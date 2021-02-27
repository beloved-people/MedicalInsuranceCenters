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
 * Servlet implementation class AddUnitInfo
 */
@WebServlet("/AddUnitInfo")
public class AddUnitInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUnitInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scompanyCode = request.getParameter("companyCode");
		long companyCode = Long.parseLong(scompanyCode);
		String companyName = request.getParameter("companyName");
		String icompanyType = request.getParameter("companyType");
		int companyType = Integer.parseInt(icompanyType);
		String companyAddress = request.getParameter("companyAddress");
		String companyPostcode = request.getParameter("companyPostcode");
		String companyContactNumber = request.getParameter("companyContactNumber");
		UnitInfo4 ui = new UnitInfo4(companyCode,companyName,companyType,companyAddress,companyPostcode,companyContactNumber);
		UnitInfoService uis = new UnitInfoServiceImpl();
		boolean isSuccess = uis.add(ui);
		if(isSuccess) {
			request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("/AddUnitInfo.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "添加失败");
			request.getRequestDispatcher("/AddUnitInfo.jsp").forward(request, response);
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
