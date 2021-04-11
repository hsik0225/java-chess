package chess.controller;

import com.google.gson.Gson;

import chess.service.ChessService;
import spark.Request;
import spark.Response;

public class ChessController {

    private static final Gson GSON = new Gson();

    private final ChessService chessService;

    public ChessController() {
        this.chessService = new ChessService();
    }

    public String getIds(Request req, Response res) {
        String chessId = chessService.findChessIdAsString();
        return GSON.toJson(chessId);
    }

    public String getTurn(Request req, Response res) {
        Long chessId = Long.valueOf(req.params(":chessId"));
        String turn = chessService.findTurnById(chessId);
        return GSON.toJson(turn);
    }

    public String insert(Request req, Response res) {
        Long chessId = chessService.insert();

        res.cookie("chessId", String.valueOf(chessId));
        res.status(201);

        return GSON.toJson(chessId);
    }

    public Response delete(Request req, Response res) {
        Long chessId = Long.valueOf(req.params(":chessId"));
        chessService.delete(chessId);

        res.status(204);
        return res;
    }
}
