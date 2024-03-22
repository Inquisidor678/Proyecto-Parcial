import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

class FrmListar extends JFrame {
    public FrmListar() {
        setTitle("Lista de Usuarios");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Los nombres de las columnas ahora comienzan con "Código ID"
        String[] columnNames = {"Código ID", "Documento", "Nombre", "Apellido", "Edad", "Contraseña"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        cargarUsuarios(model);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void cargarUsuarios(DefaultTableModel model) {
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] usuarios = linea.split(";");
                for (String usuario : usuarios) {
                    if (!usuario.isEmpty()) {
                        String[] datos = usuario.split(",");
                        // Asegurarse de que hay 6 elementos en el array para evitar errores de índice
                        String[] datosCompletos = new String[6];
                        for (int i = 0; i < datos.length; i++) {
                            datosCompletos[i] = datos[i].isEmpty() ? "xxx" : datos[i];
                        }
                        // Reordenar los datos para que el código ID esté primero
                        String[] datosOrdenados = {
                                datosCompletos[5], // Código ID
                                datosCompletos[0], // Documento
                                datosCompletos[1], // Nombre
                                datosCompletos[2], // Apellido
                                datosCompletos[3], // Edad
                                datosCompletos[4]  // Contraseña
                        };
                        model.addRow(datosOrdenados);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


