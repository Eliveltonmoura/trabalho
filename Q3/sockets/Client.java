package sockets;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 7896);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeUTF("1"); // Criar novo depósito
            //out.writeUTF("1"); // Criar novo depósito
            //out.writeUTF("2;aparelho1;philco;500;12;1;32;0"); // Adicionar novo aparelho "2;<nome>;<marca>;<preço>;<quantidade>;<tipo[1..3]>;<tamanho/potencia/bocas>;<idDeposito>"
            //out.writeUTF("2;aparelho2;multilaser;90;10;2;500;0");
            //out.writeUTF("2;aparelho3;amd;1200;30;1;49;1");
            //out.writeUTF("3;0;1;1"); // Transferir Aparelho "3;<idDepositoOrigem>;<idAparelho>;<idDepositoDestino>"
            //out.writeUTF("4"); // Listar depósitos "4" 
            //out.writeUTF("5;0;2"); // Remover aparelho do depósito "5;<idDeposito>;<idAparelho>"
            //out.writeUTF("6;1"); // Limpar depósito "6;<idDeposito>"
            //out.writeUTF("7"); // Fechar servidor "7"
            String data = in.readUTF(); // read response from server
            System.out.println(data);
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        } finally {
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Close:" + e.getMessage());
                }
            System.out.println("Conexão encerrada!");
        }
    }
}
