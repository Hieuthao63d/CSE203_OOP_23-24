/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6_ass2;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
/**
 *
 * @author Phan Thao
 */
public class CalculatorPanel extends JPanel{
    private JTextField txtGuestName;
    private JCheckBox cbBreakfast, cbGolf,cbPool;
    private JComboBox<String> cbDaytype;
    private JButton btnCalculate;
    private JLabel lblResult;
    
    public CalculatorPanel(){
        setLayout(new FlowLayout());
        
        add(new JLabel("Base price for a room is $200"));
        add(new JLabel("Choose options that you want"));
        txtGuestName = new JTextField(15);
        add(new JLabel("Guest Name:"));
        add(txtGuestName);

        cbBreakfast = new JCheckBox("Breakfast $20");
        cbGolf = new JCheckBox("Golf $50");
        cbPool = new JCheckBox("Pool $15");
        add(cbBreakfast);
        add(cbGolf);
        add(cbPool);

        cbDaytype = new JComboBox<>(new String[]{"Weekday (-10%)", "Weekend (+30%)"});
        add(cbDaytype);

        btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(this::calculateAction);
        add(btnCalculate);

        lblResult = new JLabel("");
        add(lblResult);
    }

    private void calculateAction(ActionEvent e) {
        PriceCaculator calculator = new PriceCaculator(
            txtGuestName.getText(),
            cbBreakfast.isSelected(),
            cbGolf.isSelected(),
            cbPool.isSelected(),
            cbDaytype.getSelectedIndex()
        );
        String result = calculator.calculate();
        lblResult.setText(result);
    }   
}
