import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

class CurrentStatus extends JFrame implements ActionListener {

	JLabel lblTitle;
	JLabel lblPhase;
	JLabel lblProjects;
	JLabel lblName;
	JLabel lblTechnology;
	JLabel lblStatus;
	JLabel lblDeadline;
	JLabel lblCustomer;
	JLabel lblName1;
	JLabel lblTechnology1;
	JLabel lblStatus1;
	JLabel lblDeadline1;
	JLabel lblCustomer1;

	JComboBox cbPhase;
	JComboBox cbProjects;

	JButton btnExit;
	
	public void label () {
		lblTitle = new JLabel ("                 Phase");
		lblTitle.setBounds (120, 55, 400, 35);
		lblTitle.setFont (new Font ("Elephant", Font.BOLD, 30));
		lblTitle.setOpaque (true);
		lblTitle.setBackground (Color.BLUE.darker ());
		lblTitle.setForeground (Color.WHITE);
		lblPhase =  new JLabel("Phase");
		lblPhase.setBounds (70, 150, 100, 25);
		lblProjects =  new JLabel("Projects");
		lblProjects.setBounds (70, 190, 100, 25);
		lblName1 =  new JLabel("Name");
		lblName1.setBounds (55, 245, 100, 25);
		lblTechnology1 =  new JLabel("Technology");
		lblTechnology1.setBounds (295, 245, 100, 25);
		lblStatus1 =  new JLabel("Status");
		lblStatus1.setBounds (195, 245, 100, 25);
		lblDeadline1 =  new JLabel("Deadline");
		lblDeadline1.setBounds (415, 245, 100, 25);
		lblCustomer1 =  new JLabel("Customer Id");
		lblCustomer1.setBounds (535, 245, 100, 25);

		lblName =  new JLabel();
		lblName.setOpaque (true);
		lblName.setBackground (Color.WHITE);
		lblName.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblName.setBounds (50, 280, 125, 25);
		lblTechnology =  new JLabel();
		lblTechnology.setOpaque (true);
		lblTechnology.setBackground (Color.WHITE);
		lblTechnology.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblTechnology.setBounds (290, 280, 100, 25);
		lblStatus =  new JLabel();
		lblStatus.setOpaque (true);
		lblStatus.setBackground (Color.WHITE);
		lblStatus.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblStatus.setBounds (190, 280, 80, 25);
		lblDeadline =  new JLabel();
		lblDeadline.setOpaque (true);
		lblDeadline.setBackground (Color.WHITE);
		lblDeadline.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblDeadline.setBounds (410, 280, 100, 25);
		lblCustomer =  new JLabel();
		lblCustomer.setOpaque (true);
		lblCustomer.setBackground (Color.WHITE);
		lblCustomer.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblCustomer.setBounds (530, 280, 100, 25);

	}

	public void combobox () {
		cbPhase = new JComboBox (new String[] {"Planning", "Analysis", "Design", "Coding", "Testing", "Installation"});
		cbPhase.setBounds (200, 150, 275, 25);
		cbProjects = new JComboBox ();
		cbProjects.setBounds (200, 190, 275, 25);
	}

	public void button () {
		btnExit = new JButton ("EXIT");
		btnExit.setBounds (250, 350, 100, 25);
	}

	public CurrentStatus () {
		setLayout (null);
		label ();
		add (lblTitle);
		add (lblPhase);
		add (lblProjects);
		
		add (lblName);
		add (lblTechnology);
		add (lblStatus);
		add (lblDeadline);
		add (lblCustomer);

		add (lblName1);
		add (lblTechnology1);
		add (lblStatus1);
		add (lblDeadline1);
		add (lblCustomer1);

		combobox ();
		add (cbPhase);
		cbPhase.addActionListener (this);
		add (cbProjects);
		cbProjects.addActionListener (this);

		button ();
		add (btnExit);
		btnExit.addActionListener (this);
	}

	public void actionPerformed (ActionEvent e) {
		if (e.getSource () == btnExit) {
			this.dispose ();
		}
		if (e.getSource () == cbPhase) {
		cbProjects.removeAllItems ();
		Vector vv=DAProject.getByPhase ( (String) cbPhase.getSelectedItem ());
		for(Object oo:vv){
		
		cbProjects.addItem(oo);

		}
			

		}
		if (e.getSource () == cbProjects) {
			
			
			BOProject p = (BOProject)cbProjects.getSelectedItem ();
			if (p != null) {
			lblName.setText (p.getName());
			lblTechnology.setText (p.getTechnology ());
			lblStatus.setText (p.getStatus ());
			lblDeadline.setText (p.getDeadline ());
			lblCustomer.setText (String.valueOf(p.getUser ().getId ()));
			}
		}
		
	}

	public static void main (String arg[]) {
		CurrentStatus frame = new CurrentStatus ();
		frame.setVisible (true);
		frame.setSize (670, 475);
		frame.setTitle ("Phase");
		frame.setDefaultLookAndFeelDecorated (true); 
	} 
}