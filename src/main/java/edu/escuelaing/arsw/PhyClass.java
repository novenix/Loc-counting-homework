package edu.escuelaing.arsw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhyClass {
    private Long cont= Long.valueOf(0);
    Long getCont(){
        return cont;
    }
    private void setCont(Long i){
        cont = i;
    }

    public  PhyClass(String fileName) {
        Path path = Paths.get(fileName);
        try (Stream<String> stream = Files.lines(path)) {
            cont=stream.count();


        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
