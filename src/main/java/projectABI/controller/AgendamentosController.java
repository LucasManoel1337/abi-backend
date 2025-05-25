package projectABI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectABI.dto.AgendamentosDto;
import projectABI.service.AgendamentosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentosController {

    private AgendamentosService service;

    public AgendamentosController(AgendamentosService service) {
        this.service = service;
    }

    @PostMapping("/novo")
    public void novoAgendamento(@RequestParam("categoria") String categoria,
                                @RequestParam("idUsuario") String idUsuario,
                                @RequestParam("idUniversidade") String idUniversidade,
                                @RequestParam("nomeUniversidade") String nomaUniversidade,
                                @RequestParam("data") String data,
                                @RequestParam("horarioMarcado") String horarioMarcado,
                                @RequestParam("modelo") String modelo) {
        service.novoAgendamento(categoria, idUsuario, idUniversidade, nomaUniversidade, data, horarioMarcado, modelo);
    }

    @GetMapping("/buscar-agendamentos/{id}")
    public Optional<AgendamentosDto> buscarAgendamentos(@PathVariable("id") String id){
        return service.buscarAgendamentos(id);
    }

    @GetMapping("/horarios-ocupados")
    public ResponseEntity<List<String>> getHorariosOcupados(
            @RequestParam String idUniversidade,
            @RequestParam String data,
            @RequestParam String categoria
    ) {
        List<String> horariosOcupados = service.buscarHorariosOcupados(idUniversidade, data, categoria);
        return ResponseEntity.ok(horariosOcupados);
    }

    @DeleteMapping("/cancelar-agendamento/{id}")
    public void cancelarAgendamento(@PathVariable("id") String id){
        service.cancelarAgendamento(id);
    }

}
