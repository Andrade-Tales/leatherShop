package br.com.ecommerce.leatherShop.repository;

import br.com.ecommerce.leatherShop.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    public List<Categoria> findAllByCorContainingIgnoreCase(String cor);

}
