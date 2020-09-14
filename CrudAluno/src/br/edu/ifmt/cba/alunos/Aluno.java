package br.edu.ifmt.cba.alunos;

import java.util.Objects;

/**
 *
 * @author Eduardo Gonçalves da Silva
 */
public class Aluno implements Comparable<Aluno> { //para implementar o metodo "compareTo" e fazer a ordenação por meio da matriula usando "Collections.sort()"
    private long cpf;
    private String nome;
    private final long matricula;
    

    public Aluno(long matricula) {
        this.matricula = matricula;
    }
    
    public Aluno(long cpf, String nome, long matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getMatricula() {
        return matricula;
    }


    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public int compareTo(Aluno outra) {
        if (this.matricula < outra.getMatricula() ) {
            return -1;
        }
        if (this.matricula > outra.getMatricula()) {
            return 1;
        }
            return 0;
    }
   
}
