package com.springboot.jackonsample;

public class Finance implements iDepartment {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Finance [exp=" + exp + ", financeDegree=" + financeDegree + "]";
	}

	/**
	 * @param exp
	 * @param financeDegree
	 */
	public Finance(String exp, String financeDegree) {
		super();
		this.exp = exp;
		this.financeDegree = financeDegree;
	}

	String exp;
	String financeDegree;

	/**
	 * @return the financeDegree
	 */
	public String getFinanceDegree() {
		return financeDegree;
	}

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
	 * @param financeDegree
	 *            the financeDegree to set
	 */
	public void setFinanceDegree(String financeDegree) {
		this.financeDegree = financeDegree;
	}
}
