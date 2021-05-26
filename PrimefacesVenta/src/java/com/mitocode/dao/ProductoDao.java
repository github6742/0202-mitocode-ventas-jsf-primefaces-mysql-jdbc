/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.dao;

import com.mitocode.model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sgrsm
 */
public class ProductoDao extends DAO{
    
    public void registrar(Producto producto) throws Exception{
        try{
            this.Conectar();
            PreparedStatement  st = this.getCn().prepareStatement("INSERT INTO Producto (nombre, precio) values (?,?)");
            st.setString(1, producto.getNombre());
            st.setDouble(2, producto.getPrecio());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
    public List<Producto> listar() throws Exception{
        
        List<Producto> lista = null;
        ResultSet rs = null;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT codigo, nombre, precio FROM Producto");
            rs = st.executeQuery();
            lista = new ArrayList();
            
            while(rs.next()){
                
                Producto per = new Producto();
                
                per.setCodigo(rs.getInt("codigo"));
                per.setNombre(rs.getString("nombre"));
                per.setPrecio(rs.getDouble("precio"));
                
                lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        
        return  lista;
    }
    
    public Producto leerID(Producto pro) throws Exception{
        Producto prod = null;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement  st = this.getCn().prepareStatement("SELECT codigo, nombre, precio FROM Producto WHERE codigo = ?");
            st.setInt(1,pro.getCodigo());
            rs = st.executeQuery();
            while(rs.next()){
                prod = new Producto();
                prod.setCodigo(rs.getInt("codigo"));
                prod.setNombre(rs.getString("nombre"));
                prod.setPrecio(rs.getDouble("precio"));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        
        return prod;
    }
    
    public void modificar(Producto producto) throws Exception{
        try{
            this.Conectar();
            PreparedStatement  st = this.getCn().prepareStatement("UPDATE Producto SET nombre = ?, precio = ? WHERE codigo = ? ");
            st.setString(1, producto.getNombre());
            st.setDouble(2, producto.getPrecio());
            st.setInt(3, producto.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
    public void eliminar(Producto producto) throws Exception{
        try{
            this.Conectar();
            PreparedStatement  st = this.getCn().prepareStatement("DELETE FROM Producto WHERE codigo = ? ");
            st.setInt(1, producto.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
