<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
  <c:when test="${!empty reportData}">
    <table border='1' style="background-color: cyan">
      <tr style="color:blue">
        <th>eno</th><th>ename</th><th>desg</th><th>salary</th>
      </tr>
      <c:forEach var="emp" items="${reportData}">
         <tr style="color:red">
           <td>${emp.eno} </td>
           <td>${emp.ename} </td>
           <td>${emp.desg} </td>
           <td>${emp.salary} </td>
         </tr>
      </c:forEach>
    </table>
     <c:forEach var="i" begin="1" end="${pagesCount}">
        [<a href="controller?pageNo=${i}"> ${i} </a>] &nbsp;&nbsp;
     </c:forEach>
  </c:when>
  <c:otherwise>
     <h1 style='color:red'>Records not found </h1>
  </c:otherwise>
</c:choose>

<br><br>
<a href="index.jsp">home</a>    


    
    
