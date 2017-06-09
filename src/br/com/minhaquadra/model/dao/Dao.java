package br.com.minhaquadra.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import br.com.minhaquadra.model.Domain;
import br.com.minhaquadra.model.dao.util.JPAUtil;

/**
 * Classe pai de todos os DAOs do sistema
 * 
 * @author Deylon
 *
 */
public class Dao implements DaoInterface<Domain, Long>
{

	private static EntityManager em = new JPAUtil().getEntityManager();

	protected static Session getSession()
	{
		Session session = (Session) em.getDelegate();
		return session;
	}

	/**
	 * Método que pega o EntityManager
	 * 
	 * @return EntityManager
	 */
	protected static EntityManager getEntityManager()
	{
		if (em != null)
		{
			return em;
		}
		em = new JPAUtil().getEntityManager();
		return em;
	}

	private EntityTransaction getCurrentEntityTransaction()
	{
		return getEntityManager().getTransaction();
	}

	private void openCurrentTransaction()
	{
		getCurrentEntityTransaction().begin();
	}

	private void commitCurrentTransaction()
	{
		getCurrentEntityTransaction().commit();
	}

	private void rollbackCurrentTransaction()
	{
		getCurrentEntityTransaction().rollback();
	}

	/**
	 * Obtém objeto do banco pelo oid
	 * 
	 * @param p_oid Oid do objeto que será buscado
	 * @param p_class Classe da entidade do objeto
	 * @return Objeto encontrado
	 */
	protected static <T> Object getByOid(Long p_oid)
	{
		return getEntityManager().find(Domain.class, p_oid);
	}

	@Override
	public <T extends Domain> Domain salvar(T p_domain)
	{
		openCurrentTransaction();
		getEntityManager().persist(p_domain);
		commitCurrentTransaction();
		return p_domain;
	}

	@Override
	public <T extends Domain> Domain atualizar(T p_domain)
	{
		openCurrentTransaction();
		getEntityManager().merge(p_domain);
		commitCurrentTransaction();
		return p_domain;
	}

	@Override
	public <T extends Domain> Domain obterPeloOid(Long p_oid)
	{
		return (Domain) getEntityManager().find(getDoaminClass(), p_oid);
	}

	@Override
	public void deletar(Domain p_domain)
	{
		openCurrentTransaction();
		getEntityManager().remove(p_domain);
		commitCurrentTransaction();

	}

	protected Class getDoaminClass()
	{
		return Domain.class;
	}

}
