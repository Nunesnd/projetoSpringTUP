package com.webtup.SpringWeb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
