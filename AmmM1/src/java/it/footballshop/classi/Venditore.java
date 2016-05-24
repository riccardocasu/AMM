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
public class Venditore extends Utente{
    
    private ArrayList<OggettoInVendita> OggettiInVendita = new ArrayList<OggettoInVendita>(); 
    
    /* Costruttore */    
    public Venditore()
    {
        super();
    }

    /**
     * @return the OggettiInVendita
     */
    public ArrayList<OggettoInVendita> getOggettiInVendita() {
        return OggettiInVendita;
    }

    /**
     * @param OggettiInVendita the OggettiInVendita to set
     */
    public void setOggettiInVendita(ArrayList<OggettoInVendita> OggettiInVendita) {
        this.OggettiInVendita = OggettiInVendita;
    }
}
