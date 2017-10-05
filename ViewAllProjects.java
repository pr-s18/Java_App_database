import java.awt.*;
import javax.swing.*;
import java.util.*;

class ViewAllProjects extends JFrame {

JTable table;
JScrollPane pane;

public ViewAllProjects () {
	Vector vv=new Vector();
	vv.add("Id");
	vv.add("Name");
	vv.add("Deadline");
	vv.add("Technology");
	vv.add("User Id");
	vv.add("Start Date");
	vv.add ("Status");
	vv.add ("Description");
	vv.add ("Budget");
	vv.add ("Phase");

	table=new JTable(DAProject.getByAll (),vv);
	pane=new JScrollPane(table);
	add(pane);

}

public static void main (String args[]){
	ViewAllProjects frame = new ViewAllProjects ();
	frame.setVisible (true);
	
}
}