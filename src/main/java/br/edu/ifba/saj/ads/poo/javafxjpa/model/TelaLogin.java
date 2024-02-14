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

public class TelaLogin extends Application {

    private Stage primaryStage;

    public TelaLogin() {
    }

    public TelaLogin(Stage stage) {
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
        Label CPFLabel = new Label("CPF");
        CPFLabel.setStyle("-fx-text-fill:white");
        TextField CPFTextField = new TextField();
        CPFTextField.setPromptText("Digite seu CPF");
        Label senhaLabel = new Label("SENHA");
        senhaLabel.setStyle("-fx-text-fill:white");
        PasswordField senhaTextField = new PasswordField();
        senhaTextField.setPromptText("Digite sua senha");

        Button entrarButton = new Button("ENTRAR");
        entrarButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        entrarButton.setOnAction(e -> {
            String CPF = CPFTextField.getText();
            String senha = senhaTextField.getText();
            if (autenticarUsuario(CPF, senha)) {
                abrirTelaPrincipal();
            } else {
                exibirErro("Usuário ou senha incorretos.");
            }
        });

        Button esqueciSenhaButton = new Button("ESQUECI MINHA SENHA");
        esqueciSenhaButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        Button criarContaButton = new Button("NÃO TEM UMA CONTA ?\nCLIQUE AQUI PARA CRIAR SUA CONTA");
        criarContaButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        Button voltarButton = new Button("Voltar");
        voltarButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        voltarButton.setOnAction(e -> voltarParaTelaAnterior());

        esqueciSenhaButton.setOnAction(e -> exibirTelaEsqueciSenha());
        criarContaButton.setOnAction(e -> exibirTelaCadastro());

        VBox layoutLogin = new VBox(10);
        layoutLogin.setPadding(new Insets(20));
        layoutLogin.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layoutLogin.getChildren().addAll(tituloLabel, subtituloLabel, CPFLabel, CPFTextField, senhaLabel, senhaTextField, entrarButton, esqueciSenhaButton, criarContaButton, voltarButton);

        Scene sceneLogin = new Scene(layoutLogin, 500, 400);

        primaryStage.setScene(sceneLogin);
        primaryStage.setTitle("Tela de Login");
        primaryStage.show();
    }

    private void abrirTelaPrincipal() {
        TelaMenuPrincipal telaPrincipal = new TelaMenuPrincipal(primaryStage);
        try {
            telaPrincipal.start(primaryStage);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private boolean autenticarUsuario(String CPF, String senha) {
        // autenticar o usuário no banco de dados
        return true;
    }

    private void exibirTelaCadastro() {
        TelaCadastro telaCadastro = new TelaCadastro(primaryStage);
        telaCadastro.exibirTelaCadastro();
    }

    private void exibirTelaEsqueciSenha() {
        TelaEsqueciSenha telaEsqueciSenha = new TelaEsqueciSenha(primaryStage);
        telaEsqueciSenha.exibirTelaEsqueciSenha();
    }

    private void voltarParaTelaAnterior() {
        TelaInicial telaInicial = new TelaInicial();
        Stage stage = new Stage(); 
        try {
            telaInicial.start(stage);
            primaryStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void exibirErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

}