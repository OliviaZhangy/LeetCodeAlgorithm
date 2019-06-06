package src.Olivia;

//NO 489
//DFS hard

import java.util.HashSet;
import java.util.Set;


public class cleanRoom {

    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();

        public void turnRight();

        // Clean the current cell.
        public void clean();
    }



    public void cleanRoom(Robot robot) {
        Set<String> set = new HashSet<>();
        cleanHelper(robot, set, 0, 0,0);
    }

    int[][] direction = {{1,0}, {0,1}, {-1,0}, {0, -1}};

    private void cleanHelper(Robot robot, Set<String> set, int x, int y, int dir) {
        String cur = x+"-"+y;
        if(set.contains(cur)) return;
        set.add(cur);
        robot.clean();
        //go all for directions
        for(int i=0;i<4;i++){
            if(robot.move()) {
                //go until cannot move more
                int a = x + direction[dir][0];
                int b = y + direction[dir][1];
                cleanHelper(robot,set,a,b,dir);
                //one step back
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            //do to the next direction
            robot.turnRight();
            dir = (dir+1)%4;
        }

    }

}

