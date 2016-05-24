/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.footballshop.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author casur
 */
public class UtentiFactory {
    
    private static UtentiFactory singleton;
    String connectionString; 
    
    // E' l'unico metodo che restituisce il singleton. Provvede a inizializzarlo alla prima chiamata.
    // Nelle successive chiamate lo restituisce e basta.
    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }
    
    /* Costruttore */
    private UtentiFactory() {

    }
    
    /* Metodi */        
    public Utente getUtente(String username, String password)
    {
        try{
            Connection conn= DriverManager.getConnection(connectionString, "riccardocasu", "65003");
            //sql Command
            String query = "select * from venditore where username = ? and password = ?";
            //
            PreparedStatement stmt= conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            //Esegui query
            ResultSet res = stmt.executeQuery();
            
            if(res.next())
            {
                Venditore venditore = new Venditore();
                venditore.setId(res.getInt("id"));
                venditore.setNome(res.getString("nome"));
                venditore.setCognome(res.getString("cognome"));
                venditore.setUsername(res.getString("username"));
                venditore.setPassword(res.getString("password"));
                venditore.setSaldo(res.getDouble("saldo"));
                // Oggetti in vendita da questo venditore
                query = "select * from oggetto"
                        + " where id_venditore = "+ venditore.getId();
                Statement st= conn.createStatement();
                ResultSet res2= st.executeQuery(query);
                
                while(res2.next())
                {
                    OggettoInVendita o = new OggettoInVendita();
                    o.setId(res2.getInt("id"));
                    o.setNome(res2.getString("nome"));
                    o.setUrlImmagine(res2.getString("url_immagine"));
                    o.setDescrizione(res2.getString("descrizione"));
                    o.setPrezzo(res2.getDouble("prezzo"));
                    o.setQuantita(res2.getInt("quantita"));
                    venditore.getOggettiInVendita().add(o);
                }
                
                st.close();
                stmt.close();
                conn.close();
                return venditore;
            }
            
            //sql command
            query = "select * from cliente where username = ? and password = ?";
            stmt = conn.prepareStatement(query);
            //dati
            stmt.setString(1, username);
            stmt.setString(2, password);
            res = stmt.executeQuery();
            
            if (res.next())
            {
                Cliente cliente = new Cliente();
                cliente.setId(res.getInt("id"));
                cliente.setNome(res.getString("nome"));
                cliente.setCognome(res.getString("cognome"));
                cliente.setUsername(res.getString("username"));
                cliente.setPassword(res.getString("password"));
                cliente.setSaldo(res.getDouble("saldo"));
                
                stmt.close();
                conn.close();
                return cliente;
            }
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
        
        }
        return null;
    }
    // Venditore
    // Dato un id restituisce il relativo venditore (se esiste un venditore con quell'id, altrimenti
    // restituisce null).
    public Utente getVenditore(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "riccardocasu", "65003");
            // Query
            String query = "select * from venditore "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Venditore current = new Venditore();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setSaldo(res.getDouble("saldo"));
                // Oggetti in vendita da questo venditore
                query = "select * from oggetto"
                        + " where oggetto.id_venditore = "+ current.getId();
                Statement st= conn.createStatement();
                ResultSet res2= st.executeQuery(query);
                
                while(res2.next())
                {
                    OggettoInVendita o = new OggettoInVendita();
                    o.setId(res2.getInt("id"));
                    o.setNome(res2.getString("nome"));
                    o.setUrlImmagine(res2.getString("url_immagine"));
                    o.setDescrizione(res2.getString("descrizione"));
                    o.setPrezzo(res2.getDouble("prezzo"));
                    o.setQuantita(res2.getInt("quantita"));
                    current.getOggettiInVendita().add(o);
                }                 
                st.close();
                stmt.close();
                conn.close();
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    // Restituisce la lista di tutti i venditori
    public ArrayList<Venditore> getVenditori()
    {
        ArrayList<Venditore> listaVenditori = new ArrayList<Venditore>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "riccardocasu", "65003");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "venditore'";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Venditore current = new Venditore();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setSaldo(set.getDouble("saldo"));
                listaVenditori.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaVenditori;
    }
    
    // Restituisce la lista di tutti i clienti
    public ArrayList<Cliente> getClienti()
    {
        ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "riccardocasu", "65003");
            Statement stmt = conn.createStatement();
            String query = "select * from cliente";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Cliente current = new Cliente();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setSaldo(set.getDouble("saldo"));
                listaClienti.add(current);
            }     
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaClienti;
    }
    
    // Dato un id restituisce il relativo cliente (se esiste uno cliente con quell'id, altrimenti
    // restituisce null).
    public Utente getCliente(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "riccardocasu", "65003");
            String query = "select * from cliente "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
           
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Cliente current = new Cliente();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setSaldo(res.getDouble("saldo"));
                
                stmt.close();
                conn.close();
                return current;
            }
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public ArrayList<OggettoInVendita> getOggettiInVendita()
    {
        ArrayList<OggettoInVendita> lista = new ArrayList<OggettoInVendita>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "riccardocasu", "65003");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "oggetto";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                OggettoInVendita o = new OggettoInVendita();
                    o.setId(set.getInt("id"));
                    o.setNome(set.getString("nome"));
                    o.setUrlImmagine(set.getString("url_immagine"));
                    o.setDescrizione(set.getString("descrizione"));
                    o.setPrezzo(set.getDouble("prezzo"));
                    o.setQuantita(set.getInt("quantita"));
                lista.add(o);
            }
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lista;
    }
    public OggettoInVendita getOggetto(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "riccardocasu", "65003");
            String query = "select * from oggetto "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                OggettoInVendita o = new OggettoInVendita();
                    o.setId(res.getInt("id"));
                    o.setNome(res.getString("nome"));
                    o.setUrlImmagine(res.getString("url_immagine"));
                    o.setDescrizione(res.getString("descrizione"));
                    o.setPrezzo(res.getDouble("prezzo"));
                    o.setQuantita(res.getInt("quantita"));
                
   
                stmt.close();
                conn.close();
                return o;
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer getIdVenditore(Integer idOggettiInVendita){
        Integer idVenditore=0;
        try{
            Connection conn = DriverManager.getConnection(connectionString, "riccardocasu", "65003");
            String query = "select * from oggetto "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, idOggettiInVendita);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                idVenditore = res.getInt("id_venditore");
            }
            stmt.close();
                conn.close();
                return idVenditore;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public void eliminaOggetto(int id){
        
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "riccardocasu", "65003");

            String query = "DELETE FROM oggetto "
                         + "WHERE id = " + id;
            Statement st = conn.createStatement();
           
            st.executeUpdate(query);

            
            st.close();
            conn.close();
                  
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
       
    }
    public void inserisciOggetto(String nome, String url_immagine, Double prezzo, Integer quantita, String descrizione, Integer id_venditore){
       
        try
        {
            Connection c = DriverManager.getConnection(connectionString, "riccardocasu", "65003");
            
            String query = "INSERT INTO oggetto_in_vendita (id, nome, url_immagine, prezzo, quantita, descrizione, id_venditore)"
                            + " VALUES (?, ?, ?, ?, ?, ?, ?)";
           PreparedStatement stmt = c.prepareStatement(query);
            stmt.setInt(1, getOggettiInVendita().size());
            stmt.setString(2, nome);
            stmt.setString(3, url_immagine);            
            stmt.setDouble(4, prezzo);
            stmt.setInt(5, quantita);
            stmt.setString(6, descrizione);
            stmt.setInt(7, id_venditore);
            
            //Esegui query
           
            stmt.executeUpdate();
            stmt.close();
            c.close();
            
            
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }
     public void modificaOggetto(Integer id, String nome, String url_immagine, String descrizione, Double prezzo, Integer quantita){
       
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "riccardocasu", "65003");
            String query = "UPDATE oggetto SET nome = ? , url_immagine = ? , prezzo = ?, quantita = ?, descrizione = ? WHERE id = ?";

            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, nome);
            st.setString(2, url_immagine);
            st.setString(3, descrizione);
            st.setDouble(4, prezzo);
            st.setInt(5, quantita);
            st.setInt(6, id);
            
            st.executeUpdate();


            st.close();
            conn.close();
                  
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
       
    }
     
     public Integer Compra(int idCliente, int idOggettiInVendita) throws SQLException
        {
            Connection conn = DriverManager.getConnection(connectionString, "riccardocasu", "65003");
            PreparedStatement aggiornaSaldoVenditore = null;
            PreparedStatement aggiornaSaldoCliente= null;
            PreparedStatement aggiornaQuantitaOggetto=null;
            //sql command
            String updateCliente = "UPDATE cliente SET saldo = ? where id = ?";
            String updateVenditore = "UPDATE venditore SET saldo = ? where id = ?";
            String updateOggetto = "UPDATE oggetto SET quantita = ? where id = ?";
            try{
                conn.setAutoCommit(false);
                aggiornaSaldoVenditore = conn.prepareStatement(updateVenditore);
                aggiornaSaldoCliente = conn.prepareStatement(updateCliente);
                aggiornaQuantitaOggetto = conn.prepareStatement(updateOggetto);
                
                Double saldoC = getCliente(idCliente).getSaldo();
                Double saldoV = getVenditore(getIdVenditore(idOggettiInVendita)).getSaldo();
                Double prezzo = getOggetto(idOggettiInVendita).getPrezzo();
                Integer quantita = getOggetto(idOggettiInVendita).getQuantita();
                if (saldoC > prezzo && quantita!=0){
                    saldoC-=prezzo;
                    saldoV+=prezzo;
                    quantita--;
                }
                else
                {
                    if(quantita == 0)
                    {
                        return 2;//ogg terminato
                    }
                    return 3;//saldo insufficiente
                }
                
                aggiornaSaldoVenditore.setDouble(1, saldoV);
                aggiornaSaldoVenditore.setInt(2, getIdVenditore(idOggettiInVendita));
                
                aggiornaSaldoCliente.setDouble(1, saldoC);
                aggiornaSaldoCliente.setInt(2, idCliente);
                
                aggiornaQuantitaOggetto.setInt(1, quantita);
                aggiornaQuantitaOggetto.setInt(2, idOggettiInVendita);          
                
                int r1 = aggiornaSaldoVenditore.executeUpdate();
                int r2 = aggiornaSaldoCliente.executeUpdate();
                int r3 = aggiornaQuantitaOggetto.executeUpdate();
                
                if(r1 != 1 || r2 != 1 || r3 != 1)
                {
                    conn.rollback();
                }
                conn.commit();
                return 1;//pagamento effettuato con successo
            }
            catch(SQLException e)
            {
                conn.rollback();
                throw e;
            }
            finally
            {
                if(aggiornaSaldoVenditore != null)
                    aggiornaSaldoVenditore.close();
                if(aggiornaSaldoCliente != null)
                    aggiornaSaldoCliente.close();
                if(aggiornaQuantitaOggetto != null)
                    aggiornaQuantitaOggetto.close();
                conn.setAutoCommit(true);
                conn.close();
            }
        }
     
// ConnectionString
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}
