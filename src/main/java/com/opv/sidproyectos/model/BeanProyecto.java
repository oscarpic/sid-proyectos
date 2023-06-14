package com.opv.sidproyectos.model;

public class BeanProyecto {
	private String codigo;
	private String nombre;
	private Perfil perfil;
	private Tipo tipo;
	private Estado estado;
	private BeanPlanificacion planificacion;
	private BeanCostes costes;
	private String observaciones;

	public BeanProyecto() {
	}

	// Getters y Setters

	// Codigo
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	// Nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Perfil
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	// Tipo
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	// Estado
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	// Planificacion
	public BeanPlanificacion getPlanificacion() {
		return planificacion;
	}

	public void setPlanificacion(BeanPlanificacion planificacion) {
		this.planificacion = planificacion;
	}

	// Costes
	public BeanCostes getCostes() {
		return costes;
	}

	public void setCostes(BeanCostes costes) {
		this.costes = costes;
	}

	// Observaciones
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	// Enumerados

	// Perfil
	public enum Perfil {
		JP, SOPORTE, DESARROLLO
	}

	// Tipo
	public enum Tipo {
		EVOLUTIVO, PROYECTO, INCIDENCIA
	}

	// Estado
	public enum Estado {
		SIN_AFECTACION, PARADA, DESCARTADA, CLASIFICADA, ESTIMADA, PLANIFICADA, EN_CURSO, PRUEBAS, CERRADA
	}
}
