package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BancoDeDados {
	
	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	//simular uma chave sequencial no banco de dados:
	private static Integer chaveSequencial = 1;
	
	static { //isso vai carregar assim que a classe inicializar, criando de antemao as empresas para fim de teste
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Alura");
		empresa1.setId(chaveSequencial++);
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setId(chaveSequencial++);
		
		listaEmpresas.add(empresa1);
		listaEmpresas.add(empresa2);
		
		Usuario user1 = new Usuario();
		user1.setLogin("nico");
		user1.setSenha("12345");
		Usuario user2 = new Usuario();
		user2.setLogin("ana");
		user2.setSenha("12345");
		
		listaUsuarios.add(user1);
		listaUsuarios.add(user2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		listaEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return BancoDeDados.listaEmpresas;
	}

	//DELETE do banco de dados
	public void removerEmpresa(Integer id) {
		
		Iterator<Empresa> it = listaEmpresas.iterator();
		 while(it.hasNext()) { 
		        Empresa emp = it.next();

		        if(emp.getId() == id ) {
		            it.remove();
		        }
		 }
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		for (Empresa empresa: listaEmpresas) { 
	        if(empresa.getId() == id)  {
	            return empresa;
	        }
	    }
	    return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha) ) {
				return usuario;
			}
		}
		return null;
	}

}
