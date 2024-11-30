<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.TeamDAO, dto.TeamDTO" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%
    // Get the team_id from the request
    String teamName = request.getParameter("team_id");

    // If teamName is null or empty, respond with "fail"
    if (teamName == null || teamName.trim().isEmpty()) {
        out.print("fail");
        return;
    }

    // Get the TeamDAO instance
    TeamDAO teamDAO = TeamDAO.getInstance();
    TeamDTO teamDTO = teamDAO.team_view(teamName);

    // If teamDTO is null, respond with "fail"
    if (teamDTO == null) {
        out.print("fail");
    } else {
        // Output success and HTML content for the team information
        out.print("success");
        out.print("<!--");
        out.println("<div id='team-info'>");
        out.println("<table border=1>");
        out.println("    <tr>");
        out.println("        <td rowspan='5'><img src='../img/" + teamDTO.getT_name() + ".svg' width='200' height='auto' /></td>");
        out.println("        <th>팀 이름</th>");
        out.println("        <td>" + teamDTO.getT_name() + "</td>");
        out.println("    </tr>");
        out.println("    <tr>");
        out.println("        <th>창단년도</th>");
        out.println("        <td>" + teamDTO.getT_founded() + "</td>");
        out.println("    </tr>");
        out.println("    <tr>");
        out.println("        <th>연고지</th>");
        out.println("        <td>" + teamDTO.getT_hometown() + "</td>");
        out.println("    </tr>");
        out.println("    <tr>");
        out.println("        <th>경기장</th>");
        out.println("        <td>" + teamDTO.getT_stadium() + "</td>");
        out.println("    </tr>");
        out.println("    <tr>");
        out.println("        <th>K리그1 우승 횟수</th>");
        out.println("        <td>" + teamDTO.getT_win() + "회</td>");
        out.println("    </tr>");
        out.println("</table>");
        out.println("</div>");
        out.print("-->");
    }
%>
