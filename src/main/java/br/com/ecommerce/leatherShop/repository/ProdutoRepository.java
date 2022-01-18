package br.com.ecommerce.leatherShop.repository;

import br.com.ecommerce.leatherShop.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public List<Produto> findAllByBlusaContainingIgnoreCase(String blusa);

    public List<Produto> findAllByCamisetaContainingIgnoreCase(String camiseta);

    public List<Produto> findAllByCalcaContainingIgnoreCase(String calca);

    public List<Produto> findAllByJaquetaContainingIgnoreCase(String jaqueta);

    public List<Produto> findAllBySapatoContainingIgnoreCase(String sapato);
}
