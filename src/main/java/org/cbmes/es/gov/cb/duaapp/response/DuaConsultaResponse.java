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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"duaConsultaResult"},
        namespace = "http://www.sefaz.es.gov.br/duae"
)
@XmlRootElement(
        name = "duaConsultaResponse",
        namespace = "http://www.sefaz.es.gov.br/duae"
)
public class DuaConsultaResponse {
    private DuaConsultaResult duaConsultaResult;

    public DuaConsultaResult getDuaConsultaResult() {
        if (this.duaConsultaResult == null) {
            this.duaConsultaResult = new DuaConsultaResult();
        }

        return this.duaConsultaResult;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
            name = "duaConsultaResult",
            propOrder = {"retConsDua"}
    )
    public static class DuaConsultaResult {
        private RetConsDua retConsDua;

        public DuaConsultaResult() {
        }

        public RetConsDua getRetConsDua() {
            if (this.retConsDua == null) {
                this.retConsDua = new RetConsDua();
            }

            return this.retConsDua;
        }

        public void setRetConsDua(RetConsDua retConsDua) {
            this.retConsDua = retConsDua;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(
                name = "retConsDua",
                propOrder = {"tpAmb", "dRet", "nProt", "tProc", "cStat", "xMotivo", "dua"}
        )
        public static class RetConsDua {
            private String tpAmb;
            private String dRet;
            private String nProt;
            private String tProc;
            private String cStat;
            private String xMotivo;
            private Dua dua;

            public RetConsDua() {
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
                    propOrder = {"infDUAe"}
            )
            public static class Dua {
                private InfDUAe infDUAe;

                public Dua() {
                }

                public InfDUAe getInfDUAe() {
                    if (this.infDUAe == null) {
                        this.infDUAe = new InfDUAe();
                    }

                    return this.infDUAe;
                }

                public void setInfDUAe(InfDUAe infDUAe) {
                    this.infDUAe = infDUAe;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(
                        name = "",
                        propOrder = {"ide", "orgao", "area", "serv", "rece", "contri", "data", "valor", "pgto", "infComp"}
                )
                public static class InfDUAe {
                    private Ide ide;
                    private Orgao orgao;
                    private Area area;
                    private Serv serv;
                    private Rece rece;
                    private Contri contri;
                    private Data data;
                    private Valor valor;
                    private Pgto pgto;
                    String infComp;

                    public InfDUAe() {
                    }

                    public Ide getIde() {
                        if (this.ide == null) {
                            this.ide = new Ide();
                        }

                        return this.ide;
                    }

                    public void setIde(Ide ide) {
                        this.ide = ide;
                    }

                    public Orgao getOrgao() {
                        if (this.orgao == null) {
                            this.orgao = new Orgao();
                        }

                        return this.orgao;
                    }

                    public void setOrgao(Orgao orgao) {
                        this.orgao = orgao;
                    }

                    public Area getArea() {
                        if (this.area == null) {
                            this.area = new Area();
                        }

                        return this.area;
                    }

                    public void setArea(Area area) {
                        this.area = area;
                    }

                    public Serv getServ() {
                        if (this.serv == null) {
                            this.serv = new Serv();
                        }

                        return this.serv;
                    }

                    public void setServ(Serv serv) {
                        this.serv = serv;
                    }

                    public Rece getRece() {
                        if (this.rece == null) {
                            this.rece = new Rece();
                        }

                        return this.rece;
                    }

                    public void setRece(Rece rece) {
                        this.rece = rece;
                    }

                    public Contri getContri() {
                        if (this.contri == null) {
                            this.contri = new Contri();
                        }

                        return this.contri;
                    }

                    public void setContri(Contri contri) {
                        this.contri = contri;
                    }

                    public Data getData() {
                        if (this.data == null) {
                            this.data = new Data();
                        }

                        return this.data;
                    }

                    public void setData(Data data) {
                        this.data = data;
                    }

                    public Valor getValor() {
                        if (this.valor == null) {
                            this.valor = new Valor();
                        }

                        return this.valor;
                    }

                    public void setValor(Valor valor) {
                        this.valor = valor;
                    }

                    public Pgto getPgto() {
                        if (this.pgto == null) {
                            this.pgto = new Pgto();
                        }

                        return this.pgto;
                    }

                    public void setPgto(Pgto pgto) {
                        this.pgto = pgto;
                    }

                    public String getInfComp() {
                        return this.infComp;
                    }

                    public void setInfComp(String infComp) {
                        this.infComp = infComp;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(
                            name = "",
                            propOrder = {"cPgto", "dAut", "cAge", "cAut", "fPgto", "tCap", "cBan"}
                    )
                    public static class Pgto {
                        public String cPgto;
                        public String dAut;
                        public String cAge;
                        public String cAut;
                        public String fPgto;
                        public String tCap;
                        public String cBan;

                        public Pgto() {
                        }
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(
                            name = "",
                            propOrder = {"vMul", "vJur", "vAtu", "vCred", "vTot"}
                    )
                    public static class Valor {
                        public String vMul;
                        public String vJur;
                        public String vAtu;
                        public String vCred;
                        public String vTot;

                        public Valor() {
                        }
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(
                            name = "",
                            propOrder = {"dRef", "dVen", "dPag"}
                    )
                    public static class Data {
                        public String dRef;
                        public String dVen;
                        public String dPag;

                        public Data() {
                        }
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(
                            name = "",
                            propOrder = {"cnpj", "cpf", "xNome"}
                    )
                    public static class Contri {
                        public String cnpj;
                        public String cpf;
                        public String xNome;

                        public Contri() {
                        }
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(
                            name = "",
                            propOrder = {"cRece", "vRece"}
                    )
                    public static class Rece {
                        public String cRece;
                        public String vRece;

                        public Rece() {
                        }
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(
                            name = "",
                            propOrder = {"cServ", "xNome"}
                    )
                    public static class Serv {
                        public String cServ;
                        public String xNome;

                        public Serv() {
                        }
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(
                            name = "",
                            propOrder = {"cArea", "xNome"}
                    )
                    public static class Area {
                        public String cArea;
                        public String xNome;

                        public Area() {
                        }
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(
                            name = "",
                            propOrder = {"cnpj", "cOrg", "xNome", "xSigla"}
                    )
                    public static class Orgao {
                        public String cnpj;
                        public String cOrg;
                        public String xNome;
                        public String xSigla;

                        public Orgao() {
                        }
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(
                            name = "",
                            propOrder = {"nDUA", "dEmis", "cBarra"}
                    )
                    public static class Ide {
                        public String nDUA;
                        public String dEmis;
                        public String cBarra;

                        public Ide() {
                        }
                    }
                }
            }
        }
    }
}
