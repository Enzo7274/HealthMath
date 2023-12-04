/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.healthmath.backend.javarestapplication.controller;

/**
 *
 * @author enzob
 */
import br.healthmath.backend.javarestapplication.model.Atendimento;
import br.healthmath.backend.javarestapplication.dao.AtendimentoDAO;
import java.util.List;

public class AtendimentoBC {

    private final AtendimentoDAO dao = new AtendimentoDAO();

    public boolean salvar(Atendimento atendimento) {
        if (!this.dao.obterAtendimentosPorNum(atendimento.getNumero_aten()).isEmpty()) {
            return false;
        }
        this.dao.salvar(atendimento);
        return true;
    }

    public List<Atendimento> obterAtendimentos() {
        return this.dao.obterAtendimentos();
    }

    public List<Atendimento> obterAtendimentosPorNum(int numero_aten) {
        return this.dao.obterAtendimentosPorNum(numero_aten);
    }
}
