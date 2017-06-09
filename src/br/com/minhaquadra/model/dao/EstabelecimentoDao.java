package br.com.minhaquadra.model.dao;

import br.com.minhaquadra.model.Estabelecimento;

public class EstabelecimentoDao extends Dao
{

	@Override
	protected Class getDoaminClass()
	{
		return Estabelecimento.class;
	}

}
