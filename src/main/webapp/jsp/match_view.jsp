<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.BoardDAO" %>
<%@ page import="dto.BoardDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    // 요청 파라미터에서 b_seq를 가져옵니다.
    int b_seq = Integer.parseInt(request.getParameter("b_seq"));

	BoardDAO boardDAO = BoardDAO.getInstance(); //싱글톤
	List<BoardDTO> boardList = boardDAO.view(b_seq); 

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	StringBuilder htmlResponse = new StringBuilder();
	
	if (boardList == null || boardList.isEmpty()) {
        htmlResponse.append("<tr><td colspan='4'>데이터가 없습니다.</td></tr>");
    }else{
    	for (BoardDTO board : boardList) {
    		 htmlResponse.append("<tr>");
             
             // 각 <td>를 링크로 감싸기
             htmlResponse.append("<td><a href='match_view.html?b_seq=")
                         .append(board.getB_seq())
                         .append("'>")
                         .append(board.getB_seq())
                         .append("</a></td>");
             
             htmlResponse.append("<td><a href='match_view.html?b_seq=")
                         .append(board.getB_seq())
                         .append("'>")
                         .append(board.getB_title())
                         .append("</a></td>");
             
             htmlResponse.append("<td><a href='match_view.html?b_seq=")
                         .append(board.getB_seq())
                         .append("'>")
                         .append(board.getB_content())
                         .append("</a></td>");
             
             htmlResponse.append("<td><a href='match_view.html?b_seq=")
                         .append(board.getB_seq())
                         .append("'>")
                         .append(board.getB_name())
                         .append("</a></td>");
             
             htmlResponse.append("<td><a href='match_view.html?b_seq=")
                         .append(board.getB_seq())
                         .append("'>")
                         .append(sdf.format(board.getB_logtime()))
                         .append("</a></td>");
             
             htmlResponse.append("</tr>");
        }
    }
	
%>