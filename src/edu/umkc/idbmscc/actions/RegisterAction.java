package edu.umkc.idbmscc.actions;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.umkc.idbmscc.dao.LoginDao;
import edu.umkc.idbmscc.dao.LoginDaoImpl;
import edu.umkc.idbmscc.dto.LoginDto;
import edu.umkc.idbmscc.dto.RegisterDto;

/**
 * Servlet implementation class RegisterAction
 */
@WebServlet("/Register")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobilenumber = request.getParameter("mobileno");
		String zipcode = request.getParameter("zipcode");
		String category = request.getParameter("categories");
		RegisterDto registerDto = new RegisterDto();
		String nextJSP = "/login.jsp";
		RequestDispatcher dispatcher;
		
		registerDto.setFirstname(firstname);
		registerDto.setLastname(lastname);
		registerDto.setEmail(email);
		registerDto.setPassword(password);
		registerDto.setMobilenumber(mobilenumber);
		registerDto.setZipcode(zipcode);
		registerDto.setCategory(category);
		
		System.out.println(registerDto.toString());
		
		LoginDao loginDao = new LoginDaoImpl();

		try {
			boolean reg = loginDao.registerUser(registerDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

		
	}

}
