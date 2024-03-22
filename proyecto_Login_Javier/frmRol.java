import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frmRol extends JFrame {

    public frmRol() {
        setTitle("Seleccionar Rol");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Etiqueta de bienvenida
        JLabel lblBienvenido = new JLabel("Bienvenido, por favor selecciona tu rol", SwingConstants.CENTER);
        lblBienvenido.setFont(new Font("Arial", Font.BOLD, 20));
        lblBienvenido.setForeground(new Color(78, 52, 46, 255)); // Color del texto
        lblBienvenido.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Margen superior e inferior

        // Panel principal con diseño de fondo
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(255, 255, 255)); // Fondo blanco

        // Botón para Profesor
        JButton btnProfesor = new JButton("Profesor");
        btnProfesor.setFont(new Font("Arial", Font.BOLD, 16));
        btnProfesor.setBackground(new Color(102, 204, 255)); // Color azul claro
        btnProfesor.setForeground(Color.WHITE); // Texto en blanco
        btnProfesor.setFocusPainted(false);
        btnProfesor.addActionListener(e -> {
            new inicio().setVisible(true); // Redirige al frmInicio
            frmRol.this.dispose(); // Cierra frmRol
        });

        // Botón para Estudiante
        JButton btnEstudiante = new JButton("Estudiante");
        btnEstudiante.setFont(new Font("Arial", Font.BOLD, 16));
        btnEstudiante.setBackground(new Color(255, 153, 153)); // Color rojo claro
        btnEstudiante.setForeground(Color.WHITE); // Texto en blanco
        btnEstudiante.setFocusPainted(false);
        btnEstudiante.addActionListener(e -> {
            new frmEstudiantes().setVisible(true); // Redirige al frmEstudiantes
            frmRol.this.dispose(); // Cierra frmRol
        });

        // Agregar botones al panel principal
        mainPanel.add(btnProfesor);
        mainPanel.add(btnEstudiante);

        // Agregar la etiqueta de bienvenida y el panel principal a la ventana
        add(lblBienvenido, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new frmRol().setVisible(true);
            }
        });
    }
}






