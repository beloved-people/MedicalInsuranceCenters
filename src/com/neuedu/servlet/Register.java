package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.OperatorInfo;
import com.neuedu.service.implement.OperatorServiceImpl;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operatorName = request.getParameter("operatorName");
		String operatorGender = request.getParameter("operatorGender");
		String operatorPwd = request.getParameter("operatorPwd");
		String operatorAccount = request.getParameter("operatorAccount");
		String jobNumber = request.getParameter("jobNumber");
		OperatorInfo oi = new OperatorInfo();
		oi.setOperatorName(operatorName);
		oi.setOperatorGender(operatorGender);
		oi.setOperatorPwd(operatorPwd);
		oi.setOperatorAccount(operatorAccount);
		oi.setJobNumber(jobNumber);
		OperatorServiceImpl osi = new OperatorServiceImpl();
		boolean isSuccess = osi.register(oi);
		if (isSuccess) {
			response.getWriter().write("<div class='page-header'><h1>×¢²á³É¹¦<small>ÕýÔÚÌøÍùµÇÂ½Ò³Ãæ......</small></h1></div>");
	        response.setHeader("Refresh", "5;URL="+request.getContextPath());
		} else {
			request.setAttribute("msg", "×¢²áÊ§°Ü");
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
