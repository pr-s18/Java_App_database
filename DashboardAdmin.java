import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class DashboardAdmin extends JFrame implements ActionListener {

	JLabel lblWelcome;
	JLabel lblImage;
	
	JButton btnUser;
	JButton btnDesignation;
	JButton btnProject;
	JButton btnPhase;
	JButton btnCancel;
	JButton btnViewUser;
	JButton btnViewProjects;
	JButton btnViewDesignations;

	
	public void label () {
		lblWelcome = new JLabel ("     WELCOME to TECH HUB");
		lblWelcome.setFont (new Font ("Algerian", Font.BOLD, 40));
		lblWelcome.setBounds (85, 55, 600, 45);
		lblImage = new JLabel (new ImageIcon ("def.jpg"));
		lblImage.setBounds (100, 135, 470, 230 );
	}	

	public void button () {
		btnUser = new JButton ("USER");
		btnUser.setBounds (150, 400, 125, 30);
		btnDesignation = new JButton ("DESIGNATION");
		btnDesignation.setBounds (450, 400, 125, 30);
		btnProject = new JButton ("PROJECT");
		btnProject.setBounds (150, 455, 125, 30);
		btnPhase = new JButton ("PHASE");
		btnPhase.setBounds (450, 455, 125, 30);
		btnCancel = new JButton ("CANCEL");
		btnCancel.setBounds (300, 510, 125, 30);
		btnViewUser = new JButton ("View All Users");
		btnViewUser.setBounds (600, 170, 165, 30);
		btnViewProjects = new JButton ("View All Projects");
		btnViewProjects.setBounds (600, 240, 165, 30);
		btnViewDesignations = new JButton ("View All Designations");
		btnViewDesignations.setBounds (600, 310, 165, 30);
	}

	public DashboardAdmin () {
		setLayout (null);
		
		label ();
		add (lblWelcome);
		add (lblImage);

		button ();
		add (btnUser);
		btnUser.addActionListener (this);
		add (btnDesignation);
		btnDesignation.addActionListener (this);
		add (btnProject);
		btnProject.addActionListener (this);
		add (btnPhase);
		btnPhase.addActionListener (this);
		add (btnCancel);
		btnCancel.addActionListener (this);
		add (btnViewUser);
		btnViewUser.addActionListener (this);
		add (btnViewProjects);
		btnViewProjects.addActionListener (this);
		add (btnViewDesignations);
		btnViewDesignations.addActionListener (this);
	}

	public void actionPerformed (ActionEvent e) {
		if (e.getSource () == btnUser) {
			UIAddUser u = new UIAddUser ();
			u.setVisible (true);
			u.setSize (570, 760);	
		}

		if (e.getSource () == btnDesignation) {
			UIDesignation d = new UIDesignation ();
			d.setVisible (true);
			d.setSize (570, 510);	
		}

		if (e.getSource () == btnProject) {
			UIAddProject p = new UIAddProject ();
			p.setVisible (true);
			p.setSize (570, 740);	
		}

		if (e.getSource () == btnPhase) {
			CurrentStatus c = new CurrentStatus ();
			c.setVisible (true);
			c.setSize (700, 475);	
		}
		
/*		if (e.getSource () == btnViewUser) {
			ViewAllUsers vu = new ViewAllUsers (this,"View all users ",true);
			vu.setVisible (true);
			vu.setSize (size);
		}*/

		if (e.getSource () == btnViewUser) {
			ViewAllUsers vu = new ViewAllUsers ();
			vu.setVisible (true);
			vu.setSize (1300, 400);
		}

		if (e.getSource () == btnViewProjects) {
			ViewAllProjects vp = new ViewAllProjects ();
			vp.setVisible (true);
			vp.setSize (1000, 400);
		}

		if (e.getSource () == btnViewDesignations) {
			ViewAllDesignations vd = new ViewAllDesignations ();
			vd.setVisible (true);
			vd.setSize (1000, 400);
		}

		if (e.getSource () == btnCancel) {
			this.dispose ();
		}

	}
	
	public static void main (String arg[]) {
		DashboardAdmin frame = new DashboardAdmin ();
		frame.setVisible (true);
		frame.setSize (770, 800);
		frame.setTitle ("WELCOME");
		frame.setDefaultLookAndFeelDecorated (true);		
	}
}