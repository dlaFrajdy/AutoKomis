package com.company;

import console.StartWindow;
import dataGenerator.CarGenerator;
import dataGenerator.ClientGenerator;
import human.Client;
import human.Player;
import vechicle.Car;

import java.util.ArrayList;

public class Game {
    public ArrayList<Player> playerList;
    public ArrayList<Car> carsAvailableForPurchase;
    public ArrayList<Client> potencialClients;
    public int currentRound;
    public Player winner;

    public Game(ArrayList<String> playerNamesList){
        playerList = new ArrayList<>();
        carsAvailableForPurchase = CarGenerator.getCarStartList();
        potencialClients = ClientGenerator.getClientsStartList();
        currentRound = 0;

        for (String playerName: playerNamesList
             ) {
            playerList.add(new Player(playerName));
        }

    }

    public void increaseNumberOfPotencialClients(int number){
        for (int i=0; i<number;i++){
            potencialClients.add(ClientGenerator.generateClient());
        }
    }
}
