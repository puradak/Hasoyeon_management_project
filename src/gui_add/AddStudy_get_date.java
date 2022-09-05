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

public class AddStudy_get_date {
	private int count;
	
	private JFrame frame = new JFrame("Get Date");
	
	private JTextField date;
	private JTextField[] order_tf, day_tf, time_tf, term_tf;
	private JTextField[][] texts = new JTextField[4][count];
	
	private JLabel order = new JLabel("순서"),
				   day = new JLabel("요일"),
				   time = new JLabel("시각"),
				   term = new JLabel("시간");
	private JLabel[] labels = { order, day, time, term };
	
	private JButton btn_confirm = new JButton("저장");
	
	public AddStudy_get_date(int x, int y, int count, JTextField date) {
		this.count = count;
		this.date = date;
		
		frame.setBounds(x,y,500,400);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(null);
		frame.setAlwaysOnTop(true);
		frame.setType(Type.UTILITY);
		frame.setVisible(true);
		
		// init textFields and add on frame
		setTexts();
		for(JTextField[] tfs : texts) {
			for(JTextField tf : tfs) {
				frame.add(tf);
			}
		}
		
		// init labels and add on frame
		setLabels();
		for(JLabel l : labels) {
			frame.add(l);
		}
		
		setButton();
		frame.add(btn_confirm);
		
	}
	
	
	private void setTexts() {

		order_tf = new JTextField[count];
		day_tf = new JTextField[count];
		time_tf = new JTextField[count];
		term_tf = new JTextField[count];
		
		for(int i=0; i<count; i++) {
			order_tf[i] = new JTextField(""+(i+1)+"번째");
			order_tf[i].setFocusable(false);
			day_tf[i] = new JTextField("");
			time_tf[i] = new JTextField("");
			term_tf[i] = new JTextField("");
		}
		
		texts[0] = order_tf;
		texts[1] = day_tf;
		texts[2] = time_tf;
		texts[3] = term_tf;
		
		int x_order = 0, y_order = 0;
		for(JTextField[] tfs : texts) {
			for(JTextField tf : tfs) {
				tf.setBounds(60+100*x_order,100+25*y_order,40,20);
				y_order ++;
			}
			y_order = 0;
			x_order++;
		}
	}
	
	private void setLabels() {
		int x_order = 0;
		for(JLabel l : labels) {
			l.setBounds(60+100*x_order,70,40,20);
			l.setFont(new Font("HY중고딕", Font.PLAIN, 15));
			x_order++;
		}
	}
	
	private void setButton() {
		btn_confirm.setBounds(200,290,80,60);
		btn_confirm.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setDate();
			}
		});
	}
	
	// 1 : day, 2 : time, 3 : term
	public void setDate() {
		String date_info = "";
		
		for(int i=0; i<count; i++) {
				int tempTime = Integer.parseInt(time_tf[i].getText());
				int tempTerm = Integer.parseInt(term_tf[i].getText());
				date_info += texts[1][i].getText()+"요일 ";
				date_info += texts[2][i].getText()+"시 ~ ";
				date_info += (tempTime+tempTerm)+"시";
				if(i!=count-1) date_info += "  /  ";
		}
		
		date.setText(date_info);
		frame.setVisible(false);
	}
}
