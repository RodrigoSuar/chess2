package com.chess.engine.board;


import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;
public abstract class Tile {

    protected final int tileCoordinate;

    private static final Map<Integer, EmptyTitle> Empty_Titles_CACHE = CreateAllPossibleEmptyTitles();

    private static Map<Integer, EmptyTitle> CreateAllPossibleEmptyTitles() {

        final Map<Integer, EmptyTitle> emptyTileMap = new HashMap<>();
        for(int i = 0;i<64;i++){
            emptyTileMap.put(i,new EmptyTitle(i));
        }
        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile createTile(final int tileCoordinate, final Piece piece){
        return piece != null ? new OccupiedTile(tileCoordinate,piece) : Empty_Titles_CACHE.get(tileCoordinate);
    }


    private Tile(int tileCoordinate){

        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTitle extends Tile{
        private EmptyTitle(final int coordinate){
            super(coordinate);
        }

        @Override
        public boolean isTileOccupied(){
            return false;
        }
        @Override
        public Piece getPiece(){
            return null;
        }
    }

    public static final class OccupiedTile extends Tile {
        private final Piece pieceOnTile;

        private OccupiedTile(int tileCoordinate,Piece pieceOnTile){
            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece(){
            return this.pieceOnTile;
        }


    }

}
