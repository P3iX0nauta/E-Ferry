package br.edu.ifba.saj.ads.poo.javafxjpa.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TelaMenuPrincipal extends Application {

    private Stage primaryStage;
    private String nomeUsuario;

    public TelaMenuPrincipal(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.nomeUsuario = "Gustavo"; // nome de usuario
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        exibirTelaPrincipal();
    }

    public void exibirTelaPrincipal() {
        Label tituloLabel = new Label("OLÁ, " + nomeUsuario.toUpperCase());
        tituloLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;-fx-text-fill: white;");
        Label subtituloLabel = new Label("O QUE VOCÊ DESEJA?");
        subtituloLabel.setStyle("-fx-text-fill: white;");
        
        Button ComprarPassagemButton = new Button("COMPRAR PASSAGEM");
        ComprarPassagemButton.setOnAction(e -> abrirTelaComprarPassagem());
        ComprarPassagemButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        
        Button RecarregarCartaoButton = new Button("Recarregar Cartão FerryCard");
        RecarregarCartaoButton.setOnAction(e -> abrirTelaRecarregarCarta());
        RecarregarCartaoButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        
        Button CadastrarVeiculoButton = new Button("Gerenciar Veículos");
        CadastrarVeiculoButton.setOnAction(e -> abrirGerenciarVeiculo());
        CadastrarVeiculoButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        
        Button VerificarStatusButton = new Button("Visualizar Status da Fila");
        VerificarStatusButton.setOnAction(e -> abrirTelaVisualizarStatus());
        VerificarStatusButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        
        Button VisualizarHistorico = new Button("Visualizar Histórico de Compras e Recargas");
        VisualizarHistorico.setOnAction(e -> abrirTelaHistoricoCompras());
        VisualizarHistorico.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        Button ConsultarTarifas = new Button("Consultar Valor das Tarifas");
        ConsultarTarifas.setOnAction(e -> abrirConsultarTarifas());
        ConsultarTarifas.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        
        Button sairButton = new Button("SAIR");
        sairButton.setOnAction(e -> encerrarPrograma());
        sairButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        VBox layoutPrincipal = new VBox(20);
        layoutPrincipal.setPadding(new Insets(20));
        layoutPrincipal.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layoutPrincipal.getChildren().addAll(tituloLabel, subtituloLabel, ComprarPassagemButton,
                                               RecarregarCartaoButton, CadastrarVeiculoButton,
                                               VerificarStatusButton, VisualizarHistorico,ConsultarTarifas,
                                               sairButton);
        layoutPrincipal.setAlignment(Pos.CENTER);

        Scene scenePrincipal = new Scene(layoutPrincipal, 500, 400);

        primaryStage.setScene(scenePrincipal);
        primaryStage.setTitle("Tela Principal");
        primaryStage.show();
    }

    private void abrirConsultarTarifas() {
        TelaConsultarTarifas telaConsultarTarifas = new TelaConsultarTarifas();
        telaConsultarTarifas.start(primaryStage);
    }
    private void abrirTelaComprarPassagem() {
        TelaComprarPassagem telaComprarPassagem = new TelaComprarPassagem();
       telaComprarPassagem.start(primaryStage);
    }
    
    private void abrirTelaRecarregarCarta() {
        primaryStage.close();
        TelaRecarregarCartao telaRecarregarCartao = new TelaRecarregarCartao();
         telaRecarregarCartao.start(new Stage());
    }
    private void abrirGerenciarVeiculo() {
        primaryStage.close();
       TelaGerenciarVeiculo telaGerenciarVeiculo = new TelaGerenciarVeiculo();
       telaGerenciarVeiculo.start(new Stage());
    }
    private void abrirTelaVisualizarStatus() {
        TelaVisualizarStatus telaVisualizarStatus = new TelaVisualizarStatus();
        telaVisualizarStatus.start(primaryStage);
    }
    
    private void abrirTelaHistoricoCompras() {
        primaryStage.close();
      TelaHistoricoCompras telaHistoricoCompras = new TelaHistoricoCompras();
       Stage stage = new Stage();
       telaHistoricoCompras.start(stage);
    }
    

    private void encerrarPrograma() {
        primaryStage.close();
    }
    
}