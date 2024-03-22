import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class frmInicio extends JFrame {
    public frmInicio() {
        setTitle("Inicio");
        setSize(400, 200); // Tamaño ajustado para mejor visualización
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Uso de BorderLayout para mejor distribución de componentes
        getContentPane().setBackground(new Color(255, 255, 255)); // Fondo blanco para un aspecto más limpio

        // Panel superior para el título
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(255, 255, 255));
        JLabel lblTitle = new JLabel("Sistema de Gestión Académica");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setForeground(new Color(0, 102, 204)); // Color de texto azul
        titlePanel.add(lblTitle);

        // Panel central para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 5, 5)); // GridLayout para organizar los botones
        buttonPanel.setBackground(new Color(255, 255, 255));

        JButton btnListar = new JButton("Listar Profesores");
        btnListar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnListar.setBackground(new Color(102, 178, 255)); // Botones con color azul claro
        btnListar.setForeground(Color.WHITE); // Texto en blanco
        btnListar.setFocusPainted(false); // Sin foco alrededor del texto del botón
        btnListar.addActionListener(e -> new FrmListar().setVisible(true));
        buttonPanel.add(btnListar);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnRegistrar.setBackground(new Color(102, 178, 255));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addActionListener(e -> new FrmRegistrar().setVisible(true));
        buttonPanel.add(btnRegistrar);

        // Agregar paneles al frame
        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}

