package com.crustaceo_cascarudo.servicio;
import java.util.ArrayList;
import java.util.List;
import com.crustaceo_cascarudo.modelo.Carta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CartaService {
    // Atributos
    private SessionFactory factory;

    public CartaService(){
        //CREAR OBJETO QUE PERMITA ABRIR SESIONES
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Carta.class)
        .buildSessionFactory();
    }

    public Session openSession(){
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public List<Carta> getPlatos(){
        List<Carta> platos = new ArrayList<>();
        Session session = openSession();
        try {
            platos = session.createQuery("from Carta", Carta.class).list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return platos;
    }

    public List<Carta> getXCategoria(String categoria) {
        List<Carta> platos = new ArrayList<>();
        Session session = openSession();
        try {
            platos = session.createQuery("from Carta where categoria = :categoria", Carta.class)
            .setParameter("categoria", categoria)
            .list();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return platos;
    }

    public String create(Carta plato){
        String resp = "";
        Session session = openSession();
        try {
            session.persist(plato);
            session.getTransaction().commit();
            resp = "Plato creado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            resp = e.getMessage();
        }

        return resp;
    }    
        /*public String create(String nombre_plato, int id_categoria, String foto, Double precio, String descripcion){
        String resp = "";
        Session session = openSession();

        try {
            Carta plato = new Carta(nombre_plato,id_categoria,foto,precio,descripcion);
            session.persist(plato);
            session.getTransaction().commit();

            resp = "Plato creado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            resp = e.getMessage();
        }

        return resp;
    }*/
}
