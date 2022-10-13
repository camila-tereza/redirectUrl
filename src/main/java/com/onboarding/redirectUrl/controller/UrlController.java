package com.onboarding.redirectUrl.controller;

import com.onboarding.redirectUrl.model.Url;
import com.onboarding.redirectUrl.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class UrlController {

    @Autowired
    private UrlRepository repository;

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

    @PostMapping ("/create")
    @Transactional
    public ResponseEntity<Url> createUrl(@RequestBody Url newSite, UriComponentsBuilder uriBuilder){
        repository.save(newSite);

        URI uri =uriBuilder.path("/{name}").buildAndExpand(newSite.getName()).toUri();
        return ResponseEntity.created(uri).body(newSite);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Url> updateUrl(@PathVariable Long id, @RequestBody Url newSite){
        Optional<Url> url = repository.findById(id);

        if(url.isPresent()){
            url.get().setLink(newSite.getLink());
            url.get().setName(newSite.getName());
            return ResponseEntity.ok(url.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public RedirectView acess(@PathVariable Long id) {
        Optional<Url> link = repository.findById(id);
        if (link.isPresent()) {
            RedirectView redirect = new RedirectView();
            redirect.setUrl(link.get().getLink());
            return redirect;
        }
        return null;
    }

}
