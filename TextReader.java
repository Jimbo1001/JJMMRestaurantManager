import java.io.File; 
import java.util.Scanner; 
import java.io.FileNotFoundException; 
import java.util.ArrayList;

class TextReader {
    /*
    public static ArrayList<MenuItem> ReadMenuItems ( Menu menu ) {
        String content = "";
        try {
            File menuTxt = new File("Menu.txt");
            Scanner Reader = new Scanner(menuTxt);
            while ( Reader.hasNextLine() ) {
                content += Reader.nextLine();
            }
            Reader.close();
        } catch ( FileNotFoundException e ) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String [] contentSplit = content.split("~");
        String [] menuSplit = contentSplit[0].split("*");
        String [] itemSplit = new String [2];
        String name = "";
        Float price = null;
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        for ( int i = 0; i < menuSplit.length; i++ ) {
            itemSplit = menuSplit[i].split(",");
            name = itemSplit[0];
            price = Float.parseFloat(itemSplit[1]);
            menuItems.add( new MenuItem( name, price ) );
        } 
        return menuItems;
    }

    public static ArrayList<MenuItem> ReadCustomItems ( Menu menu ) {
        String content = "";
        try {
            File menuTxt = new File("Menu.txt");
            Scanner Reader = new Scanner(menuTxt);
            while ( Reader.hasNextLine() ) {
                content += Reader.nextLine();
            }
            Reader.close();
        } catch ( FileNotFoundException e ) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String [] contentSplit = content.split("~");
        String [] customSplit = contentSplit[1].split("*");
        String [] itemSplit = new String [2];
        String name = "";
        Float price = null;
        ArrayList<MenuItem> customItems = new ArrayList<MenuItem>();
        for ( int i = 0; i < customSplit.length; i++ ) {
            itemSplit = customSplit[i].split(",");
            name = itemSplit[0];
            price = Float.parseFloat(itemSplit[1]);
            customItems.add( new MenuItem( name, price ) );
        } 
        return customItems;
    }

    public static ArrayList<Integer> ReadLogin() {
        String content = "";
        try {
            File LoginTxt = new File("Login.txt");
            Scanner Reader = new Scanner(LoginTxt);
            while ( Reader.hasNextLine() ) {
                content += Reader.nextLine();
            }
            Reader.close();
        } catch ( FileNotFoundException e ) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String [] loginSplit = content.split("*");
        ArrayList<Integer> logins = new ArrayList<Integer>();
        for ( int i = 0; i < loginSplit.length; i++ ) {
            if ( !loginSplit[i].equals("") ) {
                logins.add(Integer.parseInt(loginSplit[i]));
            }
        }
        return logins;
    }*/
}