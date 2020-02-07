/*
 * Author: Tyler Jones
 * Course: CITP 190
 * Project: 
 * Summary: 
 */
package com.tylerjones.seedfindertest;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
//        seed needs to end with L
        long seed = -8119254364297184820L;
        final int MAX_CHUNK_NUM = Integer.MAX_VALUE/16;
        
//        y is first [] each line, x is second [] each sub-element
//        boolean[][] pattern =
//        {
//            {true, true, true, true, true, true, true, true}
//        };
//        
//        int xp = 272;
//        int zp = 272;
//        
//        System.out.println(xp + ",\t" + zp + ",\t" + isSlime(seed, xp, zp));
        
        System.out.println(MAX_CHUNK_NUM);

        for(int i=0; i<MAX_CHUNK_NUM; i++) {
//            System.out.println(i);
        }


//        keep the program open
//        sc.nextLine();
        
    }
    
    public static boolean isSlime(long seed, int xp, int zp) {
        
        Random rnd = new Random(
        seed +
        (int) (xp * xp * 0x4c1906) +
        (int) (xp * 0x5ac0db) + 
        (int) (zp * zp) * 0x4307a7L +
        (int) (zp * 0x5f24f) ^ 0x3ad8025f
        );
        return rnd.nextInt(10) == 0;
        
    }
    
}
