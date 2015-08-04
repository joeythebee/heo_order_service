package clinsys.heo.order_service.eso_order_writer.domain_objects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

public class ESO_Packet {
	/*
	mrn : "my_mrn",
    case_nbr : "my_case",
    user_id : "myuser",
    xml_as_string : cart_string
    */
	private String m_mrn;
	private String m_case_nbr;
	private String m_userID;
	
	private String m_env;
	private String m_fromwiz;
	private String m_token;
	
	//Do away with this ...
	//private String m_xml_as_string;
	private String m_error_message;
	
	//In favor of this..	
	private List<ESO_Order> m_order_list = new ArrayList<ESO_Order>();
	
	public String getMrn() {
		return m_mrn;
	}
	public void setMrn(String m_mrn) {
		this.m_mrn = m_mrn;
	}
	public String getCase_nbr() {
		return m_case_nbr;
	}
	public void setCase_nbr(String m_case_nbr) {
		this.m_case_nbr = m_case_nbr;
	}
	public String getUserID() {
		return m_userID;
	}
	public void setUserID(String m_user_id) {
		this.m_userID = m_user_id;
	}
	/*
	public String getXml_as_string() {
		return m_xml_as_string;
	}
	public void setXml_as_string(String m_xml_as_string) {
		this.m_xml_as_string = m_xml_as_string;
	}
	*/
	public List<ESO_Order> getESO_Orders(){
		return this.m_order_list;
	}
	
	public void setOrderList(List<ESO_Order> m_order_list) {
		this.m_order_list = m_order_list;
	}
	
	public void setEnv(String sIn) {
		m_env = sIn;
	}
	public String getEnv() {
		return m_env;
	}
	public void setFromwiz(String s) {
		this.m_fromwiz = s;
	}
	
	public String getToken() {
		return this.m_token;
	}
	
	public void setToken(String s) {
		this.m_token = s;
	}
	
	public String validate() {
		String message = "";
		//Can haz token ?
		if (this.m_token.isEmpty() ) {
			message = "No token - No service";
		}
		
		return message;
	}
	public ESO_Packet addOrder(ESO_Order eo1) {
		this.m_order_list.add(eo1);
		return this;
	}
}
