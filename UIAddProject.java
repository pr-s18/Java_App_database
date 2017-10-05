import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class UIAddProject extends JFrame implements ActionListener {

	JLabel lblTitle;
	JLabel lblName;	
	JLabel lblId;	
	JLabel lblDeadline;	
	JLabel lblTechnology;	
	JLabel lblU_Id;	
	JLabel lblStartdate;	
	JLabel lblStatus;	
	JLabel lblDescription;	
	JLabel lblBudget;	
	JLabel lblPhase;	

	JTextField txtName;
	JTextField txtId;	
	JTextField txtDeadline;
	JTextField txtTechnology;
	JTextField txtU_Id;
	JTextField txtStartdate;
	JTextField txtStatus;
	TextArea txtDescription;
	JTextField txtBudget;

	JComboBox cbPhase;

	JButton btnSubmit;
	JButton btnReset;
	JButton btnExit;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnId;

	public void label () {
		lblTitle = new JLabel ("           PROJECT");
		lblTitle.setFont (new Font ("Elephant", Font.BOLD, 30));
		lblTitle.setOpaque (true);
		lblTitle.setBackground (Color.BLUE.darker ());
		lblTitle.setForeground (Color.WHITE);
		lblTitle.setBounds (70, 40, 405, 35);		
		lblName = new JLabel ("Name");
		lblName.setBounds (70, 100, 100, 25);
		lblId = new JLabel ("Id");
		lblId.setBounds (70, 135, 100, 25);
		lblDeadline = new JLabel ("Deadline");
		lblDeadline.setBounds (70, 170, 100, 25);
		lblTechnology = new JLabel ("Technology");
		lblTechnology.setBounds (70, 205, 100, 25);
		lblU_Id = new JLabel ("User Id");
		lblU_Id.setBounds (70, 240, 100, 25);
		lblStartdate = new JLabel ("Start Date");
		lblStartdate.setBounds (70, 275, 100, 25);
		lblStatus = new JLabel ("Status");
		lblStatus.setBounds (70, 310, 100, 25);
		lblDescription = new JLabel ("Description");
		lblDescription.setBounds (70, 345, 100, 25);
		lblBudget = new JLabel ("Budget");
		lblBudget.setBounds (70, 405, 100, 25);
		lblPhase = new JLabel ("Phase");
		lblPhase.setBounds (70, 440, 100, 25);
	}

	public void text () {
		txtName = new JTextField ();
		txtName.setBounds (200, 100, 275, 25);
		txtId = new JTextField ();
		txtId.setBounds (200, 135, 275, 25);
		txtDeadline = new JTextField ();
		txtDeadline.setBounds (200, 170, 275, 25);
		txtTechnology = new JTextField ();
		txtTechnology.setBounds (200, 205, 275, 25);
		txtU_Id = new JTextField ();
		txtU_Id.setBounds (200, 240, 275, 25);
		txtStartdate = new JTextField ();
		txtStartdate.setBounds (200, 275, 275, 25);
		txtStatus = new JTextField ();
		txtStatus.setBounds (200, 310, 275, 25);
		txtDescription = new TextArea ();
		txtDescription.setBounds (200, 345, 275, 50);
		txtBudget = new JTextField ();
		txtBudget.setBounds (200, 405, 275, 25);
	}

	public void combobox () {
		cbPhase = new JComboBox (new String[] {"Planning", "Analysis", "Design", "Coding", "Testing", "Installation"});
		cbPhase.setBounds (200, 440, 275, 25);
	}

	public void button () {
		btnSubmit = new JButton ("Submit");
		btnSubmit.setBounds (130, 505, 75, 25);
		btnReset = new JButton ("Reset");
		btnReset.setBounds (230, 505, 75, 25);
		btnExit = new JButton ("Exit");
		btnExit.setBounds (330, 505, 75, 25);
		btnDelete = new JButton ("Delete");
		btnDelete.setBounds (280, 555, 125, 25);
		btnUpdate = new JButton ("Update");
		btnUpdate.setBounds (130, 555, 125, 25);
		btnId = new JButton ("Get By Id");
		btnId.setBounds (210, 605, 115, 25);
	}

 
	public UIAddProject () {
		setLayout (null);
		label ();
		add (lblTitle);
		add (lblName);
		add (lblId);
		add (lblDeadline);
		add (lblTechnology);
		add (lblU_Id);
		add (lblStartdate);
		add (lblStatus);
		add (lblDescription);
		add (lblBudget);
		add (lblPhase);

		text ();
		add (txtName);
		add (txtId);
		add (txtDeadline);
		add (txtTechnology);
		add (txtU_Id);
		add (txtStartdate);
		add (txtStatus);
		add (txtDescription);
		add (txtBudget);

		combobox ();
		add (cbPhase);

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

		BOUser u = Invoker.user;
		if (u.getType ().equals ("Employee")) {
			btnSubmit.setEnabled (false);
			btnReset.setEnabled (false);
			//btnExit.setEnabled (false);
			btnUpdate.setEnabled (false);
			btnDelete.setEnabled (false);			
		}


		
		//txtId.addActionListener (this);
	}

	public void actionPerformed (ActionEvent e) {
		if (e.getSource ()== btnExit) {
			this.dispose ();
		}
		if (e.getSource () == btnReset) {
			txtName.setText ("");
			txtId.setText ("");
			txtDeadline.setText ("");
			txtTechnology.setText ("");
			txtU_Id.setText ("");
			txtStartdate.setText ("");
			txtStatus.setText ("");
			txtDescription.setText (" ");
			txtBudget.setText ("");
			cbPhase.setSelectedItem ("Planning");
		}
		if (e.getSource () == btnSubmit) {
			BOProject project = new BOProject ();
			project.setName (txtName.getText ());
			project.setId (Integer.parseInt (txtId.getText ()));
			project.setDeadline (txtDeadline.getText ());
			project.setTechnology (txtTechnology.getText ());
			
			
			project.setUser (DAUser.getById(Integer.parseInt(txtU_Id.getText ())));
			
			project.setStartdate (txtStartdate.getText ());
			project.setStatus (txtStatus.getText ());
			project.setDescription (txtDescription.getText ());
			project.setBudget (txtBudget.getText ());
			project.setPhase ((String)cbPhase.getSelectedItem ());
			if (DAProject.add (project)) {
				JOptionPane.showMessageDialog (null, "Project Submitted");
				
			}
			else {
				JOptionPane.showMessageDialog (null, "ERROR!!!");
			}
		}

		if (e.getSource () == btnUpdate) {
			BOProject project = new BOProject ();
			project.setName (txtName.getText ());
			project.setId (Integer.parseInt (txtId.getText ()));
			project.setDeadline (txtDeadline.getText ());
			project.setTechnology (txtTechnology.getText ());
			project.setUser(DAUser.getById (Integer.parseInt (txtU_Id.getText ())));
			project.setStartdate (txtStartdate.getText ());
			project.setStatus (txtStatus.getText ());
			project.setDescription (txtDescription.getText ());
			project.setBudget (txtBudget.getText ());
			project.setPhase ((String)cbPhase.getSelectedItem ());
			if (DAProject.update (project)) {
				JOptionPane.showMessageDialog (null, "Project Updated");
			}
			else {
				JOptionPane.showMessageDialog (null, "ERROR!!!");
			}
		
		}
		if (e.getSource () == btnDelete) {
			if (DAProject.delete (Integer.parseInt (txtId.getText ()))) {
				JOptionPane.showMessageDialog (null, "Project Deleted");
			}
			else {
				JOptionPane.showMessageDialog (null, "ERROR!!!");
			}
		}
		if (e.getSource() == btnId) {
			BOProject proj = DAProject.getById (Integer.parseInt(txtId.getText()));
			txtName.setText (proj.getName ());
			txtId.setText (String.valueOf (proj.getId ()));
			txtDeadline.setText (proj.getDeadline ());
			txtTechnology.setText (proj.getTechnology ());
			txtU_Id.setText (String.valueOf(proj.getUser ()));
			txtStartdate.setText (proj.getStartdate ());
			txtStatus.setText (proj.getStatus ());
			txtDescription.setText (proj.getDescription ());
			txtBudget.setText (proj.getBudget ());
			cbPhase.setSelectedItem (proj.getPhase ());
			
		}
	}

	public static void main (String arg[]) {
		UIAddProject frame = new UIAddProject ();
		frame.setVisible (true);
		frame.setSize (570, 690);
		frame.setTitle ("PROJECT");
		frame.setDefaultLookAndFeelDecorated (true);

	}
}