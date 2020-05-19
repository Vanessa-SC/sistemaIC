
package Logica;

import Datos.Articulo;
import Datos.ArticuloProveedor;
import Datos.ArticuloVenta;
import Datos.Proveedor;
import Datos.Venta;
import Interface.home;
import com.toedter.calendar.JDateChooser;
import datos.Usuario;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DBventasIC {
    Connection con = null;
    
    public DBventasIC ()
    {
        Conectar();
    }
    
    public void Conectar()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/sistemaic?user=root&password=");
            //JOptionPane.showMessageDialog(null, "¡CONECTADO!");
        } catch (ClassNotFoundException cnfe){
            System.out.println(cnfe.getMessage());
        }
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void Desconectar()
    {
        try
        {
            if(con!=null)
            {
                con.close();
                JOptionPane.showMessageDialog(null, "¡Desconectado!");
            }
            con=null;
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void crearTablaUsuario()
    {
        String sentencia = "CREATE TABLE usuario("
                + "idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "usuario VARCHAR(70) NOT NULL,"
                + "nombre VARCHAR(14) NOT NULL,"
                + "contrasena VARCHAR(45) NOT NULL,"
                + "tipo INT NOT NULL "
                + ") ENGINE=InnoDB ";
       try
       {
        	Statement stm = con.createStatement();
        	stm.executeUpdate(sentencia);
        	System.out.println("Tabla creada");
       } catch (SQLException sqle)
       {
        	System.out.println(sqle.getMessage());
        	sqle.printStackTrace();
       }
    }
    
    public void crearTablaArticulo()
    {
        String sentencia = "CREATE TABLE articulo("
                + "idArticulo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "clave VARCHAR(14) NOT NULL,"
                + "nombre VARCHAR(45) NOT NULL,"
                + "descripcion VARCHAR(70) NOT NULL,"
                + "marca VARCHAR(45)"
                + "stock int NOT NULL,"
                + ") ENGINE=InnoDB ";
       try
       {
        	Statement stm = con.createStatement();
        	stm.executeUpdate(sentencia);
        	System.out.println("Tabla creada");
       } catch (SQLException sqle)
       {
        	System.out.println(sqle.getMessage());
        	sqle.printStackTrace();
       }
    }
    
    public void crearTablaProveedor()
    {
    	try
    	{
    		PreparedStatement ps = con.prepareStatement("CREATE TABLE proveedor("
    				+ "idProveedor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
    				+ "nombre VARCHAR(45) NOT NULL,"
    				+ "telefono VARCHAR(14) NOT NULL,"
    				+ "direccion VARCHAR(75) NOT NULL,"
    				+ "email VARCHAR(60) NOT NULL"
    				+ ") ENGINE=InnoDB ");
    		ps.executeUpdate();
    		 System.out.println("Tabla creada");
    	} catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void crearTablaVenta()
    {
    	try
    	{
    		PreparedStatement ps = con.prepareStatement("CREATE TABLE venta("
    				+ "idVenta INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
    				+ "fecha DATE NOT NULL,"
    				+ "hora TIME NOT NULL,"
    				+ "totalVenta FLOAT NOT NULL"
    				+ ")engine=innoDB;");
    		ps.executeUpdate();
    		System.out.println("Tabla creada");
    	} catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void crearTablaArticuloVenta()
    {
    	try
    	{
    		PreparedStatement ps = con.prepareStatement("CREATE TABLE articulo_venta("
    				+"idArticulo INT NOT NULL," 
    				+"idVenta INT NOT NULL "
    				+")engine=innoDB;");
    		ps.executeUpdate();
    		System.out.println("Tabla creada");
    	} catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }

    public void crearTablaArticuloProveedor()
    {
    	try
    	{
    		PreparedStatement ps = con.prepareStatement("CREATE TABLE articulo_proveedor("
    				+"idArticulo INT NOT NULL," 
    				+"idProveedor INT NOT NULL "
    				+")engine=innoDB;");
    		ps.executeUpdate();
    		System.out.println("Tabla creada");
    	} catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }

    public void altaArticulo(Articulo a) 
    {
    	try
    	{
    		PreparedStatement ps = con.prepareStatement("INSERT INTO articulo VALUES(?,?,?,?,?,?)");
    		ps.setInt(1, a.getId());
                ps.setString(2, a.getClave());
    		ps.setString(3, a.getNombre());
    		ps.setString(4, a.getDescripcion());
    		ps.setString(5, a.getMarca());
                ps.setFloat(6, a.getPrecio());
    		int filasAfectadas = ps.executeUpdate();
    		if (filasAfectadas > 0)
                {
                    JOptionPane.showMessageDialog(null, "Artículo registrado correctamente.");
                } else 
                    {
                        JOptionPane.showMessageDialog(null, "Error al registrar artículo.");
                    }
    	}catch(SQLException sqle)
            {
                    System.out.println(sqle.getMessage());
                    sqle.printStackTrace();
            }
    }
    
    public void altaProveedor(Proveedor p) 
    {
    	try
    	{
    		PreparedStatement ps = con.prepareStatement("INSERT INTO proveedor (nombre,telefono,direccion,email) VALUES(?,?,?,?)");
    		ps.setString(1, p.getNombre());
    		ps.setString(2, p.getTelefono());
    		ps.setString(3, p.getDireccion());
    		ps.setString(4, p.getEmail());
    		int filasAfectadas = ps.executeUpdate();
    		if (filasAfectadas >0)
                {
                    JOptionPane.showMessageDialog(null, "Se ha agregado correctamente");
                } else
                {
                    JOptionPane.showMessageDialog(null, "No se ha podido agregar.");
                }
    		
    	}catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void altaVenta(Venta vta) 
    {
    	try
    	{
    		PreparedStatement ps = con.prepareStatement("INSERT INTO venta (fecha,hora,totalVenta) VALUES(?,?,?)");
    		ps.setString(1, vta.getFecha());
    		ps.setString(2, vta.getHora());
    		ps.setFloat(3, vta.getTotalVenta());
                vta.setFecha(vta.getFecha());
                vta.setTotalVenta(vta.getTotalVenta());
                int filasAfectadas = ps.executeUpdate();
    		//System.out.println("Filas afectadas: "+filasAfectadas);
    		
    	}catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void actualizarVenta(float totalVenta,int id) 
    {
    	try
    	{
    		PreparedStatement ps = con.prepareStatement("UPDATE venta SET totalVenta=? where idVenta=?");
    		ps.setFloat(1,totalVenta);
                ps.setInt(2, id);
                
                ps.executeUpdate();
    		
    	}catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void salidaStock(int idProd,int cant){
        try
    	{
    		PreparedStatement ps = con.prepareStatement("UPDATE producto SET stock=stock-? where idProducto=?");
    		ps.setInt(1,cant);
                ps.setInt(2, idProd);
                
                ps.executeUpdate();
    		
    	}catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void altaArticulo_Venta(int idArticulo, int idVenta,int cantidad,float totalProd)
    {
        try 
        {
        	PreparedStatement ps = con.prepareStatement("INSERT INTO articulo_venta VALUES ("+idArticulo+","+idVenta+","+cantidad+","+totalProd+")");
        	ps.executeUpdate();
                
        } catch(SQLException sqle)
        {
        	System.out.println(sqle.getMessage());
        	sqle.printStackTrace();
        }
    }
    
    public void altaArticulo_Proveedor()
    {
    	try 
        {
        	ArticuloProveedor ap = new ArticuloProveedor();
        	PreparedStatement ps = con.prepareStatement("INSERT INTO articulo_proveedor VALUES (?,?)");
        	ps.setInt(1, ap.getIdArticulo());
        	ps.setInt(2, ap.getIdProveedor());
        } catch(SQLException sqle)
        {
        	System.out.println(sqle.getMessage());
        	sqle.printStackTrace();
        }
    }
    
    public void bajaArticulo(String clave) 
    {
    	try
    	{
               PreparedStatement ps = con.prepareStatement("DELETE FROM articulo WHERE clave=?");
    		ps.setString(1, clave);
    		int filasAfectadas = ps.executeUpdate();
    		if(filasAfectadas>0){
                    JOptionPane.showMessageDialog(null, "Eliminado correctamente");
                } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar.");
                }
    	}catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void bajaProveedor(String nom) 
    {
    	try
    	{
               PreparedStatement ps = con.prepareStatement("DELETE FROM proveedor WHERE nombre=?");
                ps.setString(1, nom);
                
                int filasAfectadas=ps.executeUpdate();
    		if(filasAfectadas>0) {
                    JOptionPane.showMessageDialog(null, "Eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error!");
                }
    		
    	}catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void bajaVenta() 
    {
    	try
    	{
            Venta vta = new Venta();
            vta.solicitarId();
    		PreparedStatement ps = con.prepareStatement("DELETE FROM venta WHERE idVenta=? ");
    		ps.setInt(1, vta.getIdVenta());
    		int filasAfectadas = ps.executeUpdate();
    		//System.out.println("Filas afectadas: "+filasAfectadas);
    		
    	}catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }

    public void bajaArticuloVenta(ArticuloVenta artVta, JTable tabla) 
    {
    	try
    	{
            PreparedStatement ps = con.prepareStatement("DELETE FROM articulo_venta WHERE idArticulo=? AND idVenta=? ");
            ps.setInt(1, artVta.getIdArticulo());
            ps.setInt(2, artVta.getIdVenta());
    		int filasAfectadas = ps.executeUpdate();
    		//System.out.println("Filas afectadas: "+filasAfectadas);
    		if (filasAfectadas==1){
                    AgregarCompra(tabla, artVta.getIdVenta());
                }
    	}catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void bajaArticuloProveedor() 
    {
    	try
    	{
            Proveedor p = new Proveedor();
            Articulo a = new Articulo();
            a.solicitarID();
            p.solicitarID();
    		PreparedStatement ps = con.prepareStatement("DELETE FROM articulo_proveedor WHERE idArticulo=? AND idProveedor=? ");
    		ps.setInt(1, a.getId());
                ps.setInt(2, p.getId());
    		int filasAfectadas = ps.executeUpdate();
    		//System.out.println("Filas afectadas: "+filasAfectadas);
    		
    	}catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void bajaUsuario(String nom) 
    {
    	try
    	{
               PreparedStatement ps = con.prepareStatement("DELETE FROM usuario WHERE nombre='"+nom+"'");
    		int filasAfectadas = ps.executeUpdate();
    		if(filasAfectadas>0){
                    JOptionPane.showMessageDialog(null, "Eliminado correctamente.");
                }
    		
    	}catch(SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void modificarArticulo(Articulo a)
    {
        try
        {
            PreparedStatement ps = con.prepareStatement("UPDATE articulo SET nombre=?,descripcion=?,marca=?,precio=?,stock=(stock+?) WHERE clave=? ");
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getDescripcion());
            ps.setString(3, a.getMarca());
            ps.setFloat(4, a.getPrecio());
            ps.setInt(5, a.getCantidad());
            ps.setString(6, a.getClave());
            
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0)
                {
                    JOptionPane.showMessageDialog(null, "Artículo actualizado correctamente.");
                } else 
                    {
                        JOptionPane.showMessageDialog(null, "Error al modificar artículo.");
                    }        }catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }
    }
    
    public void modificarArticulo(JTextField id,JComboBox cl,JTextField nom,JTextField desc, JTextField marca, JTextField precio)
    {
        try
        {
            PreparedStatement ps = con.prepareStatement("UPDATE articulo SET clave="+cl+",nombre="+nom+",descripcion="+desc+",marca="+marca+",precio="+precio
                    + "WHERE idArticulo="+id);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0)
                {
                    JOptionPane.showMessageDialog(null, "Artículo actualizado correctamente.");
                } else 
                    {
                        JOptionPane.showMessageDialog(null, "Error al modificar artículo.");
                    }        }catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }
    }
    
    public void modificarProveedor(Proveedor p)
    {
        try
        {
            PreparedStatement ps = con.prepareStatement("UPDATE proveedor SET telefono=?,direccion=?,email=?"
                    + "WHERE nombre=?");
            ps.setString(1, p.getTelefono());
            ps.setString(2, p.getDireccion());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getNombre());
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0)
                {
                    JOptionPane.showMessageDialog(null, "Proveedor actualizado correctamente.");
                } else 
                    {
                        JOptionPane.showMessageDialog(null, "Error al modificar Proveedor.");
                    }
        }catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    public void modificarVenta()
    {
        try
        {
            Venta vta = new Venta();
            vta.solicitarId();
            vta.solicitarTotal();
            PreparedStatement ps = con.prepareStatement("UPDATE venta SET fecha=?,hora=?,totalVenta=? WHERE idVenta=?");
            ps.setString(1, vta.getFecha());
            ps.setString(2, vta.getHora());
            ps.setFloat(3, vta.getTotalVenta());
            ps.setInt(4, vta.getIdVenta());
            
            int filasAfectadas = ps.executeUpdate();
            //System.out.println("Numero de filas afectadas: "+filasAfectadas);
        }catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }
    }
    
    public void modificarUsuario(Usuario u,JTextField id)
    {
        try
        {
            
            PreparedStatement ps = con.prepareStatement("UPDATE usuario SET nombre=?,usuario=?,contrasena=?"
                    + "WHERE idUsuario=?");
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getUsuario());
            ps.setString(3, u.getContrasena());
            ps.setString(4, id.getText());
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0)
                {
                    JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
                } else 
                    {
                        JOptionPane.showMessageDialog(null, "Error al modificar usuario.");
                    }
        }catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }
    }
    
    public void buscarArticuloxC()
    {
    	ResultSet rs;
    	try
    	{
    		Articulo a = new Articulo();
    		a.solicitarClave();
    		PreparedStatement ps = con.prepareStatement("SELECT idArticulo,nombre,clave,descripcion,marca,precio FROM articulo WHERE clave LIKE ? ");
    		ps.setString(1, a.getClave());
    		rs = ps.executeQuery();
    		while(rs.next())
    		{
                System.out.println("ID: "+rs.getString("idArticulo"));
                System.out.println("Nombre: "+rs.getString("nombre"));
                System.out.println("Clave: "+rs.getString("clave"));
                System.out.println("Descripcion: "+rs.getString("descripcion"));
                System.out.println("Marca: "+rs.getString("marca"));
                System.out.println("Precio: $"+rs.getString("precio"));
    		}
    	}catch (SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void buscarArticuloEscribiendo(String texto, JTable tabla)
    {
        ResultSet rs;
        String sql="SELECT * FROM articulo WHERE clave LIKE '%"+texto+"%' ";
        try
        {
           PreparedStatement ps = con.prepareStatement(sql);
           rs = ps.executeQuery();

            String []fila = new String[5];
            DefaultTableModel modelo= new DefaultTableModel();
            tabla.setModel(modelo);
            modelo.addColumn("CLAVE"); 
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DESCRIPCION");
            modelo.addColumn("MARCA");
            modelo.addColumn("PRECIO");
           while (rs.next())
           {
               fila[0]=(rs.getString("clave"));
               fila[1]=(rs.getString("nombre"));
               fila[2]=(rs.getString("descripcion"));
               fila[3]=(rs.getString("marca"));
               fila[4]=(rs.getString("precio"));
               modelo.addRow(fila);
           }
        } catch(SQLException sqle)
            {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
            }
    }
    
    public void buscarProveedorEscribiendo(String texto, JTable tabla)
    {
        ResultSet rs;
        String sql="SELECT * FROM proveedor WHERE nombre LIKE '%"+texto+"%' ";
        try
        {
           PreparedStatement ps = con.prepareStatement(sql);
           rs = ps.executeQuery();

            String []fila = new String[4];
            DefaultTableModel modelo= new DefaultTableModel();
            tabla.setModel(modelo);
            modelo.addColumn("Nombre"); 
            modelo.addColumn("Telefono");
            modelo.addColumn("Direccion");
            modelo.addColumn("E-mail");
           while (rs.next())
           {
               fila[0]=(rs.getString("nombre"));
               fila[1]=(rs.getString("telefono"));
               fila[2]=(rs.getString("direccion"));
               fila[3]=(rs.getString("email"));
               modelo.addRow(fila);
           }
        } catch(SQLException sqle)
            {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
            }
    }
    
    public void consultarProveedor()
    {
    	Proveedor p = new Proveedor();
    	p.solicitarID();
    	int id= p.getId();
    	ResultSet rs;
        Statement stm;
        String sentenciaSQL="SELECT * FROM proveedor WHERE idProveedor= "+id;
        try
        {
           stm = con.createStatement();
           rs = stm.executeQuery(sentenciaSQL);
           
           while (rs.next())
           {
               System.out.println("ID: "+rs.getInt("idProveedor"));
               System.out.println("Nombre: "+rs.getString("nombre"));
               System.out.println("Telefono: "+rs.getString("telefono"));
               System.out.println("Direccion: "+rs.getString("direccion"));
               System.out.println("E-mail: "+rs.getString("email"));
           }
           
        } catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }
    }
    
    public void buscarProveedor(JTextArea prov, String nom)
    {
    	ResultSet rs;
    	try
    	{
    		PreparedStatement ps = con.prepareStatement("SELECT idProveedor,nombre,telefono,direccion,email FROM proveedor WHERE nombre LIKE ? ");
    		ps.setString(1, nom);
    		rs = ps.executeQuery();
    		while(rs.next())
    		{
                prov.append("ID: "+rs.getString("idProveedor"));
                prov.append("\nNombre: "+rs.getString("nombre"));
                prov.append("\nTelefono: "+rs.getString("telefono"));
                prov.append("\nDireccion: "+rs.getString("direccion"));
                prov.append("\nCorreo electrónico: "+rs.getString("email"));
    		}
    	}catch (SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void buscarProveedor(JTextField id,JComboBox cbNom, JTextField dir, JTextField tel, JTextField email)
    {
    	ResultSet rs;
    	try
    	{
    		PreparedStatement ps = con.prepareStatement("SELECT idProveedor,nombre,telefono,direccion,email FROM proveedor WHERE nombre LIKE ? ");
    		ps.setString(1, cbNom.getSelectedItem().toString());
    		rs = ps.executeQuery();
    		while(rs.next())
    		{
                id.setText(rs.getString("idProveedor"));
                dir.setText(rs.getString("direccion"));
                tel.setText(rs.getString("telefono"));
                email.setText(rs.getString("email"));
    		}
    	}catch (SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void buscarUsuario(JTextField id,JComboBox cbNom, JTextField nombre, JTextField usuario, JPasswordField pass)
    {
    	ResultSet rs;
    	try
    	{
    		PreparedStatement ps = con.prepareStatement("SELECT idUsuario,nombre,usuario,contrasena FROM usuario WHERE nombre LIKE ? ");
    		ps.setString(1, cbNom.getSelectedItem().toString());
    		rs = ps.executeQuery();
    		while(rs.next())
    		{
                id.setText(rs.getString("idUsuario"));
                nombre.setText(rs.getString("nombre"));
                usuario.setText(rs.getString("usuario"));
                pass.setText(rs.getString("contrasena"));
    		}
    	}catch (SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void consultarVenta()
    {
    	Venta v = new Venta();
    	v.solicitarId();
    	ResultSet rs;
        Statement stm;
        String sentenciaSQL="SELECT * FROM venta WHERE idVenta= "+v.getIdVenta();
        try
        {
           stm = con.createStatement();
           rs = stm.executeQuery(sentenciaSQL);
           
           while (rs.next())
           {
               System.out.println("ID: "+rs.getInt("idVenta"));
               System.out.println("Fecha: "+rs.getString("fecha"));
               System.out.println("Hora: "+rs.getString("hora"));
               System.out.println("Total: $"+rs.getString("totalVenta"));
           }
           
        } catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }    
    }

    public void consultarArticuloVenta()
    {
    	ArticuloVenta av = new ArticuloVenta();
    	
    	ResultSet rs;
        Statement stm;
        String sentenciaSQL="SELECT * FROM articulo_venta WHERE idArticulo="+av.getIdArticulo()+" AND idVenta="+av.getIdVenta();
        try
        {
           stm = con.createStatement();
           rs = stm.executeQuery(sentenciaSQL);
           
           while (rs.next())
           {
               System.out.println("IdArticulo: "+rs.getInt("idArticulo"));
               System.out.println("IdVenta: "+rs.getString("idVenta"));
           }
           
        } catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }    
    }

    public void consultarVentaXFecha(String fecha1, String fecha2){
         try
         {
           ResultSet rs;
            Statement stm;
            String sentenciaSQL="SELECT articulo.clave,articulo.nombre,articulo.marca,articulo.precio,articulo_venta.cantidad,venta.fecha,venta.hora "
                    + "FROM articulo, venta, articulo_venta "
                    + "WHERE articulo.idArticulo=articulo_venta.idArticulo AND articulo_venta.idVenta=venta.idVenta AND venta.fecha BETWEEN '"+fecha1+"' AND  '"+fecha2+"'";

           stm = con.createStatement();
           rs = stm.executeQuery(sentenciaSQL);
             
             while(rs.next())
             {
                System.out.println("Clave"+rs.getString("clave"));
                System.out.println("Articulo: "+rs.getString("nombre"));
                System.out.println("Marca: "+rs.getString("marca"));
                System.out.println("Precio: "+rs.getString("precio"));
                System.out.println("Cantidad: "+rs.getString("cantidad"));
                System.out.println("Fecha: $"+rs.getString("fecha"));
                System.out.println("Hora: "+rs.getString("hora"));
             }
         } catch (SQLException sqle)
         {
             System.out.println(sqle.getMessage());
             sqle.printStackTrace();
         }
         
     }

    public void cargarClaves(JComboBox clave)
    {
        clave.removeAllItems();
        try
        {
            ResultSet rs;
            String consulta = "SELECT clave FROM articulo";
            PreparedStatement ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            clave.addItem("Seleccione la clave");
            
            while (rs.next())
            {
                clave.addItem(rs.getString("clave"));
            }
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void cargarCantidades(JComboBox cant)
    {
            cant.addItem("Seleccionar");
        for(int i=1;i<100;i++)
        {
            cant.addItem(String.valueOf(i));
        }
    }
    
    public void cargarProveedores(JComboBox nom)
    {
        nom.removeAllItems();
        try
        {
            ResultSet rs;
            String consulta = "SELECT nombre FROM proveedor";
            PreparedStatement ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            nom.addItem("Seleccione el proveedor");
            
            while (rs.next())
            {
                nom.addItem(rs.getString("nombre"));
            }
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void cargarUsuarios(JComboBox nombre)
    {
        nombre.removeAllItems();
        try
        {
            ResultSet rs;
            String consulta = "SELECT nombre FROM usuario";
            PreparedStatement ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            nombre.addItem("Seleccione el usuario");
            
            while (rs.next())
            {
                nombre.addItem(rs.getString("nombre"));
            }
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void buscarxClave(JTextArea prod, String clave)
    {
    	ResultSet rs;
    	try
    	{
    		PreparedStatement ps = con.prepareStatement("SELECT idArticulo,nombre,clave,descripcion,marca,precio FROM articulo WHERE clave LIKE ? ");
    		ps.setString(1, clave);
    		rs = ps.executeQuery();
    		while(rs.next())
    		{
                prod.append("ID: "+rs.getString("idArticulo"));
                prod.append("\nNombre: "+rs.getString("nombre"));
                prod.append("\nClave: "+rs.getString("clave"));
                prod.append("\nDescripcion: "+rs.getString("descripcion"));
                prod.append("\nMarca: "+rs.getString("marca"));
                prod.append("\nPrecio: $"+rs.getString("precio"));
    		}
    	}catch (SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
    
    public void buscarProdxClave(JTextField id,JComboBox cbCl,JTextField nom, JTextField desc, JTextField marca, JTextField precio)
    {
    	ResultSet rs;
    	try
    	{
    		PreparedStatement ps = con.prepareStatement("SELECT idArticulo,nombre,descripcion,marca,precio FROM articulo WHERE clave LIKE ? ");
    		ps.setString(1, cbCl.getSelectedItem().toString());
    		rs = ps.executeQuery();
    		while(rs.next())
    		{
                id.setText(rs.getString("idArticulo"));
                nom.setText(rs.getString("nombre"));
                desc.setText(rs.getString("descripcion"));
                marca.setText(rs.getString("marca"));
                precio.setText(rs.getString("precio"));
    		}
    	}catch (SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }

    public void ObtenerPrecio(JComboBox cbCl,JTextField precio)
    {
        ResultSet rs;
        try
    	{
    		PreparedStatement ps1 = con.prepareStatement("SELECT precio FROM articulo WHERE clave LIKE '"+cbCl.getSelectedItem()+"' ");
                rs = ps1.executeQuery();
    		while(rs.next())
    		{
                precio.setText(rs.getString("precio"));
                }
                }catch (SQLException sqle)
    	{
    		System.out.println(sqle.getMessage());
    		sqle.printStackTrace();
    	}
    }
        
    public void ObtenerTotalProd(JTextField Precio,JTextField Total,JSpinner Cant)
    {
       
        float precio = Float.parseFloat(Precio.getText());
        int cantidad = (Integer)(Cant.getValue());
        float precioTotal = precio*cantidad;
        Total.setText(Float.toString(precioTotal));
    }
    
    public void ObtenerTotalVenta(JTextField TotalProd, JTextField TotalVenta)
    {
        float suma = 0;
        if(TotalVenta.getText().equals("0.00")){
            TotalVenta.setText(TotalProd.getText());
        } else {
            suma =+ Float.parseFloat(TotalProd.getText());
            TotalVenta.setText(String.valueOf(suma));
        }
    }
    
    public boolean login(Usuario usr)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select idUsuario,nombre,usuario,contrasena,tipo FROM usuario WHERE usuario = ?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString (1, usr.getUsuario());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                if (usr.getContrasena().equals(rs.getString(4)))
                {
                    usr.setIdUsuario(rs.getInt(1));
                    usr.setNombre(rs.getString(2));
                    usr.setUsuario(rs.getString(3));
                    usr.setTipo(rs.getInt(5));
                    return true;
                }else 
                {
                    return false;
                }
            }
            return false;
        } catch(SQLException sqle)
        {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
            return false;
        }
        
    }
    
    public int regresar()
    {
        home menu = new home(); 
         menu.setVisible(true);
        return 1;
    }
    
    public void AgregarTabla(JTable tabla)
    {
        DefaultTableModel modelo= new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Nº VENTA");
        modelo.addColumn("TOTAL");
        modelo.addColumn("FECHA");
        modelo.addColumn("HORA");
        
    }
    
    public void AgregarTablaUsuarios(JTable tabla)
    {
        DefaultTableModel modelo= new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("NOMBRE");
        modelo.addColumn("NOMBRE DE USUARIO");
    }
    
    public void LlenarTablaUsuarios(JTable tabla)
    {
        DefaultTableModel modelo= new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("NOMBRE");
        modelo.addColumn("NOMBRE DE USUARIO");
        try {
        String consulta = "SELECT usuario,nombre FROM usuario ";
        Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(consulta);
                while(rs.next())
                {
                    String []Datos= new String [2];
                    Datos[0]=rs.getString("nombre");
                    Datos[1]=rs.getString("usuario");
                    modelo.addRow(Datos);
                }
        } catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Ocurrió un error: "+sqle.getMessage());
        }
    }

    public void LlenarTablaCxF(JTable tablaVentas, JDateChooser fecha1,JDateChooser fecha2)
    {
        DefaultTableModel modelo= new DefaultTableModel();
        tablaVentas.setModel(modelo);
        modelo.addColumn("Nº Venta");
        modelo.addColumn("TOTAL");
        modelo.addColumn("FECHA");
        modelo.addColumn("HORA");
        {
        String consulta="SELECT *"
                    + "FROM venta "
                    + "ORDER BY idVenta ASC, fecha ASC, hora ASC ";
        try {
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(consulta);
                while(rs.next())
                {
                    String []Datos= new String [4];
                    Datos[0]=rs.getString("idVenta");
                    Datos[1]=rs.getString("totalVenta");
                    Datos[2]=rs.getString("fecha");
                    Datos[3]=rs.getString("hora");

                    modelo.addRow(Datos);
                }
            }catch (SQLException sqle)
         {
             System.err.println(sqle.getMessage());
             sqle.printStackTrace();
         }
        }
    }

    public void VentasDelDia(JTable tabla)
    {
        funciones fecha = new funciones();
        DefaultTableModel modelo= new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Nº Venta");
        modelo.addColumn("TOTAL");
        modelo.addColumn("FECHA");
        
        String consulta="SELECT *"
                    + "FROM venta "
                    + "WHERE fecha='"+fecha.getFechaActual()+"' "
                    + "ORDER BY idVenta ASC, hora ASC ";
        {
//        String consulta="SELECT venta.idVenta,articulo.clave,articulo.nombre,articulo.marca,articulo.precio,articulo_venta.cantidad,venta.hora "
//                    + "FROM articulo, venta, articulo_venta "
//                    + "WHERE articulo.idArticulo=articulo_venta.idArticulo AND articulo_venta.idVenta=venta.idVenta AND venta.fecha='"+fecha.getFechaActual()+"' "
//                + "ORDER BY venta.idVenta ASC";

        try {
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(consulta);
                while(rs.next())
                {
                    String []Datos= new String [3];
                    Datos[0]=rs.getString("idVenta");
                    Datos[1]=rs.getString("totalVenta");
                    Datos[2]=rs.getString("hora");

                    modelo.addRow(Datos);
                }
            }catch (SQLException sqle)
             {
                 System.err.println(sqle.getMessage());
                 sqle.printStackTrace();
             }
        }
    }
    
    public void detalleVenta(JTable tabla, String id)
    {
        funciones fecha = new funciones();
        DefaultTableModel modelo= new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("CLAVE");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("MARCA");
        modelo.addColumn("CANT");
        modelo.addColumn("TOTAL");
        {
        funciones Funcion = new funciones();
        String consulta="SELECT articulo.clave,articulo.descripcion,articulo.marca,articulo_venta.cantidad,articulo_venta.total "
                    + "FROM articulo, articulo_venta "
                    + "WHERE articulo.idArticulo=articulo_venta.idArticulo AND articulo_venta.idVenta="+id+" ";

        try {
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(consulta);
                while(rs.next())
                {
                    String []Datos= new String [5];
                    Datos[0]=rs.getString("clave");
                    Datos[1]=rs.getString("descripcion");
                    Datos[2]=rs.getString("marca");
                    Datos[3]=rs.getString("cantidad");
                    Datos[4]=rs.getString("total");

                    modelo.addRow(Datos);
                }
            }catch (SQLException sqle)
         {
             System.out.println(sqle.getMessage());
             sqle.printStackTrace();
         }
        }
    }

    public void TotalVentas(JTable tabla, JTextField total)
    {
        int filast = tabla.getRowCount();
        int c=0;
        total.setText("0.00");
        do {
            try
            {
                int f=c++;
                float n1 = Float.parseFloat(tabla.getValueAt(f,4).toString());
                String nu=total.getText();
                float nu2=Float.parseFloat(nu);
                float re=n1+nu2;
                total.setText(String.valueOf(re));
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        } while(c<filast);
    }
    
     public void TotalVentasDia(JTable tabla, JTextField total)
    {
        int filast = tabla.getRowCount();
        int c=0;
        total.setText("0.00");
        do {
            try
            {
                int f=c++;
                float n1 = Float.parseFloat(tabla.getValueAt(f,1).toString());
                String nu=total.getText();
                float nu2=Float.parseFloat(nu);
                float re=n1+nu2;
                total.setText(String.valueOf(re));
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        } while(c<filast);
        }
        
    public void registrarUsuario(JTextField nombre,JTextField usuario, JPasswordField pass)
    {
            try
            {
                
                PreparedStatement ps = con.prepareStatement("INSERT INTO usuario(nombre,usuario,contrasena,tipo) VALUES (?,?,?,2)");
                ps.setString(1, nombre.getText());
                ps.setString(2, usuario.getText());
                ps.setString(3, pass.getText());
                
                int filasAfectadas = ps.executeUpdate();
                
                if(filasAfectadas>0){
                    JOptionPane.showMessageDialog(null, "Usuario registrado correctamente!");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error", "Error!", JOptionPane.WARNING_MESSAGE);
                }
               
            }catch(SQLException sqle)
            {
                JOptionPane.showMessageDialog(null ,sqle.getMessage());
            }
        }
        
    public void obtenerID_Articulo(String clave,JTextField id)
    {
        try{
            PreparedStatement ps = con.prepareStatement("Select idArticulo from articulo where clave='"+clave+"'");
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                id.setText(rs.getString("idArticulo"));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void obtenerIDuser(String usuario, String contrasena,JTextField id)
    {
        try{
            PreparedStatement ps = con.prepareStatement("Select idUsuario from usuario where usuario='"+usuario+"' and contrasena='"+contrasena+"'");
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                id.setText(rs.getString("idUsuario"));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public void obtenerID_Venta(JTextField id)
    {
        try{
            PreparedStatement ps = con.prepareStatement("Select max(idVenta) from venta");
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                id.setText(rs.getString("max(idVenta)"));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    public void AgregarCompra(JTable tabla, int idVenta)
    {
        DefaultTableModel modelo= new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("CLAVE");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("PRECIO UNITARIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("TOTAL");
        
        String consulta="SELECT articulo.clave,articulo.descripcion,articulo.precio,articulo_venta.cantidad,articulo_venta.total "
                    + "FROM articulo, articulo_venta "
                    + "WHERE articulo.idArticulo=articulo_venta.idArticulo AND articulo_venta.idVenta="+idVenta+" ";
        try{
        Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(consulta);
                while(rs.next())
                {
                    String []Datos= new String [5];
                    Datos[0]=rs.getString("clave");
                    Datos[1]=rs.getString("descripcion");
                    Datos[2]=rs.getString("precio");
                    Datos[3]=rs.getString("cantidad");
                    Datos[4]=rs.getString("total");
                    
                    modelo.addRow(Datos);
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    public void mostrarProductos(JTable tabla)
    {
        DefaultTableModel modelo= new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("CLAVE"); 
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("MARCA");
        modelo.addColumn("PRECIO");
       modelo.addColumn("STOCK");
        
        
        String consulta="SELECT * FROM articulo";
        try{
        Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(consulta);
                while(rs.next())
                {
                    String []Datos= new String [6];
                    Datos[0]=rs.getString("clave");
                    Datos[1]=rs.getString("nombre");
                    Datos[2]=rs.getString("descripcion");
                    Datos[3]=rs.getString("marca");
                    Datos[4]=rs.getString("precio");
                    Datos[5]=rs.getString("stock");
                    
                    modelo.addRow(Datos);
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void mostrarProveedores(JTable tabla)
    {
        DefaultTableModel modelo= new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Nombre"); 
        modelo.addColumn("Telefono");
        modelo.addColumn("Direccion");
        modelo.addColumn("E-mail");
       
        
        
        String consulta="SELECT nombre,telefono,direccion,email FROM proveedor";
        try{
        Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(consulta);
                while(rs.next())
                {
                    String []Datos= new String [4];
                    Datos[0]=rs.getString("nombre");
                    Datos[1]=rs.getString("telefono");
                    Datos[2]=rs.getString("direccion");
                    Datos[3]=rs.getString("email");
                    
                    modelo.addRow(Datos);
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    public void mostrarUsuarios(JTable tabla)
    {
        DefaultTableModel modelo= new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Nombre"); 
        modelo.addColumn("Nombre de usario");
        modelo.addColumn("Contraseña");
       
        String consulta="SELECT * FROM usuario";
        try{
        Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(consulta);
                while(rs.next())
                {
                    String []Datos= new String [3];
                    Datos[0]=rs.getString("nombre");
                    Datos[1]=rs.getString("usuario");
                    Datos[2]=rs.getString("contrasena");
                    
                    modelo.addRow(Datos);
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    public void limpiarTabla(JTable tabla){
        try {
            DefaultTableModel modelo=(DefaultTableModel)tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    
    public boolean claveExiste(String texto){
        try{
            int idArticulo = 0;
            String sql = "Select idArticulo from articulo where clave='"+texto+"' ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                idArticulo = rs.getInt("idArticulo");
            }
            Statement st  = con.createStatement();
            ResultSet rs2 = st.executeQuery("Select idArticulo from articulo_venta where idArticulo="+idArticulo);
            
            while(rs2.next()){
                return true;
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean articuloYaExiste(String clave, JTable tabla){
       try {
               for (int i = 0 ; i < tabla.getRowCount() ; i++){
                  if(tabla.getValueAt(i, 0).toString().equals(clave)){
                      JOptionPane.showMessageDialog(null, "Ya ha agregado este producto.");
                      return true;
                  }
                  return false;
               }
           } catch(Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
           }
        return false;
    }
    
}

