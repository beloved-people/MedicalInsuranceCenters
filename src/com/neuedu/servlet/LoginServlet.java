package com.neuedu.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.OperatorInfo;
import com.neuedu.service.implement.OperatorServiceImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operatorName = request.getParameter("operatorName");
		String operatorPwd = request.getParameter("operatorPwd");
		String jobNumber = request.getParameter("jobNumber");
		OperatorInfo o = new OperatorInfo();
		o.setOperatorName(operatorName);
		o.setOperatorPwd(operatorPwd);
		o.setJobNumber(jobNumber);
		OperatorServiceImpl osi = new OperatorServiceImpl();
		boolean isSuccess = osi.login(o);
		if (isSuccess) {
			HttpSession session = request.getSession();
			session.setAttribute("operator", o);
			session.setAttribute("jobNumber", jobNumber);
			String id = session.getId();	
			Cookie cookie = new Cookie("JSESSIONID",id);
			cookie.setMaxAge(60*3);
			cookie.setPath("/");	
			response.addCookie(cookie);
			request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
		}else {
			response.getWriter().write("µÇÂ½Ê§°Ü");
			response.sendRedirect("Login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
