package data;

import java.io.Serializable;

public class Study implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7350170686275520761L;
	private String name;
	private String leader;
	private String subject;
	private String meeting;
	private String place;
	private String support;
	private String date;
	private String[] memberList;
	private String[] information = new String[7];
	public Study() {
		// TODO Auto-generated constructor stub
	}

	public Study(String name, String leader, String subject, String meeting, String place, String support, String date,
			String[] memberList) {
		super();
		information[0] = this.name = name;
		information[1] = this.leader = leader;
		information[2] = this.subject = subject;
		information[3] = this.meeting = meeting;
		information[4] = this.place = place;
		information[5] = this.support = support;
		information[6] = this.date = date;
		this.memberList = memberList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMeeting() {
		return meeting;
	}

	public void setMeeting(String meeting) {
		this.meeting = meeting;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String[] getMemberList() {
		return memberList;
	}

	public void setMemberList(String[] memberList) {
		this.memberList = memberList;
	}
	
	public String getInformation(int index) {
		return this.information[index];
	}
	
	public void setInformation(int index,String str) {
		this.information[index] = str;
	}
	
	public String[] getInformationArray() {
		return this.information;
	}
}
