package clienteweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.fabricadeprogramador.model.Cliente;
import br.com.fabricadeprogramador.service.ClienteService;

@WebServlet(urlPatterns = { "/cliente", "/clientesServlet", "/clienteController" })
public class ClienteServlete extends HttpServlet {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ClienteService cli;
	public ClienteServlete() {
		System.out.println("Construindo Servlet");
	}
	
	@Override
	public void init() throws ServletException {
		cli= new ClienteService();
		System.out.println("Inicializando Servlet");
		super.init();
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Chamando o service....");
		super.service(req, res);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		/*Para realializar teste com o outro modo JSTL do JSP
		UsandoJstl.jsp alterar o dispacther para:
		RequestDispatcher dispatcher = req.getRequestDispatcher("UsandoJstl.jsp");*/
		req.setAttribute("lista", cli.getLista());
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		Cliente cliente = new Cliente();
		cliente.setEmail(email);
		cli.cadastrarCliente(cliente);
		//resp.sendRedirect("cliente");//so para recarregar a tela pra eviar mensagem já não serve
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");//para recarregar a tela pra eviar mensagem junto daqui até a linha 63
		req.setAttribute("msg","Cadstro Realizado com Sucesso");
		req.setAttribute("lista", cli.getLista());
		dispatcher.forward(req, resp);
		
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	@Override
	public void destroy() {
	System.out.println("Destruindo o Servlet");
		super.destroy();
	}
}
