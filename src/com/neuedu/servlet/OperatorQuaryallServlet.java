package com.neuedu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.dao.implement.OperatorDaoImpl;
import com.neuedu.entity.OperatorInfo;

/**
 * Servlet implementation class OperatorQuaryallServlet
 */
@WebServlet("/OperatorQuaryallServlet")
public class OperatorQuaryallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperatorQuaryallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperatorDaoImpl odi = new OperatorDaoImpl();
		List<OperatorInfo> list = odi.qurryAll();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/Operator.jsp").forward(request, response);
		doGet(request, response);
	}

}
