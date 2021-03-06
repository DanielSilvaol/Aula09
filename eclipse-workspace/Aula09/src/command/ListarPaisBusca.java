package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import pacote.Pais;
import service.VendedorService;

public class ListarPaisBusca implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		VendedorService vendedor = new VendedorService();
		ArrayList<Pais> lista = null;
		HttpSession session = request.getSession();
		
		if (chave != null && chave.length() > 0) {
			lista = vendedor.listarPais(chave);
		} else {
			lista = vendedor.listarPais();
		}
		session.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarPais.jsp");
		dispatcher.forward(request, response);
	}

}
