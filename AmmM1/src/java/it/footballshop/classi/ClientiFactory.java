/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.footballshop.classi;

import java.util.ArrayList;

/**
 *
 * @author casur
 */
public class ClientiFactory {
    // Attributi
    private static ClientiFactory singleton;
    public static ClientiFactory getInstance() {
        if (singleton == null) {
            singleton = new ClientiFactory();
        }
        return singleton;
    }
    
    // Lista Clienti
    private ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
    
    /* Costruttore */
    private ClientiFactory() {
            
        //Cliente 1
        Cliente cliente_1 = new Cliente();
        cliente_1.setUsername("riky22");
        cliente_1.setPassword("0");
        cliente_1.setNome("Ricardo");
        cliente_1.setCognome("Kaka");
        cliente_1.setId(0);
        listaClienti.add(cliente_1);
        //Cliente 2
        Cliente cliente_2 = new Cliente();
        cliente_2.setUsername("papugomez");
        cliente_2.setNome("Alejandro");
        cliente_2.setCognome("Gomez");
        cliente_2.setId(1);
        listaClienti.add(cliente_2);
    }
    
    /* Metodi */
    public ArrayList<Cliente> getClienteList()
    {
        return listaClienti;
    }
    public Cliente getCliente(int id)
    {
        for(Cliente c : listaClienti)
        {
            if(c.id == id)
                return c;
        }
        
        return null;
    }
}
