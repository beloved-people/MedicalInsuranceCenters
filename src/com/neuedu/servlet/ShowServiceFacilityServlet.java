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

@WebServlet("/ShowServiceFacilityServlet")
public class ShowServiceFacilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowServiceFacilityServlet() {
        super();
    }

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
        ServiceFacilityService serviceFacility = new ServiceFacilityServiceImpl();
        PageBean<ServiceFacilityInfo> pb = serviceFacility.findByPageBean(currentPage, rows, condition);
        //��PageBean����request
        request.setAttribute("pb", pb);
        request.setAttribute("condition",condition);
        //ת����list.jsp
        request.getRequestDispatcher("/ShowServiceFacility.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
