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
import java.util.Date;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author majma
 */
public class CoordinatorPage extends javax.swing.JFrame {

    /**
     * Creates new form CoordinatorPage
     */
    String user = "majmals1998@gmail.com", coname = "Stack Overflow", coaddress="Null", NAME="Muhammed Ajmal";
    public void getInfo(String mailid, String cname, String caddress, String name){
        user = mailid;
        coname = cname;
        coaddress = caddress;
        NAME = name;
    }
    
    public void TableDisp(){
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from vacancies where cname='"+coname+"'");
            rs.next();
            dtm = (DefaultTableModel) jTable1.getModel();
            int count = Integer.parseInt(rs.getString("count(*)"));
            dtm.setRowCount(count);
            rs = st.executeQuery("select * from vacancies where cname='"+coname+"'");
            count = 0;
            while(rs.next()){
                String tcon = "<html><body>"
                        +"<span style='color:#A3B0E4;font-size:11px;font-family:georgia;font-weight:bold;'>"+rs.getString("job")+"</span>"
                        +"<br/><span style='color:black;font-size:10px;font-family:consolas;font-weight:bold;'>"+rs.getString("jobid")+"</span>"
                        +"<br/><span style='color:black;font-size:10px;font-family:consolas;font-weight:bold;'>Company: "+rs.getString("cname")+"</span>"
                        +"<br/><span style='color:black;font-size:10px;font-family:consolas;font-weight:bold;'>"+rs.getString("address")+"</span>"
                        +"<br/><span style='color:black;font-size:10px;font-family:consolas;font-weight:bold;'>Salary: "+rs.getString("salary")+"</span>"
                        
                        + "</body></html>";
               jTable1.setValueAt(tcon, count, 0);
               
                count++;
            }
            
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public CoordinatorPage() {
        initComponents();
        jPanel1.hide();
        jPanel2.hide();
        jPanel6.hide();
        jTable1.setValueAt(jid, 0, 0);
        this.setSize(806, 615);
        this.setResizable(false);
        new Thread(){
            public void run(){
                try {
                    while(true){
                        Date d = new Date();
                        settime.setText(new UserPage().convertTime(d.getHours(), d.getMinutes(), d.getSeconds()));
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                }
            }
        }.start();
        
        
        
        
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        settime = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jsal = new javax.swing.JTextField();
        jid = new javax.swing.JTextField();
        jname = new javax.swing.JTextField();
        jvac = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        remjid = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        msgcount = new javax.swing.JButton();
        stdcount = new javax.swing.JLabel();
        sstdcount = new javax.swing.JLabel();
        jcount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Coordinator Page");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ico17.jpg"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 330, 182, 45));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ico16.jpg"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 395, 182, 45));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ico15.jpg"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 458, 182, 45));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ico14.jpg"))); // NOI18N
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 520, 182, 45));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ico18.jpg"))); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 269, 182, 45));

        settime.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        settime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settime.setText("00:00:00 AM");
        getContentPane().add(settime, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 190, 60));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.CardLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Students"
            }
        )

        {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        }

    );
    jTable2.setEditingColumn(0);
    jTable2.setEditingRow(1);
    jTable2.setFillsViewportHeight(true);
    jTable2.setRowHeight(80);
    jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable2MouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(jTable2);

    jPanel6.add(jScrollPane1, "card2");

    getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 540, 470));

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel3.setBackground(new java.awt.Color(255, 255, 255));
    jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.gray));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel3.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
    jLabel3.setText("Job Name");
    jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 70, -1));

    jLabel4.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
    jLabel4.setText("Job Description");
    jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, 120, -1));

    jLabel8.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
    jLabel8.setText("Job ID");
    jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, -1));
    jPanel3.add(jsal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 170, 30));

    jid.setEditable(false);
    jPanel3.add(jid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 140, 30));

    jname.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            jnameFocusLost(evt);
        }
    });
    jPanel3.add(jname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 25, 230, 30));
    jPanel3.add(jvac, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 25, 110, 30));

    jLabel9.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
    jLabel9.setText("Vacancies");
    jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 60, -1));

    jButton6.setBackground(new java.awt.Color(0, 0, 0));
    jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton6.setForeground(new java.awt.Color(255, 255, 255));
    jButton6.setText("Reset");
    jButton6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton6ActionPerformed(evt);
        }
    });
    jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 80, 40));

    jButton7.setBackground(new java.awt.Color(0, 0, 0));
    jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton7.setForeground(new java.awt.Color(255, 255, 255));
    jButton7.setText("Add");
    jButton7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton7ActionPerformed(evt);
        }
    });
    jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 80, 40));

    jLabel5.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
    jLabel5.setText("Salary");
    jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 65, 50, -1));

    jScrollPane2.setViewportView(desc);

    jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 330, 80));

    jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 172));

    jPanel4.setBackground(new java.awt.Color(255, 255, 255));
    jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.gray));
    jPanel4.setLayout(new java.awt.CardLayout());

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null}
        },
        new String [] {
            ""
        }
    ));
    jTable1.setRowHeight(100);
    jScrollPane3.setViewportView(jTable1);

    jPanel4.add(jScrollPane3, "card2");

    jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, 540, 210));

    jPanel5.setBackground(new java.awt.Color(255, 255, 255));
    jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.gray));
    jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel10.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
    jLabel10.setText("Job ID");
    jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, -1));
    jPanel5.add(remjid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 190, 30));

    jButton8.setBackground(new java.awt.Color(0, 0, 0));
    jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton8.setForeground(new java.awt.Color(255, 255, 255));
    jButton8.setText("Remove");
    jButton8.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton8ActionPerformed(evt);
        }
    });
    jPanel5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 90, 40));

    jButton9.setBackground(new java.awt.Color(0, 0, 0));
    jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton9.setForeground(new java.awt.Color(255, 255, 255));
    jButton9.setText("Edit");
    jButton9.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton9ActionPerformed(evt);
        }
    });
    jPanel5.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 90, 40));

    jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 540, 70));

    getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 540, 460));

    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    msgcount.setBackground(new java.awt.Color(255, 255, 255));
    msgcount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    msgcount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    msgcount.setFocusPainted(false);
    msgcount.setOpaque(false);
    msgcount.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            msgcountActionPerformed(evt);
        }
    });
    jPanel1.add(msgcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 70, 50));

    stdcount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    stdcount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    stdcount.setText("25");
    jPanel1.add(stdcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 70, 50));

    sstdcount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    sstdcount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    sstdcount.setText("25");
    jPanel1.add(sstdcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 70, 50));

    jcount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jcount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jcount.setText("25");
    jPanel1.add(jcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 70, 50));

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/panel2.jpg"))); // NOI18N
    jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 480));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 520, 480));

    jLabel1.setBackground(new java.awt.Color(255, 255, 255));
    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/coordinator.jpg"))); // NOI18N
    jLabel1.setOpaque(true);
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jvac.setText("");
        jsal.setText("");
        jname.setText("");
        jid.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String jobname = jname.getText(), jobsalary = jsal.getText(), vacancycount = jvac.getText(), jobid;
        jobid = jid.getText();
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
            Statement st = con.createStatement();
            st.executeUpdate("insert into vacancies values('"+jobname+"', '"+desc.getText()+"', '"+coname+"', '"+coaddress+"', '"+vacancycount+"', '"+jobid+"', '"+jobsalary+"')");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(jcount, "Job already added!");
        }
        
        TableDisp();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jnameFocusLost
        // TODO add your handling code here:
        try {
            String jobname = jname.getText(), jobsalary = jsal.getText(), vacancycount = jvac.getText(), jobid;
            String[]X = jobname.split(" ");
            Date d = new Date();
            if(X.length > 1)
                jobid = X[0].substring(0, 2).toUpperCase()+X[X.length-1].substring(0, 2).toUpperCase();
            else
                jobid = X[0].substring(0, 2).toUpperCase();
            String[]Y = coname.split(" ");
            if(Y.length > 1)
                jobid += Y[0].substring(0, 2).toUpperCase()+Y[Y.length-1].substring(0, 2).toUpperCase();
            else
                jobid += Y[0].substring(0, 2).toUpperCase();


            String[]month = {

                "JAN",
                "FEB",
                "MAR",
                "APR",
                "MAY",
                "JUN",
                "JUL",
                "AUG",
                "SEP",
                "OCT",
                "NOV",
                "DEC"

            };

            jobid += String.valueOf(d.getDate())+month[d.getMonth()];
            jid.setText(jobid);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jcount, "Please enter a valid job name!");
        }
        
        
    }//GEN-LAST:event_jnameFocusLost

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jPanel1.show();
        jPanel2.hide();
        jPanel6.hide();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jPanel1.hide();
        jPanel2.show();
        jPanel6.hide();
        TableDisp();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
            Statement st = con.createStatement();
            try{
                int res = st.executeUpdate("delete from vacancies where jobid='"+remjid.getText()+"'");
                if(res == 1)
                    JOptionPane.showMessageDialog(jcount, "Job Removed");
                else
                    JOptionPane.showMessageDialog(jcount, "No such a job found!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(jcount, "Job Removed Failed");
            }
            TableDisp();
            
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        SendMail s = new SendMail("('S-C','A-C')", NAME, user, 'C');
        s.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
String[][]STD;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jPanel1.hide();
        jPanel2.hide();
        jPanel6.show();
        
        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from appliedjobs where jobid in (select jobid from vacancies where cname='"+coname+"')");
            
//            sname,uname,course,batch,phone,path,rpath
            rs.next();
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            int count = Integer.parseInt(rs.getString("count(*)"));
            STD = new String[count][10];
            rs = st.executeQuery("select * from student where sid in (select sid from appliedjobs where jobid in (select jobid from vacancies where cname='"+coname+"'))");
            count = 0;
            while(rs.next()){
                
                String stdname = rs.getString("sname");
                String course = rs.getString("course");
                String batch = rs.getString("batch");
                ResultSet rs2 = con.createStatement().executeQuery("select job, jobid from vacancies where jobid in (select jobid from vacancies where cname='"+coname+"')");
                while(rs2.next()){
                    STD[count][0] = stdname;
                    STD[count][1] = rs2.getString("job");
                    STD[count][2] = course;
                    STD[count][3] = batch;
                    STD[count][4] = rs.getString("uname");
                    STD[count][5] = rs.getString("phone");
                    STD[count][6] = rs.getString("path");
                    STD[count][7] = rs.getString("rpath");
                    STD[count][8] = rs.getString("sid");
                    STD[count][9] = rs2.getString("jobid");
                    String tcon = "<html><body>"
                        +"<span style='color:#A3B0E4;font-size:11px;font-family:georgia;font-weight:bold;'>"+stdname+"</span>"
                        +"<br/><span style='color:black;font-size:10px;font-family:georgia;font-weight:bold;'>Applied Post: "+rs2.getString("job")+"</span>"
                        +"<br/><span style='color:black;font-size:10px;font-family:consolas;font-weight:bold;'>Course: "+course+"</span>"
                        +"<br/><span style='color:black;font-size:10px;font-family:consolas;font-weight:bold;'>Batch: "+batch+"</span>"
                        + "</body></html>";
                    jTable2.setValueAt(tcon, count, 0);

                    count++;
                }
            }
            
            con.close();
        } catch (Exception e) {
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            StudentInfo s = new StudentInfo();
            s.getStrings(STD[jTable2.getSelectedRow()],coname,NAME,user);
            s.setVisible(true);
            jTable2.clearSelection();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void msgcountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgcountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msgcountActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from srmail where status=0 and tmailid='"+user+"'");
            rs.next();
            msgcount.setText(rs.getString("count(*)"));
            rs = st.executeQuery("select count(*) from vacancies where cname='"+coname+"'");
            rs.next();
            jcount.setText(rs.getString("count(*)"));
            rs = st.executeQuery("select count(*) from selectstudent");
            rs.next();
            sstdcount.setText(rs.getString("count(*)"));
            rs = st.executeQuery("select count(*) from appliedjobs where jobid in (select jobid from vacancies where cname='"+coname+"')");
            rs.next();
            stdcount.setText(rs.getString("count(*)"));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Update up = new Update();
        up.getData(remjid.getText());
        up.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(CoordinatorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoordinatorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoordinatorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoordinatorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoordinatorPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane desc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel jcount;
    private javax.swing.JTextField jid;
    private javax.swing.JTextField jname;
    private javax.swing.JTextField jsal;
    private javax.swing.JTextField jvac;
    private javax.swing.JButton msgcount;
    private javax.swing.JTextField remjid;
    private javax.swing.JLabel settime;
    private javax.swing.JLabel sstdcount;
    private javax.swing.JLabel stdcount;
    // End of variables declaration//GEN-END:variables
}