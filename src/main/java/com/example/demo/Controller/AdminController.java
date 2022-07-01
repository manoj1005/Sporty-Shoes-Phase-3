package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.CasualsRepository;
import com.example.demo.Repository.RunningRepository;
import com.example.demo.Repository.SportsRepository;
import com.example.demo.Service.AdminDao;
import com.example.demo.Service.ShoeDao;
import com.example.demo.Service.UserDao;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Casuals;
import com.example.demo.entity.Running;
import com.example.demo.entity.Shoe;
import com.example.demo.entity.Sports;
import com.example.demo.entity.User;

@Controller
public class AdminController {
	@Autowired
	AdminDao adao;
	@Autowired
	UserDao udao;
	@Autowired
	ShoeDao sdao;
	@Autowired
	CasualsRepository crepo;
	@Autowired
	RunningRepository rrepo;
	@Autowired
	SportsRepository srepo;
	
	@RequestMapping("/alogin")
		public void asave(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String mail=req.getParameter("mail");
		String pw=req.getParameter("pwd");
		Admin a=adao.byEmail(mail);
		String p=a.getPassword();
		if(p.equals(pw)) {
			res.sendRedirect("AdminControl.jsp");
		}
		else {
			res.sendError(0);
		}
	}
	@RequestMapping("/aregister")
	public void aregister(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String name=req.getParameter("name");
		String mail=req.getParameter("mail");
		String pwd=req.getParameter("pwd");
		Admin a=new Admin();
		a.setName(name);
		a.setEmail(mail);
		a.setPassword(pwd);
		Admin a1=adao.insert(a);
		if(a1!=null) {
			res.sendRedirect("Alogin.jsp");
		}
		else {
			res.sendRedirect("error.jsp");
		}
	}
	@RequestMapping("/aproduct")
	public void aviewProducts(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String cat=req.getParameter("cat");
		if(cat.equalsIgnoreCase("All")) {
		List<Shoe> s=sdao.getAll();
		HttpSession session=req.getSession();
		session.setAttribute("Shoes", s);
		if(s!=null) {
			res.sendRedirect("ashoeall.jsp");
		}
		}
		else if(cat.equalsIgnoreCase("Casuals")) {
			List<Casuals> c=crepo.findAll();
			HttpSession session=req.getSession();
			session.setAttribute("Shoes", c);
			if(c!=null) {
				res.sendRedirect("ashoeall.jsp");
			}
		}
		else if(cat.equalsIgnoreCase("Running")) {
			List<Running> c=rrepo.findAll();
			HttpSession session=req.getSession();
			session.setAttribute("Shoes", c);
			if(c!=null) {
				res.sendRedirect("ashoeall.jsp");
			}
		}
		else if(cat.equalsIgnoreCase("Sports")) {
			List<Sports> c=srepo.findAll();
			HttpSession session=req.getSession();
			session.setAttribute("Shoes", c);
			if(c!=null) {
				res.sendRedirect("ashoeall.jsp");
			}
		}
		else res.sendRedirect("error.jsp");
		}
	@RequestMapping("/auser")
	public void aviewUser(HttpServletRequest req,HttpServletResponse res) throws IOException {
	List<User> u=udao.retrieve();
	HttpSession session=req.getSession();
	session.setAttribute("Users", u);
	if(u!=null) {
		res.sendRedirect("auserall.jsp");
	}
	else res.sendError(0);
	}
	@RequestMapping("/deleteshoe")
	public void adeleteshoe(HttpServletRequest req,HttpServletResponse res,@RequestParam("id") Integer id) throws IOException {
		 String del=sdao.deleteById(id);
		 if(del!=null) {
			 res.sendRedirect("aproducts.jsp");
		 }
		 else res.sendRedirect("deleteshoe.jsp");
	}
	@RequestMapping("/editshoe")
	public void aupdate(HttpServletRequest req,HttpServletResponse res,@RequestParam("id") Integer id,
			@RequestParam("comp") String comp,@RequestParam("cat") String cat,
			@RequestParam("size") Integer size,@RequestParam("price") Integer price) throws IOException {
		if(cat.equalsIgnoreCase("Casuals")) {
		Shoe s=new Casuals();
		s.setId(id);
		s.setShoeComp(comp);
		s.setCategory(cat);
		s.setPrice(price);
		s.setSize(size);
		Shoe ss=sdao.edit(s);
		if(ss!=null) {
			res.sendRedirect("aproducts.jsp");
		}
		}
		else if(cat.equalsIgnoreCase("Running")) {
			Shoe s=new Running();
			s.setId(id);
			s.setShoeComp(comp);
			s.setCategory(cat);
			s.setPrice(price);
			s.setSize(size);
			Shoe ss=sdao.edit(s);
			if(ss!=null) {
				res.sendRedirect("aproducts.jsp");
			}
			}
		else if(cat.equalsIgnoreCase("Sports")) {
			Shoe s=new Sports();
			s.setId(id);
			s.setShoeComp(comp);
			s.setCategory(cat);
			s.setPrice(price);
			s.setSize(size);
			Shoe ss=sdao.edit(s);
			if(ss!=null) {
				res.sendRedirect("aproducts.jsp");
			}
			}
		else res.sendRedirect("error.jsp");
	}
	
	@RequestMapping("/edituser")
		public void aedituser(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int id=Integer.valueOf(req.getParameter("id"));
		String f=req.getParameter("first");
		String l=req.getParameter("last");
		String m=req.getParameter("email");
		String p=req.getParameter("pwd");
		User u=new User();
		u.setId(id);
		u.setFirstName(f);
		u.setLastName(l);
		u.setMailId(m);
		u.setPassword(p);
		User uu=udao.adminUpdatesuser(u);
		if(uu!=null) {
			res.sendRedirect("auser.jsp");
		}
		else res.sendError(0);
	}
	@RequestMapping("/deleteuser")
	public void adeleteUser(HttpServletRequest req,HttpServletResponse res,@RequestParam("id") Integer id) throws IOException {
		String delu=udao.deleteUser(id);
		if(delu!=null) {
			res.sendRedirect("auser.jsp");
		}
		else res.sendRedirect("error.jsp");
	}
}
