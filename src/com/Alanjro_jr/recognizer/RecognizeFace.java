package com.Alanjro_jr.recognizer;

import com.Alanjro_jr.util.Connect;
import com.Alanjro_jr.capture.ControlPerson;
import com.Alanjro_jr.capture.ModelPerson; 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Array;
import javax.imageio.ImageIO;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
import org.bytedeco.opencv.global.opencv_imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;

public final class RecognizeFace extends javax.swing.JDialog {

    ModelPerson mod = new ModelPerson();
    ControlPerson cod = new ControlPerson();
    smsalert jib = new smsalert();
    private RecognizeFace.DaemonThread myThread = null;

    //JavaCV 1.5.1
    private VideoCapture webSource = null;
    private Mat cameraImage = new Mat();
    private CascadeClassifier cascade = new CascadeClassifier("C:\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");
    private LBPHFaceRecognizer recognizer = LBPHFaceRecognizer.create();

    private BytePointer mem = new BytePointer();
    private RectVector detectedFaces = new RectVector();

    //Vars
    private String root, firstNamePerson, lastNamePerson, officePerson, dobPerson, telefone , phone;
    //Social Info
    private String facebook,insta, linkedin, git;
    private int idPerson;

    //Utils
    private Connect conecta = new Connect(); 

    public RecognizeFace(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        recognizer.read("C:\\photos\\classifierLBPH.yml");
        recognizer.setThreshold(80); //the smaller the size,dificult to recognize...
        startCamera();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel11 = new javax.swing.JLabel();
        label_office = new javax.swing.JLabel();
        label_name = new javax.swing.JLabel();
        label_phone = new javax.swing.JLabel();
        label_photo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_id_label = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        kGradientPanel5 = new keeptoo.KGradientPanel();

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(95, 106, 117));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Hi!");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(132, 242, 145)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(14, 14, 50));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(82, 82, 82));
        jLabel2.setText("Reason for the Target :::");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(82, 82, 82));
        jLabel3.setText("Fullname:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(82, 82, 82));
        jLabel4.setText("Address");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 100, -1));

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel1.setkFillBackground(false);
        kGradientPanel1.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 180, 30));

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel2.setkFillBackground(false);
        kGradientPanel2.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 110, 30));

        kGradientPanel3.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel3.setkFillBackground(false);
        kGradientPanel3.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 300, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(158, 158, 159));
        jLabel11.setText("Personal Information");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        label_office.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jPanel4.add(label_office, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 270, 30));

        label_name.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jPanel4.add(label_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 160, 30));

        label_phone.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jPanel4.add(label_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 170, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 300, 160));

        label_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(label_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 450, 420));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(100, 100, 100));
        jLabel13.setText("Monitor Screen  ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, null, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id_label.setBackground(new java.awt.Color(132, 242, 145));
        txt_id_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_id_label.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 40, 30));

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
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 30, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 330, 30));

        kGradientPanel4.setkEndColor(new java.awt.Color(64, 79, 225));
        kGradientPanel4.setkStartColor(new java.awt.Color(110, 208, 137));
        kGradientPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel5.setText("If the Target suspect is seen from the surveillance camera ");
        kGradientPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 340, 40));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel6.setText("he'll be reported  to an official  Phone number of the reporter");
        kGradientPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 370, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icone - Copy.png"))); // NOI18N
        kGradientPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 80, 70));

        jPanel1.add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 290, 160));

        kGradientPanel5.setBackground(new java.awt.Color(14, 14, 50));
        kGradientPanel5.setkFillBackground(false);
        jPanel1.add(kGradientPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 490));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 500));

        setSize(new java.awt.Dimension(820, 497));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        stopCamera();
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecognizeFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecognizeFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecognizeFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecognizeFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            RecognizeFace dialog = new RecognizeFace(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private javax.swing.JLabel label_name;
    private javax.swing.JLabel label_office;
    private javax.swing.JLabel label_phone;
    private javax.swing.JLabel label_photo;
    private javax.swing.JLabel txt_id_label;
    // End of variables declaration//GEN-END:variables

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

                            Mat imageGray = new Mat();
                            cvtColor(cameraImage, imageGray, COLOR_BGRA2GRAY);

                            RectVector detectedFace = new RectVector();
                            cascade.detectMultiScale(imageGray, detectedFace,1.1, 2, 0, new Size(150, 150), new Size(500, 500));
                            //

                            for (int i = 0; i < detectedFace.size(); i++) {
                                Rect dadosFace = detectedFace.get(i);
                                rectangle(cameraImage, dadosFace, new Scalar(0, 255, 0, 3), 3, 0, 0);
                                Mat faceCapturada = new Mat(imageGray, dadosFace);
                                opencv_imgproc.resize(faceCapturada, faceCapturada, new Size(160, 160));

                                IntPointer rotulo = new IntPointer(1);
                                DoublePointer confidence = new DoublePointer(1);
                                recognizer.predict(faceCapturada, rotulo, confidence);
                                int prediction = rotulo.get(0);
                                String nome;
                                nome = firstNamePerson;

                                if (prediction == -1) {
                                       
                                    rectangle(cameraImage, dadosFace, new Scalar(0, 0, 255, 3), 3, 0, 0);
                                     
                                    idPerson = 0;
                                    label_name.setText("Unknown");
                                    txt_id_label.setText("");
                                    label_office.setText("");
                                    label_phone.setText("");
                             
                                    facebook = "";
                                    insta = "";
                                    git = "";
                                    linkedin = "";
                                } else { 
                                     rectangle(cameraImage, dadosFace, new Scalar(0, 255, 0, 3), 3, 0, 0);
                                     
                                     
                                         //System.out.println("KNOWN PARSON");
                                        
                                    System.out.println(confidence.get(0));
                                    idPerson = prediction;
                                   rec();
                                  
                                   
                                    try {
                               try{
          //  System.out.print(jib.sendGet(phone, firstNamePerson)+"   Your Remaining Balance  Is ");
        
    //System.out.println(jib.GetBal());
    }catch(Exception UnknownHostException ){
    
    String p = "No Network connectivity so  sms cannot be sent";
   // JOptionPane.showMessageDialog(null, p);
    }
                           // JOptionPane.showMessageDialog(null,"Target is seen at main camera ");
    }catch(Exception e){
    e.printStackTrace();
    }

                                }

                            }

                            imencode(".bmp", cameraImage, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.getStringBytes()));
                            BufferedImage buff = (BufferedImage) im;

                            try {
                                if (g.drawImage(buff, 0, 0, 360, 390, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                    if (runnable == false) {
                                        this.wait();
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception ex) {
                    }
                }
            }
        }
    }

    private void rec() {
        //Retrieve data from database
        new Thread() {
            @Override
            public void run() {
                conecta.conexao();
                try {
                    conecta.executaSQL("SELECT * FROM person WHERE id = " + String.valueOf(idPerson));
                    while (conecta.rs.next()) {
                        firstNamePerson = conecta.rs.getString("first_name");
                        jLabel10.setText("Hi, " + firstNamePerson + " " + conecta.rs.getString("last_name"));
                        label_name.setText(conecta.rs.getString("first_name") + " " + conecta.rs.getString("last_name"));
                        label_office.setText(conecta.rs.getString("office"));
                        telefone = conecta.rs.getString("phone_number");
                        label_phone.setText(telefone);
                      txt_id_label.setText(conecta.rs.getString("id"));

                       phone = conecta.rs.getString("profile_facebook");
                     
                        facebook = conecta.rs.getString("profile_facebook");
                        // insta = conecta.rs.getString("profile_instagram");
                         //linkedin = conecta.rs.getString("profile_linkedin");
                         //git = conecta.rs.getString("profile_github");

                        Array ident = conecta.rs.getArray("first_name");
                        String[] person = (String[]) ident.getArray();
  
                 
                        for (String person1 : person) {
                            System.out.println(person1);
                    
                        }

                    }
                } catch (Exception e) {
                }
                conecta.disconnect();
            }
        }.start();
    }

    public void stopCamera() {
        try {
            myThread.runnable = false;
            webSource.release();
            dispose();
        } catch (Exception e) {
        }
    }

    public void startCamera() {
        new Thread() {
            @Override
            public void run() {
                webSource = new VideoCapture(1);
                myThread = new RecognizeFace.DaemonThread();
                Thread t = new Thread(myThread);
                t.setDaemon(true);
                myThread.runnable = true;
                t.start();
            }
        }.start();
    }
   
    
}
