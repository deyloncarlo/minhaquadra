package br.com.minhaquadra.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Usuários que irão utlizar as quadras disponibilizadas pelos Estabelecimentos
 * 
 * @author Deylon
 *
 */
@Entity
public class Usuario extends Domain
{

	/** Identificador único de cada usuário */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	/** Nome do usuário */
	@Column(nullable = false, length = 100)
	private String nome;

	/** Data de nascimento do usuário */
	@Column(nullable = false)
	private LocalDate dataNascimento;

	/** Data em que o usuário foi cadastrado no sistema */
	@Column(nullable = false)
	private LocalDateTime dataCadastro;

	/**
	 * Nome de usuário que o usuário do sistema irá utlizar para logar no
	 * sistema
	 */
	@Column(nullable = false, length = 100, unique = true)
	private String usuario;

	/** Senha que o usuário irá utilizar para logar no sistema */
	@Column(nullable = false, length = 100)
	private String senha;

	/** E-mail que o usuario irá receber notificações do sistema */
	@Column(nullable = false, unique = true)
	private String email;

	/** Lista de agendamentos realizados pelo usuário */
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Agendamento> listaAgendamento;

	public Usuario(String nome, LocalDate dataNascimento, LocalDateTime dataCadastro, String usuario, String senha,
			String email)
	{
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
	}

	/**
	 * Construtor
	 */
	@Deprecated
	public Usuario()
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

	public LocalDate getDataNascimento()
	{
		return this.dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}

	public LocalDateTime getDataCadastro()
	{
		return this.dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro)
	{
		this.dataCadastro = dataCadastro;
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

	public List<Agendamento> getListaAgendamento()
	{
		return this.listaAgendamento;
	}

	public void setListaAgendamento(List<Agendamento> listaAgendamento)
	{
		this.listaAgendamento = listaAgendamento;
	}

}
