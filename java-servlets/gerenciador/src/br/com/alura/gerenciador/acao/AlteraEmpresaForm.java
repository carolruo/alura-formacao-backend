package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;
import br.com.alura.gerenciador.modelo.Empresa;

public class AlteraEmpresaForm implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("mostrando empresa executando");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		BancoDeDados banco = new BancoDeDados();
		
		Empresa empresa = banco.buscaEmpresaPorId(id);
		
		request.setAttribute("empresa", empresa);

        return "forward:formAlterarEmpresa.jsp";
	}

}
