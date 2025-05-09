package com.doback.E_rank.controller;

import com.doback.E_rank.models.UsuariosJogosModel;
import com.doback.E_rank.facade.UsuariosJogosFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/usuariosJogos")
public class UsuariosJogosController {
    private final UsuariosJogosFacade usuariosJogosFacade;

    public UsuariosJogosController(UsuariosJogosFacade usuariosJogosFacade) {
        this.usuariosJogosFacade = usuariosJogosFacade;
    }

    @GetMapping
    public List<UsuariosJogosModel> listaUsuariosJogos() {
        return usuariosJogosFacade.listarUsuariosJogos();
    }

    @GetMapping("/{id}")
    public UsuariosJogosModel obterUsuariosJogos(@PathVariable int id) {
        return usuariosJogosFacade.buscarUsuariosJogosPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarUsuariosJogos(@RequestBody UsuariosJogosModel usuariosJogosModel) {
        usuariosJogosFacade.salvarUsuariosJogos(usuariosJogosModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirUsuariosJogos(@PathVariable int id) {
        usuariosJogosFacade.excluirUsuariosJogos(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarUsuariosJogos(@PathVariable int id, @RequestBody UsuariosJogosModel usuariosJogosModel) {
        usuariosJogosFacade.atualizarUsuariosJogos(id, usuariosJogosModel);
    }
}
