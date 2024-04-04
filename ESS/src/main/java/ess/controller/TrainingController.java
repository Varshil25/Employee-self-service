package ess.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import ess.model.Training;
import ess.services.TrainingService;

@Controller
public class TrainingController {

	@Autowired
	private TrainingService trainingService;

	@RequestMapping("/add-training")
	public String addTraining(Model model) {
		model.addAttribute("title", "Add Training Module");
		return "addTraining_Form";
	}

	@RequestMapping("/list-training")
	public String Training(Model model) {
		List<Training> training = trainingService.getAllTrainingDetails();
		model.addAttribute("title", "List of Training Module");
		model.addAttribute("training", training);
		return "listTraining_Form";
	}

	@RequestMapping("/show-Training")
	public String showTraining(Model model) {
		List<Training> training = trainingService.getAllTrainingDetails();
		model.addAttribute("title", "List of Training Module");
		model.addAttribute("training", training);
		return "showTraining";
	}

	@RequestMapping(value = "/training-module", method = RequestMethod.POST)
	public RedirectView saveTrainingForm(@ModelAttribute("training") Training training,
			@RequestParam("startDate") String startDateString, @RequestParam("endDate") String endDateString,
			HttpServletRequest request, Model model) {
		training.setStartDate(startDateString);
		training.setEndDate(endDateString);
		trainingService.addTraining(training);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/list-training");
		return redirectView;
	}

	@RequestMapping("/deleteTraining/{id}")
	public RedirectView deleteTraining(@PathVariable("id") int id, HttpServletRequest request) {
		this.trainingService.deleteTraining(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/list-training");
		return redirectView;
	}

	@RequestMapping("/updateTraining/{id}")
	public String updateForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("title", "Update Training Module");
		Training tr = this.trainingService.getTrainingById(id);
		model.addAttribute("tr", tr);
		return "updateTrainingForm";
	}
}
