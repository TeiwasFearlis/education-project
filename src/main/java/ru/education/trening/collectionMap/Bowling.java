package ru.education.trening.collectionMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Bowling {
    HashMap<String, Integer> players;

    Bowling() {
        players = new HashMap<String, Integer>();
    }

    public void addPlayer(String name, int p) {
        players.put(name, p);
    }

    //введите код сюда
    public String getWinner() {
        players.put("Dave", 42);
        players.put("Amy", 103);
        players.put("Rob", 64);
        Iterator<String> iterator = players.keySet().iterator();
        int x = 0;
        String winner = null;
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(players.get(next));
            if (players.get(next) > x) {
                x = players.get(next);
                winner = next;
            }
        }
        System.out.println(winner);
        return winner;
    }

    public static void main(String[] args) {
        Bowling game = new Bowling();
//        Scanner sc = new Scanner(System.in);
//
//        for(int i=0;i<3;i++) {
//            String input = sc.nextLine();
//            String[] values = input.split(" ");
//            String name = values[0];
//            int points = Integer.parseInt(values[1]);
//            game.addPlayer(name, points);
//        }
        game.getWinner();
    }
}
