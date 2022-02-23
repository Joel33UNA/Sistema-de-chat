/*
UNIVERSIDAD NACIONAL DE COSTA RICA
EIF-206  -  PROGRAMACIÓN III
ESTUDIANTE: JOEL ZAMORA Y DIEGO JIMÉNEZ
PROFESOR: JOSE SÁNCHEZ SALAZAR
*/

package usuario.presentation.principal;

import java.util.Observable;
import java.util.Observer;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextArea;
import protocol.Logic.Contacto;
import protocol.Logic.Mensaje;
import protocol.Logic.Usuario;
import protocol.table.ContactoTableModel;

public class View extends javax.swing.JFrame implements Observer {
    public View() {
        this.controller = null;
        this.model = null;
        this.getContentPane().setBackground(new java.awt.Color(0, 200, 255));
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelContraseña = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();
        jPasswordFieldLogin = new javax.swing.JPasswordField();
        jPanelChat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaChat = new javax.swing.JTextArea();
        jLabelEscribir = new javax.swing.JLabel();
        jButtonEnviar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaEscribe = new javax.swing.JTextArea();
        jButtonLogOut = new javax.swing.JButton();
        jLabelChat = new javax.swing.JLabel();
        jLabelEnviarMensaje = new javax.swing.JLabel();
        jLabelRegistrar = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelFiltrar = new javax.swing.JLabel();
        jTextFieldFiltrar = new javax.swing.JTextField();
        jButtonFiltrar = new javax.swing.JButton();
        jButtonAgregar = new javax.swing.JButton();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelRegistrar1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableContactos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelUsuario.setText("Identificación");

        jLabelContraseña.setText("Contraseña: ");

        jButtonLogin.setText("Entrar");
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseClicked(evt);
            }
        });

        jButtonCerrar.setText("Terminar");
        jButtonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabelContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelContraseña)
                    .addComponent(jButtonLogin)
                    .addComponent(jButtonCerrar)
                    .addComponent(jPasswordFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTextAreaChat.setEditable(false);
        jTextAreaChat.setColumns(20);
        jTextAreaChat.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextAreaChat.setForeground(new java.awt.Color(51, 51, 51));
        jTextAreaChat.setRows(5);
        jScrollPane1.setViewportView(jTextAreaChat);

        jLabelEscribir.setText("Escribir mensaje:");

        jButtonEnviar.setText("Enviar mensaje");
        jButtonEnviar.setEnabled(false);
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jTextAreaEscribe.setColumns(20);
        jTextAreaEscribe.setRows(5);
        jTextAreaEscribe.setEnabled(false);
        jScrollPane2.setViewportView(jTextAreaEscribe);

        jButtonLogOut.setText("Cerrar sesión");
        jButtonLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLogOutMouseClicked(evt);
            }
        });

        jLabelChat.setText("Chat:");

        jLabelEnviarMensaje.setText("Enviar mensaje a:");

        jLabelRegistrar.setText("Registrar contacto (ID):");

        jLabelFiltrar.setText("Filtrar:");

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonFiltrarMouseClicked(evt);
            }
        });

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAgregarMouseClicked(evt);
            }
        });

        jLabelRegistrar1.setText("(Nombre):");

        jTableContactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContactosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableContactos);

        javax.swing.GroupLayout jPanelChatLayout = new javax.swing.GroupLayout(jPanelChat);
        jPanelChat.setLayout(jPanelChatLayout);
        jPanelChatLayout.setHorizontalGroup(
            jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(jButtonEnviar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelChatLayout.createSequentialGroup()
                        .addGroup(jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRegistrar)
                            .addComponent(jLabelEnviarMensaje)
                            .addComponent(jLabelRegistrar1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldID)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
                    .addComponent(jLabelEscribir)
                    .addGroup(jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelChatLayout.createSequentialGroup()
                            .addComponent(jLabelFiltrar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChatLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanelChatLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChat)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelChatLayout.setVerticalGroup(
            jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelChatLayout.createSequentialGroup()
                        .addGroup(jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelChatLayout.createSequentialGroup()
                                .addComponent(jLabelChat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelEnviarMensaje))
                            .addGroup(jPanelChatLayout.createSequentialGroup()
                                .addGroup(jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelChatLayout.createSequentialGroup()
                                        .addGroup(jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelRegistrar)
                                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelRegistrar1))))
                                .addGap(0, 13, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFiltrar)
                            .addComponent(jTextFieldFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonFiltrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelEscribir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelChatLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnviar)
                    .addComponent(jButtonLogOut))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.jButtonEnviar.setEnabled(false);
        this.jTextAreaEscribe.setEnabled(false);
        controller.logOut();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLogOutMouseClicked
        this.jButtonEnviar.setEnabled(false);
        this.jTextAreaEscribe.setEnabled(false);
        controller.logOut();
    }//GEN-LAST:event_jButtonLogOutMouseClicked

    private void jButtonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseClicked
        try{
            Usuario typed = new Usuario();
            typed.setId(this.jTextFieldUsuario.getText());
            typed.setClave(new String(this.jPasswordFieldLogin.getPassword()));
            typed.setNombre("");
            this.controller.login(typed);
            this.jPasswordFieldLogin.setText(null);
            this.jTextFieldUsuario.setText(null);
        }
        catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "El usuario o contraseña no existe.");
            this.jPasswordFieldLogin.setText(null);
            this.jTextFieldUsuario.setText(null);
        }
    }//GEN-LAST:event_jButtonLoginMouseClicked

    private void jButtonCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButtonCerrarMouseClicked

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        try{
            if (this.jTableContactos.getSelectedRow() == -1)
                throw new Exception();
            int seleccionado = jTableContactos.getSelectedRow();
            Contacto contacto = model.getContactos().get(seleccionado);
            controller.post(contacto);
        }
        catch(Exception e){
            showMessageDialog(null, "Debe seleccionar un contacto, reintente.");
        }
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jButtonAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAgregarMouseClicked
        try{
            if (this.jTextFieldID.getText().isEmpty() || this.jTextFieldNombre.getText().isEmpty())
                throw new Exception();
            Contacto contacto = new Contacto(jTextFieldNombre.getText(), jTextFieldID.getText());
            controller.agregarContacto(contacto);
            this.jTextFieldNombre.setText(null);
            this.jTextFieldID.setText(null);
        }
        catch(Exception e){
            showMessageDialog(null, "Contacto no admitido.");
        }
    }//GEN-LAST:event_jButtonAgregarMouseClicked

    private void jButtonFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonFiltrarMouseClicked
        Contacto contacto = new Contacto();
        contacto.setNombre(jTextFieldFiltrar.getText());
        controller.filtrarContacto(contacto);
    }//GEN-LAST:event_jButtonFiltrarMouseClicked

    private void jTableContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContactosMouseClicked
        this.jTextAreaEscribe.setEnabled(true);
        this.jButtonEnviar.setEnabled(true);
        if (this.jTableContactos.getSelectedRow() != -1)
            controller.filtrarMensajes(jTableContactos.getSelectedRow());
    }//GEN-LAST:event_jTableContactosMouseClicked

    @Override
    public void update(Observable o, Object arg) {
        if(model.getCurrent()==null){
           this.jPanelLogin.setVisible(true);
           this.jPanelChat.setVisible(false);
           this.setTitle(null);
       }
       else{
           this.jPanelLogin.setVisible(false);
           this.jPanelChat.setVisible(true);           
            this.setTitle(model.getCurrent().toString());
            String msg="";
            for( Mensaje m: model.getMensajes())
                msg += (m.toString() + "\n");
            this.jTextAreaChat.setText(msg);
            this.jTextAreaEscribe.setText(null);
            this.jTextAreaEscribe.requestFocus();
            this.jTableContactos.setModel(new ContactoTableModel(this.model.getContactos()));
       }
        this.validate();
    }
    
    public void setController(Controller controller){
        this.controller = controller;
    }
    
    public void setModel(Model model){
        this.model = model;
        model.addObserver(this);
    }
    
    public JTextArea getMensaje() {
        return this.jTextAreaEscribe;
    }
    
    Controller controller;
    Model model;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelChat;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelEnviarMensaje;
    private javax.swing.JLabel jLabelEscribir;
    private javax.swing.JLabel jLabelFiltrar;
    private javax.swing.JLabel jLabelRegistrar;
    private javax.swing.JLabel jLabelRegistrar1;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelChat;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPasswordField jPasswordFieldLogin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableContactos;
    private javax.swing.JTextArea jTextAreaChat;
    private javax.swing.JTextArea jTextAreaEscribe;
    private javax.swing.JTextField jTextFieldFiltrar;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

}
