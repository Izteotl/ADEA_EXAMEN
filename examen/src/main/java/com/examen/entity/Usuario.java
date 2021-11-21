package com.examen.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {
	
	@Id
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "PASSWORD") 
	private String password;
	
	@Column(name = "NOMBRE") 
    private String nombre;
	
	@Column(name = "CLIENTE")
	private float cliente;
			 
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FECHAALTA")
	private Date fechaAlta;
	
	@Column(name = "FECHABAJA")
	private Date fechaBaja;
	
	@Column(name = "STATUS")
	private char status;
	
	@Column(name = "INTENTOS") 
	private Double intentos;
	
	@Column(name = "FECHAREVOCADO")
	private Date fechaRevocado;
	
	@Column(name = "FECHA_VIGENCIA")
	private Date fechaVigente;
	
	@Column(name = "NO_ACCESO")
	private Integer noAcceso;
	
	@Column(name = "APELLIDO_PATERNO")
	private String apellidoPaterno;
	
	@Column(name = "APELLIDO_MATERNO")
	private String apellidoMaterno;
	
	@Column(name = "AREA")
	private Double area;
	
	@Column(name = "FECHAMODIFICACION")
	private Date fechaModificacion;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCliente() {
		return cliente;
	}

	public void setCliente(float cliente) {
		this.cliente = cliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Double getIntentos() {
		return intentos;
	}

	public void setIntentos(Double intentos) {
		this.intentos = intentos;
	}

	public Date getFechaRevocado() {
		return fechaRevocado;
	}

	public void setFechaRevocado(Date fechaRevocado) {
		this.fechaRevocado = fechaRevocado;
	}

	public Date getFechaVigente() {
		return fechaVigente;
	}

	public void setFechaVigente(Date fechaVigente) {
		this.fechaVigente = fechaVigente;
	}

	public Integer getNoAcceso() {
		return noAcceso;
	}

	public void setNoAcceso(Integer noAcceso) {
		this.noAcceso = noAcceso;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	

}
