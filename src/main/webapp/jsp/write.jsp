<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.BoardDAO" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%
    request.setCharacterEncoding("UTF-8");

    // 폼 데이터 받기
    String b_title = request.getParameter("b_title");
    String b_name = request.getParameter("b_name");
    String b_content = request.getParameter("b_content");

    BoardDAO boardDAO = BoardDAO.getInstance();
    boolean isSuccess = boardDAO.write(b_title,	b_content, b_name);

    // 결과를 클라이언트에 반환
    if (isSuccess) {
        out.print("success");
    } else {
        out.print("fail");
    }
%>