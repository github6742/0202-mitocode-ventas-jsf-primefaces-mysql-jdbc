/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.dao;

import com.mitocode.model.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sgrsm
 */
public class PersonaDao extends DAO{
    
    public void registrar(Persona persona) throws Exception{
        try{
            this.Conectar();
            PreparedStatement  st = this.getCn().prepareStatement("INSERT INTO Persona (nombre, sexo) values (?,?)");
            st.setString(1, persona.getNombre());
            st.setString(2, persona.getSexo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
    public List<Persona> listar() throws Exception{
        
        List<Persona> lista = null;
        ResultSet rs = null;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT codigo, nombre, sexo FROM Persona");
            rs = st.executeQuery();
            lista = new ArrayList();
            
            while(rs.next()){
                
                Persona per = new Persona();
                
                per.setCodigo(rs.getInt("codigo"));
                per.setNombre(rs.getString("nombre"));
                per.setSexo(rs.getString("sexo"));
                
                lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        
        return  lista;
    }
    
    public Persona leerID(Persona per) throws Exception{
        Persona pers = null;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement  st = this.getCn().prepareStatement("SELECT codigo, nombre, sexo FROM Persona WHERE codigo = ?");
            st.setInt(1,per.getCodigo());
            rs = st.executeQuery();
            while(rs.next()){
                pers = new Persona();
                pers.setCodigo(rs.getInt("codigo"));
                pers.setNombre(rs.getString("nombre"));
                pers.setSexo(rs.getString("sexo"));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        
        return pers;
    }
    
    public void modificar(Persona persona) throws Exception{
        try{
            this.Conectar();
            PreparedStatement  st = this.getCn().prepareStatement("UPDATE Persona SET nombre = ?, sexo = ? WHERE codigo = ? ");
            st.setString(1, persona.getNombre());
            st.setString(2, persona.getSexo());
            st.setInt(3, persona.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
    public void eliminar(Persona persona) throws Exception{
        try{
            this.Conectar();
            PreparedStatement  st = this.getCn().prepareStatement("DELETE FROM Persona WHERE codigo = ? ");
            st.setInt(1, persona.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
