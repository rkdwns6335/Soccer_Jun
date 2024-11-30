<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    HttpSession session_name = request.getSession();
    String userName = (String) session_name.getAttribute("u_name");
    boolean isLoggedIn = (userName != null);
%>