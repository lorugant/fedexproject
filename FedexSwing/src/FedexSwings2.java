import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FedexSwings2 extends JFrame {

	private JPanel contentPane;
	public static String Source,Destination, cityName,cityName1,trackingnum;
	public static  Double weight;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FedexSwings2 frame = new FedexSwings2();
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
	public FedexSwings2() {
		setTitle("Package Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[] List = {"NorthBorough(MA)","Edison(NJ)","Pittsburgh(PA)", "AllenTown(PA)", "Martinsburg(WV)"," Charlotte(NC)","Atlanta(GA)","Orlando(FL)","Memphis(TN)","Grove City(OH)","IndianaPolis(IN)","Detroit(MI)","NewBerlin(WI)","Minneapolis(MN)","St.Louis(MO)","Kansas(KS)","Dallas(TX)","Houston(TX)","Denver(CO)","SaltLakeCity(UT)","Phoenix(AZ)","LosAngeles(CA)","Chino(CA)","Sacremento(CA)","Seattle(WA)"};
		
		JLabel lblPackageInformation = new JLabel("Package Information");
		lblPackageInformation.setBounds(149, 28, 146, 15);
		contentPane.add(lblPackageInformation);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setBounds(23, 51, 70, 15);
		contentPane.add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(23, 91, 105, 15);
		contentPane.add(lblDestination);
		
		JComboBox comboBox = new JComboBox(List);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(true);
		        JComboBox cb = (JComboBox)e.getSource();
		        String cityName = (String)cb.getSelectedItem();
		        System.out.println(cityName);
		        Source = cityName;
			}
		});
		comboBox.setBounds(131, 55, 265, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(List);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(true);
		        JComboBox cb = (JComboBox)e.getSource();
		        String cityName2 = (String)cb.getSelectedItem();
		        System.out.println(cityName2);
		        Destination = cityName2;
		        
			}
		});
		comboBox_1.setBounds(131, 86, 265, 20);
		contentPane.add(comboBox_1);
		
		String[] weightList = {"5","10","15","20","25","30","35","40","45","50"};
		JLabel lblWeight = new JLabel("Weight(in lbs)");
		lblWeight.setBounds(23, 138, 105, 15);
		contentPane.add(lblWeight);
		JComboBox comboBox_2 = new JComboBox(weightList);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_2.setEnabled(true);
		        JComboBox cb2 = (JComboBox)e.getSource();
		        String wgt = (String)cb2.getSelectedItem();
		        Double weight = Double.valueOf(wgt);
		        System.out.println(weight);
			}
		});
		comboBox_2.setBounds(131, 138, 265, 20);
		contentPane.add(comboBox_2);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("OK")) {
					 String aToZ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // 36 letter.
						//  String randomStr=generateRandom(aToZ);
						    Random rand=new Random();
						    StringBuilder res=new StringBuilder();
						    for (int i = 0; i < 6; i++) {
						       int randIndex=rand.nextInt(aToZ.length()); 
						       res.append(aToZ.charAt(randIndex)); 
						    }
						       String trackingnum = res.toString();
						       System.out.println(trackingnum);
						       JOptionPane.showInputDialog("Your Tracking number is",trackingnum);
						        
						       String T = "NULL";
						       String InSt ="NULL";
						   InsertRow pt= new InsertRow();
						   
							try {
								pt.InsertingRow(T,InSt,Source,Destination,trackingnum,weight);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
					 
				}
			}
		});
		btnOk.setBounds(190, 200, 117, 25);
		contentPane.add(btnOk);
		
		
		
	}
}
