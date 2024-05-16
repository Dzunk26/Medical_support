package DataAccessObject;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Database.JDBCUtil;
import model.account;

public class AccountDAO implements DAOInterface<account>{

	public static AccountDAO getInstance() {
		return new AccountDAO();
	}
	
	@Override
	public int insert(account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(account t) {
		int result = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "UPDATE account "
					+ "Set"
					+ " password = ?"
					+ ", username = ?"
					+ "WHERE id = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, t.getPassword());
			pst.setString(2, t.getUsername());
			pst.setString(3, t.getId());
			
			// tra ve so dong thay doi
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(pst!=null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public int delete(account t) {
		int result=0;
		Connection con=null;
		Statement st=null;
		try {
			con = JDBCUtil.getConnection();
			
			st = con.createStatement();
			
			String sql = "DELETE from account "+
						"Where username='"+t.getUsername()+"'";
			
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
	public ArrayList<account> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public account selectById(account t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<account> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkAccExist(String username) {
		boolean result=false;
		Connection con=null;
		Statement st=null;
		try {
			con = JDBCUtil.getConnection();
			st = con.createStatement();
			
			String sql= "SELECT username from account "
						+ "Where username = '"+username+"'";
			
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
				result=true;
			
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
	
	public boolean checkPassword(String username, String password) {
		boolean result=false;
		Connection con=null;
		Statement st=null;
		try {
			con = JDBCUtil.getConnection();
			st = con.createStatement();
			
			String sql = "SELECT password from account "
						+ "Where username = '"+username+"'"+" And password = '"+password+"'";
			
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
				result=true;
			
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
	
	public String getTypeAcc(String username, String password) {
		String result="";
		Connection con=null;
		Statement st=null;
		try {
			con = JDBCUtil.getConnection();
			
			st = con.createStatement();
			
			String sql = "SELECT type_account from account "
					+ "Where username = '"+username+"'"+" And password = '"+password+"'";
			
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
				result=rs.getString("type_account");
			
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
	
	public String getID(String user) {
		String result = "";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "SELECT id FROM account WHERE username = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, user);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next())
				result = rs.getString("id");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(pst!=null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public boolean checkID(String id) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM account WHERE id = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			String checkid = "";
			
			if(rs.next()) {
				checkid = rs.getString("id");
				if (id.equals(checkid))
					result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(pst!=null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public boolean checkIDPatient(String id) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM patient WHERE id = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			String checkid1 = "";
			
			if(rs.next()) {
				checkid1 = rs.getString("id");
				if (id.equals(checkid1))
					result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(pst!=null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public boolean checkIDDoctor(String id) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM doctor WHERE doctor_id = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			String checkid1 = "";
			
			if(rs.next()) {
				checkid1 = rs.getString("doctor_id");
				if (id.equals(checkid1))
					result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(pst!=null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public account getByID(String id) {
		account result = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM account WHERE id = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			rs.next();
			String username = rs.getString("username");
			String password = rs.getString("password");
			
			result = new account(id, username, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(pst!=null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int insertAccount(account t, String typeAcc) {
		int result = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO account (id, username, password, type_account) "
					+ "VALUES (?, ?, ?, ?);";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, t.getId());
			pst.setString(2, t.getUsername());
			pst.setString(3, t.getPassword());
			pst.setString(4, typeAcc);
			
			// tra ve so dong thay doi
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(pst!=null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public void changePassword(String username, String password) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "UPDATE account "
					+ "Set"
					+ " password = ?"
					+ "WHERE username = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, username);
			
			// tra ve so dong thay doi
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					JDBCUtil.closeConnection(con);
				if(pst!=null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}