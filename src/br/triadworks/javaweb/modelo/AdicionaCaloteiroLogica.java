package br.triadworks.javaweb.modelo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.mysql.jdbc.Connection;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.servlets.CaloteiroServletException;

public class AdicionaCaloteiroLogica implements Logica {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String devendo = request.getParameter("devendo");
		String dataDivida = request.getParameter("dataDivida");
		Calendar dataDividaConvertida = null;
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy")
					.parse(dataDivida);
			dataDividaConvertida = Calendar.getInstance();
			dataDividaConvertida.setTime(data);

		} catch (ParseException e) {

			// out.println("Erro de conversão da data.");
			throw new CaloteiroServletException();
		}

		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setNome(nome);
		caloteiro.setEmail(email);
		caloteiro.setDevendo(new Integer(devendo));
		caloteiro.setDataDivida(dataDividaConvertida);

		CaloteiroDAO dao = new CaloteiroDAO(connection);
		dao.adiciona(caloteiro);

		RequestDispatcher rd = request
				.getRequestDispatcher("/caloteiro-adicionado.jsp");
		rd.forward(request, response);
	}
}
