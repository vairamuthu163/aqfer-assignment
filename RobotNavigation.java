import java.util.*;

public class RobotNavigation {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java Robot <source> <target>");
      System.out.println("Example: java Robot 0,0,N 2,3,S");
      return;
    }
    String[] source = args[0].split(",");
    String[] target = args[1].split(",");
    int srcX = Integer.parseInt(source[0]);
    int srcY = Integer.parseInt(source[1]);
    char srcDir = source[2].charAt(0);
    int destX = Integer.parseInt(target[0]);
    int destY = Integer.parseInt(target[1]);
    char destDir = target[2].charAt(0);
    int numSteps = 0;
    int numMoves = 0;
    int numTurns = 0;
    while (srcX != destX || srcY != destY || srcDir != destDir) {
      if (srcX != destX || srcY != destY) {
        int dx = destX - srcX;
        int dy = destY - srcY;
        if (Math.abs(dx) >= Math.abs(dy)) {
          if (dx > 0) {
            srcDir = 'E';
            srcX++;
          } else {
            srcDir = 'W';
            srcX--;
          }
        } else {
          if (dy > 0) {
            srcDir = 'N';
            srcY++;
          } else {
            srcDir = 'S';
            srcY--;
          }
        }
        numSteps++;
        numMoves++;
        System.out.println("Move Forward: " + srcX + " " + srcY + " " + srcDir);
      } else {
        if (srcDir == 'N') {
          if (destDir == 'E') {
            srcDir = 'E';
          } else if (destDir == 'S') {
            srcDir = 'W';
          } else if (destDir == 'W') {
            srcDir = 'W';
          }
        } else if (srcDir == 'E') {
          if (destDir == 'N') {
            srcDir = 'N';
          } else if (destDir == 'S') {
            srcDir = 'S';
          } else if (destDir == 'W') {
            srcDir = 'N';
          }
        } else if (srcDir == 'S') {
          if (destDir == 'N') {
            srcDir = 'N';
          } else if (destDir == 'E') {
            srcDir = 'E';
          } else if (destDir == 'W') {
            srcDir = 'E';
          }
        } else if (srcDir == 'W') {
          if (destDir == 'N') {
            srcDir = 'E';
          } else if (destDir == 'E') {
            srcDir = 'S';
          } else if (destDir == 'S') {
            srcDir = 'S';
          }
        }
        numSteps++;
        numTurns++;
        System.out.println("Turn Left: " + srcX + " " + srcY + " " + srcDir);
      }
    }
    System.out.println("No of Moves = "+numMoves+"\nNo of turns ="+numTurns+" \nTotal no fo steps ="+numSteps);
  }
}

