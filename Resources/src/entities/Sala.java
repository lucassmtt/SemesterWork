package entities;

public class Sala
{
    // Declarando todos os atributos da classe "Sala"
    public String nome;
    public String local;
    public int capacidade;

    // Construtor simples da classe
    public Sala(){}

    // Construtor com todos os campos
    public Sala(String nome, String local, int capacidade) {
        this.nome = nome;
        this.local = local;
        this.capacidade = capacidade;
    }

    // Getters e Setters da classe
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
        return "Sala{" +
                "nome='" + nome + '\'' +
                ", local='" + local + '\'' +
                ", capacidade=" + capacidade +
                '}';
    }
}
