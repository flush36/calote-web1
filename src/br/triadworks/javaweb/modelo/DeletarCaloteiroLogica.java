package br.triadworks.javaweb.modelo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.triadworks.javaweb.dao.CaloteiroDAO;


public class DeletarCaloteiroLogica implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		String id = request.getParameter("id");
		CaloteiroDAO dao = new CaloteiroDAO(connection);
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setId(new Long(id));
		dao.deleta(caloteiro);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/sistema?logica=ListarCaloteiro");
		rd.forward(request, response);
	}
}
