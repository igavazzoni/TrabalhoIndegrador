/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vendasapi;

import com.mycompany.vendasapi.dto.ClienteDTO;
import java.util.List;
import com.mycompany.vendasapi.service.ClienteService;

/**
 *
 * @author igorp
 */
public class VendasApi {

    public static void main(String[] args) throws Exception {
        
 
    new FramePrincipal().setVisible(true);
    List<ClienteDTO> yCliente = ClienteService.buscarCliente();      
    System.out.println(yCliente.toString());
    }
}
