package ess.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import ess.model.LeaveApplication;
import ess.model.TourLeave;
import ess.model.Training;
import ess.model.User;
import ess.services.LeaveApplicationService;
import ess.services.UserService;

@Controller
public class LeaveController {

	@Autowired
	private LeaveApplicationService leaveApplicationService;

	@Autowired
	private UserService userService;

	@RequestMapping("/add-leave")
	public String addLeave(Model model) {
		model.addAttribute("title", "Leave Application");
		return "LeaveApplication_form";
	}

//	Take a name from Logging user not by Default.
	/*
	 * @GetMapping("/leaveApplications") public String getLeaveApplication(Model
	 * model, Principal principal) { String email = principal.getName(); User user =
	 * userService.findByEmail(email); List<LeaveApplication> leaveApplications =
	 * leaveApplicationService.findByUserId(user.getId());
	 * model.addAttribute("employeeName", user.getName());
	 * model.addAttribute("leaveApplications", leaveApplications); return
	 * "leaveApplications"; }
	 */

//	Admin Page
	@RequestMapping("/action-leave")
	public String showLeave(Model model) {
		model.addAttribute("title", "Leave Application Action");
		List<LeaveApplication> leaveApplications = leaveApplicationService.getAllLeaveApplications();
		model.addAttribute("leaveApplications", leaveApplications);
		return "showLeaveApplication_form";
	}

	@GetMapping("/approveLeave/{id}")
	public String approveLeave(@PathVariable("id") Integer id, Model model) {
		LeaveApplication leaveApplication = leaveApplicationService.getLeaveById(id);

		if (leaveApplication == null) {
			return "redirect:/error";
		}
		leaveApplication.setStatus("Approved");
		leaveApplicationService.addLeave(leaveApplication);
		return "showLeaveApplication_form";
	}

	@GetMapping("/rejectLeave/{id}")
	public String rejectLeave(@PathVariable("id") Integer id, Model model) {
		LeaveApplication leaveApplication = leaveApplicationService.getLeaveById(id);
		if (leaveApplication == null) {
			return "redirect:/error";
		}
		leaveApplication.setStatus("Rejected");
		leaveApplicationService.addLeave(leaveApplication);
		return "showLeaveApplication_form";
	}

	@GetMapping("/updateLeaveStatus/{id}")
	public RedirectView updateLeaveStatus(@PathVariable("id") Integer id, @RequestParam("status") String status,
			Model model, HttpServletRequest request) {
		LeaveApplication leaveApplication = leaveApplicationService.getLeaveById(id);
		leaveApplication.setStatus(status);
		leaveApplicationService.addLeave(leaveApplication);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/action-leave");
		return redirectView;

	}

	@RequestMapping("/list-leave")
	public String listLeave(Model model) {
		model.addAttribute("title", "List of Leave");
		List<LeaveApplication> leaveApplications = leaveApplicationService.getAllLeaveApplications();
		model.addAttribute("leaveApplications", leaveApplications);
		return "listLeave_form";
	}

	@RequestMapping(value = "/leave-module", method = RequestMethod.POST)
	public RedirectView saveLeaveForm(@ModelAttribute("leaveApplication") LeaveApplication leaveApplication,
			@RequestParam("fromDateString") String fromDateString, @RequestParam("toDateString") String toDateString,
			@RequestParam("dateString") String dateString, HttpServletRequest request, Model model) {
		leaveApplication.setFromDate(fromDateString);
		leaveApplication.setToDate(toDateString);
		leaveApplication.setDate(dateString);
		leaveApplicationService.addLeave(leaveApplication);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/list-leave");
		return redirectView;
	}

	@RequestMapping("/deleteLeave/{id}")
	public RedirectView deleteLeave(@PathVariable("id") Integer id, HttpServletRequest request) {
		this.leaveApplicationService.deleteLeave(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/add-leave");
		return redirectView;
	}

}
