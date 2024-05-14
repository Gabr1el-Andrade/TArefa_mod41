package br.com.tgabriel.microsservico.microsservico.repository;

import br.com.tgabriel.microsservico.microsservico.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
    public interface IProdutoRepository extends MongoRepository<Produto, String> {

        Optional<Produto> findByCodigo(String codigo);

        Page<Produto> findAllByStatus(Pageable pageable, Produto.Status status);

    Produto save(Produto produto);

}

