package org.cbmes.es.gov.cb.duaapp.service.imp;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.cbmes.es.gov.cb.duaapp.request.ConsultarDuaRequest;
import org.cbmes.es.gov.cb.duaapp.request.EmitirDuaRequest;
import org.cbmes.es.gov.cb.duaapp.response.DuaConsultaResponse;
import org.cbmes.es.gov.cb.duaapp.response.DuaEmissaoResponse;
import org.cbmes.es.gov.cb.duaapp.service.IntegrarDuaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.xml.soap.*;
import org.w3c.dom.Document;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;

@Service
public class IntegrarDuaServiceImpl implements IntegrarDuaService {

    private final int valor;
    private final String url;

    public IntegrarDuaServiceImpl(@Value("${dua.sefaz.environment}") String environment,
                                  @Value("${dua.sefaz.url}") String url) {
        this.valor = "PRODUCAO".equals(environment) ? 1 : 2;
        this.url = url;
    }

    @Override
    public DuaEmissaoResponse emitirDUA(EmitirDuaRequest request) throws Exception {
        try {
            String xmlEmissao = this.retornaXmlMontadoParaEmitirDua(request);
            SOAPMessage mensagemReposta = this.realizaRequisicaoNaSefaz(xmlEmissao);
            JAXBContext converterXmlToObj = JAXBContext.newInstance(DuaEmissaoResponse.class);
            Unmarshaller unMarshaller = converterXmlToObj.createUnmarshaller();
            Document doc = this.trataResponseDaRequisicao(mensagemReposta);
            return (DuaEmissaoResponse) unMarshaller.unmarshal(doc);
        } catch (Exception e) {
            throw new Exception("Erro ao tentar realizar a conversão do XML para o objeto DuaEmissaoResponse: " + e.getMessage(), e);
        }
    }

    @Override
    public DuaConsultaResponse consultarDua(ConsultarDuaRequest request) throws Exception {
        try {
            String xml = this.retornaXmlMontadoParaConsultarDua(request);
            SOAPMessage mensagemReposta = this.realizaRequisicaoNaSefaz(xml);
            JAXBContext converterXmlToObj = JAXBContext.newInstance(DuaConsultaResponse.class);
            Unmarshaller unMarshaller = converterXmlToObj.createUnmarshaller();
            Document doc = this.trataResponseDaRequisicao(mensagemReposta);
            return (DuaConsultaResponse) unMarshaller.unmarshal(doc);
        } catch (Exception e) {
            throw new Exception("Erro ao tentar realizar a conversão do XML para o objeto DuaConsultaResponse: " + e.getMessage(), e);
        }
    }

    private SOAPMessage realizaRequisicaoNaSefaz(String xml) throws Exception {
        MimeHeaders header = new MimeHeaders();
        header.addHeader("Content-Type", "application/soap+xml");
        MessageFactory factory = MessageFactory.newInstance("SOAP 1.2 Protocol");
        SOAPMessage message = factory.createMessage(header, new ByteArrayInputStream(xml.getBytes()));
        SOAPConnection conSoap = SOAPConnectionFactory.newInstance().createConnection();

        try {
            return conSoap.call(message, this.url + "/duaservice.asmx");
        } catch (Exception e) {
            throw new Exception("Erro ao se comunicar com a SEFAZ ->" + e.getMessage(), e);
        }
    }

    private Document trataResponseDaRequisicao(SOAPMessage mensagemReposta) throws Exception {
        SOAPBody body = mensagemReposta.getSOAPBody();
        return body.extractContentAsDocument();
    }

    private String retornaXmlMontadoParaEmitirDua(EmitirDuaRequest request) {
        return "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:duae=\"http://www.sefaz.es.gov.br/duae\">" +
                "<soap:Header><duae:DuaServiceHeader><duae:versao>1.01</duae:versao></duae:DuaServiceHeader></soap:Header>" +
                "<soap:Body><duae:duaEmissao><duae:duaDadosMsg><emisDua versao=\"1.01\" xmlns=\"http://www.sefaz.es.gov.br/duae\">" +
                "<tpAmb>" + valor + "</tpAmb>" +
                "<cnpjEmi>" + request.getCnpjEmi() + "</cnpjEmi>" +
                "<cnpjOrg>" + request.getCnpjOrg() + "</cnpjOrg>" +
                "<cArea>" + request.getCodigoArea() + "</cArea>" +
                "<cServ>" + request.getCodigoServico() + "</cServ>" +
                "<cnpjPes>" + request.getCnpjPes() + "</cnpjPes>" +
                "<dRef>" + new SimpleDateFormat("yyyy-MM").format(request.getDataReferencia()) + "</dRef>" +
                "<dVen>" + new SimpleDateFormat("yyyy-MM-dd").format(request.getDataVencimento()) + "</dVen>" +
                "<dPag>" + new SimpleDateFormat("yyyy-MM-dd").format(request.getDataParaPagamento()) + "</dPag>" +
                "<cMun>" + request.getCodigoMunicipio() + "</cMun>" +
                "<xInf>" + request.getInformacoesComplementares() + "</xInf>" +
                "<qtde>" + request.getQuantidade() + "</qtde>" +
                "<xIde>" + request.getCnpjPes() + "</xIde>" +
                "<fPix>true</fPix></emisDua></duae:duaDadosMsg></duae:duaEmissao></soap:Body></soap:Envelope>";
    }

    private String retornaXmlMontadoParaConsultarDua(ConsultarDuaRequest request) {
        String cpfCnpj = request.getCnpj().length() == 11 ? "cpf" : "cnpj";
        return "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"http://www.sefaz.es.gov.br/duae\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" +
                "<soap12:Header><DuaServiceHeader xmlns=\"http://www.sefaz.es.gov.br/duae\"><versao>1.00</versao></DuaServiceHeader></soap12:Header>" +
                "<soap12:Body><duaConsulta><duaDadosMsg><consDua versao=\"1.00\">" +
                "<tpAmb>" + valor + "</tpAmb>" +
                "<nDua>" + request.getNumeroDua() + "</nDua>" +
                "<" + cpfCnpj + ">" + request.getCnpj() + "</" + cpfCnpj + "></consDua></duaDadosMsg></duaConsulta></soap12:Body></soap12:Envelope>";
    }
}
