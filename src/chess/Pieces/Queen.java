package chess.Pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);

	}

	@Override

	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {

		ChessMoves r = new ChessMoves(getBoard(), getColor(), position);

		boolean[][] matr = r.rookMoves();

		ChessMoves b = new ChessMoves(getBoard(), getColor(), position);
		boolean[][] matb = b.bishopMoves();
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		for (int i = 0; i < getBoard().getRows(); i++) {
			for (int j = 0; j < getBoard().getColumns(); j++) {
				if (matr[i][j] || matb[i][j]) {
					mat[i][j] = true;
				}
			}

		}

		// TODO Auto-generated method stub
		return mat;
	}

}
