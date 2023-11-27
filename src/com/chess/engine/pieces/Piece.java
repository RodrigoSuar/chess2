package com.chess.engine.pieces;


import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

import java.util.List;

public abstract class Piece {
     protected final int piecePosition;
     protected final Alliance pieceAlliance;

     Piece(final int piecePosition, final Alliance pieceAlliance) {
        this.piecePosition = piecePosition;
        this.pieceAlliance = pieceAlliance;
     }

     public abstract List<Move> CalculateLegalMoves(final Board board);

}
