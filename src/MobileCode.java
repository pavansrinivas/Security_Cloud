
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavan
 */
public class MobileCode extends javax.swing.JFrame {

    /**
     * Creates new form MobileCode
     */
     static String s2=new String();
    
    public MobileCode() {
        initComponents();
    }
    public void getcode(String s)

    {
        s2=s;
        System.out.println("7."+s2);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   public void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        code_txt = new javax.swing.JTextField();
        sbt_code = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        code_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                code_txtActionPerformed(evt);
            }
        });
        jPanel1.add(code_txt);
        code_txt.setBounds(88, 93, 262, 30);

        sbt_code.setText("Submit");
        sbt_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbt_codeActionPerformed(evt);
            }
        });
        jPanel1.add(sbt_code);
        sbt_code.setBounds(141, 141, 65, 23);

        jLabel1.setText("Enter the code you received");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(88, 47, 243, 35);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        pack();
		
    }// </editor-fold>//GEN-END:initComponents

    public void sbt_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbt_codeActionPerformed
        // TODO add your handling code here:
        
        SMS sw=new SMS();
        
        //System.out.println("BOX"+sw.);
        String s1=code_txt.getText();
        System.out.println("CODE RECEVIED"+s1);
       // MobileCode mcd=new MobileCode();
        if(s1.equals(this.s2))
        {
        Acess_modifyFiles1 amf1=new Acess_modifyFiles1();
        amf1.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null," INVALID MOBILE CODE ","ERROR",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_sbt_codeActionPerformed

    public void code_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_code_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_code_txtActionPerformed

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
            java.util.logging.Logger.getLogger(MobileCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MobileCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MobileCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MobileCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
//MobileCode mcek=new MobileCode();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MobileCode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField code_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton sbt_code;
    // End of variables declaration//GEN-END:variables
}