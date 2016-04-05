package es.upm.dit.isst.tfg.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TFG implements Serializable {
	private static final long serialVersionUID = 01L;
	
	@Id
	private String autor;
	
}
