import java.sql.*;
import java.util.*;

class DADesignation extends AbstractDao {
	static Connection cc = getConnection ();
	public static boolean add (BODesignation des) {
		try {
			PreparedStatement s = cc.prepareStatement ("insert into designation (name, id, salary, work_profile) values (?,?,?,?)");
			
			s.setString (1, des.getName ());
			s.setInt (2, des.getId ());
			s.setString (3, des.getSalary ());
			s.setString (4, des.getWork_profile ());
			s.executeUpdate ();
			return true;
		}
		catch (Exception e) {
			System.out.println (e);
			return false;
		}
	}

//-----getbyid----------
//----------------------
	public static BODesignation getById (int id) {
		BODesignation desg = null;
		try {
			PreparedStatement s = cc.prepareStatement ("select * from designation where id = ?");
			s.setInt (1, id);
			ResultSet rs = s.executeQuery ();
			while (rs.next()) {
				desg = new BODesignation ();
				desg.setName (rs.getString (2));
				desg.setId (rs.getInt (1));
				desg.setSalary (rs.getString (3));
				desg.setWork_profile (rs.getString (4));

			}
		}
		catch (Exception e) {
			System.out.println (e);
		}
		return desg;
	}
 

//--------update---------
//-----------------------
	public static boolean update (BODesignation des) {
		try {
			PreparedStatement s = cc.prepareStatement ("update designation set name= ?, id = ?, salary = ?, work_profile=?");
			
			s.setString (1, des.getName ());
			s.setInt (2, des.getId ());
			s.setString (3, des.getSalary ());
			s.setString (4, des.getWork_profile ());
			s.executeUpdate ();
			return true;
		}
		catch (Exception e) {
			System.out.println (e);
			return false;
		}
	}

//------------delete-----------
//-----------------------------
	public static boolean delete (int id) {
		try {
			PreparedStatement s = cc.prepareStatement ("delete designation where id = ?");
			
			s.setInt (1, id);
			s.executeUpdate ();
			return true;
		}
		catch (Exception e) {
			System.out.println (e);
			return false;
		}
		
	}
//----------------------------------
//----------------------------------

	public static Vector getAll () {
		Vector designation = new Vector ();
		try {
			PreparedStatement s = cc.prepareStatement ("select * from designation");
			ResultSet rs = s.executeQuery ();
			while (rs.next()) {
				BODesignation desg = new BODesignation ();
				desg.setName (rs.getString (2));
				desg.setId (rs.getInt (1));
				desg.setSalary (rs.getString (3));
				desg.setWork_profile (rs.getString (4));
				designation.add (desg);

			}
		}
		catch (Exception e) {
			System.out.println (e);
		}
		return designation;
	}

//----------------------------------------------------------
//-------------------------getByAll-------------------------

	public static Vector getByAll () {
		Vector designation = new Vector ();
		try {
			PreparedStatement s = cc.prepareStatement ("select * from designation");
			ResultSet rs = s.executeQuery ();
			while (rs.next()) {
				Vector desg = new Vector ();
				desg.add (rs.getString (2));
				desg.add (rs.getInt (1));
				desg.add (rs.getString (3));
				desg.add (rs.getString (4));
				designation.add (desg);

			}
		}
		catch (Exception e) {
			System.out.println (e);
		}
		return designation;
	}


}