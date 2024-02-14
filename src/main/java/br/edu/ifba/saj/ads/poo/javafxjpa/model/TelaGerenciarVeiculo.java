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

public class TelaGerenciarVeiculo extends Application {

    private Stage primaryStage;

    public TelaGerenciarVeiculo() {

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirGerenciamentoVeiculos();
    }

    public void exibirGerenciamentoVeiculos() {
        Label tituloLabel = new Label("Gerenciamento de Veículos");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

        Button cadastrarVeiculoButton = new Button("Cadastrar Veículo");
        cadastrarVeiculoButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        cadastrarVeiculoButton.setOnAction(e -> {
            TelaCadastrarVeiculo telaCadastrarVeiculo = new TelaCadastrarVeiculo();
            telaCadastrarVeiculo.start(primaryStage);       
         });

        Button listarVeiculosButton = new Button("Listar Veículos");
        listarVeiculosButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        listarVeiculosButton.setOnAction(e -> {
            TelaListaVeiculo telaListaVeiculo = new TelaListaVeiculo();
            telaListaVeiculo.start(primaryStage);               
        });

        Button voltarButton = new Button("Voltar");
        voltarButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        voltarButton.setOnAction(e -> voltarParaTelaAnterior());

        VBox layout = new VBox(10);
        layout.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setPadding(new Insets(20));
        layout.setAlignment(javafx.geometry.Pos.CENTER
        );
        layout.getChildren().addAll(tituloLabel, cadastrarVeiculoButton, listarVeiculosButton, voltarButton);


    StackPane root = new StackPane();
    root.getChildren().add(layout);

    Scene scene = new Scene(root, 500, 300);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Gerenciamento de Veículos");
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