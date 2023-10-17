/* 
 * NAME: Tracy Bullock
 * CLASS: CMIS 242 (2215)
 * DATE: June 03, 2021
 * 
 * This program is made to give the current local and international
 * times of selected regions. There are currently only two international
 * regions to select from, Frankfurt and charlotte. The user can click
 * the various tabs to select between their local time and international times.
 * 
 */

package asg3Clock;

import javax.swing.*;
import javax.swing.GroupLayout.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.LayoutStyle.ComponentPlacement;

public class Clock_Main extends JFrame {

	private JPanel contentPane, localTimePanel, fraTimePanel, cltTimePanel;
	private JTabbedPane tabbedTimePane;
	private JLabel lblCharlotteTime, lblFraTime, lblLocalTime;
	private Seconds localTime, frankfurtTime, charlotteTime;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private int delay = 1000;

	//////////////////////////////////////
	// Launch the application.
	////////////////////////////////////
	public static void main(String[] args) {
		
		///////////////////////////
		// Customize DialogPanes
		/////////////////////////
		JDialog.setDefaultLookAndFeelDecorated(true);
		UIManager UI = new UIManager();
		UI.put("OptionPane.messageFont", new FontUIResource("Arial", Font.BOLD, 12));
		UI.put("OptionPane.background", new ColorUIResource(144,146,151));
		UI.put("OptionPane.messageForeground", new ColorUIResource(252,252,252));
		UI.put("Panel.background", new ColorUIResource(112,112,114));
		
		intro();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clock_Main frame = new Clock_Main();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	////////////////////////////
	// Create the frame.
	//////////////////////////
	public Clock_Main() {

		initComponents();
		createEvents();

	}
	
	/////////////////////////////////////////////////////////
	// method to give class info and indroduce program
	///////////////////////////////////////////////////////
	public static void intro() {
					
		// window for class info
		JOptionPane.showInternalMessageDialog(null, "\n      " + 
				"NAME: Tracy Bullock\n      " + 
				"CLASS: CMIS 242 (2215)               \n      DATE: 06/03/2021\n ", 
				"Class Project", JOptionPane.INFORMATION_MESSAGE);
					
		// window for app intro
		JOptionPane.showInternalMessageDialog(null, "\n                 Welcome to the International Clock APP!                 \n" + 
				"\n                                     ::::::::::::::::::::::::\n"
				+ "                                     ::    *NOTE*    ::\n"
				+ "                                     ::::::::::::::::::::::::\n\n"
				+ "                    The beta version only has 3 options:"
				+ "\n                                -- local time"
				+ "\n                                -- Frankfurt, Germany"
				+ "\n                                -- Charlotte, North Carolina\n ", 
				"International Clock", JOptionPane.PLAIN_MESSAGE);
		}
	
	///////////////////////////////
	// method to say goodbye
	/////////////////////////////
	public static void outro() {
		
		JOptionPane.showInternalMessageDialog(null, "\n      Thank you for using the "
				+ "International Clock Program.      \n" + 
				"\n                                     Have a great day!\n ", 
				"GoodBye", JOptionPane.PLAIN_MESSAGE);
	}
	
	////////////////////////////////////////////////////////////////////
	// This method contains all of the code for creating and
	// initializing components.
	//////////////////////////////////////////////////////////////////
	private void initComponents() {
		
		setTitle("International Clock");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clock_Main.class.getResource("/resources/worlClock.png")));
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedTimePane = new JTabbedPane(JTabbedPane.TOP);
		tabbedTimePane.setForeground(Color.LIGHT_GRAY);
		tabbedTimePane.setBackground(new Color(0, 153, 204));
		tabbedTimePane.setBounds(0, 0, 438, 265);
		contentPane.add(tabbedTimePane);
		
		localTimePanel = new JPanel();
		localTimePanel.setBackground(Color.LIGHT_GRAY);
		tabbedTimePane.addTab("Local Time", null, localTimePanel, null);
		
