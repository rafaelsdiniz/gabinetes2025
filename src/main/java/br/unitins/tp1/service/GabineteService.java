package br.unitins.tp1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.unitins.tp1.dto.GabineteRequestDTO;
import br.unitins.tp1.dto.GabineteResponseDTO;
import br.unitins.tp1.model.Gabinete;
import br.unitins.tp1.model.Marca;
import br.unitins.tp1.repository.GabineteRepository;
import br.unitins.tp1.repository.MarcaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class GabineteService {
    @Inject
    GabineteRepository repository;

    @Inject
    MarcaRepository marcaRepository;

    @Transactional
    public GabineteResponseDTO create(GabineteRequestDTO dto) {
        Marca marca = marcaRepository.findById(dto.getMarcaId());
        if (marca == null) {
            throw new IllegalArgumentException("Marca não encontrada com ID: " + dto.getMarcaId());
        }

        Gabinete gabinete = new Gabinete();
        gabinete.setModelo(dto.getModelo());
        gabinete.setMarca(marca);

        repository.persist(gabinete);
        return new GabineteResponseDTO(gabinete.getModelo(), gabinete.getMarca().getNome());
    }

    public List<GabineteResponseDTO> findAll() {
        return repository.listAll().stream()
                .map(g -> new GabineteResponseDTO(g.getModelo(), g.getMarca().getNome()))
                .collect(Collectors.toList());
    }

    public GabineteResponseDTO findById(Long id) {
        Gabinete gabinete = repository.findById(id);
        if (gabinete == null) {
            throw new IllegalArgumentException("Gabinete não encontrado com ID: " + id);
        }
        return new GabineteResponseDTO(gabinete.getModelo(), gabinete.getMarca().getNome());
    }

    @Transactional
    public GabineteResponseDTO update(Long id, GabineteRequestDTO dto) {
        Gabinete gabinete = repository.findById(id);
        if (gabinete == null) {
            throw new IllegalArgumentException("Gabinete não encontrado com ID: " + id);
        }

        Marca marca = marcaRepository.findById(dto.getMarcaId());
        if (marca == null) {
            throw new IllegalArgumentException("Marca não encontrada com ID: " + dto.getMarcaId());
        }

        gabinete.setModelo(dto.getModelo());
        gabinete.setMarca(marca);

        return new GabineteResponseDTO(gabinete.getModelo(), gabinete.getMarca().getNome());
    }

    public GabineteResponseDTO findByModelo(String modelo) {
        Optional<Gabinete> gabineteOpt = Optional.ofNullable(repository.find("modelo", modelo).firstResult());
        return gabineteOpt.map(g -> new GabineteResponseDTO(g.getModelo(), g.getMarca().getNome()))
                .orElseThrow(() -> new IllegalArgumentException("Gabinete não encontrado para o modelo: " + modelo));
    }

    @Transactional
    public void delete(Long id) {
        Gabinete gabinete = repository.findById(id);
        if (gabinete == null) {
            throw new IllegalArgumentException("Gabinete não encontrado com ID: " + id);
        }
        repository.delete(gabinete);
    }
}
