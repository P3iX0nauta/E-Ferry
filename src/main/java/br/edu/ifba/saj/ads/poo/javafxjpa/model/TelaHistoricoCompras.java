package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TelaHistoricoCompras extends Application {

    private Stage primaryStage;

    public TelaHistoricoCompras() {

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaHistoricoCompras();
    }

    public void exibirTelaHistoricoCompras() {
        Label tituloLabel = new Label("Histórico de Compras");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label descricaoLabel = new Label("Seu histórico de compras estará disponível em breve.");
        descricaoLabel.setStyle("-fx-text-fill: white;");

        Button voltarButton = new Button("Voltar");
        voltarButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        voltarButton.setOnAction(e -> voltarParaTelaAnterior());

        VBox layout = new VBox(10);
        layout.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setPadding(new Insets(20));
        layout.setAlignment(javafx.geometry.Pos.CENTER);
        layout.getChildren().addAll(tituloLabel, descricaoLabel, voltarButton);

        StackPane root = new StackPane();
        root.getChildren().add(layout);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Histórico de Compras");
        primaryStage.show();
    }

    private void voltarParaTelaAnterior() {
        primaryStage.close();
        try {
            new TelaMenuPrincipal(primaryStage).start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
