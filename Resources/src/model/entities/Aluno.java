package model.entities;

import java.io.Serializable;
import java.util.Objects;

// Classe "Aluno" que herda da classe "Pessoa"
// "final" para indicar que está classe não pode ser herdada
public final class Aluno extends Pessoa implements Serializable {
    // declaração do atributo "matricula"
    public int Id_Matricula;
    public Curso curso;

    // construtor simples de "Aluno"
    public Aluno() {
    }

    // construtor com todos os campos de "Aluno"
    public Aluno(String cpf, String nome, String endereco, String email, String celular) {
        super(cpf, nome, endereco, email, celular);
    }

    public Aluno(String cpf, String nome, String endereco, String email, String celular, Curso curso) {
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

    public int getId_Matricula() {
        return Id_Matricula;
    }

    public void setId_Matricula(int id_Matricula) {
        Id_Matricula = id_Matricula;
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
        Aluno aluno = (Aluno) o;
        return Id_Matricula == aluno.Id_Matricula && Objects.equals(curso, aluno.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_Matricula, curso);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}