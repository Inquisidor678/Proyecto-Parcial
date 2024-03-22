import javax.swing.*;
import java.awt.*;

public class frmInfoEstudiantes extends JFrame {

    public frmInfoEstudiantes(String[] datosUsuario) {
        setTitle("Información del Estudiante");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        getContentPane().setBackground(new Color(235, 235, 235)); // Color de fondo

        // Asumiendo que datosUsuario contiene nombre en [1] y apellido en [2]
        String nombreCompleto = datosUsuario[1] + " " + datosUsuario[2];
        JLabel lblBienvenida = new JLabel("Bienvenido, " + nombreCompleto);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 16)); // Estilo del texto
        add(lblBienvenida);
    }
}

