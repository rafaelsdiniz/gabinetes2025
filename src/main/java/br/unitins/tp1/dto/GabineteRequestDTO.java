package br.unitins.tp1.dto;


public class GabineteRequestDTO {
    
    private String modelo;


    private Long marcaId;

    // Construtor padrão
    public GabineteRequestDTO() {}

    public GabineteRequestDTO(String modelo, Long marcaId) {
        this.modelo = modelo;
        this.marcaId = marcaId;
    }

    // Getters e Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Long marcaId) {
        this.marcaId = marcaId;
    }
}
