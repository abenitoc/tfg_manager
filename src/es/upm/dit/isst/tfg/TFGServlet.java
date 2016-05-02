package es.upm.dit.isst.tfg;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.tfg.dao.TFGDAO;
import es.upm.dit.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;

public class TFGServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 212171272476140668L;

	/**
	 * Método encargado
	 * */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws IOException, ServletException {
		
	}
	
	/**
	 * Método encargado de crear la petición en estado 1
	 * */
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			 throws IOException, ServletException {
		
		String autor = req.getRemoteUser();
		String title = req.getParameter("titulo");
		String resumen = req.getParameter("resumen");
		String tutor = req.getParameter("tutor");
		
		TFGDAO tfgdao = TFGDAOImpl.getInstance();
		TFG tfg = tfgdao.createTFG(autor, title, resumen, tutor);
		
		try{
			MimeMessage msg = new MimeMessage(Session.getDefaultInstance(new Properties(), null));
			 msg.setFrom(new InternetAddress("tfg@tfg_manager.appspotmail.com", "Sistema de gestion de TFG"));
			 msg.addRecipient(Message.RecipientType.TO,  new InternetAddress(tfg.getAutor(), "Solicitante de TFG"));
			  msg.setSubject("El profesor " + tutor + " acepta actuar como tutor del TFG");
	          msg.setText("El profesor " + tutor + " acepta actuar como tutor del TFG propuesto por " + tfg.getAutor()
	+ " con titulo " + tfg.getTitulo());
	          Transport.send(msg);

			}
			catch(Exception e){}
		
		resp.sendRedirect("/isst_tfg_t4");
		
	}
}
