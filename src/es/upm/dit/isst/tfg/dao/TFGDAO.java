package es.upm.dit.isst.tfg.dao;

import es.upm.dit.isst.tfg.model.TFG;

public interface TFGDAO {
	
	public TFG createTFG(String autor_email, String title);
	public TFG readTFG(String autor_email);
	public TFG updateTFG(TFG tfg);	
	public void deleteTFG(String autor_email);
	
}
