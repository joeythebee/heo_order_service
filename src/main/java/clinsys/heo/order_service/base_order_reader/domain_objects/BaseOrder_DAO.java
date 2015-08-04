package clinsys.heo.order_service.base_order_reader.domain_objects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import clinsys.heo.utils.ResourceGetter;

public class BaseOrder_DAO {

	private static final Logger log = LoggerFactory.getLogger(BaseOrder_DAO.class);
	
	//Could be autowired...curently injected via BeanConfig
	NamedParameterJdbcTemplate m_jdbcTemplate;
	
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		m_jdbcTemplate = jdbcTemplate;
	}
	
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return m_jdbcTemplate;
	}
	
	private String getSQL_O_ITEM_PROMPTS_FOR_PID() throws Exception {
		String sFILE = "o_item_prompt.sql";
		String sSQL = ResourceGetter.getResource(this.getClass(), sFILE);
		return sSQL;
	}
	
	private String getSQL_O_ITEM_ATTRS_FOR_PID() throws Exception {
		String sFILE = "o_item_attributes.sql";
		String sSQL = ResourceGetter.getResource(this.getClass(), sFILE);
		return sSQL;
	}

	private String getSQL_O_REVISE_GROUP_FOR_PID() throws Exception {
		String sFILE = "o_item_revise_group.sql";
		String sSQL = ResourceGetter.getResource(this.getClass(), sFILE);
		return sSQL;
	}
	
	private String getSQL_O_LOV_FOR_PID() throws Exception {
		String sFILE = "o_lov_for_pid.sql";
		String sSQL = ResourceGetter.getResource(this.getClass(), sFILE);
		return sSQL;
	}
	
	public BaseOrder getBaseOrderForPID(String l_pid) throws Exception{
		log.info("ENTER");
		BaseOrder bo = new BaseOrder();
		
		String sSQL = getSQL_O_ITEM_PROMPTS_FOR_PID();
		
		List<BaseOrderPrompt> prompt_results = getJdbcTemplate().query(sSQL,
				Collections.singletonMap("pid", l_pid),
				new RowMapper<BaseOrderPrompt>() {
					public BaseOrderPrompt mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new BaseOrderPrompt(
								rs.getLong("ORDER_ITEM_SEQ"),
								rs.getLong("PROMPT_SEQ"),
								rs.getInt("DISP_SEQ"),
								rs.getString("DFLT_RESPONSE"),
								rs.getString("MAND_FL"),
								rs.getInt("MIN_RESPONSE"),
								rs.getInt("MAX_RESPONSE"),
								rs.getString("NAME_MODIFIER"),
								rs.getString("IS_CLINICALLY_RELEVANT"),
								rs.getString("PROMPT_TEXT"),
								rs.getString("DFLT_UNIT"),
								rs.getString("CURRENT_VALUE"),
								rs.getString("CURRENT_UNIT"),
								rs.getLong("RECOMMENDED_VAL_SEQ"),
								rs.getLong("ALLOWED_VAL_SEQ"),
								rs.getLong("ALLOWED_UNIT_SEQ"),
								rs.getString("LIMIT_TO_AVAILABLE"),
								rs.getString("VISIBLE_FL"),
								rs.getString("READ_ONLY_HEO"),
								rs.getString("DISPLAY_ON_NEW_LINE")
								);
					}
				}
		);
		
		bo.setPrompts(prompt_results);
		
		
		//We will only be returning the FIRST one
		/*
		List<HEO_Active_Staff> results = getJdbcTemplate().query(sSQL,
				Collections.singletonMap("racfids", lRacf),
				new RowMapper<HEO_Active_Staff>(){
					@Override
					public HEO_Active_Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new HEO_Active_Staff(
								rs.getInt("staff_seq"),
								rs.getString("access_id"),
								rs.getString("staff_name"),
								rs.getDate("inactive_dt")
								);
					}
		});
		*/
		log.info("LEAVE");
		return bo;
	}
	
}
