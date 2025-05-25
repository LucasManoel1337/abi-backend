package projectABI.service;

import org.springframework.stereotype.Service;
import projectABI.dto.UniversidadesDto;
import projectABI.repository.UniversidadesRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UniversidadesService {

    private UniversidadesRepository repository;

    public UniversidadesService(UniversidadesRepository repository) {
        this.repository = repository;
    }

    public List<UniversidadesDto> retornarUniversidadePorEstado(String estado) {
        return repository.findByEstado(estado);
    }

    public Optional<UniversidadesDto> returnarUniversidadeEspecifica(String Id){
        return repository.findById(Id);
    }
}
