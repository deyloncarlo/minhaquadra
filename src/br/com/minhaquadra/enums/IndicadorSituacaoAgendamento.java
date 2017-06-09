package br.com.minhaquadra.enums;

/**
 * Responsável por indicar qual a situação(status) do agendamento
 * 
 * @author Deylon
 *
 */
public enum IndicadorSituacaoAgendamento
{

	LIBERADO("Liberado para agendar"), AGENDADO("Já foi agendado por algum usuário"), FINALIZADO(
			"Tempo de agendamento concluído"), CANCELADO("Agendamento cancelado");

	private String descricao;

	private IndicadorSituacaoAgendamento(String p_descricao)
	{
		setDescricao(p_descricao);
	}

	public String getDescricao()
	{
		return this.descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

}
