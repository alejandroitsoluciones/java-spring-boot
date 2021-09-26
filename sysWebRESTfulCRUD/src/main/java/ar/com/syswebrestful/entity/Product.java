package ar.com.syswebrestful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 45)
	private String nombreProducto;
	
	@Column(nullable = false, length = 65)
	private String descripcionProducto;
	
	@Column(nullable = false, precision = 2)
	private float precioProducto;
	
	@Column(nullable = false)
	private int cantidadProducto;

	public Product() {

	}

	public Product(int id, String nombreProducto, String descripcionProducto, float precioProducto,
			int cantidadProducto) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.precioProducto = precioProducto;
		this.cantidadProducto = cantidadProducto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public float getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(float precioProducto) {
		this.precioProducto = precioProducto;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	
	
	
}
