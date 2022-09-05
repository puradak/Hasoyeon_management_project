package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import data.Member;
import data.Study;

public class FileIO {
	private static ArrayList<Member> memberList = new ArrayList<>();
	private static ArrayList<Study> studyList = new ArrayList<>();
	private static FileIO file = new FileIO();
	
	private FileIO() {
		
	}
	
	public static FileIO getFileObject() {
		return file;
	}
	
	public ArrayList<Member> getMemberList(){
		return memberList;
	}
	
	public ArrayList<Study> getStudyList(){
		return studyList;
	}
	
	public boolean save() {
		try {
			ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream( "MemberSave.txt" ) );
			out.writeObject(memberList);
			out.close();
		} catch (IOException e) {
			return false;
		}
		try {
			ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream( "StudySave.txt" ) );
			out.writeObject(studyList);
			out.close();
		} catch (IOException e) {
			System.out.println("error occurs in saving StudySave.txt");
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean load() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("MemberSave.txt"));
			memberList = (ArrayList<Member>)in.readObject();
			in.close();
			if(memberList == null) memberList = new ArrayList<Member>();
		}catch ( IOException e ) {
			return false;
		}catch ( ClassNotFoundException e ) {
			return false;
		}
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("StudySave.txt"));
			studyList = (ArrayList<Study>)in.readObject();
			in.close();
			if(studyList == null) studyList = new ArrayList<Study>();
		}catch ( IOException e ) {
			System.out.println("error occurs in loading StudySave.txt");
			return false;
		}catch ( ClassNotFoundException e ) {
			return false;
		}
		return true;
	}
	
}
