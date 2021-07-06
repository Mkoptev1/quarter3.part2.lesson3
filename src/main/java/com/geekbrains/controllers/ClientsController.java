package com.geekbrains.controllers;

import com.geekbrains.entities.Client;
import com.geekbrains.entities.ClientWareLink;
import com.geekbrains.services.ClientService;
import com.geekbrains.services.ClientsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientsController {
    private ClientService clientService;
    private ClientsOrderService clientsOrderService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setClientsOrderService(ClientsOrderService clientsOrderService) {
        this.clientsOrderService = clientsOrderService;
    }

    // Список клиентов
    // http://localhost:8189/app/clients/client-list
    @RequestMapping("/client-list")
    public String getClientList(Model model) {
        List<Client> clientList = clientService.getClientList();
        model.addAttribute("clients", clientList);
        return "client-list";
    }

    // Форма добавления клиента
    // http://localhost:8189/app/clients/add-client
    @RequestMapping("/add-client")
    public String newClient(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "add-client";
    }

    // Сохранение клиента
    // http://localhost:8189/app/clients/save-client
    @RequestMapping("/save-client")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.saveClient(client);
        return "redirect:client-list";
    }

    // Форма удаления клиента
    // http://localhost:8189/app/clients/del-client-form
    @RequestMapping("/del-client-form")
    public String delClient() {
        return "del-client-form";
    }

    // Сохранение удаленного клиента
    // http://localhost:8189/app/clients/save-del-client
    @RequestMapping("/save-del-client")
    public String saveDelClient(@ModelAttribute("client") Client client) {
        //clientService.saveWare(client);
        return "redirect:client-list";
    }

    // Поиск клиента по товару
    // http://localhost:8189/app/clients/search-client-by-ware-form
    @RequestMapping("/search-client-by-ware-form")
    public String searchClientByWareForm() {
        return "search-client-by-ware-form";
    }

    // Результат поиска клиента по товару
    @RequestMapping(path="/search-client-by-ware-result", method=RequestMethod.GET)
    public String searchWareResult(@RequestParam("id") long clientId, Model model) {
        Client client = new Client();
        client = clientService.getClientById(clientId);
        model.addAttribute("client", client);
        return "search-client-by-ware-result";
    }

    // Отчет по заказам
    // http://localhost:8189/app/clients/rep-form-client-ware
    @RequestMapping("/rep-form-client-ware")
    public String geClientWareList(Model model) {
        List<ClientWareLink> clientWareLinkList = clientsOrderService.getClientsOrderList();
        model.addAttribute("clientsOrder", clientWareLinkList);
        return "rep-form-client-ware";
    }
}