package com.example.app.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.model.Person;
import com.example.app.repositry.PersonRepositry;

@Controller
public class PersonController {

	@Autowired
	private PersonRepositry repo;

	@GetMapping("/")
	public String homePage() {

		return "home";
	}

	@GetMapping("/getPersons")
	public String getAll(Model model) {

		Iterable<Person> persons = repo.findAll();
		model.addAttribute("person", persons);

		return "persons";
	}

	@GetMapping("/getPersons/add")
	public String addPerson(@Valid @ModelAttribute("person") Person person,Model model) {

		model.addAttribute("person",person);

		return "addPerson";
	}

	@PostMapping("/getPersons/save")
	public String savePerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {

		if (result.hasErrors()) {
			return "redirect:/getPersons/add";
		}
		repo.save(person);

		return "redirect:/getPersons";
	}
	@GetMapping("/getPersons/remove/{id}")
	public String deletePerson(Model model ,@PathVariable("id") Integer id) {

		repo.deleteById(id);

		return "redirect:/getPersons";
	}
	@GetMapping("/getPersons/edite/{id}")
	public String updatePerson(@Valid @ModelAttribute("person") Optional<Person> person,Model model ,@PathVariable("id") Integer id) {
		
		person=repo.findById(id) ;
		model.addAttribute("person",person);
		return "update";
	}
	@PostMapping("/getPersons/edit")
	public String editPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {

		if (result.hasErrors()) {
			return "redirect:/getPersons/update";
		}
		repo.save(person);

		return "redirect:/getPersons";
	}
}
