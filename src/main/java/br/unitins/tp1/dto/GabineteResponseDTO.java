package br.unitins.tp1.dto;

import br.unitins.tp1.model.TipoGabinete;

public record GabineteResponseDTO(Long id, String modelo, String marca, TipoGabinete tipo) {}
