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
@Table(name = "SOLICITUD")
public class Solicitud {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SOLICITUD")
	private int ID_SOLICITUD;
	private String NEXPEDIENTE;
	private String TIPO;
	private String INI_VIGENCIA;
	private String FIN_VIGENCIA;
	private String ESTADO;
	private String FECHAREGISTRO;
	
	

	
	@ManyToOne
	@JoinColumn(name = "ID_SOLIORG")
	private SoliOrganizacion soliorganizacion;

}
