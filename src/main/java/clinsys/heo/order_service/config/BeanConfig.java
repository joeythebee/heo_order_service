package clinsys.heo.order_service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import clinsys.heo.order_service.base_order_reader.domain_objects.BaseOrder_DAO;

@Configuration
public class BeanConfig {

	private static final Logger logger = LoggerFactory.getLogger(BeanConfig.class);
	  
	 @Bean(name="heo_DataSource")
	    public org.apache.commons.dbcp.BasicDataSource getDataSource(){
		 	logger.info("ENTER");
		 	//Use dbcp for poiling 
		 	org.apache.commons.dbcp.BasicDataSource ds = new org.apache.commons.dbcp.BasicDataSource();
		 	//org.springframework.jdbc.datasource.DriverManagerDataSource ds = new org.springframework.jdbc.datasource.DriverManagerDataSource();
	    	ds.setDriverClassName("oracle.jdbc.OracleDriver");
	    	
		 	String sConnect = "(DESCRIPTION= (ADDRESS=(PROTOCOL=TCP)(HOST=hci05lt-racv.mc.vanderbilt.edu)(PORT=1521)"
	    			+ ")(CONNECT_DATA=(SERVER=dedicated)(SID = TEST1)))";
		 	
		 	//sConnect = "TEST1.OAS.VANDERBILT";
	    	ds.setUrl("jdbc:oracle:thin:@"+sConnect);
	    	ds.setUsername("ccuser");
	    	ds.setPassword("bueno");
	    	return ds;
	    }
	 
	 @Bean(name="heo_NamedParameterJdbcTemplate")
	    public NamedParameterJdbcTemplate getJDBCTemplate(){
	    	logger.info("ENTER");
		 	NamedParameterJdbcTemplate jt = new NamedParameterJdbcTemplate(getDataSource());
	    	return jt;
	    }
	 
	 //DAO goes here...
	
	 @Bean(name="heo_dao")
	 BaseOrder_DAO getHEO_TEST_DAO(){
		BaseOrder_DAO hd = new BaseOrder_DAO();
	    hd.setJdbcTemplate(getJDBCTemplate());
	    return hd;
	 }
	 
}
