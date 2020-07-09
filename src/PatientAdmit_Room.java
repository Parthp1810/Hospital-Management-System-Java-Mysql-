import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PatientAdmit_Room extends javax.swing.JFrame {

    public PatientAdmit_Room() {
        initComponents();
        fillcombo();
        cmbRoomNo.setSelectedIndex(-1);
        cmbRoomNo1.setVisible(false);
        Get_Data1();
        GetRecord();
    }
public void Reset()
{
    txtDoctorID.setText("");
    txtDoctorName.setText("");
    PatientID.setText("");
    txtPatientName.setText("");
    txtBloodGroup.setText("");
    txtGender.setText("");
    txtDisease.setText("");
    txtAdmitDate.setText("");    
    txtRemarks.setText("");
    cmbRoomNo.setSelectedIndex(-1);
    ADD.setEnabled(true);
    Upd.setEnabled(false);
    Del.setEnabled(false);
    txtDisease.requestDefaultFocus();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        int rows = model.getRowCount();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                model.removeRow(0);
            }
        }
        DefaultTableModel model1 = (DefaultTableModel) jTable3.getModel();

        int rows1 = model1.getRowCount();
        if (rows1 > 0) {
            for (int i = 0; i < rows1; i++) {
                model1.removeRow(0);
            }
        }
    fillcombo();
    cmbRoomNo1.setVisible(false);
    Get_Data1();
    GetRecord();
    }
    public void fillcombo()
{
     try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","mysql");
            String sql= "select distinct RoomNo from Room where RoomNo != 0 order by RoomNo";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);   
      while(rs.next()){
          String add=rs.getString("RoomNo");
          cmbRoomNo.addItem(add);        
         }
                con.close();
                st.close();
                rs.close();
        }catch(Exception ex){
           JOptionPane.showMessageDialog(this,ex); 
        }
}

public void GetRecord(){
        
       try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","mysql");
            String sql="select * from Doctor where DoctorID != 0  order by DoctorID";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql); 
            DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
            while(rs.next())
            {
                int s1=Integer.parseInt(rs.getString("DoctorID"));
                String s2=rs.getString("Doctorname");                                
                model.addRow(new Object[]{s1,s2});
            }
                con.close();
                st.close();
                rs.close();
         }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
          
}
    }

