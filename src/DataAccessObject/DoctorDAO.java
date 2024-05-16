package DataAccessObject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Database.JDBCUtil;
import model.doctor;

public class DoctorDAO implements DAOInterface<doctor>{
	public static DoctorDAO getInstance() {
		return new DoctorDAO();
	}

	@Override
	public int insert(doctor t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "INSERT INTO doctor (doctor_id, name, birth, sex, phone, email, specialist, position, degree, experience)"
					+ "VALUES ('"+t.getId()+"', '"+t.getName()+"', '"+t.getBirth()+"', '"+t.getSex()+"', '"+t.getPhone()+"', '"+t.getEmail()+"', '"+t.getSpecialist()+"', '"+t.getPosition()+"', '"+t.getDegree()+"', '"+t.getExperience()+"');";
			
			// tra ve so dong thay doi
			result = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(doctor t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "UPDATE doctor "
					+ "SET "
					+ "name = '" + t.getName() +"'"
					+ ", birth = '" + t.getBirth() + "'"
					+ ", sex = '" + t.getSex() + "'"
					+ ", phone = '" + t.getPhone() + "'"
					+ ", email = '" + t.getEmail() + "'"
					+ ", specialist = '" + t.getSpecialist() + "'"
					+ ", position = '" + t.getPosition() + "'"
					+ ", degree = '" + t.getDegree() + "'"
					+ ", experience = '" + t.getExperience() + "'"
					+ "WHERE doctor_id = '" + t.getId() + "'";
			
			result = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(doctor t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "DELETE FROM doctor "
					+ "WHERE doctor_id = '" + t.getId() + "'";
			
			result = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public ArrayList<doctor> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public doctor selectById(doctor t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<doctor> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkExist(String id) {
		boolean result = false;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM doctor WHERE doctor_id = ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			String checkuser = "";
			
			if (rs.next()) {
				checkuser = rs.getString("doctor_id");
				if (id.equals(checkuser))
					result = true;
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public doctor getInfor(String id) {
		doctor result = null;
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM doctor WHERE doctor_id = '" + id + "'";
			
			// tra ve 1 table
			ResultSet rs = st.executeQuery(sql);
			
			rs.next();
			String doctor_id = rs.getString("doctor_id");
			String name = rs.getString("name");
	        Date birth = rs.getDate("birth");
	        String sex = rs.getString("sex");
	        String phone = rs.getString("phone");
		    String email = rs.getString("email");
		    String specialist = rs.getString("specialist");
		    String position = rs.getString("position");
		    String degree = rs.getString("degree");
		    String experience = rs.getString("experience");
		        
		    result = new doctor(doctor_id, name, birth, sex, phone, email, specialist, position, degree, experience);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
