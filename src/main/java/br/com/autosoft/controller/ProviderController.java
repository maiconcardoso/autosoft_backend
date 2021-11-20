package br.com.autosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.autosoft.dtos.ProviderDTO;
import br.com.autosoft.entities.Provider;
import br.com.autosoft.service.ProviderService;

@RestController(value = "/provider")
public class ProviderController {

    @Autowired
    private ProviderService service;

    @PostMapping
    public ResponseEntity<Provider> save(@RequestBody Provider providerToBeSaved) {
        Provider providerSave = service.create(providerToBeSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(providerSave);
    }

    @GetMapping
    public ResponseEntity<List<ProviderDTO>> findAll() {
        List<ProviderDTO> providerList = service.readAll();
        return ResponseEntity.status(HttpStatus.OK).body(providerList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDTO> findById(@PathVariable Integer id) {
        ProviderDTO providerById = service.readById(id);
        return ResponseEntity.status(HttpStatus.OK).body(providerById);
    }

    @PutMapping
    public ResponseEntity<ProviderDTO> update(@PathVariable Integer id, @RequestBody Provider provider) {
        ProviderDTO providerForUpdate = service.update(id, provider);
        return ResponseEntity.status(HttpStatus.OK).body(providerForUpdate);
    }

    @GetMapping("/name")
    public ResponseEntity<List<ProviderDTO>> findByName(@PathVariable String name) {
        List<ProviderDTO> providerByName = service.readByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(providerByName);
    }


    
}
