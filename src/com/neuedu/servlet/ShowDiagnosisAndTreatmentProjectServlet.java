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

@WebServlet("/ShowDiagnosisAndTreatmentProjectServlet")
public class ShowDiagnosisAndTreatmentProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowDiagnosisAndTreatmentProjectServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("projectName")==null||"".equals(request.getParameter("projectName"))){
			String projectName = request.getParameter("projectName");
			request.setAttribute("projectName", java.net.URLDecoder.decode(projectName, "UTF-8"));
		}
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
        Map<String, String[]> condition = request.getParameterMap();
        //����service����
        DiagnosisAndTreatmentProjectServiceImpl projectService = new DiagnosisAndTreatmentProjectServiceImpl();
        PageBean<DiagnosisAndTreatmentProjectInfo> pb = projectService.findDiagnosisAndTreatmentProjectByPage(currentPage, rows, condition);
        //��PageBean����request
        request.setAttribute("pb", pb);
        request.setAttribute("condition",condition);
        //ת����list.jsp
        request.getRequestDispatcher("/DiagnosisAndTreatmentProject.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
