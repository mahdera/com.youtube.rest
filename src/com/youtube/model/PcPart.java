/**
 * 
 */
package com.youtube.model;

/**
 * @author Mahder on macbook Pro
 *
 */
public class PcPart {
	private int pcPartsId;
	private String pcPartsTitle;
	private String pcPartsCode;
	private String pcPartsMaker;
	private int pcPartsAvail;
	private String pcPartsDesc;
	/**
	 * 
	 */
	public PcPart() {
	}
	/**
	 * @param pcPartsTitle
	 * @param pcPartsCode
	 * @param pcPartsMaker
	 * @param pcPartsAvail
	 * @param pcPartsDesc
	 */
	public PcPart(String pcPartsTitle, String pcPartsCode,
			String pcPartsMaker, int pcPartsAvail, String pcPartsDesc) {
		this.pcPartsTitle = pcPartsTitle;
		this.pcPartsCode = pcPartsCode;
		this.pcPartsMaker = pcPartsMaker;
		this.pcPartsAvail = pcPartsAvail;
		this.pcPartsDesc = pcPartsDesc;
	}
	/**
	 * @param pcPartsId
	 * @param pcPartsTitle
	 * @param pcPartsCode
	 * @param pcPartsMaker
	 * @param pcPartsAvail
	 * @param pcPartsDesc
	 */
	public PcPart(int pcPartsId, String pcPartsTitle, String pcPartsCode,
			String pcPartsMaker, int pcPartsAvail, String pcPartsDesc) {
		this.pcPartsId = pcPartsId;
		this.pcPartsTitle = pcPartsTitle;
		this.pcPartsCode = pcPartsCode;
		this.pcPartsMaker = pcPartsMaker;
		this.pcPartsAvail = pcPartsAvail;
		this.pcPartsDesc = pcPartsDesc;
	}
	/**
	 * @return the pcPartsId
	 */
	public int getPcPartsId() {
		return pcPartsId;
	}
	/**
	 * @param pcPartsId the pcPartsId to set
	 */
	public void setPcPartsId(int pcPartsId) {
		this.pcPartsId = pcPartsId;
	}
	/**
	 * @return the pcPartsTitle
	 */
	public String getPcPartsTitle() {
		return pcPartsTitle;
	}
	/**
	 * @param pcPartsTitle the pcPartsTitle to set
	 */
	public void setPcPartsTitle(String pcPartsTitle) {
		this.pcPartsTitle = pcPartsTitle;
	}
	/**
	 * @return the pcPartsCode
	 */
	public String getPcPartsCode() {
		return pcPartsCode;
	}
	/**
	 * @param pcPartsCode the pcPartsCode to set
	 */
	public void setPcPartsCode(String pcPartsCode) {
		this.pcPartsCode = pcPartsCode;
	}
	/**
	 * @return the pcPartsMaker
	 */
	public String getPcPartsMaker() {
		return pcPartsMaker;
	}
	/**
	 * @param pcPartsMaker the pcPartsMaker to set
	 */
	public void setPcPartsMaker(String pcPartsMaker) {
		this.pcPartsMaker = pcPartsMaker;
	}
	/**
	 * @return the pcPartsAvail
	 */
	public int getPcPartsAvail() {
		return pcPartsAvail;
	}
	/**
	 * @param pcPartsAvail the pcPartsAvail to set
	 */
	public void setPcPartsAvail(int pcPartsAvail) {
		this.pcPartsAvail = pcPartsAvail;
	}
	/**
	 * @return the pcPartsDesc
	 */
	public String getPcPartsDesc() {
		return pcPartsDesc;
	}
	/**
	 * @param pcPartsDesc the pcPartsDesc to set
	 */
	public void setPcPartsDesc(String pcPartsDesc) {
		this.pcPartsDesc = pcPartsDesc;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pcPartsAvail;
		result = prime * result
				+ ((pcPartsCode == null) ? 0 : pcPartsCode.hashCode());
		result = prime * result
				+ ((pcPartsDesc == null) ? 0 : pcPartsDesc.hashCode());
		result = prime * result + pcPartsId;
		result = prime * result
				+ ((pcPartsMaker == null) ? 0 : pcPartsMaker.hashCode());
		result = prime * result
				+ ((pcPartsTitle == null) ? 0 : pcPartsTitle.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PcPart other = (PcPart) obj;
		if (pcPartsAvail != other.pcPartsAvail)
			return false;
		if (pcPartsCode == null) {
			if (other.pcPartsCode != null)
				return false;
		} else if (!pcPartsCode.equals(other.pcPartsCode))
			return false;
		if (pcPartsDesc == null) {
			if (other.pcPartsDesc != null)
				return false;
		} else if (!pcPartsDesc.equals(other.pcPartsDesc))
			return false;
		if (pcPartsId != other.pcPartsId)
			return false;
		if (pcPartsMaker == null) {
			if (other.pcPartsMaker != null)
				return false;
		} else if (!pcPartsMaker.equals(other.pcPartsMaker))
			return false;
		if (pcPartsTitle == null) {
			if (other.pcPartsTitle != null)
				return false;
		} else if (!pcPartsTitle.equals(other.pcPartsTitle))
			return false;
		return true;
	}
	
	
}//end class
