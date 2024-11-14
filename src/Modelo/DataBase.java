package Modelo;

import java.util.ArrayList;

public class DataBase implements Crud {

    ArrayList<Articulo> art;
    int c = 0;

    public DataBase() {

        art = new ArrayList<Articulo>();
    }

    public String Listar_Productos() {
        String pro = "";
        c++;
        for (Articulo articulo : getArt()) {
            if (articulo.isEstado() != false) {
                pro += "Codigo: " + articulo.getCodigo() + " Tipo: " + articulo.getTipo() + " Nombre producto : "
                        + articulo.getNombre() + " Iva: " + articulo.getIva() + " Valor Unitario: "
                        + articulo.getValor_uni() + "\n";
            }
        }
        System.out.println("---------------" + getArt());
        System.out.println("--------------- " + c);
        return pro;
    }

    @Override
    public void adicionar(Articulo art) {
        this.art.add(art);
    }

    @Override
    public Articulo consultar(int codigo) {
        for (Articulo obj : getArt()) {
            if (obj.getCodigo() == codigo) {
                if (obj.isEstado() != false) {

                    return obj;
                } else {
                    System.out.println("Producto Inactivo");
                    // puede ir exepciones
                }
            }

        }
        return null;
    }

    @Override
    // public void modificar(int codigo, String valor, int op) { // es para la clase
    // app que se usa por consla
    public void modificar(int codigo, Articulo art) {
        /// Se puede optimizar solo debo crear otro metodo consultar que reciba un Articulo y dentro modificar el objeto
        consultar(codigo).setNombre(art.getNombre());
        consultar(codigo).setTipo(art.getTipo());
        consultar(codigo).setIva(art.getIva());
        consultar(codigo).setValor_uni(art.getValor_uni());

        // Se puede optimizar Creado un metodo en la clase Articulo que sirva como
        // controlador
        /*
         * switch (op) {
         * case 1:
         * consultar(codigo).setTipo(valor);
         * break;
         * case 2:
         * consultar(codigo).setNombre(valor);
         * break;
         * case 3:
         * consultar(codigo).setIva(Double.parseDouble(valor));
         * break;
         * case 4:
         * consultar(codigo).setValor_uni(Double.parseDouble(valor));
         * break;
         * default:
         * break;
         * }
         */

    }

    @Override
    public void inactivar(int cod, boolean estado) {
        consultar(cod).setEstado(estado);

    }

    public ArrayList<Articulo> getArt() {
        return art;
    }

    public void setArt(ArrayList<Articulo> art) {
        this.art = art;
    }

}
