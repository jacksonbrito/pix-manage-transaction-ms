package com.br.pix.pixmanagetransactionms.controller;

import com.br.pix.pixmanagetransactionms.entity.ChavePix;
import com.br.pix.pixmanagetransactionms.service.ChavePixService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/key")
public class ChavePixController {

    @Autowired
    private ChavePixService chavePixService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChavePix salvarChave(@RequestBody @Valid ChavePix chavePix){
        return chavePixService.salvarChavePix(chavePix);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ChavePix> listarChaves() {
        return chavePixService.listarChavePix();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarChave(@PathVariable("id") Long id){
        chavePixService.buscarPorId(id)
                .map(chavePix -> {
                    chavePixService.removerPorId(chavePix.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Chave não cadastrada na instituição Will Bank"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarChavePorId(@PathVariable("id") Long id, @RequestBody ChavePix chavePix) {
        chavePixService.buscarPorId(id)
                .map(chavePixBase -> {
                    modelMapper.map(chavePix, chavePixBase);
                    chavePixService.salvarChavePix(chavePixBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Chave não cadastrada na instituição Will Bank"));
    }

}
