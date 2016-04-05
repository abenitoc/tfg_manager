package es.upm.dit.isst.tfg.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EMFService {
	
	private static final EntityManagerFactory emfinstance = Persistence.createEntityManagerFactory("transactions-optional");
	
	private EMFService(){
		
	}
	
	public static EntityManagerFactory get(){
		return emfinstance;
	}
	
}
