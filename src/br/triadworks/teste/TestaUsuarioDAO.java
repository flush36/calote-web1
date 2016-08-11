package br.triadworks.teste;

import java.sql.Connection;

import br.triadworks.javaweb.dao.ConnectionFactory;
import br.triadworks.javaweb.dao.UsuarioDAO;
import br.triadworks.javaweb.modelo.Usuario;

public class TestaUsuarioDAO {

	public static void main(String[] args) {
		
		Connection conexao = new ConnectionFactory().getConnection();
		UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
		
		Usuario usuarioLogado = usuarioDAO.autentica("handerson", "123");
		if(usuarioLogado != null){
			
			System.out.println("Usuário logado: " +usuarioLogado.getNome());
		}
		
		Usuario usuarioErrado = usuarioDAO.autentica("loginQueNaoExiste", "123");
		if(usuarioErrado == null){
			
			System.out.println("Usuário não existe");
		}
	}
}
