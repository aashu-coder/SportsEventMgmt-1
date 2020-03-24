package com.cognizant.sportsEventMgmt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.sportsEventMgmt.model.Event;
import com.cognizant.sportsEventMgmt.model.Participation;
import com.cognizant.sportsEventMgmt.model.Player;
import com.cognizant.sportsEventMgmt.model.Sports;
import com.cognizant.sportsEventMgmt.model.User;
import com.cognizant.sportsEventMgmt.repository.EventRepository;
import com.cognizant.sportsEventMgmt.repository.ParticipationRepository;
import com.cognizant.sportsEventMgmt.repository.PlayerRepository;
import com.cognizant.sportsEventMgmt.repository.SportsRepository;
import com.cognizant.sportsEventMgmt.repository.UserRepository;

@Controller
public class SportsController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	SportsRepository sportsRepository;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	ParticipationRepository participationRepository;
	HttpSession session;

	@RequestMapping(value = "/indexPage", method = RequestMethod.GET)
	public String indexPage(@ModelAttribute("user") User user, Model m) {
		user = new User();
		m.addAttribute("display1", "block");
		m.addAttribute("display2", "none");
		return "index";
	}

	@RequestMapping(value = "/organizerPage", method = RequestMethod.GET)
	public String organizerPage(@ModelAttribute("user") User user) {
		user = new User();
		return "organizer";
	}

	@RequestMapping(value = "/coachPage", method = RequestMethod.GET)
	public String coachPage(@ModelAttribute("user") User user) {
		user = new User();
		return "coach";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerPage(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model m) {

		if (bindingResult.hasErrors()) {
			m.addAttribute("display1", "none");
			m.addAttribute("display2", "block");
			return "index";
		}
		try {
			userRepository.save(user);
		} catch (Exception e) {
			m.addAttribute("display1", "block");
			m.addAttribute("display2", "none");
			m.addAttribute("errMsg", "Email Id is already registered. Please Sign in.");
			return "index";
		}
		m.addAttribute("display1", "block");
		m.addAttribute("display2", "none");
		return "redirect:/indexPage";
	}

	@RequestMapping(value = "/authenticateUser", method = RequestMethod.POST)
	public String authenticateUser(@RequestParam String emailId, @RequestParam String password,
			HttpServletRequest request, Model model) {
		model.addAttribute(new User());
		User user = userRepository.authenticateUser(emailId, password);
		if (user != null) {
			session = request.getSession();
			if (user.getUserType().equalsIgnoreCase("Organizer")) {
				session.setAttribute("oid", user.getId());
				return "organizer";
			} else {
				session.setAttribute("cid", user.getId());

				return "coach";
			}
		} else {
			model.addAttribute("display1", "block");
			model.addAttribute("display2", "none");
			model.addAttribute("status", "Invalid username/password");
			return "index";
		}
	}

	@RequestMapping(value = "/requestSignOut", method = RequestMethod.GET)
	public String requestSignOut() {
		return "signOut";
	}

	@RequestMapping(value = "/addSports", method = RequestMethod.GET)
	public String addSports(@ModelAttribute("sports") Sports sports) {
		sports = new Sports();
		return "addSports";
	}

	@RequestMapping(value = "/addSportsData", method = RequestMethod.POST)
	public String addSportsData(@Valid @ModelAttribute("sports") Sports sports, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addSports";
		}
		sportsRepository.save(sports);
		return "redirect:/viewSports";
	}

	@RequestMapping(value = "/updateSports", method = RequestMethod.GET)
	public String updateSports(@ModelAttribute("sports") Sports sports, Model model, @RequestParam("id") int id) {
		sports = new Sports();
		Optional<Sports> s = sportsRepository.findById(id);

		model.addAttribute("sports", s.get());
		return "updateSports";
	}

	@RequestMapping(value = "/updateSportsData", method = RequestMethod.POST)
	public String updateSportsData(@Valid @ModelAttribute("sports") Sports sports, BindingResult bindingResult,
			@RequestParam("noOfPlayers") String nop, @RequestParam("timeOfMatch") String tom,
			@RequestParam("sId") int id) {

		if (bindingResult.hasErrors()) {
			return "updateSports";
		}
		sportsRepository.updateSports(nop, tom, id);
		return "redirect:/viewSports";
	}

	@RequestMapping(value = "/addEvent", method = RequestMethod.GET)
	public String addEvent(@ModelAttribute("event") Event event) {
		event = new Event();
		return "addEvent";
	}

	@RequestMapping(value = "/addEventData", method = RequestMethod.POST)
	public String addEventData(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addEvent";
		}
		eventRepository.save(event);
		return "redirect:/viewEvent";
	}

	@RequestMapping(value = "/updateEvent", method = RequestMethod.GET)
	public String updateEvent(@RequestParam int eId, @ModelAttribute("event") Event event, Model model) {
		event = new Event();
		Optional<Event> e = eventRepository.findById(eId);
		model.addAttribute("event", e.get());

		return "updateEvent";
	}

	@RequestMapping(value = "/updateEventData", method = RequestMethod.POST)
	public String updateEventData(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) {

		if (bindingResult.hasErrors()) {
			return "updateEvent";
		}

		String eventDate = event.getEventDate();
		String eventTime = event.getEventTime();
		String noOfSlots = event.getNoOfSlots();
		int eId = event.geteId();
		eventRepository.updatEvent(eventDate, eventTime, noOfSlots, eId);

		// String msg=event.getEventName() + " is updated please check the event page.";
		// Cookie c = new Cookie("eventname",event.getEventName() );

		// response.addCookie(c);
		return "redirect:/viewEvent";
	}

	@RequestMapping(value = "/addPlayer", method = RequestMethod.GET)
	public String addPlayer(@ModelAttribute("player") Player player) {
		player = new Player();
		return "addPlayer";
	}

	@RequestMapping(value = "/addPlayerData", method = RequestMethod.POST)
	public String addPlayerData(@Valid @ModelAttribute("player") Player player, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addPlayer";
		}
		playerRepository.save(player);
		return "redirect:/viewPlayer";
	}

	@RequestMapping(value = "/updatePlayer", method = RequestMethod.GET)
	public String updatePlayer(@RequestParam int pId, @ModelAttribute("player") Player player, Model model) {
		player = new Player();
		Optional<Player> p = playerRepository.findById(pId);
		model.addAttribute(p.get());

		return "updatePlayer";
	}

	@RequestMapping(value = "/updatePlayerData", method = RequestMethod.POST)
	public String updatePlayerData(@Valid @ModelAttribute("player") Player player, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) {

		if (bindingResult.hasErrors()) {
			return "updatePlayer";
		}
		String emailId = player.getEmailId();
		String contactNumber = player.getContactNumber();
		String age = player.getAge();
		String gender = player.getGender();
		int pId = player.getpId();
		playerRepository.updatePlayer(emailId, contactNumber, age, gender, pId);

		// playerRepository.save(player);
		return "redirect:/viewPlayer";
	}

	@RequestMapping(value = "/viewSports")
	public String viewSports(Model m) {
		List<Sports> slist = sportsRepository.findAll();
		m.addAttribute("slist", slist);
		return "viewSports";
	}

	@RequestMapping(value = "/viewEvent")
	public String viewSEvent(Model m) {
		List<Event> elist = eventRepository.findAll();
		m.addAttribute("elist", elist);
		return "viewEvent";
	}

	@RequestMapping(value = "/viewPlayer")
	public String viewPlayer(Model m) {
		List<Player> plist = playerRepository.findAll();
		m.addAttribute("plist", plist);
		return "viewPlayer";
	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword() {
		return "forgotPassword";
	}

	@RequestMapping(value = "/contactPage", method = RequestMethod.GET)
	public String contactPage() {
		return "contact";
	}

	@RequestMapping(value = "/aboutPage", method = RequestMethod.GET)
	public String aboutPage() {
		return "about";
	}

	@RequestMapping(value = "/servicesPage", method = RequestMethod.GET)
	public String servicesPage() {
		return "services";
	}

	@ModelAttribute("sportsList")
	public List<String> sportsList(Model model) {
		List<String> sportsList = new ArrayList<String>();
		sportsList = (List<String>) sportsRepository.findName();
		model.addAttribute("sportsList", sportsList);
		return sportsList;
	}

	@RequestMapping(value = "/deleteSports", method = RequestMethod.GET)
	public String deleteSports(@ModelAttribute("sports") Sports sports, BindingResult bindingResult,
			@RequestParam("sId") int id) {
		sportsRepository.deleteById(id);
		return "redirect:/viewSports";
	}

	@RequestMapping(value = "/deleteEvent", method = RequestMethod.GET)
	public String deleteEvent(@ModelAttribute("event") Event event, BindingResult bindingResult,
			@RequestParam("eId") int id) {
		eventRepository.deleteById(id);
		return "redirect:/viewEvent";
	}

	@RequestMapping(value = "/deletePlayer", method = RequestMethod.GET)
	public String deletePlayer(@ModelAttribute("player") Player player, BindingResult bindingResult,
			@RequestParam("pId") int id) {
		playerRepository.deleteById(id);
		return "redirect:/viewPlayer";
	}

	@RequestMapping(value = "/eventParticipation", method = RequestMethod.GET)
	public String eventParticipation(@ModelAttribute("participation") Participation participation) {
		participation = new Participation();

		return "eventParticipation";
	}

	@RequestMapping(value = "/viewParticipation", method = RequestMethod.GET)
	public String viewParticipation(@ModelAttribute("participation") Participation participation) {
		participation = new Participation();

		return "viewParticipation";
	}
}
