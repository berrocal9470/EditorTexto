/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Negocio.Controlador;
import javax.swing.JOptionPane;

/**
 *
 * @author Berrocal
 */
public class Editor extends javax.swing.JFrame {
    
    //guarda la altura máxima (por defecto) del menu superior
    private final int ALTURA_MAX_MENU;
    //guarda la altura mínima del menu superior
    private final int ALTURA_MIN_MENU = 30;
    //guarda la altura máxima (por defecto) del text area página
    private final int ALTURA_MAX_PAGINA;
    //guarda la altura mínima del text area página
    private final int ALTURA_MIN_PAGINA;
    //guarda el ancho del text area página
    private final int ANCHO_PAGINA;
    
    private Controlador controlador;

    /**
     * Creates new form Editor
     */
    public Editor() {
        initComponents();
        
        ALTURA_MAX_MENU = tbPnlArchivo.getHeight();
        ALTURA_MIN_PAGINA = scrllPagina.getHeight();
        ALTURA_MAX_PAGINA = ALTURA_MIN_PAGINA + 
                (ALTURA_MAX_MENU - ALTURA_MIN_MENU);
        ANCHO_PAGINA = scrllPagina.getWidth();
        
        controlador = new Controlador();
        
        //¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡QUITAR ESTA LLAVE!!!!!!!!!!!!!!!
        //(ahorita la dejo puesta por pereza de estarla escribiendo xD )
        txtLlave.setText("kWmHe8xIsDpfzK4d");
    }
    
