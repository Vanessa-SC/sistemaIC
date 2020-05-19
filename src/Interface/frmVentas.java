package Interface;

import Datos.ArticuloVenta;
import Datos.Venta;
import Logica.DBventasIC;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmVentas extends javax.swing.JInternalFrame {

    DBventasIC db = new DBventasIC();
    DefaultTableModel modelo = new DefaultTableModel();

    public frmVentas() {
        initComponents();
        cargar();
    }

    public void cargar() {
        txtPrecio.setEditable(false);
        ID_Articulo.setEditable(false);
        ID_Venta.setEditable(false);
        this.tablaCompra.setModel(modelo);
        db.cargarClaves(cbClaveCom);
        //db.cargarCantidades(cbCant);
        this.modelo.addColumn("CLAVE");
        this.modelo.addColumn("DESCRIPCION");
        this.modelo.addColumn("PRECIO UNITARIO");
        this.modelo.addColumn("CANTIDAD");
        this.modelo.addColumn("TOTAL");

        btnPagar.setVisible(false);
        btnNuevaVenta.setEnabled(false);
        btnQuitarCompra.setEnabled(false);
        btnTerminarVenta.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCompra = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTotalProd = new javax.swing.JTextField();
        btnCompra = new javax.swing.JButton();
        cbClaveCom = new javax.swing.JComboBox<>();
        SpinnerCant = new javax.swing.JSpinner();
        btnQuitarCompra = new javax.swing.JButton();
        btnNuevaVenta = new javax.swing.JButton();
        btnTerminarVenta = new javax.swing.JButton();
        ID_Articulo = new javax.swing.JTextField();
        ID_Venta = new javax.swing.JTextField();
        txtTotalVenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel2.setBackground(new java.awt.Color(252, 252, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles de la compra", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tablaCompra.setBackground(new java.awt.Color(252, 252, 255));
        tablaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCompra);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        jPanel1.setBackground(new java.awt.Color(252, 252, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Realizar compra", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setText("Clave del producto:");

        jLabel3.setText("Cantidad:");

        jLabel4.setText("Precio: $");

        jLabel5.setText("Total: $");

        txtTotalProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalProdActionPerformed(evt);
            }
        });

        btnCompra.setText("Agregar");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        cbClaveCom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbClaveComItemStateChanged(evt);
            }
        });
        cbClaveCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClaveComActionPerformed(evt);
            }
        });

        SpinnerCant.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
        SpinnerCant.setMaximumSize(new java.awt.Dimension(99, 99));
        SpinnerCant.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinnerCantStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbClaveCom, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SpinnerCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbClaveCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(SpinnerCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnCompra)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        btnQuitarCompra.setText("Quitar producto");
        btnQuitarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarCompraActionPerformed(evt);
            }
        });

        btnNuevaVenta.setText("Nueva Venta");
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnTerminarVenta.setText("Terminar venta");
        btnTerminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarVentaActionPerformed(evt);
            }
        });

        txtTotalVenta.setText("0.00");

        jLabel6.setText("Total a pagar: $");

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnQuitarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                        .addGap(41, 41, 41))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnTerminarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(27, 27, 27)
                                        .addComponent(ID_Articulo))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(133, 133, 133)
                                        .addComponent(ID_Venta)))))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuitarCompra)
                            .addComponent(btnNuevaVenta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTerminarVenta)
                            .addComponent(ID_Articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ID_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalProdActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        if (cbClaveCom.getSelectedIndex() != 0) {
            if (!db.articuloYaExiste(cbClaveCom.getSelectedItem().toString(), tablaCompra)) {
                try {
                    //Comprobar si es nueva venta y obtener id
                    if (ID_Venta.getText().equals("")) {
                        Venta vta = new Venta(Float.parseFloat(txtTotalProd.getText()));
                        db.altaVenta(vta);
                        db.obtenerID_Venta(ID_Venta);
                        db.obtenerID_Articulo(cbClaveCom.getSelectedItem().toString(), ID_Articulo);
                        db.altaArticulo_Venta(Integer.parseInt(ID_Articulo.getText()), Integer.parseInt(ID_Venta.getText()), (Integer) SpinnerCant.getValue(), Float.parseFloat(txtTotalProd.getText()));
                        db.AgregarCompra(tablaCompra, Integer.parseInt(ID_Venta.getText()));
                        db.TotalVentas(tablaCompra, txtTotalVenta);
                        db.actualizarVenta(Float.parseFloat(txtTotalVenta.getText()), Integer.parseInt(ID_Venta.getText()));
                        btnQuitarCompra.setEnabled(true);
                        btnTerminarVenta.setEnabled(true);

                    } else {
                        //Obtener idArticulo
                        db.obtenerID_Articulo(cbClaveCom.getSelectedItem().toString(), ID_Articulo);
                        //Agregar articulo_venta
                        db.altaArticulo_Venta(Integer.parseInt(ID_Articulo.getText()), Integer.parseInt(ID_Venta.getText()), (Integer) SpinnerCant.getValue(), Float.parseFloat(txtTotalProd.getText()));
                        //Llenar tabla
                        db.AgregarCompra(tablaCompra, Integer.parseInt(ID_Venta.getText()));
                        db.TotalVentas(tablaCompra, txtTotalVenta);
                        db.actualizarVenta(Float.parseFloat(txtTotalVenta.getText()), Integer.parseInt(ID_Venta.getText()));
                        btnQuitarCompra.setEnabled(true);
                    }
                    //
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Primero seleccione una clave...");
        }
    }//GEN-LAST:event_btnCompraActionPerformed

    private void cbClaveComItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbClaveComItemStateChanged
        txtTotalProd.setText("");
        SpinnerCant.setValue(0);
    }//GEN-LAST:event_cbClaveComItemStateChanged

    private void cbClaveComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClaveComActionPerformed
        // Metodo para buscar precio
        db.ObtenerPrecio(cbClaveCom, txtPrecio);
        SpinnerCant.setValue(1);
    }//GEN-LAST:event_cbClaveComActionPerformed

    private void SpinnerCantStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinnerCantStateChanged
        if (!txtPrecio.getText().equals("")) {
            db.ObtenerTotalProd(txtPrecio, txtTotalProd, SpinnerCant);
        }

    }//GEN-LAST:event_SpinnerCantStateChanged

    private void btnQuitarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarCompraActionPerformed
        try {
            if (tablaCompra.getSelectedRow() > -1) {
                if (!txtTotalVenta.getText().equals("")) {
                    txtTotalVenta.setText("");
                }
                ArticuloVenta artVta = new ArticuloVenta(Integer.parseInt(ID_Articulo.getText()), Integer.parseInt(ID_Venta.getText()));
                db.bajaArticuloVenta(artVta, tablaCompra);
                db.TotalVentas(tablaCompra, txtTotalVenta);
                db.actualizarVenta(Float.parseFloat(txtTotalVenta.getText()), Integer.parseInt(ID_Venta.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione primero la fila del producto a quitar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnQuitarCompraActionPerformed

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        db.cargarClaves(cbClaveCom);
        SpinnerCant.setValue(1);
        txtPrecio.setText("");
        txtTotalProd.setText("");
        txtTotalVenta.setText("");
        ID_Venta.setText("");
        ID_Articulo.setText("");
        db.limpiarTabla(tablaCompra);
        btnCompra.setEnabled(true);
        btnTerminarVenta.setEnabled(false);
        btnNuevaVenta.setEnabled(false);
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void btnTerminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarVentaActionPerformed
        db.TotalVentas(tablaCompra, txtTotalVenta);
        db.actualizarVenta(Float.parseFloat(txtTotalVenta.getText()), Integer.parseInt(ID_Venta.getText()));
        btnPagar.setVisible(true);
        btnCompra.setEnabled(false);
        btnQuitarCompra.setEnabled(false);
        btnNuevaVenta.setEnabled(true);
    }//GEN-LAST:event_btnTerminarVentaActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        float pago = Float.parseFloat(JOptionPane.showInputDialog(this, "Cantidad pagada: "));
        float cambio = pago - (Float.parseFloat(txtTotalVenta.getText()));
        JOptionPane.showMessageDialog(this, "Su cambio es: $" + cambio);
    }//GEN-LAST:event_btnPagarActionPerformed

    private void tablaCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCompraMouseClicked
        int fila = tablaCompra.getSelectedRow();
        if (fila > -1) {
            String clave = tablaCompra.getValueAt(fila, 0).toString();
            db.obtenerID_Articulo(clave, ID_Articulo);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tablaCompraMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID_Articulo;
    private javax.swing.JTextField ID_Venta;
    private javax.swing.JSpinner SpinnerCant;
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnQuitarCompra;
    private javax.swing.JButton btnTerminarVenta;
    private javax.swing.JComboBox<String> cbClaveCom;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCompra;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotalProd;
    private javax.swing.JTextField txtTotalVenta;
    // End of variables declaration//GEN-END:variables
}
