package com.company;

import console.PlayGameWindow;
import console.StartWindow;

public class Main {

    public static void main(String[] args) {


       Game game = StartWindow.printMainMenu();
        PlayGameWindow.playRound(game);

    }
}
