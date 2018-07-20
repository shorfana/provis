/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.frame;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import tubes.koneksi.database.koneksi;

/**
 *
 * @author Shorfana
 */
public class frame_simulasiNilaiAkhir_if extends javax.swing.JFrame {

    /**
     * Creates new form frame_mahasiswa_if
     */
    // declarasi variabel program if
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
    
    public frame_simulasiNilaiAkhir_if() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tabel_mahasiswa_if.setModel(tableModel);
        tampilComboif();
        
        settableload();
    }
    
    public void tampilkodemkif(){
       try {
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select kd_mk from t_mata_kuliah where nama_mk='"+cmb_mata_kuliah_if.getSelectedItem()+"'";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()){
                Object[] ob = new Object[1];
                ob[0]=  res.getString(1);
                
                txt_kodeMk_if.setText((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
        } 
    }
    
    public void tampilComboif(){
       try {
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select nama_mk from t_mata_kuliah";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()){
                cmb_mata_kuliah_if.addItem(res.getString("nama_mk"));
                
            }
            res.close();
            stt.close();
        } catch (Exception e) {
        } 
    }
    
    int row = -1;
    String data[] = new String[20];
    private void settableload(){
        String stat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select * from t_simulasi_nilai";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
            data[0] = res.getString("kode_simulasi");
            data[1] = res.getString("kd_mk");
            data[2] = res.getString("nama_mk");
            data[3] = res.getString("persentase_absen");
            data[4] = res.getString("persentase_tugas");
            data[5] = res.getString("persentase_uts");
            data[6] = res.getString("persentase_uas");
            data[7] = res.getString("absensi");
            data[8] = res.getString("tgs1");
            data[9] = res.getString("tgs2");
            data[10] = res.getString("tgs3");
            data[11] = res.getString("uts");
            data[12] = res.getString("uas");
            data[13] = res.getString("nilai_absen");
            data[14] = res.getString("nilai_tugas");
            data[15] = res.getString("nilai_uts");
            data[16] = res.getString("nilai_uas");
            data[17] = res.getString("nilai_akhir");
            data[18] = res.getString("indek");
            data[19] = res.getString("keterangan");
            
            tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    public void membersihkan_teks(){
        txt_kodeMk_if.setText("");
        txt_prsAbsen_if.setText("");
        txt_prsTugas_if.setText("");
        txt_prsUTS_if.setText("");
        txt_prsUAS_if.setText("");
        txt_kehadiran_if.setText("");
        txt_tgs1_if.setText("");
        txt_tgs2_if.setText("");
        txt_tgs3_if.setText("");
        txt_uts_if.setText("");
        txt_uas_if.setText("");
    }
    
    public void nonaktifkan_teks(){
        txt_kodeMk_if.setEnabled(false);
        txt_prsAbsen_if.setEnabled(false);
        txt_prsTugas_if.setEnabled(false);
        txt_prsUTS_if.setEnabled(false);
        txt_prsUAS_if.setEnabled(false);
        txt_kehadiran_if.setEnabled(false);
        txt_tgs1_if.setEnabled(false);
        txt_tgs2_if.setEnabled(false);
        txt_tgs3_if.setEnabled(false);
        txt_uts_if.setEnabled(false);
        txt_uas_if.setEnabled(false);
    }
    
    public void aktif_teks(){
        txt_kodeMk_if.setEnabled(true);
        txt_prsAbsen_if.setEnabled(true);
        txt_prsTugas_if.setEnabled(true);
        txt_prsUTS_if.setEnabled(true);
        txt_prsUAS_if.setEnabled(true);
        txt_kehadiran_if.setEnabled(true);
        txt_tgs1_if.setEnabled(true);
        txt_tgs2_if.setEnabled(true);
        txt_tgs3_if.setEnabled(true);
        txt_uts_if.setEnabled(true);
        txt_uas_if.setEnabled(true);
    }
    
    public void tampil_field(){
        row = tabel_mahasiswa_if.getSelectedRow();
        txt_kodeMk_if.setText(tableModel.getValueAt(row, 1).toString());
        cmb_mata_kuliah_if.getModel().setSelectedItem(tableModel.getValueAt(row, 2).toString());
        txt_prsAbsen_if.setText(tableModel.getValueAt(row, 3).toString());
        txt_prsTugas_if.setText(tableModel.getValueAt(row, 4).toString());
        txt_prsUTS_if.setText(tableModel.getValueAt(row, 5).toString());
        txt_prsUAS_if.setText(tableModel.getValueAt(row, 6).toString());
        txt_kehadiran_if.setText(tableModel.getValueAt(row, 7).toString());
        txt_tgs1_if.setText(tableModel.getValueAt(row, 8).toString());
        txt_tgs2_if.setText(tableModel.getValueAt(row, 9).toString());
        txt_tgs3_if.setText(tableModel.getValueAt(row, 10).toString());
        txt_uts_if.setText(tableModel.getValueAt(row, 11).toString());
        txt_uas_if.setText(tableModel.getValueAt(row, 12).toString());
        
        btn_ubah_if.setEnabled(true);
        
    }
    
    private javax.swing.table.DefaultTableModel tableModel = getDefaultTableModel();
    private javax.swing.table.DefaultTableModel getDefaultTableModel() {
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"id","kode mk","Nama M.K","Persentase Absen","Persentase Tugas",""
                        + "Persentase UTS","Persentase UAS", "Absensi", "Tgs "
                        + "1","Tgs 2","Tgs 3","UTS","UAS","Nilai Absen","Nilai"
                        + " Tugas","Nilai UTS","Nilai UAS","Nilai Akhir","Index"
                        + "", "Keterangan"}
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false
                    , false, false, false, false, false, false, false, false, false
                    , false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
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
        panelJudul = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelIsi = new javax.swing.JPanel();
        panelIsi2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_kodeMk_if = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_prsAbsen_if = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_mahasiswa_if = new javax.swing.JTable();
        btn_tambah_if = new javax.swing.JButton();
        btn_ubah_if = new javax.swing.JButton();
        btn_hapus_if = new javax.swing.JButton();
        btn_simpan_if = new javax.swing.JButton();
        btn_batal_if = new javax.swing.JButton();
        btn_keluar_if = new javax.swing.JButton();
        cmb_mata_kuliah_if = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_prsTugas_if = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_prsUTS_if = new javax.swing.JTextField();
        txt_prsUAS_if = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_kehadiran_if = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_tgs1_if = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_tgs2_if = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_tgs3_if = new javax.swing.JTextField();
        txt_uts_if = new javax.swing.JTextField();
        txt_uas_if = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelJudul.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("FORM SIMULASI NILAI AKHIR ");

        javax.swing.GroupLayout panelJudulLayout = new javax.swing.GroupLayout(panelJudul);
        panelJudul.setLayout(panelJudulLayout);
        panelJudulLayout.setHorizontalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudulLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        panelJudulLayout.setVerticalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(panelJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 490, 60));

        panelIsi2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Kode M.K");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Presentase Absen");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nama Mata Kuliah");

        tabel_mahasiswa_if.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_mahasiswa_if.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_mahasiswa_ifMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_mahasiswa_if);

        btn_tambah_if.setText("Tambah");
        btn_tambah_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_ifActionPerformed(evt);
            }
        });

        btn_ubah_if.setText("Ubah");
        btn_ubah_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubah_ifActionPerformed(evt);
            }
        });

        btn_hapus_if.setText("Hapus");
        btn_hapus_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_ifActionPerformed(evt);
            }
        });

        btn_simpan_if.setText("Simpan");
        btn_simpan_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_ifActionPerformed(evt);
            }
        });

        btn_batal_if.setText("Batal");

        btn_keluar_if.setText("Keluar");

        cmb_mata_kuliah_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_mata_kuliah_ifActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("%");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Presentase Tugas");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Presentase UTS");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Presentase UAS");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Kehadiran");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Tugas 1");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Tugas 2");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Tugas 3");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("%");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("%");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("%");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("UTS");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("UAS");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Pertemuan");

        javax.swing.GroupLayout panelIsi2Layout = new javax.swing.GroupLayout(panelIsi2);
        panelIsi2.setLayout(panelIsi2Layout);
        panelIsi2Layout.setHorizontalGroup(
            panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi2Layout.createSequentialGroup()
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelIsi2Layout.createSequentialGroup()
                                        .addComponent(txt_prsUTS_if, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18))
                                    .addGroup(panelIsi2Layout.createSequentialGroup()
                                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                                .addComponent(txt_prsAbsen_if, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8))
                                            .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cmb_mata_kuliah_if, 0, 132, Short.MAX_VALUE)
                                                .addComponent(txt_kodeMk_if))
                                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                                .addComponent(txt_prsTugas_if, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9))
                                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                                .addComponent(txt_prsUAS_if, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel19)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21))
                                        .addGap(31, 31, 31)
                                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_uas_if, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                            .addComponent(txt_uts_if, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                            .addComponent(txt_tgs2_if, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                            .addComponent(txt_tgs1_if, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                            .addComponent(txt_tgs3_if, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                            .addComponent(txt_kehadiran_if))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17)
                                        .addGap(45, 45, 45))))
                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 582, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_tambah_if)
                        .addGap(46, 46, 46)
                        .addComponent(btn_ubah_if)
                        .addGap(59, 59, 59)
                        .addComponent(btn_hapus_if)
                        .addGap(93, 93, 93)
                        .addComponent(btn_simpan_if)
                        .addGap(67, 67, 67)
                        .addComponent(btn_batal_if)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_keluar_if)))
                .addContainerGap())
        );
        panelIsi2Layout.setVerticalGroup(
            panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmb_mata_kuliah_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txt_kodeMk_if, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_prsAbsen_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_prsTugas_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_prsUTS_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_prsUAS_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel12)))
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_kehadiran_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_tgs1_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_tgs2_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txt_tgs3_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(txt_uts_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(txt_uas_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah_if)
                    .addComponent(btn_ubah_if)
                    .addComponent(btn_hapus_if)
                    .addComponent(btn_simpan_if)
                    .addComponent(btn_batal_if)
                    .addComponent(btn_keluar_if))
                .addGap(94, 94, 94))
        );

        javax.swing.GroupLayout panelIsiLayout = new javax.swing.GroupLayout(panelIsi);
        panelIsi.setLayout(panelIsiLayout);
        panelIsiLayout.setHorizontalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelIsi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelIsiLayout.setVerticalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelIsi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(panelIsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 730, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_mata_kuliah_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_mata_kuliah_ifActionPerformed
        // TODO add your handling code here:
        tampilkodemkif();
    }//GEN-LAST:event_cmb_mata_kuliah_ifActionPerformed

    private void btn_tambah_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_ifActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
        txt_kodeMk_if.requestFocus();
        btn_simpan_if.setEnabled(true);
        btn_ubah_if.setEnabled(false);
        btn_hapus_if.setEnabled(false);
        btn_keluar_if.setEnabled(false);
        aktif_teks();
    }//GEN-LAST:event_btn_tambah_ifActionPerformed

    
    private void btn_simpan_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_ifActionPerformed
        // TODO add your handling code here:
        String data[] = new String[19];
        
        double pabsen = Double.valueOf(txt_prsAbsen_if.getText()) / 100;
        double hadir2 = Double.valueOf(txt_kehadiran_if.getText());
        double hadir = Double.valueOf(txt_kehadiran_if.getText()) / 14;
        double nilaiAbsen = hadir * 100 * pabsen;
        double ptugas = Double.valueOf(txt_prsTugas_if.getText()) / 100;
        double tgs1 = Double.valueOf(txt_tgs1_if.getText());
        double tgs2 = Double.valueOf(txt_tgs2_if.getText());
        double tgs3 = Double.valueOf(txt_tgs3_if.getText());
        double nilaiTugas = ((tgs1+tgs2+tgs3)/3) * ptugas ;
        double puts = Double.valueOf(txt_prsUTS_if.getText()) ;
        double nilaiUTS = (Double.valueOf(txt_uts_if.getText()) * puts)/100;
        double puas = Double.valueOf(txt_prsUAS_if.getText()) ;
        double nilaiUAS = (Double.valueOf(txt_uas_if.getText()) * puas)/100;
        double nilaiAkhir =  (nilaiAbsen + nilaiTugas + nilaiUTS + nilaiUAS);
        String index = "";
        if(nilaiAkhir >=80 && nilaiAkhir <= 100 ){
            index = "A";
        }else if(nilaiAkhir >=68 && nilaiAkhir <= 79){
            index = "B";
        }else if(nilaiAkhir >=56 && nilaiAkhir <= 67){
            index="C";
        }else if(nilaiAkhir >=45 && nilaiAkhir <= 55){
            index="D";
        }else{
            index="E";
        }
        String keterangan = "";
        if(hadir2 <= 11){
            keterangan="Tidak Lulus";
        }else if((index == "A" || index == "B" || index == "C") && hadir2 >= 11){
            keterangan="LULUS";
        }else if((index == "D" || index == "E")){
            keterangan="Tidak Lulus";
        }
        
        if(txt_kodeMk_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Kode MK Harus diisi");
            txt_kodeMk_if.requestFocus();
        }else if(txt_prsAbsen_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi Absen Harus diisi");
            txt_prsAbsen_if.requestFocus();
        }else if(txt_prsTugas_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi Tugas Harus diisi");
            txt_prsTugas_if.requestFocus();
        }else if(txt_prsUTS_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi UTS Harus diisi");
            txt_prsUTS_if.requestFocus();
        }else if(txt_prsUAS_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi UAS Harus diisi");
            txt_prsUAS_if.requestFocus();
        }else if(txt_kehadiran_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Kehadiran Harus diisi");
            txt_kehadiran_if.requestFocus();
        }else if(hadir2 > 14){
            JOptionPane.showMessageDialog(null, "Kolom Kehadiran Tidak Boleh Lebih Dari 14");
            txt_kehadiran_if.requestFocus();
            
        }else if(txt_tgs1_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Tugas 1 Harus diisi");
            txt_tgs1_if.requestFocus();
        }else if(txt_tgs2_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Tugas 2 Harus diisi");
            txt_tgs2_if.requestFocus();
        }else if(txt_tgs3_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Tugas 3 Harus diisi");
            txt_tgs3_if.requestFocus();
        }else if(txt_uts_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Nilai UTS Harus diisi");
            txt_uts_if.requestFocus();
        }else if(txt_uas_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Nilai UAS Harus diisi");
            txt_uas_if.requestFocus();
        }else {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(
                                database,
                                user,
                                pass);
                Statement stt = kon.createStatement();
                String    SQL = "INSERT INTO `java_akdmk_10116465`.`t_simulasi_nilai` "
                        + "( `kd_mk`, `nama_mk`, `persentase_absen`, "
                        + "`persentase_tugas`, `persentase_uts`, `persentase_uas`,"
                        + " `absensi`, `tgs1`, `tgs2`, `tgs3`, `uts`, `uas`, "
                        + "`nilai_absen`, `nilai_tugas`, `nilai_uts`, `nilai_uas`, "
                        + "`nilai_akhir`,`indek`, `keterangan`) "
                        + "VALUES ( "
                        + "'"+txt_kodeMk_if.getText()+"', "
                        + "'"+cmb_mata_kuliah_if.getSelectedItem().toString()+"', "
                        + "'"+txt_prsAbsen_if.getText()+"', "
                        + "'"+txt_prsTugas_if.getText()+"', "
                        + "'"+txt_prsUTS_if.getText()+"', "
                        + "'"+txt_prsUAS_if.getText()+"', "
                        + "'"+txt_kehadiran_if.getText()+"', "
                        + "'"+txt_tgs1_if.getText()+"', "
                        + "'"+txt_tgs2_if.getText()+"', "
                        + "'"+txt_tgs3_if.getText()+"', "
                        + "'"+txt_uts_if.getText()+"', "
                        + "'"+txt_uas_if.getText()+"', "
                        + "'"+nilaiAbsen+"', '"+nilaiTugas+"', "
                        + "'"+nilaiUTS+"', '"+nilaiUAS+"', '"+nilaiAkhir+"', "
                        + "'"+index+"', "
                        + "'"+keterangan+"')";
                stt.executeUpdate(SQL);
                
                tableModel.setRowCount(0);
                settableload();
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_simpan_if.setEnabled(false);
                btn_keluar_if.setEnabled(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e.getMessage(),"Error",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_btn_simpan_ifActionPerformed

    private void tabel_mahasiswa_ifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_mahasiswa_ifMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==1) {
            tampil_field();
        }
    }//GEN-LAST:event_tabel_mahasiswa_ifMouseClicked

    private void btn_ubah_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubah_ifActionPerformed
        // TODO add your handling code here:
        String data[] = new String[19];
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Belum Memilih Row !!!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
        double pabsen = Double.valueOf(txt_prsAbsen_if.getText()) / 100;
        double hadir2 = Double.valueOf(txt_kehadiran_if.getText());
        double hadir = Double.valueOf(txt_kehadiran_if.getText()) / 14;
        double nilaiAbsen = hadir * 100 * pabsen;
        double ptugas = Double.valueOf(txt_prsTugas_if.getText()) / 100;
        double tgs1 = Double.valueOf(txt_tgs1_if.getText());
        double tgs2 = Double.valueOf(txt_tgs2_if.getText());
        double tgs3 = Double.valueOf(txt_tgs3_if.getText());
        double nilaiTugas = ((tgs1+tgs2+tgs3)/3) * ptugas ;
        double puts = Double.valueOf(txt_prsUTS_if.getText()) ;
        double nilaiUTS = (Double.valueOf(txt_uts_if.getText()) * puts)/100;
        double puas = Double.valueOf(txt_prsUAS_if.getText()) ;
        double nilaiUAS = (Double.valueOf(txt_uas_if.getText()) * puas)/100;
        double nilaiAkhir =  (nilaiAbsen + nilaiTugas + nilaiUTS + nilaiUAS);
        String index = "";
        if(nilaiAkhir >=80 && nilaiAkhir <= 100 ){
            index = "A";
        }else if(nilaiAkhir >=68 && nilaiAkhir <= 79){
            index = "B";
        }else if(nilaiAkhir >=56 && nilaiAkhir <= 67){
            index="C";
        }else if(nilaiAkhir >=45 && nilaiAkhir <= 55){
            index="D";
        }else{
            index="E";
        }
        String keterangan = "";
        if(hadir2 <= 11){
            keterangan="Tidak Lulus";
        }else if((index == "A" || index == "B" || index == "C") && hadir2 >= 11){
            keterangan="LULUS";
        }else if((index == "D" || index == "E")){
            keterangan="Tidak Lulus";
        }
        
        if(txt_kodeMk_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Kode MK Harus diisi");
            txt_kodeMk_if.requestFocus();
        }else if(txt_prsAbsen_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi Absen Harus diisi");
            txt_prsAbsen_if.requestFocus();
        }else if(txt_prsTugas_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi Tugas Harus diisi");
            txt_prsTugas_if.requestFocus();
        }else if(txt_prsUTS_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi UTS Harus diisi");
            txt_prsUTS_if.requestFocus();
        }else if(txt_prsUAS_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi UAS Harus diisi");
            txt_prsUAS_if.requestFocus();
        }else if(txt_kehadiran_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Kehadiran Harus diisi");
            txt_kehadiran_if.requestFocus();
        }else if(hadir2 > 14){
            JOptionPane.showMessageDialog(null, "Kolom Kehadiran Tidak Boleh Lebih Dari 14");
            txt_kehadiran_if.requestFocus();
            
        }else if(txt_tgs1_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Tugas 1 Harus diisi");
            txt_tgs1_if.requestFocus();
        }else if(txt_tgs2_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Tugas 2 Harus diisi");
            txt_tgs2_if.requestFocus();
        }else if(txt_tgs3_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Tugas 3 Harus diisi");
            txt_tgs3_if.requestFocus();
        }else if(txt_uts_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Nilai UTS Harus diisi");
            txt_uts_if.requestFocus();
        }else if(txt_uas_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Nilai UAS Harus diisi");
            txt_uas_if.requestFocus();
        }else{
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(
                    database,
                    user,
                    pass);
            Statement stt = kon.createStatement();
            String SQL = "UPDATE `java_akdmk_10116465`.`t_simulasi_nilai` SET "
                    + "`kd_mk` = '"+txt_kodeMk_if.getText()+"' , "
                    + "`nama_mk` = '"+cmb_mata_kuliah_if.getSelectedItem()+"' , "
                    + "`persentase_absen` = '"+txt_prsAbsen_if.getText()+"' , "
                    + "`persentase_tugas` = '"+txt_prsTugas_if.getText()+"' , "
                    + "`persentase_uts` = '"+txt_prsUTS_if.getText()+"' , "
                    + "`persentase_uas` = '"+txt_prsUAS_if.getText()+"' , "
                    + "`absensi` = '"+txt_kehadiran_if.getText()+"' , "
                    + "`tgs1` = '"+txt_tgs1_if.getText()+"' , `tgs2` = '"+txt_tgs2_if.getText()+"' , "
                    + "`tgs3` = '"+txt_tgs3_if.getText()+"' , `uts` = '"+txt_uts_if.getText()+"' , "
                    + "`uas` = '"+txt_uas_if.getText()+"' ,`nilai_absen` = '"+nilaiAbsen+"' , "
                    + "`nilai_tugas` = '"+nilaiTugas+"' , `nilai_uts` = '"+nilaiUTS+"' ,"
                    + "`nilai_uas` = '"+nilaiUAS+"' , "
                    + "`nilai_akhir` = '"+nilaiAkhir+"' , `indek` = '"+index+"' , "
                    + "`keterangan` = '"+keterangan+"' "
                    + "WHERE `kode_simulasi` = '"+tableModel.getValueAt(row,0).toString()+"'";
            stt.executeUpdate(SQL);
            tableModel.setRowCount(0);
            settableload();
            stt.close();
            kon.close();
            membersihkan_teks();
            } catch (Exception e) {
            }
        }
        
    }//GEN-LAST:event_btn_ubah_ifActionPerformed

    private void btn_hapus_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_ifActionPerformed
        // TODO add your handling code here:
        //validasi belum meilih row
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Belum Memilih Row !!!","WARNING",JOptionPane.WARNING_MESSAGE);
        } else {
        
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                    database,
                    user,
                    pass);
            Statement stt = kon.createStatement();
            String SQL = "DELETE FROM `java_akdmk_10116465`.`t_simulasi_nilai` "
                    + "WHERE `kode_simulasi` = '"
                    + tableModel.getValueAt(row, 0).toString() + "';";

            stt.executeUpdate(SQL);
            tableModel.removeRow(row);
            stt.close();
            kon.close();
            membersihkan_teks();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        }
    }//GEN-LAST:event_btn_hapus_ifActionPerformed

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
            java.util.logging.Logger.getLogger(frame_simulasiNilaiAkhir_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_simulasiNilaiAkhir_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_simulasiNilaiAkhir_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_simulasiNilaiAkhir_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame_simulasiNilaiAkhir_if().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal_if;
    private javax.swing.JButton btn_hapus_if;
    private javax.swing.JButton btn_keluar_if;
    private javax.swing.JButton btn_simpan_if;
    private javax.swing.JButton btn_tambah_if;
    private javax.swing.JButton btn_ubah_if;
    private javax.swing.JComboBox<String> cmb_mata_kuliah_if;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelIsi;
    private javax.swing.JPanel panelIsi2;
    private javax.swing.JPanel panelJudul;
    private javax.swing.JTable tabel_mahasiswa_if;
    private javax.swing.JTextField txt_kehadiran_if;
    private javax.swing.JTextField txt_kodeMk_if;
    private javax.swing.JTextField txt_prsAbsen_if;
    private javax.swing.JTextField txt_prsTugas_if;
    private javax.swing.JTextField txt_prsUAS_if;
    private javax.swing.JTextField txt_prsUTS_if;
    private javax.swing.JTextField txt_tgs1_if;
    private javax.swing.JTextField txt_tgs2_if;
    private javax.swing.JTextField txt_tgs3_if;
    private javax.swing.JTextField txt_uas_if;
    private javax.swing.JTextField txt_uts_if;
    // End of variables declaration//GEN-END:variables

   
}
