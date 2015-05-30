import java.awt.*;
import java.awt.Dimension;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by e.makarycheva on 25.05.2015.
 */
public class FrameForChangesPeople extends JFrame {

    int mode;
    public static final int ADD = 0;
    public static final int EDIT = 1;
    public final JLabel lableName = new JLabel();
    public final JTextField textForName = new JTextField();
    public final JLabel lableSurame = new JLabel();
    public final JTextField textForSurame = new JTextField();
    public final JButton butOkForChanges = new JButton("Ок");
    public final JButton butCancelAllChanges = new JButton("Отмена");

    public FrameForChangesPeople(MainFrameForPeople mainFrameForPeople, int mode, String name, String surname) {
        setName("Человек");
        setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setSize(300, 100);
        setLayout(new GridLayout(3, 2));
        this.lableName.setText("Имя");
        this.lableSurame.setText("Фамилия");
        textForName.setText(name);
        textForSurame.setText(surname);
        add(this.lableName);
        add(this.lableSurame);
        add(this.textForName);
        add(this.butOkForChanges);
        add(this.butCancelAllChanges);

        if (this.mode == EDIT) {
            this.butOkForChanges.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    textForName.getText();
                    textForSurame.getText();

                    removeAll();
                }
            });
        } else {
            this.butOkForChanges.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = textForName.getText();
                    String surmane = textForSurame.getText();
                    removeAll();
                }
            });
        }


        butCancelAllChanges.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
            }
        });
    }
}
