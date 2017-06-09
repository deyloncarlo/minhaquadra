package br.com.minhaquadra.model.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.minhaquadra.model.Agendamento;
import br.com.minhaquadra.model.Domain;
import br.com.minhaquadra.model.Quadra;

public class QuadraDao extends Dao
{
	private static QuadraDao quadraDao;

	public static QuadraDao getInstance()
	{
		if (quadraDao == null)
		{
			quadraDao = new QuadraDao();
		}
		return quadraDao;
	}

	@Override
	public <Quadra extends Domain> Domain obterPeloOid(Long p_oid)
	{
		return super.obterPeloOid(p_oid);
	}

	@Override
	public <Quadra extends Domain> Domain salvar(Quadra p_domain)
	{
		return super.salvar(p_domain);
	}

	/**
	 * Método que obtém a lista de todas as quadras que possuem pelo menos uma
	 * das modalidade presente na lista passada por parâmetro
	 * 
	 * @param v_lista Lista de modalidades de esporte
	 * @return Quadras encontradas que possuem ao menos uma modalidade da lista
	 * passada por parâmetro
	 */
	public static List<Quadra> obterQuadrasPorModalidades(Collection<Agendamento> v_lista)
	{
		CriteriaBuilder v_criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Quadra> v_criteriaQuery = v_criteriaBuilder.createQuery(Quadra.class);
		Root<Quadra> v_root = v_criteriaQuery.from(Quadra.class);
		// Path<Agendamento> v_path =
		// v_root.<Agendamento>get("listaAgendamento");
		//
		// Predicate v_p1 = v_path.in(v_lista);
		v_criteriaQuery.where(v_root.get("listaAgendamento").<Agendamento>in(v_lista));

		TypedQuery<Quadra> v_typedQuery = getEntityManager().createQuery(v_criteriaQuery);
		return v_typedQuery.getResultList();
	}

	/**
	 * Obtém todas as quadras do banco
	 * 
	 * @return Lista de quadras encontradas
	 */
	public static List<Quadra> obterTodas()
	{
		CriteriaBuilder v_criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Quadra> v_teste = v_criteriaBuilder.createQuery(Quadra.class);
		v_teste.from(Quadra.class);

		TypedQuery<Quadra> v_typedQuery = getEntityManager().createQuery(v_teste);
		return v_typedQuery.getResultList();
	}

	@Override
	protected Class getDoaminClass()
	{
		return Quadra.class;
	}

}
