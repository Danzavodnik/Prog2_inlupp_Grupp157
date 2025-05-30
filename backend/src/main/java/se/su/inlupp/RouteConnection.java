package se.su.inlupp;

public class RouteConnection<T> implements Edge<T> {
    private final T destination;
    private final String name;
    private int weight;

    public RouteConnection(T destination, String name, int weight){
        this.destination = destination;
        this.name = name;
        this.weight = weight;
    }

    @Override    
    public int getWeight(){
        return weight;
    }

    @Override    
    public void setWeight(int weight){
        if (weight < 0) {
        throw new IllegalArgumentException("Error: Vikten får inte vara negativ.");
        }
        this.weight = weight;
    }

    @Override
    public T getDestination() {
        return destination;
    }
    
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return "till " + getDestination() + " med " + getName() + " tar " + getWeight();
    }
    
}
