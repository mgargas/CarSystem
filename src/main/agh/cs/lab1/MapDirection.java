package agh.cs.lab1;

public enum MapDirection {
    North,
    South,
    West,
    East;
    @Override
    public String toString(){
       switch(this){
           case East:
               return "Wschód";
           case West:
               return "Zachód";
           case North:
               return "Północ";
           case South:
               return "Południe";
           default:
               return null;
       }
    }
    public MapDirection next(){
        switch (this) {
            case North:
                return East;
            case East:
                return South;
            case South:
                return West;
            case West:
                return North;
            default:
                return null;
        }

    }

    public MapDirection previous() {
        switch (this) {
            case North:
                return West;
            case East:
                return North;
            case South:
                return East;
            case West:
                return South;
            default:
                return null;
        }
    }
}
