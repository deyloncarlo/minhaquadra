package br.com.minhaquadra.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FiltrarQuadra
 */
@WebServlet("/filtrarQuadra")
public class FiltrarQuadra extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FiltrarQuadra()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest p_request, HttpServletResponse p_response)
			throws ServletException, IOException
	{
		String v_nomeEstabelecimento = p_request.getParameter("nomeEstabelecimento");
		String v_precoAluguel = p_request.getParameter("precoAluguel");
		String v_dataDiaDisponivel = p_request.getParameter("diaDisponivel");
		String v_horarioDisponivel = p_request.getParameter("horarioDisponivel");
		String v_tempoAluguel = p_request.getParameter("tempoAluguel");

		System.out.println(v_nomeEstabelecimento);
		System.out.println(v_precoAluguel);
		System.out.println(v_dataDiaDisponivel);
		System.out.println(v_horarioDisponivel);
		System.out.println(v_tempoAluguel);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
