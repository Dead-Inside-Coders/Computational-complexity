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
    private LineChart<Long, Long> graphicChart;

    @FXML
    private Button buildButton;

    private Graphic graphic;

    public void initialize()
    {
        complexityBox.setItems(FXCollections.observableArrayList("O(1)","O(n)","O(n^2)","O(n^3)","O(Log n)"));
        graphic = new Graphic();
    }

    @FXML
    void buildGraphic(ActionEvent event)
    {
        long[][] array =  graphic.getGraphic(Integer.parseInt(elementsLabel.getText()),complexityBox.getValue());
        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i <array.length ; i++)
        {
            series.getData().add(new XYChart.Data(array[i][0],array[i][1]));
        }
        graphicChart.getData().add(series);

    }

}
