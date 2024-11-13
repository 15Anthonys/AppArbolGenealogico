/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package arboles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author dugla
 */
public class CargarJSON extends javax.swing.JFrame {

    /**
     * Creates new form Pestana
     */
    public CargarJSON() {
        initComponents();
        setLocationRelativeTo(null);
        BSiguienteVentana.setEnabled(false);
        MostrarJSON.setEditable(false);
    }
    
    private static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndex = name.lastIndexOf('.');
        if (lastIndex == -1) {
            return "";
        }
        return name.substring(lastIndex + 1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MostrarJSON = new javax.swing.JTextArea();
        BCargarJSON = new javax.swing.JButton();
        BSiguienteVentana = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Bienvenido a tu cargador de archivos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        MostrarJSON.setColumns(20);
        MostrarJSON.setRows(5);
        jScrollPane1.setViewportView(MostrarJSON);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 610, 250));

        BCargarJSON.setText("Cargar Archivo JSON");
        BCargarJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCargarJSONActionPerformed(evt);
            }
        });
        jPanel1.add(BCargarJSON, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        BSiguienteVentana.setText("Siguiente");
        BSiguienteVentana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSiguienteVentanaActionPerformed(evt);
            }
        });
        jPanel1.add(BSiguienteVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BCargarJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCargarJSONActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileFilter(new FileFilter() {
            
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                }
                String extension = getFileExtension(file);
                return extension.equals("json");
            }

            
            public String getDescription() {
                return "Archivos JSON (*.json)";
            }
        });
        
        
        int result = fileChooser.showOpenDialog(rootPane);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String extension = getFileExtension(selectedFile);
            if (!extension.equals("json")) {
                JOptionPane.showMessageDialog(rootPane,
                        "Archivo no válido. Por favor, selecciona un archivo JSON.",
                        "Error de tipo de archivo",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                    StringBuilder jsonContent = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        jsonContent.append(line).append("\n"); 
                    }
                    JOptionPane.showMessageDialog(rootPane, "Archivo seleccionado correctamente");
                    BSiguienteVentana.setEnabled(true); 
                    MostrarJSON.setText(jsonContent.toString()); 
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(rootPane, 
                            "Error al leer el archivo: " + e.getMessage(),
                            "Error de lectura",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_BCargarJSONActionPerformed

    private void BSiguienteVentanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSiguienteVentanaActionPerformed
        // TODO add your handling code here:
        String guardarArbol = MostrarJSON.getText();
        
    }//GEN-LAST:event_BSiguienteVentanaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CargarJSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarJSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarJSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarJSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarJSON().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCargarJSON;
    private javax.swing.JButton BSiguienteVentana;
    private javax.swing.JTextArea MostrarJSON;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}