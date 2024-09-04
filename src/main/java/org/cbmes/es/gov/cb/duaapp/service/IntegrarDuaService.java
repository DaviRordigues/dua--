package org.cbmes.es.gov.cb.duaapp.service;

import org.cbmes.es.gov.cb.duaapp.request.ConsultarDuaRequest;
import org.cbmes.es.gov.cb.duaapp.request.EmitirDuaRequest;
import org.cbmes.es.gov.cb.duaapp.response.DuaConsultaResponse;
import org.cbmes.es.gov.cb.duaapp.response.DuaEmissaoResponse;

public interface IntegrarDuaService {

    DuaEmissaoResponse emitirDUA(EmitirDuaRequest request) throws Exception;

    DuaConsultaResponse consultarDua(ConsultarDuaRequest request) throws Exception;
}
