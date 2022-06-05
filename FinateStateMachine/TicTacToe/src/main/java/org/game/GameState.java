package org.game;

public interface GameState {
    int checkWinner(TicTacToe.GameBoard gameBoard, char c);
    GameState playerMove(int x, int y, TicTacToe.GameBoard gameBoard);
}
