<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.MemberDAO" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%
    String u_id = request.getParameter("u_id"); // 넘어오는 데이터를 받음 request

    // DB 연동 구역
    MemberDAO memberDAO = MemberDAO.getInstance();
    boolean isExist = memberDAO.isExistId(u_id);

    // HTML 응답 작성
    response.setContentType("text/html; charset=UTF-8");
    response.setCharacterEncoding("UTF-8");

    if (isExist) {
        out.print("<span style='color: red;'>아이디를 사용할 수 없습니다.</span>");
    } else {
        out.print("<span style='color: blue;'>사용 가능한 아이디입니다.</span>");
    }
%>