package savic_application;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import savic.application.form.LoginForm;
import savic.application.form.MainForm;
import savic.application.form.FormDisplayReports;
import savic.menu.xdd;
import raven.toast.Notifications;

/**
 *
 * @author Raven
 */
public class Application extends javax.swing.JFrame {

    private static Application app;
    public final MainForm mainForm;
    // private final LoginForm loginForm;

    public Application() {
        app = this; // Set the app instance to the current instance
        initComponents();
        setSize(new Dimension(1500, 850));
        setLocationRelativeTo(null);
        mainForm = new MainForm();
        // loginForm = new LoginForm();
    
        setContentPane(mainForm);
        Notifications.getInstance().setJFrame(this);


        
        
       
            
    }

    public void showForm(Component com) {
    if(Application.getAppInstance() != null) {
        Application.getAppInstance().getComponentOrientation();
        // Rest of the method...
    } else {
        // Handle the case where app instance is null
    }
}


//    public static void login() {
//        FlatAnimatedLafChange.showSnapshot();
//        app.setContentPane(app.mainForm);
//        app.mainForm.applyComponentOrientation(app.getComponentOrientation());
//        setSelectedMenu(0, 0);
//        app.mainForm.hideMenu();
//        SwingUtilities.updateComponentTreeUI(app.mainForm);
//        FlatAnimatedLafChange.hideSnapshotWithAnimation();
//    }
//
//    public static void logout() {
//        FlatAnimatedLafChange.showSnapshot();
//        app.setContentPane(app.loginForm);
//        app.loginForm.applyComponentOrientation(app.getComponentOrientation());
//        SwingUtilities.updateComponentTreeUI(app.loginForm);
//        FlatAnimatedLafChange.hideSnapshotWithAnimation();
//    }

    public static void setSelectedMenu(int index, int subIndex) {
        app.mainForm.setSelectedMenu(index, subIndex);
    }
    
   public static void setAppInstance(Application application) {
        app = application;
    }

    public static Application getAppInstance() {
        return app;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

public static void main(String args[]) {
    FlatRobotoFont.install();
    FlatLaf.registerCustomDefaultsSource("raven.theme");
    FlatMacDarkLaf.setup(); // Set up dark mode
    java.awt.EventQueue.invokeLater(() -> {
        Application app = new Application();
        app.setVisible(true);
        Application.setAppInstance(app);
    });
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
