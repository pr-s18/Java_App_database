import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class DashboardCustomer extends JFrame implements ActionListener {

	JLabel lblTitle;
	JLabel lblImage;
	JLabel lblId;
	JLabel lblMobile;
	JLabel lblGender;
	JLabel lblProjects;
	JLabel lblStartdate;
	JLabel lblTechnology;
	JLabel lblStatus;
	JLabel lblDeadline;
	JLabel lblBudget;
	JLabel lblPhase;

	JLabel lbl1Startdate;
	JLabel lbl1Technology;
	JLabel lbl1Status;
	JLabel lbl1Deadline;
	JLabel lbl1Budget;
	JLabel lbl1Phase;

	JComboBox cbProjects;
	
	JButton btnExit;
	BOUser user=Invoker.user;
	
	public void label () {
		
		String[] name= user.getName ().split ("/");
 
		lblTitle = new JLabel ("    WELCOME "+ name[0]);
		lblTitle.setFont (new Font ("Elephant", Font.BOLD, 32));
		lblTitle.setOpaque (true);
		lblTitle.setBackground (Color.BLUE.darker ());
		lblTitle.setForeground (Color.WHITE);
		lblTitle.setBounds (100, 55, 550, 40);
		lblImage = new JLabel (new ImageIcon ("customer.jpg"));
		lblImage.setBounds (335, 115, 350, 200);
		lblId = new JLabel (String.valueOf (user.getId ()));
		lblId.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblId.setBounds (130, 135, 100, 30);
		lblMobile = new JLabel (user.getMobile ());
		lblMobile.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblMobile.setBounds (130, 160, 100, 30);
		lblGender = new JLabel (user.getGender());
		lblGender.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblGender.setBounds (130, 185, 100, 30);
		lblProjects = new JLabel ("Projects");
		lblProjects.setForeground (Color.RED);
		lblProjects.setFont (new Font ("Jokerman", Font.BOLD, 20));
		lblProjects.setBounds (130, 225, 100, 30);


		lblStartdate = new JLabel ();
		lblStartdate.setOpaque (true);
		lblStartdate.setBackground (Color.WHITE);
		lblStartdate.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblStartdate.setBounds (100, 390, 150, 25);
		lblTechnology = new JLabel ();
		lblTechnology.setOpaque (true);
		lblTechnology.setBackground (Color.WHITE);
		lblTechnology.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblTechnology.setBounds (300, 390, 150, 25);
		lblStatus = new JLabel ();
		lblStatus.setOpaque (true);
		lblStatus.setBackground (Color.WHITE);
		lblStatus.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblStatus.setBounds (500, 390, 150, 25);
		lblDeadline = new JLabel ();
		lblDeadline.setOpaque (true);
		lblDeadline.setBackground (Color.WHITE);
		lblDeadline.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblDeadline.setBounds (100, 495, 150, 25);
		lblBudget = new JLabel ();
		lblBudget.setOpaque (true);
		lblBudget.setBackground (Color.WHITE);
		lblBudget.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblBudget.setBounds (300, 495, 150, 25);
		lblPhase = new JLabel ();
		lblPhase.setOpaque (true);
		lblPhase.setBackground (Color.WHITE);
		lblPhase.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblPhase.setBounds (500, 495, 150, 25);

		lbl1Startdate = new JLabel ("Start Date");
		lbl1Startdate.setFont (new Font ("Calibri", Font.BOLD, 20));
		lbl1Startdate.setBounds (100, 345, 150, 25);
		lbl1Technology = new JLabel ("Technology");
		lbl1Technology.setFont (new Font ("Calibri", Font.BOLD, 20));
		lbl1Technology.setBounds (300, 345, 150, 25);
		lbl1Status = new JLabel ("Status");
		lbl1Status.setFont (new Font ("Calibri", Font.BOLD, 20));
		lbl1Status.setBounds (500, 345, 150, 25);
		lbl1Deadline = new JLabel ("Deadline");
		lbl1Deadline.setFont (new Font ("Calibri", Font.BOLD, 20));
		lbl1Deadline.setBounds (100, 450, 150, 25);
		lbl1Budget = new JLabel ("Budget");
		lbl1Budget.setFont (new Font ("Calibri", Font.BOLD, 20));
		lbl1Budget.setBounds (300, 450, 150, 25);
		lbl1Phase = new JLabel ("Phase");
		lbl1Phase.setFont (new Font ("Calibri", Font.BOLD, 20));
		lbl1Phase.setBounds (500, 450, 150, 25);

	}

	public void combobox () {
		cbProjects = new JComboBox (DAProject.getAll (user.getId ()));
		cbProjects.setBounds (130, 275, 200, 25);
	}

	public void button () {
		btnExit = new JButton ("EXIT");
		btnExit.setBounds (225, 550, 100, 25);
	}

	public DashboardCustomer () {
		setLayout (null);
		
		label ();
		add (lblTitle);
		add (lblImage);
		add (lblId);
		add (lblMobile);
		add (lblGender);
		add (lblProjects); 
		add (lblStartdate);
		add (lblTechnology);
		add (lblStatus);
		add (lblDeadline);
		add (lblBudget);
		add (lblPhase);
		
		add (lbl1Startdate);
		add (lbl1Technology);
		add (lbl1Status);
		add (lbl1Deadline);
		add (lbl1Budget);
		add (lbl1Phase);

		combobox ();
		add (cbProjects);
		cbProjects.addActionListener (this);

		button ();
		add (btnExit);
		btnExit.addActionListener (this);
		
	}

	public void actionPerformed (ActionEvent e) {
		if (e.getSource () == btnExit) {
			user = null;
			this.dispose ();
		}
		if (e.getSource () == cbProjects) {
			BOProject p = ((BOProject)cbProjects.getSelectedItem ());
			if (p != null) {
			lblStartdate.setText (p.getStartdate());
			lblTechnology.setText (p.getTechnology ());
			lblStatus.setText (p.getStatus ());
			lblDeadline.setText (p.getDeadline ());
			lblBudget.setText (p.getBudget ());
			lblPhase.setText (p.getPhase ());
			}

		}

	}

	public static void main (String arg[]) {
		DashboardCustomer frame = new DashboardCustomer ();
		frame.setVisible (true);
		frame.setTitle ("Customer Dashboard");
		frame.setDefaultLookAndFeelDecorated (true);
	}

}