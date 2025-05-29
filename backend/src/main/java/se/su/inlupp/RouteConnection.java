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
        return String.format("→ %s (%s, vikt: %d)", destination, name, weight);
    }
    
}
