/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campus_placement_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author majma
 */
public class SendMail extends javax.swing.JFrame {

    /**
     * Creates new form SendMail
     */
    String[][]arr;
    String[][]arr2;
    public int len, um;
    public static String typed = "('A-C', 'S-C')", name="Muhammed Ajmal", username="majmals1998@gmail.com", emailid;
    public static char user = 'C';
    public SendMail(String msgtype, String usrname, String uname, char utype) {
        
        typed = msgtype;
        name = usrname;
        username = uname;
        user = utype;
        initComponents();
        
        
        jPanel1.hide();
        jPanel3.hide();
        wname.setText(usrname);        
        try{
            int cx = 0;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from srmail where status=0 and mailtype in "+typed+" and tmailid='"+username+"'");
            rs.next();
            len = Integer.parseInt(rs.getString("count(*)"));
            arr = new String[len][6];
            System.err.println(len);
            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            dtm.setRowCount(len);
            jTable3.setModel(dtm);
            if(len>0){
                rs = st.executeQuery("select * from srmail where status=0 and mailtype in "+typed+" and tmailid='"+username+"'");
   
                while(rs.next()){
                    String tdat = "<html><body><span style='color:#420420;font-weight:bold;font-family:georgia;font-size:10px;'>" + rs.getString("sname") + "<span><br/>";
                    tdat += "<span style='color:black;font-family:consolas;font-size:11px;'>"+rs.getString("mailid")+"</span><br/><span style='color:black;font-family:consolas;font-size:10px;'>"+rs.getString("date")+ "</span></body></html>";
                    jTable3.setValueAt(tdat, cx, 0);
                    String[]tlist = new String[5];
                    tlist[0]=rs.getString("sname");
                    tlist[1]=rs.getString("mailid");
                    tlist[2]=rs.getString("message");
                    tlist[3]=rs.getString("date");
                    tlist[4]=rs.getString("status");
                    emailid = rs.getString("mailid");
                    arr[cx]=tlist;
                    cx++;
                }
                
            }
            cx = 0;
            rs = st.executeQuery("select count(*) from srmail where status=1 and mailtype in "+typed+" and tmailid='"+username+"'");
            rs.next();
            len = Integer.parseInt(rs.getString("count(*)"));
            arr2 = new String[len][6];

            dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(len);
            jTable1.setModel(dtm);  
            
            if(len>0){
                //System.err.println("select * from srmail where status=1 and mailtype in "+typed+" and tmailid='"+username+"'");
                rs = st.executeQuery("select * from srmail where status=1 and mailtype in "+typed+" and tmailid='"+username+"'");
                
                 
                while(rs.next()){
                    String tdat = "<html><body><span style='color:#420420;font-weight:bold;font-family:georgia;font-size:10px;'>" + rs.getString("sname") + "<span><br/>";
                    tdat += "<span style='color:black;font-family:consolas;font-size:11px;'>"+rs.getString("mailid")+"</span><br/><span style='color:black;font-family:consolas;font-size:10px;'>"+rs.getString("date")+ "</span></body></html>";
                    jTable1.setValueAt(tdat, cx, 0);
                    String[]tlist = new String[5];
                    tlist[0]=rs.getString("sname");
                    tlist[1]=rs.getString("mailid");
                    tlist[2]=rs.getString("message");
                    tlist[3]=rs.getString("date");
                    tlist[4]=rs.getString("status");
                    emailid = rs.getString("mailid");
                    arr2[cx]=tlist;
                    cx++;
                }
                System.err.println("Tab: "+len);
                System.err.println(arr2.length);
                
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
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

        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        inboxpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextPane();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        rmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rcon = new javax.swing.JTextPane();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        chooseres = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        wname = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mail");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Compose");
        jButton2.setAutoscrolls(true);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 22, 150, 40));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 60, 378, 42));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 60, 135, 42));

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 66, 148, 35));

        jPanel2.setBackground(new java.awt.Color(12, 49, 69));

        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Readed Messages"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(60);
        jTable1.setRowMargin(0);
        jTable1.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jTable3.setAutoCreateRowSorter(true);
        jTable3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Unreaded Messages"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setColumnSelectionAllowed(true);
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable3.setRowHeight(60);
        jTable3.setRowMargin(0);
        jTable3.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jTable3.setShowHorizontalLines(false);
        jTable3.setShowVerticalLines(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable3);
        jTable3.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 710, 300));

        jPanel1.setBackground(new java.awt.Color(12, 49, 69));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        jPanel1.setForeground(new java.awt.Color(0, 0, 51));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inboxpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        text.setContentType("text/html");
        text.setDragEnabled(true);
        jScrollPane1.setViewportView(text);

        inboxpanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 230));

        jPanel1.add(inboxpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 17, 680, 230));

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 250, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 135, 710, 280));

        jPanel3.setBackground(new java.awt.Color(12, 49, 69));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(0, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel4.setText("Reciever Mail ID");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 120, 30));
        jPanel4.add(rmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 490, 30));

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel2.setText("Content");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 100, 30));

        rcon.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jScrollPane2.setViewportView(rcon);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 490, 160));

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Send");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 203, 90, 40));

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Reset");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 90, 40));

        chooseres.setBackground(new java.awt.Color(0, 0, 0));
        chooseres.setForeground(new java.awt.Color(255, 255, 255));
        chooseres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Student", "Coordinator" }));
        jPanel4.add(chooseres, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 130, 30));

        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Use <br> to break a line;");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 490, 20));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 690, 280));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 132, 710, 300));
        jPanel3.getAccessibleContext().setAccessibleName("");

        wname.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        wname.setForeground(new java.awt.Color(0, 204, 204));
        wname.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wname.setText("Muhammed Ajmal");
        getContentPane().add(wname, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 220, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mail.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jPanel1.hide();
        jPanel2.hide();
        jPanel3.show();
    }//GEN-LAST:event_jButton2ActionPerformed
    int cm = 1, cp = len-1;
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        rmail.setText("");
        rcon.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String mdat = chooseres.getSelectedItem().toString();
        String tmailid = rmail.getText();
        if(mdat.equals("Admin") && user=='S')
            mdat = "S-A";
        else if(mdat.equals("Coordinator") && user=='S')
            mdat = "S-C";
        else if(mdat.equals("Coordinator") && user=='A')
            mdat = "A-C";
        else if(mdat.equals("Student") && user=='A')
            mdat = "A-S";
        else if(mdat.equals("Admin") && user=='C')
            mdat = "C-A";
        else if(mdat.equals("Student") && user=='C')
            mdat = "C-S";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
            Statement st = con.createStatement();
            Date d = new Date();
            StudentInfo sx = new StudentInfo();
            String date;
            date = sx.zero(d.getDate())+"/"+sx.zero(d.getMonth())+"/"+sx.zero(d.getYear()+1900)+" "+sx.zero(d.getHours())+":"+sx.zero(d.getMinutes())+":"+sx.zero(d.getSeconds());
            if(!rmail.getText().equals("") && !rcon.getText().equals("")){
                st.executeUpdate("insert into srmail values('"+username+"','"+name+"','"+tmailid+"','"+mdat+"','"+rcon.getText()+"','"+date+"', 0)");
                
                JOptionPane.showMessageDialog(rmail, "Mail Sended Successfully");
            }else{
                JOptionPane.showMessageDialog(rmail, "Please enter the fields!");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rcon, "Mail Sended Failed");
        }
    }//GEN-LAST:event_jButton6ActionPerformed
