/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendasapi.dao;

import com.mycompany.vendasapi.conexaoBD.ConexaoPostgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igorp
 */
public abstract class GenericDAO<Objeto> {
     public Connection conn = null;
    
    public GenericDAO(){
        conn = ConexaoPostgres.getConection();
    }
    
    protected abstract Objeto construirObjeto(ResultSet rs);
        
    public abstract boolean salvar(Objeto obj);     
    
    public abstract boolean atualizar(Objeto obj);
    
    public ArrayList<Objeto> retornaLista(String sql){
        
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Objeto>lista = new ArrayList<>();
        
        try {
            
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                lista.add(construirObjeto(rs));
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public Objeto retornarPeloId(int id, 
            String tabela, String chavePrimaria){
        
        PreparedStatement ps;
        ResultSet rs;
        Objeto obj = null;
        
        try {
            ps = conn.prepareStatement("SELECT * FROM public.\""+tabela+"\" WHERE "+
                    "\""+chavePrimaria+"\" = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
               obj = construirObjeto(rs);
            }
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return obj;
    }
    
    public void delete(int id, String tabela, 
            String chavePrimaria){
        
        PreparedStatement ps;
        
        try {
            ps = conn.prepareStatement("DELETE FROM "
                    + "public.\""+tabela+"\" WHERE \""+
                    chavePrimaria+"\" = ? ");
            
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
