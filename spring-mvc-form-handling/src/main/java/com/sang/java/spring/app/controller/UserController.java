package com.sang.java.spring.app.controller;

import com.sang.java.spring.app.user.DataUtils;
import com.sang.java.spring.app.user.model.User;
import com.sang.java.spring.app.user.service.UserService;
import com.sang.java.spring.app.user.validator.UserFormValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserFormValidator formValidator;

	// register the form validator to this controller
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// this will override the jsr303 validator
		// binder.setValidator(formValidator);

		// this support both spring validator and jsr303 validator
		binder.addValidators(formValidator);
	}

	@GetMapping(value = { "/", "/users" })
	public String listAllUsers(Model model) {
		logger.debug("listUsers()...");
		model.addAttribute("users", userService.findAll());
		return "list";

	}

	// @Valid from jsr 303 and @Validate from the Spring.
	// save or update user
	// 1. @ModelAttribute bind form value
	// 2. @Valid form validator
	// 3. RedirectAttributes for flash value
	@PostMapping("/users")
	public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user, BindingResult bindingResult,
			Model model, final RedirectAttributes redirectAttributes) {

		// @InitBinder or run the form validator manually like this
		// formValidator.validate(user, bindingResult);

		logger.debug("saveOrUpdateUser() : {}", user);

		if (bindingResult.hasErrors()) {
			populateDefaultCheckBoxesAndRadios(model); // repopulate for items like checkboxes, radios and etc
			return "userform";
		} else {

			// Add message to flash scope
			redirectAttributes.addFlashAttribute("alert", "success");
			if (user.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}

			userService.saveOrUpdate(user);

			// POST/REDIRECT/GET
			return "redirect:/users/" + user.getId();

			// POST/FORWARD/GET
			// return "user/list";

		}

	}

	// show user
	@GetMapping("/users/{id}")
	public String showUser(@PathVariable("id") int userId, Model model) {

		logger.debug("showUser() userId: {}", userId);

		User user = userService.findById(userId);
		if (user == null) {
			model.addAttribute("alert", "danger");
			model.addAttribute("msg", "User not found!");
		}
		model.addAttribute("user", user);

		return "show";

	}

	// show add user form
	@GetMapping("/users/add")
	public String showAddUserForm(Model model) {

		logger.debug("showAddUserForm()");

		// init values for user form
		User user = new User();
		user.setSex("M");
		user.setCountry("MY");
		user.setFramework(new ArrayList<String>(Arrays.asList("Spring", "Struts")));
		user.setSkill(new ArrayList<String>(Arrays.asList("Spring", "Struts", "Hibernate")));
		model.addAttribute("userForm", user);

		populateDefaultCheckBoxesAndRadios(model);

		return "userform";

	}

	// show update form
	@GetMapping("/users/{id}/update")
	public String showUpdateUserForm(@PathVariable("id") int id, Model model) {

		logger.debug("showUpdateUserForm() : {}", id);

		model.addAttribute("userForm", userService.findById(id));

		populateDefaultCheckBoxesAndRadios(model);

		return "userform";

	}

	@PostMapping("/users/{id}/delete")
	public String deleteUser(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

		logger.debug("deleteUser() : {}", id);

		userService.delete(id);

		redirectAttributes.addFlashAttribute("alert", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/";

	}

	private void populateDefaultCheckBoxesAndRadios(Model model) {
		model.addAttribute("frameworkList", DataUtils.FRAMEWORKS_LIST);
		model.addAttribute("javaSkillList", DataUtils.SKILLS);
		model.addAttribute("numberList", DataUtils.NUMBERS);
		model.addAttribute("countryList", DataUtils.COUNTRY);
	}
}