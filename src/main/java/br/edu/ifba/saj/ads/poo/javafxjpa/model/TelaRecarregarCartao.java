package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TelaRecarregarCartao extends Application {

    private Stage primaryStage;

    public TelaRecarregarCartao() {

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaRecargaFerryCard();
    }

    public void exibirTelaRecargaFerryCard() {
        Label tituloLabel = new Label("Recarga do Ferry Card");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label numeroFerryCardLabel = new Label("Número do Ferry Card:");
        numeroFerryCardLabel.setStyle("-fx-text-fill: white;");
        TextField numeroFerryCardTextField = new TextField();

        Label valorRecargaLabel = new Label("Valor da Recarga:");
        valorRecargaLabel.setStyle("-fx-text-fill: white;");
        TextField valorRecargaTextField = new TextField();

        Button recarregarButton = new Button("Recarregar");
        recarregarButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        recarregarButton.setOnAction(e -> {
            String numeroFerryCard = numeroFerryCardTextField.getText();
            String valorRecarga = valorRecargaTextField.getText();
            if (!numeroFerryCard.isEmpty() && !valorRecarga.isEmpty()) {
                // lógica de recarga do ferry card
                exibirAviso("Recarga realizada com sucesso!", Color.GREEN);
                voltarParaTelaAnterior();
            } else {
                exibirAviso("Por favor, preencha todos os campos.", Color.RED);
                voltarParaTelaAnterior();
            }
        });

        Button voltarButton = new Button("Voltar");
        voltarButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        voltarButton.setOnAction(e -> voltarParaTelaAnterior());

        VBox layout = new VBox(10);
        layout.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setPadding(new Insets(20));
        layout.setAlignment(javafx.geometry.Pos.CENTER);
        layout.getChildren().addAll(tituloLabel, numeroFerryCardLabel, numeroFerryCardTextField, valorRecargaLabel, valorRecargaTextField, recarregarButton, voltarButton);

        StackPane root = new StackPane();
        root.getChildren().add(layout);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Recarga do Ferry Card");
        primaryStage.show();
    }

    private void exibirAviso(String mensagem, Color corFundo) {
        Label label = new Label(mensagem);
        label.setStyle("-fx-background-color: " + corFundo.toString().replace("0x", "#") + "; -fx-padding: 10px;");
        Button okButton = new Button("OK");
        okButton.setOnAction(e -> {
            primaryStage.close();
            ((Stage) label.getScene().getWindow()).close();
        });
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(label, okButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        StackPane stackPane = new StackPane(vbox);
        Stage avisoStage = new Stage();
        avisoStage.setScene(new Scene(stackPane, 300, 150));
        avisoStage.setTitle("AVISO");
        avisoStage.showAndWait();
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
