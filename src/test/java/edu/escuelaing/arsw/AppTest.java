package edu.escuelaing.arsw;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * The type App test.
 */
public class AppTest
{
    /**
     * Should answer with true.
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    /**
     * Test loc 1.
     * Should answer with .
     */
    @Test
    public void testLoc1(){
        try {
            LocClass loc = new LocClass("C:\\Users\\Acer\\Desktop\\escuela\\inter\\loc-count\\Loc-counting\\src\\main\\java\\edu\\escuelaing\\arsw\\App.java");
            Assert.assertEquals(loc.getCont(),48);
        } catch (IOException e){
            Assert.fail();
        }
    }

    /**
     * Test loc 2.
     */
    @Test
    public void testLoc2(){
        try {
            LocClass loc = new LocClass("C:\\Users\\Acer\\Desktop\\escuela\\inter\\loc-count\\Loc-counting\\src\\main\\java\\edu\\escuelaing\\arsw\\LocClass.java");
            Assert.assertEquals(loc.getCont(),70);
        } catch (IOException e){
            Assert.fail();
        }
    }

    /**
     * Test loc 3.
     */
    @Test
    public void testLoc3(){
        try {
            LocClass loc = new LocClass("C:\\Users\\Acer\\Desktop\\escuela\\inter\\loc-count\\Loc-counting\\src\\main\\java\\edu\\escuelaing\\arsw\\PhyClass.java");
            Assert.assertEquals(loc.getCont(),25);
        } catch (IOException e){
            Assert.fail();
        }
    }

    /**
     * Test phy 4.
     */
    @Test
    public void testPhy4(){
        try {
            PhyClass phy = new PhyClass("C:\\Users\\Acer\\Desktop\\escuela\\inter\\loc-count\\Loc-counting\\src\\main\\java\\edu\\escuelaing\\arsw\\App.java");
            Assert.assertEquals(phy.getCont(),new Long(68));
        } catch (IOException e){
            Assert.fail();
        }
    }

    /**
     * Test phy 5.
     */
    @Test
    public void testPhy5(){
        try {
            PhyClass phy = new PhyClass("C:\\Users\\Acer\\Desktop\\escuela\\inter\\loc-count\\Loc-counting\\src\\main\\java\\edu\\escuelaing\\arsw\\LocClass.java");
            Assert.assertEquals(phy.getCont(),new Long(110));
        } catch (IOException e){
            Assert.fail();
        }
    }

    /**
     * Test loc 6.
     */
    @Test
    public void testPhyc6(){
        try {
            PhyClass phy = new PhyClass("C:\\Users\\Acer\\Desktop\\escuela\\inter\\loc-count\\Loc-counting\\src\\main\\java\\edu\\escuelaing\\arsw\\PhyClass.java");
            Assert.assertEquals(phy.getCont(),new Long(47));
        } catch (IOException e){
            Assert.fail();
        }
    }
}
