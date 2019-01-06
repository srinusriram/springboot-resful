package com.springboot.jackonsample;

public class Technical implements iDepartment {
	/**
	 * @param exp
	 * @param technicalDegree
	 */
	public Technical(String exp, String technicalDegree) {
		super();
		this.exp = exp;
		this.technicalDegree = technicalDegree;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Technical [exp=" + exp + ", technicalDegree=" + technicalDegree + "]";
	}

	String exp;
	String technicalDegree;

	/**
	 * @return the exp
	 */
	public String getExp() {
		return exp;
	}

	/**
	 * @param exp
	 *            the exp to set
	 */
	public void setExp(String exp) {
		this.exp = exp;
	}

	/**
	 * @return the technicalDegree
	 */
	public String getTechnicalDegree() {
		return technicalDegree;
	}

	/**
	 * @param technicalDegree
	 *            the technicalDegree to set
	 */
	public void setTechnicalDegree(String technicalDegree) {
		this.technicalDegree = technicalDegree;
	}

}
