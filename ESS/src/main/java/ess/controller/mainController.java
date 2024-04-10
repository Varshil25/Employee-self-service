
package ess.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import ess.dao.UserDao;
import ess.model.Role;
import ess.model.StringToRoleConverter;
import ess.model.User;
import ess.services.UserService;

@Controller
public class mainController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String UserLogin(@RequestParam String email, @RequestParam String password, @RequestParam String roleString,
			Model model, HttpSession session, HttpServletRequest request) {

		User user = userService.findByEmail(email);
		StringToRoleConverter stringToRoleConverter = new StringToRoleConverter();
		Role role = stringToRoleConverter.convert(roleString);

		if (role == null) {
			model.addAttribute("rolenull", "Enter Credential!");
			model.addAttribute("delay", 5000);
			return "index";
		}

		if (user != null && userService.validatePassword(user, password) && role != null
				&& role.equals(user.getRole())) {

			session = request.getSession();
			session.setAttribute("userId", user.getId());

			if (user.getRole() == Role.Admin) {
				model.addAttribute("title", "Admin DashBoard");
				return "admindashboard";
			} else if (user.getRole() == Role.Employee) {
				model.addAttribute("title", "Employee DashBoard");
				return "employeedashboard";
			}
		}
		model.addAttribute("error", "Invalid username, password or role");
		model.addAttribute("delay", 2000);
		return "index";
	}

}
