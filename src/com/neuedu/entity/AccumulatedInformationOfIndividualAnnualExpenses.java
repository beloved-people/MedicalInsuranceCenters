package com.neuedu.entity;

public class AccumulatedInformationOfIndividualAnnualExpenses {
	private int id;
	  private String personId;
	  private int annualCumulativeReimbursementTimes;
	  private double annualMedicalExpensesAccumulation;
	  private double reimbursementAccumulationOfMedicalInsuranceCenter;
	  private double individualSelfPaymentAccumulation;
	public AccumulatedInformationOfIndividualAnnualExpenses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccumulatedInformationOfIndividualAnnualExpenses(int id, String personId,
			int annualCumulativeReimbursementTimes, double annualMedicalExpensesAccumulation,
			double reimbursementAccumulationOfMedicalInsuranceCenter, double individualSelfPaymentAccumulation) {
		super();
		this.id = id;
		this.personId = personId;
		this.annualCumulativeReimbursementTimes = annualCumulativeReimbursementTimes;
		this.annualMedicalExpensesAccumulation = annualMedicalExpensesAccumulation;
		this.reimbursementAccumulationOfMedicalInsuranceCenter = reimbursementAccumulationOfMedicalInsuranceCenter;
		this.individualSelfPaymentAccumulation = individualSelfPaymentAccumulation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public int getAnnualCumulativeReimbursementTimes() {
		return annualCumulativeReimbursementTimes;
	}
	public void setAnnualCumulativeReimbursementTimes(int annualCumulativeReimbursementTimes) {
		this.annualCumulativeReimbursementTimes = annualCumulativeReimbursementTimes;
	}
	public double getAnnualMedicalExpensesAccumulation() {
		return annualMedicalExpensesAccumulation;
	}
	public void setAnnualMedicalExpensesAccumulation(double annualMedicalExpensesAccumulation) {
		this.annualMedicalExpensesAccumulation = annualMedicalExpensesAccumulation;
	}
	public double getReimbursementAccumulationOfMedicalInsuranceCenter() {
		return reimbursementAccumulationOfMedicalInsuranceCenter;
	}
	public void setReimbursementAccumulationOfMedicalInsuranceCenter(
			double reimbursementAccumulationOfMedicalInsuranceCenter) {
		this.reimbursementAccumulationOfMedicalInsuranceCenter = reimbursementAccumulationOfMedicalInsuranceCenter;
	}
	public double getIndividualSelfPaymentAccumulation() {
		return individualSelfPaymentAccumulation;
	}
	public void setIndividualSelfPaymentAccumulation(double individualSelfPaymentAccumulation) {
		this.individualSelfPaymentAccumulation = individualSelfPaymentAccumulation;
	}
	  
	  
}
