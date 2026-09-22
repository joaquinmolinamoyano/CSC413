package edu.sfsu.csc413.chess.model;

public record Position (int file, int rank) {

    public static final int BOARD_SIZE = 8;

    public static boolean isOnBoard(int file, int rank) {
        return file >= 0 && file < BOARD_SIZE && rank >= 0 && rank < BOARD_SIZE;
    }

    public static Position parse(String algebraic) {
        Position value = new Position(Character.toLowerCase(algebraic.charAt(0)) - 'a', algebraic.charAt(1) - '0' - 1);

        //throw new UnsupportedOperationException("M0b: your turn");

        return value;

    }

    public Position {
        if (!isOnBoard(file, rank)) {
            throw new IllegalArgumentException(
                    "Position off board: file=" + file + ", rank=" + rank);
        }
    }

    public Position offsetOrNull(int fileDelta, int rankDelta) {


        int newFile = file + fileDelta;
        int newRank = rank + rankDelta;

        if(!isOnBoard(newFile, newRank)){
            return null;
        }

        return new Position(newFile, newRank);

        //throw new UnsupportedOperationException("M0b: your turn");
    }

    @Override
    public String toString() {
        return "" + (char) ('a' + file) + (char) ('1' + rank);
    }

}