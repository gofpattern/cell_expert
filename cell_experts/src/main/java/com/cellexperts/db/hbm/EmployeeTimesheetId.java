package com.cellexperts.db.hbm;

// Generated Sep 3, 2015 2:22:26 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * EmployeeTimesheetId generated by hbm2java
 */
public class EmployeeTimesheetId implements java.io.Serializable {

	private int employeeId;
	private Date weekendDt;

	public EmployeeTimesheetId() {
	}

	public EmployeeTimesheetId(int employeeId, Date weekendDt) {
		this.employeeId = employeeId;
		this.weekendDt = weekendDt;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
		if (!(other instanceof EmployeeTimesheetId))
			return false;
		EmployeeTimesheetId castOther = (EmployeeTimesheetId) other;

		return (this.getEmployeeId() == castOther.getEmployeeId())
				&& ((this.getWeekendDt() == castOther.getWeekendDt()) || (this
						.getWeekendDt() != null
						&& castOther.getWeekendDt() != null && this
						.getWeekendDt().equals(castOther.getWeekendDt())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getEmployeeId();
		result = 37 * result
				+ (getWeekendDt() == null ? 0 : this.getWeekendDt().hashCode());
		return result;
	}

}