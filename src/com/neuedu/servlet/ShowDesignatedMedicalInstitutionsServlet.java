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


@WebServlet("/ShowDesignatedMedicalInstitutionsServlet")
public class ShowDesignatedMedicalInstitutionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDesignatedMedicalInstitutionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        DesignatedMedicalInstitutionsService designatedMedicalInstitutionsService = new DesignatedMedicalInstitutionsServiceImpl();
        PageBean<DesignatedMedicalInstitutionsInfo> pb = designatedMedicalInstitutionsService.findByPageBean(currentPage, rows, condition);
        //��PageBean����request
        request.setAttribute("pb", pb);
        request.setAttribute("condition",condition);
        //ת����list.jsp
        request.getRequestDispatcher("/ShowDesignatedMedicalInstitutions.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
