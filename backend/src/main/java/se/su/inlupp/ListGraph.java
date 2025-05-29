package se.su.inlupp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class ListGraph<T> implements Graph<T> {
  
  private final Map<T, List<Edge<T>>> adjacencyList = new HashMap<>();

  
  @Override
  public void add(T node) {
    adjacencyList.putIfAbsent(node, new ArrayList<>());
  }

  @Override
  public void connect(T node1, T node2, String name, int weight) {
    if(!adjacencyList.containsKey(node1) || !adjacencyList.containsKey(node2)){
      throw new NoSuchElementException("Error: Någon eller båda noderna är inte i grafen");
    }
    if(weight<0){
      throw new IllegalArgumentException("Error: Vikt får inte ha negativt värde");
    }
    for(Edge<T> edge : adjacencyList.get(node1)){
      if(edge.getDestination().equals(node2)){
        throw new IllegalStateException("Error: Förbinelse mellan en eller flera noder finns redan");
      }
    }

    Edge<T> edge1 = new RouteConnection<>(node2, name, weight);
    Edge<T> edge2 = new RouteConnection<>(node1, name, weight);
    
    adjacencyList.get(node1).add(edge1);
    adjacencyList.get(node2).add(edge2);
  

  }

  @Override
  public void setConnectionWeight(T node1, T node2, int weight) {
    throw new UnsupportedOperationException("Unimplemented method 'setConnectionWeight'");
  }

  @Override
  public Set<T> getNodes() {
    throw new UnsupportedOperationException("Unimplemented method 'getNodes'");
  }

  @Override
  public Collection<Edge<T>> getEdgesFrom(T node) {
    throw new UnsupportedOperationException("Unimplemented method 'getEdgesFrom'");
  }

  @Override
  public Edge<T> getEdgeBetween(T node1, T node2) {
    throw new UnsupportedOperationException("Unimplemented method 'getEdgeBetween'");
  }

  @Override
  public void disconnect(T node1, T node2) {
    throw new UnsupportedOperationException("Unimplemented method 'disconnect'");
  }

  @Override //sdad
  public void remove(T node) {
    if(!adjacencyList.containsKey(node)){
      throw new NoSuchElementException("Error: Noden saknas i grafen");
    }

    for(T other : adjacencyList.keySet()){
      if(!other.equals(node)){
        adjacencyList.get(other).removeIf(edge -> edge.getDestination().equals(node));
      }
    }
    adjacencyList.remove(node);
  }

  @Override
  public boolean pathExists(T from, T to) {
    throw new UnsupportedOperationException("Unimplemented method 'pathExists'");
  }

  @Override
  public List<Edge<T>> getPath(T from, T to) {
    throw new UnsupportedOperationException("Unimplemented method 'getPath'");
  }
}