String mtype1="", mtype2 = "";
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        if(user == 'A'){
            jComboBox1.addItem("Student");
            jComboBox1.addItem("Coordinator");
            mtype1 = "'S-A'";
            mtype2 = "'C-A'";
            
        }else if(user == 'S'){
            jComboBox1.addItem("Admin");
            jComboBox1.addItem("Coordinator");
            mtype1 = "'A-S'";
            mtype2 = "'C-S'";
            
        }else if(user == 'C'){
            jComboBox1.addItem("Student");
            jComboBox1.addItem("Admin");
            mtype1 = "'S-C'";
            mtype2 = "'A-C'";
        }
    }//GEN-LAST:event_formWindowOpened

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        jPanel2.show();
        jPanel1.hide();
        jPanel3.hide();
        if(jComboBox1.getSelectedIndex() == 0){
            try{
                int cx = 0;
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select count(*) from srmail where status=0 and mailtype = "+mtype1+" and tmailid='"+username+"'");
                rs.next();
                len = Integer.parseInt(rs.getString("count(*)"));
                arr = new String[len][6];
                //System.err.println(len);
                DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
                dtm.setRowCount(len);
                jTable3.setModel(dtm); 
                if(len>0){
                    rs = st.executeQuery("select * from srmail where status=0 and mailtype = "+mtype1+" and tmailid='"+username+"'");
                      
                    while(rs.next()){
                        String tdat = "<html><body><span style='color:#420420;font-weight:bold;font-family:georgia;font-size:10px;'>" + rs.getString("sname") + "<span><br/>";
                        tdat += "<span style='color:black;font-family:consolas;font-size:11px;'>"+rs.getString("mailid")+"</span><br/><span style='color:black;font-family:consolas;font-size:10px;'>"+rs.getString("date")+ "</span></body></html>";
                        jTable3.setValueAt(tdat, cx, 0);
                        String[]tlist = new String[5];
                        tlist[0]=rs.getString("sname");
                        tlist[1]=rs.getString("mailid");
                        tlist[2]=rs.getString("message");
                        tlist[3]=rs.getString("date");
                        tlist[4]=rs.getString("status");
                        emailid = rs.getString("mailid");
                        arr[cx]=tlist;
                        cx++;
                    }

                }
                cx = 0;
                //System.err.println("select count(*) from srmail where status=1 and mailtype = "+mtype2+" and tmailid='"+username+"'");
                rs = st.executeQuery("select count(*) from srmail where status=1 and mailtype = "+mtype2+" and tmailid='"+username+"'");
                rs.next();
                len = Integer.parseInt(rs.getString("count(*)"));
                //System.err.println("Admin Unreaded = "+len);
                dtm = (DefaultTableModel) jTable1.getModel();
                dtm.setRowCount(len);
                jTable1.setModel(dtm); 
                if(len > 0){
                    //System.err.println("select * from srmail where status=1 and mailtype = "+mtype1+" and tmailid='"+username+"'");
                    rs = st.executeQuery("select * from srmail where status=1 and mailtype = "+mtype1+" and tmailid='"+username+"'");
                    
                    arr2 = new String[len][6];
                      
                    while(rs.next()){
                        String tdat = "<html><body><span style='color:#420420;font-weight:bold;font-family:georgia;font-size:10px;'>" + rs.getString("sname") + "<span><br/>";
                        tdat += "<span style='color:black;font-family:consolas;font-size:11px;'>"+rs.getString("mailid")+"</span><br/><span style='color:black;font-family:consolas;font-size:10px;'>"+rs.getString("date")+ "</span></body></html>";
                        jTable1.setValueAt(tdat, cx, 0);
                        //System.err.println(tdat);
                        String[]tlist = new String[5];
                        tlist[0]=rs.getString("sname");
                        tlist[1]=rs.getString("mailid");
                        tlist[2]=rs.getString("message");
                        tlist[3]=rs.getString("date");
                        tlist[4]=rs.getString("status");
                        emailid = rs.getString("mailid");
                        arr2[cx]=tlist;
                        cx++;
                    }

                }



            }catch(Exception e){
//                e.printStackTrace();
            }
        }
        
        if(jComboBox1.getSelectedIndex() == 1){
            try{
                int cx = 0;
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select count(*) from srmail where status=0 and mailtype = "+mtype1+" and tmailid='"+username+"'");
                rs.next();
                len = Integer.parseInt(rs.getString("count(*)"));
                arr = new String[len][6];
                //System.err.println(len);
                DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
                dtm.setRowCount(len);
                jTable3.setModel(dtm);
                if(len>0){
                    rs = st.executeQuery("select * from srmail where status=0 and mailtype = "+mtype1+" and tmailid='"+username+"'");
                      
                    while(rs.next()){
                        String tdat = "<html><body><span style='color:#420420;font-weight:bold;font-family:georgia;font-size:10px;'>" + rs.getString("sname") + "<span><br/>";
                        tdat += "<span style='color:black;font-family:consolas;font-size:11px;'>"+rs.getString("mailid")+"</span><br/><span style='color:black;font-family:consolas;font-size:10px;'>"+rs.getString("date")+ "</span></body></html>";
                        jTable3.setValueAt(tdat, cx, 0);
                        String[]tlist = new String[5];
                        tlist[0]=rs.getString("sname");
                        tlist[1]=rs.getString("mailid");
                        tlist[2]=rs.getString("message");
                        tlist[3]=rs.getString("date");
                        tlist[4]=rs.getString("status");
                        emailid = rs.getString("mailid");
                        arr[cx]=tlist;
                        cx++;
                    }

                }
                cx = 0;
                rs = st.executeQuery("select count(*) from srmail where status=1 and mailtype = "+mtype2+" and mailid='"+username+"'");
                rs.next();
                len = Integer.parseInt(rs.getString("count(*)"));
                arr2 = new String[len][6];
                //System.err.println(len);
                dtm = (DefaultTableModel) jTable1.getModel();
                    dtm.setRowCount(len);
                    jTable1.setModel(dtm); 
                if(len>0){
                    rs = st.executeQuery("select * from srmail where status=1 and mailtype = "+mtype2+" and mailid='"+username+"'");
                      
                    while(rs.next()){
                        String tdat = "<html><body><span style='color:#420420;font-weight:bold;font-family:georgia;font-size:10px;'>" + rs.getString("sname") + "<span><br/>";
                        tdat += "<span style='color:black;font-family:consolas;font-size:11px;'>"+rs.getString("mailid")+"</span><br/><span style='color:black;font-family:consolas;font-size:10px;'>"+rs.getString("date")+ "</span></body></html>";
                        jTable1.setValueAt(tdat, cx, 0);
                        String[]tlist = new String[5];
                        tlist[0]=rs.getString("sname");
                        tlist[1]=rs.getString("mailid");
                        tlist[2]=rs.getString("message");
                        tlist[3]=rs.getString("date");
                        tlist[4]=rs.getString("status");
                        emailid = rs.getString("mailid");
                        arr2[cx]=tlist;
                        cx++;
                    }

                }



            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        int index = jTable3.getSelectedRow();
        //System.err.println(arr[jTable3.getSelectedRow()][0]);
        jTable3.clearSelection();
        jPanel1.show();
        jPanel2.hide();
        jPanel3.hide();
            String email = "<br/><span style='font-weight:bold;font-size:12px;color:black;font-family:consolas;'>Sender: </span>";
            email += "<span style='font-family:consolas; font-weight:bold;font-size:12px'>"+arr[index][1]+"</span><br/>";
            String msgbody ="<br/><span style='font-size:11px'>"+arr[index][2]+"</span><br/><br/>";
            String dtime = "<span style='font-weight:bold;font-size:12px;color:black;font-family:consolas;'>Date & Time: "+arr[index][3]+"</span>";
            text.setText("<html><body>"+msgbody+email+dtime+"<br/><br/><br/></body></html>");
            text.setEditable(false);
            
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
            Statement st = con.createStatement();
            st.executeUpdate("update srmail set status=1 where mailid='"+emailid+"' and tmailid='"+arr[index][1]+"'");
            con.close();
        } catch (Exception e) {
            
        }
        jPanel2.hide();
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        //System.err.println(arr2[jTable1.getSelectedRow()][0]);
        jTable1.clearSelection();
        jPanel1.show();
        jPanel2.hide();
        jPanel3.hide();
            String email = "<br/><span style='font-weight:bold;font-size:12px;color:black;font-family:consolas;'>Sender: </span>";
            email += "<span style='font-family:consolas; font-weight:bold;font-size:12px'>"+arr2[index][1]+"</span><br/>";
            String msgbody ="<br/><span style='font-size:11px'>"+arr2[index][2]+"</span><br/><br/>";
            String dtime = "<span style='font-weight:bold;font-size:12px;color:black;font-family:consolas;'>Date & Time: "+arr2[index][3]+"</span>";
            text.setText("<html><body>"+msgbody+email+dtime+"<br/><br/><br/></body></html>");
            text.setEditable(false);
            
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
            Statement st = con.createStatement();
            st.executeUpdate("update srmail set status=1 where mailid='"+emailid+"' and tmailid='"+arr2[index][1]+"'");
            con.close();
        } catch (Exception e) {
            
        }
        jPanel2.hide();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jPanel1.hide();
        jPanel2.show();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        String squery = jTextField1.getText();
        
        
        try{
            int cx = 0;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from srmail where status=0 and mailtype in "+typed+" and tmailid='"+username+"' and mailid='"+squery+"'");
            rs.next();
            len = Integer.parseInt(rs.getString("count(*)"));
            arr = new String[len][6];
            //System.err.println(len);
            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
                dtm.setRowCount(len);
                jTable3.setModel(dtm); 
            if(len>0){
                rs = st.executeQuery("select * from srmail where status=0 and mailtype in "+typed+" and tmailid='"+username+"' and mailid='"+squery+"'");
                  
                while(rs.next()){
                    String tdat = "<html><body><span style='color:#420420;font-weight:bold;font-family:georgia;font-size:10px;'>" + rs.getString("sname") + "<span><br/>";
                    tdat += "<span style='color:black;font-family:consolas;font-size:11px;'>"+rs.getString("mailid")+"</span><br/><span style='color:black;font-family:consolas;font-size:10px;'>"+rs.getString("date")+ "</span></body></html>";
                    jTable3.setValueAt(tdat, cx, 0);
                    String[]tlist = new String[5];
                    tlist[0]=rs.getString("sname");
                    tlist[1]=rs.getString("mailid");
                    tlist[2]=rs.getString("message");
                    tlist[3]=rs.getString("date");
                    tlist[4]=rs.getString("status");
                    emailid = rs.getString("mailid");
                    arr[cx]=tlist;
                    cx++;
                }
                
            }
            cx = 0;
            rs = st.executeQuery("select count(*) from srmail where status=1 and mailtype in "+typed+" and tmailid='"+username+"' and mailid='"+squery+"'");
            rs.next();
            len = Integer.parseInt(rs.getString("count(*)"));
            arr2 = new String[len][6];
            //System.err.println(len+"Where");
            dtm = (DefaultTableModel) jTable1.getModel();
                dtm.setRowCount(len);
                jTable1.setModel(dtm); 
            if(len>0){
                //System.err.println("select * from srmail where status=1 and mailtype in "+typed+" and tmailid='"+username+"'");
                rs = st.executeQuery("select * from srmail where status=1 and mailtype in "+typed+" and tmailid='"+username+"' and mailid='"+squery+"'");
                
                  
                while(rs.next()){
                    String tdat = "<html><body><span style='color:#420420;font-weight:bold;font-family:georgia;font-size:10px;'>" + rs.getString("sname") + "<span><br/>";
                    tdat += "<span style='color:black;font-family:consolas;font-size:11px;'>"+rs.getString("mailid")+"</span><br/><span style='color:black;font-family:consolas;font-size:10px;'>"+rs.getString("date")+ "</span></body></html>";
                    jTable1.setValueAt(tdat, cx, 0);
                    String[]tlist = new String[5];
                    tlist[0]=rs.getString("sname");
                    tlist[1]=rs.getString("mailid");
                    tlist[2]=rs.getString("message");
                    tlist[3]=rs.getString("date");
                    tlist[4]=rs.getString("status");
                    emailid = rs.getString("mailid");
                    arr2[cx]=tlist;
                    cx++;
                }
                
            }
            
            
            
        }catch(Exception e){
            
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(SendMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendMail(typed, name, username, user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> chooseres;
    private javax.swing.JPanel inboxpanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane rcon;
    private javax.swing.JTextField rmail;
    private javax.swing.JTextPane text;
    private javax.swing.JLabel wname;
    // End of variables declaration//GEN-END:variables
}
