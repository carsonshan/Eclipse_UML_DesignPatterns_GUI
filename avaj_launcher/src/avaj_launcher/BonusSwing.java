package avaj_launcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class BonusSwing extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static BonusSwing window;

	private BonusSwing () {}
	
	public static void initWindow() {
		if (window == null) {
			window = new BonusSwing();
			window.init();
		}
	}
	
	private void init() {
		this.setTitle("Generator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
/* //////////////////////////////////////////////////////////////////////////////// */	
		JPanel panel1 = new JPanel();
	
		panel1 = new JPanel(new BorderLayout());
		panel1.setBackground(new Color(255,255,255));
		panel1.setLayout(null);
//		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		panel1.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createTitledBorder("New Aircraft"),
							BorderFactory.createEmptyBorder(10,10,10,10)));
		
		
		
		JLabel idnum0 = new JLabel("Cycle(s) :");
		idnum0.setBounds(16, 40, 66, 20);
		panel1.add(idnum0);
				
		JTextField textField_0 = new JTextField();
		textField_0.setToolTipText("max value 255");
		textField_0.setBounds(76, 40, 46, 22);
		panel1.add(textField_0);
		
		JLabel type = new JLabel("Type :");
		type.setBounds(16, 90, 66, 20);
		panel1.add(type);
		
		
		ButtonGroup groupe = new ButtonGroup();
		
		JRadioButton button1 = new JRadioButton(" JetPlane");
		groupe.add(button1);
		button1.addActionListener(new StateListener());
		button1.setBounds(16, 120, 90, 25);
		panel1.add(button1);
		
		JRadioButton button2 = new JRadioButton(" Helicopter");
		groupe.add(button2);
		button2.addActionListener(new StateListener());
		button2.setBounds(16, 150, 110, 25);
		panel1.add(button2);
		
		JRadioButton button3 = new JRadioButton(" Baloon");
		groupe.add(button3);
		button3.addActionListener(new StateListener());
		button3.setBounds(16, 180, 100, 25);
		panel1.add(button3);
		
		JRadioButton button4 = new JRadioButton(" Rocket");
		groupe.add(button4);
		button4.addActionListener(new StateListener());
		button4.setBounds(16, 210, 100, 25);
		panel1.add(button4);
		
		JRadioButton button5 = new JRadioButton(" Drone");
		groupe.add(button5);
		button5.addActionListener(new StateListener());
		button5.setBounds(16, 240, 100, 25);
		panel1.add(button5);
		
	

		
		JLabel idnum1 = new JLabel("Name :");
		idnum1.setBounds(16, 290, 66, 20);
		panel1.add(idnum1);
				
		JTextField textField_1 = new JTextField();
		textField_1.setToolTipText("max value 999");
		textField_1.setBounds(64, 290, 46, 22);
		panel1.add(textField_1);
		
		JLabel idnum2 = new JLabel("Longitude :");
		idnum2.setBounds(16, 340, 76, 20);
		panel1.add(idnum2);
				
		JTextField textField_2 = new JTextField();
		textField_2.setToolTipText("max value 999");
		textField_2.setBounds(91, 340, 46, 22);
		panel1.add(textField_2);
		
		JLabel idnum3 = new JLabel("Latitude :");
		idnum3.setBounds(16, 390, 66, 20);
		panel1.add(idnum3);
				
		JTextField textField_3 = new JTextField();
		textField_3.setToolTipText("max value 999");
		textField_3.setBounds(79, 390, 46, 22);
		panel1.add(textField_3);
	
		JLabel idnum4 = new JLabel("Height :");
		idnum4.setBounds(16, 440, 66, 20);
		panel1.add(idnum4);
				
		JTextField textField_4 = new JTextField();
		textField_4.setToolTipText("max value 999");
		textField_4.setBounds(70, 440, 46, 22);
		panel1.add(textField_4);
		
		
/* //////////////////////////////////////////////////////////////////////////////// */	
		JPanel panel2 = new JPanel();
		
		panel2 = new JPanel(new BorderLayout());
		panel2.setBackground(new Color(255,255,255));
		panel2.setLayout(null);
//		panel2.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		panel2.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createTitledBorder("File saved"),
							BorderFactory.createEmptyBorder(10,10,10,10)));



/* //////////////////////////////////////////////////////////////////////////////// */	
		JPanel panelboutton = new JPanel(new BorderLayout());
		  panelboutton.setLayout(null);
		  panelboutton.setSize(50, 100);
		  
		  
			
		JCheckBox flag2 = new JCheckBox("-g : generate MD5");
		flag2.addItemListener(new ItemListen());
		flag2.setBounds(120, 15, 290, 25);
		panelboutton.add(flag2);
		  	  
		  
		  JButton fin = new JButton ("<html><body><u>F</u>inish</body></html>");
		  fin.setBounds(310, 55, 90, 25);
		  fin.setEnabled(false);
		  panelboutton.add(fin);
		  
		  JButton can = new JButton ("<html><body><u>C</u>ancel</body></html>");
		  can.setBounds(405, 55, 90, 25);
		  panelboutton.add(can);

		  
		  
/* ******************************************************************************* */			
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel1,panel2);
		splitPane2.setDividerLocation(200);
		splitPane2.setOneTouchExpandable(false);
		
		JSplitPane splitPane3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,splitPane2,panelboutton);
		splitPane3.setDividerLocation(520);
		splitPane3.setOneTouchExpandable(true);
		
		this.add(splitPane3);
		this.setSize(518,650);
		this.setResizable(false);
		this.setVisible(true);
	}		
	
}