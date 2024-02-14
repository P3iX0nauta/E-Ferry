package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TelaAdm extends Application {

    private Stage primaryStage;

    public TelaAdm() {
    }

    public TelaAdm(Stage stage) {
        this.primaryStage = stage;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        exibirTelaLogin();
    }

    public void exibirTelaLogin() {
        Label tituloLabel = new Label("LOGIN");
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;-fx-text-fill:white");
        Label subtituloLabel = new Label("PARA CONTINUAR FAÇA O LOGIN");
        subtituloLabel.setStyle("-fx-text-fill:white");
        Label matriculaLabel = new Label("Matrícula de Administração");
        matriculaLabel.setStyle("-fx-text-fill:white");
        TextField matriculaTextField = new TextField();
        matriculaTextField.setPromptText("Digite sua matrícula de administração");

        Label senhaLabel = new Label("SENHA");
        senhaLabel.setStyle("-fx-text-fill:white");
        PasswordField senhaTextField = new PasswordField();
        senhaTextField.setPromptText("Digite sua senha");

        Button entrarButton = new Button("ENTRAR");
        entrarButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        entrarButton.setOnAction(e -> {
            String matricula = matriculaTextField.getText();
            String senha = senhaTextField.getText();
            if (autenticarUsuario(matricula, senha)) {
                exibirTelaPrincipal("SeuNome");
            } else {
                exibirErro("Usuário ou senha incorretos.");
            }
        });

        VBox layoutLogin = new VBox(10);
        layoutLogin.setPadding(new Insets(20));
        layoutLogin.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layoutLogin.getChildren().addAll(tituloLabel, subtituloLabel, matriculaLabel, matriculaTextField, senhaLabel, senhaTextField, entrarButton);

        Scene sceneLogin = new Scene(layoutLogin, 500, 300);

        primaryStage.setScene(sceneLogin);
        primaryStage.setTitle("Tela de Login");
        primaryStage.show();
    }

    private void exibirTelaPrincipal(String nomeUsuario) {
        nomeUsuario="Gustavo";
        Label saudacaoLabel = new Label("Olá " + nomeUsuario);
        saudacaoLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");
        Label emBreveLabel = new Label("Em breve...");
        emBreveLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: white;");

        VBox layoutPrincipal = new VBox(20);
        layoutPrincipal.setPadding(new Insets(20));
        layoutPrincipal.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layoutPrincipal.getChildren().addAll(saudacaoLabel, emBreveLabel);

        Scene scenePrincipal = new Scene(layoutPrincipal, 500, 300);
        primaryStage.setScene(scenePrincipal);
        primaryStage.setTitle("Tela Principal");
    }

    private boolean autenticarUsuario(String matricula, String senha) {
        //  autenticação do usuáro, por enquanto, true para permitir qualquer combinação
        return true;
    }

    private void exibirErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

}
