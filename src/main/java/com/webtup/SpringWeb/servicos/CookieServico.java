package com.webtup.SpringWeb.servicos;

import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.Optional;

import org.apache.catalina.connector.Request;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieServico {
    public static void setCookie(HttpServletResponse response, String key, String valor, int segundos){
        Cookie cookie = new Cookie(key, valor);
        cookie.setMaxAge(segundos);
        response.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest request, String key){

        return Optional.ofNullable(request.getCookies())
            .flatMap(cookies -> Arrays.stream(cookies)
            .filter(cookie->key.equals(cookie.getName()))
            .findAny()
            ).map(e -> e.getValue())
            .orElse(null);
    }
}
