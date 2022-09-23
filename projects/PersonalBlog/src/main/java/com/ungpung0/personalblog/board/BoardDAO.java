package com.ungpung0.personalblog.board;

import java.sql.*;

public class BoardDAO {

    DBConnection dbConnection;

    // 게시글 삽입 메소드.
    public void insertBoard(BoardDTO data) {
        try {
            String query = String.format("INSERT INTO board(board_title, board_author, board_password, board_content) VALUES('%s', '%s', '%s', '%s')"
                    , data.getBoardTitle(), data.getBoardWriter(), data.getBoardPassword(), data.getBoardContent());
            dbConnection.startConnection();
            dbConnection.statement.executeUpdate(query);
        }catch (Exception error){
            error.printStackTrace();
        }finally {
            dbConnection.closeConnection();
        }
    }



}
