package model.entities;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pessoa
{
    // Declaração de todos os atributos da classe "Pessoa"
    public String cpf;
    public String nome;
    public String endereco;
    public String email;
    public String celular;

    // Construtor simples de "Pessoa"
    Pessoa(){}

    // Construtor com todos os campos de "Pessoa"
    public Pessoa(String cpf, String nome, String endereco, String email, String celular)
    {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.celular = celular;
    }
    // Getters e Setters de "Pessoa"
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    // to String de "Pessoa"
    @Override
    public String toString() {
        return "Pessoa{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}
