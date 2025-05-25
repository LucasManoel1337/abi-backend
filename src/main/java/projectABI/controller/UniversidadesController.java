package projectABI.controller;

import org.springframework.web.bind.annotation.*;
import projectABI.dto.UniversidadesDto;
import projectABI.service.UniversidadesService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/universidades")
public class UniversidadesController {

    private UniversidadesService service;

    public UniversidadesController(UniversidadesService service) {
        this.service = service;
    }

    @GetMapping("/buscar")
    public List<UniversidadesDto> buscarUniversidade(@RequestParam("estado") String estado) {
        return service.retornarUniversidadePorEstado(estado);
    }
    
    @GetMapping("/buscar-especifica/{id}")
    public Optional<UniversidadesDto> buscarUniversaidadeEspecifica(@PathVariable("id") String id) {
        return service.returnarUniversidadeEspecifica(id);
    }
}
