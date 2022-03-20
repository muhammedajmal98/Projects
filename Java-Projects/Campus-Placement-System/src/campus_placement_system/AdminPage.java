/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campus_placement_system;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author majma
 */
public class AdminPage extends javax.swing.JFrame {

    /**
     * Creates new form AdminPage
     */
    public static String namer = "Muhammed Ajmal"; 
    public void passName(String getName){
//        namer = getName;
    }
    public String convertTime(int hour, int minute, int second){
        String h=String.valueOf(hour), m=String.valueOf(minute), s=String.valueOf(second), n;
        if(hour>=12)
            n = "PM";
        else
            n = "AM";
        hour %= 12;
        h=String.valueOf(hour);
        if(hour<10)
            h = "0"+String.valueOf(hour);
        if(minute<10)
            m = "0"+String.valueOf(minute);
        if(second<10)
            s= "0"+String.valueOf(second);
        return h+":"+m+":"+s+" "+n;
    }
    public AdminPage() {
        initComponents();
        this.setResizable(false);
        this.setSize(805, 615);
        jButton5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        companies.hide();
        users.hide();
        vacancies.hide();
        msgcount.setText("0");
        vacancycount.setText("0");
        comapanycount.setText("0");
        usercount.setText("0");
        new Thread(){
            public void run() {
            try {
                int count = 1;
                while(true){
                    Date d = new Date();
                    timer.setText(convertTime(d.getHours(), d.getMinutes(), d.getSeconds()));
                    count++;
                    Thread.sleep(1000);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }.start();
        
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
            Statement st = con.createStatement();
            int count = 0;
            ResultSet rs = st.executeQuery("select count(*) from student");
            rs.next();
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            count = Integer.parseInt(rs.getString("count(*)"));
            dtm.setRowCount(count);
            jTable2.setModel(dtm);
            count = 0;
            rs = st.executeQuery("select * from student");
            while(rs.next()){
                jTable2.setValueAt(rs.getString("sid"), count, 0);
                jTable2.setValueAt(rs.getString("sname"), count, 1);
                jTable2.setValueAt(rs.getString("course"), count, 2);
                jTable2.setValueAt(rs.getString("batch"), count, 3);
                count++;
            }
            usercount.setText(String.valueOf(count));
            rs = st.executeQuery("select count(*) from coordinator");
            rs.next();
            dtm = (DefaultTableModel) jTable3.getModel();
            count = Integer.parseInt(rs.getString("count(*)"));
            dtm.setRowCount(count);
            jTable3.setModel(dtm);
            count = 0;
            rs = st.executeQuery("select * from coordinator");
            while(rs.next()){
                jTable3.setValueAt(rs.getString("cname"), count, 0);
                jTable3.setValueAt(rs.getString("address"), count, 1);
                jTable3.setValueAt(rs.getString("phone"), count, 2);
                jTable3.setValueAt(rs.getString("ename"), count, 3);
                count++;
            }
            comapanycount.setText(String.valueOf(count));
            rs = st.executeQuery("select count(*) from srmail where status=0 and mailtype='S-A'");
            rs.next();
            msgcount.setText(rs.getString("count(*)"));
            rs = st.executeQuery("select count(*) from vacancies");
            rs.next();
            dtm = (DefaultTableModel) jTable1.getModel();
            count = Integer.parseInt(rs.getString("count(*)"));
            dtm.setRowCount(count);
            jTable1.setModel(dtm);
            count = 0;
            rs = st.executeQuery("select * from vacancies");
            while(rs.next()){
                jTable1.setValueAt(rs.getString("job"), count, 0);
                jTable1.setValueAt(rs.getString("description"), count, 1);
                jTable1.setValueAt(rs.getString("cname"), count, 2);
                jTable1.setValueAt(rs.getString("address"), count, 3);
                jTable1.setValueAt(rs.getString("vacancies"), count, 4);
                count++;
            }
            vacancycount.setText(String.valueOf(count));
        } catch (Exception e) {
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

        jButton5 = new javax.swing.JButton();
        timer = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        dashboard = new javax.swing.JPanel();
        vacancycount = new javax.swing.JLabel();
        comapanycount = new javax.swing.JLabel();
        usercount = new javax.swing.JLabel();
        welcomename = new javax.swing.JLabel();
        msgcount = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        vacancies = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        companies = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        users = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin Page");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 50, 40));

        timer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        timer.setForeground(new java.awt.Color(255, 255, 255));
        timer.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        timer.setText("11:40 PM");
        timer.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(timer, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 16, 200, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ico2.jpg"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 210, 60));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ico3.jpg"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 210, 60));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ico4.jpg"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 210, 60));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ico.jpg"))); // NOI18N
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 210, 60));

        dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vacancycount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        vacancycount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vacancycount.setText("120");
        dashboard.add(vacancycount, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 80, 70));

        comapanycount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        comapanycount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comapanycount.setText("120");
        dashboard.add(comapanycount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 80, 70));

        usercount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        usercount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usercount.setText("120");
        dashboard.add(usercount, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 80, 70));

        welcomename.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        welcomename.setText("Welcome Muhammed Ajmal");
        dashboard.add(welcomename, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 250, 30));

        msgcount.setBackground(new java.awt.Color(255, 255, 255));
        msgcount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        msgcount.setBorder(null);
        msgcount.setBorderPainted(false);
        msgcount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        msgcount.setFocusPainted(false);
        msgcount.setLabel("120");
        msgcount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msgcountActionPerformed(evt);
            }
        });
        dashboard.add(msgcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 70, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/panel1.jpg"))); // NOI18N
        dashboard.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 520));

        getContentPane().add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 520, 520));

        vacancies.setBackground(new java.awt.Color(255, 255, 255));
        vacancies.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Job Position", "Job Description", "Company Name", "Address", "Vacancies"
            }
        ));
        jTable1.setAlignmentX(1.0F);
        jTable1.setAlignmentY(1.0F);
        jTable1.setEditingColumn(1);
        jTable1.setEditingRow(1);
        jTable1.setFillsViewportHeight(true);
        jTable1.setFocusCycleRoot(true);
        jTable1.setFocusTraversalPolicyProvider(true);
        jTable1.setInheritsPopupMenu(true);
        jTable1.setMinimumSize(new java.awt.Dimension(500, 390));
        jTable1.setName("Vacancies"); // NOI18N
        jTable1.setPreferredSize(new java.awt.Dimension(550, 375));
        jTable1.setRowHeight(26);
        jTable1.setRowMargin(2);
        jTable1.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        vacancies.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 510, 420));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Vacancies");
        vacancies.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 40));

        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("*Click twice to see the detailed content of any cells.");
        vacancies.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 470, -1));

        getContentPane().add(vacancies, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 520, 520));

        companies.setBackground(new java.awt.Color(255, 255, 255));
        companies.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setAutoscrolls(true);

        jTable3.setAutoCreateRowSorter(true);
        jTable3.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Address", "Phone", "Coordinator"
            }
        ));
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable3.setEditingColumn(1);
        jTable3.setEditingRow(1);
        jTable3.setFillsViewportHeight(true);
        jTable3.setFocusCycleRoot(true);
        jTable3.setFocusTraversalPolicyProvider(true);
        jTable3.setInheritsPopupMenu(true);
        jTable3.setName("Vacancies"); // NOI18N
        jTable3.setRowHeight(26);
        jTable3.setRowMargin(4);
        jTable3.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jTable3.setSurrendersFocusOnKeystroke(true);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable3MousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        companies.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 510, 420));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setText("Companies");
        companies.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 40));

        getContentPane().add(companies, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 520, 520));

        users.setBackground(new java.awt.Color(255, 255, 255));
        users.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Course", "Batch"
            }
        ));
        jTable2.setEditingColumn(1);
        jTable2.setEditingRow(1);
        jTable2.setFillsViewportHeight(true);
        jTable2.setFocusCycleRoot(true);
        jTable2.setFocusTraversalPolicyProvider(true);
        jTable2.setInheritsPopupMenu(true);
        jTable2.setName("Vacancies"); // NOI18N
        jTable2.setRowHeight(26);
        jTable2.setRowMargin(2);
        jTable2.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jTable2.setSurrendersFocusOnKeystroke(true);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable2MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        users.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 510, 420));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("Users");
        users.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 40));

        getContentPane().add(users, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 520, 520));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dashboard.show();
        vacancies.hide();
        companies.hide();
        users.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        vacancies.show();
        dashboard.hide();
        companies.hide();
        users.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        vacancies.hide();
        dashboard.hide();
        companies.show();
        users.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        vacancies.hide();
        dashboard.hide();
        companies.hide();
        users.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new PSettings().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        
        
        System.err.println(jTable1.getSelectedRow());
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        if(evt.getClickCount() == 2 && jTable1.getSelectedRow()>=0){
            String[]str = jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()).toString().split(" ");
            String ntq = "";
            int count = 1;
            for(String dat:str){
                if(count%12 == 0)
                    ntq += "\n";
                ntq += dat+" ";
                count++;
            }
            JOptionPane.showMessageDialog(this, ntq, "", 1);
            jTable1.clearSelection();
        }
    }//GEN-LAST:event_jTable1MousePressed

    private void jTable3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MousePressed
        // TODO add your handling code here:
        if(evt.getClickCount() == 2 && jTable3.getSelectedRow()>=0){
            String[]str = jTable3.getValueAt(jTable3.getSelectedRow(), jTable3.getSelectedColumn()).toString().split(" ");
            String ntq = "";
            int count = 1;
            for(String dat:str){
                if(count%12 == 0)
                    ntq += "\n";
                ntq += dat+" ";
                count++;
            }
            JOptionPane.showMessageDialog(this, ntq, "", 1);
            jTable3.clearSelection();
        }
    }//GEN-LAST:event_jTable3MousePressed

    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed
        // TODO add your handling code here:
        if(evt.getClickCount() == 2 && jTable2.getSelectedRow()>=0){
            String[]str = jTable2.getValueAt(jTable2.getSelectedRow(), jTable2.getSelectedColumn()).toString().split(" ");
            String ntq = "";
            int count = 1;
            for(String dat:str){
                if(count%12 == 0)
                    ntq += "\n";
                ntq += dat+" ";
                count++;
            }
            JOptionPane.showMessageDialog(this, ntq, "", 1);
            jTable2.clearSelection();
        }
    }//GEN-LAST:event_jTable2MousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        welcomename.setText("Welcome "+namer);
    }//GEN-LAST:event_formWindowOpened
    SendMail s = new SendMail("('S-A','C-A')", namer, "admin@cps.com", 'A');
    private void msgcountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgcountActionPerformed
//Not set
        s.setVisible(true);
    }//GEN-LAST:event_msgcountActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel comapanycount;
    private javax.swing.JPanel companies;
    private javax.swing.JPanel dashboard;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton msgcount;
    private javax.swing.JLabel timer;
    private javax.swing.JLabel usercount;
    private javax.swing.JPanel users;
    private javax.swing.JPanel vacancies;
    private javax.swing.JLabel vacancycount;
    private javax.swing.JLabel welcomename;
    // End of variables declaration//GEN-END:variables
}
