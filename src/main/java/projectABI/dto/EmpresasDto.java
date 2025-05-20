package projectABI.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EmpresasDto {

    @Id
    private String id;
    private String nome;
    private String categoria;
    private String funcao;
    private String descricao;

}
