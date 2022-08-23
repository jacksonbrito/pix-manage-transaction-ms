package com.br.pix.pixmanagetransactionms.controller;

import com.br.pix.pixmanagetransactionms.entity.RecebimentoPix;
import com.br.pix.pixmanagetransactionms.service.RecebimentoPixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/pay")
public class RecebimentoController {

    @Autowired
    private RecebimentoPixService recebimentoPixService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public RecebimentoPix receberPagamento(@RequestBody @Valid RecebimentoPix recebimentoPix){
        return recebimentoPixService.salvarRecebimentoPix(recebimentoPix);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RecebimentoPix> listarRecebiemntos() {
        return recebimentoPixService.listarRecebimentosPix();
    }
}
