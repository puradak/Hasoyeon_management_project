package gui_table;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import data.Member;
import file.FileIO;
import function.Function;
import gui_add.AddMember;

public class MemberTable {

	private int x, y;
	private FileIO file = FileIO.getFileObject();
	private Function function = new Function();
	private ArrayList<Member> memberList = file.getMemberList();
	
	private JFrame frame;
	private JPanel panel = new JPanel();
	private JLabel privateInfo;
	private JLabel reason;
	private JTextField privateInfo_tf;
	private JTextField major_tf;
	private JTextField date_tf;
	private JTextField fee_tf;
	private JTextField phone_number_tf;
	private JTextArea reason_ta;
	private JTextArea toDo_ta;
	private JTable table;
	private DefaultTableModel tableModel;
	private String[] tableColumn = { "가입일","이름","나이","성별","학번","학과","연락처","지원사유","희망활동", "fee" };

	
	
	public MemberTable(int x, int y) {
		this.x = x;
		this.y = y;
		
		// init frame
		frame = new JFrame();
		frame.setTitle("Member Management");
		frame.setBounds(x,y,1000,800);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		panel.setBackground(Color.white);
		panel.setBounds(12, 569, 960, 182);
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		panel.setLayout(null);
		setPanel();
		frame.add(panel);
		
		// init table model
		tableModel = new DefaultTableModel(tableColumn,0);
		setTable();
		
		
		// init table
		table = new JTable(tableModel);

		// add selection listener
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String[] info = new String[10];
				int row = table.getSelectedRow();
				for(int i=0; i<10; i++) {
					info[i] = table.getValueAt(row, i).toString();
				}
				//tableColumn = { "가입일","이름","나이","성별","학번","학과","연락처","지원사유","희망활동", "fee" };
				String private_info = info[1]+"("+info[2]+","+info[3]+")";
				String phone_number_info = info[6];
				String student_info = info[4]+"("+info[5]+")";
				String date = info[0];
				String reason = info[7];
				String toDo = info[8];
				String fee = info[9];
				
				privateInfo_tf.setText(private_info);
				phone_number_tf.setText(phone_number_info);
				major_tf.setText(student_info);
				date_tf.setText(date);
				reason_ta.setText(reason);
				toDo_ta.setText(toDo);
				fee_tf.setText(fee);
				
			}
		});
		
		// init scroll pane
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(12, 79, 960, 480);
		frame.add(sp);
		
	}
	
	private void setPanel() {
		
		privateInfo = new JLabel("이름(나이, 성별) :");
		privateInfo.setFont(new Font("굴림", Font.PLAIN, 15));
		privateInfo.setBounds(12, 10, 122, 18);
		panel.add(privateInfo);
		
		JLabel major = new JLabel("학과(학번) : ");
		major.setFont(new Font("굴림", Font.PLAIN, 15));
		major.setBounds(274, 10, 83, 18);
		panel.add(major);
		
		JLabel date = new JLabel("가입일 :");
		date.setFont(new Font("굴림", Font.PLAIN, 15));
		date.setBounds(647, 10, 56, 18);
		panel.add(date);
		
		reason = new JLabel("지원동기");
		reason.setFont(new Font("굴림", Font.PLAIN, 15));
		reason.setBounds(12, 27, 56, 18);
		panel.add(reason);
		
		reason_ta = new JTextArea();
		reason_ta.setFont(new Font("HY중고딕", Font.PLAIN, 13));
		reason_ta.setBounds(12, 43, 648, 48);
		reason_ta.setLineWrap(true);
		reason_ta.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(reason_ta);
		
		JLabel toDo = new JLabel("희망활동");
		toDo.setFont(new Font("굴림", Font.PLAIN, 15));
		toDo.setBounds(12, 96, 56, 18);
		panel.add(toDo);
		
		toDo_ta = new JTextArea();
		toDo_ta.setFont(new Font("HY중고딕", Font.PLAIN, 13));
		toDo_ta.setBounds(12, 113, 648, 48);
		toDo_ta.setLineWrap(true);
		toDo_ta.setBorder(new LineBorder(new Color(0,0,0)));
		panel.add(toDo_ta);
		
		JLabel fee = new JLabel("납부 :");
		fee.setFont(new Font("굴림", Font.PLAIN, 15));
		fee.setBounds(821, 10, 61, 18);
		panel.add(fee);
		
		privateInfo_tf = new JTextField();
		privateInfo_tf.setBounds(131, 9, 131, 21);
		panel.add(privateInfo_tf);
		privateInfo_tf.setColumns(10);
		
		major_tf = new JTextField();
		major_tf.setColumns(10);
		major_tf.setBounds(354, 9, 286, 21);
		panel.add(major_tf);
		
		date_tf = new JTextField();
		date_tf.setColumns(10);
		date_tf.setBounds(699, 9, 116, 21);
		panel.add(date_tf);
		
		fee_tf = new JTextField();
		fee_tf.setColumns(10);
		fee_tf.setBounds(864, 9, 56, 21);
		panel.add(fee_tf);
		
		JButton btn_edit = new JButton("수정");
		btn_edit.setBounds(672, 79, 77, 53);
		panel.add(btn_edit);
		
		JButton btn_remove = new JButton("삭제");
		btn_remove.setForeground(new Color(220, 20, 60));
		btn_remove.setBounds(761, 79, 77, 53);
		panel.add(btn_remove);
		
		JButton btn_add = new JButton("추가");
		btn_add.setForeground(new Color(30, 144, 255));
		btn_add.setBounds(850, 79, 77, 53);
		panel.add(btn_add);
		
		JLabel lblNewLabel = new JLabel("하소연 회원 정보 리스트");
		lblNewLabel.setFont(new Font("HY중고딕", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 960, 59);
		
		JLabel phone_number = new JLabel("연락처 :");
		phone_number.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		phone_number.setBounds(680, 40, 56, 18);
		panel.add(phone_number);
		
		phone_number_tf = new JTextField();
		phone_number_tf.setColumns(10);
		phone_number_tf.setBounds(735, 38, 185, 21);
		phone_number_tf.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		panel.add(phone_number_tf);
		
		
		btn_edit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(privateInfo.getText() == null || privateInfo.getText().equals("")) return;
				int index = table.getSelectedRow();
				Member target = function.findMemberByName(function.getName(privateInfo.getText()));
				if(target != null) {
					target.setName(function.getName(privateInfo_tf.getText()));
					target.setAge(function.getAge(privateInfo_tf.getText()));
					target.setGender(function.getGender(privateInfo_tf.getText()));
					target.setPhone_number(phone_number_tf.getText());
					target.setDate(date_tf.getText());
					target.setMajor(function.getMajor(major_tf.getText()));
					target.setStuNumber(function.getStudentNumber(major_tf.getText()));
					target.setReason(reason_ta.getText());
					target.setToDo(toDo_ta.getText());
					target.setFee(fee_tf.getText());
				}
				else {
					target = new Member(
							date_tf.getText(),
							function.getName(privateInfo_tf.getText()),
							function.getAge(privateInfo_tf.getText()),
							function.getGender(privateInfo_tf.getText()),
							function.getStudentNumber(major_tf.getText()),
							function.getMajor(major_tf.getText()),
							phone_number_tf.getText(),
							reason_ta.getText(),
							toDo_ta.getText(),
							fee_tf.getText()
							);
					
					file.getMemberList().remove(index);
					file.getMemberList().add(index, target);
				}
				file.save();
			}
		});
		
		btn_add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				open_add_page();
			}
		});
	
		btn_remove.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(privateInfo_tf.getText() == null || privateInfo_tf.getText().equals("")) return;
				file.getMemberList().remove(function.findMemberByName(function.getName(privateInfo_tf.getText())));
				file.save();
			}
		});
		
	}
	
//	String name, String age, String gender, String phone_number, String stuNumber, String major,
//	String join_date, String reason, String toDo, fee -> 9 strings
	private void setTable() {
		if(memberList == null) return;
		for(int i=0; i<memberList.size(); i++) {
			Vector<String> row = new Vector<>();
			for(int j=0; j<10; j++) {
				row.add(memberList.get(i).getInfo(j));
			}
			tableModel.addRow(row);
		}
	}
	
	private void open_add_page() {
		new AddMember(x,y);
	}
	
}
