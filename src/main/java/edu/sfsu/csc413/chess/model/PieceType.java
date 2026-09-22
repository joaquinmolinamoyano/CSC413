package edu.sfsu.csc413.chess.model;

public enum PieceType {
    PAWN('P'), KNIGHT('N'), BISHOP('B'), ROOK('R'), QUEEN('Q'), KING('K');

    private final char symbol;

    PieceType(char symbol) {
        this.symbol = symbol;
    }

    /** The uppercase letter for this type, as used in FEN and algebraic notation. */
    public char symbol() {
        return symbol;
    }

    /** The inverse: the type for a letter, in either case. Throws if it names no piece. */
    public static PieceType fromSymbol(char letter) {
        if(Character.toUpperCase(letter) == 'P') return PAWN;
        else if(Character.toUpperCase(letter) == 'N') return KNIGHT;
        else if(Character.toUpperCase(letter) == 'B') return BISHOP;
        else if(Character.toUpperCase(letter) == 'R') return ROOK;
        else if(Character.toUpperCase(letter) == 'Q') return QUEEN;
        else if(Character.toUpperCase(letter) == 'K') return KING;
        else throw new IllegalArgumentException("Invalid symbol: " + letter);

        //throw new UnsupportedOperationException("Not done lmao extra");
    }
}
