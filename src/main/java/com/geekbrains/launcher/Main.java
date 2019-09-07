package com.geekbrains.launcher;

import com.geekbrains.entities.Client;
import com.geekbrains.entities.ClientsOrder;
import com.geekbrains.entities.Ware;
import com.geekbrains.entities.WareByClient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("resources/hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;

        // Добавляем нового клиента
        session = factory.getCurrentSession();
        Client client = new Client();
        client.setClient_name("Клиент1");
        session.beginTransaction();
        session.save(client);
        System.out.println(client);
        session.getTransaction().commit();

        // Добавляем новую книгу
        session = factory.getCurrentSession();
        Ware ware = new Ware();
        ware.setWare_name ("Товар1");
        ware.setWare_cost((long) 12);
        session.beginTransaction();
        session.save(ware);
        System.out.println(ware);
        session.getTransaction().commit();

        // Совершаем покупку товара клиентом
        session = factory.getCurrentSession();
        ClientsOrder clientsOrder = new ClientsOrder();
        clientsOrder.setClient_id (client.getClient_id());
        clientsOrder.setWare_id(ware.getWare_id());
        clientsOrder.setWare_cost(ware.getWare_cost());
        session.beginTransaction();
        session.save(clientsOrder);
        System.out.println(ware);
        session.getTransaction().commit();

        // Смотрим, какие товары покупал клиент
        session = factory.getCurrentSession();
        session.beginTransaction();
        WareByClient showWareByClient = session.get(WareByClient.class, 2);
        System.out.println(showWareByClient);
        session.getTransaction().commit();

        // Удаляем клиента
        session = factory.getCurrentSession();
        Client clientRemove = new Client();
        clientRemove.setClient_id((long) 2);
        session.beginTransaction();
        session.delete(clientRemove);
        System.out.println(clientRemove);
        session.getTransaction().commit();

        // Удаляем товар
        session = factory.getCurrentSession();
        Ware wareRemove = new Ware();
        wareRemove.setWare_id((long) 2);
        session.beginTransaction();
        session.delete(wareRemove);
        System.out.println(wareRemove);
        session.getTransaction().commit();

        factory.close();
        session.close();
    }
}
