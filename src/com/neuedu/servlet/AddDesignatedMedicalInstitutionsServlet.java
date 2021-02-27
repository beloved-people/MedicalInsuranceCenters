package com.neuedu.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.DesignatedMedicalInstitutionsInfo;
import com.neuedu.entity.PageBean;
import com.neuedu.service.DesignatedMedicalInstitutionsService;
import com.neuedu.service.implement.DesignatedMedicalInstitutionsServiceImpl;

/**
 * Servlet implementation class AddDesignatedMedicalInstitutionsServlet
 */
@WebServlet("/AddDesignatedMedicalInstitutionsServlet")
public class AddDesignatedMedicalInstitutionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDesignatedMedicalInstitutionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long designatedMedicalInstitutionCode = Long.parseLong(request.getParameter("designatedMedicalInstitutionCode"));
		String serviceOrganizationName = request.getParameter("serviceOrganizationName");
		int hospitalLevel = Integer.parseInt(request.getParameter("hospitalLevel"));
		String medicalInstitutionTypeID = request.getParameter("medicalInstitutionTypeID");
		String postcode = request.getParameter("postcode");
		String legalRepresentativeName = request.getParameter("legalRepresentativeName");
		String legalRepresentativeCellphoneNumber = request.getParameter("legalRepresentativeCellphoneNumber");
		String concatName = request.getParameter("concatName");
		String contactNumber = request.getParameter("contactNumber");
		String concatCellphoneNumber = request.getParameter("concatCellphoneNumber");
		String address = request.getParameter("address");
		String remarks = request.getParameter("remarks");
		DesignatedMedicalInstitutionsService des = new DesignatedMedicalInstitutionsServiceImpl();
		DesignatedMedicalInstitutionsInfo d = new DesignatedMedicalInstitutionsInfo(designatedMedicalInstitutionCode,
				serviceOrganizationName,hospitalLevel,medicalInstitutionTypeID,postcode,legalRepresentativeName,
				legalRepresentativeCellphoneNumber,concatName,contactNumber,concatCellphoneNumber,
				address,remarks);
		boolean isSuccess = des.add(d);
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
        DesignatedMedicalInstitutionsService designatedMedicalInstitutionsService = new DesignatedMedicalInstitutionsServiceImpl();
        PageBean<DesignatedMedicalInstitutionsInfo> pb = designatedMedicalInstitutionsService.findByPageBean(currentPage, rows, condition);
        //��PageBean����request
        request.setAttribute("pb", pb);
		if (isSuccess) {
			request.setAttribute("msg", "���ӳɹ�");
			request.getRequestDispatcher("/DesignatedMedicalInstitutions.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "����ʧ��");
			request.getRequestDispatcher("/DesignatedMedicalInstitutions.jsp").forward(request, response);
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