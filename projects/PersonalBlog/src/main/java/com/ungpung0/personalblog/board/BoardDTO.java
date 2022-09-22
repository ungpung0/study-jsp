package com.ungpung0.personalblog.board;

public class BoardDTO {

    /*
        boardId         : 글 번호
        boardCount      : 조회수
        boardWriter     : 작성자
        boardTitle      : 글 제목
        boardContent    : 글 내용
        boardPassword   : 글 비밀번호
     */

    private int boardId;
    private int boardCount;
    private String boardWriter;
    private String boardTitle;
    private String boardContent;
    private String boardPassword;
    private String regDate;

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public int getBoardCount() {
        return boardCount;
    }

    public void setBoardCount(int boardCount) {
        this.boardCount = boardCount;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public String getBoardPassword() {
        return boardPassword;
    }

    public void setBoardPassword(String boardPassword) {
        this.boardPassword = boardPassword;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
