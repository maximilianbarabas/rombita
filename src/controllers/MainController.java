/*
* File: MainController.java
* Author: Maximilian Barabas
* Copyright: M B 
* Group: Szoft_II_N
* Date: 2022-04-22
* Github: https://github.com/maximilianbarabas
* Licenc: GNU GPL
*/
package controllers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import lan.bcs.InputPanel;
import views.MainFrame;

public class MainController implements ActionListener {
  MainFrame mf;

  JButton submitButton;
  JButton resetButton;
  JButton creditsButton;
  JButton exitButton;

  InputPanel sideInput;
  InputPanel angleInput;

  InputPanel perimeterDisplay;
  InputPanel areaDisplay;
  
  public MainController() {

    start();
    addActionEvents();
  }

  private void start() {
    this.mf = new MainFrame();

    submitButton = mf.getSubmitButton();
    resetButton = mf.getResetButton();
    creditsButton = mf.getCreditsButton();
    exitButton = mf.getExitButton();

    sideInput = mf.getSideInput();
    angleInput = mf.getAngleInput();

    perimeterDisplay = mf.getPerimeterDisplay();
    areaDisplay = mf.getAreaDisplay();
  }

  private void addActionEvents() {
    submitButton.addActionListener(this);
    resetButton.addActionListener(this);
    exitButton.addActionListener(this);
    creditsButton.addActionListener(this);
  }

  private void calculate(double side, double angle) {
    Double perimeter = 4 * side;

    Double area = Math.pow(side, 2) * Math.sin(Math.toRadians(angle));

    perimeterDisplay.setValue(perimeter.toString());
    areaDisplay.setValue(area.toString());
  }

  private void tryCalculate() {

    String sideInputString = sideInput.getValue();
    String angleInputString = angleInput.getValue();

    try {
      Double side = Double.parseDouble(sideInputString);
      Double angle = Double.parseDouble(angleInputString);

      calculate(side, angle);

    } catch (NumberFormatException e) {

      String content = "Hibás bemenő adatok!";
      String title = "HIBA";

      JOptionPane.showMessageDialog(
        mf.getContentPane(),
        content,
        title,
        JOptionPane.ERROR_MESSAGE
      );
    }

  }

  private void reset() {
    sideInput.setValue(null);
    angleInput.setValue(null);
    perimeterDisplay.setValue(null);
    areaDisplay.setValue(null);
  }

  private void displayCredits() {
    
    String content = 
      "Készítő: Maximilian Barabas \n"
      "Csoport: Szoft_II_N \n"

    String title = "Rombitak1";

    JOptionPane.showMessageDialog(
      mf.getContentPane(), 
      content, 
      title, 
      JOptionPane.INFORMATION_MESSAGE);

  }

  private void exit() {
    System.exit(0);
  }

  @Override
  public void actionPerformed(ActionEvent event) {

    Object source = event.getSource();

    if (source == submitButton) {
      tryCalculate();
    } else if (source == resetButton) {
      reset();
    } else if (source == creditsButton) {
      displayCredits();
    } else if (source == exitButton) {
      exit();
    }
  }
}