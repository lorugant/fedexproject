import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FedexSwings extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		connection cs=new connection();
		cs.connsetup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FedexSwings frame = new FedexSwings();
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
	public FedexSwings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] List = {"NorthBorough(MA)","Edison(NJ)","Pittsburgh(PA)", "AllenTown(PA)", "Martinsburg(WV)"," Charlotte(NC)","Atlanta(GA)","Orlando(FL)","Memphis(TN)","Grove City(OH)","IndianaPolis(IN)","Detroit(MI)","NewBerlin(WI)","Minneapolis(MN)","St.Louis(MO)","Kansas(KS)","Dallas(TX)","Houston(TX)","Denver(CO)","SaltLakeCity(UT)","Phoenix(AZ)","LosAngeles(CA)","Chino(CA)","Sacremento(CA)","Seattle(WA)"};
		
		JLabel lblFedexPackagingInformation = new JLabel("FEDEX");
		lblFedexPackagingInformation.setBounds(190, 55, 61, 15);
		contentPane.add(lblFedexPackagingInformation);
		
		JButton btnEnterPackageInformation = new JButton("Enter Package Information");
		btnEnterPackageInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("Enter Package Information")) {
					FedexSwings2 nw = new FedexSwings2();
					nw.NewScreen();
				}
			}
		});
		btnEnterPackageInformation.setBounds(88, 99, 273, 25);
		contentPane.add(btnEnterPackageInformation);
		
		JButton btnNewButton = new JButton("Track my Package");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("Track my Package")) {
					FedexSwings4 nw4 = new FedexSwings4();
					nw4.NewScreen4();
				}
			}
		});
		btnNewButton.setBounds(88, 152, 284, 25);
		contentPane.add(btnNewButton);
	}
}
