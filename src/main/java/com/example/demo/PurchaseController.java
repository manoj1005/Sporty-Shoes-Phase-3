package com.example.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PurchaseController {
	@Autowired
	PurchaseDao pdao;
	@Autowired
	ShoeDao sdao;
	@Autowired
	UserDao udao;
	
	@RequestMapping("/checkOut")
	public void checkOut(HttpServletRequest req,HttpServletResponse res,
			@RequestParam("price") Integer price) throws IOException {
		HttpSession session=req.getSession();
		session.setAttribute("Price",price);
		res.sendRedirect("CheckOut.jsp");
	}
	
	@RequestMapping("/confirm")
	public void confirm(HttpServletRequest req,HttpServletResponse res,@RequestParam("mail") String mail,
			@RequestParam("id") Integer id,@RequestParam("price") Integer price) throws IOException {
		Purchase p=new Purchase();
		HttpSession session=req.getSession();
		User u=udao.getUserByMail(mail);
		Shoe s=sdao.findById(id);
		p.setPrice(price);
		p.setShoe(s);
		p.setUser(u);
		String add=req.getParameter("add");
		if((add.length()>=5) && (s.getPrice()==price)) {
		Purchase pp=pdao.insert(p);
		res.sendRedirect("Confirm.jsp");
		}
		else res.sendRedirect("error.jsp");
	}
	
	@RequestMapping("/acart")
	public void getall(HttpServletRequest req,HttpServletResponse res) throws IOException {
		List<Purchase> p=pdao.getall();
		HttpSession session=req.getSession();
		session.setAttribute("List", p);
		res.sendRedirect("acartall.jsp");
	}
}