public void Get_Data1(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","mysql");
            String sql="select * from Patientregistration where PatientID != 0  order by PatientID";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql); 
            DefaultTableModel model=(DefaultTableModel) jTable3.getModel();
            while(rs.next())
            {
                int s1=Integer.parseInt(rs.getString("PatientID"));
                String s2=rs.getString("Patientname");  
                String s3=rs.getString("Gen"); 
                String s4=rs.getString("BG"); 
                model.addRow(new Object[]{s1,s2,s3,s4});
            }
                con.close();
                st.close();
                rs.close();
         }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
          
}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        Back1 = new javax.swing.JButton();
        GetData = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        PatientID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBloodGroup = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDisease = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtAdmitDate = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
        cmbRoomNo = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDoctorID = new javax.swing.JTextField();
        txtDoctorName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRemarks = new javax.swing.JTextArea();
        cmbRoomNo1 = new javax.swing.JComboBox();
        Upd = new javax.swing.JButton();
        Del = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        New = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Back.png"))); // NOI18N
        Back1.setText("Back");
        Back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back1ActionPerformed(evt);
            }
        });
        jPanel3.add(Back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 670, 160, 50));

        GetData.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        GetData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GetData.png"))); // NOI18N
        GetData.setText("Get Data");
        GetData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetDataActionPerformed(evt);
            }
        });
        jPanel3.add(GetData, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 670, 180, 50));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 1, 52)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Patient Admit Room Details");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1214, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor Id", "Doctor Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 370, 168));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Id", "Patient Name", "Gender", "Blood Group"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 370, 278));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 255));
        jLabel8.setText("Patient ID");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        PatientID.setEditable(false);
        PatientID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        PatientID.setForeground(new java.awt.Color(51, 153, 0));
        PatientID.setDisabledTextColor(new java.awt.Color(51, 153, 0));
        PatientID.setEnabled(false);
        jPanel1.add(PatientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 10, 280, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 255));
        jLabel11.setText("Patient Name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        txtPatientName.setEditable(false);
        txtPatientName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtPatientName.setForeground(new java.awt.Color(51, 153, 0));
        txtPatientName.setDisabledTextColor(new java.awt.Color(51, 153, 0));
        txtPatientName.setEnabled(false);
        jPanel1.add(txtPatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 40, 280, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 255));
        jLabel12.setText("Gender");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        txtGender.setEditable(false);
        txtGender.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtGender.setForeground(new java.awt.Color(51, 153, 0));
        txtGender.setDisabledTextColor(new java.awt.Color(51, 153, 0));
        txtGender.setEnabled(false);
        jPanel1.add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 70, 280, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 255));
        jLabel9.setText("Blood Group");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        txtBloodGroup.setEditable(false);
        txtBloodGroup.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtBloodGroup.setForeground(new java.awt.Color(51, 153, 0));
        txtBloodGroup.setDisabledTextColor(new java.awt.Color(51, 153, 0));
        txtBloodGroup.setEnabled(false);
        jPanel1.add(txtBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 100, 280, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 255));
        jLabel13.setText("Disease");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        txtDisease.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtDisease.setForeground(new java.awt.Color(51, 153, 0));
        txtDisease.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiseaseKeyTyped(evt);
            }
        });
        jPanel1.add(txtDisease, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 130, 280, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 255));
        jLabel14.setText("Admit Date");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        txtAdmitDate.setForeground(new java.awt.Color(51, 153, 0));
        txtAdmitDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtAdmitDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtAdmitDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdmitDateKeyTyped(evt);
            }
        });
        jPanel1.add(txtAdmitDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 160, 190, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 255));
        jLabel22.setText("(DD/MM/YYYY)");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 90, 20));

        cmbRoomNo.setEditable(true);
        cmbRoomNo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cmbRoomNo.setForeground(new java.awt.Color(51, 153, 0));
        jPanel1.add(cmbRoomNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 270, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 255));
        jLabel15.setText("Room No.");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 255));
        jLabel16.setText("Doctor ID");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        txtDoctorID.setEditable(false);
        txtDoctorID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtDoctorID.setForeground(new java.awt.Color(51, 153, 0));
        txtDoctorID.setDisabledTextColor(new java.awt.Color(51, 153, 0));
        txtDoctorID.setEnabled(false);
        jPanel1.add(txtDoctorID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 270, 20));

        txtDoctorName.setEditable(false);
        txtDoctorName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtDoctorName.setForeground(new java.awt.Color(51, 153, 0));
        txtDoctorName.setDisabledTextColor(new java.awt.Color(51, 153, 0));
        txtDoctorName.setEnabled(false);
        jPanel1.add(txtDoctorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 270, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 255));
        jLabel17.setText("Doctor Name");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 255));
        jLabel10.setText("Remarks");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        txtRemarks.setColumns(20);
        txtRemarks.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtRemarks.setForeground(new java.awt.Color(51, 153, 0));
        txtRemarks.setRows(5);
        txtRemarks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRemarksKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtRemarks);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 270, 190));

        cmbRoomNo1.setEditable(true);
        cmbRoomNo1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cmbRoomNo1.setForeground(new java.awt.Color(102, 255, 255));
        jPanel1.add(cmbRoomNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 90, -1));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 1240, 480));

        Upd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Upd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Refresh.png"))); // NOI18N
        Upd.setText("Update");
        Upd.setEnabled(false);
        Upd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdActionPerformed(evt);
            }
        });
        jPanel3.add(Upd, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 670, 160, 50));

        Del.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Delete.png"))); // NOI18N
        Del.setText("Delete");
        Del.setEnabled(false);
        Del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelActionPerformed(evt);
            }
        });
        jPanel3.add(Del, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 670, 160, 50));

        ADD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Save.png"))); // NOI18N
        ADD.setText("Save");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });
        jPanel3.add(ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 670, 160, 50));

        New.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New.png"))); // NOI18N
        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        jPanel3.add(New, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 670, 160, 50));

        Search.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Search.png"))); // NOI18N
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        jPanel3.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 670, 160, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 660));

        jLabel2.setBackground(new java.awt.Color(211, 219, 238));
        jLabel2.setOpaque(true);
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 660, 1390, 64));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1359, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(1375, 763));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_Back1ActionPerformed

    private void GetDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetDataActionPerformed
        PatientAdmit_RoomRecord frm = new PatientAdmit_RoomRecord();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_GetDataActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try {
            int row = jTable2.getSelectedRow();
            String table_click = jTable2.getModel().getValueAt(row, 0).toString();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","mysql");
            String sql = "select * from Doctor where DoctorID = '" + table_click + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String add1 = rs.getString("DoctorID");
                txtDoctorID.setText(add1);
                String add2 = rs.getString("Doctorname");
                txtDoctorName.setText(add2);
            }
            con.close();
            st.close();
            rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        try {
            int row = jTable2.getSelectedRow();
            String table_click = jTable2.getModel().getValueAt(row, 0).toString();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","mysql");
            String sql = "select * from PatientRegistration where PatientID = '" + table_click + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String add1 = rs.getString("PatientID");
                PatientID.setText(add1);
                String add2 = rs.getString("Patientname");
                txtPatientName.setText(add2);
                String add9 = rs.getString("BG");
                txtBloodGroup.setText(add9);
                String add11 = rs.getString("Gen");
                txtGender.setText(add11);
            }
            con.close();
            st.close();
            rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void txtDiseaseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiseaseKeyTyped
        String s = txtDisease.getText();
        if (s.length() == 15) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDiseaseKeyTyped

    private void txtAdmitDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdmitDateKeyTyped
        String s = txtAdmitDate.getText();
        if (s.length() == 10) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtAdmitDateKeyTyped

    private void txtRemarksKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemarksKeyTyped
        String s = txtRemarks.getText();
        if (s.length() == 50) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtRemarksKeyTyped

    private void UpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdActionPerformed
        try {
            if (PatientID.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Retrieve Patient ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtPatientName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Retrieve Patient Name", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtGender.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Retrieve Gender", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtBloodGroup.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Retrieve Blood Group", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtDisease.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Disease", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtAdmitDate.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Admit Date", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (cmbRoomNo.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Select Room No.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtDoctorID.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Retrieve Doctor Id", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtDoctorName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Retrieve Doctor Name", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","mysql");
            Statement st = con.createStatement();
            String s = cmbRoomNo.getSelectedItem().toString();
            String t = cmbRoomNo1.getSelectedItem().toString();
            if (!t.equals(s)) {
                String sql = "Select RoomNo from Room where RoomNo= " + cmbRoomNo.getSelectedItem() + " and RoomStatus='Booked'";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Room is already booked", "Error", JOptionPane.ERROR_MESSAGE);
                    cmbRoomNo.setSelectedItem("");
                    cmbRoomNo.requestDefaultFocus();
                    return;
                }
            }
            Statement stmt1 = con.createStatement();
            String sql1 = " update AdmitPatient_Room set  PatientID=" + PatientID.getText() + ",PatientName='" + txtPatientName.getText() + "',Gender='" + txtGender.getText() + "',BloodGroup='" + txtBloodGroup.getText() + "',Disease='" + txtDisease.getText() + "',AdmitDate='" + txtAdmitDate.getText() + "',RoomNo='" + cmbRoomNo.getSelectedItem() + "',DoctorID=" + txtDoctorID.getText() + ",DoctorName='" + txtDoctorName.getText() + "',AP_Remarks='" + txtRemarks.getText() + "' where PatientID= " + PatientID.getText() + " and DoctorID=" + txtDoctorID.getText() + "";
            int rowsEffected1 = stmt1.executeUpdate(sql1);
            /*Statement stmt2 = con.createStatement();
            String sql2 = " update AdmitPatient_RoomMain set  PatientID=" + PatientID.getText() + ",PatientName='" + txtPatientName.getText() + "',Gen='" + txtGender.getText() + "',BG='" + txtBloodGroup.getText() + "',Disease='" + txtDisease.getText() + "',AdmitDate='" + txtAdmitDate.getText() + "',RoomNo=" + cmbRoomNo.getSelectedItem() + ",DoctorID=" + txtDoctorID.getText() + ",DoctorName='" + txtDoctorName.getText() + "',AP_Remarks='" + txtRemarks.getText() + "' where PatientID= " + PatientID.getText() + "";
            int rowsEffected2 = stmt2.executeUpdate(sql2);*/
            if (!t.equals(s)) {
                Statement stmt3 = con.createStatement();
                String sql3 = "update room set RoomStatus='Booked' where RoomNo=" + cmbRoomNo.getSelectedItem() + "";
                int rowsEffected3 = stmt3.executeUpdate(sql3);
            }
            if (!t.equals(s)) {
                Statement stmt4 = con.createStatement();
                String sql4 = "update room set RoomStatus='Vacant' where RoomNo=" + cmbRoomNo1.getSelectedItem() + "";
                int rowsEffected4 = stmt4.executeUpdate(sql4);
            }
            JOptionPane.showMessageDialog(this, "Data Successfully Updated", "Patient Admit Room Record", JOptionPane.INFORMATION_MESSAGE);
            Reset();
            con.close();
            st.close();
            stmt1.close();
            //stmt2.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_UpdActionPerformed

    private void DelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelActionPerformed
        try {
            int P = JOptionPane.showConfirmDialog(this, " Are you sure want to delete ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","mysql");
                Statement stmt = con.createStatement();
                String sql = "delete from AdmitPatient_Room where PatientID = " + PatientID.getText() + "";
                int rowsEffected = stmt.executeUpdate(sql);
                /*Statement stmt1 = con.createStatement();
                String sql1 = "delete from AdmitPatient_RoomMain where PatientID = " + PatientID.getText() + "";
                int rowsEffected1 = stmt1.executeUpdate(sql1);*/
                Statement stmt2 = con.createStatement();
                String sql2 = "update Room set RoomStatus='Vacant'";
                int rowsEffected2 = stmt2.executeUpdate(sql2);
                JOptionPane.showMessageDialog(this, "Data Successfully Deleted", "Patient Admit Room Record", JOptionPane.INFORMATION_MESSAGE);
                Reset();
                con.close();
                stmt.close();
                //stmt1.close();
                stmt2.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_DelActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        try {
            if (PatientID.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Retrieve Patient ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtPatientName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Retrieve Patient Name", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtGender.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Retrieve Gender", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtBloodGroup.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Retrieve Blood Group", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtDisease.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Disease", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtAdmitDate.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Admit Date", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (cmbRoomNo.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Select Room No.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtDoctorID.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Retrieve Doctor Id", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtDoctorName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Retrieve Doctor Name", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","mysql");
            Statement stmt = con.createStatement();
            String sql = "Select RoomNo from Room where RoomNo= '" + cmbRoomNo.getSelectedItem() + "' and RoomStatus='Booked'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Room is already booked", "Error", JOptionPane.ERROR_MESSAGE);
                cmbRoomNo.setSelectedItem("");
                cmbRoomNo.requestDefaultFocus();
                return;
            } else {
                Statement stmt1 = con.createStatement();
                String sql1 = "Select PatientID,AdmitDate from AdmitPatient_Room where PatientID= '" + PatientID.getText() + "' and AdmitDate='" + txtAdmitDate + "'";
                ResultSet rs1 = stmt1.executeQuery(sql1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Record already exists", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    /*Statement stmt2 = con.createStatement();
                    String sql2 = "insert into AdmitPatient_RoomMain(PatientID,PatientName,Gen,BG,Disease,AdmitDate,RoomNo,DoctorID,DoctorName,AP_Remarks)values('" + PatientID.getText() + "','" + txtPatientName.getText() + "','" + txtGender.getText() + "','" + txtBloodGroup.getText() + "','" + txtDisease.getText() + "','" + txtAdmitDate.getText() + "'," + cmbRoomNo.getSelectedItem() + ",'" + txtDoctorID.getText() + "','" + txtDoctorName.getText() + "','" + txtRemarks.getText() + "')";
                    int rowsEffected2 = stmt2.executeUpdate(sql2);*/
                    Statement stmt3 = con.createStatement();
                    String sql3 = "insert into AdmitPatient_Room(PatientID,PatientName,Gender,BloodGroup,Disease,AdmitDate,RoomNo,DoctorID,DoctorName,AP_Remarks)values('" + PatientID.getText() + "','" + txtPatientName.getText() + "','" + txtGender.getText() + "','" + txtBloodGroup.getText() + "','" + txtDisease.getText() + "','" + txtAdmitDate.getText() + "'," + cmbRoomNo.getSelectedItem() + ",'" + txtDoctorID.getText() + "','" + txtDoctorName.getText() + "','" + txtRemarks.getText() + "')";
                    int rowsEffected3 = stmt3.executeUpdate(sql3);
                    Statement stmt4 = con.createStatement();
                    String sql4 = "update room set RoomStatus='Booked' where RoomNo='" + cmbRoomNo.getSelectedItem() + "'";
                    int rowsEffected4 = stmt4.executeUpdate(sql4);
                    JOptionPane.showMessageDialog(this, "Data Successfully Saved", "Patient Admit Room Record", JOptionPane.INFORMATION_MESSAGE);
                    stmt1.close();
                    rs1.close();
                    //stmt2.close();
                    stmt3.close();
                    stmt4.close();
                }

                Reset();
                con.close();
                stmt.close();
                rs.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_ADDActionPerformed

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        Reset();
    }//GEN-LAST:event_NewActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        Search_PatientAdmit_Room frm = new Search_PatientAdmit_Room();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SearchActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientAdmit_Room().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton ADD;
    public static javax.swing.JButton Back1;
    public static javax.swing.JButton Del;
    public static javax.swing.JButton GetData;
    public static javax.swing.JButton New;
    public javax.swing.JTextField PatientID;
    private javax.swing.JButton Search;
    public static javax.swing.JButton Upd;
    public javax.swing.JComboBox cmbRoomNo;
    public javax.swing.JComboBox cmbRoomNo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    public javax.swing.JFormattedTextField txtAdmitDate;
    public javax.swing.JTextField txtBloodGroup;
    public javax.swing.JTextField txtDisease;
    public javax.swing.JTextField txtDoctorID;
    public javax.swing.JTextField txtDoctorName;
    public javax.swing.JTextField txtGender;
    public javax.swing.JTextField txtPatientName;
    public javax.swing.JTextArea txtRemarks;
    // End of variables declaration//GEN-END:variables
}
