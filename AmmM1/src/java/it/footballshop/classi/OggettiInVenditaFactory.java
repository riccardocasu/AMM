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
public class OggettiInVenditaFactory {
    // Attributi
    private static OggettiInVenditaFactory singleton;
    public static OggettiInVenditaFactory getInstance() {
        if (singleton == null) {
            singleton = new OggettiInVenditaFactory();
        }
        return singleton;
    }
    
    // Lista OggettiInVendita
    private ArrayList<OggettoInVendita> listaOggettiInVendita = new ArrayList<OggettoInVendita>();
    
    /* Costruttore */
    private OggettiInVenditaFactory() {
            
        //Oggetto 1
        OggettoInVendita oggetto_1 = new OggettoInVendita();
        oggetto_1.setNome("Maglia Juventus");
        oggetto_1.setUrlImmagine("images/juve.png");
        oggetto_1.setPrezzo(45.00);
        oggetto_1.setPezziDisponibili(30);
        oggetto_1.setDescrizione("Maglia Juventus");
        oggetto_1.setId(0);
        listaOggettiInVendita.add(oggetto_1);
        //Oggetto 2
        OggettoInVendita oggetto_2 = new OggettoInVendita();
        oggetto_2.setNome("Maglia Roma");
        oggetto_2.setUrlImmagine("images/roma.png");
        oggetto_2.setPrezzo(45.00);
        oggetto_2.setPezziDisponibili(52);
        oggetto_2.setDescrizione("Maglia Roma");
        oggetto_2.setId(1);
        listaOggettiInVendita.add(oggetto_2);
        //Oggetto 3
        OggettoInVendita oggetto_3 = new OggettoInVendita();
        oggetto_3.setNome("Maglia Inter");
        oggetto_3.setUrlImmagine("images/inter.png");
        oggetto_3.setPrezzo(45.00);
        oggetto_3.setPezziDisponibili(48);
        oggetto_3.setDescrizione("Maglia Inter");
        oggetto_3.setId(2);
        listaOggettiInVendita.add(oggetto_3);
        //Oggetto 4
        OggettoInVendita oggetto_4 = new OggettoInVendita();
        oggetto_4.setNome("Maglia Milan (Trasferta)");
        oggetto_4.setUrlImmagine("images/milan2.png");
        oggetto_4.setPrezzo(40.00);
        oggetto_4.setPezziDisponibili(78);
        oggetto_4.setDescrizione("Maglia Milan (Trasferta)");
        oggetto_4.setId(3);
        listaOggettiInVendita.add(oggetto_4);
        //Oggetto 5
        OggettoInVendita oggetto_5 = new OggettoInVendita();
        oggetto_4.setNome("Pallone Napoli");
        oggetto_5.setUrlImmagine("images/napoli_pallone.png");
        oggetto_5.setPrezzo(10.50);
        oggetto_5.setPezziDisponibili(90);
        oggetto_5.setDescrizione("Pallone Napoli");
        oggetto_5.setId(4);
        listaOggettiInVendita.add(oggetto_5);
        //Oggetto 6
        OggettoInVendita oggetto_6 = new OggettoInVendita();
        oggetto_4.setNome("Cover Fiorentina");
        oggetto_6.setUrlImmagine("images/fiorentina_cover.png");
        oggetto_6.setPrezzo(6.00);
        oggetto_6.setPezziDisponibili(94);
        oggetto_6.setDescrizione("Cover Fiorentina");
        oggetto_6.setId(5);
        listaOggettiInVendita.add(oggetto_6);
    }
    
    /* Metodi */
    public ArrayList<OggettoInVendita> getOggettiInVenditaList()
    {
        return listaOggettiInVendita;
    }
    public OggettoInVendita getOggettoInVendita(int id)
    {
        for(OggettoInVendita o : listaOggettiInVendita)
        {
            if(o.id == id)
                return o;
        }
        
        return null;
    }
}

