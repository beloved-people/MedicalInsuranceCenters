package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.service.ServiceFacilityService;
import com.neuedu.service.implement.ServiceFacilityServiceImpl;

/**
 * Servlet implementation class DeleteServiceFacilityServlet
 */
@WebServlet("/DeleteServiceFacilityServlet")
public class DeleteServiceFacilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServiceFacilityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long medicalServiceFacilityCode=Long.parseLong(request.getParameter("id")); 
		ServiceFacilityService service = new ServiceFacilityServiceImpl();
		service.delete(medicalServiceFacilityCode);
		request.getRequestDispatcher("/ShowServiceFacilityServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
