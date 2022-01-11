package com.eps.pojo;

public class DrugPojo {
	private int drugId;
	private String drugName;
	private int drugNdc;
	private int drugQty;
	
	
	public DrugPojo() {
		super();
	}
	
	public int getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public int getDrugNdc() {
		return drugNdc;
	}
	public void setDrugNdc(int drugNdc) {
		this.drugNdc = drugNdc;
	}
	public int getDrugQty() {
		return drugQty;
	}
	public void setDrugQty(int drugQty) {
		this.drugQty = drugQty;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + drugId;
		result = prime * result + ((drugName == null) ? 0 : drugName.hashCode());
		result = prime * result + drugNdc;
		result = prime * result + drugQty;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DrugPojo other = (DrugPojo) obj;
		if (drugId != other.drugId)
			return false;
		if (drugName == null) {
			if (other.drugName != null)
				return false;
		} else if (!drugName.equals(other.drugName))
			return false;
		if (drugNdc != other.drugNdc)
			return false;
		if (drugQty != other.drugQty)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DrugPojo [drugId=" + drugId + ", drugName=" + drugName + ", drugNdc=" + drugNdc + ", drugQty=" + drugQty
				+ "]";
	}
	
	
}
