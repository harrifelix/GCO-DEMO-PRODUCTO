package com.gco.producto.infraestructura.adapters.entidad;

import  com.gco.producto.infraestructura.entrypoints.enums.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Movimiento")
@NamedQueries({
		@NamedQuery(name = "Movimiento.findById", query = "SELECT movimiento from Movimiento movimiento where movimiento.id = :id"),
		@NamedQuery(name = "Movimiento.findAll", query = "SELECT movimiento from Movimiento movimiento")
})
public class MovimientoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "id")
	private ProductoEntity producto;
	@Column(nullable = false)
	private TipoMovimientoEnum tipo ;
	@Column(nullable = false)
	private int   cantidad;
	@Column(nullable = false)
	private Date  fecha;
	@Column(nullable = false)
	private String descripcion;

	public MovimientoEntity(){

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public TipoMovimientoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimientoEnum tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
