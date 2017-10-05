import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class DashboardEmployee extends JFrame implements ActionListener {
	
	JLabel lblTitle;
	JLabel lblImage;
	JLabel lblGender;
	JLabel lblDesg_name;
	JLabel lblMobile;
	

	JButton btnUser;
	JButton btnProjects;
	JButton btnPhase;
	JButton btnLogout;

	BOUser user = Invoker.user;
	

	public void label () {
		String[] name = user.getName ().split ("/");
		lblTitle = new JLabel ("          WELCOME  " + name[0]);
		
		lblTitle.setFont (new Font ("Elephant", Font.BOLD, 32));
		lblTitle.setOpaque (true);
		lblTitle.setBackground (Color.BLUE.darker ());
		lblTitle.setForeground (Color.WHITE);
		lblTitle.setBounds (60, 55, 760, 40);
		lblImage = new JLabel (new ImageIcon ("Employee.jpg"));
		lblImage.setBounds (330, 175, 550, 300);
		lblGender = new JLabel (user.getGender ());
		lblGender.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblGender.setBounds (100, 120, 150, 30);
		//System.out.println(user.getDesignation ().getName ());
		lblDesg_name = new JLabel (user.getDesignation ().getName ());
		lblDesg_name.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblDesg_name.setBounds (100, 150, 150, 30);
		lblMobile = new JLabel (user.getMobile ());
		lblMobile.setFont (new Font ("Calibri", Font.BOLD, 20));
		lblMobile.setBounds (100, 180, 150, 30);
	}

	public void button () {
		btnUser = new JButton ("User");
		btnUser.setBounds (140, 245, 125, 32);
		btnProjects = new JButton ("Projects");
		btnProjects.setBounds (140, 295, 125, 32);
		btnPhase = new JButton ("Phase");
		btnPhase.setBounds (140, 345, 125, 32);
		btnLogout = new JButton ("Logout");
		btnLogout.setBounds (140, 395, 125, 32);
	}

	public DashboardEmployee () {
		setLayout (null);

		label ();
		add (lblTitle);
		add (lblImage);
		add (lblGender);
		add (lblDesg_name);
		add (lblMobile);

		button ();
		add (btnUser);
		btnUser.addActionListener (this);
		add (btnProjects);
		btnProjects.addActionListener (this);
		add (btnPhase);
		btnPhase.addActionListener (this);
		add (btnLogout);
		btnLogout.addActionListener (this);
	}
	
	public void actionPerformed (ActionEvent e) {
		if (e.getSource () == btnLogout) {
			user = null;
			this.dispose ();
		}
		if (e.getSource () == btnUser) {
			UIAddUser u = new UIAddUser ();
			u.setVisible (true);
			u.setSize (570, 780);
		}
		if (e.getSource () == btnProjects) {
			UIAddProject p = new UIAddProject ();
			p.setVisible (true);
			p.setSize (570, 740);
		}
		if (e.getSource () == btnPhase) {
			CurrentStatus c = new CurrentStatus ();
			c.setVisible (true);
			c.setSize (670, 475);
		}
	}
	
	public static void main (String arg[]) {
		DashboardEmployee frame = new DashboardEmployee ();
		frame.setVisible (true);
		frame.setTitle ("Employee Dashboard");
		frame.setDefaultLookAndFeelDecorated (true);	
	}

}