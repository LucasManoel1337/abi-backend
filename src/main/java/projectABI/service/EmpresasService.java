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

    public List<EmpresasDto> listarEmpresasFiltro(int qnt, int pagina, String filtro) {
        List<EmpresasDto> todas = empresasRepository.findAll()
                .stream()
                .filter(emp -> emp.getCategoria().equalsIgnoreCase(filtro))
                .toList();

        int inicio = (pagina - 1) * qnt;
        int fim = Math.min(inicio + qnt, todas.size());

        if (inicio >= todas.size()) {
            return List.of();
        }

        return todas.subList(inicio, fim);
    }
}
