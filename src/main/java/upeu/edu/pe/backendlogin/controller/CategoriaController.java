package upeu.edu.pe.backendlogin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upeu.edu.pe.backendlogin.entity.Categoria;
import upeu.edu.pe.backendlogin.service.CategoriaService;


@RestController
@RequestMapping("/api/categoria")
@CrossOrigin({"*"})
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping("/get-all")
	public List<Categoria> getCategorias(){
		return categoriaService.readAllCategories();
	}
	
	@GetMapping("/get-categoria/{id_categoria}")
	public Optional<Categoria> getCategoria(@PathVariable int id_categoria){
		return categoriaService.readOneCategoria(id_categoria);
	}

	@PostMapping("/create-categoria")
	public Categoria create(@RequestBody Categoria categoria){
		return categoriaService.createCategoria(categoria);
	}
	
	@PutMapping("/update-categoria/{id_categoria}")
	public Categoria update(@PathVariable int id_categoria, @RequestBody Categoria categoria){
		return categoriaService.updateCategoria(id_categoria, categoria);
	}
	
	@DeleteMapping("/delete-categoria/{id_categoria}")
	public void delete(@PathVariable int id_categoria){
		categoriaService.deleteCategoria(id_categoria);
	}
	
	
}
