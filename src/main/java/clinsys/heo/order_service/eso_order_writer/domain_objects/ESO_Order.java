package clinsys.heo.order_service.eso_order_writer.domain_objects;

import java.util.ArrayList;
import java.util.List;

public class ESO_Order {
	
	
	private List<ESO_Prompt> m_prompt_list = new ArrayList<ESO_Prompt>();

	public List<ESO_Prompt> getPrompt_list() {
		return m_prompt_list;
	}

	public void setPrompt_list(List<ESO_Prompt> m_prompt_list) {
		this.m_prompt_list = m_prompt_list;
	}

	public ESO_Order addPrompt(ESO_Prompt ep1) {
		m_prompt_list.add(ep1);
		return this;
	}
	
	
}
