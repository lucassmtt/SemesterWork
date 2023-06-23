package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Sala implements Serializable {
    // Declarando todos os atributos da classe "Sala"
    public Integer Id_Sala;
    public String nomeSala;
    public String localSala;
    public int capacidadeSala;


    // Construtor simples da classe
    public Sala() {
    }

    // Construtor com todos os campos
    public Sala( String nome, String local, int capacidade) {
        this.nomeSala = nome;
        this.localSala = local;
        this.capacidadeSala = capacidade;
    }

    public Integer getId_Sala() {
        return Id_Sala;
    }

    public void setId_Sala(Integer id_Sala) {
        Id_Sala = id_Sala;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public String getLocalSala() {
        return localSala;
    }

    public void setLocalSala(String localSala) {
        this.localSala = localSala;
    }

    public int getCapacidadeSala() {
        return capacidadeSala;
    }

    public void setCapacidadeSala(int capacidadeSala) {
        this.capacidadeSala = capacidadeSala;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return capacidadeSala == sala.capacidadeSala && Objects.equals(Id_Sala, sala.Id_Sala) && Objects.equals(nomeSala, sala.nomeSala) && Objects.equals(localSala, sala.localSala);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_Sala, nomeSala, localSala, capacidadeSala);
    }

    @Override
    public String toString() {
        return "Sala{" +
                "Id_Sala=" + Id_Sala +
                ", nomeSala='" + nomeSala + '\'' +
                ", localSala='" + localSala + '\'' +
                ", capacidadeSala=" + capacidadeSala +
                '}';
    }
}