/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr_kitten;

import java.util.Random;

/**
 *
 * @author Arya
 */
public class Interface extends javax.swing.JDialog {
    private static Game g = new Game();
    private boolean questDory,questBedroom,quest1 = false;
    /**
     * Creates new form Interface
     */
    public Interface(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        YesNo = new javax.swing.JDialog();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Shutdown = new javax.swing.JButton();
        Explore = new javax.swing.JButton();
        Help = new javax.swing.JButton();
        go_up = new javax.swing.JButton();
        go_down = new javax.swing.JButton();
        go_west = new javax.swing.JButton();
        go_east = new javax.swing.JButton();
        go_north = new javax.swing.JButton();
        go_south = new javax.swing.JButton();
        Look = new javax.swing.JButton();
        Items = new javax.swing.JButton();
        jButtonA = new javax.swing.JButton();
        jButtonB = new javax.swing.JButton();
        jButtonC = new javax.swing.JButton();
        jButtonD = new javax.swing.JButton();
        next = new javax.swing.JButton();

        jRadioButton1.setText("Oh Yes!");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Doesn't sound like Fun... No!");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Your call now!");

        javax.swing.GroupLayout YesNoLayout = new javax.swing.GroupLayout(YesNo.getContentPane());
        YesNo.getContentPane().setLayout(YesNoLayout);
        YesNoLayout.setHorizontalGroup(
            YesNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YesNoLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jRadioButton2)
                .addGap(21, 21, 21))
            .addGroup(YesNoLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        YesNoLayout.setVerticalGroup(
            YesNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, YesNoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(YesNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(128, 128, 128))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livingroom.png"))); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        Shutdown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mr_kitten/shutdown.png"))); // NOI18N
        Shutdown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShutdownMouseClicked(evt);
            }
        });

        Explore.setText("Explore");
        Explore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExploreMouseClicked(evt);
            }
        });

        Help.setText("Help");
        Help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HelpMouseClicked(evt);
            }
        });

        go_up.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mr_kitten/Arrow_up.png"))); // NOI18N
        go_up.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                go_upMouseClicked(evt);
            }
        });

        go_down.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mr_kitten/Arrow_down.png"))); // NOI18N
        go_down.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                go_downMouseClicked(evt);
            }
        });

        go_west.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mr_kitten/Arrow_left.png"))); // NOI18N
        go_west.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                go_westMouseClicked(evt);
            }
        });

        go_east.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mr_kitten/Arrow_right.png"))); // NOI18N
        go_east.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                go_eastMouseClicked(evt);
            }
        });

        go_north.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mr_kitten/Arrow_up.png"))); // NOI18N
        go_north.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                go_northMouseClicked(evt);
            }
        });
        go_north.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_northActionPerformed(evt);
            }
        });

        go_south.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mr_kitten/Arrow_down.png"))); // NOI18N
        go_south.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                go_southMouseClicked(evt);
            }
        });

        Look.setText("Look");
        Look.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LookMouseClicked(evt);
            }
        });

        Items.setText("Items");
        Items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemsMouseClicked(evt);
            }
        });

        jButtonA.setText("a");
        jButtonA.setVisible(false);
        jButtonA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAMouseClicked(evt);
            }
        });

        jButtonB.setText("b");
        jButtonB.setVisible(false);
        jButtonB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBMouseClicked(evt);
            }
        });

        jButtonC.setText("c");
        jButtonC.setVisible(false);
        jButtonC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCMouseClicked(evt);
            }
        });
        jButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCActionPerformed(evt);
            }
        });

        jButtonD.setText("d");
        jButtonD.setVisible(false);
        jButtonD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDMouseClicked(evt);
            }
        });

        next.setText("next");
        next.setVisible(false);
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Shutdown, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(go_down, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(293, 293, 293)
                                .addComponent(go_up, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Look))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Explore))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Items))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(go_west, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(go_north)
                            .addComponent(go_south))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(go_east, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(241, 241, 241)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonC)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(next)
                                .addGap(126, 126, 126)
                                .addComponent(Help)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(Shutdown, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonA)
                            .addComponent(Explore))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonB)
                            .addComponent(Items))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Look)
                            .addComponent(jButtonC))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonD)
                            .addComponent(Help)
                            .addComponent(next))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(go_east)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(go_up, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(go_north)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(go_south))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(go_west, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)))))))
                .addComponent(go_down, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Evenement when shut down with the mouse clicked
     * @param evt 
     */
    private void ShutdownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShutdownMouseClicked
        System.exit(1);
        // g.goRoom(new Command("go","north")); pour bouger de salle en fct de la direction avec les fleches
    }//GEN-LAST:event_ShutdownMouseClicked
    
    /**
     * Evenement when click the explore button
     * @param evt 
     */
    private void ExploreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExploreMouseClicked
        g.exploreRoomTest(this);
    }//GEN-LAST:event_ExploreMouseClicked

    /**
     * Evenement when click the help button
     * @param evt 
     */
    private void HelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpMouseClicked
        jTextArea1.setText(g.printHelp());
    }//GEN-LAST:event_HelpMouseClicked

