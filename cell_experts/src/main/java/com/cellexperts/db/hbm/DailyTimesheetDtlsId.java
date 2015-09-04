package com.cellexperts.db.hbm;

// Generated Sep 3, 2015 2:22:26 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * DailyTimesheetDtlsId generated by hbm2java
 */
public class DailyTimesheetDtlsId implements java.io.Serializable {

	private int employeeId;
	private Date todayDt;
	private Date weekendDt;

	public DailyTimesheetDtlsId() {
	}

	public DailyTimesheetDtlsId(int employeeId, Date todayDt, Date weekendDt) {
		this.employeeId = employeeId;
		this.todayDt = todayDt;
		this.weekendDt = weekendDt;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getTodayDt() {
		return this.todayDt;
	}

	public void setTodayDt(Date todayDt) {
		this.todayDt = todayDt;
	}

	public Date getWeekendDt() {
		return this.weekendDt;
	}

	public void setWeekendDt(Date weekendDt) {
		this.weekendDt = weekendDt;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DailyTimesheetDtlsId))
			return false;
		DailyTimesheetDtlsId castOther = (DailyTimesheetDtlsId) other;

		return (this.getEmployeeId() == castOther.getEmployeeId())
				&& ((this.getTodayDt() == castOther.getTodayDt()) || (this
						.getTodayDt() != null && castOther.getTodayDt() != null && this
						.getTodayDt().equals(castOther.getTodayDt())))
				&& ((this.getWeekendDt() == castOther.getWeekendDt()) || (this
						.getWeekendDt() != null
						&& castOther.getWeekendDt() != null && this
						.getWeekendDt().equals(castOther.getWeekendDt())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getEmployeeId();
		result = 37 * result
				+ (getTodayDt() == null ? 0 : this.getTodayDt().hashCode());
		result = 37 * result
				+ (getWeekendDt() == null ? 0 : this.getWeekendDt().hashCode());
		return result;
	}

}
