package agh.cs.lab1;

public class RectangularMap extends AbstractWorldMap {
    private int width;
    private int height;
    //List<Car> cars = new ArrayList<>();
    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }
    @Override
    public boolean canMoveTo(Position position){
        if(position.x >=0 && position.x <= this.width && position.y >=0 && position.y <= this.height && !isOccupied(position)) return true;
        return false;
    }
    @Override
    public boolean place(Car car){
        if(isOccupied(car.getPosition()) || !canMoveTo(car.getPosition())) return false;
        else {
            cars.put(car.getPosition(), car);
            return true;
        }

    }
/*
    @Override
    public void run(MoveDirection[] directions) {
        for(int i=0;i<directions.length;i++){
            Car temp = cars.get(i%cars.size());
            temp.move(directions[i]);
            cars.set(i % cars.size(), temp);
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        if(objectAt(position)!=null) return true;
        return false;
    }
*/
    @Override
    public Object objectAt(Position position) {
        return cars.get(position);
    }
    /*@Override
    public void showCars(){
        for(Car o:cars){
            System.out.println(o.getPosition()+o.toString());
        }
    }*/
    @Override
    public String toString(){
        MapVisualizer mapVisualizer = new MapVisualizer();
        return mapVisualizer.dump(this,new Position(0,0),new Position(width,height));
    }

}
