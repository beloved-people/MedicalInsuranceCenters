package com.neuedu.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.DrugInfo;
import com.neuedu.entity.PageBean;
import com.neuedu.service.implement.DrugInfoServiceImpl;

/**
 * Servlet implementation class DrugInfo1Servlet
 */
@WebServlet("/DrugInfo1Servlet")
public class DrugInfo1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrugInfo1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
		
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        Map<String, String[]> condition = request.getParameterMap();
        DrugInfoServiceImpl drugservice = new DrugInfoServiceImpl();
        PageBean<DrugInfo> pb = drugservice.findByPageBean(currentPage, rows, condition);
        request.setAttribute("pb", pb);
        request.setAttribute("condition",condition);		
        request.getRequestDispatcher("/DrugInfo2.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
