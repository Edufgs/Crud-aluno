package br.edu.ifmt.cba.alunos;
import br.edu.ifmt.cba.util.Teclado;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author Eduardo Gonçalves da Silva
 */
public class Main {

    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();//operador diamante
        menu(alunos); //chama menu e manda a Lista para o resto do programa
    }
    
    public static void menu(List alunos){//Menu prncipal do programa
        System.out.println("================== Menu ==================");
        System.out.println("============ 1 = Cadastrar          ======");
        System.out.println("============ 2 = Excluir            ======");
        System.out.println("============ 3 = Obter              ======");
        System.out.println("============ 4 = Alterar/Pesquisar  ======");
        System.out.println("============ 5 = Adicionar nota     ======");
        System.out.println("============ 6 = Sair               ======");
        System.out.println("==========================================");
        
        try{
            int op = Teclado.leInt("Digite a Opção:");
            int i;
            switch(op){
                case 1:
                    cadastrar(alunos); //cadastra os alunos
                    break;
                
                case 2:
                    i = pesquisa(alunos);
                    System.out.println(alunos.get(i));
                    System.out.println("Deseja remover ?");//confirmar a remoção
                    op = Teclado.leInt("1= Sim OU 2= Não");
                    switch(op){
                        case 1:
                            if(alunos.remove(alunos.get(i)) == true){
                            System.out.println("Removido com sucesso!!!");
                            }else{
                                System.out.println("Erro para remover!!!");
                            }
                            menu(alunos);
                            break;
                        case 2:
                            System.out.println("Remoção cancelada");
                            menu(alunos);
                            break;
                        default:
                            System.out.println("Opção Invalida!!!");
                            menu(alunos);
                    }   
                    break;
                        
                case 3:
                    System.out.println(alunos); //imprime a lista inteira
                    menu(alunos);
                    break;
                
                case 4:
                    alterar(alunos);
                    menu(alunos);
                break;
                
                case 5:
                    i = pesquisa(alunos);
                    adicionarNota(alunos, i);
                    break;
             
                case 6:
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Opção Invalida!!!");
                    menu(alunos);
            } 
        }catch(Exception e){
            System.out.println("Erro na digitação: " + e);
            menu(alunos);
        }   
        
    }
    
    public static void cadastrar(List alunos) throws Exception {//cadastra os alunos
        System.out.println("========== Tipo de Funcionarios ==========");
        System.out.println("==== 1 = Aluno do Ensino Medio        ====");
        System.out.println("==== 2 = Aluno do Ensino Superior     ====");
        System.out.println("==== 3 = Voltar                       ====");
        System.out.println("==========================================");
        int op = Teclado.leInt("Digite a Opção:");
        long cpf;
        Aluno aux = null;
        switch (op){
            case 1:
                //verifica se o cpf ja esta cadastrado
                cpf = Teclado.leLong("Escreva o CPF: ");
                if(verificaCpf(alunos, cpf) != -1){
                    System.out.println("Esse CPF ja esta cadastrado!!!");
                    cadastrar(alunos);
                }
                
                //cadastra
                if(alunos.isEmpty() == true){//cadastra se não tiver alunos e a matricula é 1
                   if(alunos.add(new AlunoEnsinoMedio(cpf, Teclado.leString("Digite o nome: "),1 )) == true){
                        System.out.println(alunos.get(alunos.size() - 1));//imprime o cadastro na tela
                        System.out.println("Cadastrado com sucesso !!!");
                     
                    }else{
                        System.out.println("Erro no cadastro, tente novamente !!!");
                        cadastrar(alunos);
                    
                    } 
                }else{//adidiona a matricula diferente do ultimo da lista
                    aux = (Aluno)alunos.get(alunos.size()-1);
                    if(alunos.add(new AlunoEnsinoMedio(cpf, Teclado.leString("Digite o nome: "), aux.getMatricula()+1 )) == true){
                        System.out.println(alunos.get(alunos.size() - 1));//imprime o cadastro na tela
                        System.out.println("Cadastrado com sucesso !!!");
                     
                    }else{
                        System.out.println("Erro no cadastro, tente novamente !!!");
                        cadastrar(alunos);
                    
                    }
                }

                
                break;
        
            case 2:
                //verifica se o cpf ja esta cadastrado
                cpf = Teclado.leLong("Escreva o CPF: ");
                if(verificaCpf(alunos, cpf) != -1){
                    System.out.println("Esse CPF ja esta cadastrado!!!");
                    cadastrar(alunos);
                }
                
                //cadastra
                 if(alunos.isEmpty() == true){//cadastra se não tiver alunos e a matricula é 1
                   if(alunos.add(new AlunoEnsinoSuperior(cpf, Teclado.leString("Digite o nome: "),1 )) == true){
                        System.out.println(alunos.get(alunos.size() - 1));//imprime o cadastro na tela
                        System.out.println("Cadastrado com sucesso !!!");
                     
                    }else{
                        System.out.println("Erro no cadastro, tente novamente !!!");
                        cadastrar(alunos);
                    
                    } 
                }else{//adidiona a matricula diferente do ultimo da lista
                    aux = (Aluno)alunos.get(alunos.size()-1);
                    if(alunos.add(new AlunoEnsinoSuperior(cpf, Teclado.leString("Digite o nome: "), aux.getMatricula()+1 )) == true){
                        System.out.println(alunos.get(alunos.size() - 1));//imprime o cadastro na tela
                        System.out.println("Cadastrado com sucesso !!!");
                     
                    }else{
                        System.out.println("Erro no cadastro, tente novamente !!!");
                        cadastrar(alunos);
                    
                    }
                }
                break;
                
            case 3:
                menu(alunos);
                break;
            
            default:
                System.out.println("Opção Invalida !!!");
                cadastrar(alunos);
        }
        Collections.sort(alunos); //ordena por ordem de matricula (maior para menor)
        menu(alunos);
        
    }
    
    public static int pesquisa(List alunos) throws Exception{ //pesquisa na lista
        System.out.println("=========== Pesquisar por: ===========");
        System.out.println("==== 1 = Nome                     ====");
        System.out.println("==== 2 = Matricula                ====");
        System.out.println("==== 3 = CPF                      ====");
        System.out.println("==== 4 = Voltar                   ====");
        System.out.println("======================================");
        int op = Teclado.leInt("Digite a Opção:");
        Aluno aux;
        
        switch(op){
            case 1:
                String nome = Teclado.leString("Digite o nome: ");
                for(int i = 0; i < alunos.size() ; i++){
                    aux = (Aluno)alunos.get(i);
                    if(aux.getNome().equals(nome) == true){
                        return i;
                    }
                }
                System.out.println("Não foi encontrado !!!!");
                pesquisa(alunos);
               
                break;
            case 2:
                long matricula = Teclado.leLong("Digite a matricula: ");
                for(int i = 0; i < alunos.size(); i++){
                    aux = (Aluno)alunos.get(i);
                    if(aux.getMatricula() == matricula){
                        return i;
                    }
                }
                System.out.println("Não foi encontrado !!!!");
                pesquisa(alunos);
                
                break;
            case 3:
                long cpf = Teclado.leLong("Digite o CPF: ");
                int i = verificaCpf(alunos, cpf);
                if(i  != -1){
                    return i;
                }
                System.out.println("Não foi encontrado !!!!");
                pesquisa(alunos);
                break;
            case 4:
                menu(alunos);
                break;
                
            default:
            System.out.println("Opção Invalida!!!");
            pesquisa(alunos);
        }
        return -1;
    }

    public static void alterar(List alunos) throws Exception{
        
        int i = pesquisa(alunos);
        System.out.println(alunos.get(i));
        System.out.println("=========== Alterar o que: ===========");
        System.out.println("==== 1 = Nome                     ====");
        System.out.println("==== 2 = CPF                      ====");
        System.out.println("==== 3 = Nota                     ====");
        System.out.println("==== 4 = Voltar                   ====");
        System.out.println("======================================");
        int op = Teclado.leInt("Digite a Opção:");
        Aluno aux;
        
        switch(op){
            case 1:
                aux = (Aluno)alunos.get(i);//Obrigatorio fazer o cast
                aux.setNome(Teclado.leString("Escreva o novo nome: "));
                System.out.println("Alterado com sucesso !!!");
                System.out.println(aux);
                menu(alunos);
                
                break;
            case 2:
                aux = (Aluno)alunos.get(i);
                aux.setCpf(Teclado.leLong("Escreva o novo CPF: "));
                System.out.println("Alterado com sucesso !!!");
                System.out.println(aux);
                menu(alunos);    
                
                break;
            case 3:
                adicionarNota(alunos,i);
                break;
            case 4:
                menu(alunos);
                break;
                
            default:
            System.out.println("Opção Invalida!!!");
            pesquisa(alunos);
        }
        
    }
    
    public static void adicionarNota(List alunos, int i) throws Exception{
        if(alunos.get(i) instanceof AlunoEnsinoMedio == true){
            AlunoEnsinoMedio alunoMedio = (AlunoEnsinoMedio)alunos.get(i); //cast obrigatorio
            System.out.println(alunos.get(i));//imprime na tela
            System.out.println("=========== Alterar o que: ===========");
            System.out.println("==== 1 = Nota 1                   ====");
            System.out.println("==== 2 = Nota 2                   ====");
            System.out.println("==== 3 = Nota 3                   ====");
            System.out.println("==== 4 = Nota 4                   ====");
            System.out.println("==== 5 = Voltar                   ====");
            System.out.println("======================================");
            int op = Teclado.leInt("Digite a Opção:");
            if(op != 1 && op != 2 && op != 3  && op != 4 && op != 5 ){
                System.out.println("Opção invalida");
                alterar(alunos);
            }
            if(op == 5){
                menu(alunos);
            }
            try{
                alunoMedio.setNota(op-1, Teclado.leFloat("Digite a nota:"));
                System.out.println("Alterado com Sucesso!!!!");
                adicionarNota(alunos, i);
            }catch(Exception e){
                System.out.println("Erro na digitação: Aluno do ensino medio a nota vai de 0 á 10 (" + e + ")");
                alterar(alunos);
            }
               
        }else{
            try{
                AlunoEnsinoSuperior alunoSuperior = (AlunoEnsinoSuperior)alunos.get(i);
                alunoSuperior.setNota(Teclado.leChar("Digite a nota:"));
                System.out.println("Alterado com Sucesso!!!!");
            }catch(Exception e){
                System.out.println("Aluno do ensino superior  nota vai de A á F (" + e + ")");
            }
        }
    }
    
    public static int verificaCpf(List alunos, long cpf) throws Exception{
        for(int i = 0; i < alunos.size(); i++){
            Aluno aluno = (Aluno)alunos.get(i);
            if(aluno.getCpf() ==  cpf){
                return i;
            }
        }
        return -1;
    }
}
