package br.com.ecommerce.leatherShop.controller;


import br.com.ecommerce.leatherShop.model.Categoria;
import br.com.ecommerce.leatherShop.model.Produto;
import br.com.ecommerce.leatherShop.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAllProduto() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findByIdProduto(@PathVariable long id) {
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/blusa/{blusa}")
    public ResponseEntity<List<Produto>> getByBlusa(@PathVariable String blusa) {
        return ResponseEntity.ok
                (repository.findAllByBlusaContainingIgnoreCase(blusa));
    }

    @GetMapping("/camiseta/{camiseta}")
    public ResponseEntity<List<Produto>> getByCamiseta(@PathVariable String camiseta) {
        return ResponseEntity.ok
                (repository.findAllByCamisetaContainingIgnoreCase(camiseta));
    }

    @GetMapping("/calca/{calca}")
    public ResponseEntity<List<Produto>> getByCalca(@PathVariable String calca) {
        return ResponseEntity.ok
                (repository.findAllByCalcaContainingIgnoreCase(calca));
    }

    @GetMapping("/jaqueta/{jaqueta}")
    public ResponseEntity<List<Produto>> getByJaqueta(@PathVariable String jaqueta) {
        return ResponseEntity.ok
                (repository.findAllByJaquetaContainingIgnoreCase(jaqueta));
    }

    @GetMapping("/sapato/{sapato}")
    public ResponseEntity<List<Produto>> getBySapato(@PathVariable String sapato) {
        return ResponseEntity.ok
                (repository.findAllBySapatoContainingIgnoreCase(sapato));
    }

    @PostMapping
    public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> putProduto(@RequestBody Produto produto) {
        return ResponseEntity.ok(repository.save(produto));
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable long id) {
        repository.deleteById(id);
    }
}
