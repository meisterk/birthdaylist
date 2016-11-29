package gui;

import model.BirthdaylistModel;
import model.Model;
import model.Person;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BirthdaylistController implements Initializable {
    @FXML
    private ListView<String> listViewPersons;
    @FXML
    private TextField textFieldName;
    @FXML
    private DatePicker datePickerBirthday;
    @FXML
    private MenuItem menuItemNew;
    @FXML
    private MenuItem menuItemDelete;
    @FXML
    private Button buttonSave;
    @FXML
    private AnchorPane panelDetail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //********************************
        // INIT
        //********************************
        // init model
        BirthdaylistModel model = getModelWithSampleData();

        // fill list
        this.fillList(model);
        
        // choose last entry and show it in datail-window
        listViewPersons.getSelectionModel().selectLast();
        fillDetailWindow(model, model.count() - 1);

        //********************************
        // Events
        //********************************
        // change selection in list
        listViewPersons.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov,
                            String old_val, String new_val) {
                        int index = listViewPersons.getSelectionModel().getSelectedIndex();
                        if (index >= 0) {
                            aktivateDetailWindow();
                            fillDetailWindow(model, index);                            
                        } else {
                            deaktivateDetailWindow();
                        }
                    }
                });

        // CREATE
        menuItemNew.setOnAction((event) -> {
            model.createPerson("Neu", LocalDate.now());
            fillList(model);
            listViewPersons.getSelectionModel().selectLast();
            textFieldName.selectAll();
        });

        // UPDATE
        buttonSave.setOnAction((event) -> {
            // get data from window
            String name = textFieldName.getText();
            LocalDate birthday = datePickerBirthday.getValue();

            // save data in model
            int index = listViewPersons.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                model.updateName(index, name);
                model.updateBirthday(index, birthday);
            }

            // update window
            fillList(model);
            listViewPersons.getSelectionModel().select(index);
        });

        // DELETE
        menuItemDelete.setOnAction((event) -> {
            int index = listViewPersons.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                model.deletePerson(index);
                fillList(model);
                if (index == model.count()) {
                    index--;
                }
                listViewPersons.getSelectionModel().select(index);
            }
        });

    }

    //********************************
    // Update GUI
    //********************************        
    private void fillList(Model model) {
        ObservableList<String> olist = listViewPersons.getItems();
        olist.clear();
        List<Person> list = model.getPersonList();
        for (Person p : list) {
            String text =p.getName() + " " +
                    p.getBirthday().getDayOfMonth() + "." +
                    p.getBirthday().getMonthValue() + ".";
            olist.add(text);
        }
    }

    private void fillDetailWindow(Model model, int index) {
        if (index >= 0) {
            textFieldName.setText(model.getName(index));
            datePickerBirthday.setValue(model.getBirthday(index));
        }
    }

    private void aktivateDetailWindow() {
        panelDetail.setVisible(true);
    }

    private void deaktivateDetailWindow() {
        panelDetail.setVisible(false);
    }

    //********************************
    // Fill model with data
    //********************************        
    private BirthdaylistModel getModelWithSampleData() {
        // Create an fill model with sample-data
        BirthdaylistModel model = new BirthdaylistModel();

        // Create
        model.createPerson("Anna Arm", LocalDate.of(1970, 10, 1));
        model.createPerson("Berta Bein", LocalDate.of(1980, 8, 25));
        model.createPerson("Carla Copf", LocalDate.of(1990, 3, 13));

        return model;
    }

}
