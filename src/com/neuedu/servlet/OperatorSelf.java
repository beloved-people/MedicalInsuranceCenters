package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.OperatorInfo;
import com.neuedu.service.OperatorService;
import com.neuedu.service.implement.OperatorServiceImpl;

@WebServlet("/OperatorSelf")
public class OperatorSelf extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OperatorSelf() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String jobNumber = (String) session.getAttribute("jobNumber");
		OperatorService service = new OperatorServiceImpl();
		OperatorInfo o = service.get(jobNumber);
		request.setAttribute("o", o);
		request.getRequestDispatcher("/OperatorInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
