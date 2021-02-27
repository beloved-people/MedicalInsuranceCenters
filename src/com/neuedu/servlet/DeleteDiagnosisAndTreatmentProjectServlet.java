package com.neuedu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.service.implement.DiagnosisAndTreatmentProjectServiceImpl;

/**
 * Servlet implementation class DeleteDiagnosisAndTreatmentProjectServlet
 */
@WebServlet("/DeleteDiagnosisAndTreatmentProjectServlet")
public class DeleteDiagnosisAndTreatmentProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDiagnosisAndTreatmentProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long projectCode =Long.parseLong(request.getParameter("ids")); 
	
        DiagnosisAndTreatmentProjectServiceImpl projectService = new DiagnosisAndTreatmentProjectServiceImpl();
        projectService.delete(projectCode);
        request.getRequestDispatcher("ShowDiagnosisAndTreatmentProjectServlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
