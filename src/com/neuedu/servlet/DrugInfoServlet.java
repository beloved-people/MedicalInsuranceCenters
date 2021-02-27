package com.neuedu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neuedu.dao.implement.DrugInfoDaoImpl;
import com.neuedu.entity.DrugInfo;

@WebServlet("/DrugInfoServlet")
public class DrugInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DrugInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String st1 = request.getParameter("dc");
		long dc = Long.valueOf(st1);
		System.out.println(dc);
		String medicineName = request.getParameter("medicineName");
		String medicineEnglishName = request.getParameter("medicineEnglishName");
		String st2 = request.getParameter("chargeCategory");
		int chargeCategory = Integer.valueOf(st2);
		String st3 = request.getParameter("prescriptionDrugMark");
		int prescriptionDrugMark = Integer.parseInt(st3);
		String st4 = request.getParameter("chargingItemLevel");
		int chargingItemLevel = Integer.parseInt(st4);
		String st5 = request.getParameter("drugDosageUnit");
		int drugDosageUnit = Integer.parseInt(st5);
		String st6 = request.getParameter("maximumPrice");
		double maximumPrice =  Double.parseDouble(st6);
		String st7 = request.getParameter("inHospitalPreparationMark");
		int inHospitalPreparationMark = Integer.parseInt(st7);
		String approvalMarkRequired = request.getParameter("approvalMarkRequired");
		String st8 = request.getParameter("hospitalLevel");
		int hospitalLevel = Integer.parseInt(st8);
		String dosageFormId = request.getParameter("dosageFormId");
		String usageFrequencyId = request.getParameter("usageFrequencyId");
		String usageId = request.getParameter("usageId");
		String st9 = request.getParameter("unit");
		int unit = Integer.parseInt(st9);
		String specification = request.getParameter("specification");
		String st10 = request.getParameter("limitedDays");
		int limitedDays = Integer.parseInt(st10);
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
	    boolean isSuccess = ddi.add(drug);
		if(isSuccess){
			request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("/DrugInfo1Servlet").forward(request, response);
		} else{
			request.setAttribute("msg", "添加失败");
			request.getRequestDispatcher("/DrugInfo1Servlet").forward(request, response);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
