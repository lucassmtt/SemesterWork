package model.entities;

import java.io.Serializable;
import java.util.Objects;

// Classe "Professor" que herda da classe "Pessoa"
// "final" para indicar que está classe não pode ser herdada
public final class Professor extends Pessoa implements Serializable {
    public int Id_Professor;

    public Curso curso;

    // construtor simples de "Professor"
    public Professor() {
    }

    // construtor com todos os campos de "Professor"
    public Professor(String cpf, String nome, String endereco, String email, String celular)
    {
        super(cpf, nome, endereco, email, celular);
    }

    public Professor(String cpf, String nome, String endereco, String email, String celular, Curso curso)
    {
        super(cpf, nome, endereco, email, celular);
        this.curso = curso;
    }

    public Object se_existir_o_curso_retorna_id_ou_null(){
        if (curso == null){
            return null;
        }
        else {
            return curso.getId_Curso();
        }
    }

    // getter e setter do atributo "codigoFuncionario"
    public int getId_Professor() {
        return Id_Professor;
    }

    public void setId_Professor(int id_Professor) {
        this.Id_Professor = id_Professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Id_Professor == professor.Id_Professor && Objects.equals(curso, professor.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_Professor, curso);
    }

    // to String da classe "Professor"
    @Override
    public String toString() {
        return "Professor{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}
