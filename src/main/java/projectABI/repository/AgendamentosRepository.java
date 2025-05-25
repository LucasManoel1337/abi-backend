package projectABI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectABI.dto.AgendamentosDto;

import java.util.List;
import java.util.Optional;

public interface AgendamentosRepository extends JpaRepository<AgendamentosDto, String> {

    Optional<AgendamentosDto> findAllByIdUsuario(String id);

    @Query("SELECT a.horarioMarcado FROM AgendamentosDto a WHERE a.idUniversidade = :id_universidade AND a.data = :data AND a.categoria = :categoria")
    List<String> findHorariosOcupados(@Param("id_universidade") String idUniversidade,
                                      @Param("data") String data,
                                      @Param("categoria") String categoria);
}
