import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FedexSwings4 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void NewScreen4() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FedexSwings4 frame = new FedexSwings4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FedexSwings4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourTracking = new JLabel("Enter your tracking number");
		lblEnterYourTracking.setBounds(28, 63, 213, 15);
		contentPane.add(lblEnterYourTracking);
		textField = new JTextField(30);
	
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		textField.setBounds(257, 61, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(41, 153, 376, 118);
		contentPane.add(textArea);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("OK")) {
					String trackId = textField.getText(); 
					System.out.println("trackId="+trackId);
					Connection conn;
					try {
						conn = DriverManager.getConnection("jdbc:mysql://localhost/Fedex?autoReconnect=true&useSSL=false","root","chinnu41093");
				
					Statement sttmt = conn.createStatement();
					//PreparedStatement psttmt= conn.prepareStatement();
					//"Select * From Fedex.packageinfo Where TNO ="+trackno);
					String q = "Select * From Fedex.packageinfo Where TNO ='"+trackId+"'";
					PreparedStatement psttmt= conn.prepareStatement(q);
					ResultSet rs = sttmt.executeQuery(q);
				//	ResultSet rsmd = rs.getMetaData();
					//int columnsNumber = rsmd.getColumnCount();
					while(rs.next()) {
						String all= rs.getString("Istation");
						String ti = rs.getString("Time");
						String sc = rs.getString("Source");
						String ds = rs.getString("Destination");
						String tno = rs.getString("TNO");
						System.out.println("The packet of id "+tno+"is at "+all+" at time "+ti+" traveling from "+sc+"to "+ds);
						//System.out.println(all);
						textArea.append("The packet "+tno+" is at "+all+" at time "+ti+" traveling from "+sc+"to "+ds+"\n");
						
					}
					String qu = "Delete From packageinfo ";
					sttmt.executeUpdate(qu);
			         conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnOk.setBounds(183, 110, 75, 15);
		contentPane.add(btnOk);
		

	}
}
