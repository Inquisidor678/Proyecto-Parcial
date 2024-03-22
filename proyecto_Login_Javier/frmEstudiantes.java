import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class frmEstudiantes extends JFrame {

    private JTextField txtCodigo;
    private JButton btnVerificar;
    private JLabel lblTitulo, lblCodigo;
    private JPanel panelPrincipal, panelCodigo, panelBoton;

    public frmEstudiantes() {
        // Configuración inicial de la ventana
        setTitle("Ingreso de Estudiantes");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Centrar la ventana

        // Panel principal con diseño de fondo
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(new Color(245, 245, 245)); // Color suave de fondo

        // Título de la ventana
        lblTitulo = new JLabel("Acceso Estudiantes");
        lblTitulo.setFont(new Font("Helvetica", Font.BOLD, 18)); // Fuente y tamaño del título
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinear al centro

        // Panel para el código
        panelCodigo = new JPanel(new FlowLayout());
        panelCodigo.setBackground(new Color(245, 245, 245)); // Color suave de fondo

        lblCodigo = new JLabel("Código:");
        txtCodigo = new JTextField(15); // Campo de texto con ancho definido

        panelCodigo.add(lblCodigo);
        panelCodigo.add(txtCodigo);

        // Panel para el botón
        panelBoton = new JPanel(new FlowLayout());
        panelBoton.setBackground(new Color(245, 245, 245)); // Color suave de fondo

        btnVerificar = new JButton("Verificar");
        btnVerificar.addActionListener(e -> verificarCodigo());

        panelBoton.add(btnVerificar);

        // Agregar componentes al panel principal
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado superior
        panelPrincipal.add(lblTitulo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre elementos
        panelPrincipal.add(panelCodigo);
        panelPrincipal.add(panelBoton);

        // Agregar el panel principal a la ventana
        add(panelPrincipal, BorderLayout.CENTER);
    }

    private void verificarCodigo() {
        String codigo = txtCodigo.getText();
        String[] datosUsuario = verificarCodigoEnArchivo(codigo);
        if (datosUsuario != null) {
            new frmInfoEstudiantes(datosUsuario).setVisible(true);
            this.dispose(); // Cierra la ventana actual
        } else {
            JOptionPane.showMessageDialog(this, "Código incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String[] verificarCodigoEnArchivo(String codigo) {
        try (BufferedReader br = new BufferedReader(new FileReader("codigosEstudiantes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length > 5 && datos[5].equals(codigo)) {
                    return datos; // Retorna todos los datos del usuario
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
