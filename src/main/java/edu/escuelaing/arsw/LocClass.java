package edu.escuelaing.arsw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Loc class.
 */
public class LocClass {
    private  Integer cont =0;
    private Boolean isComment=false;
    private  Boolean getIsComment(){
        return isComment;
    }
    private  void setIsComment(Boolean bol){
        isComment = bol;

    }

    /**
     * Get cont int.
     * This allows to return the integer of total lines of the file without spaces and comments
     * @return the int
     */
    int getCont(){
        return cont;
    }

    private  int setCont(){
        return cont += 1;
    }

    private  Boolean checkAsterisc(String i){

        return i.trim().substring(0, 1).matches("\\*") && getIsComment();
    }

    private  Boolean checkSlash(String i){

        return  i.trim().substring(0, 2).matches("//") ;
    }

    private  Boolean checkStartAsteriscComment(String i){


        return  i.trim().substring(0, 2).matches("/\\*") ;
    }

    private  Boolean checkFinishAsteriscComment(String i){


        return  i.trim().substring(0, 2).matches("\\*\\/");
    }

    /**
     * Instantiates a new Loc class.
     *
     * @param fileName the file name
     * @throws IOException the io exception
     */
    public LocClass(String fileName) throws IOException  {
        Path path = Paths.get(fileName);
        try (Stream<String> stream = Files.lines(path)) {
            for(String i:stream.collect(Collectors.toList())){

                    if(i.trim().length()==1  ){

                         if(checkAsterisc(i) ){
                             //no hace nada, no debe contar
                         }
                    }
                    if(i.trim().length()>=2  ){
                        if(checkSlash(i)){
                            //no hace nada, no debe contar
                        }
                        else if(checkFinishAsteriscComment(i)){
                            setIsComment(false);
                            //no hace nada, no debe contar
                        }
                        else if( checkStartAsteriscComment(i)){
                            setIsComment(true);

                            //no hace nada, no debe contar

                        }
                        else if( !getIsComment() ){
                            setCont();
                        }
//
                    }
                    else if(i.trim().length()==0 ){

                    }
                     else {
                         setCont();
                     }
                    stream.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
