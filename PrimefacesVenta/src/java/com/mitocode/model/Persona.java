/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.model;

/**
 *
 * @author sgrsm
 */
public class Persona {
    private String nombre;
    private String sexo;
    private int codigo;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
       // return "Persona{" + "codigo" + codigo + '}';
       return String.format("%s[codigo=%d]", getClass().getSimpleName(), getCodigo());
    }      

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
}
