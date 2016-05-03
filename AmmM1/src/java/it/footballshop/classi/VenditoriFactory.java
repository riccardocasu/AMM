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
public class VenditoriFactory {
    // Attributi
    private static VenditoriFactory singleton;
    public static VenditoriFactory getInstance() {
        if (singleton == null) {
            singleton = new VenditoriFactory();
        }
        return singleton;
    }
    
    // Lista Venditori
    private ArrayList<Venditore> listaVenditori = new ArrayList<Venditore>();
    
    /* Costruttore */
    private VenditoriFactory() {
            
        //Venditore 1
        Venditore venditore_1 = new Venditore();
        venditore_1.setUsername("faraone");
        venditore_1.setPassword("2");
        venditore_1.setNome("Stephan");
        venditore_1.setCognome("El Shaarawy");
        venditore_1.setId(2);
        listaVenditori.add(venditore_1);
        //Venditore 2
        Venditore venditore_2 = new Venditore();
        venditore_2.setUsername("pipita");
        venditore_2.setPassword("3");
        venditore_2.setNome("Gonzalo");
        venditore_2.setCognome("Higuain");
        venditore_2.setId(3);
        listaVenditori.add(venditore_2);
    }
    
    /* Metodi */
    public ArrayList<Venditore> getVenditoreList()
    {
        return listaVenditori;
    }
    public Venditore getVenditore(int id)
    {
        for(Venditore v : listaVenditori)
        {
            if(v.id == id)
                return v;
        }
        
        return null;
    }
}
