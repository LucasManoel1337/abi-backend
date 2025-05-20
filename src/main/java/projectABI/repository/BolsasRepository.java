package projectABI.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import projectABI.dto.BolsasDto;

public interface BolsasRepository extends JpaRepository<BolsasDto, String> {

    Page<BolsasDto> findByCategoriaIgnoreCase(String categoria, Pageable pageable);

}
