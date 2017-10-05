 import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class UIAddUser extends JFrame implements ActionListener
{
	ButtonGroup bg=new ButtonGroup();
	JLabel lblTitle;
	JLabel lblType;
	JLabel lblName;
	JLabel lblFather;
	JLabel lblId;
	JLabel lblD_Id;
	JLabel lblDOB;
	JLabel lblAddress;
	JLabel lblWorkingSince;
	JLabel lblMobileNumber;
	JLabel lblEmail;
	JLabel lblGender;
	JLabel lblQualification;
	
	JTextField txtNameFirst;
	JTextField txtNameLast;
	JTextField txtFatherFirst;
	JTextField txtFatherLast;
	JTextField txtId;
	//JTextField txtD_Id;
	TextArea txtAddress;
	JTextField txtWorkingSince;
	JTextField txtMobileNumber;
	JTextField txtEmail;
	JTextField txtQualification;
		
	
	JComboBox cbType;
	JComboBox cbDate;
	JComboBox cbMonth;
	JComboBox cbYear;
	JComboBox cbD_id;
	
	JRadioButton rbMale;
	JRadioButton rbFemale;
	
	JButton btnSubmit;
	JButton btnReset;
	JButton btnExit;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnId;
	
	JSpinner spDate;
	JSpinner spMonth;
	JSpinner spYear;
	
	public void label () {
		lblTitle = new JLabel ("              USER");
		lblTitle.setFont (new Font ("Elephant", Font.BOLD, 30));
		lblTitle.setOpaque (true);
		lblTitle.setBackground (Color.BLUE.darker ());
		lblTitle.setForeground (Color.WHITE);
		lblTitle.setBounds (70, 15, 410, 35);
		lblType = new JLabel ("Type");
		lblType.setBounds (70, 65, 100, 25);
		//lblType.setForeground (Color.WHITE);
		lblName = new JLabel ("Name");
		lblName.setBounds (70, 100, 100, 25);
		//lblName.setForeground (Color.WHITE);
		lblFather = new JLabel ("Father's Name");
		lblFather.setBounds (70, 135, 100, 25);
		//lblFather.setForeground (Color.WHITE);
		lblId = new JLabel ("Id");
		lblId.setBounds (70, 170, 100, 25);
		//lblId.setForeground (Color.WHITE);
		lblD_Id = new JLabel ("D id");
		lblD_Id.setBounds (70, 205, 100, 25);
		//lblD_Id.setForeground (Color.WHITE);
		lblDOB = new JLabel ("DOB");
		lblDOB.setBounds (70, 240, 100, 25);
		//lblDOB.setForeground (Color.WHITE);
		lblAddress = new JLabel ("Address");
		lblAddress.setBounds (70, 275, 100, 25);
		//lblAddress.setForeground (Color.WHITE);	
		lblWorkingSince = new JLabel ("Working Since");
		lblWorkingSince.setBounds (70, 335, 100, 25);
		//lblWorkingSince.setForeground (Color.WHITE);
		lblMobileNumber = new JLabel ("Mobile Number");
		lblMobileNumber.setBounds (70, 370, 100, 25);
		//lblMobileNumber.setForeground (Color.WHITE);
		lblEmail = new JLabel ("Email Id");
		lblEmail.setBounds (70, 405, 100, 25);
		//lblEmail.setForeground (Color.WHITE);
		lblGender = new JLabel ("Gender");
		lblGender.setBounds (70, 440, 100, 25);
		//lblGender.setForeground (Color.WHITE);
		lblQualification = new JLabel ("Qualification");
		lblQualification.setBounds (70, 475, 100, 25);
		//lblQualification.setForeground (Color.WHITE);
		}
	
	public void text () {
		txtNameFirst = new JTextField ();
		txtNameFirst.setBounds (200, 100, 125, 25);
		txtNameLast = new JTextField ();
		txtNameLast.setBounds (350, 100, 125, 25);
		txtFatherFirst = new JTextField ();
		txtFatherFirst.setBounds (200, 135, 125, 25);
		txtFatherLast = new JTextField ();
		txtFatherLast.setBounds (350, 135, 125, 25);
		txtId = new JTextField ();
		txtId.setBounds (200, 170, 275, 25);
	//	txtD_Id = new JTextField ();
	//	txtD_Id.setBounds (200, 205, 275, 25);
		txtAddress = new TextArea ();
		txtAddress.setBounds (200, 275, 275, 50);
		txtWorkingSince = new JTextField ();
		txtWorkingSince.setBounds (200, 335, 275, 25);
		txtMobileNumber = new JTextField ();
		txtMobileNumber.setBounds (200, 370, 275, 25);			
		txtEmail = new JTextField ();
		txtEmail.setBounds (200, 405, 275, 25);
		txtQualification = new JTextField ();
		txtQualification.setBounds (200, 475, 275, 25);
	}
	
	public void combo_box () {
		cbType = new JComboBox (new String[]{"Employee","Customer", "Admin"});
		cbType.setBounds (200, 65, 275, 25);
	/*	cbDate = new JComboBox ();
		cbDate.setBounds (200, 205, 85, 25);
		cbMonth = new JComboBox ();
		cbMonth.setBounds (295, 205, 85, 25);
		cbYear = new JComboBox ();
		cbYear.setBounds (390, 205, 85, 25);*/
		cbD_id = new JComboBox (DADesignation.getAll());
		cbD_id.setBounds (200, 205, 275, 25);
	} 
	
	public void radio_button () {
		rbMale = new JRadioButton ("Male");
		rbMale.setBounds (350, 440, 125, 25);
		rbFemale = new JRadioButton ("Female");
		rbFemale.setBounds (200, 440, 125, 25);
		bg.add(rbMale);
		bg.add(rbFemale);
	}
	
	public void button () {
		btnSubmit = new JButton ("Submit");
		btnSubmit.setBounds (100, 550, 75, 25);
		btnReset = new JButton ("Reset");
		btnReset.setBounds (200, 550, 75, 25);
		btnExit = new JButton ("Exit");
		btnExit.setBounds (300, 550, 75, 25);
		btnDelete = new JButton ("Delete");
		btnDelete.setBounds (250, 600, 125, 25);
		btnUpdate = new JButton ("Update");
		btnUpdate.setBounds (100, 600, 125, 25);
		btnId = new JButton ("Get By Id");
		btnId.setBounds (180, 650, 115, 25);
	
	}
	
	public void spinner () {
		spDate = new JSpinner ();
		spDate.setBounds (200, 240, 85, 25);
		spMonth = new JSpinner ();
		spMonth.setBounds (295, 240, 85, 25);
		spYear = new JSpinner ();
		spYear.setBounds (390, 240, 85, 25);
	}
	
	public UIAddUser () {
		setLayout (null);
		/*setContentPane (new JLabel (new ImageIcon ("bg4.jpg")));*/		                                   /*Container cc=getContentPane();
										                 cc.setBackground(Color.cyan);*/	
		
		label ();
		add (lblTitle);
		add (lblType);
		add (lblName);
		add (lblFather);
		add (lblId);
		add (lblD_Id);
		add (lblDOB);
		add (lblAddress);
		add (lblWorkingSince);
		add (lblMobileNumber);
		add (lblEmail);
		add (lblGender);
		add (lblQualification);
		
		text ();
		add (txtNameFirst);
		add (txtNameLast);
		add (txtFatherFirst);
		add (txtFatherLast);
		add (txtId);
		//add (txtD_Id);
		add (txtAddress);
		add (txtWorkingSince);
		add (txtMobileNumber);
		add (txtEmail);
		add (txtQualification);
		
		combo_box ();
		add (cbType);
	/*	add (cbDate);
		add (cbMonth);
		add (cbYear);*/
		add (cbD_id);			
	
		radio_button ();
		add (rbMale);
		add (rbFemale);
		
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
		cbType.addActionListener (this); 
		
		spinner ();
		add (spDate);
		add (spMonth);
		add (spYear);

		BOUser u = Invoker.user;
		if (u.getType ().equals ("Employee")) {
			btnSubmit.setEnabled (false);
			btnReset.setEnabled (false);
			//btnExit.setEnabled (false);
			btnUpdate.setEnabled (false);
			btnDelete.setEnabled (false);			
		}
		
		}
	
	public void actionPerformed (ActionEvent e) {
		if (e.getSource () == btnSubmit) {
			BOUser user = new BOUser ();
			user.setType ((String)cbType.getSelectedItem ());
			user.setName (txtNameFirst.getText() + "/" + txtNameLast.getText ());
			user.setFathers_name (txtFatherFirst.getText () + "/" + txtFatherLast.getText ());
			user.setId (Integer.parseInt (txtId.getText ()));
			user.setDOB ((int)spDate.getValue () + "/" + (int)spMonth.getValue () + "/" + (int)spYear.getValue ());
			user.setAddress (txtAddress.getText ());
			user.setWorking_since (txtWorkingSince.getText ());
			user.setMobile (txtMobileNumber.getText ());
			user.setEmail (txtEmail.getText ());
			user.setGender(rbMale.isSelected ()?"Male":"Female");
			user.setQualification (txtQualification.getText ());
			user.setDesignation ((BODesignation)cbD_id.getSelectedItem ());
			if (DAUser.add (user)) {
				JOptionPane.showMessageDialog (null, "User Successfully Added");
			}
			else {
				JOptionPane.showMessageDialog (null, "ERROR!!!");
			}
		}
		if (e.getSource () == btnExit) {
			this.dispose ();
		}
		if (e.getSource () == btnReset) {
			cbType.setSelectedItem ("employee");
			txtNameFirst.setText ("");
			txtNameLast.setText ("");
			txtFatherFirst.setText ("");
			txtFatherLast.setText ("");
			txtId.setText ("");
			spDate.setValue (0);
			spMonth.setValue (0);
			spYear.setValue (2000);
			txtAddress.setText (" ");
			txtWorkingSince.setText ("");
			txtMobileNumber.setText ("");
			txtEmail.setText ("");
			rbFemale.setSelected (true);
			txtQualification.setText ("");
			//txtD_Id.setText ("");
			
		}
		if (e.getSource () == btnId) {
			BOUser user = DAUser.getById (Integer.parseInt (txtId.getText ()));
			String[] name = user.getName().split ("/", 2);
			String b = name[0];
			String c = name[1];
			String[] father = user.getFathers_name ().split ("/", 2);
			String d = father[0];
			String f = father[1];
			String[] Dob = user.getDOB ().split ("/");
				
			cbType.setSelectedItem (user.getType());
			txtNameFirst.setText (b);
			txtNameLast.setText (c);
			txtFatherFirst.setText (d);
			txtFatherLast.setText (f);
			txtId.setText (String.valueOf (user.getId ()));

			spDate.setValue (Integer.parseInt(Dob[0]));
			spMonth.setValue (Integer.parseInt(Dob[1]));
			spYear.setValue (Integer.parseInt(Dob[2]));

			txtAddress.setText (user.getAddress());
			txtWorkingSince.setText (user.getWorking_since ());
			txtMobileNumber.setText (user.getMobile ());
			txtEmail.setText (user.getEmail());
			if (user.getGender().equals ("Male")) {
				rbMale.setSelected (true);
			}
			else {
				rbFemale.setSelected (true);
			}
			txtQualification.setText (user.getQualification ());
			cbD_id.setSelectedItem (user.getDesignation ());
		}
		
	if (e.getSource () == btnUpdate) {
			BOUser user = new BOUser ();
			user.setType ((String)cbType.getSelectedItem ());
			user.setName (txtNameFirst.getText() + "/" + txtNameLast.getText ());
			user.setFathers_name (txtFatherFirst.getText () + "/" + txtFatherLast.getText ());
			user.setId (Integer.parseInt (txtId.getText ()));
			user.setDOB ((int)spDate.getValue () + "/" + (int)spMonth.getValue () + "/" + (int)spYear.getValue ());
			user.setAddress (txtAddress.getText ());
			user.setWorking_since (txtWorkingSince.getText ());
			user.setMobile (txtMobileNumber.getText ());
			user.setEmail (txtEmail.getText ());
			user.setGender(rbMale.isSelected ()?"Male":"Female");
			user.setQualification (txtQualification.getText ());
			user.setDesignation ((BODesignation) cbD_id.getSelectedItem ());
			if (DAUser.update (user)) {
				JOptionPane.showMessageDialog (null, "User updated successfully");
			}
			else {
				JOptionPane.showMessageDialog (null, "ERROR!!!");
			}
		}
		if (e.getSource () == btnDelete) {
			if (DAUser.delete (Integer.parseInt (txtId.getText ()))) {
				JOptionPane.showMessageDialog (null, "User Deleted");
			}
			else {
				JOptionPane.showMessageDialog (null, "ERROR!!!");
			}
		}
		if (e.getSource () == cbType) {
			if (((String)cbType.getSelectedItem ()).equals ("Customer")) {
				txtWorkingSince.setEnabled (false);
				cbD_id.setEnabled (false);
			}
			if (((String)cbType.getSelectedItem ()).equals ("Employee")) {
				txtWorkingSince.setEnabled (true);
				cbD_id.setEnabled (true);
			}
		}
		
	}	

	public static void main (String arg[]) {
		UIAddUser frame = new UIAddUser ();
		frame.setVisible (true);
		frame.setSize (570, 730);
		frame.setTitle ("USER");
		frame.setDefaultLookAndFeelDecorated (true);
		}
	}