package ar.com.syswebcrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 25)
	private String nameProduct;
	
	@Column(nullable = false, length = 25)
	private String detailProduct;
	
	@Column(nullable = false, length = 25)
	private String madeProduct;
	
	@Column(nullable = false, precision = 2)
	private float priceProduct;
	
	@Column(nullable = false)
	private int cuantityProduct;
	
	public Product() {

	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getDetailProduct() {
		return detailProduct;
	}
	public void setDetailProduct(String detailProduct) {
		this.detailProduct = detailProduct;
	}
	public String getMadeProduct() {
		return madeProduct;
	}
	public void setMadeProduct(String madeProduct) {
		this.madeProduct = madeProduct;
	}
	public float getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}
	public int getCuantityProduct() {
		return cuantityProduct;
	}
	public void setCuantityProduct(int cuantityProduct) {
		this.cuantityProduct = cuantityProduct;
	}
	
}

