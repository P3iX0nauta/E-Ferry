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

public class TelaListaVeiculo extends Application {

    private Stage primaryStage;

    public TelaListaVeiculo() {

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirListaVeiculos();
    }

    public void exibirListaVeiculos() {
        Label tituloLabel = new Label("Lista de Veículos");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

        // Veículo 1
        Label veiculo1Label = new Label("Veículo 1:");
        veiculo1Label.setStyle("-fx-text-fill: white;");
        Label veiculo1TipoLabel = new Label("Tipo: Automóvel");
        veiculo1TipoLabel.setStyle("-fx-text-fill: white;");
        Label veiculo1PlacaLabel = new Label("Placa: ABC-1234");
        veiculo1PlacaLabel.setStyle("-fx-text-fill: white;");
        Label veiculo1RenavamLabel = new Label("Renavam: 123456789");
        veiculo1RenavamLabel.setStyle("-fx-text-fill: white;");
        Button removerVeiculo1Button = new Button("Remover");
        removerVeiculo1Button.setOnAction(e -> {
            // Lógica para remover veículo 1
        });

        // Veículo 2
        Label veiculo2Label = new Label("Veículo 2:");
        veiculo2Label.setStyle("-fx-text-fill: white;");
        Label veiculo2TipoLabel = new Label("Tipo: Motocicleta");
        veiculo2TipoLabel.setStyle("-fx-text-fill: white;");
        Label veiculo2PlacaLabel = new Label("Placa: DEF-5678");
        veiculo2PlacaLabel.setStyle("-fx-text-fill: white;");
        Label veiculo2RenavamLabel = new Label("Renavam: 987654321");
        veiculo2RenavamLabel.setStyle("-fx-text-fill: white;");
        Button removerVeiculo2Button = new Button("Remover");
        removerVeiculo2Button.setOnAction(e -> {
            // Lógica para remover veículo 2
        });

        Button voltarButton = new Button("Voltar");
        voltarButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        voltarButton.setOnAction(e -> voltarParaTelaAnterior());

        VBox layout = new VBox(10);
        layout.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setPadding(new Insets(20));
        layout.setAlignment(javafx.geometry.Pos.CENTER);
        layout.getChildren().addAll(tituloLabel,
                criarVeiculoLayout(veiculo1Label, veiculo1TipoLabel, veiculo1PlacaLabel, veiculo1RenavamLabel, removerVeiculo1Button),
                criarVeiculoLayout(veiculo2Label, veiculo2TipoLabel, veiculo2PlacaLabel, veiculo2RenavamLabel, removerVeiculo2Button),
                voltarButton);

        StackPane root = new StackPane();
        root.getChildren().add(layout);

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lista de Veículos");
        primaryStage.show();
    }

    private VBox criarVeiculoLayout(Label label, Label tipoLabel, Label placaLabel, Label renavamLabel, Button removerButton) {
        VBox veiculoLayout = new VBox(5);
        veiculoLayout.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px;");
        veiculoLayout.getChildren().addAll(label, tipoLabel, placaLabel, renavamLabel, removerButton);
        return veiculoLayout;
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
