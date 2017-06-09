package br.com.minhaquadra.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.minhaquadra.enums.TipoModalidadeEsporte;

@Entity(name = "Quadra")
public class Quadra extends Domain
{

	/** Identificador único de cada quadra */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	/** Nome que identifica a quadra */
	@Column(nullable = false, unique = true)
	private String nome;

	/** Número máximo de usuário que podem utilizar a quadra ao mesmo tempo */
	@Column
	private Integer numeroMaximoUsuarios;

	/** Largura em metros da quadra */
	@Column(precision = 6, scale = 2)
	private Float laguraQuadra;

	/** Comprimento em metros da quadra */
	@Column(precision = 6, scale = 2)
	private Float comprimentoQuadra;

	/** Custo da quadra */
	@Column(nullable = false)
	private Float precoAluguel;

	@OneToMany(mappedBy = "quadra", fetch = FetchType.LAZY)
	private List<Agendamento> listaAgendamento = new ArrayList<Agendamento>();

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = TipoModalidadeEsporte.class)
	private List<TipoModalidadeEsporte> listaModalidade = new ArrayList<TipoModalidadeEsporte>();

	@ManyToOne(cascade = CascadeType.ALL)
	private Estabelecimento estabelecimento;

	/**
	 * Construtor
	 */
	@Deprecated
	public Quadra()
	{

	}

	public Quadra(String nome, Integer numeroMaximoUsuarios, Float laguraQuadra, Float comprimentoQuadra,
			Float precoAluguel)
	{
		this.nome = nome;
		this.numeroMaximoUsuarios = numeroMaximoUsuarios;
		this.laguraQuadra = laguraQuadra;
		this.comprimentoQuadra = comprimentoQuadra;
		this.precoAluguel = precoAluguel;
	}

	public Long getOid()
	{
		return this.oid;
	}

	public void setOid(Long oid)
	{
		this.oid = oid;
	}

	public String getNome()
	{
		return this.nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Integer getNumeroMaximoUsuarios()
	{
		return this.numeroMaximoUsuarios;
	}

	public void setNumeroMaximoUsuarios(Integer numeroMaximoUsuarios)
	{
		this.numeroMaximoUsuarios = numeroMaximoUsuarios;
	}

	public Float getLaguraQuadra()
	{
		return this.laguraQuadra;
	}

	public void setLaguraQuadra(Float laguraQuadra)
	{
		this.laguraQuadra = laguraQuadra;
	}

	public Float getComprimentoQuadra()
	{
		return this.comprimentoQuadra;
	}

	public void setComprimentoQuadra(Float comprimentoQuadra)
	{
		this.comprimentoQuadra = comprimentoQuadra;
	}

	public Float getPrecoAluguel()
	{
		return this.precoAluguel;
	}

	public void setPrecoAluguel(Float precoAluguel)
	{
		this.precoAluguel = precoAluguel;
	}

	public List<Agendamento> getListaAgendamento()
	{
		return this.listaAgendamento;
	}

	public void setListaAgendamento(List<Agendamento> listaAgendamento)
	{
		this.listaAgendamento = listaAgendamento;
	}

	public List<TipoModalidadeEsporte> getListaModalidade()
	{
		return this.listaModalidade;
	}

	public void setListaModalidade(List<TipoModalidadeEsporte> listaModalidade)
	{
		this.listaModalidade = listaModalidade;
	}

	public Estabelecimento getEstabelecimento()
	{
		return this.estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento)
	{
		this.estabelecimento = estabelecimento;
	}
}
