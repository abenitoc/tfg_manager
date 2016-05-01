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
	public TFG createTFG(String autor, String title, String resumen, String tutor) {
		
		TFG tfg = null;
		
		EntityManager em = EMFService.get().createEntityManager();
		// TODO Auto-generated method stub
		
		tfg = new TFG(autor, title, resumen, tutor, "","", 1);
		em.getTransaction().begin();
		em.persist(tfg);
		em.getTransaction().commit();
		em.close();
		
		return tfg;
	}

	@Override
	public TFG readTFG(String autor) {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select t from TFG t where t.autor = :autor");
		q.setParameter("autor", autor);
		TFG res = null;
		@SuppressWarnings("unchecked")
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
		@SuppressWarnings("unchecked")
		List<TFG> tfgs = q.getResultList();
		em.close();
		return tfgs;
	};

	@Override
	public TFG updateTFG(TFG tfg) {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		em.getTransaction().begin();
		TFG res = em.merge(tfg);
		em.getTransaction().commit();
		em.close();
		return res;
	}

	@Override
	public void deleteTFG(String autor_email) {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		try{
			TFG tfgtoDel = em.find(TFG.class, autor_email);
			em.getTransaction().begin();
			em.remove(tfgtoDel);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

}
