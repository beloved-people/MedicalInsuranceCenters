package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.ServiceFacilityInfo;
import com.neuedu.service.ServiceFacilityService;
import com.neuedu.service.implement.ServiceFacilityServiceImpl;

/**
 * Servlet implementation class AddServiceFacility
 */
@WebServlet("/AddServiceFacility")
public class AddServiceFacility extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServiceFacility() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long medicalServiceFacilityCode = Long.parseLong(request.getParameter("medicalServiceFacilityCode")); 
		String serviceFacilitiesName = request.getParameter("serviceFacilitiesName");
		String remarks = request.getParameter("remarks");
		String restrictedUsingScope = request.getParameter("restrictedUsingScope");
		ServiceFacilityInfo sf = new ServiceFacilityInfo();
		sf.setMedicalServiceFacilityCode(medicalServiceFacilityCode);
		sf.setServiceFacilitiesName(serviceFacilitiesName);
		sf.setRemarks(remarks);
		sf.setRestrictedUsingScope(restrictedUsingScope);
		ServiceFacilityService service = new ServiceFacilityServiceImpl();
		boolean isSuccess = service.add(sf);
		if (isSuccess) {
			request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("/ServiceFacility.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "添加失败");
			request.getRequestDispatcher("/ServiceFacility.jsp").forward(request, response);
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
