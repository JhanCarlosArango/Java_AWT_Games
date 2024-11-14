package Vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Controlador.Articulo_controlador;
import Modelo.Articulo;

public class Conf_Ventana extends JFrame {

    Articulo_controlador controladora;
    ImageIcon save,lim;
    private JPanel lienzo;
    @SuppressWarnings("rawtypes")
    public JComboBox caja;
    private JTable t_product;
    public ButtonGroup g_iva;
    public JButton b_save, b_ejecutar,b_lim;
    private DefaultTableModel modelTable;
    public JRadioButton r_iva_5, r_iva_10, r_iva_15;
    private JLabel l_cod, l_tipo, l_nombre, l_valor_uni, l_iva, l_titulo;
    public JTextField tf_cod, tf_tipo, tf_nombre, tf_valor_uni, tf_rud_cod;

    Conf_Ventana() {
        // --Nota: Tener en cuenta la barra Invertida "/" tambien Depende de la
        // configuracion del classpath--
        Image icon = new ImageIcon(getClass().getResource("/Icon/agregar.png")).getImage(); // En esta
        // --ocasion No funciona por que la carpeta Icon no esta en el Classpath a menos
        // que se mueva a la carpeta src--
        // -- o Se agrege toda la carpeta del proyecto al Classpath
        setIconImage(icon);
        controladora = new Articulo_controlador(this);
        setTitle("Producto Warehouse");
        setSize(300, 480);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JComponentes();
    }

    //
    private void JComponentes() {

        Iconos();
        JPanesles();
        Jbutones();
        JRadioButton();
        Jlabel();
        JTextF();
        MarcoTabla();
        JCombo();
        Jtabla(new ArrayList<>());
    }

    private void Iconos() {
        save = new ImageIcon("src/Icon/save.png");
        lim = new ImageIcon("src/Icon/l.png");
    }

    public void limpiar() {
        tf_cod.setText("");
        tf_nombre.setText("");
        tf_tipo.setText("");
        tf_valor_uni.setText("");
        g_iva.clearSelection();

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void JCombo() {
        String[] option = { "Default", "Product List", "Search", "Update", "Delete" };
        caja = new JComboBox(option);
        caja.setBorder(BorderFactory.createTitledBorder("Options Available"));
        caja.setBounds(145, 355, 135, 50);
        caja.addActionListener(controladora);

        lienzo.add(caja);
    }

    private void MarcoTabla() {
        t_product = new JTable();
        JScrollPane scrollPane = new JScrollPane(t_product);
        scrollPane.setBounds(10, 230, 270, 120);
        lienzo.add(scrollPane);
    }

    public void Jtabla(ArrayList<Articulo> list_art) {
        modelTable = new DefaultTableModel(); // modelTable se configurar la tabla
        modelTable.addColumn("Code");
        modelTable.addColumn("Type");
        modelTable.addColumn("Name");
        modelTable.addColumn("Unitary");
        modelTable.addColumn("IVA");

        for (Articulo art : list_art) {

            if (art.isEstado() != false) { 
                Object[] columna = new Object[6];
                columna[0] = art.getCodigo();
                columna[1] = art.getTipo();
                columna[2] = art.getNombre();
                columna[3] = art.getValor_uni();
                columna[4] = art.getIva();
                modelTable.addRow(columna);
            }
        }

        // Actualizar el modelo de la tabla con los nuevos datos
        t_product.setModel(modelTable);

    }

    private void JRadioButton() {
        r_iva_5 = new JRadioButton("5");
        r_iva_5.setActionCommand("5");
        r_iva_5.setBounds(120, 130, 35, 25);
        lienzo.add(r_iva_5);

        r_iva_10 = new JRadioButton("10");
        r_iva_10.setActionCommand("10");
        r_iva_10.setBounds(155, 130, 40, 25);
        lienzo.add(r_iva_10);

        r_iva_15 = new JRadioButton("19");
        r_iva_15.setActionCommand("19");
        r_iva_15.setBounds(200, 130, 40, 25);
        lienzo.add(r_iva_15);

        g_iva = new ButtonGroup();
        g_iva.add(r_iva_5);
        g_iva.add(r_iva_10);
        g_iva.add(r_iva_15);
    }

    private void Jbutones() {
        b_save = new JButton();

        b_save.setIcon(new ImageIcon(save.getImage().getScaledInstance(268, 25, Image.SCALE_SMOOTH)));
        b_save.addActionListener(controladora);
        b_save.setBounds(10, 160, 270, 30);
        lienzo.add(b_save);

        b_ejecutar = new JButton("EJECUTAR");
        b_ejecutar.setEnabled(false);

        b_ejecutar.addActionListener(controladora);
        b_ejecutar.setBounds(10, 410, 270, 30);
        lienzo.add(b_ejecutar);

        b_lim = new JButton("L");
        b_lim.addActionListener(controladora);
        b_lim.setBounds(220, 10, 50, 50);
        b_lim.setBorder(null);
        b_lim.setBackground(null);
        b_lim.setIcon(new ImageIcon(lim.getImage().getScaledInstance(b_lim.getWidth(), b_lim.getHeight(), Image.SCALE_SMOOTH)));
        lienzo.add(b_lim);
    
    }

    private void Jlabel() {
        // l_cod.setForeground(new Color(0, 0, 0));
        l_cod = new JLabel("Product Code");
        l_cod.setBounds(10, 10, 120, 25);
        lienzo.add(l_cod);

        l_tipo = new JLabel("Product Type");
        l_tipo.setBounds(10, 40, 120, 25);
        lienzo.add(l_tipo);

        l_nombre = new JLabel("Product Name");
        l_nombre.setBounds(10, 70, 120, 25);
        lienzo.add(l_nombre);

        l_valor_uni = new JLabel("Value Unitary");
        l_valor_uni.setBounds(10, 100, 120, 25);
        lienzo.add(l_valor_uni);

        l_iva = new JLabel("Product IVA");
        l_iva.setBounds(10, 130, 120, 25);
        lienzo.add(l_iva);

        l_titulo = new JLabel("------Product List------");
        l_titulo.setBounds(90, 210, 120, 25);
        lienzo.add(l_titulo);
    }

    private void JTextF() {
        tf_cod = new JTextField();
        tf_cod.setBounds(120, 10, 90, 25);
        lienzo.add(tf_cod);

        tf_tipo = new JTextField();
        tf_tipo.setBounds(120, 40, 90, 25);
        lienzo.add(tf_tipo);

        tf_nombre = new JTextField();
        tf_nombre.setBounds(120, 70, 90, 25);
        lienzo.add(tf_nombre);

        tf_valor_uni = new JTextField();
        tf_valor_uni.setBounds(120, 100, 90, 25);
        lienzo.add(tf_valor_uni);

        tf_rud_cod = new JTextField();
        tf_rud_cod.setBorder(BorderFactory.createTitledBorder("Codigo"));
        tf_rud_cod.setBounds(10, 363, 128, 40);
        lienzo.add(tf_rud_cod);
    }

    private void JPanesles() {
        lienzo = new JPanel();
        lienzo.setLayout(null);
        add(lienzo);
    }

    public void modificar_celdas(JTable t_product) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        t_product.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        t_product.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        t_product.getColumnModel().getColumn(0).setPreferredWidth(40);
        t_product.getColumnModel().getColumn(4).setPreferredWidth(40);
    }

    public static void main(String[] arg) {
        Conf_Ventana main_ = new Conf_Ventana();

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Icon/agregar.png"));
        main_.setIconImage(retValue);
        main_.setVisible(true);
    }
}