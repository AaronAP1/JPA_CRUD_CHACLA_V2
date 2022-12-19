package upeu.edu.pe.backendlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.backendlogin.entity.Requisito;

@Repository
public interface RequisitoRepository extends JpaRepository<Requisito, Integer>{

}
