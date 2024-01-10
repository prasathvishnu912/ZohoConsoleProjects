package com.zsgs.travels.empleave;

import com.zsgs.travels.Employee;

public class EmpLeaveApplyView {

	private EmpLeaveApplyVM empApplyVm = new EmpLeaveApplyVM();

	public void applyView(Employee emp) {
		empApplyVm.removeFromAttendance(emp);
		empApplyVm.removeEmpFromAvailList(emp.getUserName(), emp.getVechileType());
	}

	public void leaveApplied() {
		System.out.println("Leave Approved!!");

	}
}
