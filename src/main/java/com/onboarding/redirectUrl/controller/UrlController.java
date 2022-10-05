package com.onboarding.redirectUrl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UrlController {

    @GetMapping("/gitHub")
    public RedirectView git(){
        RedirectView redirect = new RedirectView();
        redirect.setUrl("https://github.com/");
        return redirect;
    }

    @GetMapping("/assertiva")
    public RedirectView assertiva(){
        RedirectView redirect = new RedirectView();
        redirect.setUrl("https://assertivasolucoes.com.br/");
        return redirect;
    }
}
