package br.unitins.tp1.dto;

public class GabineteResponseDTO {
    private String modelo;
    private String marcaNome; // Nome da marca associada

    // Construtor
    public GabineteResponseDTO(String modelo, String marcaNome) {
        this.modelo = modelo;
        this.marcaNome = marcaNome;
    }

    // Getters
    public String getModelo() {
        return modelo;
    }

    public String getMarcaNome() {
        return marcaNome;
    }
}
