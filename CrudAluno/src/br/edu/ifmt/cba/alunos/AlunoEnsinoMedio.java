package br.edu.ifmt.cba.alunos;

/**
 *
 * @author Eduardo Gonçalves da Silva
 */
public class AlunoEnsinoMedio extends Aluno {
    private float[] notas = new float[4];
    
    public AlunoEnsinoMedio(long matricula) {
        super(matricula);
    }

    public AlunoEnsinoMedio(long cpf, String nome, long matricula) {
        super(cpf, nome, matricula);
    }

    public String getNota() {
        float soma = 0 ;
        String aux = "";
        for(int i = 0; i < 4; i++){
            int j = i + 1;
            aux += " Nota " + (i+1) + "= " + notas[i] + ",";
            soma += notas[i];
        }
        return aux + " Nota Final= " + soma/4;
    }

    public void setNota(int posicao, float nota) {
        this.notas[posicao] = nota;
    }
    
    @Override
    public String toString() {
        return "\nAlunoEnsinoMedio{" + "Nome= " + super.getNome() + ", Matricula= " + super.getMatricula() + ", CPF= " + super.getCpf() + "," + getNota() + '}' + "\n";
    } 
    
}
