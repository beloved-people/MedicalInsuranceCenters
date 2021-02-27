package com.neuedu.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.DiagnosisAndTreatmentProjectInfo;
import com.neuedu.entity.PageBean;
import com.neuedu.service.implement.DiagnosisAndTreatmentProjectServiceImpl;

/**
 * Servlet implementation class UpdateDiagnosisAndTreatmentProjectServlet
 */
@WebServlet("/UpdateDiagnosisAndTreatmentProjectServlet")
public class UpdateDiagnosisAndTreatmentProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDiagnosisAndTreatmentProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long projectCode =Long.parseLong(request.getParameter("projectCode")); 
		String projectName = request.getParameter("projectName");
		System.out.println(projectName);
		int chargeCategory =Integer.parseInt(request.getParameter("chargeCategory")); 
		int chargingItemLevel =Integer.parseInt(request.getParameter("chargingItemLevel"));
		int hospitalLevel = Integer.parseInt(request.getParameter("hospitalLevel"));
		String projectUnit = request.getParameter("projectUnit");
		String restrictedProjectUsingScope = request.getParameter("restrictedProjectUsingScope");
		String remarks = request.getParameter("remarks");
		DiagnosisAndTreatmentProjectInfo atpi = new DiagnosisAndTreatmentProjectInfo();
		atpi.setProjectCode(projectCode);
		atpi.setProjectName(projectName);
		atpi.setChargeCategory(chargeCategory);
		atpi.setChargingItemLevel(chargingItemLevel);
		atpi.setHospitalLevel(hospitalLevel);
		atpi.setProjectUnit(projectUnit);
		atpi.setRestrictedProjectUsingScope(restrictedProjectUsingScope);
		atpi.setRemarks(remarks);
		DiagnosisAndTreatmentProjectServiceImpl d = new DiagnosisAndTreatmentProjectServiceImpl();
		boolean isSuccess = d.update(atpi);
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
        DiagnosisAndTreatmentProjectServiceImpl projectService = new DiagnosisAndTreatmentProjectServiceImpl();
        PageBean<DiagnosisAndTreatmentProjectInfo> pb = projectService.findDiagnosisAndTreatmentProjectByPage(currentPage, rows, condition);
        //��PageBean����request
        request.setAttribute("pb", pb);
		if (isSuccess) {
			request.setAttribute("msgs", "�޸ĳɹ�");
			request.getRequestDispatcher("/DiagnosisAndTreatmentProject.jsp").forward(request, response);
		}else {
			request.setAttribute("msgs", "�޸�ʧ��");
			request.getRequestDispatcher("/DiagnosisAndTreatmentProject.jsp").forward(request, response);
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
