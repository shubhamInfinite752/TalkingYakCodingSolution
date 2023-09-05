import java.util.*;

public class RobotMover {
        public String callRobot(String input) {
            String [] split = input.split("\n");
            String [] dimesnsions = split[0].split(" ");
            String [] roboPos = split[1].split(" ");
            String instructions = split[2];

            int m = Integer.parseInt(dimesnsions[0]);
            int n =  Integer.parseInt(dimesnsions[1]);

            int roboX = Integer.parseInt(roboPos[0]);
            int roboY = Integer.parseInt(roboPos[1]);
            String dir = roboPos[2];
            
            List<String> dirArr = Arrays.asList(new String[]{"N", "E", "S", "W"});
            int indDir = dirArr.indexOf(dir);


            for(int i = 0;i < instructions.length(); i++) {
                char ch = instructions.charAt(i);
                if(ch == 'L') {
                    indDir = (indDir + 3)%4;
                } else if(ch == 'R') {
                    indDir = (indDir + 1)%4;
                } else {
                    int move [][]= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                    int newX = roboX + move[indDir][0];
                    int newY = roboY + move[indDir][1];
                    if(isValid(newX, newY, m, n)) {
                        roboX = newX;
                        roboY = newY;
                    }
                }
            }
            return roboX + " " + roboY +  " " + dirArr.get(indDir);
        }
        public boolean isValid(int x, int y, int m, int n) {
            return x >= 0 && y >= 0 && x <= m && y <= n;
        }


    public static void main(String[] args){
        RobotMover robotMover = new RobotMover();
        System.out.println(robotMover.callRobot("5 5" + "\n"  + "1 2 N" + "\n" + "LMLMLMLMM"));
        System.out.println(robotMover.callRobot("5 5" + "\n"  +  "3 3 E" + "\n"  + "MMRMMRMRRM"));
    }
}
