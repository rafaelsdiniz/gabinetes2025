package br.unitins.tp1.dto;

import br.unitins.tp1.model.TipoGabinete;

public record GabineteRequestDTO(String modelo, String marca, TipoGabinete tipo) {
    // Não é necessário implementar os métodos modelo(), marca() e tipo()
}
