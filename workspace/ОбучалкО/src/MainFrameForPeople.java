import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by e.makarycheva on 25.05.2015.
 */
public class MainFrameForPeople extends JFrame {

    public JList people = new JList();
    final JScrollPane scrollPeople = new JScrollPane(people);
    final JPanel panelForMainBut = new JPanel();
    final JButton butAddPeople = new JButton("Добавить");
    final JButton butChangePeople = new JButton("Изменить");
    final JButton butDropPeople = new JButton("Удалить");
    final List<Human> newHumans = new ArrayList<Human>();
    public MainFrameForPeople() {

    }

    private List<Human> getValueForPeople() {

        List<Human> humans = new ArrayList<Human>();
        List<Worker> workers = new ArrayList<Worker>();

        for (
                int i = 0;
                i <= 49; i++) {
            humans.add(new Human(Sex.MAN, "Name" + (i + 1), "Surname" + (i + 1)));
        }

        for (
                int i = 0;
                i <= 49; i++) {
            workers.add(new Worker(Sex.WOMAN, "Name" + (i + 51), "Surname" + (i + 51)));
        }


        final List<Human> newHumans = new ArrayList<Human>();

        for (
                int i = 0;
                i < (humans.size() + workers.size()); i++) {
            if (i < humans.size()) {
                newHumans.add(humans.get(i));
            } else {
                Human h = workers.get(i - humans.size());
                newHumans.add(h);
            }
        }
        return newHumans;
    }


    public JList getPeople() {
        return this.people;
    }


    public void setPeole(JList people) {
        this.people = people;
    }

    public void createMainFrameForPeople() {

        setName("Люди");
        setSize(300, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getValueForPeople();

        people.setVisibleRowCount(5);
        scrollPeople.createVerticalScrollBar();
        add(scrollPeople, BorderLayout.NORTH);
        panelForMainBut.setLayout(new FlowLayout());
        add(panelForMainBut, BorderLayout.SOUTH);
        panelForMainBut.add(butAddPeople);
        butChangePeople.setEnabled(false);
        panelForMainBut.add(butChangePeople);
        butDropPeople.setEnabled(false);
        panelForMainBut.add(butDropPeople);
        setVisible(true);


        people.addListSelectionListener(new ListSelectionListener() {
                                            @Override
                                            public void valueChanged(ListSelectionEvent e) {
                                                butChangePeople.setEnabled(true);
                                                butDropPeople.setEnabled(true);

                                            }
                                        }
        );

        butChangePeople.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {

                                                  FrameForChangesPeople modalWindowForPeopleChanges = new FrameForChangesPeople(MainFrameForPeople.this, 1, selectedPeople.getName(), selectedPeople.getSurname());


                                              }
                                          }

        );

        butAddPeople.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent e) {
                                               FrameForChangesPeople modalWindowForPeopleChanges = new FrameForChangesPeople(MainFrameForPeople.this, 0, "", "");

                                           }
                                       }

        );
        butDropPeople.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                newHumans.remove(people.getSelectedIndex());
                                                people.setListData(newHumans.toArray());
                                                people.repaint();
                                                repaint();
                                            }
                                        }

        );
    }

}
