import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

class FrmRegistrar extends JFrame {

    private JComboBox<String> cmbOcupacion;
    private JTextField txtDocumento, txtNombre, txtApellidos, txtEdad;
    private JPasswordField pwdContraseña, pwdVerificar;

    public FrmRegistrar() {
        setTitle("Registrar Usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 10, 10));
        getContentPane().setBackground(new Color(235, 235, 235)); // Color de fondo
        setSize(new Dimension(400, 400));

        // Panel para los campos de entrada
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(235, 235, 235)); // Color de fondo del panel

        // Campos para el registro de usuarios
        panel.add(new JLabel("Número de Documento:"));
        txtDocumento = new JTextField();
        panel.add(txtDocumento);

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        panel.add(txtApellidos);

        panel.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panel.add(txtEdad);

        panel.add(new JLabel("Contraseña:"));
        pwdContraseña = new JPasswordField();
        panel.add(pwdContraseña);

        panel.add(new JLabel("Verificar Contraseña:"));
        pwdVerificar = new JPasswordField();
        panel.add(pwdVerificar);

        panel.add(new JLabel("Ocupación:"));
        cmbOcupacion = new JComboBox<>(new String[]{"Profesor", "Estudiante"});
        panel.add(cmbOcupacion);

        // Botón para registrar
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBackground(new Color(152, 251, 152)); // Color del botón
        btnRegistrar.addActionListener(e -> registrarUsuario());

        add(panel, BorderLayout.CENTER);
        add(btnRegistrar, BorderLayout.SOUTH);
    }

    private void registrarUsuario() {
        String documento = txtDocumento.getText();
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String edad = txtEdad.getText();
        String contraseña = new String(pwdContraseña.getPassword());
        String verificar = new String(pwdVerificar.getPassword());
        String ocupacion = (String) cmbOcupacion.getSelectedItem();

        if (contraseña.equals(verificar)) {
            String codigoID = generarCodigoID();
            if ("Profesor".equals(ocupacion)) {
                guardarEnArchivo("usuarios.txt", documento, nombre, apellidos, edad, contraseña, codigoID);
            } else {
                guardarEnArchivo("codigosEstudiantes.txt", documento, nombre, apellidos, edad, contraseña, codigoID);
            }
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String generarCodigoID() {
        Random rnd = new Random();
        int numero = rnd.nextInt(90000) + 10000; // Genera un número entre 10000 y 99999
        return String.valueOf(numero);
    }

    private void guardarEnArchivo(String nombreArchivo, String... datos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            for (String dato : datos) {
                bw.write(dato + ",");
            }
            bw.write(";"); // Separador de usuarios
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void limpiarCampos() {
        txtDocumento.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtEdad.setText("");
        pwdContraseña.setText("");
        pwdVerificar.setText("");
        cmbOcupacion.setSelectedIndex(0);
    }
}







