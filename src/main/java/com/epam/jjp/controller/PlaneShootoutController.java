package com.epam.jjp.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.epam.jjp.domain.City;
import com.epam.jjp.domain.Plane;
import com.epam.jjp.domain.Route;
import com.epam.jjp.service.CityService;
import com.epam.jjp.service.GameService;
import com.epam.jjp.service.PlaneService;
import com.epam.jjp.service.RouteService;

@Controller
@Scope("session")
@SessionAttributes("routeForm")
public class PlaneShootoutController {

	@Autowired
	private PlaneService service;
	@Autowired
	private CityService cService;
	@Autowired
	private RouteService rservice;
	@Autowired
	private GameService gservice;

	private static final Logger LOG = LoggerFactory
			.getLogger(PlaneShootoutController.class);

	@RequestMapping(value = "/planeShootout", method = RequestMethod.GET)
	public String planeShootout(@RequestParam final int year, Locale locale,
			Model model) {
		return "planeShootout";
	}

	@RequestMapping(value = "/planeShoutout/planes", method = RequestMethod.GET)
	public String planes(final Locale locale, final Model model) {

		loadParams(model);
		return "flightLister";
	}

	private void loadParams(final Model model) {
		model.addAttribute("routes", rservice.getRoutes());
		model.addAttribute("cities", cService.getCities());
		model.addAttribute("planes", service.getPlanes());
	}

	@RequestMapping(value = "/planeShoutout/planes/add", method = RequestMethod.POST)
	public String addPlane(
			@ModelAttribute("planeForm") final PlaneForm planeForm,
			@RequestParam("name") final String name, final Locale locale,
			final Model model) {
		Plane plane = new Plane();
		plane.setName(name);
		plane.setId(planeForm.getId());
		plane.setFuel(planeForm.getFuel());
		service.addPlane(plane);

		loadParams(model);
		return "flightLister";
	}

	@RequestMapping(value = "/planeShoutout/planes/addCity", method = RequestMethod.POST)
	public String addCity(@ModelAttribute("cityForm") final CityForm cityForm,
			final Locale locale, final Model model) {
		City city = new City();
		city.setName(cityForm.getName());
		System.out.println(cityForm.getName());
		city.setTimeZoneCorrection(cityForm.getTimeZone());
		cService.addCity(city);


		loadParams(model);
		return "flightLister";
	}

	@RequestMapping(value = "/planeShoutout/planes/addRoute", method = RequestMethod.POST)
	public String addRoute(final RouteForm routeForm, final Locale locale,
			final Model model) {

		loadParams(model);
		return "addVias";
	}

	@RequestMapping(value = "/planeShoutout/planes/addVia", method = RequestMethod.POST)
	public String viaCity(final RouteForm routeForm, final Locale locale,
			final Model model) {

		loadParams(model);
		return "addVias";
	}

	@RequestMapping(value = "/planeShoutout/planes/addVia", method = RequestMethod.GET, params = "step=done")
	public String finishRoute(final RouteForm routeForm, final Locale locale,
			final Model model, final SessionStatus status) {

		Route route = new Route();
		for(String via : routeForm.getVias()) {
			route.addVia(cService.getCityByName(via));
		}
		
		route.setFrom(cService.getCityByName(routeForm.getFrom()));
		route.setTo(cService.getCityByName(routeForm.getTo()));
		route.setLenght(routeForm.getLength());
		route.setFuelNecessary(routeForm.getFuel());
		status.setComplete();
		rservice.addRoute(route);
		loadParams(model);
		return "flightLister";
	}
	
	 @RequestMapping(value = "/planes/playGame", method = RequestMethod.GET)
	 public String playGame() {
		 gservice.gameStart();
		 return "redirect:/planeControlling";
	 }
	 
	 @RequestMapping(value = "/planeControlling/addAnotherPlane", method = RequestMethod.POST)
	 public String addNewPlane(final String planeId, final Locale locale, final Model model) {
		 gservice.addPlane(service.getPlaneById(planeId));
		 return "redirect:/planeControlling";
	 }
	 
	 @RequestMapping(value = "/planeControlling/addAnotherRoute", method = RequestMethod.POST)
	 public String addNewRoute(final String routeId, final Locale locale, final Model model) {
		 System.out.println("routeID: " + routeId);
		 gservice.addRoute(rservice.getRouteById(routeId));
		 return "redirect:/planeControlling";
	 }
	 
	 @RequestMapping(value = "/planeControlling", method = RequestMethod.GET) 
	 public String plainPlaneControlling(final Locale locale, final Model model) {
		 model.addAttribute("flights", gservice.getFlights());
		 loadParams(model);
		 return "planeControlling";
	 }
	 
	 
}