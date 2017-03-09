package bch.jpmrgn.entity;

import java.io.Serializable;

public class Currency implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 359326436495147499L;
	public Currency(String code, int startWorkingDay, int endWorkingDay) {
		super();
		this.code = code;
		this.startWorkingDay = startWorkingDay;
		this.endWorkingDay = endWorkingDay;
	}
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getStartWorkingDay() {
		return startWorkingDay;
	}
	public void setStartWorkingDay(int startWorkingDay) {
		this.startWorkingDay = startWorkingDay;
	}
	public int getEndWorkingDay() {
		return endWorkingDay;
	}
	public void setEndWorkingDay(int endWorkingDay) {
		this.endWorkingDay = endWorkingDay;
	}
	private int startWorkingDay, endWorkingDay;

}
