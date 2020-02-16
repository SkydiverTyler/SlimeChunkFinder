/*
 * Author: Tyler Jones
 * Date: Feb. 7, 2020
 * Project: Slime Chunk Finder
 * Summary: A tool to find Minecraft Slime Chunks
 */
package com.tylerjones.slimechunks;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
            
//    seed needs to end with L
    static long SEED = -8119254364297184820L;
    static final int MAX_CHUNK_NUM = 1874998;
    static Scanner sc = new Scanner(System.in);
    
    
    
    public static void main(String[] args) {      
                
//        y is first [], each line,
//        while x is second [], each sub-element
        boolean[][] pattern =
        {
            {true},
            {true},
            {true}
        };
        
        int xPos = 0;
        int zPos = 0;
        
        int dirX = -1;
        int dirZ = -1;
        
        for (int count=1; count < MAX_CHUNK_NUM*2; count++) {
            
            for (int cZ = count; cZ > 0; cZ--) {
                
                checkPattern(pattern, xPos, zPos);
                zPos += dirZ;
            }
            
            dirZ *= -1;
            
            for (int cX = count; cX > 0; cX--) {
                
                checkPattern(pattern, xPos, zPos);
                xPos += dirX;
            }
            
            dirX *= -1;          
            
        }
    }   
    
    
    
    
    public static boolean checkPattern(boolean[][] pattern, int xp, int zp) {
                
//        xp is initial x position
//        zp is initial z position
        for (int z = zp; z < Array.getLength(pattern) + zp; z++) {
            
            for (int x = xp; x < Array.getLength( pattern[z-zp] ) + xp; x++) {
                                
                if (pattern[z-zp][x-xp] != isSlime(x,z)) {
                    
                    System.out.println(xp + ", " + zp + " does not match");
                    return false;
                }                
            }            
        }
        
        System.out.println("\nPATTERN MATCH!!"
                + "\n\tStarting at coords [" + xp*16 + ", " + zp*16 + "]"
                + "\n\tor chunk [" + xp + ", " + zp + "]");    
        
        sc.nextLine();
        return true;
        
    }
    
    
    
    
    public static boolean isSlime(int xp, int zp) {
        
        Random rnd = new Random(
        SEED +
        (int) (xp * xp * 0x4c1906) +
        (int) (xp * 0x5ac0db) + 
        (int) (zp * zp) * 0x4307a7L +
        (int) (zp * 0x5f24f) ^ 0x3ad8025f
        );
        return rnd.nextInt(10) == 0;
        
    }        
    
    
}