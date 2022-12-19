package upeu.edu.pe.backendlogin.entity;




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
@Table(name = "ORGANIZACION")
public class Organizacion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ID_ORGANIZACION")
	private int ID_ORGANIZACION;
	private String CODIGO;
	private String NOMBRE;
	private String DIRECCION;
	private String INI_VIGENCIA;
	private String FIN_VIGENCIA;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO")
	private Parametro Organizacion1;
	
	@ManyToOne
	@JoinColumn(name = "ID_ZONA")
	private Parametro Organizacion2;

	@ManyToOne
	@JoinColumn(name = "ID_NIVEL")
	private Parametro Organizacion3;
	
	@JoinColumn(name= "ID_DOCUMENTO")
	@OneToOne
	private Documento documento;
	
	
	

}
