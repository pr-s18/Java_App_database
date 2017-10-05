import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class UIDesignation extends JFrame implements ActionListener {

	JLabel lblTitle;
	JLabel lblId;
	JLabel lblName;
	JLabel lblSalary;
	JLabel lblWorkprofile;

	JTextField txtId;
	JTextField txtName;
	JTextField txtSalary;
	TextArea txtWorkprofile;

	JButton btnSubmit;
	JButton btnReset;
	JButton btnExit;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnId;

	public void label () {
		lblTitle = new JLabel ("DESIGNATION");
		lblTitle.setFont (new Font ("Elephant", Font.BOLD, 30));
		lblTitle.setOpaque (true);
		lblTitle.setBackground (Color.BLUE.darker ());
		lblTitle.setForeground (Color.WHITE);
		lblTitle.setBounds (70, 40, 405, 35);
		lblId = new JLabel ("Id");
		lblId.setBounds (70, 100, 100, 25);
		lblName = new JLabel ("Name");
		lblName.setBounds (70, 135, 100, 25);
		lblSalary = new JLabel ("Salary");
		lblSalary.setBounds (70, 170, 100, 25);
		lblWorkprofile = new JLabel ("Work Profile");
		lblWorkprofile.setBounds (70, 205, 100, 25);
	}

	public void text () {
		txtId = new JTextField ();
		txtId.setBounds (200, 100, 275, 25);
		txtName = new JTextField ();
		txtName.setBounds (200, 135, 275, 25);
		txtSalary = new JTextField ();
		txtSalary.setBounds (200, 170, 275, 25);
		txtWorkprofile = new TextArea ();
		txtWorkprofile.setBounds (200, 205, 275, 50);
	}

	public void button () {
		btnSubmit = new JButton ("Submit");
		btnSubmit.setBounds (130, 275, 75, 25);
		btnReset = new JButton ("Reset");
		btnReset.setBounds (230, 275, 75, 25);
		btnExit = new JButton ("Exit");
		btnExit.setBounds (330, 275, 75, 25);
		btnDelete = new JButton ("Delete");
		btnDelete.setBounds (280, 320, 125, 25);
		btnUpdate = new JButton ("Update");
		btnUpdate.setBounds (130, 320, 125, 25);
		btnId = new JButton ("Get By Id");
		btnId.setBounds (210, 365, 115, 25);
	}

	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == btnExit) {
			this.dispose ();
		}
		if (e.getSource () == btnReset) {
			txtName.setText ("");
			txtId.setText ("");
			txtSalary.setText ("");
			txtWorkprofile.setText (" ");
		}
		if (e.getSource () == btnSubmit) {
			BODesignation desg = new BODesignation ();
			desg.setName (txtName.getText ());
			desg.setId (Integer.parseInt (txtId.getText ()));
			desg.setSalary (txtSalary.getText ());
			desg.setWork_profile (txtWorkprofile.getText ());
			if (DADesignation.add (desg)) {
				JOptionPane.showMessageDialog (null, "Designation Submitted");
			}
			else {
				JOptionPane.showMessageDialog (null, "ERROR!!!");
			}
		}
		if (e.getSource () == btnUpdate) {
			BODesignation desg = new BODesignation ();
			desg.setName (txtName.getText ());
			desg.setId (Integer.parseInt (txtId.getText ()));
			desg.setSalary (txtSalary.getText ());
			desg.setWork_profile (txtWorkprofile.getText ());
			if (DADesignation.update (desg)) {
				JOptionPane.showMessageDialog (null, "Designation Updated");
			}
			else {
				JOptionPane.showMessageDialog (null, "ERROR!!!");
			}
		}
		if (e.getSource () == btnDelete) {
			if (DADesignation.delete (Integer.parseInt (txtId.getText ()))) {
				JOptionPane.showMessageDialog (null, "Designation Deleted");
			}
			else {
				JOptionPane.showMessageDialog (null, "ERROR!!!");
			}
		}
		if (e.getSource() == btnId) {
			BODesignation des = DADesignation.getById (Integer.parseInt (txtId.getText ()));
			txtName.setText (des.getName ());
			txtId.setText (String.valueOf (des.getId ()));
			txtSalary.setText (des.getSalary ());
			txtWorkprofile.setText (des.getWork_profile ());

		}
	}
	
	public UIDesignation () {
		setLayout (null);
		label ();
		add (lblTitle);
		add (lblId);
		add (lblName);
		add (lblSalary);
		add (lblWorkprofile);

		text ();
		add (txtId);
		add (txtName);
		add (txtSalary);
 		add (txtWorkprofile);

		button ();
		add (btnSubmit);
		btnSubmit.addActionListener (this);
		add (btnReset);
		btnReset.addActionListener (this);
		add (btnExit);
		btnExit.addActionListener (this);
		add (btnUpdate);
		btnUpdate.addActionListener (this);
		add (btnDelete);
		btnDelete.addActionListener (this);
		add (btnId);
		btnId.addActionListener (this);

		//txtId.addActionListener (this);
		
	}
	
	public static void main (String arg[]) {
		UIDesignation frame = new UIDesignation ();
		frame.setVisible (true);
		frame.setSize (570, 460);
		frame.setTitle ("DESIGNATION");
		frame.setDefaultLookAndFeelDecorated (true);
	}
}