package chess.domain.piece;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import chess.domain.Board;
import chess.domain.position.Direction;
import chess.domain.position.Position;

public abstract class FixedPiece extends AbstractPiece {
	protected FixedPiece(String name, Color color, List<Direction> movableDirections) {
		super(name, color, movableDirections);
	}

	@Override
	public Set<Position> findMovablePositions(Position currentPosition, Board board) {
		Set<Position> movablePositions = new HashSet<>();
		for (Direction direction : movableDirections) {
			movablePositions.addAll(findNext(currentPosition, direction, board));
		}
		return movablePositions;
	}

	public Set<Position> findNext(Position currentPosition, Direction direction, Board board) {
		Set<Position> movablePositions = new HashSet<>();
		if (!currentPosition.canMoveNext(direction)) {
			return movablePositions;
		}
		currentPosition = currentPosition.next(direction);
		if (!board.isNotEmptyPosition(currentPosition)) {
			movablePositions.add(currentPosition);
		}
		if (board.isNotEmptyPosition(currentPosition) && isEnemy(board.findPieceBy(currentPosition))) {
			movablePositions.add(currentPosition);
		}
		return movablePositions;
	}
}
