package edu.escuelaing.arsw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.stream.Stream;

/**
 * The type Phy class.
 */
public class PhyClass {
    private Long cont= Long.valueOf(0);

    /**
     * Get cont long.
     * This allows to return the integer of total lines of the file with spaces and comments
     * @return the long
     */
    Long getCont(){
        return cont;
    }
    private void setCont(Long i){
        cont = i;
    }

    /**
     * Instantiates a new Phy class.
     *
     * @param fileName the file name
     * @throws IOException the io exception
     */
    public  PhyClass(String fileName) throws IOException  {
        Path path = Paths.get(fileName);
        try (Stream<String> stream = Files.lines(path)) {
            cont=stream.count();


        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
