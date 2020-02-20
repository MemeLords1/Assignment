//Thomas Chen
//Assignment 4 Income



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.collections.*;
import java.lang.NumberFormatException;
import java.text.DecimalFormat;
import javafx.beans.value.*;
import static javafx.application.Application.launch;


class IncomeTaxCalculator extends Application {
  private int Filing = 0;
  private double StateTaxRate = 0;
  private double FederalTaxRate = 0;

  public void start(Stage primaryStage) {

    Text text1 = new Text("Income:");
    TextField Income = new TextField();

    Button buttonCalculate = new Button("Calculate");
    Button buttonClear = new Button("Clear");
    Button buttonExit = new Button("Exit");

    final ToggleGroup tg = new ToggleGroup();
    RadioButton rSingle = new RadioButton("Single");
    rSingle.setUserData("0");
    rSingle.setToggleGroup(tg);
    rSingle.setSelected(true);
   
    HBox taxFiling = new HBox(10, rSingle);

   
    GridPane gridPane = new GridPane();
    gridPane.setMinSize(400, 200);
    gridPane.setPadding(new Insets(10, 10, 10, 10));
    gridPane.setVgap(5);
    gridPane.setHgap(5);
    gridPane.setAlignment(Pos.CENTER);


    gridPane.add(text1, 0, 0);
    gridPane.add(Income, 1, 0);
    gridPane.add(buttonCalculate, 3, 0);
    gridPane.add(buttonClear, 3, 1);
    gridPane.add(buttonExit, 3, 2);
    gridPane.add(taxFiling, 1, 1);

    final Label label = new Label();
    label.setWrapText(true);
    GridPane.setConstraints(label, 1, 5);
    GridPane.setColumnSpan(label, 2);
    gridPane.getChildren().add(label);

    final Label label2 = new Label();
    label.setWrapText(true);
    GridPane.setConstraints(label2, 1, 2);
    GridPane.setColumnSpan(label2, 2);
    gridPane.getChildren().add(label2);

    final Label label3 = new Label();
    label.setWrapText(true);
    GridPane.setConstraints(label3, 1, 3);
    GridPane.setColumnSpan(label3, 2);
    gridPane.getChildren().add(label3);


    tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
        @Override
        public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (tg.getSelectedToggle() != null) {
          Filing = Integer.parseInt(tg.getSelectedToggle()
            .getUserData().toString());
        }
      }
    });

    buttonCalculate.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) throws NumberFormatException {
        try {
          double IncomeValue;
          double stTax;
          double fedTax;
          double total = 0;
          DecimalFormat df = new DecimalFormat("#.00");
          df.setGroupingUsed(true);
          df.setGroupingSize(3);

          if ((Income.getText() != null &&
            !Income.getText().isEmpty())) {
            IncomeValue = Double.parseDouble(Income.getText());
           
          if (IncomeValue <= 0) {
            label.setText("Value must be positive.");
          } else {
            stTax = StateTax(IncomeValue, Filing);
            label2.setText("State Tax (" + StateTaxRate + "%): $"
              + df.format(stTax));
            fedTax = federalTax(IncomeValue, Filing);
            label3.setText("Federal Tax (" + FederalTaxRate + "%): $"
              + df.format(fedTax));
            total = stTax + fedTax;
            label.setText("Your income is $" + df.format(IncomeValue)
            + " and the total tax amount due is $" + df.format(total));
           }
        } else {
            label.setText("Please input a valid number.");
          }
        } catch (NumberFormatException error) {
            label.setText("Please input a valid number.");
          }
        }
    });

     
      buttonClear.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
          Income.clear();
          rSingle.setSelected(false);
       
         
         
          label.setText(null);
          label2.setText(null);
          label3.setText(null);
        }
      });

     
      buttonExit.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
           primaryStage.close();
        }
      });

   
      Scene scene = new Scene(gridPane);
      primaryStage.setTitle("Income Tax Calculator");
      primaryStage.setScene(scene);
      primaryStage.show();
  }

 
  public double StateTax(double income, int Filing) {
    double tax = 0;

 
    if (Filing == 0 || Filing == 2) {
      if (income <= 8500) {
        tax = income * 0.04;
        StateTaxRate = 4;
      } else if (income > 8500 && income < 11701) {
        tax = (income - 8500) * 0.045 + 340;
        StateTaxRate = 4.5;
      } else if (income > 11700 && income < 13901) {
        tax = (income - 11700) * 0.0525 + 484;
        StateTaxRate = 5.25;
      } else if (income > 13900 && income < 21401) {
        tax = (income - 13900) * 0.059 + 600;
        StateTaxRate = 5.9;
      } else if (income > 21400 && income < 80651) {
        tax = (income - 21400) * 0.0633 + 1042;
        StateTaxRate = 6.33;
      } else if (income > 80650 && income < 215401) {
        tax = (income - 80650) * 0.0657 + 4793;
        StateTaxRate = 6.57;
      } else if (income > 215400 && income < 1077551) {
        tax = (income - 215400) * 0.0685 + 13646;
      } else {
        tax = (income - 1077550) * 0.0882 + 72703;
        StateTaxRate = 8.82;
      }
    }

   
 
    return tax;
  }


  public double federalTax(double income, int Filing) {
    double tax = 0;

   
    if (Filing == 0) {
      if (income <= 9526) {
        tax = income * 0.1;
        FederalTaxRate = 10;
      } else if (income < 38701) {
        tax = 9525 * 0.1 + (income - 9525) * 0.12;
        FederalTaxRate = 12;
      } else if (income < 82501) {
        tax = 9525 * 0.1 + (38700 - 9525) * 0.12 + (income - 38700) * 0.22;
        FederalTaxRate = 22;
      } else if (income < 157501) {
        tax = 9525 * 0.1 + (38700 - 9525) * 0.12 + (82500 - 38700) * 0.22
          + (income - 82500) * 0.24;
        FederalTaxRate = 24;
      } else if (income < 200001) {
        tax = 9525 * 0.1 + (38700 - 9525) * 0.12 + (82500 - 38700) * 0.22
          + (157500 - 82500) * 0.24 + (income - 157500) * 0.32;
        FederalTaxRate = 32;
      } else if (income < 500001) {
        tax = 9525 * 0.1 + (38700 - 9525) * 0.12 + (82500 - 38700) * 0.22
          + (157500 - 82500) * 0.24 + (200000 - 157500) * 0.32
          + (income - 200000) * 0.35;
        FederalTaxRate = 35;
      } else {
        tax = 9525 * 0.1 + (38700 - 9525) * 0.12 + (82500 - 38700) * 0.22
          + (157500 - 82500) * 0.24 + (200000 - 157500) * 0.32
          + (500000 - 200000) * 0.35 + (income - 500000) * 0.37;
        FederalTaxRate = 37;
      }
    }
   
   
    return tax;
  }

  public static void main(String args[]) {
    launch(args);
  }
}

