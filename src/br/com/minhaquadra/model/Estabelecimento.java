package br.com.minhaquadra.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estabelecimento
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	@Column(nullable = false, length = 100, unique = true)
	private String nome;

	@Column(nullable = false, length = 500)
	private String descricao;

	@Column(nullable = false)
	private LocalDateTime horaInicioFuncionamento;

	@Column(nullable = false)
	private LocalDateTime horaFimFuncionamento;

	@Column(nullable = false, length = 100, unique = true)
	private String usuario;

	@Column(nullable = false, length = 100)
	private String senha;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = true)
	private String telefone;

	@Column(nullable = false)
	private String cep;

	@Column(nullable = false)
	private String rua;

	@Column(nullable = false)
	private String numero;

	@Column(nullable = false)
	private String bairro;

	@OneToMany(mappedBy = "estabelecimento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Quadra> listaQuradra = new ArrayList<Quadra>();

	/**
	 * Construtor
	 */
	@Deprecated
	public Estabelecimento()
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

	public String getNome()
	{
		return this.nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getDescricao()
	{
		return this.descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public LocalDateTime getHoraInicioFuncionamento()
	{
		return this.horaInicioFuncionamento;
	}

	public void setHoraInicioFuncionamento(LocalDateTime horaInicioFuncionamento)
	{
		this.horaInicioFuncionamento = horaInicioFuncionamento;
	}

	public LocalDateTime getHoraFimFuncionamento()
	{
		return this.horaFimFuncionamento;
	}

	public void setHoraFimFuncionamento(LocalDateTime horaFimFuncionamento)
	{
		this.horaFimFuncionamento = horaFimFuncionamento;
	}

	public String getUsuario()
	{
		return this.usuario;
	}

	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	public String getSenha()
	{
		return this.senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getTelefone()
	{
		return this.telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	public String getCep()
	{
		return this.cep;
	}

	public void setCep(String cep)
	{
		this.cep = cep;
	}

	public String getRua()
	{
		return this.rua;
	}

	public void setRua(String rua)
	{
		this.rua = rua;
	}

	public String getNumero()
	{
		return this.numero;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
	}

	public String getBairro()
	{
		return this.bairro;
	}

	public void setBairro(String bairro)
	{
		this.bairro = bairro;
	}

	public List<Quadra> getListaQuradra()
	{
		return this.listaQuradra;
	}

	public void setListaQuradra(List<Quadra> listaQuradra)
	{
		this.listaQuradra = listaQuradra;
	}

}
