/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sensus.penduduk;

import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.TableModel;
/**
 *
 * @author axioo
 */
public class person extends javax.swing.JFrame {
public Connection conn;
public Statement stat;
public ResultSet rs;
public String sql="",tl;


int x,no;
private static final JFileChooser CHOOSER=new JFileChooser();

private DefaultTableModel tabmode;
Object[] row={"id","name","region_id","address","income","created_at"};
DefaultTableModel tabMode = new DefaultTableModel(null,row);
    /**
     * Creates new form region
     */
    public person() {
        initComponents();
        koneksi();      
        bersih();
        jam();
        tampilperson();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tampil = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        namaperson = new javax.swing.JTextField();
        idperson = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        alamatperson = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pendapatanperson = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tanggalperson = new javax.swing.JTextField();
        id = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PERSON");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 150, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Tambah Person ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nama");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Region Id");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 130, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Daftar Person");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        tampil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tampil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tampilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tampil);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 390, 290));

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, -1, -1));

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, -1, -1));

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 70, -1));

        jButton4.setText("Bersih");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 70, -1));

        jButton5.setText("Kembali ke Menu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 210, -1));
        jPanel1.add(namaperson, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 140, 30));
        jPanel1.add(idperson, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 140, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        alamatperson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatpersonActionPerformed(evt);
            }
        });
        jPanel1.add(alamatperson, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 140, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Alamat");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 130, -1));

        pendapatanperson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendapatanpersonActionPerformed(evt);
            }
        });
        jPanel1.add(pendapatanperson, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 140, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Pendapatan         Rp");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 130, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Tanggal Daftar");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 130, -1));

        tanggalperson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalpersonActionPerformed(evt);
            }
        });
        jPanel1.add(tanggalperson, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 140, 30));

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tampilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tampilMouseClicked
        // TODO add your handling code here:
        int j=tampil.getSelectedRow();
        TableModel model=tampil.getModel();
        idperson.setText(model.getValueAt(j,0).toString());
        id.setSelectedItem(model.getValueAt(j,2).toString());
        namaperson.setText(model.getValueAt(j,1).toString());
        alamatperson.setText(model.getValueAt(j,3).toString());
        pendapatanperson.setText(model.getValueAt(j,4).toString());
        tanggalperson.setText(model.getValueAt(j,5).toString());
                
    }//GEN-LAST:event_tampilMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
                sql="insert into person values('"
                +idperson.getText()+"','"
                +namaperson.getText()+"','"
                +id.getSelectedItem()+ "','"
                +alamatperson.getText()+"','"
                +pendapatanperson.getText()+"','"
                +tanggalperson.getText()+"')";
            stat.execute(sql);
            
            JOptionPane.showMessageDialog(rootPane, "Yeay.. Tersimpan !!!");
        } catch (Exception f){
            JOptionPane.showMessageDialog(rootPane, "Ulang Simpan Data cuy..."+f);
        }
        
        tampilperson();
        bersih();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try {
            sql=("update person set name='"+namaperson.getText()+
            
            "',region_id='"+ id.getSelectedItem()+
            "',address='"+ alamatperson.getText()+
            "',income='"+ pendapatanperson.getText()+
            "',created_at='"+ tanggalperson.getText()+
             "'where id='"+idperson.getText()+"'");
            stat.execute(sql);
            JOptionPane.showMessageDialog(rootPane,"Data Berhasil Di EDIT...!'");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Data gagal Di EDIT...!'"+e);
        }
        tampilperson();
        bersih();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        bersih();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            sql="delete from person where id='"+idperson.getText()+"'";
            stat.execute(sql);
            JOptionPane.showMessageDialog(rootPane, "data sudah terhapus");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "data belum terhapus"+e);
        }
        bersih();
        tampilperson();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new menuutama().show();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void alamatpersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatpersonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatpersonActionPerformed

    private void pendapatanpersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendapatanpersonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pendapatanpersonActionPerformed

    private void tanggalpersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalpersonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalpersonActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
        try {
            String sql="select id from regions order by id asc";
            ResultSet res=stat.executeQuery(sql);
            
            while(res.next()){
                Object[] ob=new Object[3];
                ob[0]=res.getString(1);
                
                id.addItem(ob[0]);
            }
            res.close();stat.close();
                   } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"gagal"+e);
        }
    }//GEN-LAST:event_idActionPerformed

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
            java.util.logging.Logger.getLogger(person.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(person.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(person.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(person.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new person().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamatperson;
    private javax.swing.JComboBox id;
    private javax.swing.JTextField idperson;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namaperson;
    private javax.swing.JTextField pendapatanperson;
    private javax.swing.JTable tampil;
    private javax.swing.JTextField tanggalperson;
    // End of variables declaration//GEN-END:variables

    private void jam() {
      ActionListener a=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nolBulan="";
                String nolHari="";
                String nolJam="";
                String nolMenit="";
                String nolDetik="";
                Calendar dt= Calendar.getInstance();
                int nilaiTahun=dt.get(dt.YEAR);
                int nilaiBulan=dt.get(dt.MONTH)+1;
                int nilaiHari=dt.get(dt.DAY_OF_MONTH);
                int nilaiJam=dt.get(dt.HOUR_OF_DAY);
                int nilaiMenit=dt.get(dt.MINUTE);
                int nilaiDetik=dt.get(dt.SECOND);
                if (nilaiBulan<=9)
                {
                    nolBulan="0";
                }
                if (nilaiHari<=9)
                {
                    nolHari="0";
                }
                if (nilaiJam<=9)
                {
                    nolJam="0";
                }
                if (nilaiMenit<=9)
                {
                    nolMenit="0";
                }
                if (nilaiDetik<=9)
                {
                    nolDetik="0";
                }
                String bulan=nolBulan+Integer.toString(nilaiBulan);
                String hari=nolHari+Integer.toString(nilaiHari);
                String jam=nolJam+Integer.toString(nilaiJam);
                String menit=nolMenit+Integer.toString(nilaiMenit);
                String detik=nolDetik+Integer.toString(nilaiDetik);
                tanggalperson.setText(nilaiTahun+"-"+bulan+"-"+hari+"  "+jam+":"+menit+":"+detik);
                
            }
    }; new javax.swing.Timer(1000, a).start();  
    }

    private void bersih() {
    idperson.setText("");
    id.setSelectedItem("");
    namaperson.setText("");
    alamatperson.setText("");
    pendapatanperson.setText("");
    tanggalperson.setText("");
    idperson.requestFocus();      
    }

    private void koneksi() {
     try {
             Class.forName("com.mysql.jdbc.Driver");
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsensuspenduduk","root","");
           stat=conn.createStatement();
           JOptionPane.showMessageDialog(rootPane, " Ancak Koneksi Mahhh !!!");
   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, " Buaruak Koneksi Mah");
            System.out.println(e.getMessage());
            
                              }      
    }

    private void tampilperson() {
       tampil.setModel(tabMode);
   tabmode=(DefaultTableModel)tampil.getModel();
 
        
   String a,b,c,d,f,g;
     DefaultTableModel tabelperson=new DefaultTableModel();
        tabelperson.addColumn("id");
        tabelperson.addColumn("name");
        tabelperson.addColumn("region_id");
        tabelperson.addColumn("address");
        tabelperson.addColumn("income");
        tabelperson.addColumn("creatd_at");
           
                
        try {
            int n=1;
            sql="Select id,name,region_id,address,income,created_at from person";
            rs=stat.executeQuery(sql);
            while(rs.next())
            {
                
                 tabelperson.addRow(new Object[]{
                    a=rs.getString("id"),
                    b=rs.getString("name"),
                    c=rs.getString("region_id"),
                    d=rs.getString("address"),
                    f=rs.getString("income"),
                    g=rs.getString("created_at"),
                    });
                
                tampil.setModel(tabelperson);
                
                Object[]aw={(+n++),a,b,c,d,f,g};
            tabmode.addRow(aw);
            }
            } catch (Exception e){
                
                }  
    }
    
}
