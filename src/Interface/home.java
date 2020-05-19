package Interface;

import Logica.DBventasIC;
import datos.Usuario;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

public class home extends javax.swing.JFrame {
    DBventasIC bd = new DBventasIC();
    
    public home() {
        initComponents();
        this.cargarIconos();
        this.setLocationRelativeTo(null);
        timer.start();
        bd.Conectar();
    }
    public home(Usuario user){
        initComponents();
        this.cargarIconos();
        this.setLocationRelativeTo(null);
        timer.start();
        bd.Conectar();
        txtUsuario.setText(user.getNombre());
    }
    
    Timer timer = new Timer(1000, new ActionListener(){
       public void actionPerformed(ActionEvent e){
           Calendar cal = new GregorianCalendar();
           int hh, mm, ss, dia, mes, anio;
           String tt;
           hh = cal.get(Calendar.HOUR);
           mm = cal.get(Calendar.MINUTE);
           ss = cal.get(Calendar.SECOND);
           dia = cal.get(Calendar.DAY_OF_MONTH);
           mes = cal.get(Calendar.MONTH);
           anio = cal.get(Calendar.YEAR);
           int ampm = cal.get(Calendar.AM_PM);
           if( ampm == 1){ tt = "PM"; } else { tt="AM"; }
           hora.setText(hh+":"+mm+":"+ss+" "+tt);
           fecha.setText(dia+" / "+(mes+1)+" / "+anio);
       } 
    });

    
    
    public void cargarIconos(){
        ImageIcon  imgInicio = new ImageIcon(getClass().getResource("/Imagenes/home.png"));
        Icon icInicio = new ImageIcon(imgInicio.getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT));
        btnlogo.setIcon(icInicio);
        
        ImageIcon  imgVenta = new ImageIcon(getClass().getResource("/Imagenes/icons8_get_cash_50px.png"));
        Icon icVenta = new ImageIcon(imgVenta.getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT));
        btnVenta.setIcon(icVenta);
        
        ImageIcon  imgProductos = new ImageIcon(getClass().getResource("/Imagenes/productos.png"));
        Icon icProductos = new ImageIcon(imgProductos.getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT));
        btnProductos.setIcon(icProductos);
        
        ImageIcon  imgProveedores = new ImageIcon(getClass().getResource("/Imagenes/proveedores.png"));
        Icon icProveedores = new ImageIcon(imgProveedores.getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT));
        btnProveedores.setIcon(icProveedores);
        
        ImageIcon  imgReportes = new ImageIcon(getClass().getResource("/Imagenes/reporte.png"));
        Icon icReportes = new ImageIcon(imgReportes.getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT));
        btnReportes.setIcon(icReportes);
        
        ImageIcon  logo = new ImageIcon(getClass().getResource("/Imagenes/logo-large.png"));
        Icon logoic = new ImageIcon(logo.getImage().getScaledInstance(logo.getIconWidth()/9,logo.getIconHeight()/9, Image.SCALE_DEFAULT));
        btnlogo.setIcon(logoic);
    }

    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SidePanel = new javax.swing.JPanel();
        btnlogo = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        dpnEscritorio = new javax.swing.JDesktopPane();
        menu = new javax.swing.JMenuBar();
        mConsultas = new javax.swing.JMenu();
        itemReportes = new javax.swing.JMenuItem();
        itemDetalleFact = new javax.swing.JMenuItem();
        itemDetalleRec = new javax.swing.JMenuItem();
        mBD = new javax.swing.JMenu();
        itemBD = new javax.swing.JMenuItem();
        mHerramientas = new javax.swing.JMenu();
        itemUsuarios = new javax.swing.JMenuItem();
        itemInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema IC");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));

        SidePanel.setBackground(new java.awt.Color(224, 224, 251));
        SidePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Source Sans Pro", 0, 12))); // NOI18N
        SidePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnlogo.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        btnlogo.setBorder(null);
        btnlogo.setBorderPainted(false);
        btnlogo.setContentAreaFilled(false);
        btnlogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnlogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnVenta.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        btnVenta.setText("Venta");
        btnVenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        btnProductos.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnProveedores.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        btnProveedores.setText("Proveedores");
        btnProveedores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnReportes.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        lblUsuario.setText("Usuario:");

        lblFecha.setText("Fecha:");
        lblFecha.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHora.setText("Hora:");
        lblHora.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblHora.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        fecha.setText("jLabel2");

        hora.setText("jLabel3");

        txtUsuario.setEditable(false);
        txtUsuario.setBackground(new java.awt.Color(224, 224, 251));
        txtUsuario.setFont(new java.awt.Font("Noto Serif Light", 2, 14)); // NOI18N
        txtUsuario.setBorder(null);

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha)
                    .addComponent(hora)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(fecha))
                .addGap(6, 6, 6)
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHora)
                    .addComponent(hora)))
        );

        javax.swing.GroupLayout dpnEscritorioLayout = new javax.swing.GroupLayout(dpnEscritorio);
        dpnEscritorio.setLayout(dpnEscritorioLayout);
        dpnEscritorioLayout.setHorizontalGroup(
            dpnEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        dpnEscritorioLayout.setVerticalGroup(
            dpnEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        mConsultas.setText("Consultas");

        itemReportes.setText("Reportes");
        mConsultas.add(itemReportes);

        itemDetalleFact.setText("Detalle de facturas");
        mConsultas.add(itemDetalleFact);

        itemDetalleRec.setText("Detalle de recibos");
        mConsultas.add(itemDetalleRec);

        menu.add(mConsultas);

        mBD.setText("Base de datos");

        itemBD.setText("Respaldar / Restaurar BD");
        mBD.add(itemBD);

        menu.add(mBD);

        mHerramientas.setText("Herramientas");

        itemUsuarios.setText("Usuarios");
        itemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUsuariosActionPerformed(evt);
            }
        });
        mHerramientas.add(itemUsuarios);

        itemInfo.setText("Info.");
        mHerramientas.add(itemInfo);

        menu.add(mHerramientas);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpnEscritorio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dpnEscritorio)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUsuariosActionPerformed
        frmUsuario misUsuarios = new frmUsuario();
        dpnEscritorio.add(misUsuarios);
        misUsuarios.setVisible(true);
                
    }//GEN-LAST:event_itemUsuariosActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
         frmProductos misProductos = new frmProductos();
         dpnEscritorio.add(misProductos);
         misProductos.setVisible(true);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        frmProveedores misProveedores = new frmProveedores();
         dpnEscritorio.add(misProveedores);
         misProveedores.setVisible(true);
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        frmVentas misVentas = new frmVentas();
         dpnEscritorio.add(misVentas);
         misVentas.setVisible(true);
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
         frmReportes misReportes = new frmReportes();
         dpnEscritorio.add(misReportes);
         misReportes.setVisible(true);
    }//GEN-LAST:event_btnReportesActionPerformed

    
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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnVenta;
    private javax.swing.JButton btnlogo;
    private javax.swing.JDesktopPane dpnEscritorio;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel hora;
    private javax.swing.JMenuItem itemBD;
    private javax.swing.JMenuItem itemDetalleFact;
    private javax.swing.JMenuItem itemDetalleRec;
    private javax.swing.JMenuItem itemInfo;
    private javax.swing.JMenuItem itemReportes;
    private javax.swing.JMenuItem itemUsuarios;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu mBD;
    private javax.swing.JMenu mConsultas;
    private javax.swing.JMenu mHerramientas;
    private javax.swing.JMenuBar menu;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
