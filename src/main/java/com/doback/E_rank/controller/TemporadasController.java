package com.doback.E_rank.controller;
import com.doback.E_rank.entity.Temporadas;
import com.doback.E_rank.facade.TemporadasFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Temporadas")
public class TemporadasController {

    private final TemporadasFacade temporadaFacade;

    public TemporadasController(TemporadasFacade temporadaFacade) {
        this.temporadaFacade = temporadaFacade;
    }

    @GetMapping
    public List<Temporadas> listarTemporadas() {
        return temporadaFacade.listarTemporadas();
    }

    @GetMapping("/{id}")
    public Temporadas obterTemporadas(@PathVariable Long id) {
        return temporadaFacade.buscarTemporadaPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTemporada(@RequestBody Temporadas temporada) {
        temporadaFacade.salvarTemporada(temporada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirTemporada(@PathVariable Long id) { temporadaFacade.excluirTemporada(id);
    }


}
