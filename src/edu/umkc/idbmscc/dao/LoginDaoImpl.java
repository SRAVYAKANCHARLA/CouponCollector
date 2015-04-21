package edu.umkc.idbmscc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.umkc.idbmscc.dto.DealsDto;
import edu.umkc.idbmscc.dto.LoginDto;
import edu.umkc.idbmscc.dto.RegisterDto;
import edu.umkc.idbmscc.jdbc.DBConnection;

public class LoginDaoImpl implements LoginDao{

	public LoginDto loginCheck(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		
		LoginDto loginDto = new LoginDto();
		
		DBConnection dbConn = new DBConnection();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
 
		String usersSQL = "SELECT * FROM USERS WHERE USERNAME = ?";
		String userPrefSQL = "SELECT * FROM USERPREFERENCES WHERE USERID = ?";
 
		try {
			System.out.println("Hello here try");
			dbConnection = dbConn.getConnection();
			preparedStatement = dbConnection.prepareStatement(usersSQL);
			preparedStatement.setString(1, username);
 
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
 
			while (rs.next()) {
 
				int userid = rs.getInt("USERID");
				String email = rs.getString("EMAIL");
				String mobilenum = rs.getString("MOBILENUMBER");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");

				loginDto.setUserid(userid);
				loginDto.setEmail(email);
				loginDto.setMobilenumber(mobilenum);
				loginDto.setFirstname(firstname);
				loginDto.setLastname(lastname);
				preparedStatement = dbConnection.prepareStatement(userPrefSQL);
				preparedStatement.setInt(1, userid);
				// execute select SQL stetement
				ResultSet rs1 = preparedStatement.executeQuery();
				
				while (rs1.next()) {
					String ZIP = rs1.getString("ZIP");
					
					String categoryid = rs1.getString("CATEGORYID");
					
					loginDto.setZipcode(ZIP);
					loginDto.setCategory(categoryid);
				}
 
			}
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (preparedStatement != null) {
				preparedStatement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
		
		return loginDto;
	}

	@Override
	public boolean registerUser(RegisterDto registerDto) throws SQLException {
		// TODO Auto-generated method stub
		
		
		DBConnection dbConn = new DBConnection();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
 
		String countUsersSQL = "SELECT max(userid) FROM USERS";
		String userInsSQL = "INSERT INTO USERS VALUES (?,?,?,?,?,?,?,?)";
		String userPrefInsSQL = "INSERT INTO USERPREFERENCES VALUES (?,?,?,?,?,?)";
 
		try {
			System.out.println("Hello here try");
			dbConnection = dbConn.getConnection();
			preparedStatement = dbConnection.prepareStatement(countUsersSQL);
			//preparedStatement.setString(1, username);
 
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
				System.out.println("Hello " +count);
			}
			
			count = count+1;
			
			preparedStatement = dbConnection.prepareStatement(userInsSQL);

			preparedStatement.setInt(1, count);
			preparedStatement.setString(2, registerDto.getEmail());
			preparedStatement.setString(3, registerDto.getPassword());
			preparedStatement.setString(4, registerDto.getEmail());
			preparedStatement.setString(5, registerDto.getFirstname());
			preparedStatement.setString(6, registerDto.getLastname());
			preparedStatement.setString(7, registerDto.getMobilenumber());
			preparedStatement.setString(8, "user");
			
			// execute insert SQL stetement
			int result = preparedStatement .executeUpdate();
			
			preparedStatement = dbConnection.prepareStatement(userPrefInsSQL);
			
			preparedStatement.setInt(1, count);
			preparedStatement.setString(2, null);
			preparedStatement.setString(3, registerDto.getZipcode());
			preparedStatement.setString(4, registerDto.getCategory());
			preparedStatement.setString(5, null);
			preparedStatement.setString(6, null);
	
			
			// execute insert SQL stetement
			int result1 = preparedStatement .executeUpdate();
			
			if(result > 0 && result1 >0){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (preparedStatement != null) {
				preparedStatement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
		
		return false;
	}

	@Override
	public List<DealsDto> getUserPrefDeals(LoginDto loginDto) throws SQLException {
		// TODO Auto-generated method stub
		
		
		
		DBConnection dbConn = new DBConnection();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
 
		String countUsersSQL = "SELECT * FROM DEALS WHERE ";
		String strAppend = "";
		System.out.println("ZIP Code"+loginDto.getZipcode());
		if(loginDto.getZipcode() != null && loginDto.getCategory()!= null){
			 strAppend = "ZIP = '"+loginDto.getZipcode()+"' AND categoryid = '"+loginDto.getCategory()+"'";
		}else if(loginDto.getZipcode() == null){
			strAppend = "categoryid = '"+loginDto.getCategory()+"'";
		}else if(loginDto.getCategory()== null){
			strAppend = "ZIP = '"+loginDto.getZipcode()+"'";
		}
	
		countUsersSQL = countUsersSQL+strAppend;
		System.out.println("fkjasfkadhf "+countUsersSQL);
		
		try {
			System.out.println("Hello here try");
			dbConnection = dbConn.getConnection();
			preparedStatement = dbConnection.prepareStatement(countUsersSQL);
			//preparedStatement.setString(1, username);
 
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
				System.out.println("Hello " +count);
			}
			
			count = count+1;
			
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (preparedStatement != null) {
				preparedStatement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
				
		return null;
	}

}
