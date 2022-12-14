package javafxapplication;

import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button_Math;
    @FXML
    private Label label_a;
    @FXML
    private Label label_b;
    @FXML
    private Label label_x;
    @FXML
    private Label label_otvet;
    @FXML
    private TextField textField_A;
    @FXML
    private TextField textField_B;
    @FXML
    private TextField textField_X;
    @FXML
    private Label label_d;
    @FXML
    private TextField textField_D;
    @FXML
    private Button button_Clear;
    @FXML
    private Button button_Exit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void buttonMathAction(ActionEvent event) {
        double a = 0, b = 0, x= 0, y;
try {
            a = Double.parseDouble(textField_A.getText());
        } catch (Exception ex) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введенных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            textField_A.requestFocus();
            label_otvet.setText("В введенном значении A допущена ошибка");
            textField_A.setText("???");
            textField_B.setText("");
            textField_X.setText("");
            return;
        }
try {
            b = Double.parseDouble(textField_B.getText());
        } catch (Exception ex) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введенных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            textField_B.requestFocus();
            label_otvet.setText("В введенном значении B допущена ошибка");
            textField_B.setText("???");
            textField_A.setText("???");
            textField_X.setText("???");
            return;
        }
try {
            x = Double.parseDouble(textField_X.getText());
        } catch (Exception ex) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введенных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            textField_X.requestFocus();
            label_otvet.setText("В введенном значении X допущена ошибка");
            textField_X.setText("???");
            textField_A.setText("???");
            textField_B.setText("???");
            return;
        }

        try {
            y = FXMLDocumentController.completing(a, b, x);
           label_otvet.setText("Ответ: " + String.format("%.2f", y));
        }catch  (Exception e) {
            label_otvet.setText("Нет ответа");
    
        }
    }
    
    public static double completing(double a, double b, double x) throws Exception {
        double y;
        if (x < 6) {
             y = a / x + b / (x * x);
            //label_otvet.setText("Ответ: " + String.format("%.2f",y));
        } else {
            y = (a * a) * (x + b);
            //label_otvet.setText("Ответ: " + String.format("%.2f",y));
        }
        if (!(Double.isNaN(y)) && (!Double.isInfinite(y))) {
            return y;
        } else {
            throw new Exception();
        }
    }

    @FXML
    private void buttonClearAction(ActionEvent event) {
        label_otvet.setText("Ответ: ");
        textField_A.setText("");
        textField_B.setText("");
        textField_X.setText("");
    }

    @FXML
    private void buttonExitAction(ActionEvent event) {
        System.exit(0);
    }

}
