package es.upm.dit.isst.tfg.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TFG implements Serializable {
	private static final long serialVersionUID = 01L;
	
	@Id
	private String autor_email;
	private String title;
	
	public TFG(String autor_email, String title){
		super();
		this.autor_email = autor_email;
		this.title = title;
	}
}
