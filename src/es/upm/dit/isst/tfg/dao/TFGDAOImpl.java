package es.upm.dit.isst.tfg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.dit.isst.tfg.model.TFG;

public class TFGDAOImpl implements TFGDAO {
	
	private static TFGDAOImpl instance;
		
	private TFGDAOImpl(){
		
	}
	
	public static TFGDAOImpl getInstance(){
		if (instance == null)
			instance = new TFGDAOImpl();
		return instance;
	}
	
	@Override
	public TFG createTFG(String autor_email, String title, String resumen, String tutor) {
		
		TFG tfg = null;
		
		EntityManager em = EMFService.get().createEntityManager();
		// TODO Auto-generated method stub
		
		tfg = new TFG(autor_email, title, resumen, tutor, "","", 1);
		em.persist(tfg);
		em.close();
		
		return tfg;
	}

	@Override
	public TFG readTFG(String autor_email) {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select t from TFG t where t.autor_email = :autor_email");
		q.setParameter("autor_email", autor_email);
		TFG res = null;
		List<TFG> tfgs = q.getResultList();
		if(tfgs.size() > 0)
			res = (TFG)(q.getResultList().get(0));
		em.close();
		return res;
	}
	
	public List<TFG> isATeacher(String teacher){
		
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select t from TFG t where t.tutor = :teacher");
		q.setParameter("teacher", teacher);
		List<TFG> tfgs = q.getResultList();
		em.close();
		return tfgs;
	};

	@Override
	public TFG updateTFG(TFG tfg) {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		TFG res = em.merge(tfg);
		em.close();
		return res;
	}

	@Override
	public void deleteTFG(String autor_email) {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		try{
			TFG tfgtoDel = em.find(TFG.class, autor_email);
			em.remove(tfgtoDel);
		} finally {
			em.close();
		}
	}

}
