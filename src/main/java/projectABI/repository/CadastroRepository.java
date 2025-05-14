package projectABI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectABI.dto.CadastroDto;

public interface CadastroRepository extends JpaRepository<CadastroDto, String> {

    CadastroDto findByUsuario(String usuario);

}
