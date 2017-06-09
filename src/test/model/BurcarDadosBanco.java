package test.model;

import java.util.ArrayList;
import java.util.List;

import br.com.minhaquadra.model.Agendamento;
import br.com.minhaquadra.model.Quadra;
import br.com.minhaquadra.model.dao.AgendamentoDao;
import br.com.minhaquadra.model.dao.QuadraDao;

public class BurcarDadosBanco
{

	public static void main(String[] args)
	{
		buscarQuadrasDoBancoPorModalidade();
	}

	private static void buscarQuadrasDoBancoPorModalidade()
	{
		List<Agendamento> v_lista = new ArrayList<Agendamento>();
		v_lista.add(AgendamentoDao.getInstance().obterPeloOid(1L));

		ArrayList<Quadra> v_quadras = (ArrayList<Quadra>) QuadraDao.obterQuadrasPorModalidades(v_lista);

		for (Quadra v_quadra : v_quadras)
		{
			System.out.println(v_quadra.getNome());
		}
	}
}
