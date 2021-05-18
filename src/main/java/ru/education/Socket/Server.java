package ru.education.Socket;

import java.io.*;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(4006)) {
            System.out.println("Сервер запущен!"); // хорошо бы серверу
            var clientSocket = server.accept();
            try (
                 var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 var out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
                while (true) {
                    String word = in.readLine(); // ждём пока клиент что-нибудь нам напишет
                    System.out.println(word);
                    if(word.equals("exit")){
                        clientSocket.close();
                        break;
                    }
                }
            }

        }
        System.out.println("Сервер закрыт!");
    }
}



