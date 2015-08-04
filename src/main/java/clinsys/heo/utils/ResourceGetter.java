package clinsys.heo.utils;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ResourceGetter {
	
	private final static Logger s_log = LoggerFactory  
		      .getLogger(ResourceGetter.class);  
	
	/**
	 * getResource - for reading class based resource files
	 * To use, store the resource in the resources folder, nested under the package name
	 * @param <T>
	 * @param clazz
	 * @param myResource
	 * @return
	 * @throws Exception
	 */
	public static <T> String getResource(Class<T> clazz, String myResource) throws Exception{
		try{
			
			String sComp = new Scanner(
					clazz.getResourceAsStream(myResource),  "UTF-8")
					.useDelimiter("\\A")
					.next();
			return sComp;
		}
		catch (Exception e){
			String sError = "cannot read class: " + clazz + " file: " + myResource + " sure it exists in the right place ?";
			s_log.error(sError);
			throw new Exception(sError);
		}
		
	}
}
