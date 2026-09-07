package com.pe.entity;

public class Cuenta {
    private String banco;
    private String tipo;
    private int cod_Empl;

    public Cuenta() {
    }

    public Cuenta(int cod_Empl, String tipo, String banco) {
        this.cod_Empl = cod_Empl;
        this.tipo = tipo;
        this.banco = banco;
    }

    public int getCod_Empl() {
        return cod_Empl;
    }

    public void setCod_Empl(int cod_Empl) {
        this.cod_Empl = cod_Empl;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}