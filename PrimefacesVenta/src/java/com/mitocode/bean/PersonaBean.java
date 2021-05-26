/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.bean;

import com.mitocode.dao.PersonaDao;
import com.mitocode.model.Persona;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author sgrsm
 */
@ManagedBean
@ViewScoped
public class PersonaBean {

    private Persona persona;
    private PersonaDao personaDao;
    private List<Persona> lstPersonas;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    private boolean isPostBack() {
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }

    public void operar() throws Exception {
        switch (accion) {
            case "Registrar":
                this.registrar();
                this.limpiar();
                break;
            case "Modificar":
                this.modificar();
                this.limpiar();
                break;
        }
    }

    public void limpiar() {
        this.persona.setCodigo(0);
        this.persona.setNombre("");
        this.persona.setSexo("");

    }

    private void registrar() throws Exception {
        PersonaDao dao;

        try {
            dao = new PersonaDao();
            dao.registrar(persona);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }

    }

    private void modificar() throws Exception {
        PersonaDao dao;

        try {
            dao = new PersonaDao();
            dao.modificar(persona);
            this.listar("V");

        } catch (Exception e) {
            throw e;
        }

    }

    public void listar(String valor) throws Exception {
        PersonaDao dao;

        try {
            if (valor.equals("F")) {

                if (isPostBack() == false) {
                    dao = new PersonaDao();
                    lstPersonas = dao.listar();
                }

            } else {
                dao = new PersonaDao();
                lstPersonas = dao.listar();
            }

        } catch (Exception e) {
            throw e;
        }

    }

    public void leerID(Persona per) throws Exception {
        PersonaDao dao;
        Persona temp;

        try {
            dao = new PersonaDao();
            temp = dao.leerID(per);

            if (temp != null) {
                this.persona = temp;
                this.accion = "Modificar";
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Persona per) throws Exception {
        PersonaDao dao;

        try {
            dao = new PersonaDao();
            dao.eliminar(per);
            this.listar("V");

        } catch (Exception e) {
            throw e;
        }

    }
}
