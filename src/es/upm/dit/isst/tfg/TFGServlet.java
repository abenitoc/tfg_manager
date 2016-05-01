package es.upm.dit.isst.tfg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.tfg.dao.TFGDAO;
import es.upm.dit.isst.tfg.dao.TFGDAOImpl;

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
		tfgdao.createTFG(autor, title, resumen, tutor);
		
		resp.sendRedirect("/isst_tfg_t4");
		
	}
}
