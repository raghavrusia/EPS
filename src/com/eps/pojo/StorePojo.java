package com.eps.pojo;

public class StorePojo {
	private int storeId;
	private String storeName;
	private String ncpdpNo;
	
	public StorePojo() {
		super();
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getNcpdpNo() {
		return ncpdpNo;
	}

	public void setNcpdpNo(String ncpdpNo) {
		this.ncpdpNo = ncpdpNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ncpdpNo == null) ? 0 : ncpdpNo.hashCode());
		result = prime * result + storeId;
		result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
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
		StorePojo other = (StorePojo) obj;
		if (ncpdpNo == null) {
			if (other.ncpdpNo != null)
				return false;
		} else if (!ncpdpNo.equals(other.ncpdpNo))
			return false;
		if (storeId != other.storeId)
			return false;
		if (storeName == null) {
			if (other.storeName != null)
				return false;
		} else if (!storeName.equals(other.storeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StorePojo [storeId=" + storeId + ", storeName=" + storeName + ", ncpdpNo=" + ncpdpNo + "]";
	}
	
	
}
