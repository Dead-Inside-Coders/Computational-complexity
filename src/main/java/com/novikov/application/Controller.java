package com.novikov.application;

import com.novikov.graphical.Graphic;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
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
    private LineChart<String, Number> graphicChart;

    @FXML
    private Button buildButton;

    private Graphic graphic;

    public void initialize()
    {
        complexityBox.setItems(FXCollections.observableArrayList("O(1)","O(n)","O(n^2)","O(n^3)","O(Log n)","O(n!)"));
        graphic = new Graphic();
    }

    @FXML
    void buildGraphic(ActionEvent event)
    {
        graphicChart.getData().clear();
        long[][] array =  graphic.getGraphic(Integer.parseInt(elementsLabel.getText()),complexityBox.getValue());
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (long[] longs : array)
        {
            series.getData().add(new XYChart.Data<>(String.valueOf(longs[0]), longs[1]));
        }
        graphicChart.getData().add(series);

    }

}
