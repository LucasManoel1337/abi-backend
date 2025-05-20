package projectABI.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BolsasDto {

    @Id
    private String id;
    private String nome;
    private String categoria;
    private String instituicao;
    private String descricao;
    private String tipoDeApoio;
    private String modalidade;
    private String exigenciaEscolaridade;
}
