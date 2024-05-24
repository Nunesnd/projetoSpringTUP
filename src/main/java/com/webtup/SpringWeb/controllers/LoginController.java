package com.webtup.SpringWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.webtup.SpringWeb.models.Administrador;
import com.webtup.SpringWeb.repositorio.AdministradoresRepo;

@Controller
public class LoginController {

    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/login")
    public String index() {
        return "login/index";
    }
    
    @PostMapping("/logar")
    public String logar(Model model, Administrador admParametro, String lembrar) {
        Administrador adm = this.repo.Login(admParametro.getEmail(), admParametro.getSenha());
        if(adm != null) {
            System.out.println("email: "+ adm.getEmail()+ ", senha: " +adm.getSenha());
            System.out.println("admin: " + adm);
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuario ou senha inválido"); 
        return "login/index";
    }
}
