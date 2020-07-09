package com.company;

import dataGenerator.CarGenerator;
import dataGenerator.ClientGenerator;
import human.Client;
import human.Player;
import vechicle.Car;

import java.util.ArrayList;

public class Game {
    public ArrayList<Player> playerList;
    public ArrayList<Car> carsAvailableForPurchase;
    public static ArrayList<Client> potenctalClients;
    public int currentRound;
    public Player winner;

    public Game(ArrayList<String> playerNamesList){
        playerList = new ArrayList<>();
        carsAvailableForPurchase = CarGenerator.getCarStartList();
        potenctalClients = ClientGenerator.getClientsStartList();
        currentRound = 0;

        for (String playerName: playerNamesList
             ) {
            playerList.add(new Player(playerName));
        }

    }

    public void increaseNumberOfPotencialClients(int number){
        for (int i=0; i<number;i++){
            potenctalClients.add(ClientGenerator.generateClient());
        }
    }
}
