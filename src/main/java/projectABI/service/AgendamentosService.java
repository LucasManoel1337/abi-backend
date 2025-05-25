package projectABI.service;

import org.springframework.stereotype.Service;
import projectABI.dto.AgendamentosDto;
import projectABI.repository.AgendamentosRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgendamentosService {

    private AgendamentosRepository repository;

    public AgendamentosService(AgendamentosRepository repository) {
        this.repository = repository;
    }

    public void novoAgendamento(String categoria, String idUsuario, String idUniversidade, String nomeUniversidade, String data, String horarioMarcado, String modelo) {
        AgendamentosDto novoAgendamento = new AgendamentosDto();

        novoAgendamento.setId(UUID.randomUUID().toString());
        novoAgendamento.setCategoria(categoria);
        novoAgendamento.setIdUsuario(idUsuario);
        novoAgendamento.setIdUniversidade(idUniversidade);
        novoAgendamento.setNomeUniversidade(nomeUniversidade);
        novoAgendamento.setData(data);
        novoAgendamento.setHorarioMarcado(horarioMarcado);
        novoAgendamento.setModelo(modelo);

        repository.save(novoAgendamento);
    }

    public Optional<AgendamentosDto> buscarAgendamentos(String id){
        return repository.findAllByIdUsuario(id);
    }

    public List<String> buscarHorariosOcupados(String idUniversidade, String data, String categoria) {
        return repository.findHorariosOcupados(idUniversidade, data, categoria);
    }

    public void cancelarAgendamento(String id){
        repository.deleteById(id);
    }
}
