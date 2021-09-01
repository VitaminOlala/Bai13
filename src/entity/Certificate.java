package entity;

import java.io.Serializable;

public class Certificate implements Serializable{
	public String getCertificatedID() {
		return CertificatedID;
	}
	public void setCertificatedID(String certificatedID) {
		CertificatedID = certificatedID;
	}
	public String getCertificatedRank() {
		return CertificatedRank;
	}
	public void setCertificatedRank(String certificatedRank) {
		CertificatedRank = certificatedRank;
	}
	public String getCertificatedDate() {
		return CertificatedDate;
	}
	public void setCertificatedDate(String certificatedDate) {
		CertificatedDate = certificatedDate;
	}
	private String CertificatedID;
	private String CertificatedRank;
	private String CertificatedDate;
}
