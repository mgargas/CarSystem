package agh.cs.lab1;

public class OptionParser {
    public static MoveDirection[] parse(String[] args){
        int g=0;
        for(int i=0;i<args.length;i++) if(args[i].equals("f") || args[i].equals("forward") || args[i].equals("backward") || args[i].equals("b")
                                            || args[i].equals("right") || args[i].equals("r") || args[i].equals("left") || args[i].equals("l")) g++;
        MoveDirection parsed[]=new MoveDirection[g];
        for(int i=0,j=0;i<args.length;i++){
            switch (args[i]) {
                case "forward":
                    parsed[j] = MoveDirection.Forward;
                    j++;
                    break;
                case "f":
                    parsed[j] = MoveDirection.Forward;
                    j++;
                    break;
                case "backward":
                    parsed[j] = MoveDirection.Backward;
                    j++;
                    break;
                case "b":
                    parsed[j] = MoveDirection.Backward;
                    j++;
                    break;
                case "right":
                    parsed[j] = MoveDirection.Right;
                    j++;
                    break;
                case "r":
                    parsed[j] = MoveDirection.Right;
                    j++;
                    break;
                case "left":
                    parsed[j] = MoveDirection.Left;
                    j++;
                    break;
                case "l":
                    parsed[j] = MoveDirection.Left;
                    j++;
                    break;
                default:
                    throw new IllegalArgumentException(args[i]+" is not legal move specification");

            }
        }

        return parsed;
    }
}
