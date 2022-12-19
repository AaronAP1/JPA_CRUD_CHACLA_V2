package upeu.edu.pe.backendlogin.serviceImp;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.backendlogin.entity.Organizacion;
import upeu.edu.pe.backendlogin.repository.OrganizacionRepository;
import upeu.edu.pe.backendlogin.service.OrganizacionesService;

@Service
public class OrganizacionServiceImp implements OrganizacionesService  {
	
	@Autowired
	
	OrganizacionRepository orgaRep;

	@Override
	public List<Organizacion> readAllOrganizacion() {
		// TODO Auto-generated method stub
		return  orgaRep.findAll();
	}

	@Override
	public Optional<Organizacion> readById(int id_organizacion) {
		// TODO Auto-generated method stub
		return orgaRep.findById(id_organizacion);
	}

	@Override
	public Organizacion createOrganizacion(Organizacion organizacion) {
		// TODO Auto-generated method stub
		return orgaRep.save(organizacion);
	}

	@Override
	public Organizacion updateCategoria(int id_organizacion, Organizacion organizacion) {
		// TODO Auto-generated method stub
		 Organizacion organi_update= orgaRep.findById(id_organizacion).get();
		 organi_update.setCODIGO(organizacion.getCODIGO());
		 
		 return orgaRep.save(organi_update);
	}

}
