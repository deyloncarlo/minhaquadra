package br.com.minhaquadra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.minhaquadra.enums.TipoAvaliacaoEstabelecimento;

@Entity
public class AvaliacaoEstabelecimento
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoAvaliacaoEstabelecimento tipoAvaliacaoEstabelecimento;

	@OneToOne
	private Agendamento agendamento;

	@Column(nullable = false, precision = 2)
	private Integer notaAvalicao;

	public AvaliacaoEstabelecimento(TipoAvaliacaoEstabelecimento tipoAvaliacaoEstabelecimento, Agendamento agendamento,
			Integer notaAvalicao)
	{
		super();
		this.tipoAvaliacaoEstabelecimento = tipoAvaliacaoEstabelecimento;
		this.agendamento = agendamento;
		this.notaAvalicao = notaAvalicao;
	}

	/**
	 * Construtor
	 */
	@Deprecated
	public AvaliacaoEstabelecimento()
	{

	}

	public Long getOid()
	{
		return this.oid;
	}

	public void setOid(Long oid)
	{
		this.oid = oid;
	}

	public TipoAvaliacaoEstabelecimento getTipoAvaliacaoEstabelecimento()
	{
		return this.tipoAvaliacaoEstabelecimento;
	}

	public void setTipoAvaliacaoEstabelecimento(TipoAvaliacaoEstabelecimento tipoAvaliacaoEstabelecimento)
	{
		this.tipoAvaliacaoEstabelecimento = tipoAvaliacaoEstabelecimento;
	}

	public Agendamento getAgendamento()
	{
		return this.agendamento;
	}

	public void setAgendamento(Agendamento agendamento)
	{
		this.agendamento = agendamento;
	}

	public Integer getNotaAvalicao()
	{
		return this.notaAvalicao;
	}

	public void setNotaAvalicao(Integer notaAvalicao)
	{
		this.notaAvalicao = notaAvalicao;
	}

}
