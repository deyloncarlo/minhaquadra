package br.com.minhaquadra.model.dao;

import java.io.Serializable;

import br.com.minhaquadra.model.Domain;

public interface DaoInterface<T extends Domain, Long extends Serializable>
{
	public <T extends Domain> Domain salvar(T p_domain);

	public <T extends Domain> Domain atualizar(T p_domain);

	public <T extends Domain> Domain obterPeloOid(Long p_oid);

	public void deletar(T p_domain);

}
