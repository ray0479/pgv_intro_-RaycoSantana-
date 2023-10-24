
package sgbd_rayco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class CRUD {
    public static void add(String name, String lastName, int curso, int nota) throws FileNotFoundException{
        try{
            File archivo = new File("BBDD.dat");
            RandomAccessFile raf = new RandomAccessFile(archivo, "rw");

            int nuevoId = 1;
            while (raf.getFilePointer() < raf.length()) {
                raf.readInt();
                raf.readChar();
                raf.readChar();
                raf.readInt();
                raf.readInt();
                nuevoId++;
            }


            raf.seek(raf.length());
            raf.writeInt(nuevoId);
            raf.writeChars(name);
            raf.writeChars(lastName);
            raf.writeInt(curso);
            raf.writeInt(nota);

            System.out.println("Empleado insertado con ID: " + nuevoId);
            raf.close();
        }catch(IOException e){
        
        }
    }
    public static void list(){
        try{
            File archivo = new File("BBDD.dat");
            RandomAccessFile raf = new RandomAccessFile(archivo, "r");

            while (raf.getFilePointer() < raf.length()) {
                System.out.println("ID: " + raf.readInt());
                System.out.println("Nombre: " + raf.readChar());
                System.out.println("Apellido" + raf.readChar());
                System.out.println("Curso" + raf.readInt());
                System.out.println("Nota: " + raf.readInt());
            }
            raf.close();
        }catch(IOException e){}
    }
    public static void update(int id, String name, String lastName, int curso, int nota){
        try{
            File archivo = new File("BBDD.dat");
            RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
            while (raf.getFilePointer() < raf.length()) {
                if(id == raf.readInt()){
                    raf.writeChars(name);
                    raf.writeChars(lastName);
                    raf.writeInt(curso);
                    raf.writeInt(nota);
                }else{
                    raf.readInt();
                    raf.readChar();
                    raf.readChar();
                    raf.readInt();
                    raf.readInt();
                }  
            }
            raf.close();
        }catch(IOException e){
            
        }
    }
    public static void delete(int id){
        
    }
}
