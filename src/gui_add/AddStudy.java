package gui_add;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import data.Study;
import file.FileIO;
import function.Function;

public class AddStudy {
	private FileIO file = FileIO.getFileObject();
	private Function function = new Function();
	
	private String name_study;
	
	private JFrame frame = new JFrame("Add Study");
	private JLabel name = new JLabel("이름");
	private JLabel leader = new JLabel("대표");
	private JLabel subject = new JLabel("주제");
	private JLabel date = new JLabel("요일");
	private JLabel place = new JLabel("장소");
	private JLabel members = new JLabel("구성원");
	private JLabel support = new JLabel("지원사항");
	private JLabel[] labels = { name, leader, subject, date, place, members, support }; //7
	
	private JTextField name_tf = new JTextField("");
	private JTextField leader_tf = new JTextField("");
	private JTextField subject_tf = new JTextField("");
	// date는 따로  창 만들어서 입력받기
	private JTextField date_tf = new JTextField("");
	private JTextField place_tf = new JTextField("");
	// members는 따로 창 만들어서 입력받기
	private JTextField members_tf = new JTextField("");
	private JTextField support_tf = new JTextField("");
	private JTextField[] texts = { name_tf, leader_tf, subject_tf, date_tf, place_tf, members_tf, support_tf };
	
	private JButton btn_get_date = new JButton("추가"),
					btn_get_member = new JButton("추가"),
					btn_add = new JButton("추가");
	private JButton[] buttons = { btn_get_date, btn_get_member, btn_add };
	
	public AddStudy(int x, int y, String name_study) {
		this.name_study = name_study;
		
		// init frame
		frame.setBounds(x,y,500,500);
		frame.setForeground(Color.white);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		
		// init labels and add on frame
		setLabels();
		for(JLabel l : labels) {
			frame.add(l);
		}
		
		// init textFields and add on frame
		setTexts();
		for(JTextField tf : texts) {
			frame.add(tf);
		}
		
		// init buttons and add on frame
		setButtons();
		for(JButton b : buttons) {
			frame.add(b);
		}
	}
	
	public void setLabels() {
		for(JLabel l : labels) {
			l.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		}
		
		name.setBounds(10,10,40,20);
		int y_order = 0;
		for(JLabel l : labels) {
			l.setBounds(20, 20+55*y_order,80,20);
			y_order++;
		}
	}
	
	public void setTexts() {
		// set textField's location
		int y_order = 0;
		for(JTextField tf : texts) {
			tf.setBounds(100,20+55*y_order,300,20);
			y_order++;
		}
	}
	//  name, leader, subject, date, place, members, support }
	public void setButtons() {
		btn_get_date.setBounds(400,20+55*3,80,20);
		btn_get_member.setBounds(400,20+55*5,80,20);
		btn_add.setBounds(200,380,80,80);
		
		btn_get_date.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				open_get_date(frame.getX(),frame.getY());
			}
		});
		
		btn_get_member.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(name_tf.getText().equals("")) return;
				open_get_member(frame.getX(),frame.getY());
			}
		});
		
		btn_add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for(JTextField tf : texts) {
					if(tf.getText().equals("")) return;
				}
				
				Study study = new Study();
				for(int i=0; i<7; i++) {
					study.setInformation(i, texts[i].getText());
				}

				study.setMemberList(function.getTempMembers());
				
				file.getStudyList().add(study);
				file.save();
				frame.setVisible(false);
			}
		});
	}
	
	public void open_get_date(int x, int y) {
		try{
			int count = Integer.parseInt(date_tf.getText());
			if(count < 1 || count > 7) return;
			new AddStudy_get_date(x,y,count,date_tf);
		}catch(NumberFormatException e) {
			return;
		}
		
	}
	
	public void open_get_member(int x, int y) {
		try {
			int count = Integer.parseInt(members_tf.getText());
			if(count < 1) return;
			new AddStudy_get_member(x,y,count,this.name_study, this.members_tf);
		}catch(NumberFormatException e){
			return;
		}
		
	}
	
}
