import com.sun.org.apache.xpath.internal.SourceTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Jose Enrique Reyes Huerta
 */
//public class Cronometro extends javax.swing.JFrame {
public class Cronometro extends javax.swing.JFrame {
    public CRUDCronometro CRUDCronometro;
    public Date fecha = new Date();
    public String tiempo =  null;

    public Cronometro() {
        initComponents();
        setLocationRelativeTo(null);
        t = new Timer(10, acciones);
       CRUDCronometro = new CRUDCronometro();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        Reloj relojChetumal = new Reloj();
        etiquetaReloj = new javax.swing.JLabel();
        etiquetaTitulo = new javax.swing.JLabel();
        etiquetaTiempo = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnRegist = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cronómetro");

        etiquetaReloj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clock2.gif"))); // NOI18N
        //etiquetaReloj.(relojChetumal);

        etiquetaTitulo.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        etiquetaTitulo.setText("Cronómetro");

       etiquetaTiempo.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        etiquetaTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTiempo.setText("00:00:00:00");

        btnStart.setText("Iniciar");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnPause.setText("Pausar");
        btnPause.setEnabled(false);
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnStop.setText("Detener");
        btnStop.setEnabled(false);
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);

            }
        });

        btnRegist.setText("registros");
        btnRegist.setEnabled(false);
        btnRegist.addActionListener(new java.awt.event.ActionListener()
                                    {
                                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            btnRegistActionPerformed(evt);

                                        }
                                    }

        );


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaReloj)
                                .addGap(28, 28, 28)


                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(etiquetaTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(etiquetaTitulo)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        )

                                                )
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );


        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(etiquetaTitulo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(etiquetaTiempo)

                                                .addGap(26, 26, 26)

                                                //Reloj


                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnStart)
                                                        .addComponent(btnPause)
                                                        .addComponent(btnStop))
                                                        .addComponent(btnRegist))
                                        .addComponent(etiquetaReloj))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Timer t;
    private int h, m, s, cs;
    private int  incrementar = 5;
    private ActionListener acciones = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent ae) {
            ++cs;
            if(cs==100){
                cs = 0;
                ++s;
            }
            if(s==60)
            {
                s = 0;
                ++m;
            }
            if(m==60)
            {
                m = 0;
                ++h;
            }
            if (s == incrementar){
                JOptionPane.showMessageDialog(null,"han pasado "+ incrementar);
                incrementar += 5;
            }
            actualizarLabel();
        }


    };
/*
    //metodo  Arreglo de listener

    public class Asalariado{
        private Vector salarioListeners=new Vector();

        public synchronized void addSalarioListener(SalarioListener listener){
            salarioListeners.addElement(listener);
        }

        public synchronized void removeSalarioListener(SalarioListener listener){
            salarioListeners.removeElement(listener);
        }
//...
    }

*/
    //termina metodo arreglo de listeners


    private void actualizarLabel() {
        String tiempo = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s+":"+(cs<=9?"0":"")+cs;
        etiquetaTiempo.setText(tiempo);


    }

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        t.start();
        btnStart.setEnabled(false);
        btnStart.setText("Reanudar");
        btnPause.setEnabled(true);
        btnStop.setEnabled(true);
        btnRegist.setEnabled(true);
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        t.stop();
        btnStart.setEnabled(true);
        btnPause.setEnabled(false);
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        if(t.isRunning())
            {
                t.stop();
                btnStart.setEnabled(true);
        }
        btnStart.setText("Iniciar");
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
        btnRegist.setText("registros");

        //Obtenemos el tiempo actual y hacemos el ajuste con el metodo obtener
      //Debes mandar a tu crud lo que hay en la etiqueta del tiempo como un string
       // CRUDCronometro.guardarTiempo(etiquetaTiempo.getText());
       obtenerTiempo();
        guardarTiempo();
        h=0; m=0; s=0; cs=0;
        actualizarLabel();
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed

        Registro obj = new Registro();
        obj.cargarTiempo(CRUDCronometro.getListaTiempos());
        obj.setVisible(true);

    }


    public void guardarTiempo(){
            if(this.CRUDCronometro.guardarTiempo(this.tiempo)){
                System.out.println("Registro guardado");
            }
            else{
                System.out.println("No se pudo guardar");
            }
    }

    public void obtenerTiempo(){

         String hora = String.valueOf(h);
         String minuto = String.valueOf(m);
         String segundo = String.valueOf(s);
         if(String.valueOf(h).length()==1){
             hora="0"+h;
         }
         if(String.valueOf(m).length()==1){
             minuto="0"+m;
         }
        if(String.valueOf(s).length()==1){
            segundo="0"+s;
        }
        tiempo = hora+":"+minuto+":"+segundo;



    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        //Reloj relojChetumal = new Reloj();
       //Cronometro.add(relojChetumal);




        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Cronometro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnRegist;
    private javax.swing.JLabel etiquetaReloj;
    private javax.swing.JLabel etiquetaTiempo;
    private javax.swing.JLabel etiquetaTitulo;
    // End of variables declaration//GEN-END:variables
}

