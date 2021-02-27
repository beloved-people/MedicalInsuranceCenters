package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.dao.implement.OperatorDaoImpl;
import com.neuedu.entity.OperatorInfo;
import com.neuedu.service.implement.OperatorServiceImpl;

/**
 * Servlet implementation class OperatorModifyServlet
 */
@WebServlet("/OperatorModifyServlet")
public class OperatorModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperatorModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("operatorId"));
		String jobNumber = request.getParameter("jobNumber");
		String operatorAccount = request.getParameter("operatorAccount");
		String operatorName = request.getParameter("operatorName");
		String operatorGender = request.getParameter("operatorGender");
		String operatorPwd = request.getParameter("operatorPwd");
		OperatorServiceImpl odi = new OperatorServiceImpl();
		OperatorInfo o = new OperatorInfo();
		o.setOperatorId(id);
		o.setJobNumber(jobNumber);
		o.setOperatorAccount(operatorAccount);
		o.setOperatorName(operatorName);
		o.setOperatorGender(operatorGender);
		o.setOperatorPwd(operatorPwd);
		boolean isSuccess = odi.modify(o);
		if (isSuccess) {
			request.setAttribute("msg", "修改成功");
			request.getRequestDispatcher("/OperatorSelf").forward(request, response);
		}else {
			request.setAttribute("msg", "修改失败");
			request.getRequestDispatcher("/OperatorSelf").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int operatorId = Integer.parseInt(request.getParameter("operatorId"));
		String operatorAccount = request.getParameter("operatorAccount");
		String operatorName = request.getParameter("operatorName");
		String operatorGender=request.getParameter("operatorGender");
		String jobNumber = request.getParameter("jobNumber");
		String operatorPwd = request.getParameter("operatorPwd");
		
		OperatorInfo operator = new OperatorInfo();
		operator.setOperatorId(operatorId);
		operator.setOperatorAccount(operatorAccount);
		operator.setOperatorName(operatorName);
		operator.setOperatorGender(operatorGender);
		operator.setJobNumber(jobNumber);
		operator.setOperatorPwd(operatorPwd);
		OperatorDaoImpl odi = new OperatorDaoImpl();
		odi.modify(operator);
		doGet(request, response);
	}

}
