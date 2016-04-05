<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h1>회원 리스트</h1>
<div>
<table>
      <tr>
         <td>scoreSeq</td>
         <td>아이디</td>
         <td>이름</td>
         <td>비밀번호</td>
         <td>주소</td>
         <td>생년월일</td>
         <td>자바</td>
         <td>SQL</td>
         <td>JSP</td>
         <td>스프링</td>
      </tr>
      <c:forEach var="list" items="${list}">
         <tr>
            <td><input type="text" id="scoreSeq" name="scoreSeq" value="${list.score_seq}" readonly="readonly"/></td>
            <td><input type="text" id="id" name="id" value="${list.id}" readonly="readonly"/></td>
            <td><input type="text" id="name" name="name" value="${list.name}" readonly="readonly"/></td>
            <td><input type="password" id="password" name="password" value="${list.password}" readonly="readonly"/></td>
            <td><input type="text" id="addr" name="addr" value="${list.addr}" readonly="readonly"/></td>
            <td><input type="text" id="birth" name="birth" value="${list.birth}" readonly="readonly"/></td>
            <td><input type="text" id="java" name="java" value="${list.java}" readonly="readonly"/></td>
            <td><input type="text" id="sql" name="sql" value="${list.sql}" readonly="readonly"/></td>
            <td><input type="text" id="jsp" name="jsp" value="${list.jsp}" readonly="readonly"/></td>
            <td><input type="text" id="spring" name="spring" value="${list.spring}" readonly="readonly"/></td>
         </tr>
      </c:forEach>
   </table>
</div>
</body>
</html>