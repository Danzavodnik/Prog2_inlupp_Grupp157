package se.su.inlupp;

public class TestClass {
    public static void main(String[] args) {
        ListGraph<String> graph = new ListGraph<>();

        System.out.println("🧪 Testar add...");
        try {
            graph.add("A");
            graph.add("B");
            graph.add("C");
            graph.add("A"); // ska inte krascha
            System.out.println("✅ add genomfördes utan fel");
        } catch (Exception e) {
            System.out.println("❌ add misslyckades: " + e.getMessage());
        }

        System.out.println("\n🧪 Testar connect...");
        try {
            graph.connect("A", "B", "väg1", 5);
            graph.connect("B", "C", "väg2", 10);
            System.out.println("✅ connect genomfördes utan fel");
        } catch (Exception e) {
            System.out.println("❌ connect misslyckades: " + e.getMessage());
        }

        System.out.println("\n🧪 Testar undantag vid connect (vikt < 0)...");
        try {
            graph.connect("A", "C", "väg3", -1);
            System.out.println("❌ connect tillät negativ vikt – fel!");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ IllegalArgumentException korrekt kastad");
        }

        System.out.println("\n🧪 Testar undantag vid connect (noder saknas)...");
        try {
            graph.connect("A", "X", "väg4", 1);
            System.out.println("❌ connect tillät okänd nod – fel!");
        } catch (java.util.NoSuchElementException e) {
            System.out.println("✅ NoSuchElementException korrekt kastad");
        }

        System.out.println("\n🧪 Testar remove...");
        try {
            graph.remove("B");
            System.out.println("✅ remove genomfördes utan fel");
        } catch (Exception e) {
            System.out.println("❌ remove misslyckades: " + e.getMessage());
        }

        System.out.println("\n🧪 Testar undantag vid remove (nod saknas)...");
        try {
            graph.remove("X");
            System.out.println("❌ remove tillät borttagning av okänd nod – fel!");
        } catch (java.util.NoSuchElementException e) {
            System.out.println("✅ NoSuchElementException korrekt kastad");
        }
        
        
        
        
        
        //-----------------utökad testklass-------------------------- 
        // ListGraph<String> graph = new ListGraph<>();

        // System.out.println("✅ Testar add...");
        // graph.add("Stockholm");
        // graph.add("Uppsala");
        // graph.add("Stockholm"); // bör inte orsaka förändring

        // System.out.println("Noder efter add: " + graph.getNodes());

        // System.out.println("\n✅ Testar connect...");
        // try {
        //     graph.connect("Stockholm", "Uppsala", "E4", 70);
        // } catch (Exception e) {
        //     System.out.println("❌ connect misslyckades: " + e.getMessage());
        // }

        // // Försök lägga till en redan existerande förbindelse
        // try {
        //     graph.connect("Stockholm", "Uppsala", "E4", 70);
        //     System.out.println("❌ Dubbel förbindelse tillåten – fel!");
        // } catch (IllegalStateException e) {
        //     System.out.println("✅ IllegalStateException korrekt kastad för dubbel förbindelse.");
        // }

        // System.out.println("Kanter från Stockholm: " + graph.getEdgesFrom("Stockholm"));

        // System.out.println("\n✅ Testar remove...");
        // graph.remove("Uppsala");

        // System.out.println("Noder efter borttagning: " + graph.getNodes());

        // try {
        //     graph.getEdgesFrom("Stockholm").forEach(System.out::println);
        // } catch (Exception e) {
        //     System.out.println("✅ Korrekt: inga kanter från Stockholm efter att Uppsala togs bort.");
        // }

        // // Försök ta bort en nod som inte finns
        // try {
        //     graph.remove("Göteborg");
        //     System.out.println("❌ Tog bort icke-existerande nod – fel!");
        // } catch (java.util.NoSuchElementException e) {
        //     System.out.println("✅ NoSuchElementException korrekt kastad för borttagning av okänd nod.");
        // }
    }
}
