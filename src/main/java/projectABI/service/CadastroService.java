package projectABI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectABI.dto.CadastroDto;
import projectABI.repository.CadastroRepository;
import projectABI.service.security.CripDescripSenhaService;

import java.util.UUID;

@Service
public class CadastroService {

    private final CadastroRepository cadastroRepository;
    private final CripDescripSenhaService cripSenha;

    @Autowired
    public CadastroService(CadastroRepository cadastroRepository, CripDescripSenhaService cripSenha) {
        this.cadastroRepository = cadastroRepository;
        this.cripSenha = cripSenha;
    }

    public CadastroDto novoUsuario(CadastroDto cadastroDto) {
        try {
            // Verifica se já existe um usuário com o mesmo login
            CadastroDto existente = cadastroRepository.findByUsuario(cadastroDto.getUsuario());
            if (existente != null) {
                return null;
            }

            cadastroDto.setId(UUID.randomUUID().toString());

            String senhaOriginal = cadastroDto.getSenha();
            String senhaCriptografada = cripSenha.criptografar(senhaOriginal);
            cadastroDto.setSenha(senhaCriptografada);

            return cadastroRepository.save(cadastroDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public CadastroDto buscarPorUsuario(String usuario) {
        return cadastroRepository.findByUsuario(usuario);
    }
}