/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youchat;

import java.awt.Color;
import java.awt.Insets;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kasumba
 */
public class FilePanel extends javax.swing.JPanel {

    /**
     * Creates new form FilePanel
     */
    JFrame parent;
    private String username;
    public FilePanel(JFrame owner) {
        this.parent = owner;
        initComponents();
        username =((YouChatMain)parent).verified.username;
        populateFilesList();
        this.filesList.addListSelectionListener(new DisplayFile());
        this.display_file.setWrapStyleWord(true);
        this.display_file.setLineWrap(true);
    }

    private void populateFilesList()
    {
        Connector con = new Connector();
        String query = "SELECT * FROM messages WHERE file != '' AND msg_id LIKE '%"+this.username+"%' ORDER BY timestamp ASC";
        Vector listdata = new Vector();
        String item;
        try {
            ResultSet rs = con.getStatement().executeQuery(query);
            while(rs.next())
            {
                File f = new File(rs.getString("file"));
               if(rs.getString("sender").equals(this.username))
               {
                   item = "File: "+f.getName() +" sent to "+rs.getString("receiver");
                   listdata.add(item);
               }
               else if(rs.getString("receiver").equals(this.username)){
                   item = "File: "+f.getName() +" from "+rs.getString("sender");
                   listdata.add(item);
               }
            }
         this.filesList.setListData(listdata);
         con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FilePanel.class.getName()).log(Level.SEVERE, null, ex);
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

        file_title = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        display_file = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        filesList = new javax.swing.JList<>();
        title = new javax.swing.JLabel();

        display_file.setColumns(20);
        display_file.setRows(5);
        jScrollPane2.setViewportView(display_file);

        jLabel1.setText("Files ordered by date arrived");

        filesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        filesList.setFixedCellWidth(filesList.getPreferredSize().width);
        filesList.setFocusCycleRoot(true);
        filesList.setSelectedIndex(0);
        jScrollPane4.setViewportView(filesList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea display_file;
    private javax.swing.JLabel file_title;
    private javax.swing.JList<String> filesList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    private class DisplayFile implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String file = FilePanel.this.filesList.getSelectedValue();
            file = file.substring(5);
            int n = file.indexOf("from");
            int m = file.indexOf("sent to");
            if(n==-1 && m>0)
            {
                 file = file.substring(0,m);
            }
            else if(n>0 && m==-1)
            {
                file = file.substring(0,n);
            }
           
            String filename = file.trim();
            File thisfile = new File("uploaded_files/"+filename);
            if(thisfile.exists())
            {
                try {
                    Scanner x = new Scanner(thisfile);
                    StringBuffer content= new StringBuffer();
                   while(x.hasNext())
                   {
                       content.append(x.nextLine()+"\n");
                   }
                   
                    if(content.toString().isEmpty()){
                        FilePanel.this.title.setText("FILE FORMAT NOT SUPPORTED");
                        FilePanel.this.title.setForeground(Color.red);
                        FilePanel.this.display_file.setText("");
                        FilePanel.this.display_file.setEditable(false);
                    }
                    else{
                        FilePanel.this.display_file.setText(content.toString());
                        FilePanel.this.title.setText("Reading file "+filename);
                         FilePanel.this.display_file.setMargin(new Insets(10,30,30,10));
                         FilePanel.this.title.setForeground(Color.BLUE);
                        FilePanel.this.display_file.setEditable(false);
                        
                    }
                
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FilePanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FilePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        
    }
}