package upeu.edu.pe.backendlogin.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "SOLIORGANIZACION")
public class SoliOrganizacion {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SOLIORG")
	private int ID_SOLIORG;
	private String NOMBRE;
	private String DIRECCION;
	private int MIEMBROS;
	
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO")
	private Parametro tipo;
	
	@ManyToOne
	@JoinColumn(name = "ID_ZONA")
	private Parametro zona;
	
	@ManyToOne
	@JoinColumn(name = "ID_NIVEL")
	private Parametro nivel;

}
