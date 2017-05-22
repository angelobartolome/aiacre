package com.angelobartolome;

public class Main {

    public static void main(String[] args) {
        City arad = new City("Arad", 366);
        City zerind = new City("Zerind", 374);
        City oradea = new City("Oradea", 380);
        City sibiu = new City("Sibiu", 253);
        City fagaras = new City("Fagaras", 178);
        City rimnico = new City("Rimnicu Vilcea", 193);
        City pitesti = new City("Pitesti", 98);
        City timisoara = new City("Timisoara", 329);
        City lugoj = new City("Lugoj", 244);
        City mehadia = new City("Mehadia", 241);
        City drobeta = new City("Drobeta", 242);
        City craiova = new City("Craiova", 160);
        City bucharest = new City("Bucharest", 0);
        City giurgiu = new City("Giurgiu", 77);

        arad.setBorders(new Border[]{
                new Border(75, zerind),
                new Border(140, sibiu),
                new Border(118, timisoara)
        });

        zerind.setBorders(new Border[]{
                new Border(75, arad),
                new Border(71, oradea)
        });

        oradea.setBorders(new Border[]{
                new Border(71, zerind),
                new Border(151, sibiu)
        });

        sibiu.setBorders(new Border[]{
                new Border(140, arad),
                new Border(99, fagaras),
                new Border(151, oradea),
                new Border(80, rimnico),
        });

        fagaras.setBorders(new Border[]{
                new Border(99, sibiu),
                new Border(211, bucharest)
        });

        rimnico.setBorders(new Border[]{
                new Border(80, sibiu),
                new Border(97, pitesti),
                new Border(146, craiova)
        });

        pitesti.setBorders(new Border[]{
                new Border(97, rimnico),
                new Border(101, bucharest),
                new Border(138, craiova)
        });

        timisoara.setBorders(new Border[]{
                new Border(118, arad),
                new Border(111, lugoj)
        });

        lugoj.setBorders(new Border[]{
                new Border(111, timisoara),
                new Border(70, mehadia)
        });

        mehadia.setBorders(new Border[]{
                new Border(70, lugoj),
                new Border(75, drobeta)
        });

        drobeta.setBorders(new Border[]{
                new Border(75, mehadia),
                new Border(120, craiova)
        });

        craiova.setBorders(new Border[]{
                new Border(120, drobeta),
                new Border(146, rimnico),
                new Border(138, pitesti)
        });

        bucharest.setBorders(new Border[]{
                new Border(101, pitesti),
                new Border(90, giurgiu),
                new Border(211, fagaras)
        });

        giurgiu.setBorders(new Border[]{
                new Border(90, bucharest)
        });


        Solver s = new Solver(arad, craiova);
        City found = s.solve();
        while (found != null) {
            System.out.print(found.getName() + " <- ");
            found = found.getParent();
        }
    }
}