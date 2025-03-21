package br.unitins.tp1.repository;

import br.unitins.tp1.model.Gabinete;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GabineteRepository implements PanacheRepository<Gabinete> {
    public Gabinete findByModelo(String modelo) {
        return find("modelo", modelo).firstResult();
    }
}
