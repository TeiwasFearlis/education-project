package ru.education.Socket;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            try (var clientSocket = new Socket("localhost", 4006);
                 var reader = new BufferedReader(new InputStreamReader(System.in));
                 var writerToServer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()), 2);) {
                String word = null;
                do {
                    System.out.println("Вы что-то хотели сказать? Введите это здесь:");
                    word = reader.readLine(); // ждём пока клиент что-нибудь
                    // напишет в консоль
                    writerToServer.write(word + "\n"); // отправляем сообщение на сервер
                    writerToServer.flush();
                } while (!word.equals("exit"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Клиент был закрыт...");
    }
}