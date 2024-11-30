<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.MemberDAO" %>
<%@ page import="dto.MemberDTO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%
    request.setCharacterEncoding("UTF-8");
    String u_id = request.getParameter("u_id");
    String u_pw = request.getParameter("u_pw");

    MemberDAO memberDAO = MemberDAO.getInstance();
    MemberDTO memberDTO = null;
    String responseMessage = "fail"; // 기본값으로 실패 설정

    try {
        memberDTO = memberDAO.login(u_id, u_pw);

        if (memberDTO != null) {
            responseMessage = "success";
        }
    } catch (Exception e) {
        // 예외가 발생했을 때의 메시지를 로그에 기록하고 클라이언트에 표시
        e.printStackTrace(); // 서버 로그에 오류 메시지와 스택 트레이스 기록
        responseMessage = "error: " + e.getMessage(); // 클라이언트에 오류 메시지 전달
    } finally {
        // 클라이언트에 응답 출력
        out.print(responseMessage);
    }
%>