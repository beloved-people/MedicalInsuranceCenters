package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.service.OperatorService;
import com.neuedu.service.implement.OperatorServiceImpl;

/**
 * Servlet implementation class ModifyPwd
 */
@WebServlet("/ModifyPwd")
public class ModifyPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jobNumber = request.getParameter("jobNumber");
		String password = request.getParameter("password");
		OperatorService service = new OperatorServiceImpl();
		boolean isSuccess = service.modifyPwd(jobNumber, password);
		if (isSuccess) {
			response.getWriter().write("<div class='page-header'><h1>修改密码成功<small>正在跳往登陆页面......</small></h1></div>");
	        response.setHeader("Refresh", "5;URL="+request.getContextPath());
		} else {
			request.setAttribute("msg", "修改失败");
			request.getRequestDispatcher("/ModifyPassword.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
