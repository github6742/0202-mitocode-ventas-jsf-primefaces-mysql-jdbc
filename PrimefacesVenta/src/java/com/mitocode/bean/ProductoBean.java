/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.bean;

import com.mitocode.dao.ProductoDao;
import com.mitocode.model.Producto;
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
public class ProductoBean {

    private Producto producto;
    private ProductoDao productoDao;
    private List<Producto> lstProductos;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public Producto getProducto() {
        if (producto == null) {
            producto = new Producto();
        }
        return producto;
    }

    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        this.producto.setCodigo(0);
        this.producto.setNombre("");
        this.producto.setPrecio(0.00);

    }

    private void registrar() throws Exception {
        ProductoDao dao;

        try {
            dao = new ProductoDao();
            dao.registrar(producto);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }

    }

    private void modificar() throws Exception {
        ProductoDao dao;

        try {
            dao = new ProductoDao();
            dao.modificar(producto);
            this.listar("V");

        } catch (Exception e) {
            throw e;
        }

    }

    public void listar(String valor) throws Exception {
        ProductoDao dao;

        try {
            if (valor.equals("F")) {
                if (isPostBack() == false) {
                    dao = new ProductoDao();
                    lstProductos = dao.listar();
                }
            } else {
                dao = new ProductoDao();
                lstProductos = dao.listar();
            }

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     *
     * @param per
     * @throws Exception
     */
    public void leerID(Producto per) throws Exception {
        ProductoDao dao;
        Producto temp;

        try {
            dao = new ProductoDao();
            temp = dao.leerID(per);

            if (temp != null) {
                this.producto = temp;
                this.accion = "Modificar";
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Producto per) throws Exception {
        ProductoDao dao;

        try {
            dao = new ProductoDao();
            dao.eliminar(per);
            this.listar("V");

        } catch (Exception e) {
            throw e;
        }

    }
}
