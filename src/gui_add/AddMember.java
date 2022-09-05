package gui_add;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import data.Member;
import file.FileIO;

public class AddMember {
	private JFrame frame;
	private JTextField name_tf;
	private JTextField age_tf;
	private JTextField gender_tf;
	private JLabel phone_number;
	private JTextField phone_number_tf;
	private JTextField major_tf;
	private JTextField studentNumber_tf;
	private JLabel date;
	private JTextField date_tf;
	private JLabel reason;
	private JTextField reason_tf;
	private JLabel toDO;
	private JTextField toDo_tf;
	private JLabel fee;
	private JTextField fee_tf;
	private JButton btn_add;
	
	private FileIO file = FileIO.getFileObject();
	
	public AddMember(int x, int y) {
		frame = new JFrame("멤버 추가");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(new Color(255, 255, 255));
		frame.setType(Type.UTILITY);
		frame.setBounds(x, y, 400, 600);
		frame.getContentPane().setLayout(null);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		
		JLabel title = new JLabel("회원 추가하기");
		title.setFont(new Font("HY중고딕", Font.BOLD, 15));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0, 27, 384, 25);
		frame.getContentPane().add(title);
		
		JLabel name = new JLabel("이름");
		name.setFont(new Font("HY중고딕", Font.BOLD, 15));
		name.setBounds(12, 76, 36, 25);
		frame.getContentPane().add(name);
		
		JLabel age = new JLabel("나이");
		age.setFont(new Font("HY중고딕", Font.BOLD, 15));
		age.setBounds(153, 76, 36, 25);
		frame.getContentPane().add(age);
		
		JLabel gender = new JLabel("성별");
		gender.setFont(new Font("HY중고딕", Font.BOLD, 15));
		gender.setBounds(276, 76, 36, 25);
		frame.getContentPane().add(gender);
		
		name_tf = new JTextField();
		name_tf.setFont(new Font("HY중고딕", Font.BOLD, 15));
		name_tf.setBounds(49, 77, 97, 21);
		frame.getContentPane().add(name_tf);
		name_tf.setColumns(10);
		
		age_tf = new JTextField();
		age_tf.setFont(new Font("HY중고딕", Font.BOLD, 15));
		age_tf.setColumns(10);
		age_tf.setBounds(186, 77, 78, 21);
		frame.getContentPane().add(age_tf);
		
		gender_tf = new JTextField();
		gender_tf.setFont(new Font("HY중고딕", Font.BOLD, 15));
		gender_tf.setColumns(10);
		gender_tf.setBounds(314, 78, 58, 21);
		frame.getContentPane().add(gender_tf);
		
		JLabel major = new JLabel("학과");
		major.setFont(new Font("HY중고딕", Font.BOLD, 15));
		major.setBounds(12, 132, 36, 25);
		frame.getContentPane().add(major);
		
		JLabel studentNumber = new JLabel("학번");
		studentNumber.setFont(new Font("HY중고딕", Font.BOLD, 15));
		studentNumber.setBounds(218, 132, 36, 25);
		frame.getContentPane().add(studentNumber);
		
		major_tf = new JTextField();
		major_tf.setFont(new Font("HY중고딕", Font.BOLD, 15));
		major_tf.setColumns(10);
		major_tf.setBounds(49, 132, 157, 21);
		frame.getContentPane().add(major_tf);
		
		studentNumber_tf = new JTextField();
		studentNumber_tf.setFont(new Font("HY중고딕", Font.BOLD, 15));
		studentNumber_tf.setColumns(10);
		studentNumber_tf.setBounds(257, 132, 115, 21);
		frame.getContentPane().add(studentNumber_tf);
		
		date = new JLabel("가입일");
		date.setFont(new Font("HY중고딕", Font.BOLD, 15));
		date.setBounds(12, 162, 46, 25);
		frame.getContentPane().add(date);
		
		date_tf = new JTextField();
		date_tf.setFont(new Font("HY중고딕", Font.BOLD, 15));
		date_tf.setColumns(10);
		date_tf.setBounds(70, 163, 85, 21);
		frame.getContentPane().add(date_tf);
		
		reason = new JLabel("지원사유");
		reason.setFont(new Font("HY중고딕", Font.BOLD, 15));
		reason.setBounds(12, 199, 78, 25);
		frame.getContentPane().add(reason);
		
		reason_tf = new JTextField();
		reason_tf.setBounds(12, 222, 360, 88);
		frame.getContentPane().add(reason_tf);
		reason_tf.setColumns(10);
		
		toDO = new JLabel("희망활동");
		toDO.setFont(new Font("HY중고딕", Font.BOLD, 15));
		toDO.setBounds(12, 320, 78, 25);
		frame.getContentPane().add(toDO);
		
		toDo_tf = new JTextField();
		toDo_tf.setColumns(10);
		toDo_tf.setBounds(12, 343, 360, 153);
		frame.getContentPane().add(toDo_tf);
		
		fee = new JLabel("회비 제출");
		fee.setFont(new Font("HY중고딕", Font.BOLD, 15));
		fee.setBounds(186, 162, 70, 25);
		frame.getContentPane().add(fee);
		
		fee_tf = new JTextField();
		fee_tf.setFont(new Font("HY중고딕", Font.BOLD, 15));
		fee_tf.setColumns(10);
		fee_tf.setBounds(257, 164, 115, 21);
		frame.getContentPane().add(fee_tf);
		
		phone_number = new JLabel("연락처");
		phone_number.setFont(new Font("HY중고딕", Font.BOLD, 15));
		phone_number.setBounds(12, 108, 46, 18);
		frame.getContentPane().add(phone_number);
		
		phone_number_tf = new JTextField();
		phone_number_tf.setFont(new Font("HY중고딕", Font.BOLD, 15));
		phone_number_tf.setColumns(10);
		phone_number_tf.setBounds(65, 105, 215, 21);
		frame.getContentPane().add(phone_number_tf);
		
		btn_add = new JButton("추가하기");
		btn_add.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn_add.setBackground(new Color(240, 248, 255));
		btn_add.setBounds(120, 500, 150, 50);
		frame.getContentPane().add(btn_add);
		
		btn_add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				addMemberToList();
			}
		});
		
	}
	
	private void addMemberToList() {
		String name = name_tf.getText();
		if(name.isEmpty() || name == null) return;
		String age = age_tf.getText();
		String gender = gender_tf.getText();
		String phone_number = phone_number_tf.getText();
		String major = major_tf.getText();
		String studentNumber = studentNumber_tf.getText();
		String date = date_tf.getText();
		String fee = fee_tf.getText();
		String reason = reason_tf.getText();
		String toDo = toDo_tf.getText();
				
		Member member = new Member(name, age, gender, phone_number, studentNumber, major, date, reason, toDo, fee);
		file.getMemberList().add(member);
		file.save();
		
		name_tf.setText("");
		age_tf.setText("");
		gender_tf.setText("");
		phone_number_tf.setText("");
		major_tf.setText("");
		studentNumber_tf.setText("");
		reason_tf.setText("");
		toDo_tf.setText("");
	}
	
}
