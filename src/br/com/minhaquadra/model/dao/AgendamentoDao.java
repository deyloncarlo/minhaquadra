package br.com.minhaquadra.model.dao;

import br.com.minhaquadra.model.Agendamento;
import br.com.minhaquadra.model.Domain;

public class AgendamentoDao extends Dao
{
	private static AgendamentoDao agendamentoDao;

	public static AgendamentoDao getInstance()
	{
		if (agendamentoDao == null)
		{
			agendamentoDao = new AgendamentoDao();
		}
		return agendamentoDao;
	}

	@Override
	public <Agendamento extends Domain> Agendamento obterPeloOid(Long p_oid)
	{
		return (Agendamento) super.obterPeloOid(p_oid);
	}

	@Override
	public <Agendamento extends Domain> Agendamento salvar(Agendamento p_domain)
	{
		return (Agendamento) super.salvar(p_domain);
	}

	@Override
	protected Class getDoaminClass()
	{
		return Agendamento.class;
	}
}
