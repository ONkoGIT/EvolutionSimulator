package sk.onko.evosimulator.view.gui;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Created by Ondrej on 7.2.2016.
 */
public class RegionInfoPanel extends JPanel {

    private JLabel regionTypeLabel = new JLabel("Region type");
    private JLabel regionInfoLabel = new JLabel("Info:");

    public RegionInfoPanel() {

        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        regionTypeLabel.setForeground(Color.WHITE);
        regionTypeLabel.setBounds(10, 0, 200, 30);
        this.add(regionTypeLabel);

        regionInfoLabel.setForeground(Color.WHITE);
        regionInfoLabel.setBounds(10, 20, 200, 30);
        this.add(regionInfoLabel);
    }

    public JLabel getRegionTypeLabel() {
        return regionTypeLabel;
    }

    public void setRegionTypeLabel(JLabel regionTypeLabel) {
        this.regionTypeLabel = regionTypeLabel;
    }

    public JLabel getRegionInfoLabel() {
        return regionInfoLabel;
    }

    public void setRegionInfoLabel(JLabel regionInfoLabel) {
        this.regionInfoLabel = regionInfoLabel;
    }
}
