package com.springboot.jacksonsample2;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("finance")
public class Finance extends Department {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Finance [financeDegree=" + financeDegree + "]";
	}

	/**
	 * @param exp
	 * @param financeDegree
	 */
	public Finance(String financeDegree) {
		super();
		this.financeDegree = financeDegree;
	}

	String financeDegree;

	/**
	 * @return the financeDegree
	 */
	public String getFinanceDegree() {
		return financeDegree;
	}

	/**
	 * @param financeDegree
	 *            the financeDegree to set
	 */
	public void setFinanceDegree(String financeDegree) {
		this.financeDegree = financeDegree;
	}
}