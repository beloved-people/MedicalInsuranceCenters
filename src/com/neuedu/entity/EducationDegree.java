package com.neuedu.entity;

public class EducationDegree {
	private String degreeId;
	  private String degreeName;
	public EducationDegree() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EducationDegree(String degreeId, String degreeName) {
		super();
		this.degreeId = degreeId;
		this.degreeName = degreeName;
	}
	public String getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	  
	  
}
