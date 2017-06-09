package test.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.minhaquadra.enums.IndicadorSituacaoAgendamento;
import br.com.minhaquadra.model.Agendamento;
import br.com.minhaquadra.model.Estabelecimento;
import br.com.minhaquadra.model.Quadra;
import br.com.minhaquadra.model.Usuario;
import br.com.minhaquadra.model.dao.AgendamentoDao;
import br.com.minhaquadra.model.dao.QuadraDao;
import br.com.minhaquadra.model.dao.UsuarioDao;

/**
 * Classe criada para povoar o banco de dados
 * 
 * @author Deylon
 *
 */
public class PovoarBanco
{

	public static void main(String[] args)
	{
		// provarTabelaEstabelecimento();
		// povoarTabelaQuadra();
		// povoarTabelaUsuario();
		povoarTabelaAgendamento();
		// adicioarQuadraEmUmEstabelecimento();
	}

	/**
	 * Método que povoa a tabela Quadra do banco de dados;
	 */
	private static void povoarTabelaQuadra()
	{
		// Quadra v_quadra = new Quadra("Quadra 1", null, null, null, (float)
		// 200);
		// v_quadra.setEstabelecimento(EstabelecimentoDao.obterPeloOid(1L));
		// QuadraDao.salvar(v_quadra);
		//
		// Quadra v_quadra2 = new Quadra("Quadra 2", null, null, null, (float)
		// 150);
		// v_quadra2.getListaModalidade().add(TipoModalidadeEsporte.BASQUETE);
		// v_quadra2.getListaModalidade().add(TipoModalidadeEsporte.FUTEBOL);
		// QuadraDao.salvar(v_quadra2);
	}

	/**
	 * Método que povoar a tabela Horário do banco
	 */

	private static void povoarTabelaAgendamento()
	{
		Quadra v_quadra = new Quadra();
		v_quadra.setOid(1L);

		Usuario v_usuarioEncontrador = (Usuario) UsuarioDao.getInstance().obterPeloOid(1L);

		Agendamento v_agendamento = new Agendamento((float) 150, LocalDateTime.now(), LocalDateTime.now(),
				LocalDateTime.now(), v_quadra, null, IndicadorSituacaoAgendamento.LIBERADO);

		v_agendamento.setUsuario(v_usuarioEncontrador);
		AgendamentoDao.getInstance().salvar(v_agendamento);

	}

	/**
	 * Método que busca quadra do banco
	 */
	private static void obtendoQuadra()
	{
		Quadra v_quadra = (Quadra) QuadraDao.getInstance().obterPeloOid(1L);

		for (Agendamento v_agendamento : v_quadra.getListaAgendamento())
		{
			System.out.println("Horário:" + v_agendamento.getDataHoraInicio() + "-" + v_agendamento.getDataHoraFim());
		}
	}

	/**
	 * Método para povoar tabela de Usuário do banco
	 */
	private static void povoarTabelaUsuario()
	{

		LocalDate v_localDate = LocalDate.parse("1991-06-28");
		Usuario v_usuario = new Usuario("Douglas Carlo Fidelis Couto", v_localDate, LocalDateTime.now(), "douglascarlo",
				"123456", "douglascarlo@gmail.com");
		UsuarioDao.getInstance().salvar(v_usuario);

	}

	/**
	 * Método que busca um usuário do banco de dados
	 */
	private static void obtendoUsuario()
	{
		Usuario v_usuarioEncontrador = null;/* UsuarioDao.obterPeloOid(1L); */

		for (Agendamento v_agendamento : v_usuarioEncontrador.getListaAgendamento())
		{
			System.out.println(v_agendamento.getQuadra().getNome());
			System.out.println(v_agendamento.getDataHoraInicio());
		}
		System.out.println(v_usuarioEncontrador.getEmail());
		System.out.println(v_usuarioEncontrador.getUsuario());
	}

	/**
	 * Método que povoa a table de Estabelecimento
	 */
	private static void provarTabelaEstabelecimento()
	{
		Estabelecimento v_estabelecimento = new Estabelecimento();
		v_estabelecimento.setNome("Esporte Clube");
		v_estabelecimento.setDescricao("Estabelecimento de teste");
		v_estabelecimento.setEmail("esporteclube@gmail.com.br");
		v_estabelecimento.setHoraInicioFuncionamento(LocalDateTime.of(2017, 5, 24, 8, 0));
		v_estabelecimento.setHoraFimFuncionamento(LocalDateTime.of(2017, 5, 24, 17, 0));
		v_estabelecimento.setTelefone("989816362");
		v_estabelecimento.setUsuario("esporteclube");
		v_estabelecimento.setSenha("123456");

		// endereço
		v_estabelecimento.setBairro("Santa Terezinha");
		v_estabelecimento.setCep("31365090");
		v_estabelecimento.setRua("Rua Chapada do Norte");
		v_estabelecimento.setNumero("191");

		// EstabelecimentoDao.salvar(v_estabelecimento);

	}

	private static void adicioarQuadraEmUmEstabelecimento()
	{
		// Estabelecimento v_estabelecimento =
		// EstabelecimentoDao.obterPeloOid(1L);
		// ArrayList<Quadra> v_listaQuadra = new ArrayList<Quadra>();
		// Quadra v_quadra = QuadraDao.obterPeloOid(2L);
		// v_listaQuadra.add(v_quadra);
		// v_estabelecimento.getListaQuradra().addAll(v_listaQuadra);
		// EstabelecimentoDao.salvar(v_estabelecimento);
		// QuadraDao.salvar(v_quadra);
	}

}
