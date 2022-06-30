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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoeController {
	@Autowired
	ShoeDao sdao;
	@RequestMapping("/shoe")
	public void cinsert(HttpServletRequest req,HttpServletResponse res,
			@RequestParam("comp") String comp,@RequestParam("cat") String cat,
			@RequestParam("size") Integer size,@RequestParam("price") Integer price) throws IOException {
		if(cat.equalsIgnoreCase("Casuals")) {
		Shoe s=new Casuals();
		s.setShoeComp(comp);
		s.setCategory(cat);
		s.setPrice(price);
		s.setSize(size);
		Shoe ss=sdao.insert(s);
		if(ss!=null) {
			res.sendRedirect("aproducts.jsp");
		}
		}
		else if(cat.equalsIgnoreCase("Running")) {
			Shoe s=new Running();
			s.setShoeComp(comp);
			s.setCategory(cat);
			s.setPrice(price);
			s.setSize(size);
			Shoe ss=sdao.insert(s);
			if(ss!=null) {
				res.sendRedirect("aproducts.jsp");
			}
			}
		else if(cat.equalsIgnoreCase("Sports")) {
			Shoe s=new Sports();
			s.setShoeComp(comp);
			s.setCategory(cat);
			s.setPrice(price);
			s.setSize(size);
			Shoe ss=sdao.insert(s);
			if(ss!=null) {
				res.sendRedirect("aproducts.jsp");
			}
			}
		else res.sendRedirect("error.jsp");
		}
	@RequestMapping("/getall")
	public void getAll(HttpServletRequest req,HttpServletResponse res) throws IOException {
		List<Shoe> s=sdao.getAll();
		HttpSession session=req.getSession();
		session.setAttribute("List", s);
		String mail=(String)session.getAttribute("mail");
		session.setAttribute("mail", mail);
		res.sendRedirect("Products.jsp");
	}
	
	@RequestMapping("/allcasuals")
	public void casall(HttpServletRequest req,HttpServletResponse res) throws IOException {
		List<Casuals> cs=sdao.getCas();
		HttpSession session=req.getSession();
		session.setAttribute("List", cs);
		res.sendRedirect("Products.jsp");
	}
	@RequestMapping("/allsports")
	public void sportall(HttpServletRequest req,HttpServletResponse res) throws IOException {
		List<Sports> cs=sdao.getSports();
		HttpSession session=req.getSession();
		session.setAttribute("List", cs);
		res.sendRedirect("Products.jsp");
	}
	@RequestMapping("/allrunning")
	public void runall(HttpServletRequest req,HttpServletResponse res) throws IOException {
		List<Running> cs=sdao.getRun();
		HttpSession session=req.getSession();
		session.setAttribute("List", cs);
		res.sendRedirect("Products.jsp");
	}
	
	@RequestMapping("/addtocart")
	public void addToCart(HttpServletRequest req,HttpServletResponse res,@RequestParam("id") Integer id
			) throws IOException {
		HttpSession session=req.getSession();
		Shoe s=sdao.findById(id);
		if(s!=null) {
		session.setAttribute("List",s);
		//session.setAttribute("mail", mail);  @RequestParam("mail") String mail
		res.sendRedirect("Buy.jsp");
		}
		else res.sendRedirect("error.jsp");
	}
}