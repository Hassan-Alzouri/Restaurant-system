
package savic.menuCasher;
import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
public class MenuAnimationCashier 
{
    public static void showMenuCashier(Component componet , MenuItemCashier itemCashier , MigLayout layout , boolean show)
    {
        int height = componet.getPreferredSize().height;
        Animator animator = new Animator(300, new TimingTargetAdapter()
        {
            @Override
            public void timingEvent(float fraction)
            {
                float f = show? fraction:1f-fraction;
                layout.setComponentConstraints(componet, "h " + height * f +"!");
                itemCashier.setAnimate(f);
                componet.revalidate();
                itemCashier.repaint();
            }
       
            
        });
            
        animator.setResolution(0);      // To make like smooth
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        animator.start();
        
       
    }
    
}
