<%@page import="java.io.PrintWriter"%>
<%@page import="com.emergentes.VisitaServlet"%>
<%@page import="java.util.ArrayList"%>
<%
    if(session.getAttribute("coo")==null){
    ArrayList<VisitaServlet> cook = new ArrayList<VisitaServlet>();
    //session.setAttribute(cook);
    }
 %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
  <%  int contador = 0;
      Cookie[] cukis = request.getCookies();
      if (cukis != null){         
          for(Cookie c : cukis){
              if (c.getName().equals("visitas")) {
                  contador= Integer.parseInt(c.getValue());
              }
          }
      }
      contador ++;
      Cookie c = new Cookie ("visitas",Integer.toString(contador));
      c.setMaxAge(5);
      response.addCookie(c);     %>
       <h2><%   
           if (contador ==1) {
            out.print("BIENBENIDO A NUESTRO SITIO WEB...");} 
          else{
            out.print("GRACIAS POR VISITARNOS NUEVAMENTE...");}
       %></h2>
       <h1>APLICACION WEB</h1>
       <h4>Nombre: Franklin Benz Mamani Mamani</h4>
       <h4>Materia: Tecnologias Emergentes II </h4>       
       <br><!-- comment -->
        <a href="VisitaServlet">Mostrar el contador de visitas cookies</a>
    </body>
</html>
