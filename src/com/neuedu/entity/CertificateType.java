package com.neuedu.entity;

public class CertificateType {
	private String certificateId;
	  private String certificateName;
	public CertificateType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CertificateType(String certificateId, String certificateName) {
		super();
		this.certificateId = certificateId;
		this.certificateName = certificateName;
	}
	public String getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}
	public String getCertificateName() {
		return certificateName;
	}
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	  
	  
}
