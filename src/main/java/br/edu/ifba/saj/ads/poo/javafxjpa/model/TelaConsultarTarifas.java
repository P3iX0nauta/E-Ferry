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

public class TelaConsultarTarifas extends Application {

    private Stage primaryStage;

    public TelaConsultarTarifas() {

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaVerificarStatusFila();
    }

    public void exibirTelaVerificarStatusFila() {
        Label tituloLabel = new Label("Verificar tabela de tarifas");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label descricaoLabel = new Label("Clique no botão abaixo para visualizar a tabela com os valores das tarifas:");
        descricaoLabel.setStyle("-fx-text-fill: white;");

        Button verificarStatusButton = new Button("Verificar Valores");
        verificarStatusButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        verificarStatusButton.setOnAction(e -> {
            voltarParaTelaAnterior();
            String url = "https://www.internacionaltravessias.com.br/tarifas/";
            getHostServices().showDocument(url);
        });

        Button voltarButton = new Button("Voltar");
        voltarButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        voltarButton.setOnAction(e -> voltarParaTelaAnterior());

        VBox layout = new VBox(10);
        layout.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setPadding(new Insets(20));
        layout.setAlignment(javafx.geometry.Pos.CENTER);
        layout.getChildren().addAll(tituloLabel, descricaoLabel, verificarStatusButton, voltarButton);

        StackPane root = new StackPane();
        root.getChildren().add(layout);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Consultar");
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