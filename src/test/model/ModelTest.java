package test.model;

import javax.persistence.EntityManager;

import br.com.minhaquadra.model.Quadra;
import br.com.minhaquadra.model.dao.util.JPAUtil;

public class ModelTest
{
	public static void main(String[] args)
	{
		buscandoQuadraPeloOid();
	}

	/**
	 * Método para testar a criação da tabela da entidade Quadra através do
	 * Hibernate. ALém disto, está sendo testado a inserção de uma intancia da
	 * entidade no banco de dados.
	 */
	private static void insercaoDeQuadra()
	{
		Quadra v_quadra = new Quadra("Quadra 2", null, null, null, (float) 145);

		// criando o EntityManager para gerenciar as transações
		EntityManager v_entityManager = new JPAUtil().getEntityManager();

		// iniciando a transação
		v_entityManager.getTransaction().begin();

		// persistindo o objeto quadra no banco
		v_entityManager.persist(v_quadra);

		// commitando a transação
		v_entityManager.getTransaction().commit();

		// fechando os recursos
		v_entityManager.close();
	}

	/**
	 * Método que busca uma Quadra pelo oid e modifica o nome da Quadra
	 * encontrada, pois o objeto buscado está no estado Managed
	 */
	private static void buscandoQuadraPeloOid()
	{
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Quadra v_quadra = em.find(Quadra.class, 1L);
		System.out.print(v_quadra.getNome());
		v_quadra.setNome("Quadra 3");
		em.getTransaction().commit();
		em.close();

	}
}
