package projectABI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectABI.dto.CadastroDto;
import projectABI.dto.LoginDto;
import projectABI.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        CadastroDto usuarioAutenticado = service.autenticarUsuario(loginDto.getUsuario(), loginDto.getSenha());

        if (usuarioAutenticado != null) {
            LoginDto resposta = new LoginDto("Login realizado com sucesso!", usuarioAutenticado.getId());
            return ResponseEntity.ok(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginDto("Usuário ou senha inválidos.", null));
        }
    }



}
