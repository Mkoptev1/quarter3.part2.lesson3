package com.geekbrains.launcher;

import com.geekbrains.entities.Client;
import com.geekbrains.entities.ClientWareLink;
import com.geekbrains.entities.Ware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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
        ClientWareLink ClientWareLink = new ClientWareLink();
        ClientWareLink.setClient_id (client.getClient_id());
        ClientWareLink.setWare_id(ware.getWare_id());
        ClientWareLink.setWare_cost(ware.getWare_cost());
        session.beginTransaction();
        session.save(ClientWareLink);
        System.out.println(ware);
        session.getTransaction().commit();

        // Смотрим, какие товары покупал клиент
        session = factory.getCurrentSession();
        session.beginTransaction();
        ClientWareLink showWareByClient = session.get(ClientWareLink.class, 2);
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

        // Получаем список клиентов
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Client> wareClient = session.createQuery("from Client").getResultList();
        System.out.println(wareClient);
        session.getTransaction().commit();

        // Получаем список товаров
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Ware> wareList = session.createQuery("from Ware").getResultList();
        System.out.println(wareList);
        session.getTransaction().commit();

        // Получаем список товаров по клиенту
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<ClientWareLink> wareListByClient = session.createQuery("from ClientWareLink cwl where cwl.client_id = :client_id")
                .setParameter("client_id", new Long(10)).getResultList();
        System.out.println(wareListByClient);
        session.getTransaction().commit();
  
        // Получаем список клиентов по товару
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<ClientWareLink> clientListByWare = session.createQuery("from ClientWareLink cwl where cwl.ware_id = :ware_id")
                .setParameter("ware_id", new Long(2)).getResultList();
        System.out.println(clientListByWare);
        session.getTransaction().commit();

        factory.close();
        session.close();
    }
}
