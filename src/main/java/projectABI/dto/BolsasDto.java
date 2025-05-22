package projectABI.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BolsasDto {

    @Id
    private String id;
    private String nomeInsituicao;
    private String categoria;
    private String curso;
    private String valorDaBolsa;
    private String modeloDeCurso;
    private String dataInicio;
    private String dataFim;
    private String estado;
    private String municipio;
}
