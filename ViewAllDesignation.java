import java.awt.*;
import javax.swing.*;
import java.util.*;

class ViewAllDesignations extends JFrame {

JTable table;
JScrollPane pane;

public ViewAllDesignations () {
	Vector vv=new Vector();
	vv.add("Id");
	vv.add("Name");
	vv.add("Salary");
	vv.add("Work Profile");

	table=new JTable(DADesignation.getByAll (),vv);
	pane=new JScrollPane(table);
	add(pane);

}

public static void main (String args[]){
	ViewAllDesignations frame = new ViewAllDesignations ();
	frame.setVisible (true);
	
}
}