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
 * Servlet implementation class ModifyUnitInfo
 */
@WebServlet("/ModifyUnitInfo")
public class ModifyUnitInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUnitInfo() {
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
		if(uis.modify(ui)) {
			response.getWriter().write("�޸ĳɹ�<a href=\"QueryUnitInfo.jsp\">������ز�ѯ</a>");
		}else {
			response.getWriter().write("�޸�ʧ��<a href=\"QueryUnitInfo.jsp\">������ز�ѯ</a>");
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
