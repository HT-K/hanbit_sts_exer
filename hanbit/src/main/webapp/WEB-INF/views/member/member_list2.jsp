<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <table border="1" style="width: 90%; text-align: center">
      <tr>
         <th>scoreSeq</th>
         <th>아이디</th>
         <th>이름</th>
         <th>비밀번호</th>
         <th>주소</th>
         <th>생년월일</th>
         <th>자바</th>
         <th>SQL</th>
         <th>JSP</th>
         <th>스프링</th>
      </tr>
      <c:forEach var="list" items="${list}">
         <tr>
            <td>${list.score_seq}</td>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.password}</td>
            <td>${list.addr}</td>
            <td>${list.birth}</td>
            <td>${list.java}</td>
            <td>${list.sql}</td>
            <td>${list.jsp}</td>
            <td>${list.spring}</td>
         </tr>
      </c:forEach>
   </table>
   </center>