/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendasapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.vendasapi.Util;
import com.mycompany.vendasapi.dto.ItemVendaDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 *
 * @author igorp
 */
public class ItemVendaService {
            private static int SUCESS = 200;
    private static String URLWEBSERVICE = "http://localhost/8080/api/produto";
    
    private static List<ItemVendaDTO> converte(String json) throws JsonProcessingException{
        ObjectMapper mapp = new ObjectMapper();
        List<ItemVendaDTO> listaItemVenda = mapp.readValue(json, new TypeReference<List<ItemVendaDTO>>(){});
        return listaItemVenda;
    }
    
    public static List<ItemVendaDTO> buscarProduto() throws Exception {
        String urlBusca = URLWEBSERVICE;
        
       try{
            URL url = new URL(urlBusca);
            HttpURLConnection conx = (HttpURLConnection) url.openConnection();
            
            if (conx.getResponseCode() != SUCESS){
                throw new RuntimeException("Erro na conexão"+ conx.getResponseMessage());
            }
            BufferedReader resposta = new BufferedReader(new InputStreamReader(conx.getInputStream()));
            String json = Util.converteJsonString(resposta);
            List<ItemVendaDTO> produtod = converte(json);
            return produtod;
             }catch (Exception ex){
                  throw new Exception("Erro ao retornar Item: "+ex);
             }
        }
}
