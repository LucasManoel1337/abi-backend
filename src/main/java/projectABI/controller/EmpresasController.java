package projectABI.controller;

import org.springframework.web.bind.annotation.*;
import projectABI.dto.EmpresasDto;
import projectABI.repository.EmpresasRepository;
import projectABI.service.EmpresasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {

    private EmpresasRepository empresasRepository;
    private EmpresasService service;

    public EmpresasController(EmpresasRepository empresasRepository, EmpresasService service) {
        this.empresasRepository = empresasRepository;
        this.service = service;
    }

    @GetMapping("/listar-empresas")
    public List<EmpresasDto> listarEmpresas(@RequestParam("qnt") int qnt, @RequestParam("pagina") int pagina){
        return service.listarEmpresas(qnt, pagina);
    }

    @GetMapping("/{id}")
    public Optional<EmpresasDto> empresaEspecifica(@PathVariable String id){
        return empresasRepository.findById(id);
    }

    @GetMapping("/listar-empresas/filtro")
    public List<EmpresasDto> listarEmpresas(@RequestParam("qnt") int qnt, @RequestParam("pagina") int pagina, @RequestParam("filtro") String filtro){
        return service.listarEmpresasFiltro(qnt, pagina, filtro);
    }
}
