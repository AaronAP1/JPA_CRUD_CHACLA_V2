package upeu.edu.pe.backendlogin.service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.backendlogin.entity.Organizacion;

public interface OrganizacionesService {
	
	List<Organizacion> readAllOrganizacion();
	Optional<Organizacion> readById(int id_organizacion);
	
	Organizacion createOrganizacion(Organizacion organizacion);
	Organizacion updateCategoria(int id_organizacion, Organizacion organizacion);
	

}
