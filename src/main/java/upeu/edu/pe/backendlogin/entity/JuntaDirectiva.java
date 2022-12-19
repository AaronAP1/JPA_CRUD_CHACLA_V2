package upeu.edu.pe.backendlogin.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "JUNTADIRECTIVA")

public class JuntaDirectiva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ID_JD")
	private int ID_JD;
	private String CREDENCIAL;
	
	
	@JoinColumn(name = "ID_CARGO")
	@OneToOne(cascade = CascadeType.ALL)
	private Parametro parametro;
	
	
	@JoinColumn(name= "ID_PERSONA")
	@OneToOne(cascade = CascadeType.ALL)
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name= "ID_SOLICITUD")
	private Solicitud solicitud;

}
