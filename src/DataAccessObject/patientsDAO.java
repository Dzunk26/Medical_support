package DataAccessObject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Database.JDBCUtil;
import model.patientNeedHelp;
import model.patients;

public class patientsDAO implements DAOInterface<patients> {

	public static patientsDAO getInstance() {
		return new patientsDAO();
	}
	
	@Override
	public int insert(patients t) {
		int result=0;
		Connection con=null;
		Statement st=null;
		try {
			con = JDBCUtil.getConnection();
			
			st = con.createStatement();
			
			String sql = "INSERT INTO patient(id, sid, name, birth, sex, phone, email, address, room, building, disease) "+
					"VALUES ('"+t.getId()+"', '"+t.getSid()+"', '"+t.getName()+"', '"+t.getBirth()+"', '"+t.getSex()+"', '"+t.getPhone()+"', '"+t.getEmail()+"', '"+t.getAddress()+"', '"+t.getRoom()+"', '"+t.getBuilding()+"', '"+t.getDisease()+"')";
			
			result = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(st!=null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public int update(patients t) {
		int result=0;
		Connection con=null;
		Statement st=null;
		try {
			con = JDBCUtil.getConnection();
			
			st = con.createStatement();
			
			String sql = "UPDATE patient "+
						"SET "+
						"sid = '"+t.getSid()+"', "+
						"name = '"+t.getName()+"', "+
						"birth = '"+t.getBirth()+"', "+
						"sex = '"+t.getSex()+"', "+
						"phone = '"+t.getPhone()+"', "+
						"email = '"+t.getEmail()+"', "+
						"address = '"+t.getAddress()+"', "+
						"room = '"+t.getRoom()+"', "+
						"building = '"+t.getBuilding()+"', "+
						"disease = '"+t.getDisease()+"' "+
						"WHERE id = '"+t.getId()+"'";
			
			result = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(st!=null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public int delete(patients t) {
		int result=0;
		Connection con=null;
		Statement st=null;
		try {
			con = JDBCUtil.getConnection();
			
			st = con.createStatement();
			
			String sql = "DELETE from patient "+
						"Where id='"+t.getId()+"'";
			
			result = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(st!=null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	@Override
	public ArrayList<patients> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public patients selectById(patients t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<patients> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<patientNeedHelp> getListPatientNeedHelp() {
		ArrayList<patientNeedHelp> result = new ArrayList<patientNeedHelp>();
		Connection con = null;
		Statement st = null;
		try {
			con = JDBCUtil.getConnection();
			st = con.createStatement();
			
			String sql = "SELECT * FROM patient_need_help ";
			
			// tra ve 1 table
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
                String patient_id = rs.getString("patient_id");
                String name = rs.getString("name");
                String room = rs.getString("room");
                String building = rs.getString("building");

                patientNeedHelp tmp = new patientNeedHelp(patient_id, name, room, building);
                result.add(tmp);
            }
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(st!=null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
    }
	
	public boolean checkExistPatient(String id) {
        boolean result = false;
        Connection con = null;
		Statement st = null;
		try {
			con = JDBCUtil.getConnection();
			st = con.createStatement();
			
			String sql = "SELECT * FROM patient WHERE id = '" + id + "'";
			
			// tra ve 1 table
			ResultSet rs = st.executeQuery(sql);
			String checkPatient = "";
			if (rs.next()) {
                checkPatient = rs.getString("id");
                if (checkPatient.equals(id))
                    result = true;
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(st!=null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
    }
	
	public int deletePatientNeedHelp(String id) {
		int result = 0;
		Connection con = null;
		Statement st = null;
		try {
			con = JDBCUtil.getConnection();
			st = con.createStatement();
			
			String sql = "DELETE FROM patient_need_help "
					+ "WHERE patient_id = '" + id + "'";
			
			result = st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(st!=null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
    }
	
	public patients getInfor(String id) {
		patients result = null;
		Connection con = null;
		Statement st = null;
		try {
			con = JDBCUtil.getConnection();
			st = con.createStatement();
			
			String sql = "SELECT * FROM patient WHERE id = '" + id + "'";
			
			// tra ve 1 table
			ResultSet rs = st.executeQuery(sql);

			rs.next();
            String patient_id = rs.getString("id");
            String sid = rs.getString("sid");
            String name = rs.getString("name");
            Date birth = rs.getDate("birth");
            String sex = rs.getString("sex");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            String address = rs.getString("address");
            String room = rs.getString("room");
            String building = rs.getString("building");
            String disease = rs.getString("disease");
		        
		    result = new patients(patient_id, sid, name, birth, sex, phone, email, address, room, building, disease);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(st!=null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
    }
	
	public int insertPatientNeedHelp(patients t) {
		int result = 0;
		Connection con = null;
		Statement st = null;
		try {
			con = JDBCUtil.getConnection();
			st = con.createStatement();
			
			String sql = "Insert Into patient_need_help (patient_id,name,room,building) "+
			"VALUES ('"+t.getId()+"', '"+t.getName()+"', '"+t.getRoom()+"', '"+t.getBuilding()+"')";
			
			result = st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(st!=null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
    }
	
	public boolean checkExistPatientNeedHelp(String id) {
        boolean result = false;
        Connection con = null;
		Statement st = null;
		try {
			con = JDBCUtil.getConnection();
			st = con.createStatement();
			
			String sql = "SELECT * FROM patient_need_help WHERE patient_id = '" + id + "'";
			
			// tra ve 1 table
			ResultSet rs = st.executeQuery(sql);
			String checkPatient = "";
			if (rs.next()) {
                checkPatient = rs.getString("patient_id");
                if (checkPatient.equals(id))
                    result = true;
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(st!=null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
    }
}
