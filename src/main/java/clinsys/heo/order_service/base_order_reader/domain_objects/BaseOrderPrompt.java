package clinsys.heo.order_service.base_order_reader.domain_objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import clinsys.heo.order_service.config.BeanConfig;

public class BaseOrderPrompt {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseOrderPrompt.class);


	private long m_PROMPT_SEQ;
	private long m_DISP_SEQ;
	private String m_DFLT_RESPONSE;
	private String m_MAND_FL;
	private long m_MIN_RESPONSE;
	private long m_MAX_RESPONSE;
	private String m_NAME_MODIFIER;
	private String m_IS_CLINICALLY_RELEVANT;
	private String m_PROMPT_TEXT;
	private String m_DFLT_UNIT;
	private String m_CURRENT_VALUE;
	private String m_CURRENT_UNIT;
	private long m_RECOMMENDED_VAL_SEQ;
	private long m_ALLOWED_VAL_SEQ;
	private long m_ALLOWED_UNIT_SEQ;
	private String m_LIMIT_TO_AVAILABLE;
	private String m_VISIBLE_FL;
	private String m_READ_ONLY_HEO;
	private String m_DISPLAY_ON_NEW_LINE;

	
	public BaseOrderPrompt(long long1, long long2, int int1, String string, String string2, int int2, int int3,
			String string3, String string4, String string5, String string6, String string7, String string8, long long3,
			long long4, long long5, String string9, String string10, String string11, String string12) {
		
		this.m_ORDER_ITEM_SEQ = long1;
		this.m_PROMPT_SEQ = long2;
		this.m_DISP_SEQ = int1;
		this.m_DFLT_RESPONSE = string;
		this.m_MAND_FL = string;
		this.m_MIN_RESPONSE = int2;
		this.m_MAX_RESPONSE = int3;
		this.m_NAME_MODIFIER = string3;
		this.m_IS_CLINICALLY_RELEVANT = string4;
		this.m_PROMPT_TEXT = string5;
		this.m_DFLT_UNIT = string6;
		this.m_CURRENT_VALUE = string7;
		this.m_CURRENT_UNIT = string8;
		this.m_RECOMMENDED_VAL_SEQ = long3;
		this.m_ALLOWED_VAL_SEQ = long4;
		this.m_ALLOWED_UNIT_SEQ = long5;
		this.m_LIMIT_TO_AVAILABLE = string9;
		this.m_VISIBLE_FL = string10;
		this.m_READ_ONLY_HEO = string11;
		this.m_DISPLAY_ON_NEW_LINE = string12;
		
	}
	
	private long m_ORDER_ITEM_SEQ;
	public long getORDER_ITEM_SEQ() {
		return m_ORDER_ITEM_SEQ;
	}
	public void setORDER_ITEM_SEQ(long m_ORDER_ITEM_SEQ) {
		this.m_ORDER_ITEM_SEQ = m_ORDER_ITEM_SEQ;
	}
	public long getPROMPT_SEQ() {
		return m_PROMPT_SEQ;
	}
	public void setPROMPT_SEQ(long m_PROMPT_SEQ) {
		this.m_PROMPT_SEQ = m_PROMPT_SEQ;
	}
	public long getDISP_SEQ() {
		return m_DISP_SEQ;
	}
	public void setDISP_SEQ(long m_DISP_SEQ) {
		this.m_DISP_SEQ = m_DISP_SEQ;
	}
	public String getDFLT_RESPONSE() {
		return m_DFLT_RESPONSE;
	}
	public void setDFLT_RESPONSE(String m_DFLT_RESPONSE) {
		this.m_DFLT_RESPONSE = m_DFLT_RESPONSE;
	}
	public String getMAND_FL() {
		return m_MAND_FL;
	}
	public void setMAND_FL(String m_MAND_FL) {
		this.m_MAND_FL = m_MAND_FL;
	}
	public long getMIN_RESPONSE() {
		return m_MIN_RESPONSE;
	}
	public void setMIN_RESPONSE(long m_MIN_RESPONSE) {
		this.m_MIN_RESPONSE = m_MIN_RESPONSE;
	}
	public long getMAX_RESPONSE() {
		return m_MAX_RESPONSE;
	}
	public void setMAX_RESPONSE(long m_MAX_RESPONSE) {
		this.m_MAX_RESPONSE = m_MAX_RESPONSE;
	}
	public String getNAME_MODIFIER() {
		return m_NAME_MODIFIER;
	}
	public void setNAME_MODIFIER(String m_NAME_MODIFIER) {
		this.m_NAME_MODIFIER = m_NAME_MODIFIER;
	}
	public String getIS_CLINICALLY_RELEVANT() {
		return m_IS_CLINICALLY_RELEVANT;
	}
	public void setIS_CLINICALLY_RELEVANT(String m_IS_CLINICALLY_RELEVANT) {
		this.m_IS_CLINICALLY_RELEVANT = m_IS_CLINICALLY_RELEVANT;
	}
	public String getPROMPT_TEXT() {
		return m_PROMPT_TEXT;
	}
	public void setPROMPT_TEXT(String m_PROMPT_TEXT) {
		this.m_PROMPT_TEXT = m_PROMPT_TEXT;
	}
	public String getDFLT_UNIT() {
		return m_DFLT_UNIT;
	}
	public void setDFLT_UNIT(String m_DFLT_UNIT) {
		this.m_DFLT_UNIT = m_DFLT_UNIT;
	}
	public String getCURRENT_VALUE() {
		return m_CURRENT_VALUE;
	}
	public void setCURRENT_VALUE(String m_CURRENT_VALUE) {
		this.m_CURRENT_VALUE = m_CURRENT_VALUE;
	}
	public String getCURRENT_UNIT() {
		return m_CURRENT_UNIT;
	}
	public void setCURRENT_UNIT(String m_CURRENT_UNIT) {
		this.m_CURRENT_UNIT = m_CURRENT_UNIT;
	}
	public long getRECOMMENDED_VAL_SEQ() {
		return m_RECOMMENDED_VAL_SEQ;
	}
	public void setRECOMMENDED_VAL_SEQ(long m_RECOMMENDED_VAL_SEQ) {
		this.m_RECOMMENDED_VAL_SEQ = m_RECOMMENDED_VAL_SEQ;
	}
	public long getALLOWED_VAL_SEQ() {
		return m_ALLOWED_VAL_SEQ;
	}
	public void setALLOWED_VAL_SEQ(long m_ALLOWED_VAL_SEQ) {
		this.m_ALLOWED_VAL_SEQ = m_ALLOWED_VAL_SEQ;
	}
	public long getALLOWED_UNIT_SEQ() {
		return m_ALLOWED_UNIT_SEQ;
	}
	public void setALLOWED_UNIT_SEQ(long m_ALLOWED_UNIT_SEQ) {
		this.m_ALLOWED_UNIT_SEQ = m_ALLOWED_UNIT_SEQ;
	}
	public String getLIMIT_TO_AVAILABLE() {
		return m_LIMIT_TO_AVAILABLE;
	}
	public void setLIMIT_TO_AVAILABLE(String m_LIMIT_TO_AVAILABLE) {
		this.m_LIMIT_TO_AVAILABLE = m_LIMIT_TO_AVAILABLE;
	}
	public String getVISIBLE_FL() {
		return m_VISIBLE_FL;
	}
	public void setVISIBLE_FL(String m_VISIBLE_FL) {
		this.m_VISIBLE_FL = m_VISIBLE_FL;
	}
	public String getREAD_ONLY_HEO() {
		return m_READ_ONLY_HEO;
	}
	public void setREAD_ONLY_HEO(String m_READ_ONLY_HEO) {
		this.m_READ_ONLY_HEO = m_READ_ONLY_HEO;
	}
	public String getDISPLAY_ON_NEW_LINE() {
		return m_DISPLAY_ON_NEW_LINE;
	}
	public void setDISPLAY_ON_NEW_LINE(String m_DISPLAY_ON_NEW_LINE) {
		this.m_DISPLAY_ON_NEW_LINE = m_DISPLAY_ON_NEW_LINE;
	}
	
}
