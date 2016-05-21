/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.footballshop.classi;

import java.util.ArrayList;

/**
 *
 * @author Riccardo
 */
public class Factory {
    private static Factory singleton;
    String connectionString;
    
    public static Factory getInstance(){
        if (singleton == null){
            singleton = new Factory();
        }
        return singleton;
    }
    
    // Lista Oggetti in vendita
    private ArrayList<OggettoInVendita> listaOggetti = new ArrayList<>();
    //Lista Venditori
    private ArrayList<Utente> listaVenditori = new ArrayList<>();
    //Lista Clienti
    private ArrayList<Utente> listaClienti = new ArrayList<>();
    
    //Costruttore
    public Factory(){
        
        //Oggetto 1
        OggettoInVendita oggetto_1 = new OggettoInVendita();
        oggetto_1.setNome("Maglia Juventus");
        oggetto_1.setUrlImmagine("images/juve.png");
        oggetto_1.setPrezzo(45.00);
        oggetto_1.setQuantita(30);
        oggetto_1.setDescrizione("Maglia Juventus");
        oggetto_1.setId(0);
        listaOggetti.add(oggetto_1);
        //Oggetto 2
        OggettoInVendita oggetto_2 = new OggettoInVendita();
        oggetto_2.setNome("Maglia Roma");
        oggetto_2.setUrlImmagine("images/roma.png");
        oggetto_2.setPrezzo(45.00);
        oggetto_2.setQuantita(52);
        oggetto_2.setDescrizione("Maglia Roma");
        oggetto_2.setId(1);
        listaOggetti.add(oggetto_2);
        //Oggetto 3
        OggettoInVendita oggetto_3 = new OggettoInVendita();
        oggetto_3.setNome("Maglia Inter");
        oggetto_3.setUrlImmagine("images/inter.png");
        oggetto_3.setPrezzo(45.00);
        oggetto_3.setQuantita(48);
        oggetto_3.setDescrizione("Maglia Inter");
        oggetto_3.setId(2);
        listaOggetti.add(oggetto_3);
        //Oggetto 4
        OggettoInVendita oggetto_4 = new OggettoInVendita();
        oggetto_4.setNome("Maglia Milan (Trasferta)");
        oggetto_4.setUrlImmagine("images/milan2.png");
        oggetto_4.setPrezzo(40.00);
        oggetto_4.setQuantita(78);
        oggetto_4.setDescrizione("Maglia Milan (Trasferta)");
        oggetto_4.setId(3);
        listaOggetti.add(oggetto_4);
        //Oggetto 5
        OggettoInVendita oggetto_5 = new OggettoInVendita();
        oggetto_4.setNome("Pallone Napoli");
        oggetto_5.setUrlImmagine("images/napoli_pallone.png");
        oggetto_5.setPrezzo(10.50);
        oggetto_5.setQuantita(90);
        oggetto_5.setDescrizione("Pallone Napoli");
        oggetto_5.setId(4);
        listaOggetti.add(oggetto_5);
        //Oggetto 6
        OggettoInVendita oggetto_6 = new OggettoInVendita();
        oggetto_4.setNome("Cover Fiorentina");
        oggetto_6.setUrlImmagine("images/fiorentina_cover.png");
        oggetto_6.setPrezzo(6.00);
        oggetto_6.setQuantita(94);
        oggetto_6.setDescrizione("Cover Fiorentina");
        oggetto_6.setId(5);
        listaOggetti.add(oggetto_6);
    
        
        //Clienti
        Cliente cliente_1 = new Cliente();
        cliente_1.setUsername("riky22");
        cliente_1.setPassword("0");
        cliente_1.setNome("Ricardo");
        cliente_1.setCognome("Kaka");
        cliente_1.setId(0);
        cliente_1.setSaldo(1000.0);
        listaClienti.add(cliente_1);
        
        Cliente cliente_2 = new Cliente();
        cliente_2.setUsername("papugomez");
        cliente_2.setPassword("1");
        cliente_2.setNome("Alejandro");
        cliente_2.setCognome("Gomez");
        cliente_2.setId(1);
        cliente_1.setSaldo(35.0);
        listaClienti.add(cliente_2);
        
        //Venditori        
        Venditore venditore_1 = new Venditore();
        venditore_1.setUsername("faraone");
        venditore_1.setPassword("2");
        venditore_1.setNome("Stephan");
        venditore_1.setCognome("El Shaarawy");
        venditore_1.setId(2);
        listaVenditori.add(venditore_1);
        
        Venditore venditore_2 = new Venditore();
        venditore_2.setUsername("pipita");
        venditore_2.setPassword("3");
        venditore_2.setNome("Gonzalo");
        venditore_2.setCognome("Higuain");
        venditore_2.setId(3);
        listaVenditori.add(venditore_2);
    }
    
    /* Metodi */
    public ArrayList<Utente> getVenditoreList(){
        return listaVenditori;
    }
    public Utente getVenditore(int id){
        for(Utente u : listaVenditori){
            if(u.getId() == id)
                return u;
        }
        return null;
    }
    public ArrayList<Utente> getClienteList(){
        return listaClienti;
    }
    public Utente getCliente(int id){
        for(Utente u : listaClienti){
            if(u.getId() == id)
                return u;
        }
        return null;
    }
    public ArrayList<OggettoInVendita> getOggettiList(){
        return listaOggetti;
    }
    public OggettoInVendita getOggetto(int id){
        for(OggettoInVendita o : listaOggetti){
            if(o.getId() == id)
                return o;
        }
        return null;
    }
    public void aggiungiOggetto(OggettoInVendita o){
        listaOggetti.add(o);
    }
    public ArrayList<Utente> getUserList(){
        ArrayList<Utente> listaUtenti = new ArrayList<>();
        
        listaUtenti.addAll(listaVenditori);
        listaUtenti.addAll(listaClienti);
        
        return listaUtenti;
    }
    
    // ConnectionString
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
    
}