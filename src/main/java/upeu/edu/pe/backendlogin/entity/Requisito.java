package upeu.edu.pe.backendlogin.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Entity
@Table(name = "REQUISITO")
public class Requisito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRIVILEGIO")
	private int ID_REQUISITO;
	private String NOMBRE;
	private String TIPO;
	private String MODELOWORD;
	private String MODELOPDF;
	private String DESCRIPCION;
	private String ESTADO;
	
	@ManyToMany
	@JoinTable(name= "DOCSOLI"
	, joinColumns= @JoinColumn(name="ID_PRIVILEGIO"), inverseJoinColumns=@JoinColumn(name="ID_SOLICITUD"))
	private Set<Solicitud> solicitud;

}
