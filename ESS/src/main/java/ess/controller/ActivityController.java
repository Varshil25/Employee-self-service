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

import ess.model.Event;
import ess.model.Holiday;
import ess.services.EventService;
import ess.services.HolidayService;

@Controller
public class ActivityController {

	@Autowired
	private EventService eventService;

	@Autowired
	private HolidayService holidayService;

//	Admin Side
	@RequestMapping("/add-Event")
	public String addEvent(Model model) {
		model.addAttribute("title", "Add Event");
		List<Event> event = eventService.getAllEventDetails();
		model.addAttribute("event", event);
		return "addEvent_form";
	}

//	Employee Side 
	@RequestMapping("/show-Event")
	public String showEvent(Model model) {
		model.addAttribute("title", "Event List");
		List<Event> event = eventService.getAllEventDetails();
		model.addAttribute("event", event);
		return "showEvent";
	}

	@RequestMapping(value = "/event-form", method = RequestMethod.POST)
	public RedirectView addEventForm(@ModelAttribute("event") Event event,
			@RequestParam("dateString") String dateString, @RequestParam("timeString") String timeString,
			HttpServletRequest request, Model model) {
		event.setDate(dateString);
		event.setTime(timeString);
		eventService.addEvent(event);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/add-Event");
		return redirectView;
	}

	@RequestMapping("/deleteEvent/{id}")
	public RedirectView deleteEvent(@PathVariable("id") Integer id, HttpServletRequest request) {
		this.eventService.deleteEvent(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/add-Event");
		return redirectView;
	}

	@RequestMapping("/add-Holiday")
	public String addHoliday(Model model) {
		model.addAttribute("title", "Add HoliDay");
		List<Holiday> holiday = holidayService.getAllHolidayDetails();
		model.addAttribute("holiday", holiday);
		return "addholiday_form";
	}

	@RequestMapping("/show-Holiday")
	public String showHoliday(Model model) {
		model.addAttribute("title", "Holiday List");
		List<Holiday> holiday = holidayService.getAllHolidayDetails();
		model.addAttribute("holiday", holiday);
		return "showHoliday";
	}

	@RequestMapping(value = "/holiday-module", method = RequestMethod.POST)
	public RedirectView addHolidayForm(@ModelAttribute("holiday") Holiday holiday,
			@RequestParam("startDateString") String startDateString,
			@RequestParam("endDateString") String endDateString, HttpServletRequest request, Model model) {
		holiday.setStartDate(startDateString);
		holiday.setEndDate(endDateString);
		holidayService.addHoliday(holiday);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/add-Holiday");
		return redirectView;
	}

	@RequestMapping("/deleteHoliday/{id}")
	public RedirectView deleteHoliday(@PathVariable("id") Integer id, HttpServletRequest request) {
		this.holidayService.deleteHoliday(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/add-Holiday");
		return redirectView;
	}

}
