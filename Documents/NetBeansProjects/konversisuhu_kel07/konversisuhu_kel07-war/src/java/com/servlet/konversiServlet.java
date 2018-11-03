/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.session.konversisuhu;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dea
 */
public class konversiServlet extends HttpServlet {

    @EJB
    private konversisuhu konversisuhu;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {            
            out.println("<html>");
            out.println("<body");
            out.println("<h1><center>Tugas RSBK Konversi Suhu</center></h1>");
            String suhu = request.getParameter("suhu");
            
            if ((suhu != null) && (suhu.length() > 0)) {
                double d = Double.parseDouble(suhu);
                if (request.getParameter("Celcius Ke Fahrenheit") != null){
                    String cefa = konversisuhu.celcius_fahrenheit(d);
                    out.println("<p> HASIL KONVERSI SUHU: "+cefa+"</p>");
                }  
                if (request.getParameter("Celcius Ke Reamur") != null) {
                    String cere = konversisuhu.celcius_reamure(d);
                    out.println("<p> HASIL KONVERSI SUHU: "+cere+ " .</p>");
                }
                if (request.getParameter("Reamur Ke Celcius") != null) {
                    String rece = konversisuhu.reamure_celcius(d);
                    out.println("<p> HASIL KONVERSI SUHU: " +rece+ " .</p>");
                }
                if (request.getParameter("Reamur Ke Fahrenheit") != null) {
                    String refa = konversisuhu.reamure_fahrenheit(d);
                    out.println("<p> HASIL KONVERSI SUHU: "+refa+ " .</p>");
                }
                if (request.getParameter("Fahrenheit Ke Celcius") != null) {
                    String face = konversisuhu.fahrenheit_celcius(d);
                    out.println("<p> HASIL KONVERSI SUHU: "+face+ " .</p>");
                }                
                if (request.getParameter("Fahrenheit Ke Reamur") != null) {
                    String fare = konversisuhu.fahrenheit_reamure(d); 
                    out.println("<p> HASIL KONVERSI SUHU: "+fare+ " .</p>");
                }
                
            } else {
                out.println("<center>");
                out.println("<p>Masukan Suhu:</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input type=\"text\" name=\"suhu\" size=\"20\"></p>");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Fahrenheit Ke Celcius\" value=\"Fahrenheit Ke Celcius\">"+ "<input type=\"submit\" name=\"Fahrenheit Ke Reamur\" value=\"Fahrenheit Ke Reamur\">");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Celcius Ke Fahrenheit\" value=\"Celcius Ke Fahrenheit\">"+ "<input type=\"submit\" name=\"Celcius Ke Reamur\" value=\"Celcius Ke Reamur\">");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Reamur Ke Fahrenheit\" value=\"Reamur Ke Fahrenheit\">"+ "<input type=\"submit\" name=\"Reamur Ke Celcius\" value=\"Reamur Ke Celcius\">");
                out.println("</center>");
                out.println("</form>");
            }
        
        } finally {
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }               
    }
}
  
