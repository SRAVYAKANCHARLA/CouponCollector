package edu.umkc.idbmscc.dao;

import java.sql.SQLException;
import java.util.List;

import edu.umkc.idbmscc.dto.DealsDto;
import edu.umkc.idbmscc.dto.LoginDto;
import edu.umkc.idbmscc.dto.RegisterDto;

public interface LoginDao {

	LoginDto loginCheck(String username, String password) throws SQLException;
	boolean registerUser(RegisterDto registerDto)throws SQLException;
	List<DealsDto> getUserPrefDeals(LoginDto loginDto)throws SQLException;
}
