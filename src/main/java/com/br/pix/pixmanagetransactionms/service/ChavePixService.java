package com.br.pix.pixmanagetransactionms.service;

import com.br.pix.pixmanagetransactionms.entity.ChavePix;
import com.br.pix.pixmanagetransactionms.repository.ChavePixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChavePixService {

    @Autowired
    private ChavePixRepository chavePixRepository;

    public ChavePix salvarChavePix(ChavePix chavePix){
        return chavePixRepository.save(chavePix);
    }

    public List<ChavePix> listarChavePix(){
        return chavePixRepository.findAll();
    }

    public Optional<ChavePix> buscarPorId(Long id){
        return chavePixRepository.findById(id);
    }
    public void removerPorId(Long id){
        chavePixRepository.deleteById(id);
    }

}
