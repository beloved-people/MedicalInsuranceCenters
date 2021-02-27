package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.PageBean4;
import com.neuedu.entity.UnitInfo4;
import com.neuedu.service.UnitInfoService;
import com.neuedu.service.implement.UnitInfoServiceImpl;




/**
 * Servlet implementation class Paging
 */
@WebServlet("/Paging")
public class UnitInfoPaging extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnitInfoPaging() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currPage = request.getParameter("currentPage");//获取当前页参数，第一次为null
		//判断
		if(currPage == null || "".equals(currPage.trim())) {
			currPage = "1";
		}
		//创建PageBean对象
		UnitInfoService uis = new UnitInfoServiceImpl();
		int currentPage = Integer.parseInt(currPage);
		PageBean4<UnitInfo4> pageBean = new PageBean4<UnitInfo4>();
		pageBean.setTotalCount(uis.getTotalCount());
		pageBean.setCurrentPage(currentPage);
		
		uis.getAll(pageBean);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/QueryUnitInfo.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
