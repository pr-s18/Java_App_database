import java.sql.*;
import java.util.*;

class DAProject extends AbstractDao {
	static Connection cc = getConnection ();
	public static boolean add (BOProject project) {
		try {
			PreparedStatement s = cc.prepareStatement ("insert into project_database (name, id, deadline, technology, u_id, startdate, status, description, budget, phase) values (?,?,?,?,?,?,?,?,?,?)");
			s.setString (1, project.getName ());
			s.setInt (2, project.getId ());
			s.setString (3, project.getDeadline ());
			s.setString (4, project.getTechnology ());
			s.setInt (5, project.getUser ().getId ());
			s.setString (6, project.getStartdate ());
			s.setString (7, project.getStatus ());
			s.setString (8, project.getDescription ());
			s.setString (9, project.getBudget ());
			s.setString (10, project.getPhase ());
			s.executeUpdate ();
			return true;
		}
		catch (Exception e) {
			System.out.println (e);
			return false;
		}
	}
//--------getbyid-----
//--------------------
	public static BOProject getById (int id) {
		BOProject project = null;
		try {
			PreparedStatement s = cc.prepareStatement ("select * from project_database where id = ?");
			s.setInt (1,id);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				project = new BOProject ();
				project.setName (rs.getString (1));
				project.setId (rs.getInt (2));
				project.setDeadline (rs.getString (3));
				project.setTechnology (rs.getString (4));
				project.setUser (DAUser.getById (rs.getInt (5)));
				project.setStartdate (rs.getString (6));
				project.setStatus (rs.getString (7));
				project.setDescription (rs.getString (8));
				project.setBudget (rs.getString (9));
				project.setPhase (rs.getString (10));

			}
		}
		catch (Exception e) {
			System.out.println (e);
		}
		return project;
	}



//-------------------UPDATE-------
//-------------------------------
	public static boolean update(BOProject project) {
		try {
			PreparedStatement s = cc.prepareStatement ("Update project_database set name=?, deadline=?, technology=?, u_id=?, startdate=?, status=?, description=?, budget=?, phase=? where id = ?");
			s.setString (1, project.getName ());
			s.setInt (10, project.getId ());
			s.setString (2, project.getDeadline ());
			s.setString (3, project.getTechnology ());
			s.setInt (4, project.getUser ().getId ());
			s.setString (5, project.getStartdate ());
			s.setString (6, project.getStatus ());
			s.setString (7, project.getDescription ());
			s.setString (8, project.getBudget ());
			s.setString (9, project.getPhase ());
			s.executeUpdate ();
			return true;
		}
		catch (Exception e) {
			System.out.println (e);
			return false;
		}
	}
//-------------------------------------

	public static boolean delete (int id) {
		try {
			PreparedStatement p = cc.prepareStatement ("delete from project_database where id = ?");
			p.setInt (1, id);
			p.executeUpdate ();
			return true;
		}
		catch (Exception e) {
			System.out.println (e);
			return false;
		}
	}
//----------------------------------------------------------
//------------------------get by id-------------------------

	public static Vector getAll (int id) {
		Vector v = new Vector ();
		try {
			PreparedStatement s = cc.prepareStatement ("select * from project_database where u_id = ?");
			s.setInt (1, id);
			ResultSet rs = s.executeQuery ();
			while (rs.next ()) {
				BOProject project = new BOProject ();
				project.setName (rs.getString (1));
				project.setId (rs.getInt (2));
				project.setDeadline (rs.getString (3));
				project.setTechnology (rs.getString (4));
				project.setUser (DAUser.getById (rs.getInt (5)));
				project.setStartdate (rs.getString (6));
				project.setStatus (rs.getString (7));
				project.setDescription (rs.getString (8));
				project.setBudget (rs.getString (9));
				project.setPhase (rs.getString (10));

				v.add (project);
			}
		}
		catch (Exception e) {
			System.out.println (e);
		}		
		return v;
	} 
//-----------------------------------------------------
//-----------getByPhase--------------------------------

	public static Vector getByPhase (String Phase) {
		Vector v = new Vector ();
		try {
			PreparedStatement s = cc.prepareStatement ("select * from project_database where phase = ?");
			s.setString (1, Phase);
			ResultSet rs = s.executeQuery ();
			while (rs.next ()) {
				BOProject project = new BOProject ();
				project.setName (rs.getString (1));
				project.setId (rs.getInt (2));
				project.setDeadline (rs.getString (3));
				project.setTechnology (rs.getString (4));
				project.setUser (DAUser.getById (rs.getInt (5)));
				project.setStartdate (rs.getString (6));
				project.setStatus (rs.getString (7));
				project.setDescription (rs.getString (8));
				project.setBudget (rs.getString (9));
				//project.setPhase (rs.getString (10));

				v.add (project);
			}
		}
		catch (Exception e) {
			System.out.println (e);
		}		
		return v;	
	}

	public static BOProject getByProject (String name) {
		BOProject project = null;
		try {
			PreparedStatement s = cc.prepareStatement ("select * from project_database where name = ?");
			s.setString (1,name);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				project = new BOProject ();
				project.setName (rs.getString (1));
				project.setId (rs.getInt (2));
				project.setDeadline (rs.getString (3));
				project.setTechnology (rs.getString (4));
				project.setUser (DAUser.getById (rs.getInt (5)));
				project.setStartdate (rs.getString (6));
				project.setStatus (rs.getString (7));
				project.setDescription (rs.getString (8));
				project.setBudget (rs.getString (9));
				project.setPhase (rs.getString (10));

			}
		}
		catch (Exception e) {
			System.out.println (e);
		}
		return project;
	}
//-------------------------------------------------------------------
//-----------------------getByAll------------------------------------


	public static Vector getByAll () {
		Vector v = new Vector ();
		try {
			PreparedStatement s = cc.prepareStatement ("select * from project_database");
			ResultSet rs = s.executeQuery ();
			while (rs.next ()) {
				Vector project = new Vector ();
				project.add (rs.getString (1));
				project.add (rs.getInt (2));
				project.add (rs.getString (3));
				project.add (rs.getString (4));
				project.add (DAUser.getById (rs.getInt (5)));
				project.add (rs.getString (6));
				project.add (rs.getString (7));
				project.add (rs.getString (8));
				project.add (rs.getString (9));
				project.add (rs.getString (10));

				v.add (project);
			}
		}
		catch (Exception e) {
			System.out.println (e);
		}		
		return v;
	} 
//-----------------------------------------------------


}