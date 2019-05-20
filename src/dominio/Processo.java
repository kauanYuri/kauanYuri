package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Processo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cliente;
	private String advogado;

	public Processo(Integer id, String cliente, String advogado) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.advogado = advogado;
	}

	public Processo() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getAdvogado() {
		return advogado;
	}

	public void setAdvogado(String advogado) {
		this.advogado = advogado;
	}

	@Override
	public String toString() {
		return "Processo [id=" + id + ", cliente=" + cliente + ", advogado=" + advogado + "]";
	}

}
