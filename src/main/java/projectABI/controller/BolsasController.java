package projectABI.controller;

import org.springframework.web.bind.annotation.*;
import projectABI.dto.BolsasDto;
import projectABI.repository.BolsasRepository;
import projectABI.service.BolsasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bolsas")
public class BolsasController {

    private BolsasRepository bolsasRepository;
    private BolsasService service;

    public BolsasController(BolsasRepository bolsasRepository, BolsasService service) {
        this.bolsasRepository = bolsasRepository;
        this.service = service;
    }

    @GetMapping("/listar-bolsas")
    public List<BolsasDto> listarBolsas(@RequestParam("qnt") int qnt, @RequestParam("pagina") int pagina){
        return service.listarBolsas(qnt, pagina);
    }

    @GetMapping("/{id}")
    public Optional<BolsasDto> bolsaEspecifica(@PathVariable String id){
        return bolsasRepository.findById(id);
    }

    @GetMapping("/listar-bolsas/filtro")
    public List<BolsasDto> listarBolsasFillro(@RequestParam("qnt") int qnt, @RequestParam("pagina") int pagina, @RequestParam("filtro") String filtro){
        return service.listarBolsasFiltro(qnt, pagina, filtro);
    }
}
