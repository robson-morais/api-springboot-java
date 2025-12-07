package com.example.meu_primeiro_spring_boot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.meu_primeiro_spring_boot.exceptions.RecursoNaoEncontradoException;
import com.example.meu_primeiro_spring_boot.model.Produto;
import com.example.meu_primeiro_spring_boot.repository.ProdutoRepository;

@Service
public class ProdutoServices {

    private final ProdutoRepository produtoRepository;

    public ProdutoServices(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }
    
    public Produto buscarPorID(Long id)// Segundo o professor, 'optional' pq pode ou nao retornar um objeto// depois de add a excecao,  deixou só o objeto
    {
        return produtoRepository.findById(id)
        .orElseThrow(()-> new RecursoNaoEncontradoException("Produto não encontrado para o id:"+id));
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);

    }

    public void deletarProduto(Long id){
        if (!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto não encontrado para o id:"+id); //por que esse tratamento é diferente do buscarPorId?
        }
        produtoRepository.deleteById(id);
    }
}
