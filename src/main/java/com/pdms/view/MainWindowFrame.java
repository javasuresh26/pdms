package com.pdms.view;

//import the packages for using the classes in them into the program
import com.google.common.base.Strings;
import com.pdms.utils.Utils;
import com.pdms.view.utils.MenuItemActionListener;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    private JDesktopPane desktop = new JDesktopPane();
    private final String userDir = System.getProperty("user.dir");

    public MainWindowFrame() throws Exception {
        menuBar = new JMenuBar();
        loadJson();
        loadComponents();
    }

    public static void main(String[] args) throws Exception {
        new MainWindowFrame();
    }

    private void load() throws FileNotFoundException {

    }

    private void loadJson() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        File path = new File(userDir + "/src/main/resources");
        //System.out.println(path.getAbsolutePath());
        Object obj = parser.parse(new FileReader(path + "/window.json"));
        jsonObj = (JSONArray) obj;
        //System.out.println(jsonObj);
    }

    private void loadComponents() {
        int count = jsonObj.size(), i;
        JSONObject menu;
        JSONObject menuItems;
        Class entityClass;
        for (i = 0; i < count; i++) {
            menu = (JSONObject) jsonObj.get(i);

        }
    }

    private void addMenu(JSONObject jsonMenu) {
        menu = new JMenu((String) jsonMenu.get("menuTitle"));
        menu.setMnemonic(((String) jsonMenu.get("mnemonic")).charAt(0));
        List<JMenuItem> menuItems = getMenuItem((JSONArray) jsonMenu.get("menuTitle"));
    }

    private ArrayList<JMenuItem> getMenuItem(JSONArray jsonMenuItems) {
        int count = jsonMenuItems.size(), i;

        menuItems = new ArrayList<>();

        for (i = 0; i < count; i++) {
            jsonMenuItem = (JSONObject) jsonMenuItems.get(i);
            imageIcon = new ImageIcon(userDir + (String) jsonMenuItem.get("imageIcon"));
            menuItem = new JMenuItem((String) jsonMenuItem.get("menuTitle"), imageIcon);
            frame = (JInternalFrame) utils.createInstanceAs((String) jsonMenuItem.get("className"));
            shortcut = (String) jsonMenuItem.get("shortcut");
            separator = (Boolean) jsonMenuItem.get("shortcut");
            if (!Strings.isNullOrEmpty(shortcut)) {
                menuItem.setAccelerator(utils.getKeyStroke(shortcut));
            }
            menuItem.addActionListener(new MenuItemActionListener(desktop, frame));

        }
        return menuItems;
    }
}
