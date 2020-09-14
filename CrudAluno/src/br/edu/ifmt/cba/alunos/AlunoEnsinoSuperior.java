package br.edu.ifmt.cba.alunos;

/**
 *
 * @author Eduardo Gonçalves da Silva
 */
public class AlunoEnsinoSuperior extends Aluno {
    private char nota;

    public AlunoEnsinoSuperior(long matricula) {
        super(matricula);  
    }

    public AlunoEnsinoSuperior(long cpf, String nome, long matricula) {
        super(cpf, nome, matricula);
    }

    public char getNota() {
        return nota;
    }

    public void setNota(char nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "\nAlunoEnsinoSuperior{" + "Nome= " + super.getNome() + ", Matricula= " + super.getMatricula() + ", CPF= " + super.getCpf() + ", Nota= " + this.nota + '}' + "\n";
    }
    
}