    //Sólo acepta llaves de 16 bytes (128 bits)
    private boolean validarLlave(String llave){
        if(llave.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese una llave en el campo de llave",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(llave.getBytes().length != 16){
            JOptionPane.showMessageDialog(this, "La llave no es de 128 bits",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void encriptar(String llave, String texto){
        if(validarLlave(llave)){
            String resultado = controlador.encriptar(llave, texto);
            txtPagina.setText(resultado);
        }
    }
    
    private void desencriptar(String llave, String texto){
        if(validarLlave(llave)){
            String resultado = controlador.desencriptar(llave, texto);
            txtPagina.setText(resultado);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbPnlArchivo = new javax.swing.JTabbedPane();
        pnlArchivo = new javax.swing.JPanel();
        btnUltimaPagina = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        scrllPagina = new javax.swing.JScrollPane();
        txtPagina = new javax.swing.JTextArea();
        pnlNavegacion = new javax.swing.JPanel();
        btnPaginaAnterior = new javax.swing.JButton();
        txtNumeroPagina = new javax.swing.JTextField();
        btnPaginaSiguiente = new javax.swing.JButton();
        txtLlave = new javax.swing.JTextField();
        btnDesencriptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbPnlArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbPnlArchivoMousePressed(evt);
            }
        });

        pnlArchivo.setBackground(new java.awt.Color(204, 204, 255));
        pnlArchivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnUltimaPagina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/icon-nuevo.png"))); // NOI18N
        btnUltimaPagina.setText("<html> <br/> Nueva <br/> página");
        btnUltimaPagina.setBorderPainted(false);
        btnUltimaPagina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUltimaPagina.setIconTextGap(-5);
        btnUltimaPagina.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnUltimaPagina.setPreferredSize(new java.awt.Dimension(59, 37));
        btnUltimaPagina.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnUltimaPagina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/icon-guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnGuardar.setMinimumSize(new java.awt.Dimension(59, 37));
        btnGuardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/icon-salir.png"))); // NOI18N
        btnSalir.setText("<html> Guardar y<br/> salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnSalir.setPreferredSize(new java.awt.Dimension(59, 37));
        btnSalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlArchivoLayout = new javax.swing.GroupLayout(pnlArchivo);
        pnlArchivo.setLayout(pnlArchivoLayout);
        pnlArchivoLayout.setHorizontalGroup(
            pnlArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArchivoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnUltimaPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(577, Short.MAX_VALUE))
        );
        pnlArchivoLayout.setVerticalGroup(
            pnlArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArchivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(btnUltimaPagina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tbPnlArchivo.addTab("Archivo", pnlArchivo);

        txtPagina.setColumns(20);
        txtPagina.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        txtPagina.setLineWrap(true);
        txtPagina.setRows(5);
        txtPagina.setWrapStyleWord(true);
        scrllPagina.setViewportView(txtPagina);

        pnlNavegacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnPaginaAnterior.setText("<");

        btnPaginaSiguiente.setText(">");

        btnDesencriptar.setText("Desencriptar");
        btnDesencriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesencriptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNavegacionLayout = new javax.swing.GroupLayout(pnlNavegacion);
        pnlNavegacion.setLayout(pnlNavegacionLayout);
        pnlNavegacionLayout.setHorizontalGroup(
            pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavegacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLlave)
                    .addGroup(pnlNavegacionLayout.createSequentialGroup()
                        .addComponent(btnPaginaAnterior)
                        .addGap(7, 7, 7)
                        .addComponent(txtNumeroPagina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPaginaSiguiente)))
                .addContainerGap())
            .addGroup(pnlNavegacionLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnDesencriptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNavegacionLayout.setVerticalGroup(
            pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavegacionLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPaginaAnterior)
                    .addComponent(txtNumeroPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPaginaSiguiente))
                .addGap(60, 60, 60)
                .addComponent(txtLlave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesencriptar)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbPnlArchivo)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlNavegacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(scrllPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbPnlArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrllPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlNavegacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbPnlArchivoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPnlArchivoMousePressed
        //Se cambia los tamaños de los componenetes
        
        if(tbPnlArchivo.getHeight() != 30){
            //"oculta" la barra de menu
            tbPnlArchivo.setSize(pnlArchivo.getWidth(), ALTURA_MIN_MENU);
            
            //agranda el espacio para escribir
            scrllPagina.setBounds(scrllPagina.getX(), tbPnlArchivo.getHeight()+5, 
                    ANCHO_PAGINA, ALTURA_MAX_PAGINA);
        }else{
            //"muestra" de nuevo la barra de menu
            tbPnlArchivo.setSize(pnlArchivo.getWidth(), ALTURA_MAX_MENU);
            
            //reajusta el espacio para escribir
            scrllPagina.setBounds(scrllPagina.getX(), tbPnlArchivo.getHeight()+5, 
                    ANCHO_PAGINA, ALTURA_MIN_PAGINA);
        }
        
        // mueve el panel de navegacion
        pnlNavegacion.setBounds(pnlNavegacion.getX(), tbPnlArchivo.getHeight()+5,
                pnlNavegacion.getWidth(), pnlNavegacion.getHeight());
        
        //cambia el tamaño de acuerdo al scroll
        txtPagina.setSize(txtPagina.getWidth(), scrllPagina.getHeight());
        //posiciona la barra vertical al final (si está visible)
        txtPagina.setCaretPosition(txtPagina.getDocument().getLength());
        //activa el cursor para escribir
        txtPagina.requestFocus();
    }//GEN-LAST:event_tbPnlArchivoMousePressed
	
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        encriptar(txtLlave.getText(), txtPagina.getText());
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnDesencriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesencriptarActionPerformed
        desencriptar(txtLlave.getText(), txtPagina.getText());
    }//GEN-LAST:event_btnDesencriptarActionPerformed

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
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesencriptar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPaginaAnterior;
    private javax.swing.JButton btnPaginaSiguiente;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUltimaPagina;
    private javax.swing.JPanel pnlArchivo;
    private javax.swing.JPanel pnlNavegacion;
    private javax.swing.JScrollPane scrllPagina;
    private javax.swing.JTabbedPane tbPnlArchivo;
    private javax.swing.JTextField txtLlave;
    private javax.swing.JTextField txtNumeroPagina;
    private javax.swing.JTextArea txtPagina;
    // End of variables declaration//GEN-END:variables
}
