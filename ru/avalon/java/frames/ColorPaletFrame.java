package ru.avalon.java.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Hashtable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import ru.avalon.java.ui.AbstractFrame;

public class ColorPaletFrame extends AbstractFrame {

    private JPanel paletPanel = new JPanel();
    private JPanel sliderPanel = new JPanel();

    private JSlider sliderR = new JSlider(0, 255, 125);
    private JSlider sliderG = new JSlider(0, 255, 125);
    private JSlider sliderB = new JSlider(0, 255, 125);

    private JLabel labelR = new JLabel("Red");
    private JLabel labelG = new JLabel("Green");
    private JLabel labelB = new JLabel("Blue");

    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    @Override
    protected void onCreate() {
        setTitle("Color Palet");
        setSize(600, 300);
        setLayout(new GridLayout(1, 2));

        paletPanel = paletCreator();
        add(paletPanel);

        sliderPanel = slidersCreator();
        add(sliderPanel);
        updateColor();

    }

    private JPanel paletCreator() {

        paletPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 20));

        return paletPanel;

    }

    private JPanel slidersCreator() {
        sliderPanel.setLayout(new GridLayout(3, 1));
        sliderPanel.setForeground(Color.white);

        sliderPanel.add(redPanel());
        sliderPanel.add(greenPanel());
        sliderPanel.add(bluePanel());

        return sliderPanel;
    }

    private void sliderSetter(JSlider slider) {
        slider.setMajorTickSpacing(25);
        slider.setPaintTicks(true);
        Hashtable position = new Hashtable();
        position.put(0, new JLabel("0"));
        position.put(255, new JLabel("255"));
        slider.setLabelTable(position);
        slider.setPaintLabels(true);
        slider.addChangeListener(this::onSliderChange);
    }

    private JPanel redPanel() {

        JPanel redPanel = new JPanel(new FlowLayout());
        redPanel.add(labelR);
        redPanel.add(sliderR);
        sliderSetter(sliderR);

        return redPanel;

    }

    private JPanel greenPanel() {

        JPanel greenPanel = new JPanel(new FlowLayout());
        greenPanel.add(labelG);
        greenPanel.add(sliderG);
        sliderSetter(sliderG);

        return greenPanel;

    }

    private JPanel bluePanel() {

        JPanel bluePanel = new JPanel(new FlowLayout());
        bluePanel.add(labelB);
        bluePanel.add(sliderB);
        sliderSetter(sliderB);

        return bluePanel;

    }

    private void updateColor() throws IllegalStateException {
        paletPanel.setBackground(new Color(sliderR.getValue(), sliderG.getValue(), sliderB.getValue()));
        String hex = "#" + Integer.toHexString(paletPanel.getBackground().getRGB());
        paletPanel.setToolTipText(hex);
        StringSelection copy = new StringSelection(hex);
        clipboard.setContents(copy, copy);

    }

    public void onSliderChange(ChangeEvent e) {

        updateColor();

    }
}
