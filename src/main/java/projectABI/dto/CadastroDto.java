package projectABI.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CadastroDto {

    @Id
    private String id;
    private String usuario;
    private String senha;
}
