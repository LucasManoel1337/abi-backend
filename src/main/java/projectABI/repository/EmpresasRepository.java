package projectABI.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import projectABI.dto.EmpresasDto;

public interface EmpresasRepository extends JpaRepository<EmpresasDto, String> {

    Page<EmpresasDto> findByCategoriaIgnoreCase(String categoria, Pageable pageable);

}
