import java.awt.*;
import javax.swing.*;
import java.util.*;

class ViewAllUsers extends JFrame
{
JTable table;
JScrollPane pane;
public ViewAllUsers()// DashboardAdmin d,String s,boolean b
{
Vector vv=new Vector();
vv.add("Type");
vv.add("Name");
vv.add("Fathers name");
vv.add("Id");
vv.add("DOB");
vv.add("ADDRESS");
vv.add ("Working Since");
vv.add ("Mobile");
vv.add ("Email");
vv.add ("Gender");
vv.add ("Qualification");
vv.add ("Designation");

table=new JTable(DAUser.getAll (),vv);
pane=new JScrollPane(table);
add(pane);
} 
public static void main(String rgs[])
{
//new ViewAllUsers().setVisible(true);
}
}