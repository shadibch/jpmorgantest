package bch.jpmrgn.view;

import java.io.Serializable;

public class TradeView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6431472718026333062L;
	private String entity;
	public String getEntity() {
		return entity;
	} 
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public float getSoldAmount() {
		return soldAmount;
	}
	public void setSoldAmount(float soldAmount) {
		this.soldAmount = soldAmount;
	}
	public float getBuyedAmount() {
		return buyedAmount;
	}
	public void setBuyedAmount(float buyedAmount) {
		this.buyedAmount = buyedAmount;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	private float soldAmount,buyedAmount;
	private int rank;

}
