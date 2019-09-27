package com.wipro.SpringBootDemoJul8;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HelloWorldController {
	Map<String,User> users =new HashMap<String,User>();
	
	public HelloWorldController() {
		 User uu = new User("savi","savi","savi@gmial.com",100);
	        users.put("savi",uu);
	       
	}
	@RequestMapping(value = "/users/Register", method = RequestMethod.GET)
	@ResponseBody
    public String helloWorld(@ModelAttribute("userid")String userid, @ModelAttribute("password") String password,@ModelAttribute("email")String email)
    {
		User u = new User(userid, password, email,100);
		users.put(userid,u);
        return "<html><body>Registered successfully"+ "<a href = 'http://localhost:8090/index.html'> Home to login </a> " +"</body></html>" ;
    }
	@RequestMapping(value = "/users/all", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,User> getAllRegisteredUsers(){
		return users;
	}
	@RequestMapping(value = "/users/{userid}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable("userid")String userid)
	{
		return users.get(userid);
	}
	@RequestMapping(value = "/users/login", method = RequestMethod.GET)
	@ResponseBody
	public String loginUser(@ModelAttribute("userid")String userid, @ModelAttribute("password") String password,HttpServletRequest request)
	{
		User uu = users.get(userid);
		request.getSession().setAttribute("user",uu);
		

	 if (users.get(userid)!=null)
		{
			if (users.get(userid).getPassword().equals(password))
			{
				return "Click on trade for trading <a href = 'http://localhost:8090/Trade.html'> Trade </a>";
			}
		else 
			{
				return "<html><body> Password is worng please try again "+ "<a href = 'http://localhost:8090/PasswordError.html'> </a> " + "<a href = 'http://localhost:8090/login.html'> login </a>" +"</body></html>" ;
			}
		}
	
		else {
			return "Sorry username and password not valid" + "<a href = 'http://localhost:8090/login.html'> login Again </a>";
		} 
	
	}
	
	}


