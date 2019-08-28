package com.arcones.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Indica que será una entidad que se almacenara en bbdd
@Table(name = "noticias") // Indica la tabla a la que pertenece esta entidad
public class Noticia {

	@Id // Identificador del registro para la bbdd
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY para mysql, SEQUENCE PARA ORACLE...
	private int id;

	@Column(name = "titulo", length = 250, nullable = false) // Si el atributo tiene el mismo nombre que la columna a la
																// que esta asociada @Column puede omitirse
	private String titulo;

	@Column(name = "fecha")
	private Date fecha;
	private String detalle;
	private String estatus;

	public Noticia() {
		this.fecha = new Date();
		this.estatus = "Activa";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", detalle=" + detalle + ", estatus="
				+ estatus + "]";
	}

}
