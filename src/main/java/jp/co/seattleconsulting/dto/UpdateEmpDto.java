package jp.co.seattleconsulting.dto;

import jp.co.seattleconsulting.entity.Employees;

/**
 * @author user
 *
 */
public class UpdateEmpDto {

	public Integer empNo;
	public String empName;
	public String empFurigana;
	public String birthday;
	public String tel;
	public String note;
	public Integer deleteFlag;
	public Integer status;

	public UpdateEmpDto() {}

	public UpdateEmpDto(Employees employees) {
		this.empNo = employees.empNo;
		this.empName = employees.empName;
		this.empFurigana = employees.empFurigana;
		this.birthday = employees.birthday;
		this.tel = employees.tel;
		this.note = employees.note;
		this.deleteFlag = employees.deleteFlag;
		this.status = employees.status;
	}

}