		JLabel lblLocal = new JLabel("Local Time:");
		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		localTime = new Seconds("loc");
		lblLocalTime = new JLabel(localTime.getTime());
		lblLocalTime.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Clock_Main.class.getResource("/resources/homeIcon.png")));
		GroupLayout gl_localTimePanel = new GroupLayout(localTimePanel);
		gl_localTimePanel.setHorizontalGroup(
			gl_localTimePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_localTimePanel.createSequentialGroup()
					.addGap(41)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_localTimePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_localTimePanel.createSequentialGroup()
							.addGap(118)
							.addComponent(lblLocalTime, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_localTimePanel.createSequentialGroup()
							.addGap(50)
							.addComponent(lblLocal, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
		);
		gl_localTimePanel.setVerticalGroup(
			gl_localTimePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_localTimePanel.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_localTimePanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLocal, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblLocalTime, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		localTimePanel.setLayout(gl_localTimePanel);
		
		fraTimePanel = new JPanel();
		fraTimePanel.setBackground(Color.LIGHT_GRAY);
		tabbedTimePane.addTab("Frankfurt am Main", null, fraTimePanel, null);
		
		JLabel lblFra = new JLabel("Frankfurt am Main:");
		lblFra.setFont(new Font("Tahoma", Font.PLAIN, 27));
		frankfurtTime = new Seconds("fra");
		
		lblFraTime = new JLabel(frankfurtTime.getTime());
		lblFraTime.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Clock_Main.class.getResource("/resources/fraIcon.png")));
		GroupLayout gl_fraTimePanel = new GroupLayout(fraTimePanel);
		gl_fraTimePanel.setHorizontalGroup(
			gl_fraTimePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_fraTimePanel.createSequentialGroup()
					.addGap(100)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(126, Short.MAX_VALUE))
				.addGroup(gl_fraTimePanel.createSequentialGroup()
					.addContainerGap(126, Short.MAX_VALUE)
					.addComponent(lblFra)
					.addGap(80))
				.addGroup(gl_fraTimePanel.createSequentialGroup()
					.addContainerGap(265, Short.MAX_VALUE)
					.addComponent(lblFraTime, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
		);
		gl_fraTimePanel.setVerticalGroup(
			gl_fraTimePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_fraTimePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFra, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblFraTime, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		fraTimePanel.setLayout(gl_fraTimePanel);
		
		cltTimePanel = new JPanel();
		cltTimePanel.setBackground(Color.LIGHT_GRAY);
		tabbedTimePane.addTab("Charlote, NC", null, cltTimePanel, null);
		
		JLabel lblCharlotteNc = new JLabel("Charlotte, NC:");
		lblCharlotteNc.setFont(new Font("Tahoma", Font.PLAIN, 27));
		charlotteTime = new Seconds("clt");
		
		lblCharlotteTime = new JLabel(charlotteTime.getTime());
		lblCharlotteTime.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Clock_Main.class.getResource("/resources/ncIcon.png")));
		GroupLayout gl_cltTimePanel = new GroupLayout(cltTimePanel);
		gl_cltTimePanel.setHorizontalGroup(
			gl_cltTimePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_cltTimePanel.createSequentialGroup()
					.addContainerGap(105, Short.MAX_VALUE)
					.addGroup(gl_cltTimePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_cltTimePanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblCharlotteTime, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCharlotteNc, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
					.addGap(82))
		);
		gl_cltTimePanel.setVerticalGroup(
			gl_cltTimePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_cltTimePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCharlotteNc, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCharlotteTime, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		cltTimePanel.setLayout(gl_cltTimePanel);
		
	}
	
	////////////////////////////////////////////////////////////////////
	// This method contains all of the code for creating events.
	///////////////////////////////////////////////////////////////////
	private void createEvents() {
		
		////////////////////////////////////////////
		// listener to update the time by seconds
		//////////////////////////////////////////
	    ActionListener updateTime = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				localTime = new Seconds("loc");
				lblLocalTime.setText(localTime.getTime());
				frankfurtTime = new Seconds("fra");
				lblFraTime.setText(frankfurtTime.getTime());
				charlotteTime = new Seconds("clt");
				lblCharlotteTime.setText(charlotteTime.getTime());
			}
	      };
	      
	      new Timer(delay, updateTime).start();
	      
		///////////////////////////////////////
		// listener to detect program close
		/////////////////////////////////////
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				int close = JOptionPane.showConfirmDialog(null, "\n  Would you like to close this application?        ", 
						"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (close == JOptionPane.YES_OPTION) {
					outro();
					System.exit(0);;
				}
			}
		});
	      

	}
}
