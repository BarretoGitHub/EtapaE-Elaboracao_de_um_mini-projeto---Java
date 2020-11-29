package entelgy.poo.view.principal;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComponent;

public class JanelaAbstrata {

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    public JanelaAbstrata() {
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
    }

    public void add(Container panel, JComponent component, int x, int y, int pos, int width, int height, int fill) {
        panel.setLayout(layout);
        constraints.gridx = x;
        constraints.gridy = y;

        constraints.insets = new Insets(7, 7, 5, 10);

        constraints.anchor = pos;

        constraints.gridwidth = width;
        constraints.gridheight = height;
        constraints.fill = fill;

        layout.setConstraints(component, constraints);
        panel.add(component);
    }

    public void remove(Container panel, JComponent component) {
        panel.remove(component);
    }
}
