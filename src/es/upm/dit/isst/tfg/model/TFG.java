package es.upm.dit.isst.tfg.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TFG implements Serializable {
	private static final long serialVersionUID = 01L;
	
	@Id
	private String autor;
	private String titulo;
	private String resumen;
	private String tutor;
	private String secretario;
	private String fichero;
	private int estado;
	private String memoria; 
	
	public TFG(String autor, String titulo, String resumen, String tutor, String secretario,
			 String fichero, int estado) {
		 this.autor = autor;
		 this.titulo = titulo;
		 this.setResumen(resumen);
		 this.setTutor(tutor);
		 this.setSecretario(secretario);
		 this.setFichero(fichero);
		 this.estado = estado;
		 this.setMemoria(null);
		} 
	
	public int getEstado(){
		return estado;
	}
	public void setEstado(int estado){
		this.estado = estado;
	}
	
	public String getAutor(){
		return autor;
	}
	
	public String getTitulo(){
		return titulo;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getSecretario() {
		return secretario;
	}

	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}

	public String getFichero() {
		return fichero;
	}

	public void setFichero(String fichero) {
		this.fichero = fichero;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}
	

}
