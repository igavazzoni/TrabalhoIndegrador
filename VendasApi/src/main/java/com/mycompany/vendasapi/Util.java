/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendasapi;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author igorp
 */
public class Util {
    
        public static String converteJsonString(
            BufferedReader bufferReader) throws IOException{
        
        String resposta = "";
        String jsonString = "";
        
        while((resposta = bufferReader.readLine()) != null){
            jsonString += resposta;
        }
        return jsonString;
    }
    
}
