package br.unitins.tp1.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.tp1.dto.GabineteRequestDTO;
import br.unitins.tp1.dto.GabineteResponseDTO;
import br.unitins.tp1.model.Gabinete;
import br.unitins.tp1.repository.GabineteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GabineteService {
    @Inject
    GabineteRepository repository;

    public GabineteResponseDTO create(GabineteRequestDTO dto) {
        Gabinete gabinete = new Gabinete();
        gabinete.setModelo(dto.modelo());
        gabinete.setMarca(dto.marca());
        gabinete.setTipo(dto.tipo());
        repository.persist(gabinete);
        return new GabineteResponseDTO(gabinete.getId(), gabinete.getModelo(), gabinete.getMarca(), gabinete.getTipo());
    }

    public List<GabineteResponseDTO> findAll() {
        return repository.listAll().stream()
                .map(g -> new GabineteResponseDTO(g.getId(), g.getModelo(), g.getMarca(), g.getTipo()))
                .collect(Collectors.toList());
    }

    public GabineteResponseDTO findById(Long id) {
        Gabinete gabinete = repository.findById(id);
        return new GabineteResponseDTO(gabinete.getId(), gabinete.getModelo(), gabinete.getMarca(), gabinete.getTipo());
    }

    public GabineteResponseDTO findByModelo(String modelo) {
        Gabinete gabinete = repository.findByModelo(modelo);
        return new GabineteResponseDTO(gabinete.getId(), gabinete.getModelo(), gabinete.getMarca(), gabinete.getTipo());
    }

    public GabineteResponseDTO update(Long id, GabineteRequestDTO dto) {
        Gabinete gabinete = repository.findById(id);
        if (gabinete != null) {
            gabinete.setModelo(dto.modelo());
            gabinete.setMarca(dto.marca());
            gabinete.setTipo(dto.tipo());
        }
        return new GabineteResponseDTO(gabinete.getId(), gabinete.getModelo(), gabinete.getMarca(), gabinete.getTipo());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
