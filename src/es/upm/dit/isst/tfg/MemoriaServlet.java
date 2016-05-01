package es.upm.dit.isst.tfg;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import es.upm.dit.isst.tfg.dao.TFGDAO;
import es.upm.dit.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;


public class MemoriaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws IOException, ServletException {
		String autor = req.getParameter("autor");
		TFGDAO tfgdao = TFGDAOImpl.getInstance();
		TFG tfg2 = tfgdao.readTFG(autor);
		
		BlobKey blobKey = new BlobKey(tfg2.getMemoria());
		BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		blobstoreService.serve(blobKey, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			 throws IOException, ServletException {
		
		Map<String, List<BlobKey>> blobs = BlobstoreServiceFactory.getBlobstoreService().getUploads(req);
		List<BlobKey> blobKeys = blobs.get("file");
		if (blobKeys == null || blobKeys.isEmpty()) {
			resp.sendRedirect("isst_tfg_t4");
		} else {
			String autor = req.getRemoteUser();
			TFGDAO tfgdao = TFGDAOImpl.getInstance();
			TFG tfg2 = tfgdao.readTFG(autor);
			tfg2.setMemoria(blobKeys.get(0).getKeyString());
			tfg2.setEstado(3);
			tfgdao.updateTFG(tfg2);
			
			resp.sendRedirect("/serve?blob-key=" + blobKeys.get(0).getKeyString());
		}


		
		resp.sendRedirect("isst_tfg_t4");
		
		
	}
}
