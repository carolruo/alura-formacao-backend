package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
//		sessao.removeAttribute("usuarioLogado");
//		//Quando utilizamos o removeAtribute, nosso objeto HttpSession ainda 
//		continua em mem�ria (o cookie tamb�m continua l�). J� quando usamos o invalidate, 
//		ele remove o objeto HttpSession, todos os objetos associados e tamb�m remove o cookie!
		sessao.invalidate();
		
		return "redirect:entrada?acao=LoginForm";
	}

}
