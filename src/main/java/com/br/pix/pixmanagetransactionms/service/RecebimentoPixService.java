package com.br.pix.pixmanagetransactionms.service;

import com.br.pix.pixmanagetransactionms.entity.ChavePix;
import com.br.pix.pixmanagetransactionms.entity.RecebimentoPix;
import com.br.pix.pixmanagetransactionms.repository.RecebimentoPixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecebimentoPixService {

    @Autowired
    private RecebimentoPixRepository recebimentoPixRepository;


    public RecebimentoPix salvarRecebimentoPix(RecebimentoPix recebimentoPix){
        return recebimentoPixRepository.save(recebimentoPix);
    }

    public List<RecebimentoPix> listarRecebimentosPix(){
        return recebimentoPixRepository.findAll();
    }
}
