package com.company;

import dataGenerator.CarGenerator;
import dataGenerator.ClientGenerator;
import human.Client;
import initialGameResources.CarResources;
import vechicle.Car;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<Client> list = new ArrayList<>() {{
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
            add(new ClientGenerator().generateClient());
        }};


        for (Client client : list
        ) {
            System.out.println(client);
        }


    }
}
