package com.neuedu.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.DiseaseInfo;
import com.neuedu.entity.PageBean;
import com.neuedu.service.DiseaseService;
import com.neuedu.service.implement.DiseaseServiceImpl;

/**
 * Servlet implementation class ShowDisease
 */
@WebServlet("/ShowDisease")
public class ShowDisease extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDisease() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        DiseaseService d = new DiseaseServiceImpl();
        PageBean<DiseaseInfo> pb = d.findByPageBean(currentPage, rows, condition);
        //将PageBean存入request
        request.setAttribute("pb", pb);
        request.setAttribute("condition",condition);
        //转发到list.jsp
        request.getRequestDispatcher("/ShowDisease.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
