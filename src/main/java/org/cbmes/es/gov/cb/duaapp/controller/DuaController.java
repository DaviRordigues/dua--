package org.cbmes.es.gov.cb.duaapp.controller;

import org.cbmes.es.gov.cb.duaapp.request.ConsultarDuaRequest;
import org.cbmes.es.gov.cb.duaapp.request.EmitirDuaRequest;
import org.cbmes.es.gov.cb.duaapp.response.DuaConsultaResponse;
import org.cbmes.es.gov.cb.duaapp.response.DuaEmissaoResponse;
import org.cbmes.es.gov.cb.duaapp.service.IntegrarDuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dua")
public class DuaController {

    private final IntegrarDuaService integrarDuaService;

    @Autowired
    public DuaController(IntegrarDuaService integrarDuaService) {
        this.integrarDuaService = integrarDuaService;
    }

    @PostMapping("/emit")
    public ResponseEntity<DuaEmissaoResponse> emitirDua(@RequestBody EmitirDuaRequest emitirDuaRequest) {
        try {
            DuaEmissaoResponse response = integrarDuaService.emitirDUA(emitirDuaRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/consult")
    public ResponseEntity<DuaConsultaResponse> consultarDua(@RequestBody ConsultarDuaRequest consultarDuaRequest) {
        try {
            DuaConsultaResponse response = integrarDuaService.consultarDua(consultarDuaRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
