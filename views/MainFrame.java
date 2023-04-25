/*
* File: MainFrame.java
* Author: Maximilian Barabas
* Copyright: M B 
* Group: Szoft_II_N
* Date: 2022-04-22
* Github: https://github.com/maximilianbarabas
* Licenc: GNU GPL
*/

package views;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lan.bcs.InputPanel;

public class MainFrame extends JFrame {
  JPanel mainPanel;

  JPanel northPanel;
    JLabel mainLabel;

  JPanel centerPanel;
    InputPanel sideInput;
    InputPanel angleInput;
    JPanel buttonPanel;
      JButton submitButton;
      JButton resetButton;
    InputPanel perimeterDisplay;
    InputPanel areaDisplay;

  JPanel southPanel;
    JButton exitButton;
    JButton creditsButton;

  public MainFrame() {

    setMainPanel();
    setComponents();
    addComponentsToPanels();
    setFrame();
  }

  private void setComponents() {

    GridLayout Grid_1_2 = new GridLayout(1, 2);

    northPanel = new JPanel();
      mainLabel = new JLabel("Rombusz adatai");

    centerPanel = new JPanel(new GridLayout(5, 1));

      sideInput = new InputPanel();
      sideInput.setText("A oldal (m):");
      angleInput = new InputPanel();
      angleInput.setText(("Alpha (°): "));

      buttonPanel = new JPanel(Grid_1_2);

      submitButton = new JButton("Számítás");
      resetButton = new JButton("Újra");

      perimeterDisplay = new InputPanel();
      perimeterDisplay.setText("Kerület (m): ");
      areaDisplay = new InputPanel();
      areaDisplay.setText("Terület (m²): ");

    southPanel = new JPanel(Grid_1_2);

      exitButton = new JButton("Kilépés");
      creditsButton = new JButton("Névjegy");

  }

  private void addComponentsToPanels() {
    northPanel.add(mainLabel);

    centerPanel.add(sideInput);
    centerPanel.add(angleInput);
    centerPanel.add(buttonPanel);

    buttonPanel.add(submitButton);
    buttonPanel.add(resetButton);

    centerPanel.add(perimeterDisplay);
    centerPanel.add(areaDisplay);

    southPanel.add(creditsButton);
    southPanel.add(exitButton);

    mainPanel.add(northPanel, BorderLayout.NORTH);
    mainPanel.add(centerPanel, BorderLayout.CENTER);
    mainPanel.add(southPanel, BorderLayout.SOUTH);
  }

  private void setMainPanel() {
    this.mainPanel = new JPanel(new BorderLayout());

    this.add(this.mainPanel);
  }

  private void setFrame() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400, 300);
    this.setTitle("Rombitak");
    this.setVisible(true);

  }

  // methods to access buttons
  public JButton getSubmitButton() {
    return this.submitButton;
  }
  public JButton getResetButton() {
    return this.resetButton;
  }
  public JButton getCreditsButton() {
    return this.creditsButton;
  }
  public JButton getExitButton() {
    return this.exitButton;
  }

  // methods to access input fields
  public InputPanel getSideInput() {
    return this.sideInput;
  }
  public InputPanel getAngleInput() {
    return this.angleInput;
  }

  //methods to access display fields
  public InputPanel getPerimeterDisplay() {
    return this.perimeterDisplay;
  }
  public InputPanel getAreaDisplay() {
    return this.areaDisplay;
  }
}