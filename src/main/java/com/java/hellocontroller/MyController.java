package com.java.hellocontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.service.BlogService;
import com.java.service.ItemService;


@Controller
public class MyController {
	
	@Autowired
	private ItemService itemService;
	
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/welcome")
	public String displayIndex(Model model){
		
		model.addAttribute("msg",itemService.findAll());
		
		return "index";
	}
	

	


	
	
}
