package org.game;

public class TicTacToe {

    private final GameBoard gameBoard;
    private GameState twoPlayerStateMachine;

    public TicTacToe() {
        this(3, TwoPlayerStateMachine.PLAYER1);
    }

    public TicTacToe(int gameBoardSize, GameState gameStateMachine) {
        gameBoard = new GameBoard(gameBoardSize);
        twoPlayerStateMachine = gameStateMachine;
    }

    public void playerMove(int x, int y) {
        if (validateInput(x, y)) twoPlayerStateMachine = twoPlayerStateMachine.playerMove(x, y, gameBoard);
    }

    public String getWinner() {
        return gameBoard.winner;
    }

    protected boolean validateInput(int x, int y) {
        boolean flag = true;
        if (x > gameBoard.board.length || y > gameBoard.board.length) {
            System.out.println("Invalid Input");
            flag = false;
        } else if (gameBoard.board[x - 1][y - 1] != '\0') {
            System.out.println("Invalid Input");
            flag = false;
        }
        return flag;
    }

    public void printBoard() {
        char[][] board = gameBoard.getBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class GameBoard {
        private final char[][] board;
        private String winner;
        private int emptyCells;

        GameBoard(int size) {
            board = new char[size][size];
            winner = "No Winner";
            emptyCells = size * size;
        }

        public void move(int x, int y, char c) {
            board[x][y] = c;
        }

        public void setWinner(String player) {
            this.winner = player;
        }

        public char[][] getBoard() {
            return board;
        }

        public void decrementEmptyCell() {
            emptyCells--;
        }

        public int getEmptyCells() {
            return emptyCells;
        }
    }
}
