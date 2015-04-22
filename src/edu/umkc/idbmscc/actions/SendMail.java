package edu.umkc.idbmscc.actions;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.umkc.idbmscc.dao.LoginDao;
import edu.umkc.idbmscc.dao.LoginDaoImpl;
import edu.umkc.idbmscc.dto.LoginDto;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String smtpHost = "localhost";
		int smtp_Port = 25;
		String from = "collectorcoupons@gmail.com";
		String to = request.getParameter("email");
		String subject = "Password Recovery";
		LoginDto loginDto = new LoginDto();
		String content = "";
		String nextJSP = "/passwordRecover.jsp";
		RequestDispatcher dispatcher;
		
		java.util.Properties props = new java.util.Properties();
		   
        String smtpPort = Integer.toString(smtp_Port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props, null);
        Message msg = new MimeMessage(session);
        try {
			msg.setFrom(new InternetAddress(from));
			 msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));//set to mailId here.
		        msg.setRecipient(Message.RecipientType.CC,new InternetAddress(to));//set cc mailId here.
		        msg.setSubject(subject);//mail Subject
		        

		        String mailHost= "smtp.gmail.com";//mailHost for your mail provider.For gmail smtp.gmail.com
		        String userName = "collectorcoupons@gmail.com";//userName for an E-mail provider.
		        String password = "Idbmslab1$";//password for the same.
		        Transport tr = session.getTransport("smtp");
		        tr.connect(mailHost,userName,password);
		        System.out.println("whether connection established***"+tr.isConnected());
		        
		        LoginDao loginDao = new LoginDaoImpl();

				try {
					loginDto = loginDao.getPassword(to);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					request.setAttribute("error", "Error Occurred while sending mail check again");
					e.printStackTrace();
				}
				
				if(loginDto.getEmail()== null){
					request.setAttribute("error", "Username doesnot exit");
				}else {
				    content = "<i>Greetings!</i><br>";
	
				    content += "<font color=red>Your Password to Coupons Collector is "+loginDto.getPassword()+"</font><br>";
				    content += "<b>Wish you a nice day!</b><br>";
				    content += "<b><font color=blue>By @ Team Coupons Collector</font></b><br>";
				    msg.setContent(content,"text/html");//mail content in plain format
				    msg.saveChanges();
				    tr.sendMessage(msg, msg.getAllRecipients());
				    tr.close();
				    request.setAttribute("message", "Email sent to your mailid...!!!!!");
				}
		        System.out.println("Message sent OK.");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "Error Occurred while sending mail check again");
			e.printStackTrace();
		} catch (MessagingException e) {
			request.setAttribute("error", "Error Occurred while sending mail check again");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//set from mailId here.
       
		dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
