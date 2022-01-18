package br.com.ecommerce.leatherShop.controller;


import br.com.ecommerce.leatherShop.model.Categoria;
import br.com.ecommerce.leatherShop.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAllCategoria (){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findByIdCategoria (@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/cor/{cor}")
    public ResponseEntity<List<Categoria>> getByCor(@PathVariable String cor) {
        return ResponseEntity.ok(repository.findAllByCorContainingIgnoreCase(cor));
    }

    // FAZER OUTROS GET'S ALÉM DE COR!

    @PostMapping
    public ResponseEntity<Categoria> postCategoria (@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
    }

    @PutMapping
    public ResponseEntity<Categoria> putCategoria (@RequestBody Categoria categoria){
        return ResponseEntity.ok(repository.save(categoria));
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria (@PathVariable long id) {
        repository.deleteById(id);
    }

}
