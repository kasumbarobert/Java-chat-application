/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youchat;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Point;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kasumba
 */
public class MessageSender extends javax.swing.JDialog {

    private String rec, sen;
    private JFrame parent;
    public MessageSender(JFrame x, String sender, String receiver) {
        super(x,sender+"sending to "+receiver,true);
        initComponents();
        this.parent =x;
        this.rec = receiver;
        this.sen = sender;
        this.receiver.setText(rec);
        this.setLocation(new Point(650,250));
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        receiver = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextArea();
        btn_send = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("To");

        receiver.setEnabled(false);
        receiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiverActionPerformed(evt);
            }
        });

        jLabel2.setText("Message");

        message.setColumns(20);
        message.setRows(5);
        jScrollPane1.setViewportView(message);

        btn_send.setText("Send");
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });

        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(receiver, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_send, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(receiver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_send)
                    .addComponent(btn_cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void receiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receiverActionPerformed

    private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed
       String msg = this.message.getText();
        Calendar now = new GregorianCalendar();
        long timeStamp = now.getTimeInMillis();
        String idBase = sen+"?"+rec+"_";
        if(!msg.isEmpty())
        {
            try{
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/youchat","root","");
                Statement stmt = (Statement) con.createStatement();
                String sql ="INSERT INTO messages(msg_id, sender, receiver, msg,timestamp) VALUES(?,?,?,?,?) ";
                PreparedStatement inserter = con.prepareStatement(sql);
                //count messages from this sender to the reciever
                ResultSet counter = stmt.executeQuery("SELECT COUNT(*) FROM messages WHERE msg_id like '"+idBase+"%'");
                
                if(counter.next())
                {
                    idBase+=(1+counter.getInt(1));
                }
                //store the message to the database
                //System.out.println("Love");
                inserter.setString(1, idBase);
                inserter.setString(2, sen);
                inserter.setString(3,rec);
                inserter.setString(4, msg);
                inserter.setLong(5, timeStamp);
                inserter.execute();
               JOptionPane.showMessageDialog(parent,"Message sent");
               this.setVisible(false);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage()+ "");
               System.exit(0);
            }
            
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage() + "");
                
                this.parent.dispose();
        }
        } else{System.out.println("haalo");}
            
            
    }//GEN-LAST:event_btn_sendActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btn_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea message;
    private javax.swing.JTextField receiver;
    // End of variables declaration//GEN-END:variables
}