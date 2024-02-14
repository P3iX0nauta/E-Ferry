package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TelaComprarPassagemVeiculo extends Application {

    private Stage primaryStage;
    private Stage avisoStage;

    public TelaComprarPassagemVeiculo() {

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaCompraPassagem();
    }

    public void exibirTelaCompraPassagem() {
        Label tituloLabel = new Label("Compra de Passagem");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

        ComboBox<String> escolhaVeiculoComboBox = new ComboBox<>();
        escolhaVeiculoComboBox.getItems().addAll("Veículo 1", "Veículo 2");
        escolhaVeiculoComboBox.setPromptText("Selecione o Veículo");

        ComboBox<String> destinoComboBox = new ComboBox<>();
        destinoComboBox.getItems().addAll("Salvador", "Bom Despacho (Ilha de Itaparica)");
        destinoComboBox.setPromptText("Selecione o destino");

        Spinner<Integer> quantidadePassageirosSpinner = new Spinner<>();
        quantidadePassageirosSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));

        Label quantidadePassageirosLabel = new Label("Quantidade de Passageiros:");
        quantidadePassageirosLabel.setStyle("-fx-text-fill: white;");

        ComboBox<String> horarioComboBox = new ComboBox<>();
        horarioComboBox.getItems().addAll("08:00", "10:00", "12:00", "14:00", "16:00");
        horarioComboBox.setPromptText("Selecione o horário");

        Button comprarButton = new Button("Comprar Passagem");
        comprarButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        comprarButton.setOnAction(e -> {
            String escolhaVeiculo = escolhaVeiculoComboBox.getValue();
            int quantidadePassageiros = quantidadePassageirosSpinner.getValue();
            String destino = destinoComboBox.getValue();
            String horario = horarioComboBox.getValue();
            if (destino != null && horario != null && escolhaVeiculo != null) {
                exibirResumoCompra(destino, horario, quantidadePassageiros);
            } else {
                exibirAviso("Por favor, selecione o veículo, o destino e o horário.", Color.RED);
            }
        });

        Button voltarButton = new Button("Voltar para o Menu");
        voltarButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        voltarButton.setOnAction(e -> voltarParaTelaAnterior());

        VBox layout = new VBox(10);
        layout.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setPadding(new Insets(20));
        layout.setAlignment(javafx.geometry.Pos.CENTER);
        layout.getChildren().addAll(tituloLabel, escolhaVeiculoComboBox, destinoComboBox, horarioComboBox, quantidadePassageirosLabel, quantidadePassageirosSpinner, comprarButton, voltarButton);

        StackPane root = new StackPane();
        root.getChildren().add(layout);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Compra de Passagem");
        primaryStage.show();
    }

    private void exibirResumoCompra(String destino, String horario, int quantidadePassageiros) {
        String mensagem = String.format("Passagem para %s às %s comprada para %d passageiro(s).", destino, horario, quantidadePassageiros);
        exibirAviso(mensagem, Color.GREEN);
    }

    private void exibirAviso(String mensagem, Color corFundo) {
        Label label = new Label(mensagem);
        label.setStyle("-fx-background-color: " + corFundo.toString().replace("0x", "#") + "; -fx-padding: 10px;");
        Button okButton = new Button("OK");
        okButton.setOnAction(e -> {
            ((Stage) label.getScene().getWindow()).close();
            primaryStage.close();
            try {
                new TelaMenuPrincipal(avisoStage).start(new Stage());
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(label, okButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        StackPane stackPane = new StackPane(vbox);
        Stage avisoStage = new Stage();
        avisoStage.setScene(new Scene(stackPane, 500, 200));
        avisoStage.setTitle("AVISO");
        avisoStage.showAndWait();
     }
    

    private void voltarParaTelaAnterior() {
        TelaMenuPrincipal telaMenuPrincipal = new TelaMenuPrincipal(avisoStage);
        try {
            telaMenuPrincipal.start(primaryStage);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
