package com.firstProject.firstProject.controller;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.firstProject.firstProject.entity.MyUser;
import com.firstProject.firstProject.pojo.NewUser;
import com.firstProject.firstProject.repository.MyRepository;

/**
 * @author RA319691
 *
 */

@Controller
public class MyClasss {

	@Autowired
	MyRepository myRepository;
	

	/*
	 * @PostMapping("/saveData")
	 * 
	 * public String saveData() {
	 * 
	 * Scanner sc = new Scanner(System.in); 
	 * MyUser myUser = new MyUser();
	 * 
	 * String name = sc.next(); 
	 * myUser.setEmpName(name);
	 * 
	 * String id = sc.next(); 
	 * myUser.setEmpId(id);
	 * 
	 * myRepository.save(myUser);
	 * 
	 * return "success"; }
	 */

	@PostMapping("/saveData")
	public String Submit(NewUser newmyUser) {
		boolean flag = false;
		MyUser user = new MyUser();
		List<MyUser> allUserList = myRepository.findAll();
		
		for (MyUser myUser2 : allUserList) {
			// myUser2 = (MyUser) iterator.next();
			if(myUser2.getEmpName().equalsIgnoreCase(newmyUser.getName())) {
				flag = true;
			break;}
		}
		
		user.setEmpId(newmyUser.getId());
		user.setEmpName(newmyUser.getName());
		
		if(flag){
			return "failure";
		}else {
		myRepository.save(user);
		}
		return "success";

	}
	
	@PostMapping("/editData")
	public String editData(NewUser newmyUser) {

		MyUser user = myRepository.getByEmpId(newmyUser.getId());
		
		if(user == null) {
			user = myRepository.findByEmpName(newmyUser.getName());
		}
		//MyUser user = myRepository.getByEmpName(newmyUser.getName());
		
		user.setEmpName(newmyUser.getName());
		user.setEmpId(newmyUser.getId());
		
		myRepository.save(user);
		
		//************************
		//boolean flag = false;
		/*
		 * MyUser user = new MyUser(); List<MyUser> allUserList =
		 * myRepository.findAll();
		 * 
		 * for (MyUser myUser2 : allUserList) { // myUser2 = (MyUser) iterator.next();
		 * if(myUser2.getEmpName().equalsIgnoreCase(newmyUser.getName())) { flag = true;
		 * break;} }
		 */
		//*************************
		//user.setEmpId(newmyUser.getId());
		//user.setEmpName(newmyUser.getName());
		
		/*if(flag){
			return "failure";
		}else {*/
		
		//myRepository.save(user);
		//}

		return "editSuccess";

	}
	
	
	@PostMapping("/deleteData")
	public String deleteData(NewUser newmyUser) {
		myRepository.deleteById(newmyUser.getId());

		return "deleteSuccess";

	}
	
	@GetMapping("/getName/{empName}")
	public ModelAndView getName(@PathVariable("empName") String empName) {
		MyUser myUser = myRepository.getByEmpName(empName);

		// myUser.getEmpId() + "::" + myUser.getEmpName()
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", myUser.getEmpId());
		mv.addObject("id", myUser.getEmpName());
		mv.setViewName("Welcome");

		return mv;
	}
	
	 
	  @PostMapping("/submit") 
	  public String afterSubmit(NewUser newUser, Model modelview) {
	  modelview.addAttribute("name", newUser.getName());
	  modelview.addAttribute("id", newUser.getId());
	  
	  MyUser myUser = myRepository.getByEmpName(newUser.getName());
	  modelview.addAttribute("id", myUser.getEmpId());
	  
	 MyUser userId = myRepository.getByEmpId(newUser.getId());
	 modelview.addAttribute("name", userId.getEmpName());
	 
	  return "Welcome"; 
	  }
	 

	@GetMapping("/getId/{empId}")
	public String getById(@PathVariable("empId") String empId) {
		MyUser myUser = myRepository.getByEmpId(empId);

		return myUser.getEmpId() + "::" + myUser.getEmpName();
	}
	

	@GetMapping("/findAll")
	public List<MyUser> getAll() {
		return myRepository.findAll();
	}

	@GetMapping("/jsp")
	public String getJsp() {
		return "login";
	}
	
	@GetMapping
	public void myController(HttpServletResponse response) throws IOException{
		response.sendRedirect("/jsp");
		}
	
	@GetMapping("/add")
	public String getAdd() {

		return "save";
	}

	@GetMapping("/logout")
	public String getReturn() {
		return "thankyou";
	}
	

	@GetMapping("/signup")
	public String getSign() {
		return "signup";
	}
	
	
//	@PostMapping("/Search{empName}")
	// public String searchById(String searchName) {
	// System.out.println(searchName);

	// return "Search";
	// }
	
	

	@GetMapping("/search")
	public String lectureSearch(@RequestParam("name") String name, Model model) {
		System.out.print(name);
		List<MyUser> myUserList = myRepository.findByEmpNameContains(name);
		
	    if(myUserList.size()>0) {
			/*
			 * model.addAttribute("name", myUser.getEmpName()); model.addAttribute("id",
			 * myUser.getEmpId());
			 */
	    	model.addAttribute("myUserList",myUserList);
	    }
	    else 
	    {
	    	model.addAttribute("errorFlag", 1);
	    	model.addAttribute("error", "No details found");
	    }

		return "Search";
	}
	
	@GetMapping("/edit/{name}/{id}")
	public ModelAndView myEdit(@PathVariable("name") String name, @PathVariable("id") String id) {
			 
			  System.out.println("Edit Controller-->"+name);
			  System.out.println("Edit Controller-->"+id);
			  
			ModelAndView mv = new ModelAndView("edit");
			mv.addObject("name", name);
			mv.addObject("id", id);
	
		return mv;
	}
	
	/*
	 * @GetMapping("/myDelete/{name}/{id}") public ModelAndView
	 * myDelete(@PathVariable("name") String name, @PathVariable("id") String id) {
	 * 
	 * ModelAndView mv = new ModelAndView("myDelete"); mv.addObject("name", name);
	 * mv.addObject("id", id);
	 * 
	 * return mv; }
	 */
	
	/*
	 * @RequestMapping(value = "/myDelete/{name}{id}", method =
	 * RequestMethod.DELETE) public void deleteUser(@PathVariable String
	 * name, @PathVariable String id) {
	 */  
	// }
	
	//@GetMapping("/myChange")
	//public String myChange() {
		
//		return "edit";
	//}
	
	@GetMapping("/delete")
	public String myDel() {
		return "success";
	}

	@GetMapping("/back")
	public String myBack() {
	return "Welcome";	
	}
	@GetMapping("/backhome")
	public String myHome() {
		
		return "login";
	}
	/*
	 * @GetMapping("/login") public String getLogin() {
	 * 
	 * return "loginPage"; }
	 */

}
