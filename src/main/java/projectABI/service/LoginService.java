package projectABI.service;

import org.springframework.stereotype.Service;
import projectABI.dto.CadastroDto;
import projectABI.repository.CadastroRepository;
import projectABI.service.security.CripDescripSenhaService;

@Service
public class LoginService {

    private CadastroRepository cadastroRepository;
    private final CripDescripSenhaService descripSenha;

    public LoginService(CadastroRepository cadastroRepository, CripDescripSenhaService descripSenha) {
        this.cadastroRepository = cadastroRepository;
        this.descripSenha = descripSenha;
    }

    public CadastroDto autenticarUsuario(String usuario, String senha) {
        CadastroDto cadastro = cadastroRepository.findByUsuario(usuario);

        if (cadastro == null) return null;

        try {
            String senhaDescriptografada = descripSenha.descriptografar(cadastro.getSenha());
            if (senhaDescriptografada.equals(senha)) {
                return cadastro;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
