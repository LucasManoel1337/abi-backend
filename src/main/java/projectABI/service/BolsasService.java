package projectABI.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectABI.dto.BolsasDto;
import projectABI.dto.EmpresasDto;
import projectABI.repository.BolsasRepository;

import java.util.List;

@Service
public class BolsasService {

    private BolsasRepository bolsasRepository;

    public BolsasService(BolsasRepository bolsasRepository) {
        this.bolsasRepository = bolsasRepository;
    }

    public List<BolsasDto> listarBolsas(int qnt, int paginas) {
        Pageable pageable = PageRequest.of(paginas - 1, qnt);
        return bolsasRepository.findAll(pageable).getContent();
    }

    public List<BolsasDto> listarBolsasFiltro(int qnt, int pagina, String categoria, String estado, String modeloDeCurso) {
        List<BolsasDto> todas = bolsasRepository.findAll()
                .stream()
                .filter(emp -> {
                    boolean matchCategoria = true;
                    boolean matchEstado = true;
                    boolean matchModelo = true;

                    if (categoria != null && !categoria.isBlank()) {
                        if (emp.getCategoria() == null) return false;
                        matchCategoria = emp.getCategoria().trim().equalsIgnoreCase(categoria.trim());
                    }

                    if (estado != null && !estado.isBlank()) {
                        if (emp.getEstado() == null) return false;
                        matchEstado = emp.getEstado().trim().equalsIgnoreCase(estado.trim());
                    }

                    if (modeloDeCurso != null && !modeloDeCurso.isBlank()) {
                        if (emp.getModeloDeCurso() == null) return false;
                        matchModelo = emp.getModeloDeCurso().trim().equalsIgnoreCase(modeloDeCurso.trim());
                    }

                    return matchCategoria && matchEstado && matchModelo;
                })
                .toList();

        int inicio = (pagina - 1) * qnt;
        int fim = Math.min(inicio + qnt, todas.size());

        if (inicio >= todas.size()) {
            return List.of();
        }

        return todas.subList(inicio, fim);
    }
}
