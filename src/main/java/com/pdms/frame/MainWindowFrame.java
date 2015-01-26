package com.pdms.frame;

//import the packages for using the classes in them into the program
import com.google.common.base.Strings;
import com.pdms.utils.Utils;
import com.pdms.frame.utils.MenuItemActionListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * A public class
 */

public class MainWindowFrame extends JFrame {

    private Utils utils = new Utils();
    private JSONArray jsonObj;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private ArrayList<JMenuItem> menuItems;
    private JSONObject jsonMenuItem;
    private JInternalFrame frame;
    private ImageIcon imageIcon;
    private String menuTitle;
    private String shortcut;
    private boolean separator;
    private JToolBar toolBar = new JToolBar();
    private JToolBar searchToolBar = new JToolBar();
    private JDesktopPane desktop = new JDesktopPane();
    private StatusBar statusbar = new StatusBar();
    private JPanel searchPanel = new JPanel();
    //private final String userDir = System.getProperty("user.dir");
    private JSONParser parser = new JSONParser();
    private Container container;
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Image image;
    private String className;
    private JButton button;

    

    public MainWindowFrame() {
        setTitle("PDMS");
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        menuBar = new JMenuBar();
        container = getContentPane();
        setJMenuBar(menuBar);
        
        desktop.setBackground(Color.GRAY);
        container.add("South", statusbar);
        container.add("North", toolBar);

        container.add("Center", desktop);
        loadJson();
        loadComponents();
        //setVisible(true);

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        show();
       
    }

    public static void main(String[] args) throws Exception {
        //new MainWindowFrame();
    }

    private void loadJson() {

        URL path = ClassLoader.getSystemResource("window.json");
        //System.out.println(path.getAbsolutePath());
        Object obj;
        try {
            obj = parser.parse(new FileReader(path.getFile()));
            jsonObj = (JSONArray) obj;
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        //System.out.println(jsonObj);
    }

    private void loadComponents() {
        int count = jsonObj.size(), i;
        JSONObject jsonMenu;
        JSONObject menuItems;
        for (i = 0; i < count; i++) {
            jsonMenu = (JSONObject) jsonObj.get(i);
            addMenu(jsonMenu);
        }
    }

    private void addMenu(JSONObject jsonMenu) {
        menu = new JMenu((String) jsonMenu.get("menuTitle"));
        menu.setMnemonic(((String) jsonMenu.get("mnemonic")).charAt(0));
        List<JMenuItem> menuItems = getMenuItem((JSONArray) jsonMenu.get("menuItem"));
        for (JMenuItem menuItem : menuItems) {
            menu.add(menuItem);
        }
        menuBar.add(menu);
    }

    private ArrayList<JMenuItem> getMenuItem(JSONArray jsonMenuItems) {
        int count = jsonMenuItems.size(), i;
        menuItems = new ArrayList<>();
        for (i = 0; i < count; i++) {
            jsonMenuItem = (JSONObject) jsonMenuItems.get(i);
            menuTitle = (String) jsonMenuItem.get("menuTitle");
            menuItem = new JMenuItem(menuTitle, imageIcon);
            className = (String) jsonMenuItem.get("className");
            shortcut = (String) jsonMenuItem.get("shortcut");
            separator = (Boolean) jsonMenuItem.get("separator");
            imageIcon = new ImageIcon(ClassLoader.getSystemResource((String) jsonMenuItem.get("imageIcon")));
            if (!Strings.isNullOrEmpty(shortcut)) {
                menuItem.setAccelerator(utils.getKeyStroke(shortcut));
            }
            menuItem.setActionCommand(className);
            menuItem.addActionListener(new MenuItemActionListener(desktop, className));
            menu.add(menuItem);
            button = new JButton(imageIcon);
            button.setToolTipText(menuTitle);
            button.addActionListener(new MenuItemActionListener(desktop, className));
            toolBar.add(button);
        }
        return menuItems;
    }
}
