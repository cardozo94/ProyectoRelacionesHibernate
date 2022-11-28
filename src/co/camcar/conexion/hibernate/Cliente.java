package co.camcar.conexion.hibernate;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="direccion")
	private String direccion;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private DetallesCliente detallesCliente;
	@OneToMany(mappedBy = "cliente_id", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Pedido> pedidos;
	
	public Cliente() {
	}

	public Cliente(String nombre, String apellidos, String direccion) {
		this.nombre = nombre;
		this.apellido = apellidos;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellido;
	}

	public void setApellidos(String apellidos) {
		this.apellido = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public DetallesCliente getDetallesCliente() {
		return detallesCliente;
	}

	public void setDetallesCliente(DetallesCliente detallesCliente) {
		this.detallesCliente = detallesCliente;
	}
	
	public void aggregarPedido(Pedido pedido) {
		if(this.pedidos == null) {
			this.pedidos = new ArrayList<>();
		}
		this.pedidos.add(pedido);
		pedido.setCliente(this);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + "]";
	}
}
