package test.model;

import java.util.ArrayList;
import java.util.List;

import br.com.minhaquadra.enums.TipoModalidadeEsporte;
import br.com.minhaquadra.model.Quadra;
import br.com.minhaquadra.model.dao.QuadraDao;

public class BurcarDadosBanco
{

	public static void main(String[] args)
	{
		buscarQuadrasDoBancoPorModalidade();
		// buscarQuadrasComValorAluguelMenorOuIgual();
	}

	private static void buscarQuadrasDoBancoPorModalidade()
	{
		List<TipoModalidadeEsporte> v_lista = new ArrayList<TipoModalidadeEsporte>();
		v_lista.add(TipoModalidadeEsporte.BASQUETE);
		v_lista.add(TipoModalidadeEsporte.FUTEBOL);

		ArrayList<Quadra> v_quadras = (ArrayList<Quadra>) QuadraDao.obterQuadrasPorModalidades(v_lista);

		for (Quadra v_quadra : v_quadras)
		{
			System.out.println(v_quadra.getNome());
		}
	}

	private static void buscarQuadrasComValorAluguelMenorOuIgual()
	{
		ArrayList<Quadra> v_quadras = (ArrayList<Quadra>) QuadraDao.obterQuadrasComPrecoMenorQue((float) 700);
		for (Quadra v_quadra : v_quadras)
		{
			System.out.println(v_quadra.getNome());
		}

		System.out.println("Achando os nomes");

		ArrayList<String> v_nomesQuadras = (ArrayList<String>) QuadraDao
				.obterNomesDeQuadrasComPrecoAluguelMenorQueDeterminadoValor((float) 175);

		for (String v_string : v_nomesQuadras)
		{
			System.out.println(v_string);
		}

	}
}
