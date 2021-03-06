package es.upm.dit.isst.tfg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.tfg.dao.TFGDAO;
import es.upm.dit.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;

public class TeacherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws IOException, ServletException {
		
			String autor = (String)req.getParameter("autor");
			
			TFGDAO tfgdao = TFGDAOImpl.getInstance();
			TFG tfg = tfgdao.readTFG(autor);
			tfg.setEstado(2);
			tfgdao.updateTFG(tfg);
			
			
			resp.sendRedirect("/isst_tfg_t4");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			 throws IOException, ServletException {
		
		
		
	}

}
