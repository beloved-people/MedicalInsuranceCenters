package com.neuedu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.neuedu.service.UnitInfoService;
import com.neuedu.service.implement.UnitInfoServiceImpl;

/**
 * Servlet implementation class DeleteUnitInfo
 */
@WebServlet("/DeleteUnitInfo")
public class DeleteUnitInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUnitInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		long id = Long.parseLong(sid);
		UnitInfoService uis = new UnitInfoServiceImpl();
		if(uis.del(id))
			response.getWriter().write("É¾³ý³É¹¦£¡£¡");
		else
			response.getWriter().write("É¾³ýÊ§°Ü£¡£¡");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
