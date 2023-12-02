package entities;

import java.util.Scanner;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Deposito[] depositos = new Deposito[0];
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("O que deseja fazer?:\n1 - Criar um novo depósito\n2 - Adquirir novo aparelho\n3 - Transferir aparelho\n4 - Listar depósitos\n5 - Remover Aparelho de Depósito \n6 - Limpar Depósito\n7 - Sair");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    Deposito deposito = new Deposito(null);
                    depositos = Arrays.copyOf(depositos, depositos.length + 1);
                    depositos[depositos.length - 1] = deposito;
                    System.out.println("Depósito criado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o nome do aparelho:");
                    String nomeAparelho = sc.next();
                    System.out.println("Digite a marca do aparelho:");
                    String marcaAparelho = sc.next();
                    System.out.println("Digite o preço do aparelho:");
                    double precoAparelho = sc.nextDouble();
                    System.out.println("Digite a quantidade de aparelhos:");
                    int quantidadeAparelho = sc.nextInt();

                    System.out.println("Qual o tipo do aparelho?\n1 - TV\n2 - Radio\n3 - Fogao");
                    int tipoAparelho = sc.nextInt();
                    Aparelho eletro = null;
                    switch (tipoAparelho) {
                        case 1:
                            System.out.println("Qual o tamanho da TV?");
                            int tamanhoTv = sc.nextInt();
                            eletro = new Tv(nomeAparelho, marcaAparelho, precoAparelho, quantidadeAparelho, tamanhoTv);
                            break;
                        case 2:
                            System.out.println("Qual a potencia do rádio?");
                            int potenciaRadio = sc.nextInt();
                            eletro = new Radio(nomeAparelho, marcaAparelho, precoAparelho, quantidadeAparelho, potenciaRadio);
                            break;
                        case 3:
                            System.out.println("Quantas bocas tem o fogão?");
                            int bocasFogao = sc.nextInt();
                            eletro = new Fogao(nomeAparelho, marcaAparelho, precoAparelho, quantidadeAparelho, bocasFogao);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    System.out.println("Deposítos disponíveis: 0 à "+(depositos.length-1));
                    System.out.println("Em qual depósito você deseja adicionar?:");
                    int idDeposito = sc.nextInt();
                    depositos[idDeposito].addAparelho(eletro);
                    System.out.println("Aparelho adicionado com sucesso!");
                    break;
                case 3:
                    System.out.println("Digite o id do depósito de origem:");
                    int idDepositoOrigem = sc.nextInt();
                    System.out.println("Digite o id do aparelho que deseja transferir:");
                    int idAparelhoTransferir = sc.nextInt();
                    System.out.println("Digite o id do depósito de destino:");
                    int idDepositoTransferir = sc.nextInt();
                    // System.out.println("Deposito Origem: "+ idDepositoOrigem +", Deposito destino: "+idDepositoTransferir+", Aparelho: "+idAparelhoTransferir);
                    depositos[idDepositoTransferir].addAparelho(depositos[idDepositoOrigem].getAparelhoById(idAparelhoTransferir));
                    depositos[idDepositoOrigem].removeAparelhoById(idAparelhoTransferir);
                    System.out.println("Aparelho transferido com sucesso!");
                    break;
                case 4:
                    for(int i = 0; i < depositos.length; i++){
                        System.out.println("Depósito " + i + ":");
                        System.out.print(depositos[i]);
                    }
                    break;
                case 5:
                    System.out.println("Digite o id do depósito:");
                    int idDepositoRemover = sc.nextInt();
                    System.out.println("Digite o id do aparelho que deseja remover:");
                    int idAparelhoRemover = sc.nextInt();
                    depositos[idDepositoRemover].removeAparelhoById(idAparelhoRemover);
                    System.out.println("Aparelho removido com sucesso!");
                    break;
                case 6:
                    System.out.println("Digite o id do depósito:");
                    int idDepositoLimpar = sc.nextInt();
                    depositos[idDepositoLimpar].setAparelhos(null);
                    System.out.println("Depósito limpo com sucesso!");
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}
    
