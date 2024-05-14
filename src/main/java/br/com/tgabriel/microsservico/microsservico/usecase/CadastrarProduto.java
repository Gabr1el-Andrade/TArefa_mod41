package br.com.tgabriel.microsservico.microsservico.usecase;

import br.com.tgabriel.microsservico.microsservico.domain.Produto;
import br.com.tgabriel.microsservico.microsservico.exception.EntityNotFoundException;
import br.com.tgabriel.microsservico.microsservico.repository.IProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tgabriel.microsservico.microsservico.domain.Produto.Status;

@Service
public class CadastrarProduto {
    private IProdutoRepository produtoRepository;

    @Autowired
    public CadastrarProduto(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrar(@Valid Produto produto) {
        produto.setStatus(Status.ATIVO);
        return this.produtoRepository.insert(produto);
    }

    public Produto atualizar(@Valid Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public void remover(String id) {
        Produto prod = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Produto.class, "id", id));
        prod.setStatus(Produto.Status.INATIVO);
        this.produtoRepository.save(prod);

    }

}

