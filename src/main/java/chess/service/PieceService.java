package chess.service;

import java.util.List;

import chess.domain.board.BoardDTO;
import chess.domain.chess.Chess;
import chess.domain.piece.PieceDAO;
import chess.domain.piece.PieceDTO;
import chess.domain.position.MovePositionDTO;

public class PieceService {
    private final PieceDAO pieceDAO;

    public PieceService() {
        this.pieceDAO = new PieceDAO();
    }

    public List<PieceDTO> get(Long chessId) {
        return pieceDAO.findPiecesByChessId(chessId);
    }

    public void insert(Long chessId) {
        Chess chess = Chess.createWithEmptyBoard()
                           .start();
        BoardDTO boardDTO = BoardDTO.from(chess);
        pieceDAO.insert(chessId, boardDTO);
    }

    public void move(Long chessId, MovePositionDTO movePositionDTO) {
        pieceDAO.move(chessId, movePositionDTO);
    }

    public void delete(Long chessId) {
        pieceDAO.delete(chessId);
    }
}
