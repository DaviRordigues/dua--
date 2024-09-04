//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.cbmes.es.gov.cb.duaapp.response;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.*;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        namespace = "http://www.sefaz.es.gov.br/duae",
        propOrder = {"duaEmissaoResult"}
)
@XmlRootElement(
        name = "duaEmissaoResponse",
        namespace = "http://www.sefaz.es.gov.br/duae"
)
public class DuaEmissaoResponse {
    protected DuaEmissaoResult duaEmissaoResult;

    @Setter
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
            name = "",
            propOrder = {"retEmisDua"}
    )
    public static class DuaEmissaoResult {
        private RetEmisDua retEmisDua;

        public DuaEmissaoResult() {
        }

        public RetEmisDua getRetEmisDua() {
            if (this.retEmisDua == null) {
                this.retEmisDua = new RetEmisDua();
            }

            return this.retEmisDua;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(
                name = "retEmisDua",
                propOrder = {"tpAmb", "dRet", "nProt", "tProc", "cStat", "xMotivo", "dua"}
        )
        public static class RetEmisDua {
            private String tpAmb;
            private String dRet;
            private String nProt;
            private String tProc;
            private String cStat;
            private String xMotivo;
            private Dua dua;

            public RetEmisDua() {
            }

            public String getTpAmb() {
                return this.tpAmb;
            }

            public void setTpAmb(String tpAmb) {
                this.tpAmb = tpAmb;
            }

            public String getDRet() {
                return this.dRet;
            }

            public void setDRet(String ret) {
                this.dRet = ret;
            }

            public String getNProt() {
                return this.nProt;
            }

            public void setNProt(String prot) {
                this.nProt = prot;
            }

            public String getTProc() {
                return this.tProc;
            }

            public void setTProc(String proc) {
                this.tProc = proc;
            }

            public String getCStat() {
                return this.cStat;
            }

            public void setCStat(String stat) {
                this.cStat = stat;
            }

            public String getXMotivo() {
                return this.xMotivo;
            }

            public void setXMotivo(String motivo) {
                this.xMotivo = motivo;
            }

            public Dua getDua() {
                if (this.dua == null) {
                    this.dua = new Dua();
                }

                return this.dua;
            }

            public void setDua(Dua dua) {
                this.dua = dua;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(
                    name = "",
                    propOrder = {"nDua", "dEmi", "vTot", "nBar", "xPix"}
            )
            public static class Dua {
                private String nDua;
                private String dEmi;
                private String vTot;
                private String nBar;
                private String xPix;

                public Dua() {
                }

                public String getnDua() {
                    return this.nDua;
                }

                public void setnDua(String nDua) {
                    this.nDua = nDua;
                }

                public String getdEmi() {
                    return this.dEmi;
                }

                public void setdEmi(String dEmi) {
                    this.dEmi = dEmi;
                }

                public String getvTot() {
                    return this.vTot;
                }

                public void setvTot(String vTot) {
                    this.vTot = vTot;
                }

                public String getnBar() {
                    return this.nBar;
                }

                public void setnBar(String nBar) {
                    this.nBar = nBar;
                }

                public String getxPix() {
                    return this.xPix;
                }

                public void setxPix(String xPix) {
                    this.xPix = xPix;
                }
            }
        }
    }
}
