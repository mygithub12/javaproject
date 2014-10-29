package com.java.hellocontroller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AccessDeniedController {
	
	

	
	
	@RequestMapping("/403")
	public String access(Model model ,Principal principal){
		
		String name=principal.getName();
		model.addAttribute("msg",name);
		
		return "denied";
		
	}

}
