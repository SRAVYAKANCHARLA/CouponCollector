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

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Login() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("login");
		String password = request.getParameter("pass");
		LoginDto loginDto = null;
		String nextJSP = "/login.jsp";
		RequestDispatcher dispatcher;
		HttpSession httpSession = request.getSession();
		System.out.println(username);
		LoginDao loginDao = new LoginDaoImpl();

		try {
			loginDto = loginDao.loginCheck(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (loginDto.getEmail() != null) {
			System.out.println(loginDto.toString());
			httpSession.setAttribute("loginObj", loginDto);
			
			try {
				loginDao.getUserPrefDeals(loginDto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			nextJSP = "/index.html";
			
		} else {
			System.out.println("Else condition");
			request.setAttribute("error", "invalid");
			nextJSP = "/login.jsp";
		}

		dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

	}

}
