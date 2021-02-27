package com.neuedu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.dao.implement.DrugInfoDaoImpl;
import com.neuedu.entity.DrugInfo;

/**
 * Servlet implementation class DrugInfoModfiyServlt
 */
@WebServlet("/DrugInfoModfiyServlt")
public class DrugInfoModfiyServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrugInfoModfiyServlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String dcStr = request.getParameter("dc");
	   long dc = Long.parseLong(dcStr);
	   DrugInfoDaoImpl ddi = new DrugInfoDaoImpl();
	   DrugInfo di = ddi.getbydc(dc);
	   boolean isSuccess = ddi.modify(di);
	   if (isSuccess) {
		   request.setAttribute("msg", "修改成功");
		   request.getRequestDispatcher("/DrugInfo2.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "修改失败");
			request.getRequestDispatcher("/DrugInfo2.jsp").forward(request, response);
		}
	   
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    long dc = Long.parseLong(request.getParameter("dc"));
		  
		    String medicineName = request.getParameter("medicineName");
		    System.out.println(123);
		    String medicineEnglishName = request.getParameter("medicineEnglishName");
		    int chargeCategory = Integer.parseInt(request.getParameter("chargeCategory"));
		    int prescriptionDrugMark = Integer.parseInt(request.getParameter("prescriptionDrugMark"));
		    int chargingItemLevel = Integer.parseInt(request.getParameter("chargingItemLevel"));
		    int drugDosageUnit = Integer.parseInt(request.getParameter("drugDosageUnit"));
		    double maximumPrice = Double.parseDouble(request.getParameter("maximumPrice"));
		    int inHospitalPreparationMark = Integer.parseInt(request.getParameter("inHospitalPreparationMark"));
		    String approvalMarkRequired = request.getParameter("approvalMarkRequired");
		    int hospitalLevel = Integer.parseInt(request.getParameter("hospitalLevel"));
		    String dosageFormId = request.getParameter("dosageFormId");
		    String usageFrequencyId = request.getParameter("usageFrequencyId");
		    String usageId = request.getParameter("usageId");
		    int unit = Integer.parseInt(request.getParameter("unit"));
		    String specification = request.getParameter("specification");
		    int limitedDays = Integer.parseInt(request.getParameter("limitedDays"));
		    String drugTradeName = request.getParameter("drugTradeName");
			String pharmaceuticalFactory = request.getParameter("pharmaceuticalFactory");
			String chineseMedicineQuasiCharacter = request.getParameter("chineseMedicineQuasiCharacter");
			String remarks = request.getParameter("remarks");
			String nationalCatalogCode = request.getParameter("nationalCatalogCode");
			String restrictedUsingScope = request.getParameter("restrictedUsingScope");
			String placeOfProduction = request.getParameter("placeOfProduction");
		
			DrugInfo drug = new DrugInfo();
			drug.setDc(dc);
			drug.setMedicineName(medicineName);
			drug.setMedicineEnglishName(medicineEnglishName);
			drug.setChargeCategory(chargeCategory);
			drug.setPrescriptionDrugMark(prescriptionDrugMark);
			drug.setChargingItemLevel(chargingItemLevel);
			drug.setDrugDosageUnit(drugDosageUnit);
			drug.setMaximumPrice(maximumPrice);
			drug.setInHospitalPreparationMark(inHospitalPreparationMark);
			drug.setApprovalMarkRequired(approvalMarkRequired);
			drug.setHospitalLevel(hospitalLevel);
			drug.setDosageFormId(dosageFormId);
			drug.setUsageFrequencyId(usageFrequencyId);
			drug.setUsageId(usageId);
			drug.setUnit(unit);
			drug.setSpecification(specification);
			drug.setLimitedDays(limitedDays);
			drug.setDrugTradeName(drugTradeName);
			drug.setPharmaceuticalFactory(pharmaceuticalFactory);
			drug.setChineseMedicineQuasiCharacter(chineseMedicineQuasiCharacter);
			drug.setRemarks(remarks);
			drug.setNationalCatalogCode(nationalCatalogCode);
			drug.setRestrictedUsingScope(restrictedUsingScope);
			drug.setPlaceOfProduction(placeOfProduction);
			DrugInfoDaoImpl ddi = new DrugInfoDaoImpl();
			ddi.modify(drug);
			request.getRequestDispatcher("/DrugInfo1Servlet").forward(request, response);
	}

}
