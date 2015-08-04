package clinsys.heo.order_service.old_rest_flow;

import java.sql.Connection;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;
import java.util.ArrayList;

import java.io.StringWriter;
import java.lang.Class;
import java.lang.StringBuffer;
import java.lang.reflect.Method;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.SortedMap;
import java.util.TreeMap;

public final class heo_order_info_source {

  
  protected final static Log log = LogFactory.getLog(heo_order_info_source.class);
  
  public heo_order_info_source() {
  }

  public ArrayList<HashMap<String, Object>> resultSetToArrayList(ResultSet rs) throws Exception{
          ResultSetMetaData rsmd = rs.getMetaData();
          int columnCount = rsmd.getColumnCount();

          ArrayList<HashMap<String, Object>> results = new ArrayList<HashMap<String, Object>>();
          HashMap<String, Object> result;

          while (rs.next()){
              result = new HashMap<String, Object>();
              for (int i = 1; i < columnCount + 1; i++ ) {
                  String name = rsmd.getColumnName(i);
                  result.put(name.toLowerCase(),rs.getString(i));
                  
              }
              results.add(result);
          }
          return results;
  }

  public HashMap<String, HashMap<String, Object>> 
    resultSetToMap(String sKeyColumn, ResultSet rs) throws Exception{
          ResultSetMetaData rsmd = rs.getMetaData();
          int columnCount = rsmd.getColumnCount();

          //ArrayList<HashMap<String, String>> results = new ArrayList<HashMap<String, String>>();
          HashMap<String, HashMap<String, Object>> results = new HashMap<String,HashMap<String, Object>>();
          
          HashMap<String, Object> result;
          String thisKey = "";
          while (rs.next()){
              thisKey = "";
              result = new HashMap<String, Object>();
              
              for (int i = 1; i < columnCount + 1; i++ ) {
                  String name = rsmd.getColumnName(i);
                  if (name.toLowerCase().equals(sKeyColumn.toLowerCase()))
                    thisKey = rs.getString(i);
                    
                  result.put(name.toLowerCase(),rs.getString(i));
                  
              }
              results.put(thisKey, result);
          }
          return results;
  }

