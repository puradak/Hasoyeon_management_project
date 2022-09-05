package gui_table;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import data.Study;
import file.FileIO;
import gui_add.AddStudy;

public class StudyTable {
	private FileIO file = FileIO.getFileObject();
	private int x, y;
	
	private String[] tableColumn = {"이름", "대표", "주제", "요일", "장소", "구성원", "지원사항"};
	
	private JFrame frame = new JFrame("Study Management");
	
	private DefaultTableModel model = new DefaultTableModel(tableColumn,0);
	private JTable table = new JTable(model);
	private JScrollPane sp = new JScrollPane(table);
	
	private JPanel panel = new JPanel();
	private JLabel name = new JLabel("이름");
	private JLabel leader = new JLabel("대표");
	private JLabel subject = new JLabel("주제");
	private JLabel date = new JLabel("요일");
	private JLabel place = new JLabel("장소");
	private JLabel members = new JLabel("구성원");
	private JLabel support = new JLabel("지원사항");
	private JLabel[] labels = { name, leader, subject, place, date, members, support }; //7
	
	private JTextField  name_tf = new JTextField(),
						leader_tf = new JTextField(),
						subject_tf = new JTextField(),
						date_tf = new JTextField(),
						place_tf = new JTextField();
	private JTextField[] texts = { name_tf, leader_tf, subject_tf, place_tf };
	private JTextArea members_ta,support_ta;
	
	private JButton btn_edit = new JButton("수정"),
					btn_add = new JButton("추가"),
					btn_remove = new JButton("삭제");
	private JButton[] buttons = { btn_edit, btn_add, btn_remove };
	
	public StudyTable(int x, int y) {
		this.x = x;
		this.y = y;
		
		frame.setBounds(x,y,1000,800);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.white);
		setTable();
		setPanel();
	}	
	
	public void setTable() {
		sp.setBounds(12, 30, 960, 480);
		frame.getContentPane().add(sp);
		setRows();
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				int col_order = 0;
				for(JTextField tf : texts) {
					tf.setText(table.getValueAt(row, col_order).toString());
					col_order++;
				}
				date_tf.setText(table.getValueAt(row, 4).toString());
				members_ta.setText(table.getValueAt(row, 5).toString());
				support_ta.setText(table.getValueAt(row, 6).toString());
			}
		});
	}
	
	public void setPanel() {
		// init panel basic attributes
		panel.setBackground(Color.white);
		panel.setBounds(12, 519, 960, 230);
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		panel.setLayout(null);
		frame.add(panel);
		
		// init labels and add on panel
		setLabels();
		for(JLabel l : labels) {
			panel.add(l);
		}
		
		// init textFields and textAreas and add on panel
		setTexts();
		for(JTextField tf : texts) {
			panel.add(tf);
		}
		panel.add(date_tf);
		panel.add(members_ta);
		panel.add(support_ta);
		
		// init buttons and add on panel
		setButtons();
		for(JButton b : buttons) {
			panel.add(b);
		}
	}
	
	//name, leader, subject, place, date, members, support
	public void setLabels() {
		//set Font
		for(JLabel l : labels) {
			l.setFont(new Font("HY중고딕", Font.PLAIN, 13));
		}
		
		//set Size and Location(x-y coord)
		int x_order = 0;
		for(int i = 0; i<4; i++) {
			labels[i].setBounds(20+225*x_order,20,40,20);
			x_order++;
		}
		date.setBounds(20, 50, 100, 20);
		members.setBounds(20, 75, 40, 20);
		support.setBounds(20,100,60,20);
	}
	
	//name, leader, subject, date, place / members, support
	public void setTexts() {
		// set Font
		for(JTextField tf : texts) {
			tf.setFont(new Font("HY중고딕", Font.PLAIN, 13));
		}
		date_tf.setFont(new Font("HY중고딕", Font.PLAIN, 13));
		members_ta = new JTextArea();
		members_ta.setFont(new Font("HY중고딕", Font.PLAIN, 13));
		support_ta = new JTextArea();
		support_ta.setFont(new Font("HY중고딕", Font.PLAIN, 13));
		
		// set size and Location
		int x_order = 0;
		for(int i = 0; i<4; i++) {
			texts[i].setBounds(70+225*x_order,20,155,20);
			texts[i].setBorder(new LineBorder(new Color(0,0,0)));
			x_order++;
		}
		date_tf.setBounds(70, 50, 830, 20);
		date_tf.setBorder(new LineBorder(new Color(0,0,0)));

		members_ta.setBounds(70,75,830,20);
		support_ta.setBounds(20,120,880,40);
		
		members_ta.setBorder(new LineBorder(new Color(0,0,0)));
		support_ta.setBorder(new LineBorder(new Color(0,0,0)));
	}

	public void setButtons() {
		// set Size and Location
		int x_order = 0;
		for(int i=0; i<3; i++) {
			buttons[i].setBounds(700+85*x_order,165,60,60);
			x_order++;
		}
		
		// set Font color
		btn_add.setForeground(Color.blue);
		btn_remove.setForeground(Color.red);
		
		btn_add.addMouseListener( new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				open_add_page();
			}	
		});
	}

	public void setRows() {
		if(file.getStudyList().isEmpty()) return;
		for(Study s : file.getStudyList()) {
			Vector<String> study = new Vector<>();
			
			for(String str : s.getInformationArray()) {
				study.add(str);
			}
			
			String tempMemberList = "";
			for(String str : s.getMemberList()) {
				tempMemberList += str+" ";
			}
			study.add(tempMemberList);
			
			model.addRow(study);
		}
		
	}
	
	public void open_add_page() {
		new AddStudy(x,y,name_tf.getText());
	}
}
