package br.triadworks.javaweb.modelo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.mysql.jdbc.Connection;

import br.triadworks.javaweb.dao.CaloteiroDAO;

public class ListarCaloteiroLogica implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		CaloteiroDAO dao = new CaloteiroDAO(connection);
		List<Caloteiro> lista = dao.getLista();
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/listaCaloteiros.jsp");
		
		request.setAttribute("lista", lista);
		
		
		rd.forward(request, response);
	}
}
