package modelo;

public abstract class MediosDePago {

    private String tipoPago;

    public MediosDePago(){
        this.tipoPago=tipoPago;
    }


    public String getTipoPago(){
        return tipoPago;
    }

    public void setTipoPago(String nuevoTipoPago){
        this.tipoPago=nuevoTipoPago;
    }

    public abstract boolean procresarPago();


    
}
