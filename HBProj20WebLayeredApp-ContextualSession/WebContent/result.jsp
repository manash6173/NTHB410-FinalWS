<%@page import="com.nt.dto.ProjectDTO" %>
<h1 style="color:red;text-align:center">Result Page-ProjectInfo </h1>

<%
     ProjectDTO dto=(ProjectDTO)request.getAttribute("pDetails");
    if(dto!=null){
   
%>

  <table border="1" bgcolor="cyan">
    <tr>
     <td><%=dto.getProjId()%></td>
     <td><%=dto.getProjName() %></td>
     <td><%=dto.getTeamSize()%></td>
     <td><%=dto.getDomain()%></td>
     <td><%=dto.getSdp()%></td>
     <td><%=dto.getEdcp()%></td>
    </tr>   
  </table>    
  <%}
    else{
    	out.println("<b> Record not found </b>");
    }
    %>
 <br>
  <a href="find_project.html">home</a>