package com.Alanjro_jr.capture;

import com.Alanjro_jr.util.Connect;
import com.Alanjro_jr.util.TrainLBPH;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.bytedeco.javacpp.BytePointer;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import org.bytedeco.opencv.global.opencv_imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;

 
public class RegisterFace extends javax.swing.JDialog {

    private RegisterFace.DaemonThread myThread = null;

    //JavaCV
    private VideoCapture webSource = null;
    private Mat cameraImage = new Mat();
    private CascadeClassifier cascade = new CascadeClassifier("C:\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");

    private BytePointer mem = new BytePointer();
    private RectVector detectedFaces = new RectVector();

    private int numSamples = 30, sample = 1, idPerson;

    //Connection
    private Connect conecta = new Connect();

    
    public RegisterFace(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getIdUser();
        startCamera();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel9 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        counterLabel = new javax.swing.JLabel();
        label_photo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_id_label = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        txt_first_name = new javax.swing.JTextField();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        txt_last_name = new javax.swing.JTextField();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel13 = new javax.swing.JLabel();
        txt_phone_number = new javax.swing.JTextField();
        txt_office = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_facebook = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        saveButton = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel9.setBackground(new java.awt.Color(14, 14, 50));
        kGradientPanel9.setkFillBackground(false);
        kGradientPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("After registration, capture 30 photos for Model Training.");
        kGradientPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 310, 30));

        counterLabel.setBackground(new java.awt.Color(255, 255, 255));
        counterLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        counterLabel.setForeground(new java.awt.Color(32, 78, 199));
        counterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        counterLabel.setText("00/30");
        counterLabel.setOpaque(true);
        kGradientPanel9.add(counterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 300, 20));

        label_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        kGradientPanel9.add(label_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 410, 460));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(100, 100, 100));
        jLabel12.setText("ADD NEW DATA FOR TRAINING ");
        kGradientPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 340, -1));

        jPanel1.setBackground(new java.awt.Color(14, 14, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id_label.setBackground(new java.awt.Color(90, 68, 193));
        txt_id_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_id_label.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_id_label.setText("1");
        jPanel1.add(txt_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 40, 40));

        jButton1.setBackground(new java.awt.Color(213, 83, 83));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_15px_1.png"))); // NOI18N
        jButton1.setToolTipText("Close");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 30, 40));

        kGradientPanel9.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 410, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(170, 170, 170));
        jLabel2.setText("Why Enrolling ?");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 130, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(170, 170, 170));
        jLabel3.setText("First Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(170, 170, 170));
        jLabel4.setText("Last Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(170, 170, 170));
        jLabel5.setText("Last Known Address ?");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 170, -1));

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel1.setkFillBackground(false);
        kGradientPanel1.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_first_name.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_first_name.setForeground(new java.awt.Color(255, 51, 0));
        txt_first_name.setBorder(null);
        kGradientPanel1.add(txt_first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel3.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 40));

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel2.setkFillBackground(false);
        kGradientPanel2.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_last_name.setBackground(new java.awt.Color(255, 0, 204));
        txt_last_name.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_last_name.setForeground(new java.awt.Color(255, 51, 0));
        txt_last_name.setBorder(null);
        kGradientPanel2.add(txt_last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel3.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 150, 40));

        kGradientPanel4.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel4.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel4.setkFillBackground(false);
        kGradientPanel4.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 160, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(200, 204, 208));
        jLabel13.setText("Enroll New Data For Monitoring");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        txt_phone_number.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_phone_number.setForeground(new java.awt.Color(255, 51, 51));
        txt_phone_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_phone_numberActionPerformed(evt);
            }
        });
        jPanel3.add(txt_phone_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, 40));

        txt_office.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_office.setForeground(new java.awt.Color(255, 51, 51));
        txt_office.setBorder(null);
        jPanel3.add(txt_office, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 190, 40));

        kGradientPanel9.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 340, 170));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(170, 170, 170));
        jLabel7.setText("Reporting Phone Number");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 180, 30));

        txt_facebook.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        txt_facebook.setForeground(new java.awt.Color(255, 0, 0));
        txt_facebook.setToolTipText("phone shoud be in this format only 23481********");
        txt_facebook.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.darkGray));
        jPanel4.add(txt_facebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 300, 50));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jTextField1.setToolTipText("");
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 300, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Nearby Security Parsonnel Information");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 260, 20));

        saveButton.setText("Capture Data");
        saveButton.setkAllowTab(false);
        saveButton.setkEndColor(new java.awt.Color(118, 195, 118));
        saveButton.setkHoverEndColor(new java.awt.Color(22, 92, 22));
        saveButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        saveButton.setkHoverStartColor(new java.awt.Color(80, 142, 80));
        saveButton.setkPressedColor(new java.awt.Color(28, 72, 28));
        saveButton.setkStartColor(new java.awt.Color(87, 167, 87));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel4.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 290, 30));
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        kGradientPanel9.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 330, 170));

        getContentPane().add(kGradientPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 470));

        setSize(new java.awt.Dimension(820, 460));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        stopCamera();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

    }//GEN-LAST:event_saveButtonActionPerformed

    private void txt_phone_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_phone_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_phone_numberActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            RegisterFace dialog = new RegisterFace(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel counterLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel9;
    private javax.swing.JLabel label_photo;
    private keeptoo.KButton saveButton;
    private javax.swing.JTextField txt_facebook;
    private javax.swing.JTextField txt_first_name;
    private javax.swing.JLabel txt_id_label;
    private javax.swing.JTextField txt_last_name;
    private javax.swing.JTextField txt_office;
    private javax.swing.JTextField txt_phone_number;
    // End of variables declaration//GEN-END:variables

     
    private int getIdUser() {
        int id = 0;
        conecta.conexao();
        conecta.executaSQL("SELECT * FROM person ORDER BY id DESC LIMIT 1");
        try {
            conecta.rs.first();
            txt_id_label.setText(String.valueOf(conecta.rs.getInt("id")));
            id = Integer.parseInt(txt_id_label.getText());
            id++;
            txt_id_label.setText(String.valueOf(id));
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    
    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    try {
                        if (webSource.grab()) {
                            webSource.retrieve(cameraImage);
                            Graphics g = label_photo.getGraphics();  

                            Mat imageColor = new Mat(); 
                            imageColor = cameraImage;

                            Mat imageGray = new Mat();  
                            cvtColor(imageColor, imageGray, COLOR_BGRA2GRAY);
//                          

                            RectVector detectedFaces = new RectVector(); //fd
                            cascade.detectMultiScale(imageColor, detectedFaces, 1.1, 1, 1, new Size(150, 150), new Size(500, 500));

                            for (int i = 0; i < detectedFaces.size(); i++) {  
                                Rect dadosFace = detectedFaces.get(0);

                                rectangle(imageColor, dadosFace, new Scalar(255, 255, 0, 2), 3, 0, 0);

                                Mat face = new Mat(imageGray, dadosFace);
                                opencv_imgproc.resize(face, face, new Size(160, 160));

                                if (saveButton.getModel().isPressed()) { 
                                    if (txt_first_name.getText().equals("") || txt_first_name.getText().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Empty field");
                                    } else if (txt_first_name.getText().equals("") || txt_first_name.getText().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Empty field");
                                    } else if (txt_last_name.getText().equals("") || txt_last_name.getText().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Empty field");
                                    } else if (txt_office.getText().equals("") || txt_office.getText().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Empty field");
                                    } else {
                                        if (sample <= numSamples) {
                                            String cropped = "C:\\photos\\person." + txt_id_label.getText() + "." + sample + ".jpg";
                                            imwrite(cropped, face);

                                    
                                            counterLabel.setText(String.valueOf(sample) + "/30");
                                            sample++;
                                        }
                                        if (sample > 30) {
                                            new TrainLBPH().trainPhotos();
                                            insertDatabase();  

                                            System.out.println("File Generated");
                                            stopCamera(); //  
                                        }

                                    }
                                }
                            }

                            imencode(".bmp", cameraImage, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.getStringBytes()));
                            BufferedImage buff = (BufferedImage) im;
                            try {
                                if (g.drawImage(buff, 0, 0, 360, 390, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                    if (runnable == false) {
                                        System.out.println("Save Photo");
                                        this.wait();
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * This method inserts the information into the database.
     */
    public void insertDatabase() {
        ControlPerson cod = new ControlPerson();
        ModelPerson mod = new ModelPerson();

        mod.setId(Integer.parseInt(txt_id_label.getText()));
        mod.setFirst_name(txt_first_name.getText());
        mod.setLast_name(txt_last_name.getText());
        mod.setDob(txt_phone_number.getText());
        mod.setOffice(txt_office.getText());
        mod.setFacebook(txt_facebook.getText());
        //mod.setInstagram("dUMMYASS");
        // mod.setLinkedin("Ass");
       // mod.setGithub("Ass");
        cod.insert(mod);
    }
 
    public void stopCamera() {
        myThread.runnable = false;
        webSource.release();
        dispose();
    }

     
    public void startCamera() {
        new Thread() {
            @Override
            public void run() {
                webSource = new VideoCapture(1);

                myThread = new RegisterFace.DaemonThread();
                Thread t = new Thread(myThread);
                t.setDaemon(true);
                myThread.runnable = true;
                t.start();
            }
        }.start();
    }

}
