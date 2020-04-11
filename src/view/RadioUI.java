package view;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import controller.Controller;
import model.Player;

/**
 *
 * @author Dimitris
 */
public class RadioUI extends javax.swing.JFrame {
	int ena;
	int dyo;
    /**
     * Creates new form RadioUI
     */
    public RadioUI() {
    	
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
     
        zari1 = new javax.swing.JButton();
        zari2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Radio Contest");

        zari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zari1ActionPerformed(evt);
            }
        });

        zari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zari2ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
        jLabel1.setText("Player 1");
        jLabel1.setToolTipText("");

        

        jLabel2.setText("Player 2");

        jButton3.setText("Winner");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(zari1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(zari2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(zari1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(zari2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
        );


        pack();
    }

    private void zari1ActionPerformed(java.awt.event.ActionEvent evt) {
    	Object src = evt.getActionCommand();
    	
    	int i = 0;
		Random rn=new Random();
		i = rn.nextInt(6)+1;
		this.ena = i;
    	Image zaria = new ImageIcon("src/view/images/dice-" + i + ".jpg").getImage().getScaledInstance(70, 70,
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon ena = new ImageIcon(zaria);
		zari1.setIcon(ena);
    }

    private void zari2ActionPerformed(java.awt.event.ActionEvent evt) {
    	Object src = evt.getActionCommand();
    	int i = 0;
		Random rn=new Random();
		i = rn.nextInt(6)+1; 
		this.dyo = i;
    	Image zaria = new ImageIcon("src/view/images/dice-" + i + ".jpg").getImage().getScaledInstance(70, 70,
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon ena = new ImageIcon(zaria);
		zari2.setIcon(ena);
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
//    	if(ena>dyo) {
//    		if(ctr.getP1().getC() == Player.color.BLUE) {
//    		Image zaria = new ImageIcon("src/view/images/pawn_blue.png").getImage().getScaledInstance(70, 70,
//    				java.awt.Image.SCALE_SMOOTH);
//    		ImageIcon ena = new ImageIcon(zaria);
//    		jButton3.setIcon(ena);
//    		}else{
//    			Image zaria = new ImageIcon("src/view/images/pawn_yellow.png").getImage().getScaledInstance(70, 70,
//        				java.awt.Image.SCALE_SMOOTH);
//        		ImageIcon ena = new ImageIcon(zaria);
//        		jButton3.setIcon(ena);
//    		}
//    	}else{
//    		if(ctr.getP2().getC() == Player.color.BLUE) {
//        		Image zaria = new ImageIcon("src/view/images/pawn_blue.png").getImage().getScaledInstance(70, 70,
//        				java.awt.Image.SCALE_SMOOTH);
//        		ImageIcon ena = new ImageIcon(zaria);
//        		jButton3.setIcon(ena);
//        		}else{
//        			Image zaria = new ImageIcon("src/view/images/pawn_yellow.png").getImage().getScaledInstance(70, 70,
//            				java.awt.Image.SCALE_SMOOTH);
//            		ImageIcon ena = new ImageIcon(zaria);
//            		jButton3.setIcon(ena);
//        		}
//    	}
//    	
    	
    }

    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	
    	
    //	System.out.println("----->"+ ctr.getP1().toString());
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RadioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RadioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RadioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RadioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RadioUI().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton zari1;
    private javax.swing.JButton zari2;
}
