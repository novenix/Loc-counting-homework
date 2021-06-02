package edu.escuelaing.arsw;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Hashtable;

/**
 * Hello world!
 *
 */
public class App 
{
     private static Hashtable<String, Boolean> comentarios = new Hashtable<>();
     private static Integer cont =0;
     private static int getCont(){
         return cont;
     }
    private static int setCont(){
        return cont += 1;
    }


    public static void main( String[] args ) throws IOException
    {

        comentarios.put("//", true);
        comentarios.put("/**", true);
        comentarios.put("*", true);
        comentarios.put("*/", true);
        String typeOfCount = args [0];
        String fileName = args [1];
        int indexAsterisc = fileName.indexOf("*");
        if (indexAsterisc != 0){
            String initialPath = fileName.substring(0,indexAsterisc);
            System.out.println(initialPath);
            String extension = fileName.substring(indexAsterisc+2);
            System.out.println(extension);
            Path dir = FileSystems.getDefault().getPath(initialPath);
            DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{" +extension+"}" );
            for (Path i:stream){
                if(typeOfCount.equals("loc")){
                    LocClass loc = new LocClass(initialPath+ i.getFileName().toString());
                    System.out.println(loc.getCont());
                }
                if(typeOfCount.equals("phy")){
                    PhyClass phy  = new PhyClass(initialPath+ i.getFileName().toString());
                    System.out.println(phy.getCont());

                }
            }
            stream.close();
        }
        else {
            if(typeOfCount.equals("loc")){
                LocClass loc = new LocClass(fileName);
                System.out.println(loc.getCont());
            }
            if(typeOfCount.equals("phy")){
                PhyClass phy  = new PhyClass(fileName);
                System.out.println(phy.getCont());

            }
        }


        System.out.println( "typeOfCount: " + typeOfCount );
        System.out.println( "fileName: " + fileName );


        //comentarios.put("\r", true);
    }
}
