package com.neuedu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.UnitInfo4;
import com.neuedu.service.UnitInfoService;
import com.neuedu.service.implement.UnitInfoServiceImpl;

/**
 * Servlet implementation class QueryUnitInfo
 */
@WebServlet("/QueryUnitInfo")
public class QueryUnitInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUnitInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		long id = Long.parseLong(sid);
		String name = request.getParameter("name");
		UnitInfoService uis = new UnitInfoServiceImpl();
		UnitInfo4 ui = new UnitInfo4();
		ui = uis.getByIdAndName(id, name);
		
		response.getWriter().write("{\"id\":\""+id+"\",\"name\":\""+name
				+"\",\"companyType\":\""+ui.getCompanyType()
				+"\",\"companyContactNumber\":\""+ui.getCompanyContactNumber()
				+"\",\"companyAddress\":\""+ui.getCompanyAddress()
				+"\",\"companyPostcode\":\""+ui.getCompanyPostcode()+"\"}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
