package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.Session;

public class prueba {
   public PlayView playView;
    prueba() {
        this.playView = new PlayView();
    }

 public static void main(String[] args) {
        prueba pruebas = new prueba();
        pruebas.playView.interact(new PlayController(new Session()));
    }
    
}