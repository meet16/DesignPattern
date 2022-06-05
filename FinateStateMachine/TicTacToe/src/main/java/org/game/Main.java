package org.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        TicTacToe ticTacToe = new TicTacToe();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream ps = new PrintStream(System.out);
        System.out.print("Enter no of times you need to interact with system: ");
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ticTacToe.playerMove(tmp[0], tmp[1]);
            ps.println(ticTacToe.getWinner());
            ticTacToe.printBoard();
            ps.println(ticTacToe.getWinner());
        }
    }
}