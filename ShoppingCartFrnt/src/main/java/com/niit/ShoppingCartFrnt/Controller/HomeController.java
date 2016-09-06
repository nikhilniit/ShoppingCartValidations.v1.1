package com.niit.ShoppingCartFrnt.Controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.privilegedactions.GetAnnotationParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.dao.UserDetailsDAO;
import com.niit.ShoppingCart.model.Category;
import com.niit.ShoppingCart.model.UserDetails;



@Controller
public class HomeController {
	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	@RequestMapping("/")
	@Autowired
	public ModelAndView home(){
	ModelAndView mv=new ModelAndView("/home");
		mv.addObject("message", "Thank you for using this URL");
	
	
		return mv;
	}
	@RequestMapping("/signup")
	public ModelAndView register()
	{

		ModelAndView mv=new ModelAndView("signup");
		mv.addObject("user clicked register here","true");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView Login()
	{

		ModelAndView mv=new ModelAndView("login");
		mv.addObject("user clicked register here","true");
		return mv;
	}
	 @RequestMapping("/signup1")
		public ModelAndView usersignUp(@Valid @ModelAttribute("userDetails") UserDetails user, BindingResult result,
	            Model model)
		{
			 ModelAndView mv;
			 if (result.hasErrors()) {
				 System.out.println(" errors");
		            return new ModelAndView("usersignup");
		        }
			System.out.println("user's first name:"+user.getName());

			

			
			mv= new ModelAndView("usersignup","message","Dear "+user.getName()+" !! You have successfully registered");
		   
			return mv;
		}
}

