package com.java.hellocontroller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.model.Blog;
import com.java.model.UserEntity;
import com.java.service.BlogService;
import com.java.service.ItemService;
import com.java.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BlogService blogService;
	
	@Autowired
	private ItemService itemService;
	
	
	
	
	@ModelAttribute("comm")
	public UserEntity saveUser(){
		
		return new UserEntity();
	}

	
	@ModelAttribute("model")
	public Blog blogger(){
		return new Blog();
	}

	@RequestMapping("/users")
	public String userPage(Model model) {

		model.addAttribute("msg", userService.findAll());

		return "users";
	}

	@RequestMapping("/{id}/user_blog")
	public String userBlog(Model model, @PathVariable int id) {

		model.addAttribute("msg", userService.findOne(id));

		return "userBlog";
	}
	@RequestMapping("/{id}/user_delete")
	public String userBlog( @PathVariable int id) {

		userService.delete(id);

		return "redirect:/users.html";
	}
	
	
	/*
	 * add blogs
	 */

	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		
		String name=principal.getName();
		
		model.addAttribute("msg",userService.findByname(name));

		return "account";

	}

	@RequestMapping(value = ("/account"), method = RequestMethod.POST)
	public String account(@ModelAttribute("model") Blog blog,
			Principal principal) {

		String name = principal.getName();

		blogService.saveBlog(blog, name);

		return "redirect:/account.html";

	}
	
	/*
	 * Edit blog
	 */
	
	@RequestMapping("/{id}/editBlog")
	public String editAccount() {

		return "account";

	}

	@RequestMapping(value = ("/{id}/editBlog"), method = RequestMethod.POST)
	
	public String editAccount(@ModelAttribute("model") Blog blog, Principal principle) {

		String names=principle.getName();
	

		blogService.editBlog(blog,names);

		return "redirect:/account.html";

	}
	

	@RequestMapping("/{id}/deleteBlog")
	public String deleteBlog(@PathVariable int id) {

		blogService.deleteBlog(id);
		return "redirect:/users.html";

	}
	
	

	
	@RequestMapping("/register")
	public String registerForm(){
		
		return "registration";
	}
	
	
	@RequestMapping(value=("/register"),method=RequestMethod.POST)
	public String saveForm(@Valid @ModelAttribute("comm") UserEntity users,BindingResult result){
		
		
		if(result.hasErrors()){
			return "registration";
		}
		userService.save(users);
		
		return "redirect:/register.html?success=true";
	}
	
	
	
	@RequestMapping("/search")
	
	public String search(Model model,@RequestParam("search") String name){
		
		if(name != null){
		
  boolean found=itemService.searchByName(name) !=null;
       model.addAttribute("msg",found);
       if(found==true){
		model.addAttribute("search",itemService.searchByName(name));
       }
		
	}
		return "search";
	}
	
	
	
	

}
