import java.sql.*;
import java.util.*;

class DAUser extends AbstractDao {
	static Connection cc = getConnection ();
	public static boolean add (BOUser user)
	{
	try {
		PreparedStatement p = cc.prepareStatement ("insert into user_database (type, name, fathers_name,id, dob, address, working_since, mobile, email, gender, qualification, d_id) values (?,?,?,?,?,?,?,?,?,?,?,?)");
		p.setString (1, user.getType ());
		p.setString (2, user.getName ());		
		p.setString (3, user.getFathers_name ());
		p.setInt (4, user.getId ());
		p.setString (5, user.getDOB());
		p.setString (6, user.getAddress ());
		p.setString (7, user.getWorking_since ());
		p.setString (8, user.getMobile ());
		p.setString (9, user.getEmail ());
		p.setString (10, user.getGender ());
		p.setString (11, user.getQualification ());				
		p.setInt (12, user.getDesignation ().getId ());
		p.executeUpdate ();
		return true;
	}
	catch (Exception e) {System.out.println (e);
		return false;
	}
	}

	public static BOUser getById (int id) {
		BOUser user = null;
		try {
			PreparedStatement s = cc.prepareStatement ("select * from user_database where id = ?");
			s.setInt (1, id);
			ResultSet rs = s.executeQuery ();
			while (rs.next ()) {
				user = new BOUser ();
				user.setType (rs.getString (1));
				user.setName (rs.getString (2));
				user.setFathers_name (rs.getString (3));
				user.setId (rs.getInt (4));
				user.setDOB (rs.getString (5));
				user.setAddress (rs.getString (6));
				user.setWorking_since (rs.getString (7));
				user.setMobile (rs.getString (8));
				user.setEmail (rs.getString (9));
				user.setGender (rs.getString (10));
				user.setQualification (rs.getString (11));
				user.setDesignation (DADesignation.getById (rs.getInt (12)));
			} 
		}
		catch (Exception e) {
			System.out.println (e);
		}
		return user;
	}


//-------update customer---------
public static boolean update (BOUser user)
	{
	try {
		PreparedStatement p = cc.prepareStatement ("update user_database set type=?,name=?,fathers_name=?,dob=?,address=?,working_since=?,mobile=?,email=?,gender=?,qualification=?, d_id = ? where id=?");
		p.setString (1, user.getType ());
		p.setString (2, user.getName ());		
		p.setString (3, user.getFathers_name ());
		p.setInt (12, user.getId ());
		p.setString (4, user.getDOB());
		p.setString (5, user.getAddress ());
		p.setString (6, user.getWorking_since ());
		p.setString (7, user.getMobile ());
		p.setString (8, user.getEmail ());
		p.setString (9, user.getGender ());
		p.setString (10, user.getQualification ());				
		p.setInt (11, user.getDesignation ().getId ());
		p.executeUpdate ();
		return true;
	}
	catch (Exception e) {System.out.println (e);
		return false;
	}
	}


//---------------------------
//----------delete user--------
public static boolean delete (int id)
	{
	try {
		PreparedStatement p = cc.prepareStatement ("delete from user_database where id=?");
		p.setInt(1,id);
		p.executeUpdate ();
		return true;
	}
	catch (Exception e) {System.out.println (e);
		return false;
	}
	}


//-------------------------------
//-----getBymail and id----

	public static BOUser getForLogin (String email, int id) {
		BOUser user = null;
		try {
			PreparedStatement s = cc.prepareStatement ("select * from user_database where id = ? and email = ?");
			s.setInt (1, id);
			s.setString (2, email);
			ResultSet rs = s.executeQuery ();
			while (rs.next ()) {
				user = new BOUser ();
				user.setType (rs.getString (1));
				user.setName (rs.getString (2));
				user.setFathers_name (rs.getString (3));
				user.setId (rs.getInt (4));
				user.setDOB (rs.getString (5));
				user.setAddress (rs.getString (6));
				user.setWorking_since (rs.getString (7));
				user.setMobile (rs.getString (8));
				user.setEmail (rs.getString (9));
				user.setGender (rs.getString (10));
				user.setQualification (rs.getString (11));
				user.setDesignation (DADesignation.getById (rs.getInt (12)));
			} 
		}
		catch (Exception e) {
			System.out.println (e);
		}
		return user;
	}

//------------------------------------------------
//-----get all users----

	public static Vector getAll () {
		 Vector users=new Vector();
		try {
			PreparedStatement s = cc.prepareStatement ("select * from user_database");
			ResultSet rs = s.executeQuery ();
			while (rs.next ()) {
				Vector user = new Vector();
				user.add (rs.getString (1));
				user.add (rs.getString (2));
				user.add (rs.getString (3));
				user.add (rs.getInt (4));
				user.add (rs.getString (5));
				user.add (rs.getString (6));
				user.add (rs.getString (7));
				user.add (rs.getString (8));
				user.add (rs.getString (9));
				user.add (rs.getString (10));
				user.add (rs.getString (11));
				user.add (DADesignation.getById (rs.getInt (12)));
				users.add(user);		
	} 
		}
		catch (Exception e) {
			System.out.println (e);
		}
		return users;
	}



}