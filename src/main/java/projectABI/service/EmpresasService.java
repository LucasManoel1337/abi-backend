package projectABI.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectABI.dto.EmpresasDto;
import projectABI.repository.EmpresasRepository;

import java.util.List;

@Service
public class EmpresasService {

    private EmpresasRepository empresasRepository;

    public EmpresasService(EmpresasRepository empresasRepository) {
        this.empresasRepository = empresasRepository;
    }

    public List<EmpresasDto> listarEmpresas(int qnt, int paginas) {
        Pageable pageable = PageRequest.of(paginas - 1, qnt);
        return empresasRepository.findAll(pageable).getContent();
    }

    public List<EmpresasDto> listarEmpresasFiltro(int qnt, int pagina, String categoria, String estado) {
        List<EmpresasDto> todas = empresasRepository.findAll()
                .stream()
                .filter(emp -> {
                    boolean matchCategoria = true;
                    boolean matchEstado = true;

                    if (categoria != null && !categoria.isBlank()) {
                        if (emp.getCategoria() == null) return false;
                        matchCategoria = emp.getCategoria().trim().equalsIgnoreCase(categoria.trim());
                    }

                    if (estado != null && !estado.isBlank()) {
                        if (emp.getEstado() == null) return false;
                        matchEstado = emp.getEstado().trim().equalsIgnoreCase(estado.trim());
                    }

                    return matchCategoria && matchEstado;
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