//DEPLACEMENT ENTRE LES ROOMS
    private void go_upMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_go_upMouseClicked
        g.goRoom(new Command("go", "up"));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(g.getCurrentRoom().getImage())));
    }//GEN-LAST:event_go_upMouseClicked
    private void go_downMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_go_downMouseClicked
        g.goRoom(new Command("go", "down"));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(g.getCurrentRoom().getImage())));
    }//GEN-LAST:event_go_downMouseClicked
    private void go_westMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_go_westMouseClicked
        g.goRoom(new Command("go", "west"));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(g.getCurrentRoom().getImage())));
    }//GEN-LAST:event_go_westMouseClicked
    private void go_eastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_go_eastMouseClicked
        g.goRoom(new Command ("go", "east"));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(g.getCurrentRoom().getImage())));
    }//GEN-LAST:event_go_eastMouseClicked
    private void go_northMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_go_northMouseClicked
        g.goRoom(new Command("go", "north"));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(g.getCurrentRoom().getImage())));
    }//GEN-LAST:event_go_northMouseClicked
    private void go_southMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_go_southMouseClicked
        g.goRoom(new Command("go", "south"));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(g.getCurrentRoom().getImage())));
    }//GEN-LAST:event_go_southMouseClicked

    private void go_northActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_northActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_go_northActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed
    
    /**
     * Evenement when click with look button
     * @param evt 
     */
    private void LookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LookMouseClicked
        jTextArea1.setText((g.currentRoom.getDescription()));    // TODO add your handling code here:
    }//GEN-LAST:event_LookMouseClicked

    /**
     * Evenement when click with item button
     * @param evt 
     */
    private void ItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemsMouseClicked
        g.inventory(this);
    }//GEN-LAST:event_ItemsMouseClicked

    /**
     * Evenement when click a A button
     * @param evt 
     */
    private void jButtonAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAMouseClicked
        String currentRoom = g.getCurrentRoom().getName();
        //quest from living room
        if(currentRoom.equals("livingRoom")){
            if(quest1 == false) {
                jTextArea1.setText(ExpInfo.printlivingRoom_answerA());
                g.getPlayers().grabItem("home key");
                jTextArea1.setText("You received the home key !! \n"+ExpInfo.printlivingRoom_conclu());
                quest1 = true;
            }
            else{
                jTextArea1.setText("Hum...Yum !");
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
            }    
        }
        //quest from the kitchen
        else if (currentRoom.equals("kitchen")){
            jTextArea1.setText(ExpInfo.printKitchen_answerA());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
        }
        //quest from the bedroom
        else if (currentRoom.equals("bedroom")){
            if (!questBedroom){
                jTextArea1.setText(ExpInfo.printbedroom_answerA());
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
                jButtonC.setVisible(false);
                jButtonD.setVisible(false);
            }
            else {
                jTextArea1.setText(ExpInfo.printbedroom_answerCa());
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
            }
        }
        //quest from the street1
        else if (currentRoom.equals("street1")){
            jTextArea1.setText(ExpInfo.printStreet1_answerA());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
        }
        //quest from the sewer
        else if (currentRoom.equals("sewer")){
            //Figth with rat -- ATTACK NORMAL
            int HP = g.attack(g.getEnnemiHP());
            g.setEnnemiHP(HP);
            //Ennemi attack Mr Kitten
            if(g.ennemiHP >0){
                Random nbRd = new Random();
                int nextnb = nbRd.nextInt(g.ennemiAD)+1;
                int i =  g.getPlayers().getPlayerHP() - nextnb;
                g.getPlayers().setPlayerHP(i);
            }
            //Check if there is a winner
            boolean winnerFind = false;
            if (g.ennemiHP <= 0){
                jTextArea1.setText("You win !!! It remains "+g.getPlayers().getPlayerHP()+" HP");
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
                jButtonC.setVisible(false);
                Explore.setVisible(true);
                Help.setVisible(true);
                Look.setVisible(true);
                Items.setVisible(true);
                winnerFind = true;
            }
            if (g.getPlayers().getPlayerHP() <=0)
            {
                jTextArea1.setText("You loose !! GAME OVER !!");
                winnerFind = true;
                //System.exit(1);              
            }
            if (!winnerFind){
                g.fightPeopleIN(this);
            }
        }
        //quest from the street2
        else if (currentRoom.equals("street2")){
            jTextArea1.setText(ExpInfo.printStreet2_answerA());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
        }
        //quest from the petshop
        else if (currentRoom.equals("petshop")){
            jTextArea1.setText(ExpInfo.printPetshop_answerA());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
        }
        //quest from the dory room
        else if (currentRoom.equals("dory")){
            if (!questDory){
                jTextArea1.setText(ExpInfo.printdory_answerA());
                questDory = true;
            }
            else {
                jTextArea1.setText(ExpInfo.printdory_goodanswerA());
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
                jButtonC.setVisible(false);
                jButtonD.setVisible(false);
            }
        }
        //quest from the fish palace
        else if (currentRoom.equals("theFishPalace")){
            jTextArea1.setText(ExpInfo.printfishpalace_answerA());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
            g.getPlayers().grabItem("algea");
        }
        //quest from the star wars
        else if (currentRoom.equals("starWars")){
            jTextArea1.setText(ExpInfo.printvador_answerA());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
        }
        //quest from the end
        else if (currentRoom.equals("theEnd")){
            jTextArea1.setText(ExpInfo.printend_answerA());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
        }
    }//GEN-LAST:event_jButtonAMouseClicked

    /**
     * Evenement when click a B button
     * @param evt 
     */
    private void jButtonBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBMouseClicked
        String currentRoom = g.getCurrentRoom().getName();
        //quest from living room
        if(currentRoom.equals("livingRoom")){
            if(quest1 == false) {
                jTextArea1.setText(ExpInfo.printlivingRoom_answerB());
                jTextArea1.setText(ExpInfo.printlivingRoom_conclu());
                quest1 = true;
            }
            else{
                jTextArea1.setText("Hum...Yum !"); 
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
            }
        }
        //quest from the kitchen
        else if (currentRoom.equals("kitchen")){
            jTextArea1.setText(ExpInfo.printKitchen_answerB());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
        }
        //quest from the bedroom
        else if (currentRoom.equals("bedroom")){
            if (!questBedroom){
                jTextArea1.setText(ExpInfo.printbedroom_answerB());
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
                jButtonC.setVisible(false);
                jButtonD.setVisible(false);
            }
            else {
                jTextArea1.setText(ExpInfo.printbedroom_answerCb());
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
            }
        }
        //quest from the street1
        else if (currentRoom.equals("street1")){
            jTextArea1.setText(ExpInfo.printStreet1_answerB());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
            g.getPlayers().grabItem("potionCareMin");
        }
        //quest from the street2
        else if (currentRoom.equals("street2")){
            jTextArea1.setText(ExpInfo.printStreet2_answerB());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
        }
        //quest from the petshop
        else if (currentRoom.equals("petshop")){
            jTextArea1.setText(ExpInfo.printPetshop_answerB());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
        }
        //quest from the dory room
        else if (currentRoom.equals("dory")){
            if (!questDory){
                jTextArea1.setText(ExpInfo.printdory_answerB());
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
                jButtonC.setVisible(false);
                jButtonD.setVisible(false);
            }
            else {
                jTextArea1.setText(ExpInfo.printdory_goodanswerB());
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
                jButtonC.setVisible(false);
                jButtonD.setVisible(false);
            }
        }
        //quest from the fish palace
        else if (currentRoom.equals("theFishPalace")){
            jTextArea1.setText(ExpInfo.printfishpalace_answerB());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
        }
        //quest from the star wars
        else if (currentRoom.equals("starWars")){
            jTextArea1.setText(ExpInfo.printvador_answerB());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
        }
        //quest from the end
        else if (currentRoom.equals("theEnd")){
            jTextArea1.setText(ExpInfo.printend_answerB());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
        }
    }//GEN-LAST:event_jButtonBMouseClicked

    /**
     * Evenement when click a C button
     * @param evt 
     */
    private void jButtonCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCMouseClicked
        String currentRoom = g.getCurrentRoom().getName();
        //quest from bedroom
        if(currentRoom.equals("bedroom")){
            jTextArea1.setText(ExpInfo.printbedroom_answerC());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
            jButtonC.setVisible(false);
            jButtonD.setVisible(false);
            questBedroom = true;
        }
        //quest from dory room
        else if (currentRoom.equals("dory")){
            if (!questDory){
                jTextArea1.setText(ExpInfo.printdory_answerC());
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
                jButtonC.setVisible(false);
                jButtonD.setVisible(false);
            }
            else {
                jTextArea1.setText(ExpInfo.printdory_goodanswerC());
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
                jButtonC.setVisible(false);
                jButtonD.setVisible(false);
                g.getPlayers().grabItem("Artefact Of True Vision");
            }
        }
    }//GEN-LAST:event_jButtonCMouseClicked

    /**
     * Evenement when click a D button
     * @param evt 
     */
    private void jButtonDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDMouseClicked
        String currentRoom = g.getCurrentRoom().getName();
        //quest from bedroom
        if(currentRoom.equals("bedroom")){
            jTextArea1.setText(ExpInfo.printbedroom_answerD());
            jButtonA.setVisible(false);
            jButtonB.setVisible(false);
            jButtonC.setVisible(false);
            jButtonD.setVisible(false);
        }
        //quest from dory room
        else if (currentRoom.equals("dory")){
            if (!questDory){
                jTextArea1.setText(ExpInfo.printdory_answerD());
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
                jButtonC.setVisible(false);
                jButtonD.setVisible(false);
            }
            else {
                jTextArea1.setText(ExpInfo.printdory_goodanswerD());
                jButtonA.setVisible(false);
                jButtonB.setVisible(false);
                jButtonC.setVisible(false);
                jButtonD.setVisible(false);
            }
        }
    }//GEN-LAST:event_jButtonDMouseClicked

    private void jButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCActionPerformed

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nextMouseClicked

    /*private javax.swing.JDialog getYesNo (){
        YesNo.setVisible(true);
        return YesNo;
    }*/
    
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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Interface dialog = new Interface(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Explore;
    public javax.swing.JButton Help;
    public javax.swing.JButton Items;
    public javax.swing.JButton Look;
    private javax.swing.JButton Shutdown;
    private javax.swing.JDialog YesNo;
    private javax.swing.JButton go_down;
    private javax.swing.JButton go_east;
    private javax.swing.JButton go_north;
    private javax.swing.JButton go_south;
    private javax.swing.JButton go_up;
    private javax.swing.JButton go_west;
    public javax.swing.JButton jButtonA;
    public javax.swing.JButton jButtonB;
    public javax.swing.JButton jButtonC;
    public javax.swing.JButton jButtonD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JButton next;
    // End of variables declaration//GEN-END:variables
}
