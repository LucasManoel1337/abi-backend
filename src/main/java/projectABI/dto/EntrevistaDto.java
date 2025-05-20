package projectABI.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class EntrevistaDto {

    @Id
    private String id;
    private String idUsuario;

    //Dados Pessoais
    private String nomeCompleto;
    private String nacionalidade;
    private Date dataNascimento;
    private String idioma;

    // Sim ou Não para liberar campos
    private boolean documentoIdentificacao;
    private String qualDocumento;
    private String numeroDocumento;

    // Sim ou Não para liberar campos
    private boolean conhecidosNoBrasil;
    private String quemSao;

}
