
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "VisitaServlet", urlPatterns = {"/VisitaServlet"})
public class VisitaServlet extends HttpServlet { 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //cookies
      int contador = 0;
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
      //Establece el tiempo de la cookie en segumdos
      c.setMaxAge(5);
      response.addCookie(c);
      //Generar contenido a partit del Servlet    
      response.setContentType("text/html");   
      //PrintWriter out = response.getWriter();
      //out.print("Visitante No:" + contador);
        if (contador ==1) {
            
            PrintWriter out = response.getWriter();
            out.print("BIENBENIDO A NUESTRO SITIO WEB     cookies en:"+contador);        
        }
        else{
            
            PrintWriter out = response.getWriter();
            out.print("GRACIAS POR VISITAR NUEVAMENTE      cookies en:"+contador);    
        }  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
    }
}



















