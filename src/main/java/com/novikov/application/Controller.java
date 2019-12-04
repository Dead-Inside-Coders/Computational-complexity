package com.novikov.application;

import com.novikov.algoritms.time.AlgorithmsWorkTime;
import com.novikov.validation.Validatiton;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

    @FXML
    private Label labelError;

    private AlgorithmsWorkTime algorithmsWorkTime;


    public void initialize()
    {
        complexityBox.setItems(FXCollections.observableArrayList("O(1) - Нахождение среднего элемента массива","O(n) - Линейный поиск","O(n^2) - Сортировка пузырьком","O(n^3) - Умножение матриц","O(Log n) - Бинарный поиск","O(n!) - Задача коммивояжера"));
        algorithmsWorkTime = new AlgorithmsWorkTime();
    }

    @FXML
    void buildGraphic(ActionEvent event)
    {
        graphicChart.getData().clear();
        labelError.setText("");
        try
        {
            if(new Validatiton(complexityBox.getValue(),elementsLabel.getText()).isValid())
            {
                long[][] array = algorithmsWorkTime.buildGraphic(Integer.parseInt(elementsLabel.getText()), complexityBox.getValue());

                XYChart.Series<String, Number> series = new XYChart.Series<>();
                for (long[] longs : array) {
                    series.getData().add(new XYChart.Data<>(String.valueOf(longs[0]), longs[1]));
                }
                graphicChart.getData().add(series);
            }
        }
        catch (Exception ex)
        {
            labelError.setText(ex.getMessage());
        }


    }

}
