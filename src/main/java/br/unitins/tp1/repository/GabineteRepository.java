package br.unitins.tp1.repository;

import java.util.Optional;

import br.unitins.tp1.model.Gabinete;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GabineteRepository implements PanacheRepository<Gabinete> {

    public Optional<Gabinete> findByModelo(String modelo) {
        return Optional.ofNullable(find("modelo", modelo).firstResult());
    }
}
