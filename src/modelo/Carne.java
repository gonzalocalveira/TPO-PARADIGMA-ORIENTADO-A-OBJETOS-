package modelo;

import java.util.Date;

public class Carne {

    private String tipoCarne;
    private double peso;
    private Date fechaVencimiento;


    public Carne(String tipoCarne, double peso, Date fechaVencimiento){
        this.tipoCarne = tipoCarne;
        this.peso = peso;
        this.fechaVencimiento = fechaVencimiento;
    }

    //getters y setters

    public String getTipoCarne(){
        return tipoCarne;
    }

    public double getPeso(){
        return peso;
    }

    public Date getFechaVencmiento(){
        return fechaVencimiento;
    }


    public void setTipoCarne(String nuevoTipoCarne){
        this.tipoCarne = nuevoTipoCarne;
    }

    public void setPeso(double nuevoPeso){
        this.peso = nuevoPeso;
    }

    public void setFechaVencimiento(Date nuevaFechaVencimiento){
        this.fechaVencimiento = fechaVencimiento;
    }
    
}
