package ess.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import ess.dao.UserDao;
import ess.model.Role;
import ess.model.User;
import ess.services.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserService userService;

	/*
	 * @RequestMapping("/dashboard-page") public String dashBoardpage() { return
	 * "dashboard-page"; }
	 */

	@RequestMapping("/add-employee")
	public String showAddEmployeeForm(Model model) {
		model.addAttribute("title", "Add Employee");
		return "addEmployee_form";
	}

	@RequestMapping(path = "/handle-employee", method = RequestMethod.POST)
	public RedirectView addEmployee(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("role") Role role, @RequestParam("name") String name, @RequestParam("address") String address,
			@RequestParam("position") String position, @RequestParam("gender") String gender,
			@RequestParam("bloodGroup") String bloodGroup, @RequestParam("dob") String dobString,
			@RequestParam("number") String number, HttpServletRequest request, Model model) {

		User user = null;
		if (id != null) {
			user = userService.getUserById(id);
			if (user == null) {
				model.addAttribute("errorMessage", "User not found.");
				return new RedirectView(request.getContextPath() + "/list-employee");
			}
		} else {
			user = new User();
		}

		User existingUserWithEmail = userService.findByEmail(email);
		if (existingUserWithEmail != null && !existingUserWithEmail.getId().equals(id)) {
			model.addAttribute("errorMessage", "The email is already in use. Please choose a different email.");
			return new RedirectView(request.getContextPath() + "/list-employee?id=" + id);
		}

		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		user.setName(name);
		user.setAddress(address);
		user.setPosition(position);
		user.setGender(gender);
		user.setBloodGroup(bloodGroup);
		// Convert dob String to Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dob = new Date(sdf.parse(dobString).getTime());
			user.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
			// Handle parsing exception
		}
		user.setNumber(number);

		if (id == null) {
			userService.addUser(user);
		} else {
			userService.updateUser(user);
		}
		model.addAttribute("addemployeeMessage", "Employee Added Successfully!");
		model.addAttribute("delay", 2000);
		model.addAttribute("title", "Add Employee DashBoard");
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/list-employee");
		return redirectView;
	}

	@RequestMapping("/list-employee")
	public String listOfEmployee(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "employeeListForm";
	}

	@RequestMapping("/delete/{id}")
	public RedirectView deleteUser(@PathVariable("id") int id, HttpServletRequest request) {
		this.userService.deleteUser(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/list-employee");
		return redirectView;
	}

	@RequestMapping("/update/{id}")
	public String updateForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("title", "Update Product");
		User user = this.userService.getUserById(id);
		model.addAttribute("user", user);
		return "update_form";
	}

}
