package br.edu.ifba.saj.ads.poo.javafxjpa;

import br.edu.ifba.saj.ads.poo.javafxjpa.model.TelaInicial;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.start(primaryStage);
    }

}
