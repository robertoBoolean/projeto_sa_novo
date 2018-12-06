/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Adriano Rodrigues
 */
public enum SituacaoGuarita {
    MATRICULA_NAO_ENCONTRADA('M'),
    SAIDA('S'),
    ENTRADA('E'),
    FALHA('F'),
    FORA_HORARIO('H'),
    DOIS_REGISTRO('R');

    private Character tipo;

    private static final SituacaoGuarita[] ENUNS = values();

    private static Map<Character, SituacaoGuarita> tipoMap = new LinkedHashMap<>();

    static {
        Arrays.asList(ENUNS).forEach(item -> {
            tipoMap.put(item.tipo, item);
        });
    }

    SituacaoGuarita(Character tipo){
        this.tipo = tipo;
    }

    public Character getValue() {
        return tipo;
    }
}