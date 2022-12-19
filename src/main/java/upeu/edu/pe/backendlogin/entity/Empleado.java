package upeu.edu.pe.backendlogin.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLEADO")
public class Empleado {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EMPLEADO")
	private int ID_EMPLEADO;
	private String CARGO;
	
	@JoinColumn(name = "ID_PERSONA", unique = true)
	@OneToOne(cascade = CascadeType.ALL)
	private Persona persona;

}
