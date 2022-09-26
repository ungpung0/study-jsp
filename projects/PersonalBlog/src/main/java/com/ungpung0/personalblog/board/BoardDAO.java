package com.ungpung0.personalblog.board;

import java.sql.*;
import java.util.ArrayList;

public class BoardDAO {

    private DBConnection dbConnection;
    private final String QUERY_INSERT = "INSERT INTO board(board_title, board_author, board_password, board_content) VALUES('%s', '%s', '%s', '%s')";
    private final String QUERY_SELECT_ALL = "SELECT * FROM board";
    private final String QUERY_SELECT = "SELECT * FROM board WHERE board_idx='%s'";
    private final String QUERY_DELETE = "DELETE FROM board WHERE board_idx=%d AND board_password='%s'";
    private final String QUERY_MODIFY = "UPDATE board SET board_title='%s', board_content='%s', WHERE board_idx=%d AND board_password='%s'";

    // 게시글 조회 메소드. (전체)
    public ArrayList<BoardDTO> selectList() {
        ArrayList<BoardDTO> boardList = new ArrayList<>();
        try {
            dbConnection.startConnection();
            dbConnection.resultSet = dbConnection.statement.executeQuery(QUERY_SELECT_ALL);
            while (dbConnection.resultSet.next()) {
                BoardDTO board = new BoardDTO();
                board.setBoardId(dbConnection.resultSet.getInt("board_idx"));
                board.setBoardCount(dbConnection.resultSet.getInt("board_count"));
                board.setBoardWriter(dbConnection.resultSet.getString("board_author"));
                board.setBoardTitle(dbConnection.resultSet.getString("board_title"));
                board.setBoardContent(dbConnection.resultSet.getString("board_content"));
                board.setBoardPassword(dbConnection.resultSet.getString("board_password"));
                board.setRegDate(dbConnection.resultSet.getString("reg_date"));
                boardList.add(board);
            }
        }catch (SQLException error) {
            error.printStackTrace();
        }finally {
            dbConnection.closeConnection();
            return boardList;
        }
    }

    // 게시글 조회 메소드. (단일)
    public BoardDTO selectBoard(int boardId) {
        BoardDTO board = new BoardDTO();
        try {
            String query = String.format(QUERY_SELECT, boardId);
            dbConnection.startConnection();
            dbConnection.resultSet = dbConnection.statement.executeQuery(query);
            board.setBoardId(dbConnection.resultSet.getInt("board_idx"));
            board.setBoardCount(dbConnection.resultSet.getInt("board_count"));
            board.setBoardWriter(dbConnection.resultSet.getString("board_author"));
            board.setBoardTitle(dbConnection.resultSet.getString("board_title"));
            board.setBoardContent(dbConnection.resultSet.getString("board_content"));
            board.setBoardPassword(dbConnection.resultSet.getString("board_password"));
            board.setRegDate(dbConnection.resultSet.getString("reg_date"));
        }catch (SQLException error) {
            error.printStackTrace();
        }finally {
            dbConnection.closeConnection();
            return board;
        }
    }

    // 게시글 삽입 메소드.
    public void insertBoard(BoardDTO data) {
        try {
            String query = String.format(QUERY_INSERT, data.getBoardTitle(), data.getBoardWriter(), data.getBoardPassword(), data.getBoardContent());
            dbConnection.startConnection();
            dbConnection.statement.executeUpdate(query);
        }catch (Exception error){
            error.printStackTrace();
        }finally {
            dbConnection.closeConnection();
        }
    }

    // 게시글 삭제 메소드.
    public void deleteBoard(int boardId, String boardPassword) {
        try {
            String query = String.format(QUERY_DELETE, boardId, boardPassword);
            dbConnection.startConnection();
            dbConnection.statement.executeUpdate(query);
        }catch (Exception error) {
            error.printStackTrace();
        }finally {
            dbConnection.closeConnection();
        }
    }

    // 게시글 수정 메소드.
    public void modifyBoard(int boardId, String boardPassword, String boardTitle, String boardContent) {
        try {
            String query = String.format(QUERY_MODIFY, boardTitle, boardContent, boardId, boardPassword);
            dbConnection.startConnection();
            dbConnection.statement.executeUpdate(query);
        }catch (Exception error) {
            error.printStackTrace();
        }finally {
            dbConnection.closeConnection();
        }
    }

}
