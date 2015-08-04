package clinsys.heo.order_service.base_order_reader.domain_objects;

import java.util.List;

public class BaseOrder {
	private String m_name;
	private Long m_pid;
	
	private List<BaseOrderPrompt> m_prompts;
	private List<BaseOrderAttributes> m_attrs;
	private List<BaseOrderLOV> m_lov;
	
	private String m_revise_group;

	public void setPrompts(List<BaseOrderPrompt> prompt_results) {
		m_prompts = prompt_results;
	}
	
	public String getName() {
		return m_name;
	}

	public List<BaseOrderPrompt> getPrompts() {
		return m_prompts;
	}
}
