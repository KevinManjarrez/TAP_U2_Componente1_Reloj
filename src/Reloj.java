
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Manjarrez
 */
public class Reloj extends javax.swing.JPanel implements Serializable{
    Timer ActualizaHora = new Timer(1000, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            Calendar cal = GregorianCalendar.getInstance();
            jLabel1.setText(obtenerHora(cal)+":"+obtenerMin(cal)+":"+obtenerSeg(cal)+agregarAMPM(cal));
        }
        
    });
    

    public void setColorText(Color c){
        jLabel1.setForeground(c);
    }
    public Color getColorText(){
        return jLabel1.getForeground();
    }
    public void setFormato24(Boolean formato){
        f=formato;
    }
    public Boolean getFormato24(){
        return f;
    }
    
    @Override
    public void setFont(Font f){
        try{
            letra = f;
            jLabel1.setFont(letra);
        }catch(Exception e){
            
        }
    }
    
    
    @Override
    public void setForeground(Color c){
        try{
            color = c;
            jLabel1.setForeground(c);
        }catch(Exception e){
            
        }
    }
    
    @Override
    public Color getForeground(){
        try{
            return color;
        }catch(Exception e){
            return new Color(0,0,0);
        } 
    }
    
    private String obtenerHora(Calendar c){
        int hora = c.get(Calendar.HOUR);
        if(f==true){
            return ""+c.get(Calendar.HOUR_OF_DAY);
        }
        if(hora<10){
            return "0"+hora;
        }
        return ""+hora;
    }
    private String obtenerMin(Calendar c){
        int minu= c.get(Calendar.MINUTE);
        if(minu<10){
            return "0"+minu;
        }
        return ""+minu;
    }
    private String obtenerSeg(Calendar c){
        int seg=c.get(Calendar.SECOND);
        if(seg<10){
            return "0"+seg;
        }
        return ""+seg;
    }
    private String agregarAMPM(Calendar c){
        int hora = c.get(Calendar.HOUR_OF_DAY);
        if(f==true){
            return "";
        }
        //0-11    13-23
        if(hora<12){
            return " AM";
        }
        return " PM";
    }
    public Reloj() {
        initComponents();
        ActualizaHora.start();
        letra = new Font("Arial Narrow",18,Font.PLAIN);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private Boolean f;
    private Font letra;
    private Color color;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
