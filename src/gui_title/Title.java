package gui_title;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gui_drawable.RoundedButton;
import gui_table.MemberTable;
import gui_table.StudyTable;

public class Title {
	
	private JFrame frame = new JFrame();
	
	public Title() {
		frame.setTitle("HasoyeonManagement");
		frame.setSize(1000,800);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
		
		RoundedButton btn_member = new RoundedButton("부 원 관 리", new Color(255, 218, 185), Color.BLACK);
		btn_member.setBounds(frame.getWidth()/2 - 500 + 150, 283, 267, 222);
		btn_member.setFont(new Font("HY중고딕", Font.PLAIN, 30));
		btn_member.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(btn_member);
		
		btn_member.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				open_table_member();
			}
		});
		
		
		RoundedButton btn_study = new RoundedButton("스 터 디 관 리", new Color(144, 238, 144), Color.BLACK);
		btn_study.setBounds(frame.getWidth()/2 + 216 - 150, 283, 267, 222);
		btn_study.setFont(new Font("HY중고딕", Font.PLAIN, 30));
		btn_study.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(btn_study);
		
		btn_study.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				open_table_study();
			}
		});
		
		JLabel interiorTitle = new JLabel("하  소  연    관  리    프  로  그  램");
		interiorTitle.setBounds(frame.getWidth()/2 - 500 + 150,283-50,frame.getWidth()/2 + 216 - 150,35);
		interiorTitle.setFont(new Font("HY중고딕", Font.PLAIN, 30));
		frame.getContentPane().add(interiorTitle);
		
		
		
	}
	
	private void open_table_member() {
		new MemberTable(frame.getX(), frame.getY());
	}
	
	private void open_table_study() {
		new StudyTable(frame.getX(), frame.getY());
	}
}
