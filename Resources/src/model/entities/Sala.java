package model.entities;

import java.util.ArrayList;

public class Sala
{
    // Declarando todos os atributos da classe "Sala"
    public int codigo;
    public String nome;
    public String local;
    public int capacidade;

    public ArrayList<Turma> turmaAnexadaSala;
    public ArrayList<DiaSemana> diasIndisponiveis;


    // Construtor simples da classe
    public Sala(){}

    // Construtor com todos os campos
    public Sala(int codigo, String nome, String local, int capacidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.local = local;
        this.capacidade = capacidade;
    }

    public void adicionarTurmaSala(Sala sala, Turma turma, DiaSemana dia, int diaIndex){
        if (turma.tamanho_da_turma() > sala.capacidade){
            System.out.println("Impossível adicionar turma a sala, a turma excede a capacidade da sala...");
        }

        else if (dia == diasIndisponiveis.get(diaIndex)){
            System.out.println("Impossível adicionar turma a sala no dia previsto, a sala já está sendo utilizada");
        }
        else {
            diasIndisponiveis.set(diaIndex, dia);
            turmaAnexadaSala.add(turma);
        }
    }

    public boolean salaTaDisponivel(Sala sala, ArrayList<Sala> listadeSalas){
        boolean disponivel = true;
        for (Sala salaIn : listadeSalas){
            if (salaIn.codigo == sala.codigo){
                disponivel = false;
                System.out.println("Código de sala indisponível, ja existe uma sala com este código...");
            }
        }
        return disponivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    // to String da classe
    @Override
    public String toString() {
        return "nome: " + nome +
                ", local: " + local +
                ", capacidade: " + capacidade +
                ", código: " + codigo;
    }
}
