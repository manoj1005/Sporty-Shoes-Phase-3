package com.example.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	UserDao dao;
	@RequestMapping("/register")
	public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		String f=req.getParameter("first");
		String l=req.getParameter("last");
		String m=req.getParameter("email");
		String p=req.getParameter("pwd");
		User u=new User();
		u.setFirstName(f);
		u.setLastName(l);
		u.setMailId(m);
		u.setPassword(p);
		User uu=dao.insert(u);
		if(uu!=null) {
			mv.setViewName("Login.jsp");
			return mv;
		}
		else {
			mv.setViewName("Register.jsp");
			return mv;
		}
	}
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		String m=req.getParameter("email");
		String p=req.getParameter("pwd");
		User u=dao.getUserByMail(m);
		if(dao.getUserByMail(m).equals(dao.getUserByPassword(p))) {
			mv.setViewName("ListOfShoes.jsp");
			String name=dao.getUserByMail(m).getFirstName()+" "+dao.getUserByMail(m).getLastName();
			mv.addObject("Name", name);
			mv.addObject("mail",u.getMailId());
			return mv;
		}
		else {
			mv.setViewName("Register.jsp");
			return mv;
		}
	}
	@RequestMapping("/change")
	public void changepwd(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String mail=req.getParameter("mail");
		String pwd=req.getParameter("pwd");
		String cpwd=req.getParameter("cpwd");
		if(pwd.equals(cpwd)) {
			User uu=dao.update(mail, pwd);
			if(uu!=null) {
			res.sendRedirect("Login.jsp");
			}
		}
		else res.sendRedirect("Changepwd.jsp");
	}
	
	@RequestMapping("logout")
	public void logout(HttpServletRequest req,HttpServletResponse res) throws IOException {
		HttpSession session=req.getSession();
		if(session !=null) {
			session.invalidate();
		}
		res.sendRedirect("LogoutSuc.jsp");
	}

}
