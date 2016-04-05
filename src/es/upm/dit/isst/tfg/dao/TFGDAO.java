package es.upm.dit.isst.tfg.dao;

import es.upm.dit.isst.tfg.model.TFG;

public interface TFGDAO {

	public TFG createTFG();
	public TFG getTFG();
	public TFG updateUser();	
	public void deleteUser(String user);
	
}
