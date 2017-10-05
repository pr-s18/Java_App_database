import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Login extends JFrame implements ActionListener {

	JLabel lblTitle;
	JLabel lblEmail;
	JLabel lblPassword;
	JLabel lblImage;

	JTextField txtEmail;
	JPasswordField pfPassword;

	JButton btnLogin;
	JButton btnCancel;


	public void label () {
		lblTitle = new JLabel ("            TECH HUB");
		lblTitle.setFont (new Font ("Elephant", Font.BOLD, 35));
		lblTitle.setOpaque (true);
		lblTitle.setBackground (Color.BLUE.darker ());
		lblTitle.setForeground (Color.WHITE);
		lblTitle.setBounds (70, 40, 547, 45);
		lblEmail = new JLabel ("EMAIL ID");
		lblEmail.setBounds (70, 145, 100, 28);
		lblPassword = new JLabel ("USER ID");
		lblPassword.setBounds (70, 198, 100, 28);
		lblImage = new JLabel (new ImageIcon ("abc.jpg"));
		lblImage.setBounds (467, 130, 150, 120);
	}

	public void field () {
		txtEmail = new JTextField ();
		txtEmail.setBounds (205, 145, 175, 28);
		pfPassword = new JPasswordField ();
		pfPassword.setBounds (205, 198, 175, 28);
		btnLogin = new JButton ("LOGIN");
		btnLogin.setBounds (100, 280, 125, 35);
		btnCancel = new JButton ("CANCEL");
		btnCancel.setBounds (300, 280, 125, 35);
	}

	public Login () {
		setLayout (null);
		
		label ();
		add (lblTitle);
		add (lblEmail);
		add (lblPassword);
		add (lblImage);
		
		field ();
		add (txtEmail);
		add (pfPassword);
		add (btnLogin);
		btnLogin.addActionListener (this);
		add (btnCancel);
		btnCancel.addActionListener (this);

	}

	public void actionPerformed (ActionEvent e) {
		if (e.getSource () == btnCancel) {
			this.dispose ();
		}
		if (e.getSource () == btnLogin) {
			
		BOUser user=DAUser.getForLogin (txtEmail.getText (), Integer.parseInt (pfPassword.getText ()));
			if(user==null) {	
				JOptionPane.showMessageDialog (null, "ERROR!!!");
			}
			else{
				Invoker.user=user;
				if(user.getType().equals("Employee")) {
					DashboardEmployee d=new DashboardEmployee();
					d.setVisible(true);
					d.setSize(900,590);
					this.dispose ();
				}
				if(user.getType().equals("Customer")) {
					DashboardCustomer de=new DashboardCustomer();
					de.setVisible(true);
					de.setSize(785,670);
					this.dispose ();
				}
				if (user.getType().equals ("Admin")) {
					DashboardAdmin dd = new DashboardAdmin ();
					dd.setVisible (true);
					dd.setSize (900, 640);
					this.dispose ();
				}
			}
		}
	}
	
	public static void main (String arg[]) {
		Login frame = new Login ();
		frame.setVisible (true);
		frame.setSize (700, 420);
		frame.setTitle ("Login");
		frame.setDefaultLookAndFeelDecorated (true);
	}
}