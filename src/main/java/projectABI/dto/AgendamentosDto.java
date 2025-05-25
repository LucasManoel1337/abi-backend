package projectABI.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AgendamentosDto {

    @Id
    private String id;
    private String idUsuario;
    private String categoria;
    private String idUniversidade;
    private String nomeUniversidade;
    private String data;
    private String horarioMarcado;
    private String modelo;
}
