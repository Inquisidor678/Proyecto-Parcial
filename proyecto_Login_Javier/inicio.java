import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class inicio extends JFrame {
    private static boolean validarUsuario(String usuario, String password) {
        boolean esValido = false;
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] credenciales = linea.split(";");
                for (String credencial : credenciales) {
                    String[] partes = credencial.split(",");
                    if (partes[1].equals(usuario) && partes[4].equals(password)) {
                        esValido = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return esValido;
    }

    private static void registrarIngreso(String usuario) {
        String timestamp = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
        String registro = timestamp + " - " + usuario;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("login.log", true))) {
            bw.write(registro);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public inicio() {
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(350, 200));

        UIManager.put("Button.background", Color.LIGHT_GRAY);
        UIManager.put("Panel.background", Color.WHITE);

        JPanel loginPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        loginPanel.add(new JLabel("Usuario:"));
        JTextField userField = new JTextField();
        loginPanel.add(userField);
        loginPanel.add(new JLabel("Clave:"));
        JPasswordField passwordField = new JPasswordField();
        loginPanel.add(passwordField);
        frame.add(loginPanel, BorderLayout.CENTER);


        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = userField.getText();
                String password = new String(passwordField.getPassword());
                if (validarUsuario(usuario, password)) {
                    registrarIngreso(usuario);
                    frame.dispose(); // Cerrar la ventana actual
                    new frmInicio().setVisible(true); // Mostrar FrmInicio
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuario o clave incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }
}



