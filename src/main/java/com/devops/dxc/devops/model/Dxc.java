package com.devops.dxc.devops.model;

import java.io.Serializable;

public class Dxc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2988002029080131424L;
	
	private int dxc;
	private int saldo;
	private float impuesto;
	private int sueldo;
	private int ahorro;
	private int uf; // valor de la uf
	private int utm; //valor de la utl


	public Dxc(int ahorro, int sueldo){
		this.ahorro = ahorro;
		this.sueldo = sueldo;
		this.uf = Util.getUf();
		this.utm = Util.getUTM();
	}

	public Dxc() {
		this.uf = Util.getUf();
		this.utm = Util.getUTM();
	}

	public int getDxc() {
		return Util.getDxc(ahorro,uf);
	}
	public void setDxc(int dxc) {
		this.dxc = dxc;
	}
	public int getSaldo() {
		return Util.getSaldoRestante(ahorro,getDxc());
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public double getImpuesto() {
		return Util.getImpuesto(sueldo,utm);
	}
	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public int getAhorro() {
		return ahorro;
	}

	public void setAhorro(int ahorro) {
		this.ahorro = ahorro;
	}
}
