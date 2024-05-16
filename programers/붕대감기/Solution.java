import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int healCount = 0;
        int attackCount = 0;
        int currentHealth = health;
        int holeCount = 1;

        while(currentHealth > 0) {
            if (attackCount >= attacks.length) {
                break;
            }

            if (attacks[attackCount][0] == holeCount) {
                healCount = 0;
                currentHealth -= attacks[attackCount][1];
                attackCount++;
                holeCount++;
                continue;
            }

            if (currentHealth + bandage[1] <= health) {
                currentHealth += bandage[1];
            } else {
                currentHealth = health;
            }

            healCount++;

            if (healCount == bandage[0]) {
                if (currentHealth + bandage[2] <= health) {
                    currentHealth += bandage[2];
                } else {
                    currentHealth = health;
                }
                healCount = 0;
            }

            holeCount++;
        }
        
        if (currentHealth <= 0) {
            return -1;
        }
        
        return currentHealth;
    }
}
