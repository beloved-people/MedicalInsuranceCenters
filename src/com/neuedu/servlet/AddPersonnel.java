package com.neuedu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.PersonInfo4;
import com.neuedu.service.PersonInfoService;
import com.neuedu.service.implement.PersonInfoServiceImpl;
import com.neuedu.utils.reverse.GetUUID;


/**
 * Servlet implementation class User
 */
@WebServlet("/AddPersonnel")
public class AddPersonnel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonnel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personID = GetUUID.getUUID();		
		String certificateID = request.getParameter("certificateID");
		String certificateNumber = request.getParameter("certificateNumber");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String nationID = request.getParameter("nationID");
		String birthdate = request.getParameter("birthdate");
		String participationDate = request.getParameter("participationDate");
		String retirementDate = request.getParameter("retirementDate");
		
		String retirementStatus1 = request.getParameter("retirementStatus");
		int retirementStatus = Integer.parseInt(retirementStatus1);
		
		String accountNature1 = request.getParameter("accountNature");
		int accountNature = Integer.parseInt(accountNature1);
		
		String accountLocation = request.getParameter("accountLocation");
		String degreeID = request.getParameter("degreeID");
		String outlookID = request.getParameter("outlookID");
		
		String identity1 = request.getParameter("identity");
		int identity = Integer.parseInt(identity1);
		
		String employmentForm1 = request.getParameter("employmentForm");
		int employmentForm = Integer.parseInt(employmentForm1);
		
		String specializedTechnicalJob1 = request.getParameter("specializedTechnicalJob");
		int specializedTechnicalJob = Integer.parseInt(specializedTechnicalJob1);
		
		String NVQL1 = request.getParameter("NVQL");
		int NVQL = Integer.parseInt(NVQL1); 
		
		String maritalStatus1 = request.getParameter("maritalStatus");
		int maritalStatus = Integer.parseInt(maritalStatus1);
		String dutyID = request.getParameter("dutyID");
		String remarks = request.getParameter("remarks");
		
		String companyCode1 = request.getParameter("companyCode");
		long companyCode = Long.parseLong(companyCode1);
		
		String personnelCategoryID = request.getParameter("personnelCategoryID");
		String healthStatus1 = request.getParameter("healthStatus");
		int healthStatus = Integer.parseInt(healthStatus1);
		String lamorSign1 = request.getParameter("lamorSign");
		int lamorSign = Integer.parseInt(lamorSign1);
		String cadreSign1 = request.getParameter("cadreSign");
		int cadreSign = Integer.parseInt(cadreSign1);
		String civilServantSign1 = request.getParameter("civilServantSign");
		int civilServantSign = Integer.parseInt(civilServantSign1);
		String establishmentSign1 = request.getParameter("establishmentSign");
		int establishmentSign = Integer.parseInt(establishmentSign1);
		String residentSign1 = request.getParameter("residentSign");
		int residentSign = Integer.parseInt(residentSign1);
		String flexibleEmploymentSign1 = request.getParameter("flexibleEmploymentSign");
		int flexibleEmploymentSign = Integer.parseInt(flexibleEmploymentSign1);
		String migrantWorkerSign1 = request.getParameter("migrantWorkerSign");
		int migrantWorkerSign = Integer.parseInt(migrantWorkerSign1);
		String employerSign1 = request.getParameter("employerSign");
		int employerSign = Integer.parseInt(employerSign1);
		String militaryPersonnelSign1 = request.getParameter("militaryPersonnelSign");
		int militaryPersonnelSign = Integer.parseInt(militaryPersonnelSign1);
		String socialSecurityNumber = request.getParameter("certificateNumber");
		String designatedMedicalInstitutionCode1 = request.getParameter("designatedMedicalInstitutionCode");
		long designatedMedicalInstitutionCode = Long.parseLong(designatedMedicalInstitutionCode1);

		PersonInfoService pis = new PersonInfoServiceImpl();
		PersonInfo4 pi = new PersonInfo4(personID,certificateID,certificateNumber,name,gender,nationID,birthdate,participationDate,
                retirementDate,retirementStatus,accountNature,accountLocation,degreeID,outlookID,
                identity,employmentForm,specializedTechnicalJob,NVQL,maritalStatus,dutyID,
                remarks,companyCode,personnelCategoryID,healthStatus,lamorSign,cadreSign,civilServantSign,
                establishmentSign,residentSign,flexibleEmploymentSign, migrantWorkerSign,employerSign,
                militaryPersonnelSign,  socialSecurityNumber,
                designatedMedicalInstitutionCode);
		if(pis.add(pi)) {
			request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("/AddPersonnel.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "添加失败");
			request.getRequestDispatcher("/AddPersonnel.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
