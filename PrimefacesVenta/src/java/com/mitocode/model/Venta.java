/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.model;

import java.sql.Date;

/**
 *
 * @author sgrsm
 */
public class Venta {
    private int codigo;
    private Date fecha;
    private Persona persona;
    private double monto;

    public int getCodigo() {
        return codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public double getMonto() {
        return monto;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
