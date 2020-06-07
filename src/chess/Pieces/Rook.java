package chess.Pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);

	}

	@Override

	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		ChessMoves r = new ChessMoves(getBoard(), getColor(), position);

		boolean[][] matr = r.rookMoves();

		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		for (int i = 0; i < getBoard().getRows(); i++) {
			for (int j = 0; j < getBoard().getColumns(); j++) {
				if (matr[i][j]) {
					mat[i][j] = true;
				}
			}

		}

		return mat;

	}

}
