package model.entities;

// Classe "Professor" que herda da classe "Pessoa"
// "final" para indicar que está classe não pode ser herdada
public final class Professor extends Pessoa
{
    public int codigoFuncionario;

    // construtor simples de "Professor"
    Professor(){}

    // construtor com todos os campos de "Professor"
    public Professor(String cpf, String nome, String endereco, String email, String celular, int codigoFuncionario) {
        super(cpf, nome, endereco, email, celular);
        this.codigoFuncionario = codigoFuncionario;
    }

    // getter e setter do atributo "codigoFuncionario"
    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    // to String da classe "Professor"

    @Override
    public String toString() {
        return "Professor{" +
                "codigoFuncionario=" + codigoFuncionario +
                '}';
    }
}
