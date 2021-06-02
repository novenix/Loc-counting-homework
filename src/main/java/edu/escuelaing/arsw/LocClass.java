package edu.escuelaing.arsw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocClass {
    private  Integer cont =0;
    private Boolean isComment=false;
    private  Boolean getIsComment(){
        return isComment;
    }
    private  void setIsComment(Boolean bol){
        isComment = bol;

    }
    int getCont(){
        return cont;
    }
    private  int setCont(){
        return cont += 1;
    }
    private  Boolean checkAsterisc(String i){
        System.out.println(getIsComment()+"iscomment?");

        return i.trim().substring(0, 1).matches("\\*") && getIsComment();
    }
    private  Boolean checkSlash(String i){

        System.out.println();
        return  i.trim().substring(0, 2).matches("//") ;
    }

    private  Boolean checkStartAsteriscComment(String i){


        return  i.trim().substring(0, 2).matches("/\\*") ;
    }

    private  Boolean checkFinishAsteriscComment(String i){


        return  i.trim().substring(0, 2).matches("\\*\\/");
    }
    public LocClass(String fileName) {
        Path path = Paths.get(fileName);
        try (Stream<String> stream = Files.lines(path)) {
            for(String i:stream.collect(Collectors.toList())){
                //System.out.println(loc(i));
//                System.out.println(i.trim());
//                System.out.println(i.length());
//                System.out.println(i.trim().length()==1 );






                if(i.trim().length()==1  ){
//                        System.out.println(i.trim().substring(0, 1));
                         if(checkAsterisc(i) ){
//                             System.out.println(i.trim().substring(0, 1));
//                             System.out.println(i.trim().substring(0, 1).matches("\\*"));
                             //no hace nada, no debe contar
//                             System.out.println("no hace nada length()==1");
                         }
                     }
                    if(i.trim().length()>=2  ){

                        if(checkSlash(i)){
//                            System.out.println(i.trim().substring(0, 2));
//                            System.out.println(i.trim().substring(0, 2).matches("//"));
                            //no hace nada, no debe contar
//                            System.out.println("no hace nada length()==2 ");
                        }
                        else if(checkFinishAsteriscComment(i)){
                            setIsComment(false);
//                            System.out.println(i.trim().substring(0, 2));
//                            System.out.println(i.trim().substring(0, 2).matches("//"));
                            //no hace nada, no debe contar
//                            System.out.println("no hace nada length()==2  asterusc");
                        }
                        else if( checkStartAsteriscComment(i)){
                            setIsComment(true);
//                            System.out.println(getIsComment());
//                             System.out.println(i.trim().substring(0, 3));
//                             System.out.println(i.trim().substring(0, 3).matches("/\\*\\*"));
                            //no hace nada, no debe contar
//                            System.out.println("no hace nada length()>=3 /\\*\\*");
                        }
                        else if( !getIsComment() ){
                            setCont();
//                          System.out.println("ya aumento contador");
                        }
//
                    }
//
                    else if(i.trim().length()==0 ){
//                         System.out.println("no hace nada length()==0");
                    }
                     else {
                         setCont();
//                        System.out.println("ya aumento contador");
                     }




                    stream.close();

//                System.out.println(getCont());
//                System.out.println("------------------------------------------------------------------------------------------------------");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(getCont()+"////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

    }
}
