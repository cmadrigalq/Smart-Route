/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Servicios.ServicioBus;
import Servicios.ServicioEmpresa;
import Servicios.ServicioHorario;
import Servicios.ServicioParada;
import Servicios.ServicioPuntos;
import Servicios.ServicioRuta;
import Utilitarios.Json;
import entidades.Punto;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jdani
 */
@WebServlet(name = "SMART", urlPatterns = {"/SMART"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/xml");
            String accion = request.getParameter("action");
            List<? extends Serializable> arreglo;
            String jsonText = "",aux,aux2;
            Json json = new Json();
            ServicioPuntos sp;
            ServicioHorario sh;
            Long id;
            switch (accion) {
                case "todosLosPuntos":
                    sp = new ServicioPuntos();
                    arreglo = sp.getTodosLosPuntos();
                    jsonText = json.toJson(arreglo);
                    out.write(jsonText);
                    break;
                case "todasLasParadas":
                    ServicioParada spa = new ServicioParada();
                    arreglo = spa.getTodasLasParadas();
                    jsonText = json.toJson(arreglo);
                    out.write(jsonText);
                    break;
                case "todasLasRutas":
                    ServicioRuta sru = new ServicioRuta();
                    arreglo = sru.getTodasLasRutas();
                    jsonText = json.toJson(arreglo);
                    out.write(jsonText);
                    break;
                case "todosLosBuses":
                    ServicioBus sbu = new ServicioBus();
                    arreglo = sbu.getTodosLosBuses();
                    jsonText = json.toJson(arreglo);
                    out.write(jsonText);
                    break;
                case "todasLasEmpresas":
                    ServicioEmpresa sem = new ServicioEmpresa();
                    arreglo = sem.getTodasLasEmpresas();
                    jsonText = json.toJson(arreglo);
                    out.write(jsonText);
                    break;
                case "todosLosHorarios":
                    ServicioHorario sho = new ServicioHorario();
                    arreglo = sho.getTodosLosHorarios();
                    jsonText = json.toJson(arreglo);
                    out.write(jsonText);
                    break;
                case "buscarPunto":
                    sp = new ServicioPuntos();
                    aux = request.getParameter("arg0").replaceAll("\"","");
                    id = Long.valueOf(aux);
                    Punto pt = sp.getPuntoById(id);
                    jsonText = json.toJson(pt);
                    out.write(jsonText);
                    break;
                case "buscarPorRuta":
                    aux = request.getParameter("arg0").replaceAll("\"","");
                    aux2 = request.getParameter("arg1").replaceAll("\"","");
                    id = Long.valueOf(aux);
                    sh = new ServicioHorario();
                    arreglo = sh.getByBusYRuta(id, aux2);
                    jsonText = json.toJson(arreglo);
                    out.write(jsonText);
                    break;
            }
        } catch (Exception ex) {
            System.err.println(ex);
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
