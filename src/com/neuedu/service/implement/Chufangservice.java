package com.neuedu.service.implement;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.DiagnosisAndTreatmentProjectDao;
import com.neuedu.dao.DrugInfoDao;
import com.neuedu.dao.PersonnelVisitInformationDao1;
import com.neuedu.dao.PrescriptionDetailsDao1;
import com.neuedu.dao.implement.DiagnosisAndTreatmentProjectDaoImpl;
import com.neuedu.dao.implement.DrugInfoDaoImpl;
import com.neuedu.dao.implement.PersonnelVisitInformationDaoImpl;
import com.neuedu.dao.implement.PrescriptionDetailsDaoImpl2;
import com.neuedu.entity.Chufang;
import com.neuedu.entity.DiagnosisAndTreatmentProjectInfo;
import com.neuedu.entity.DrugInfo;
import com.neuedu.entity.PersonnelVisitInformation;
import com.neuedu.entity.PrescriptionDetails;

public class Chufangservice {
	 public List<Chufang> chulist1=new ArrayList<Chufang>();
	 public List<Chufang> chulist2=new ArrayList<Chufang>();
	 public List<Chufang> chulist3=new ArrayList<Chufang>();
	public void person(String id) {
		  PersonnelVisitInformationDao1  per=new  PersonnelVisitInformationDaoImpl();//����������Ŀ
		  PersonnelVisitInformation per1=per.selperID(id);//������Աid��ʵ����������Ŀ ����������Ŀ����ֵ
		  per1.getInpatientNumber();//סԺ��
		  per1.getHospitalLevel();//סԺ�ȼ�
		  PrescriptionDetailsDao1 pre=new  PrescriptionDetailsDaoImpl2();//����������Ŀ
		  List<PrescriptionDetails> prelist=pre.selin(per1.getInpatientNumber());//����סԺ�Ų�ѯ������Ϣ
		  for(PrescriptionDetails p:prelist) {//����������
			  String str1=String.valueOf(p.getProjectCode());
				String p2=str1.substring(str1.length()-1);
			    int n=Integer.parseInt(p2);
			    switch(n){
				    case 1:
				    	DrugInfoDao drug=new DrugInfoDaoImpl();
				    	DrugInfo drug1=drug.getbydc(p.getProjectCode());
				    	if(drug1.getHospitalLevel()>per1.getHospitalLevel()) {
				    		Chufang chu=new Chufang(drug1.getDc(),drug1.getMedicineName(),p.getInpatientNumber(),p.getProjectCode(),p.getUnitPrice(),p.getAmount(),p.getSumMoney());
				    		chulist1.add(chu);
				    	}
				    	else if(drug1.getChargeCategory()==3) {
				    		Chufang chu=new Chufang(drug1.getDc(),drug1.getMedicineName(),p.getInpatientNumber(),p.getProjectCode(),p.getUnitPrice(),p.getAmount(),p.getSumMoney());
				    		chulist1.add(chu);
				    	}
				    	else if(drug1.getChargeCategory()==2) {
				    		Chufang chu=new Chufang(drug1.getDc(),drug1.getMedicineName(),p.getInpatientNumber(),p.getProjectCode(),p.getUnitPrice(),p.getAmount(),p.getSumMoney());
				    		chulist2.add(chu);
				    	}
				    	else if(drug1.getChargeCategory()==1) {
				    		Chufang chu=new Chufang(drug1.getDc(),drug1.getMedicineName(),p.getInpatientNumber(),p.getProjectCode(),p.getUnitPrice(),p.getAmount(),p.getSumMoney());
				    		chulist3.add(chu);
				    	}
				    break;
				    case 2:
				    	DiagnosisAndTreatmentProjectDao dia=new DiagnosisAndTreatmentProjectDaoImpl();
				    	DiagnosisAndTreatmentProjectInfo dia1=dia.seldia(p.getProjectCode());
				    	if(dia1.getHospitalLevel()>per1.getHospitalLevel()) {
				    		Chufang chu=new Chufang(dia1.getProjectCode(),dia1.getProjectName(),p.getInpatientNumber(),p.getProjectCode(),p.getUnitPrice(),p.getAmount(),p.getSumMoney());
				    		chulist1.add(chu);
				    	}
				    	else if(dia1.getChargeCategory()==3) {
				    		Chufang chu=new Chufang(dia1.getProjectCode(),dia1.getProjectName(),p.getInpatientNumber(),p.getProjectCode(),p.getUnitPrice(),p.getAmount(),p.getSumMoney());
				    		chulist1.add(chu);
				    	}
				    	else if(dia1.getChargeCategory()==2) {
				    		Chufang chu=new Chufang(dia1.getProjectCode(),dia1.getProjectName(),p.getInpatientNumber(),p.getProjectCode(),p.getUnitPrice(),p.getAmount(),p.getSumMoney());
				    		chulist2.add(chu);
				    	}
				    	else if(dia1.getChargeCategory()==1) {
				    		Chufang chu=new Chufang(dia1.getProjectCode(),dia1.getProjectName(),p.getInpatientNumber(),p.getProjectCode(),p.getUnitPrice(),p.getAmount(),p.getSumMoney());
				    		chulist3.add(chu);
				    	}
				    break;
				    default:
			    }
			    
		  }	  
	}

}
