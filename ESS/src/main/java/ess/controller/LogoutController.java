package ess.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ess.model.User;
import ess.services.UserService;

@Controller
public class LogoutController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/logout" , method = RequestMethod.POST)
	public String AdminLogout(HttpServletRequest request, Model model) {
		request.getSession().invalidate();
		model.addAttribute("message", "Logged out successfully!");
		List<User> u = userService.getAllUsers();
		model.addAttribute("user", u);
		model.addAttribute("delay", 2000);
		return "index";
	}
}
