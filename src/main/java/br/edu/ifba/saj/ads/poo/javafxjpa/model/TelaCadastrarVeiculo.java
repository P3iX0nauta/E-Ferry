package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TelaCadastrarVeiculo extends Application {

    private Stage primaryStage;

    public TelaCadastrarVeiculo() {

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaCadastroVeiculo();
    }

    public void exibirTelaCadastroVeiculo() {
        Label tituloLabel = new Label("Cadastro de Veículo");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label placaLabel = new Label("Placa:");
        placaLabel.setStyle("-fx-text-fill: white;");
        TextField placaField = new TextField();
        placaField.setPromptText("Digite aqui sua placa");

        Label renavamLabel = new Label("Renavam:");
        renavamLabel.setStyle("-fx-text-fill: white;");
        TextField renavamField = new TextField();
        renavamField.setPromptText("Digite aqui o número do Renavam");

        Label cpfProprietarioLabel = new Label("CPF do Proprietário:");
        cpfProprietarioLabel.setStyle("-fx-text-fill: white;");
        TextField cpfProprietarioField = new TextField();
        cpfProprietarioField.setPromptText("Digite aqui o CPF do proprietário");

        Label categoriaLabel = new Label("Categoria:");
        categoriaLabel.setStyle("-fx-text-fill: white;");
            ComboBox<String>
        categoriaComboBox = new ComboBox<>();
        categoriaComboBox.getItems().addAll(
    "Bicicleta",
        "Ciclomotor",
        "Motoneta",
        "Motocicleta",
        "Triciclo",
        "Quadriciclo",
        "Automóvel",
        "Microônibus",
        "Ônibus",
        "Reboque ou semi-reboque",
        "Caminhonete",
        "Caminhão",
        "Carro-de-mão",
        "Camioneta",
        "Utilitário",
        "Caminhão-trator",
        "Especial"
        );  
    categoriaComboBox.setPromptText("Selecione a categoria");


    Button cadastrarButton = new Button("Cadastrar");
    cadastrarButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
    cadastrarButton.setOnAction(e -> {
        if (placaField.getText().isEmpty() || renavamField.getText().isEmpty() || cpfProprietarioField.getText().isEmpty() || categoriaComboBox.getValue() == null) {
            exibirAviso("Todos os campos devem ser preenchidos!", Color.RED);
        } else {
            // lógica para cadastrar o veículo, por enquanto, exibir uma mensagem de sucesso
            exibirAviso("Veículo cadastrado com sucesso!", Color.GREEN);
            voltarParaTelaAnterior();
         }
     });

     Button voltarButton = new Button("Voltar para o Menu");
     voltarButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
     voltarButton.setOnAction(e -> voltarParaTelaAnterior());

     VBox layout = new VBox(10);
     layout.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
     layout.setPadding(new Insets(20));
     layout.setAlignment(javafx.geometry.Pos.CENTER);
     layout.getChildren().addAll(tituloLabel, placaLabel, placaField, renavamLabel, renavamField,
            cpfProprietarioLabel, cpfProprietarioField, categoriaLabel, categoriaComboBox, cadastrarButton,
            voltarButton);

     StackPane root = new StackPane();
        root.getChildren().add(layout);

     Scene scene = new Scene(root, 500, 500);
     primaryStage.setScene(scene);
     primaryStage.setTitle("Cadastro de Veículo");
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

    private void exibirAviso(String mensagem, Color corFundo) {
        Label label = new Label(mensagem);
        label.setStyle("-fx-background-color: " + corFundo.toString().replace("0x", "#") + "; -fx-padding: 10px;");
        Button okButton = new Button("OK");
        okButton.setOnAction(e -> ((Stage) label.getScene().getWindow()).close());
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(label, okButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        StackPane stackPane = new StackPane(vbox);
        Stage avisoStage = new Stage();
        avisoStage.setScene(new Scene(stackPane, 300, 200));
        avisoStage.setTitle("AVISO");
        avisoStage.showAndWait();
    }

}