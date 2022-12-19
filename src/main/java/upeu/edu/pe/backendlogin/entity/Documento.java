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
@Table(name = "DOCUMENTO")
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_DOCUMENTO")
	private int ID_DOCUMENTO;
	private String INFTECNICO;
	private String RESOLUCION;
	private String ESTADO;
	
	@JoinColumn(name= "ID_SOLICITUD")
	@OneToOne(cascade= CascadeType.ALL)
	private Solicitud solicitud;

}
