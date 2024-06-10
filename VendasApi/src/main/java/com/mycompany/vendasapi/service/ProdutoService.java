/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendasapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.vendasapi.Util;
import com.mycompany.vendasapi.dto.ProdutoDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 *
 * @author igorp
 */
public class ProdutoService {
        private static int SUCESS = 200;
    private static String URLWEBSERVICE = "http://localhost:8080/api/produto";
    
    private static List<ProdutoDTO> converte(String json) throws JsonProcessingException{
        ObjectMapper mapp = new ObjectMapper();
        List<ProdutoDTO> listaProduto = mapp.readValue(json, new TypeReference<List<ProdutoDTO>>(){});
        return listaProduto;
    }
    
    public static List<ProdutoDTO> buscarProduto() throws Exception {
        String urlBusca = URLWEBSERVICE;
        
            URL url = new URL(urlBusca);
            HttpURLConnection conx = (HttpURLConnection) url.openConnection();
            
            if (conx.getResponseCode() != SUCESS){
                throw new RuntimeException("Erro na conexão"+ conx.getResponseMessage());
            }
            BufferedReader resposta = new BufferedReader(new InputStreamReader(conx.getInputStream()));
            String json = Util.converteJsonString(resposta);
            List<ProdutoDTO> produtod = converte(json);
            return produtod;
        }
    
}
