package model.entities;

// Classe "Aluno" que herda da classe "Pessoa"
// "final" para indicar que está classe não pode ser herdada
public final class Aluno extends Pessoa
{
    // declaração do atributo "matricula"
    public int matricula;

    // construtor simples de "Aluno"
    public Aluno(){}

    // construtor com todos os campos de "Aluno"
    public Aluno(String cpf, String nome, String endereco, String email, String celular, int matricula) {
        super(cpf, nome, endereco, email, celular);
        this.matricula = matricula;
    }

    public boolean existeEssaMatricula(int matricula){
        return false;
    }

    // getter e setter do atributo "matricula"
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    // to String da classe "Aluno"
    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                '}';
    }
}
