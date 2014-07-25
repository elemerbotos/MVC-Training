package com.epam.jjp.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlaneShootoutController {

	private static final Logger LOG = LoggerFactory
			.getLogger(PlaneShootoutController.class);

	@RequestMapping(value = "/planeShootout", method = RequestMethod.GET)
	public String planeShootout(@RequestParam final int year, Locale locale,
			Model model) {
		return "planeShootout";
	}
}