package com.wipro.SpringBootDemoJul8;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TradeController {
User user = new User();

Map <String, Double> companies = new HashMap<String,Double>();
Map <String, Trade> trades = new HashMap<String,Trade>();

public TradeController() {
	companies.put("Wipro",200.00);
	companies.put("TCS",100.00);
	companies.put("IBM",300.00);
	companies.put("HDFC",400.00);

}

@RequestMapping(value = "/trade/do", method = RequestMethod.GET)
@ResponseBody

public String tradeDo(@ModelAttribute("ticker")String ticker,@ModelAttribute("qty") int qty, HttpServletRequest request)
{
	Double price =companies.get(ticker);
	Trade t= new Trade(ticker,price,qty);
	double total = price*qty;
	
	user= (User)request.getSession().getAttribute("user");
	double bal = user.getBalance();
	
	if (bal<total) {
		return "error" + new RuntimeException("Sorry no enough balance");
	}
	else {
		trades.put(ticker, t);

		bal = user.getBalance()-total;
		user.setBalance(bal);
		t.setTotalcost(total);
	}
	return "<html><body> Trade successfully completed " + user.getUserid() + " your Balance available :: " + user.getBalance()+ "<br> <a href = 'http://localhost:8090/index.html'> <br> Exit </a><br><a href = 'http://localhost:8090/Trade.html'> Trade Again </a><br>" + "<html></html>";
}
@RequestMapping(value = "trade/all", method = RequestMethod.GET)
@ResponseBody
public Map<String,Trade> getAllRegisteredUsers(){
	
	return trades;
}
@RequestMapping(value = "trade/{ticker}", method = RequestMethod.GET)
@ResponseBody
public Trade getUser(@PathVariable("ticker")String ticker)
{
	return trades.get(ticker);
}
}

