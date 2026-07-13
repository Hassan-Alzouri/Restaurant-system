
package savic.menuCasher;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;


public class menuCashier extends JComponent
{
    private MenuEventCashier event;

    public MenuEventCashier getEvent() {
        return event;
    }

    public void setEvent(MenuEventCashier event) {
        this.event = event;
    }
    private MigLayout layout;
    private String menuCashierItem[][] = new String[][]
    {
        {"Dashboard"},
        {"Main Menu","Menu"},
//        {"Customer","Add a new customer"},
        {"Logout"},
        {"Exit"}
       
    };
    
    public menuCashier() 
    {
        initCashier();
    }
    
    private void initCashier()
    {
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill"); 
        setLayout(layout);
        setOpaque(true); // for graphcs
        
        // init Casher menuItemCashier;
        for(int i=0 ; i < menuCashierItem.length ; i++)
        {
            addMenuCashier(menuCashierItem[i][0], i);    // that get Dashboard, Menu,Customer, Logout only index not subMenu;
        }
        
        
    }
    
    
    private Icon getIcon(int index) // get icon by index
    {
        URL url = getClass().getResource("/raven/menuCasher/"+index+".png");
        
        if(url!=null)
        {
            return new ImageIcon(url);
        }
        else
        {
            return null;
        }
    }
    
    
    
    
    private void addMenuCashier(String menuName, int index) {
        // Determine the length of the submenu array
        int length = menuCashierItem[index].length;

        // Create a menu item based on the length of the submenu
        MenuItemCashier itemCashier = new MenuItemCashier(menuName, index, length > 1);
        Icon icon = getIcon(index);
        if(icon !=  null)
        {
            itemCashier.setIcon(icon);
        }

        // Add action listener to the menu item
        itemCashier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // If the submenu exists
                if (length > 1) {
                    if (!itemCashier.isSelected()) {
                        itemCashier.setSelected(true);

                        // When click at menu will see for menu not another; and so on very important [getComponetZOrder]
                        addSubMenuCashier(itemCashier, index, length, getComponentZOrder(itemCashier));
                    } else {

                        //Hide menu
                        hideMenuCashier(itemCashier, index);
                        itemCashier.setSelected(false);

                    }
                }
                else
                {
                    if(event != null)
                    {
                        event.selected(index, 0);
                    }
                }
            }
        });

        // Add the menu item to the UI
        add(itemCashier);
        // Update the layout
        revalidate();
        // Update the graphics
        repaint();
    }


      
    
    // Create method to addSubMenu when user click to index that have length > 1;
    public void addSubMenuCashier(MenuItemCashier itemCashier, int index , int length , int indexZorder)           
    {
        JPanel panel = new JPanel(new MigLayout("wrap 1, fillx, inset 0 , gapy 0", "fill"));            // Add all of thing inside Panel;
        panel.setName(index + "");
        panel.setOpaque(false);     // diable the color;
        for(int i=1 ; i < length ; i++)
        {                                                     // Eg: Customer index - > subindex = add a new customer;
            MenuItemCashier subItem = new MenuItemCashier(menuCashierItem[index][i], i , false);
            
            subItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    if(event != null)
                    {
                        event.selected(index, subItem.getIndex());
                    }
            }});
            
            subItem.intSubMenuCashier(i, length);
            panel.add(subItem);
        }
        
        add(panel,"h 0!",indexZorder+1);       // When click at menu will see for menu not another; and so on very important
        revalidate();
        repaint();
        MenuAnimationCashier.showMenuCashier(panel, itemCashier, layout, true);
    }
    
    private void hideMenuCashier(MenuItemCashier item , int index)
    {
        for(Component com: getComponents())
        {
            if(com instanceof JPanel&&com.getName()!=null&&com.getName().equals(index+""))
            {
                com.setName(null);
                MenuAnimationCashier.showMenuCashier(com, item, layout, false); // False to hide menu
                break;
            }
        }
        
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setColor(new Color(21,110,71));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        super.paintComponent(grphcs);
    }
    
    
    
}
