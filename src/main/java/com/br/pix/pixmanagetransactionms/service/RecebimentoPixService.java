package com.br.pix.pixmanagetransactionms.service;

import com.br.pix.pixmanagetransactionms.entity.RecebimentoPix;
import com.br.pix.pixmanagetransactionms.repository.RecebimentoPixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecebimentoPixService {

    @Autowired
    private RecebimentoPixRepository recebimentoPixRepository;

    public RecebimentoPix salvarRecebimentoPix(RecebimentoPix recebimentoPix){
        return recebimentoPixRepository.save(recebimentoPix);
    }

}
