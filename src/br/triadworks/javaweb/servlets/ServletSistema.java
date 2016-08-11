package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.modelo.AdicionaCaloteiroLogica;
import br.triadworks.javaweb.modelo.Caloteiro;
import br.triadworks.javaweb.modelo.DeletarCaloteiroLogica;
import br.triadworks.javaweb.modelo.ListarCaloteiroLogica;
import br.triadworks.javaweb.modelo.Logica;

@WebServlet("/sistema")
public class ServletSistema extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("logica");
		
		String nomeClasse = "br.triadworks.javaweb.modelo."+acao+"Logica";
		Class classe;
		try {
			classe = Class.forName(nomeClasse);
			Object obj = classe.newInstance();
			Logica logica = (Logica) obj;
			logica.executa(request, response);
		} catch (ClassNotFoundException e) {
			throw new CaloteiroServletException(e.getMessage());
		} catch (InstantiationException | IllegalAccessException e) {
			throw new CaloteiroServletException(e.getMessage());
		} catch (Exception e) {
			throw new CaloteiroServletException(e.getMessage());
		}
		
		

//		if (acao.equals("AdicionaCaloteiro")) {
//
//			try {
//				new AdicionaCaloteiroLogica().executa(request, response);
//			} catch (Exception e) {
//
//				e.printStackTrace();
//			}
//		}
//
//		if (acao.equals("ListarCaloteiro")) {
//
//			try {
//				new ListarCaloteiroLogica().executa(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if (acao.equals("DeletarCaloteiro")) {
//
//			try {
//				new DeletarCaloteiroLogica().executa(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}
}