  public HashMap<String,Object> get_json(
					       String sENV,
					       String sPID) throws Exception {

    log.debug("ENTER");
    
    Connection c = null;
    
    HashSet<HashMap<String, Object>> results = new HashSet<HashMap<String, Object>>();
    
    HashMap<String, Object> result = new HashMap<String, Object>();
    HashMap<String, ArrayList> dictMap = new HashMap<String, ArrayList>();
    try {

      log.info("pid = "+ sPID);

      //int nPID = Integer.parseInt(sPID);

      String sDBLookup="jdbc/heo_info";
      //sDBLookup = "jdbc/heo_info";
      //if (nPID < 31000) {
      //    sDBLookup = "jdbc/heo_content";
      //}
      //JNDI style

      String sLookup = sDBLookup; 
      InitialContext ic = new InitialContext();
      DataSource ds = (DataSource) ic.lookup(sLookup);
      c=ds.getConnection(); 

      Statement stmt = c.createStatement();

      String s_sql = "";
      /*
      s_sql = "select * from O_ITEM_PROMPT oip, O_PROMPT_ATTRIBUTES opa ";
      s_sql += " where oip.order_item_seq = opa.order_item_seq ";
      s_sql += " and  opa.o_outline_seq=0 ";
      s_sql += " and oip.prompt_seq = opa.prompt_seq ";
      s_sql += " and oip.order_item_seq = " + sPID + " order by oip.disp_seq asc";
      */

      s_sql = "select * from O_ITEM_PROMPT oip ";
      s_sql += " where oip.order_item_seq = " + sPID + " order by oip.disp_seq asc";
      

      result = new HashMap<String, Object>();
      result.put("sql_1",s_sql);
      //results.add(result);
      
      //return results;
      //switch to log
      System.out.println("sql = " +s_sql);
      log.info("sql= "+s_sql);
      ResultSet rs = stmt.executeQuery(s_sql);
      result.put("heo_o_item_prompt",resultSetToArrayList(rs)); // want only the first

      s_sql = "select * from O_ITEM_ATTRIBUTES ";
      s_sql += " where o_outline_seq=0 and order_item_seq = " + sPID + " order by attribute_name ";

      result.put("sql_2",s_sql);
      ResultSet rsa = stmt.executeQuery(s_sql);
      result.put("heo_o_item_attributes",resultSetToArrayList(rsa)); // want only the first
      
      s_sql = "select attribute_value from O_ITEM_ATTRIBUTES where o_outline_seq=0 and attribute_name = 'OrdScreen' and order_item_seq = " + sPID;
      result.put("sql_3",s_sql);
      ResultSet rsrg = stmt.executeQuery(s_sql);
      String sReviseGroup  = "";
      while (rsrg.next()){
        sReviseGroup  = rsrg.getString(1);
      }
      result.put("revise_group",sReviseGroup); // want only the first

      //Get Allowed Values and Recommended Values
      s_sql = "Select * From O_Lov Where List_Of_Values_Seq In "
        + "(Select Allowed_Val_Seq From O_Item_Prompt Where Order_Item_Seq=" + sPID  
        + "union select recommended_val_seq from O_item_prompt where Order_item_seq = " + sPID + ")"
        + " order by list_of_values_seq, disp_seq" ;

      result.put("sql_4", s_sql);
      ResultSet rsValues = stmt.executeQuery(s_sql);
      
      //Store intermediate
      ArrayList<HashMap<String, Object>> myLOVList = resultSetToArrayList(rsValues);
      
      HashMap<String, Object> myLOVMap = new HashMap<String, Object>();

      for (HashMap<String, Object> thisLOV: myLOVList){
        String sLOVKey = (String) thisLOV.get("list_of_values_seq");
        Object myLOV = (SortedMap<String, Object>) myLOVMap.get(sLOVKey);
        //HashMap<String, Object> lovHashMap = null;  //global seq, disp_seq, value
        SortedMap<String, Object> lovHashMap = null; // = new TreeMap<String, Object>();
    
        if (myLOV == null){
          lovHashMap = new TreeMap<String, Object>();//new HashMap<String, Object>();
          myLOVMap.put(sLOVKey, lovHashMap);
        }
        if (lovHashMap == null){
          lovHashMap = (SortedMap<String, Object>) myLOVMap.get(sLOVKey);
        }
        HashMap<String, Object> thisLOVItem = new HashMap<String, Object>();
        
        thisLOVItem.put("o_lov_seq",thisLOV.get("o_lov_seq"));
        thisLOVItem.put("disp_seq",thisLOV.get("disp_seq"));
        thisLOVItem.put("value_field",thisLOV.get("value_field"));

        //Use disp seq as key
        lovHashMap.put((String) thisLOV.get("disp_seq"), thisLOVItem);

      }

      //Now Consolidate !
      HashMap<String, Object> myValues = new HashMap<String, Object>();
      for (String sKey : myLOVMap.keySet()){
        ArrayList<String> myItems = new ArrayList<String>();
        SortedMap<String, Object> mySortedValues = (SortedMap<String, Object>) myLOVMap.get(sKey);
        for (String sInnerKey : mySortedValues.keySet()){
           HashMap<String, Object> o = (HashMap<String, Object>) mySortedValues.get(sInnerKey);
           String thisValue = (String) o.get("value_field");
           myItems.add(thisValue);
        }
        myValues.put(sKey,myItems);
      }

      result.put("list_of_values", myValues);
      

      stmt.close(); // should release to the pool
      
      //results.add(result);
      
    } //END TRY
    catch (Exception e) {
      e.printStackTrace();
      throw e;
      
    }
    finally {
      if (c !=null) 
          c.close();
    }
   
    return result;
  }

} // END CLASS


