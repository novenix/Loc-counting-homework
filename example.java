package edu.escuelaing.arsw;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type App.
 */
public class App
{
    private static Hashtable<String, Boolean> comentarios = new Hashtable<>();
    private Integer cont =0;
    private int getCont (){
        return cont;
    }
    private int setCont (){
        return cont += 1;
    }
    private static Boolean loc(String line){
        char[] charArray = line.toCharArray();
        Boolean haveComment =false ;
        String previusChar = null;
        for (char c : charArray) {
            System.out.println("c = " + c+"comentaris get" +comentarios.get(c));
            try  {
                System.out.println(" previusChar == Character.toString(c) " +  previusChar +"=="+ Character.toString(c));
                System.out.println(previusChar != null );
                System.out.println("&&" );
                System.out.println(previusChar.equals(Character.toString(c)) );
                //chck if coment starts with "//"
                if (previusChar != null && previusChar.equals(Character.toString(c)) && previusChar.equals("/") ) {
                    System.out.println("ejtra condicion " );
                    System.out.println(comentarios.get( previusChar + c) );
                    if (comentarios.get( previusChar + c)) {
                        haveComment = true;
                        System.out.println("haveComment true" );
                        break;
                        //System.out.println("c = " + c);
                    }
                }
                //check if comment starts with //chck if coment starts with "//"
                if (previusChar != null && && previusChar.equals(Character.toString(c)) && previusChar.equals("*")) {
                    System.out.println("ejtra condicion " );
                    System.out.println(comentarios.get( previusChar + c) );
                    if (comentarios.get( previusChar + c)) {
                        haveComment = true;
                        System.out.println("haveComment true" );
                        break;
                        //System.out.println("c = " + c);
                    }
                }
            }
            catch ( NullPointerException nullPointerException){
                //no hace nada
                //System.out.println("c nada = " + c);
            }
            previusChar = Character.toString(c);
        }

        return  haveComment;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main( String[] args )
    {
        //comentarios.put("\n", true);
        //comentarios.put("\r\n", true);
        //comentarios.put("\r", true);
        comentarios.put("//", true);
        comentarios.put("/**", true);
        comentarios.put("*", true);
        comentarios.put("*/", true);
        String typeOfCount = args [0];
        String fileName = args [1];
        Path path = Paths.get(fileName);
        System.out.println( "typeOfCount: " + typeOfCount );
        System.out.println( "fileName: " + fileName );
        try (Stream<String> stream = Files.lines(path)) {
            for(String i:stream.collect(Collectors.toList())){
                if(!loc(i)) {
                    System.out.println(loc(i));
                    setCont();
                    System.out.println(getCont()+"GET CONNTTT");
                }
                System.out.println(i);
                System.out.println("------------------------------------------------------------------------------------------------------");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //comentarios.put("\r", true);
        System.out.println(getCont()+"-------------------------");
    }
}
/**
 * Hello world!
 *
 */



