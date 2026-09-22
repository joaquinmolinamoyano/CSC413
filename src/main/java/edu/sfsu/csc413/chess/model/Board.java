package edu.sfsu.csc413.chess.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Piece[][] squares =
            new Piece[Position.BOARD_SIZE][Position.BOARD_SIZE];

    public Board() {

        //throw new UnsupportedOperationException("Not done lmao");
    }                                     // an empty board

    public Piece pieceAt(Position position) {
        if (squares[position.file()][position.rank()] == null) {
            return null;
        }else{
            return squares[position.file()][position.rank()];
        }
        //throw new UnsupportedOperationException("Not done lmao");
    }            // what is here? null if nothing

    public boolean isEmpty(Position position) {
        return squares[position.file()][position.rank()] == null;
        //throw new UnsupportedOperationException("Not done lmao");
    }          // convenience

    public void place(Position position, Piece piece) {
        squares[position.file()][position.rank()] = piece;

        //throw new UnsupportedOperationException("Not done lmao");
    }  // put this here (null clears)

    public List<Position> positionsOf(Color color) {
        List<Position> positions = new ArrayList<>();

        for (int file = 0; file < squares.length; file++) {
            for (int rank = 0; rank < squares[file].length; rank++) {
                Piece piece = squares[file][rank];

                if (piece != null && piece.color().equals(color)) {
                    positions.add(new Position(file, rank));
                }
            }
        }

        return positions;
        //throw new UnsupportedOperationException("Not done lmao");
    }     // where are all of white's pieces?

    @Override public String toString() {
        StringBuilder text = new StringBuilder();

        for (int rank = Position.BOARD_SIZE - 1; rank >= 0; rank--) {
            int emptySquares = 0;

            for (int file = 0; file < Position.BOARD_SIZE; file++) {
                Piece piece = squares[file][rank];

                if (piece == null) {
                    emptySquares++;
                } else {
                    if (emptySquares > 0) {
                        text.append(emptySquares);
                        emptySquares = 0;
                    }

                    text.append(piece.symbol());
                }
            }

            if (emptySquares > 0) {
                text.append(emptySquares);
            }

            if (rank > 0) {
                text.append('/');
            }
        }

        return text.toString();

        //throw new UnsupportedOperationException("Not done lmao");
    }
}
