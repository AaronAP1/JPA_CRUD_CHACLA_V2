package upeu.edu.pe.backendlogin.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.backendlogin.entity.Categoria;
import upeu.edu.pe.backendlogin.repository.CategoriaRepository;
import upeu.edu.pe.backendlogin.service.CategoriaService;

@Service
public class CategoriaServiceImp implements CategoriaService{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> readAllCategories() {
		return categoriaRepository.findAll();
	}

	@Override
	public Optional<Categoria> readOneCategoria(int id_categoria) {
		return categoriaRepository.findById(id_categoria);
	}

	@Override
	public Categoria createCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria updateCategoria(int id_categoria, Categoria categoria) {
		Categoria categoria_update = categoriaRepository.findById(id_categoria).get();
		categoria_update.setNombre_categoria(categoria.getNombre_categoria());
		return categoriaRepository.save(categoria_update);
	}

	@Override
	public void deleteCategoria(int id_categoria) {
		categoriaRepository.deleteById(id_categoria);
		
	}
	
}
