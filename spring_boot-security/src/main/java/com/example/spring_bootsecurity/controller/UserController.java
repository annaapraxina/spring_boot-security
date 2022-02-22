package com.example.spring_bootsecurity.controller;

import com.example.spring_bootsecurity.model.Role;
import com.example.spring_bootsecurity.model.User;
import com.example.spring_bootsecurity.service.RoleService;
import com.example.spring_bootsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

	private UserService userService;
	private RoleService roleService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@GetMapping(value = "/user")
	public String userPage(@AuthenticationPrincipal User user, Model model){
		model.addAttribute("user", user);
		model.addAttribute("roles", user.getRoles());
		return "user";
	}

	@GetMapping(value = "/admin")
	public String adminPage(Model model){
		model.addAttribute("allUsers", userService.getAllUsers());
		return "admin";
	}

	@GetMapping(value = "/edit/{id}")
	public String editUserForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		model.addAttribute("roles", roleService.getAllRoles());
		return "edit";
	}

	@PostMapping(value = "/admin/edit")
	public String editUser(@ModelAttribute User user, @RequestParam(required = false, value = "checkBoxRoles") String[] checkBoxRoles) {
		Set<Role> roleSet = new HashSet<>();
		for (String roles : checkBoxRoles) {
			roleSet.add(roleService.getRoleByUsername(roles));
		}
		user.setRoles(roleSet);
		userService.updateUser(user);
		return "redirect:/admin";
	}

	@GetMapping(value = "/admin/new")
	public String newUser(Model model){
		model.addAttribute("user", new User());
		model.addAttribute("roles", roleService.getAllRoles());
		return "new";
	}
	@PostMapping(value = "/admin/add")
	public String addNewUser(@ModelAttribute User user, @RequestParam(required = false, value = "checkBoxRoles") String[] checkBoxRoles){
		Set<Role> roleSet = new HashSet<>();
		for (String roles : checkBoxRoles) {
			roleSet.add(roleService.getRoleByUsername(roles));
		}
		user.setRoles(roleSet);
		userService.addUser(user);
		return "redirect:/admin";
	}

	@GetMapping(value = "/remove/{id}")
	public String removeUser(@PathVariable("id") long id) {
		userService.removeUserById(id);
		return "redirect:/admin";
	}

}