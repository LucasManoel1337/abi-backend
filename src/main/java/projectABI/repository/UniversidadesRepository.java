package projectABI.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import projectABI.dto.UniversidadesDto;

public interface UniversidadesRepository extends JpaRepository<UniversidadesDto, String> {

    List<UniversidadesDto> findByEstado(String estado);

}
