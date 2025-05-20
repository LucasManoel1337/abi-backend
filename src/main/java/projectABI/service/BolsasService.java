package projectABI.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectABI.dto.BolsasDto;
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

    public List<BolsasDto> listarBolsasFiltro(int qnt, int pagina, String filtro) {
        List<BolsasDto> todas = bolsasRepository.findAll()
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
