package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.DiseaseInfo;
import com.neuedu.service.DiseaseService;
import com.neuedu.service.implement.DiseaseServiceImpl;

/**
 * Servlet implementation class AddDisease
 */
@WebServlet("/AddDisease")
public class AddDisease extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDisease() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String diseaseCode = request.getParameter("diseaseCode");
		String diseaseName = request.getParameter("diseaseName");
		String diseaseTypeId = request.getParameter("diseaseTypeId");
		int diseaseReimbursementSign = Integer.parseInt(request.getParameter("diseaseReimbursementSign"));
		String remarks = request.getParameter("remarks");
		DiseaseInfo disease = new DiseaseInfo(diseaseCode, diseaseName, diseaseTypeId, diseaseReimbursementSign, remarks);
		DiseaseService d = new DiseaseServiceImpl();
		boolean isSuccess = d.add(disease);
		if (isSuccess) {
			request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("/ShowDisease").forward(request, response);
		}else {
			request.setAttribute("msg", "添加失败");
			request.getRequestDispatcher("/ShowDisease").forward(request, response);
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
