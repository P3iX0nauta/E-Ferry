package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TelaInicial extends Application {

    private Stage primaryStage;

    public TelaInicial() {}

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        exibirTelaPrincipal();
    }

    public void exibirTelaPrincipal() {
        Image imagem = new Image(getClass().getResource("/br/edu/ifba/saj/ads/poo/javafxjpa/assets/LogoProvisoria.png").toString());
        ImageView imageView = new ImageView(imagem);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);

        Label tituloLabel = new Label("      Bem Vindo ao E-Ferry\n Selecione uma opção abaixo:");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button passageiroButton = new Button("Passageiro");
        passageiroButton.setOnAction(e -> {
            abrirTelaLogin();
            primaryStage.close();
        });
        passageiroButton.setStyle("-fx-font-size: 16px; -fx-min-width: 200px;");


        Button adminButton = new Button("Administrador do sistema");
        adminButton.setOnAction(e -> abrirTelaAdministrador());
        adminButton.setStyle("-fx-font-size: 16px; -fx-min-width: 150px;");


        VBox botoesBox = new VBox(10);
        botoesBox.getChildren().addAll(passageiroButton, adminButton);
        botoesBox.setAlignment(Pos.BOTTOM_CENTER);

        StackPane layoutPrincipal = new StackPane();
        layoutPrincipal.setPadding(new Insets(20));
        layoutPrincipal.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layoutPrincipal.getChildren().addAll(imageView, tituloLabel, botoesBox);
        StackPane.setAlignment(imageView, Pos.TOP_CENTER);
        StackPane.setAlignment(tituloLabel, Pos.CENTER);
        StackPane.setAlignment(botoesBox, Pos.BOTTOM_CENTER);

        Scene scenePrincipal = new Scene(layoutPrincipal, 500, 400);

        primaryStage.setScene(scenePrincipal);
        primaryStage.setTitle("Tela Inicial");
        primaryStage.show();
    }

    private void abrirTelaLogin() {
        TelaLogin telaLogin = new TelaLogin();
        try {
            telaLogin.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void abrirTelaAdministrador() {
        primaryStage.close();
        TelaAdm telaAdm = new TelaAdm();
        try {
            telaAdm.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 }


