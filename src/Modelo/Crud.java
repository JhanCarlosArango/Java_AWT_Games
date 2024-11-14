package Modelo;

public interface Crud {

    void adicionar(Articulo art);

    Articulo consultar(int codigo);

   //void modificar(int codigo,String valor,int op);
    void modificar(int codig,Articulo art);

    void inactivar(int codigo,boolean estado);

}
