package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/removerEmpresa")
public class RemoverEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		//Aqui agora seria enviar um comando de DELETE pro banco de dados real passando o id.
		//existe apenas uma lista de empresas, trata-se de um elemento est�tico da classe e n�o do objeto, 
		//portanto n�o teremos mais ou menos empresas com a cria��o de um novo banco:
		BancoDeDados banco = new BancoDeDados();
		banco.removerEmpresa(id);
		
		response.sendRedirect("listaEmpresas");
	}
}
