package com.novikov.application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Controller
{

    @FXML
    private ComboBox<String> complexityBox;

    @FXML
    private TextField elementsLabel;

    @FXML
    private LineChart<?, ?> graphicChart;

    @FXML
    private Button buildButton;

    public void initialize()
    {
        complexityBox.setItems(FXCollections.observableArrayList("O(1)","O(n)","O(n^2)","O(n^3)","O(Log n)"));
    }

    @FXML
    void buildGraphic(ActionEvent event)
    {

    }

}
