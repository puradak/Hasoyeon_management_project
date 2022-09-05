package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable{
//	// individual information in private
//	private String name;
//	private String age;
//	private String gender;
//	private String phone_number;
//	
//	// individual information using in university
//	private String stuNumber;
//	private String major;
//
//	// information about club joining
//	private String join_date;
//	private String reason;
//	private String toDo;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6557668773421283913L;
	private String[] information = new String[10];
	private ArrayList<String> study = new ArrayList<>();
	//Constructor
	public Member(String date, String name, String age, String gender, String stuNumber, String major, String phone_number, 
			String reason, String toDo, String fee) {
		super();
		information[0] = date;
		information[1] = name;
		information[2] = age;
		information[3] = gender;
		information[4] = stuNumber;
		information[5] = major;
		information[6] = phone_number;
		information[7] = reason;
		information[8] = toDo;
		information[9] = fee;
	}

	public Member(String[] information) {
		this.information = information;
	}
	
	//getter and setter
	
	public String getName() {
		return information[1];
	}

	public void setName(String name) {
		information[1] = name;
	}

	public String getAge() {
		return information[2];
	}

	public void setAge(String age) {
		information[2] = age;
	}

	public String getGender() {
		return information[3];
	}

	public void setGender(String gender) {
		information[3] = gender;
	}

	public String getPhone_number() {
		return information[6];
	}

	public void setPhone_number(String phone_number) {
		information[6] = phone_number;
	}

	public String getStuNumber() {
		return information[4];
	}

	public void setStuNumber(String stuNumber) {
		information[4] = stuNumber;
	}

	public String getMajor() {
		return information[5];
	}

	public void setMajor(String major) {
		information[5] = major;
	}

	public String getDate() {
		return information[0];
	}

	public void setDate(String join_date) {
		information[0] = join_date;
	}

	public String getReason() {
		return information[7];
	}

	public void setReason(String reason) {
		information[7] = reason;
	}

	public String getToDo() {
		return information[8];
	}

	public void setToDo(String toDo) {
		information[8] = toDo;
	}

	public String getInfo(int index) {
		return information[index];
	}
	
	public String getFee() {
		return information[9];
	}
	
	public void setFee(String fee) {
		this.information[9] = fee;
	}

	public ArrayList<String> getStudy() {
		return study;
	}

	public void setStudy(ArrayList<String> study) {
		this.study = study;
	}
	
	
}
