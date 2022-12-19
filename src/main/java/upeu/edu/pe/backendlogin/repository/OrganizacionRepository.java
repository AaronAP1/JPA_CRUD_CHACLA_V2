package upeu.edu.pe.backendlogin.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.backendlogin.entity.Organizacion;


@Repository
public interface OrganizacionRepository extends JpaRepository<Organizacion, Integer> {

}
