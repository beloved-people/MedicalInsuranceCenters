package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.PageBean4;
import com.neuedu.entity.PersonInfo4;
import com.neuedu.service.PersonInfoService;
import com.neuedu.service.implement.PersonInfoServiceImpl;




/**
 * Servlet implementation class Paging
 */
@WebServlet("/PersonInfoPaging")
public class PersonInfoPaging extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonInfoPaging() {
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
		PersonInfoService pis = new PersonInfoServiceImpl();
		int currentPage = Integer.parseInt(currPage);
		PageBean4<PersonInfo4> pageBean = new PageBean4<PersonInfo4>();
		pageBean.setTotalCount(pis.getTotalCount());
		pageBean.setCurrentPage(currentPage);
		pis.getAll(pageBean);
		request.setAttribute("pageBean1", pageBean);
		request.getRequestDispatcher("/QueryPersonnel.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
