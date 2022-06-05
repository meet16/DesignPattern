package org.game;

public enum TwoPlayerStateMachine implements GameState {
    PLAYER1 {
        @Override
        public GameState playerMove(int x, int y, TicTacToe.GameBoard gameBoard) {
            gameBoard.move(x - 1, y - 1, 'X');
            gameBoard.decrementEmptyCell();
            int t = checkWinner(gameBoard, 'X');
            if (t == 1) {
                gameBoard.setWinner("Player 1");
                return END;
            } else if (t == -1) {
                return END;
            }
            return PLAYER2;
        }
    },
    PLAYER2 {
        @Override
        public GameState playerMove(int x, int y, TicTacToe.GameBoard gameBoard) {
            gameBoard.move(x - 1, y - 1, 'O');
            gameBoard.decrementEmptyCell();
            int t = checkWinner(gameBoard, 'O');
            if (t == 1) {
                gameBoard.setWinner("Player 2");
                return END;
            } else if (t == -1) {
                return END;
            }
            return PLAYER1;
        }
    },
    END {
        @Override
        public GameState playerMove(int x, int y, TicTacToe.GameBoard gameBoard) {
            return END;
        }
    };

    public int checkWinner(TicTacToe.GameBoard gameBoard, char c) {
        int count_d1, count_d2;
        char[][] board = gameBoard.getBoard();
        int[] count_x = new int[board.length];
        int[] count_y = new int[board.length];
        count_d1 = count_d2 = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == c) {
                    count_x[i]++;
                    count_y[j]++;
                    if (i == j) count_d1++;
                    if ((i + j) == board.length - 1) count_d2++;
                }
            }
        }
        for (int i : count_x) {
            if (i == board.length) return 1;
        }
        for (int i : count_y) {
            if (i == board.length) return 1;
        }
        if (count_d1 == board.length) return 1;
        if (count_d2 == board.length) return 1;
        if (gameBoard.getEmptyCells() == 0) {
            gameBoard.setWinner("Draw");
            return -1;
        }
        return 0;
    }
}
