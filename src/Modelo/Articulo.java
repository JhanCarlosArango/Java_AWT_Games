package Modelo;

public class Articulo {

    private int codigo;
    private String tipo;
    private String nombre;
    private Double iva;
    private boolean estado = true;
    private double valor_uni;

    public Articulo() {

    }

    public Articulo(int codigo, String tipo, String nombre, Double iva, double valor_uni) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.iva = iva;
        
        this.valor_uni = valor_uni;
    }

    public String ver_articulo(Articulo art) {
        if (art != null) {
            return " Codigo: " + art.getCodigo() + " Tipo: " + art.getTipo() + " Nombre: " + art.getNombre() + " Iva: "+ art.getIva() + "% " + " Valor Unitario: $" + art.getValor_uni() +"--"+ art.isEstado();
        } else {
            return "Vacio";
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getValor_uni() {
        return valor_uni;
    }

    public void setValor_uni(double valor_uni) {
        this.valor_uni = valor_uni;
    }

}
