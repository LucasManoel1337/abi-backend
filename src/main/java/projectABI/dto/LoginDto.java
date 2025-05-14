package projectABI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    private String mensagem;
    private String id;
    private String usuario;
    private String senha;

    public LoginDto(String mensagem, String id) {
        this.mensagem = mensagem;
        this.id = id;
    }

    // Getters e Setters
}
