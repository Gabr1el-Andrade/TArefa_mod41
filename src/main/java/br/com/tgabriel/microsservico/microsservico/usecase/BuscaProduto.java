package br.com.tgabriel.microsservico.microsservico.usecase;

import br.com.tgabriel.microsservico.microsservico.domain.Produto;
import br.com.tgabriel.microsservico.microsservico.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;




@Service
public class BuscaProduto {
    private IProdutoRepository produtoRepository;

    @Autowired
    public BuscaProduto(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Page<Produto> buscar(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Page<Produto> buscar(Pageable pageable, Produto.Status status) {
        return produtoRepository.findAllByStatus((java.awt.print.Pageable) pageable, status);
    }

    public Produto buscarPorCodigo(String codigo) {
        return produtoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new EntityNotFoundException(Produto.class, "codigo", codigo));
    }

}
