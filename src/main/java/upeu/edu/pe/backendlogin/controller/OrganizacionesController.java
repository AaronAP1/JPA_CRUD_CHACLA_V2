package upeu.edu.pe.backendlogin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upeu.edu.pe.backendlogin.entity.Organizacion;
import upeu.edu.pe.backendlogin.service.OrganizacionesService;


@RestController
@RequestMapping("/api/organizacion")
@CrossOrigin({"*"})
public class OrganizacionesController {
	
	@Autowired
	OrganizacionesService OrgaServi;
	
	@GetMapping("/listar")
	public List<Organizacion> getOrganizacion(){
		return OrgaServi.readAllOrganizacion();
	}
	
	@GetMapping("/listar-organizacion/{id_organizacion}")
	public Optional<Organizacion> getOrganizacion(@PathVariable int id_organizacion){
		return OrgaServi.readById(id_organizacion);
	}
	
	@PostMapping("/crear-organizacion")
	public Organizacion create(@RequestBody Organizacion organizacion) {
		return OrgaServi.createOrganizacion(organizacion);
	}
	
	@PutMapping("/actualizar-organizacion/{id_organizacion}")
	public Organizacion update(@PathVariable int id_organizacion, @RequestBody Organizacion organizacion ) {
		return OrgaServi.updateCategoria(id_organizacion, organizacion);
	}
	
	

}
