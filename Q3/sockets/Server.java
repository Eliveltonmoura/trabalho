package sockets;

import java.util.Arrays;
import java.net.*;
import java.io.*;

import entities.*;
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7896);
            System.out.println("Conexão estabelecida!");

            Deposito[] depositos = new Deposito[0];
            int opcao = 0;

            while (opcao != 7) {
                System.out.println("Aguardando conexão...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexão estabelecida!");
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                String comando = in.readUTF();
                String[] comandos = comando.split(";");
                
                opcao = Integer.parseInt(comandos[0]);
                switch (opcao) {
                    case 1:
                        Deposito deposito = new Deposito(null);
                        depositos = Arrays.copyOf(depositos, depositos.length + 1);
                        depositos[depositos.length - 1] = deposito;
                        System.out.println("Depósito criado com sucesso!");
                        break;
                    case 2:
                        String nomeAparelho = comandos[1];
                        String marcaAparelho = comandos[2];
                        double precoAparelho = Double.parseDouble(comandos[3]);
                        int quantidadeAparelho = Integer.parseInt(comandos[4]);
                        int tipoAparelho = Integer.parseInt(comandos[5]);
                        Aparelho eletro = null;
                        switch (tipoAparelho) {
                            case 1:
                                int tamanhoTv = Integer.parseInt(comandos[6]);
                                eletro = new Tv(nomeAparelho, marcaAparelho, precoAparelho, quantidadeAparelho, tamanhoTv);
                                break;
                            case 2:
                                int potenciaRadio = Integer.parseInt(comandos[6]);
                                eletro = new Radio(nomeAparelho, marcaAparelho, precoAparelho, quantidadeAparelho, potenciaRadio);
                                break;
                            case 3:
                                int bocasFogao = Integer.parseInt(comandos[6]);
                                eletro = new Fogao(nomeAparelho, marcaAparelho, precoAparelho, quantidadeAparelho, bocasFogao);
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        int idDeposito = Integer.parseInt(comandos[7]);
                        depositos[idDeposito].addAparelho(eletro);
                        System.out.println("Aparelho adicionado com sucesso!");
                        break;
                    case 3:
                        int idDepositoOrigem = Integer.parseInt(comandos[1]);
                        int idAparelhoTransferir = Integer.parseInt(comandos[2]);
                        int idDepositoTransferir = Integer.parseInt(comandos[3]);
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
                        int idDepositoRemover = Integer.parseInt(comandos[1]);
                        int idAparelhoRemover = Integer.parseInt(comandos[2]);
                        depositos[idDepositoRemover].removeAparelhoById(idAparelhoRemover);
                        System.out.println("Aparelho removido com sucesso!");
                        break;
                    case 6:
                        int idDepositoLimpar = Integer.parseInt(comandos[1]);
                        depositos[idDepositoLimpar].setAparelhos(null);
                        System.out.println("Depósito limpo com sucesso!");
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
                String saida = "";
                for(int i = 0; i < depositos.length; i++)
                    saida += "Depósito " + i + ":" + "\n" + depositos[i] + "\n";
                out.writeUTF(saida);
            }
        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }
    }
}
    
