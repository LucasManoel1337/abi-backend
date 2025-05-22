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
    public ResponseEntity<?> cadastrar(@RequestBody CadastroDto cadastroDto) {
        // Verifica se o usuário já existe
        CadastroDto existente = cadastroService.buscarPorUsuario(cadastroDto.getUsuario());

        if (existente != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: já existe um usuário com esse nome.");
        }

        // Prossegue com o cadastro
        CadastroDto salvo = cadastroService.novoUsuario(cadastroDto);

        if (salvo != null) {
            return ResponseEntity.ok("Usuário cadastrado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar usuário.");
        }
    }
}
