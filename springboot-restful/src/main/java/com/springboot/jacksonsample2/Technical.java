package com.springboot.jacksonsample2;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("technical")
public class Technical extends Department {
	/**
	 * @param exp
	 * @param technicalDegree
	 */
	public Technical(String technicalDegree) {
		super();
		this.technicalDegree = technicalDegree;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Technical [technicalDegree=" + technicalDegree + "]";
	}

	String technicalDegree;

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
