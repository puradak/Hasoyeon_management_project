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
import function.Function;

public class AddStudy_get_member {
	
	private int count;
	private String name_study;
	private JTextField member_tf;
	
	private Function function = new Function();
	
	private JFrame frame = new JFrame("get member");
	
	private JTextField[] name_tf;
	
	private JLabel name = new JLabel("각 칸에 이름을 입력해주세요.");
	
	private JButton btn_confirm = new JButton("저장");
	
	public AddStudy_get_member(int x, int y, int count, String name_study, JTextField member_tf) {
		this.count = count;
		this.member_tf = member_tf;
		name_tf = new JTextField[count];
		
		for(int i = 0; i<count; i++) {
			name_tf[i] = new JTextField();
		}
		int y_additional = 0;
		if(count > 20) y_additional = count*5;
		frame.setBounds(x,y,400,300+y_additional);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(null);
		frame.setAlwaysOnTop(true);
		frame.setType(Type.UTILITY);
		frame.setVisible(true);
		
		setTexts();
		for(JTextField tf : name_tf) {
			frame.add(tf);
		}
		
		setLabel();
		frame.add(name);
		
		setButton();
		frame.add(btn_confirm);
	}
	
	public void setTexts() {
		int x_order = 0, y_order = -1;
		for(JTextField tf : name_tf) {
			if(x_order == 0) y_order += 1;
			tf.setBorder(new LineBorder(new Color(0,0,0)));
			tf.setFont(new Font("HY중고딕", Font.PLAIN, 13));
			tf.setBounds(30+65*x_order,40+35*y_order,50,20);
			x_order = (x_order+1)%5;
		}
	}
	
	public void setLabel() {
		name.setBounds(0,0,400,30);
		name.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void setButton() {
		btn_confirm.setBounds(160,frame.getHeight()-120,60,60);
		btn_confirm.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for(JTextField tf : name_tf) {
					if(tf.getText().equals("")) return;
				}
				setMember();
				frame.setVisible(false);
			}
		});
	}
	public void setMember() {
		Member member;
		String[] members = new String[count];
		String members_str = "";
		int index = 0;
		for(JTextField tf : name_tf) {
			member = function.findMemberByName(tf.getText());
			if(member != null) {
				member.getStudy().add(name_study);
			}
			members[index] = tf.getText();
			members_str += tf.getText() + " ";
			index++;
		}
		function.setTempMembers(members);
		member_tf.setText(members_str);
	}
}
