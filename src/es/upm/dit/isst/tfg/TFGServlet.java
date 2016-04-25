package es.upm.dit.isst.tfg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.tfg.dao.TFGDAO;
import es.upm.dit.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;

public class TFGServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws IOException, ServletException {
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			 throws IOException, ServletException {
		String autor = req.getParameter("autor_email");
		String title = req.getParameter("title");
		String resumen = req.getParameter("resumen");
		String tutor = req.getParameter("tutor");
		
		TFGDAO tfgdao = TFGDAOImpl.getInstance();
		TFG tfg = tfgdao.createTFG(autor, title, resumen, tutor);
		
		
	}
}
