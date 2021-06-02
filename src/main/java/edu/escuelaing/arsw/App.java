package edu.escuelaing.arsw;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * Hello world!
 */
public class App
{

     private static Integer cont =0;


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main( String[] args ) throws IOException
    {
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


    }
}
