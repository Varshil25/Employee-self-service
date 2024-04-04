package ess.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import ess.model.Communication;
import ess.services.CommunicationService;

@Controller
public class CommunicationController {

	@Autowired
	private CommunicationService communicationService;

	@RequestMapping("/Communication-module")
	public String CommunicationDetails(Model model) {
		model.addAttribute("title", "Communication");
		List<Communication> communications = communicationService.getAllCommunicationDetails();
		model.addAttribute("communications", communications);
		return "communication_form";
	}

	@RequestMapping("/show-Communication-module")
	public String ShowCommunicationDetails(Model model) {
		model.addAttribute("title", "Communication");
		List<Communication> communications = communicationService.getAllCommunicationDetails();
		model.addAttribute("communications", communications);
		return "showcommunication_form";
	}

	@RequestMapping(value = "/com-module", method = RequestMethod.POST)
	public RedirectView addCommunicationForm(@ModelAttribute("communication") Communication communication,
			HttpServletRequest request, Model model) {

		Communication existingCommunication = communicationService.getCommunicationByEmail(communication.getEmail());
		if (existingCommunication != null) {
			// Update existing communication
			existingCommunication.setName(communication.getName());
			existingCommunication.setPosition(communication.getPosition());
			existingCommunication.setDepartment(communication.getDepartment());
			existingCommunication.setNumber(communication.getNumber());
			existingCommunication.setComment(communication.getComment());
			communicationService.updateCom(existingCommunication);
		} else {
			communicationService.addCommunicationDetails(communication);
		}

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/Communication-module");
		return redirectView;
	}

	@GetMapping("/deleteCom/{id}")
	public RedirectView deleteCom(@PathVariable("id") Integer id, HttpServletRequest request) {
		this.communicationService.deleteCommunication(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/Communication-module");
		return redirectView;
	}

	@RequestMapping("/updateCom/{id}")
	public String updateCom(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("title", "Update Communication Module");
		Communication c = this.communicationService.getComById(id);
		model.addAttribute("c", c);
		return "updateCommunicationForm";
	}
}
