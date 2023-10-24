package sgbd_rayco;
import java.io.FileNotFoundException;

public class SGBD_Rayco {

    public static void main(String[] args) throws FileNotFoundException {
        switch(args[0]){
            case "add": CRUD.add(args[1], args[2], Integer.parseInt(args[3]), Integer.parseInt(args[4]));
            case "list": CRUD.list();
            case "update": CRUD.update(Integer.parseInt(args[1]), args[2], args[3], Integer.parseInt(args[4]), Integer.parseInt(args[5]));
        }
    }
    
}
