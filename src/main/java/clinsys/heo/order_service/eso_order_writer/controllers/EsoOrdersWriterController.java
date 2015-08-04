package clinsys.heo.order_service.eso_order_writer.controllers;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import clinsys.heo.order_service.eso_order_writer.domain_objects.ESO_Order;
import clinsys.heo.order_service.eso_order_writer.domain_objects.ESO_Packet;
import clinsys.heo.order_service.eso_order_writer.domain_objects.ESO_Prompt;

@Controller
public class EsoOrdersWriterController {
	
	private static final Logger logger = LoggerFactory.getLogger(EsoOrdersWriterController.class);
	
	@RequestMapping(value = "/testerino", 
			method = RequestMethod.GET, 
			produces="application/javascript")
	
	@ResponseBody
	public String landingPage0(Locale locale, Model model) throws IOException, JAXBException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		logger.info("ENTER");
		return "hello";
	}
	
	@RequestMapping(value = "/gen_sample_orders", 
			method = RequestMethod.GET
			/*, 
			produces="application/javascript"*/)
	
	@ResponseBody
	public ESO_Packet gen_sample(Locale locale, Model model) throws IOException, JAXBException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		logger.info("ENTER");
		ESO_Packet esop = new ESO_Packet();
		esop.setCase_nbr("012345678912");
		esop.setMrn("012345678");
		esop.setEnv("test");
		ESO_Order eo1 = new ESO_Order();
		
		ESO_Prompt ep1 = new ESO_Prompt();
		ep1.setPrompt_name("prompt1");
		ep1.setPrompt_value("value1");
		
		ESO_Prompt ep2 = new ESO_Prompt();
		ep2.setPrompt_name("prompt2");
		ep2.setPrompt_value("value2");
		
		eo1.addPrompt(ep1).addPrompt(ep2);
		ESO_Order eo2 = new ESO_Order();
		eo2.addPrompt(ep1).addPrompt(ep2);
		esop.addOrder(eo1).addOrder(eo2);
		
		return esop;
		
		
	}
	@RequestMapping(value = "/write_eso_orders", 
			method = RequestMethod.POST, 
			produces="application/javascript")
	
	@ResponseBody
	public String writeOrders(ESO_Packet myPacket, Locale locale, Model model) throws IOException, JAXBException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		logger.info("ENTER");
		
		String sMessage = myPacket.validate();
		if (!sMessage.isEmpty()) {
			return sMessage;
		}
		
		return "hello";
	}
}
