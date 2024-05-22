package com.webtup.SpringWeb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.webtup.SpringWeb.models.Administrador;
import com.webtup.SpringWeb.repositorio.AdministradoresRepo;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/admin")
    public String index(Model model) {
        List<Administrador> administradores = (List<Administrador>)repo.findAll();
        model.addAttribute("admin", administradores);
        return "admin/index";
    }

    @GetMapping("admin/novo")
    public String novo() {
        return "admin/novo";
    }

    @PostMapping("admin/criar")
    public String criar(Administrador administrador) {
        repo.save(administrador);
        return "redirect:/admin";
    }

    @GetMapping("/atualizaAdmin/{id}")
    public String busca(@PathVariable int id, Model model) {
        Optional<Administrador> adm = repo.findById(id);
        model.addAttribute("administrador", adm.get());
        return "/admin/atualizaAdmin";
    }

    @PostMapping("/atualizaAdmin/{id}/atualizar")
    public String alterar(@PathVariable int id, Administrador administrador) {
        administrador.setId(id);
        repo.save(administrador);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/excluir")
    public String excluir(@PathVariable int id) {
        repo.deleteById(id);
        return "redirect:/admin";
    }
    
}
