package com.neuedu.servlet.lilongx;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.dao.CompanyInfoDao;
import com.neuedu.dao.CompanyInfoDaoImpl;
import com.neuedu.dao.DesignatedMedicalInstitutionsDao;
import com.neuedu.dao.PersonInfoDao;
import com.neuedu.dao.PersonnelVisitInformationDao1;
import com.neuedu.dao.implement.DesignatedMedicalInstitutionsDaoImpl;
import com.neuedu.dao.implement.PersonInfoDaoImpl4;
import com.neuedu.dao.implement.PersonnelVisitInformationDaoImpl;
import com.neuedu.entity.Chufang;
import com.neuedu.entity.CompanyInfo;
import com.neuedu.entity.DesignatedMedicalInstitutionsInfo;
import com.neuedu.entity.PersonInfo;
import com.neuedu.entity.PersonnelVisitInformation;
import com.neuedu.service.implement.Chufangservice;
import com.neuedu.service.implement.Chufangservice3;
import com.neuedu.service.implement.DaxiaoImpl;

@WebServlet("/Dayin")
public class Dayin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Dayin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String person= request.getParameter("DC"); 
		Chufangservice chu=new Chufangservice();
		chu.person(person);
		List<Chufang> chu1=chu.chulist1;
		List<Chufang> chu2=chu.chulist2;
		List<Chufang> chu3=chu.chulist3;
		Chufangservice3 chufang=new Chufangservice3();
		chufang.person(person);
		double bao1=chufang.getBao2();//报销金额
		double zi1=chufang.getZi2();//自费金额
		request.setAttribute("bao1",bao1);
		request.setAttribute("zi1",zi1);		
	    request.setAttribute("chu1",chu1);
	    request.setAttribute("chu2",chu2);
	    request.setAttribute("chu3",chu3);    
	    PersonInfoDao per1=new PersonInfoDaoImpl4();
	    PersonInfo pers=per1.selName(person);
	    request.setAttribute("pers",pers);
	    CompanyInfoDao com=new CompanyInfoDaoImpl();
	    CompanyInfo com1=com.selcom(pers.getCompanyCode());
	    request.setAttribute("com1",com1);
	    PersonnelVisitInformationDao1 vis=new PersonnelVisitInformationDaoImpl();
	    PersonnelVisitInformation vis1=vis.selperID(person);
	    request.setAttribute("vis1",vis1);
	    DesignatedMedicalInstitutionsDao des=new DesignatedMedicalInstitutionsDaoImpl();
	    DesignatedMedicalInstitutionsInfo des1=des.sel(vis1.getDesignatedMedicalInstitutionCode());
	    request.setAttribute("des1",des1);
	    String str=DaxiaoImpl.toChinese(bao1);
	    request.setAttribute("str",str);
	    request.getRequestDispatcher("/PrintList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
