package esi.atl.g56583.sortingrace.view;

import esi.atl.g56583.sortingrace.model.Quantity;
import esi.atl.g56583.sortingrace.model.Result;
import esi.atl.g56583.sortingrace.model.SortType;
import esi.atl.g56583.sortingrace.model.SortingRace;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalTime;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.MILLIS;

public class FxmlController implements PropertyChangeListener {

    private final ObservableList<Result> tableList = FXCollections.observableArrayList();
    private final XYChart.Series<Number, Number> merge = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> bubble = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> selection = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> insertion = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> quick = new XYChart.Series<>();
    private final IntegerSpinnerValueFactory valueFactory = new IntegerSpinnerValueFactory(1, 10, 1);

    @FXML
    private TableView<Result> table;
    @FXML
    private TableColumn<Result, String> nameCol;
    @FXML
    private TableColumn<Result, Integer> sizeCol;
    @FXML
    private TableColumn<Result, Integer> swapCol;
    @FXML
    private TableColumn<Result, Integer> durationCol;
    @FXML
    private LineChart<Number, Number> chart;
    @FXML
    private Spinner<Integer> threadSpinner;
    @FXML
    private ChoiceBox<String> sortChoice;
    @FXML
    private ChoiceBox<String> configurationChoice;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label leftStatus;
    @FXML
    private Label rightStatus;
    @FXML
    private Button start;

    private LocalTime startTime;
    private double currentProgressBar;

    private void makeChart(XYChart.Series<Number, Number> typeChart, String legendName) {
        typeChart.setName(legendName);
        chart.getData().add(typeChart);
    }

    @FXML
    public void initialize() {
        initChart();
        makeChart();

        // Define the input for choose thread
        threadSpinner.setValueFactory(valueFactory);
        threadSpinner.setEditable(false);

        // Define the list of sort type
        for (var sort : SortType.values()) {
            sortChoice.getItems().add(sort.toString());
        }
        sortChoice.getSelectionModel().selectFirst();

        // Define the list of possible quantity
        for (var quantity : Quantity.values()) {
            configurationChoice.getItems().add(quantity.toString());
        }
        configurationChoice.getSelectionModel().selectFirst();
    }

    private void makeChart() {
        // Define legend and datas for lineChart
        makeChart(bubble, "Tri à bulle");
        makeChart(merge, "Tri fusion");
        makeChart(selection, "Tri selection");
        makeChart(insertion, "Tri insertion");
        makeChart(quick, "Tri rapide");
    }

    private void initChart() {
        // Define the column for lineChart
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        swapCol.setCellValueFactory(new PropertyValueFactory<>("swap"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        table.setItems(tableList);
    }

    @FXML
    void start(ActionEvent event) {
        var quantity = Objects.requireNonNull(Quantity.fromString(configurationChoice.getValue()));
        startTime = LocalTime.now();
        currentProgressBar = 0;
        progressBar.setProgress(currentProgressBar);
        var sortingRace = new SortingRace();
        sortingRace.runSort(threadSpinner.getValue(), quantity.getNbRepeat(), sortChoice.getValue());
        sortingRace.addPropertyChangeListener(this);
    }


    @FXML
    void quit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        Platform.runLater(() -> {
            if (currentProgressBar == 0) {
                start.setDisable(true);
            }
            currentProgressBar += .1;
            progressBar.setProgress(currentProgressBar);

            if (currentProgressBar >= 0.99) {
                currentProgressBar = 1;
                progressBar.setProgress(currentProgressBar);
                start.setDisable(false);
            }

            var sortType = Objects.requireNonNull(SortType.fromString(sortChoice.getValue()));
            long[] givenValues = (long[]) pce.getNewValue();

            XYChart.Series<Number, Number> sort = switch (sortType) {
                case BUBBLE -> bubble;
                case MERGE -> merge;
                case SELECTION -> selection;
                case INSERTION -> insertion;
                default -> quick;
            };
            sort.getData().add(new XYChart.Data<>(givenValues[0], givenValues[1]));

            tableList.add(new Result(sortType,
                    givenValues[0], // size
                    givenValues[1], // swap
                    givenValues[2])); // duration

            leftStatus.setText(Thread.activeCount() + " Threads actifs");
            var sb = new StringBuilder("Dernière exécution | Début : ").append(startTime);
            sb.append(" - Fin : ").append(LocalTime.now());
            sb.append(" | Durée : ").append(MILLIS.between(startTime, LocalTime.now())).append(" ms");
            rightStatus.setText(sb.toString());
        });
    }
}
