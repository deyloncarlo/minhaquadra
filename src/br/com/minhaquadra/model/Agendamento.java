package br.com.minhaquadra.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.minhaquadra.enums.IndicadorSituacaoAgendamento;

@Entity
public class Agendamento extends Domain
{

	/** Identificador único de cada agendamento */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	/** Valor cobrado no agendamento da quadra */
	@Column(nullable = false, precision = 2, scale = 2)
	private Float valorCobrado;

	/** Data e hora em que o agendamento foi criado */
	@Column(nullable = false)
	private LocalDateTime dataHoraCriacao;

	/** Hora em que inicia o tempo de aluguel da quadra */
	@Column(nullable = false)
	private LocalDateTime dataHoraInicio;

	/** Hora que finaliza o tempo de aluguel da quadra */
	@Column(nullable = false)
	private LocalDateTime dataHoraFim;

	/** Quadra que possui este horário */
	@ManyToOne
	private Quadra quadra;

	/** Número de pessoas que irão tulizar a quadra */
	@Column
	private Integer numeroUtilizadores;

	/** Usuário que faz o agendamento */
	@ManyToOne
	private Usuario usuario;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "VARCHAR(100) Default 'LIBERADO'")
	private IndicadorSituacaoAgendamento situacaoAgendamento;

	/** Avaliação que o usuário irá fazer */
	@OneToOne
	private AvaliacaoEstabelecimento avaliacaoEstabelecimento;

	public Agendamento(Float p_valorCobrado, LocalDateTime p_dataHoraCriacao, LocalDateTime p_horaInicio,
			LocalDateTime p_horaFim, Quadra p_quadra, Integer p_numeroUtilizadores,
			IndicadorSituacaoAgendamento p_indicadorSituacaoAgendamento)
	{
		super();
		this.valorCobrado = p_valorCobrado;
		this.dataHoraCriacao = p_dataHoraCriacao;
		this.dataHoraInicio = p_horaInicio;
		this.dataHoraFim = p_horaFim;
		this.quadra = p_quadra;
		this.numeroUtilizadores = p_numeroUtilizadores;
		this.situacaoAgendamento = p_indicadorSituacaoAgendamento;
	}

	/**
	 * Construtor
	 * 
	 */
	@Deprecated
	public Agendamento()
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

	public Float getValorCobrado()
	{
		return this.valorCobrado;
	}

	public void setValorCobrado(Float valorCobrado)
	{
		this.valorCobrado = valorCobrado;
	}

	public LocalDateTime getDataHoraInicio()
	{
		return this.dataHoraInicio;
	}

	public void setDataHoraInicio(LocalDateTime dataHoraInicio)
	{
		this.dataHoraInicio = dataHoraInicio;
	}

	public LocalDateTime getDataHoraFim()
	{
		return this.dataHoraFim;
	}

	public void setDataHoraFim(LocalDateTime dataHoraFim)
	{
		this.dataHoraFim = dataHoraFim;
	}

	public Quadra getQuadra()
	{
		return this.quadra;
	}

	public void setQuadra(Quadra quadra)
	{
		this.quadra = quadra;
	}

	public Integer getNumeroUtilizadores()
	{
		return this.numeroUtilizadores;
	}

	public void setNumeroUtilizadores(Integer numeroUtilizadores)
	{
		this.numeroUtilizadores = numeroUtilizadores;
	}

	public Usuario getUsuario()
	{
		return this.usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	public IndicadorSituacaoAgendamento getSituacaoAgendamento()
	{
		return this.situacaoAgendamento;
	}

	public void setSituacaoAgendamento(IndicadorSituacaoAgendamento situacaoAgendamento)
	{
		this.situacaoAgendamento = situacaoAgendamento;
	}

	public LocalDateTime getDataHoraCriacao()
	{
		return this.dataHoraCriacao;
	}

	public void setDataHoraCriacao(LocalDateTime dataHoraCriacao)
	{
		this.dataHoraCriacao = dataHoraCriacao;
	}

}
