package es.upm.dit.isst.tfg.dao;

import java.util.List;

import es.upm.dit.isst.tfg.model.TFG;

public interface TFGDAO {
	
	public TFG createTFG(String autor_email, String title, String resumen, String tutor);
	public TFG readTFG(String autor_email);
	public List<TFG> isATeacher(String teacher);
	public TFG updateTFG(TFG tfg);	
	public void deleteTFG(String autor_email);

	
}
