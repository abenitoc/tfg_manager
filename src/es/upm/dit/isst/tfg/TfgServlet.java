package es.upm.dit.isst.tfg;

import java.io.IOException;

import javax.servlet.http.*;

import es.upm.dit.isst.tfg.dao.TFGDAO;
import es.upm.dit.isst.tfg.dao.TFGDAOImpl;

@SuppressWarnings("serial")
public class TfgServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		TFGDAO dao = TFGDAOImpl.getInstance();

		resp.getWriter().println(dao.readTFG("dios"));

		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
