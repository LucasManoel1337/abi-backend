package projectABI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectABI.dto.CadastroDto;
import projectABI.service.CadastroService;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    private CadastroService cadastroService;

    @Autowired
    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @PostMapping("/novo")
    public ResponseEntity<? extends Object> cadastrar(@RequestBody CadastroDto cadastroDto) {
        CadastroDto salvo = cadastroService.novoUsuario(cadastroDto);
        if (salvo != null) {
            return ResponseEntity.ok("Usuário cadastrado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar usuário.");
        }
    }
}
