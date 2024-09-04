//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.cbmes.es.gov.cb.duaapp.request;

import lombok.*;

import java.util.Date;
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmitirDuaRequest {
    private String cnpjEmi;
    private String cnpjOrg;
    private int codigoArea;
    private int codigoServico;
    private String cnpjPes;
    private Date dataReferencia;
    private Date dataVencimento;
    private Date dataParaPagamento;
    private int codigoMunicipio;
    private String informacoesComplementares;
    private double valorMulta;
    private double valorJuros;
    private double valorAtualizacao;
    private double valorReceita;
    private int quantidade;

}
