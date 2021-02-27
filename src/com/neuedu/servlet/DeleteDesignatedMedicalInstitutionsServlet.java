package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.service.DesignatedMedicalInstitutionsService;
import com.neuedu.service.implement.DesignatedMedicalInstitutionsServiceImpl;

/**
 * Servlet implementation class DeleteDesignatedMedicalInstitutionsServlet
 */
@WebServlet("/DeleteDesignatedMedicalInstitutionsServlet")
public class DeleteDesignatedMedicalInstitutionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDesignatedMedicalInstitutionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long designatedMedicalInstitutionCode =Long.parseLong(request.getParameter("id")); 
		DesignatedMedicalInstitutionsService d = new DesignatedMedicalInstitutionsServiceImpl();
		d.delete(designatedMedicalInstitutionCode);
        request.getRequestDispatcher("/ShowDesignatedMedicalInstitutionsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
