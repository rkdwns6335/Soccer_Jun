<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.MemberDAO" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%
	request.setCharacterEncoding("UTF-8");// getParameter로 받은 값을 한글로 변경
    // 폼 데이터 받아오기
    String u_id = request.getParameter("u_id");
    String u_pw = request.getParameter("u_pw");
    String u_name = request.getParameter("u_name");
    String u_addr = request.getParameter("u_addr");
    String u_phone = request.getParameter("u_phone");
    String grade = request.getParameter("grade");

    // DB 구역: MemberDAO를 통해 회원가입 처리
    MemberDAO memberDAO = MemberDAO.getInstance();
    boolean isSuccess = memberDAO.join(u_id, u_pw, u_name, u_addr, u_phone, grade);

    if (isSuccess) {
        response.sendRedirect("../html/join_ok.html"); // 로그인 페이지로 리다이렉트
    } else {
        out.println("<script>alert('회원가입에 실패했습니다. 다시 시도해주세요.');</script>");
        response.sendRedirect("../html/join.html"); // 회원가입 페이지로 리다이렉트
    }
%>
