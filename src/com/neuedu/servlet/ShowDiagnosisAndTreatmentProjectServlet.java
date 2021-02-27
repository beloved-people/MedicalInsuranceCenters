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
		//获取参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        //判空
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        //调用service方法
        DiagnosisAndTreatmentProjectServiceImpl projectService = new DiagnosisAndTreatmentProjectServiceImpl();
        PageBean<DiagnosisAndTreatmentProjectInfo> pb = projectService.findDiagnosisAndTreatmentProjectByPage(currentPage, rows, condition);
        //将PageBean存入request
        request.setAttribute("pb", pb);
        request.setAttribute("condition",condition);
        //转发到list.jsp
        request.getRequestDispatcher("/DiagnosisAndTreatmentProject.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
