package es.upm.dit.isst.tfg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.tfg.dao.TFGDAO;
import es.upm.dit.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;

public class SecretarioServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws IOException, ServletException {
	
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			 throws IOException, ServletException {
		String secretario = req.getParameter("secretario");
		String autor = req.getParameter("autor");
		TFGDAO tfgdao = TFGDAOImpl.getInstance();
		TFG tfg = tfgdao.readTFG(autor);
		
		tfg.setSecretario(secretario);
		tfgdao.updateTFG(tfg);
		
		resp.sendRedirect("/isst_tfg_t4");
	}
}
