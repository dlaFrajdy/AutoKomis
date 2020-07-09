package com.company;

import console.PlayGameWindow;
import console.StartWindow;

public class Main {

    public static void main(String[] args) {

        // Wykonanie jednej udanej transakcji generuje 2 potencjalnych klientów bez dodatkowych wydatków. - przyjąłem, że będzie to zarówno kupno jak i sprzedaż
        // Przyjąłem, że Ogłoszenie w lokalnej gazecie powoduje dopływ losowej grupy kilku nowych klientów, ale kosztuje. 5 / 500;
        // zainwestować w reklamę w internecie, która jest tańsza od gazety, ale przynosi jednego nowego potencjalnego klienta.  300





        // poprawić buyCar w person - chodzi o cenę transakcji
        int a = 100;
        double x = 0.1;
        a *= 1+x;
        System.out.println(a);
       Game game = StartWindow.printMainMenu();
        PlayGameWindow.playRound(game);


    }
}
