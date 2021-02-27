package com.neuedu.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.PageBean;
import com.neuedu.entity.ServiceFacilityInfo;
import com.neuedu.service.ServiceFacilityService;
import com.neuedu.service.implement.ServiceFacilityServiceImpl;


@WebServlet("/UpdateServiceFacilityServlet")
public class UpdateServiceFacilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServiceFacilityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		boolean isSuccess = service.update(sf);
		//��ȡ����
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        //�п�
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        //��ȡ������ѯ����
        Map<String, String[]> condition = null;
        //����service����
        ServiceFacilityService serviceFacility = new ServiceFacilityServiceImpl();
        PageBean<ServiceFacilityInfo> pb = serviceFacility.findByPageBean(currentPage, rows, condition);
        //��PageBean����request
        request.setAttribute("pb", pb);
        request.setAttribute("condition",condition);
		if (isSuccess) {
			request.setAttribute("msgs", "�޸ĳɹ�");
			 request.getRequestDispatcher("/ShowServiceFacility.jsp").forward(request, response);
		}else {
			request.setAttribute("msgs", "�޸�ʧ��");
			 request.getRequestDispatcher("/ShowServiceFacility.jsp").forward(request, response);
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
