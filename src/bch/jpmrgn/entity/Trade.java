package bch.jpmrgn.entity;

import java.io.Serializable;
import java.util.Date;

public class Trade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1940575978447974695L;
	private String entity;
	public Trade(String entity, BuySell flag, Currency currency,
			Date instructionDate, Date settlementDate, float agreedFx,
			int units, float pricePerUnit) {
		super();
		this.entity = entity;
		this.flag = flag;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.agreedFx = agreedFx;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public BuySell getFlag() {
		return flag;
	}
	public void setFlag(BuySell flag) {
		this.flag = flag;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Date getInstructionDate() {
		return instructionDate;
	}
	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	public float getAgreedFx() {
		return agreedFx;
	}
	public void setAgreedFx(float agreedFx) {
		this.agreedFx = agreedFx;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public float getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	private BuySell flag;
	private Currency currency;
	private Date instructionDate, settlementDate;
	private float agreedFx;
	private int units;
	private float pricePerUnit;

}
