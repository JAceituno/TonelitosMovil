/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tonelitosmovil;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author rick
 */
public class Tonelitos extends javax.swing.JFrame {

    /**
     * Creates new form Tonelitos
     */
    public Tonelitos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jd_relations = new javax.swing.JDialog();
        jb_addImage = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jp_graphics = new javax.swing.JPanel();
        jl_image = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jd_relationsLayout = new javax.swing.GroupLayout(jd_relations.getContentPane());
        jd_relations.getContentPane().setLayout(jd_relationsLayout);
        jd_relationsLayout.setHorizontalGroup(
            jd_relationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jd_relationsLayout.setVerticalGroup(
            jd_relationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jb_addImage.setText("Add Image");
        jb_addImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_addImageActionPerformed(evt);
            }
        });

        jButton1.setText("Exportar Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jp_graphics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp_graphicsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jp_graphicsLayout = new javax.swing.GroupLayout(jp_graphics);
        jp_graphics.setLayout(jp_graphicsLayout);
        jp_graphicsLayout.setHorizontalGroup(
            jp_graphicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_graphicsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp_graphicsLayout.setVerticalGroup(
            jp_graphicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_graphicsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setText("Add Relation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jButton2)
                .addGap(113, 113, 113)
                .addComponent(jb_addImage)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(275, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_graphics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_graphics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_addImage)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_addImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_addImageActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes", "jpg", "png", "bmp", "mpg", "ico");
        chooser.setFileFilter(filter);
        ImageIcon icon;
        File imagen;

        int Okoption;
        
        Okoption = chooser.showOpenDialog(this);
        
        if (Okoption == JFileChooser.APPROVE_OPTION){
            imagen = chooser.getSelectedFile();
            icon = new ImageIcon(imagen.getAbsolutePath());
            
            int imgHeight = jl_image.getHeight();
            int imgWidth = jl_image.getWidth();
            
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(imgWidth, imgHeight, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImg);
            jl_image.setIcon(icon);
        }
    }//GEN-LAST:event_jb_addImageActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        File archivo = new File("./reporte.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
           for (int i = 0; i < contadorNodos; i++) {
                bw.write(grafo.getNodos().elementAt(i) + "\n");
                if (i == contadorNodos - 1) {
                   bw.write("Aristras: \n");
               }
                for (int j = 0; j < grafo.getNodos().elementAt(i).getAristas().size(); j++) {
                  bw.write( grafo.getNodos().elementAt(i).getAristas().elementAt(j) + "\n");
                    if (j == grafo.getNodos().elementAt(i).getAristas().size() -1) {
                        bw.write("Caminos: \n");
                    }
                    for (int k = 0; k < grafo.getNodos().elementAt(i).getDijkstraPath().size(); k++) {
                        if (k == 0) {
                          bw.write("Dijkstra");
                        }
                        bw.write(grafo.getNodos().elementAt(i).getDijkstraPath().elementAt(k) + "\n");
                    }
                    // falta floyd aqui
                    
               }
               
            }
            bw.flush();
        } catch (Exception e) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jp_graphicsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_graphicsMouseClicked

        int x = evt.getX();
        int y = evt.getY();
        if (evt.isMetaDown()){
            // draw.clearRect(x-10, y-10, 60, 60); no
            
        }else{
            
            /*
            
            // incluir todo esto en el metodo refresh()
            draw.setColor(red);
            draw.drawOval(x-10, y-10, 25, 25);
            draw.fillOval(x-10, y-10, 25, 25);
            */
            grafo.getNodos().push_back(new Node());
            grafo.getNodos().elementAt(contadorNodos).setCoordenada(new Coordenada (x-10,y-10));
        }
        
        
    }//GEN-LAST:event_jp_graphicsMouseClicked

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
            java.util.logging.Logger.getLogger(Tonelitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tonelitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tonelitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tonelitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tonelitos().setVisible(true);
            }
        });
    }
    
    public void refresh(){
        // refresh the label and the panel
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jb_addImage;
    private javax.swing.JDialog jd_relations;
    private javax.swing.JLabel jl_image;
    private javax.swing.JPanel jp_graphics;
    // End of variables declaration//GEN-END:variables
    private Color red = Color.RED;
    private Grafo grafo = new Grafo ();
    private int contadorNodos = 0;

}
