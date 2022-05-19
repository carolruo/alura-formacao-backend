package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;
import br.com.alura.gerenciador.modelo.Empresa;

//A classe ListaEmpresas faz parte da camada do Controller. Ela tamb�m � chamada de Action/A��o e representa uma "extens�o" do controlador central.

public class ListaEmpresas implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("listando empresa chamando executa");
		
		
		
		BancoDeDados banco = new BancoDeDados();
        List<Empresa> lista = banco.getEmpresas();

        request.setAttribute("empresas", lista);
        
        
        
        return "forward:listaEmpresas.jsp";
	}
}
