package function;

import data.Member;
import file.FileIO;

public class Function {
	private FileIO file = FileIO.getFileObject();
	private static String[] tempMembers;
	
	// formation : name(age, gender)
	public String getName(String str) {
		String name = "";
		
		int index = 0;
		for(index = 0; str.charAt(index)!='('; index++) {
			if(str.charAt(index) == ' ') continue;
			name += ""+(char)str.charAt(index);
		}
					
		return name;
	}
	// str formation : name(age, gender)
	public String getAge(String str) {
		String tempAge = "";
		
		int index = 0;
		for(index = 0; str.charAt(index)!='('; index++);
		index++;
		for(; str.charAt(index) != ','; index++) {
			if(str.charAt(index) == ' ') continue;
			tempAge += ""+(char)str.charAt(index);
		}
		
		return tempAge;
	}
	
	public String getGender(String str) {
		String gender = "";
		int index = 0;
		for(index = 0; str.charAt(index) != ','; index++);
		index++;
		for(;str.charAt(index)!=')'; index++ ) {
			if(str.charAt(index) == ' ') continue;
			gender += ""+(char)str.charAt(index);
		}
		return gender;
	}

	public String getStudentNumber(String str) {
		String stdNum = "";
		for(int i=0; str.charAt(i) != '('; i++) {
			if(str.charAt(i) == ' ') continue;
			stdNum += str.charAt(i);
		}
		return stdNum;
	}

	public String getMajor(String str) {
		String major = "";
		int index = 0;
		for(index=0; str.charAt(index) != '('; index++);
		index++;
		for(;str.charAt(index) != ')'; index++) {
			if(str.charAt(index) == ' ') continue;
			major += str.charAt(index);
		}
		return major;
	}
	
	public Member findMemberByName(String name) {
		for(Member m : file.getMemberList()) {
			if(m.getName().equals(name)) {
				return m;
			}
		}
		return null;
	}

	public String getFixedPhoneNumber(String str) {
		String pnum = "";
		for(int i=0; i<str.length(); i++) {
			if(i==3 || i==7) pnum+="-";
			pnum += str.charAt(i);
		}
		return pnum;
	}

	public String[] getTempMembers() {
		return tempMembers;
	}
	
	public void setTempMembers(String[] tempMembers) {
		Function.tempMembers = tempMembers;
	}
}
