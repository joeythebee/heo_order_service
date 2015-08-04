package clinsys.heo.order_service.base_order_reader.contollers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import clinsys.heo.order_service.base_order_reader.domain_objects.BaseOrder;
import clinsys.heo.order_service.base_order_reader.domain_objects.BaseOrder_DAO;


@Controller
public class BaseOrderController {

	private static final Logger logger = LoggerFactory.getLogger(BaseOrderController.class);
	
	@Autowired
	BaseOrder_DAO my_BaseOrder_DAO;
	
	@RequestMapping(value = "/base_order/{pid}", 
					method = RequestMethod.GET,
					produces="application/json")
	@ResponseBody
	public BaseOrder getBaseOrderForPID(@PathVariable String  pid, Locale locale, Model model) throws Exception {
		logger.info("ENTER controller pid = {}", pid);
		//Long l_pid = Long.parseLong(s_pid);
		BaseOrder o = my_BaseOrder_DAO.getBaseOrderForPID(pid);
		logger.info("LEAVE controller");
		return o;
	}
		
}
