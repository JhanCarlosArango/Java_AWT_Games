package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Modelo.Articulo;
import Modelo.DataBase;
import Vista.Conf_Ventana;

public class Articulo_controlador implements ActionListener {
    Conf_Ventana view;
    Articulo producto;
    DataBase BD;

    Articulo det = new Articulo(1, "Fruit", "Banana", 5.0, 750.0);
    Articulo det1 = new Articulo(2, "Vegetable", "Tomato", 10.0, 1500.0);
    Articulo det2 = new Articulo(3, "Vegetable", "Carrot", 15.0, 1150.0);
    Articulo det3 = new Articulo(4, "Chiken", "Chiken wing", 5.0, 5500.0);
    Articulo det4 = new Articulo(5, "Meat", "Pork loin", 19.0, 6850.0);
    Articulo det5 = new Articulo(6, "Vegetable", "Onion", 15.0, 2200.0);

    public Articulo_controlador(Conf_Ventana view) {
        this.view = view;
        BD = new DataBase();

        BD.adicionar(det);
        BD.adicionar(det2);
        BD.adicionar(det1);
        BD.adicionar(det3);
        BD.adicionar(det5);
        BD.adicionar(det4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (view.b_lim == e.getSource()) {
            view.limpiar();
        }
        producto = new Articulo();
        if (view.b_save == e.getSource()) {

            producto.setCodigo(Integer.parseInt(view.tf_cod.getText()));
            producto.setTipo(view.tf_tipo.getText());
            producto.setNombre(view.tf_nombre.getText());
            producto.setIva(Double.parseDouble(view.g_iva.getSelection().getActionCommand()));
            producto.setValor_uni(Double.parseDouble(view.tf_valor_uni.getText()));

            BD.adicionar(producto);
            view.Jtabla(BD.getArt());
            view.limpiar();
        }

        if (view.b_ejecutar == e.getSource()) {

            Articulo art_temp = new Articulo();

            art_temp.setNombre(view.tf_nombre.getText());
            art_temp.setTipo(view.tf_tipo.getText());
            art_temp.setValor_uni(Double.parseDouble(view.tf_valor_uni.getText()));
            art_temp.setIva(Double.valueOf(view.g_iva.getSelection().getActionCommand()));

            BD.modificar(Integer.parseInt(view.tf_rud_cod.getText()), art_temp);
        }

        if (view.caja == e.getSource()) {

            switch ((String) view.caja.getSelectedItem()) {
                case "Search":
                    view.tf_cod.setEnabled(true);
                    view.b_ejecutar.setEnabled(false);
                    ArrayList<Articulo> list_temp = new ArrayList<>();
                    list_temp.add(BD.consultar(Integer.parseInt(view.tf_rud_cod.getText())));
                    view.Jtabla(list_temp);

                    break;
                case "Update":
                    view.b_ejecutar.setEnabled(true);
                    view.tf_cod.setEnabled(false);
                    Articulo art_temp = new Articulo();
                    int c = Integer.parseInt(view.tf_rud_cod.getText());
                    art_temp = BD.consultar(c);

                    view.tf_nombre.setText(art_temp.getNombre());
                    view.tf_tipo.setText(art_temp.getTipo());
                    view.tf_valor_uni.setText(String.valueOf(art_temp.getValor_uni()));

                    break;
                case "Delete":
                    view.b_ejecutar.setEnabled(false);
                    view.tf_cod.setEnabled(true);
                    boolean inputBolean = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "Eliminar 'false'"));
                    BD.inactivar(Integer.parseInt(view.tf_rud_cod.getText()), inputBolean);

                    break;
                case "Product List":
                    view.b_ejecutar.setEnabled(false);
                    view.tf_cod.setEnabled(true);
                    System.out.println(view.caja.getSelectedItem());
                    view.Jtabla(BD.getArt());
                    break;

                default:
                    break;
            }
        }
    }

}
