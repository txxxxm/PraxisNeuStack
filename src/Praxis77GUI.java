import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
public class
Praxis77GUI {
    private JPanel Mainpanell;
    private JTextField Vorname;
    private JTextField Nachname;
    private JButton Baufnehmen;
    private JButton Paufnehmen;
    private JTextField Nächsterp;
    private JTextField Nächsterb;
    private JButton Paufrufen;
    private JButton Baufrufen;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JLabel Label4;
    private JLabel Label5;
    private JTextArea Liste;
    private JButton delete;
    private JButton deleteb;
    private JButton Stackbutton;
    private JTextArea Stackarea;
    Patient erster=null;
    Blutspender eerster=null;
    Queue<Patient> aufrufliste;
    Queue<Blutspender> blutliste;
Stack<Patient> stack;
Stack<Blutspender> blutstack;

    Patient p;
    Blutspender pp;

    public Praxis77GUI()
    {



blutstack = new Stack<>();
stack = new Stack<>();
        aufrufliste = new LinkedList<>();
        blutliste = new LinkedList<>();
        Paufnehmen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p= new Patient(Vorname.getText(),Nachname.getText());
                if (aufrufliste.isEmpty()){
                    erster= p;
                    aufrufliste.add(p);
                }
                else{
                    aufrufliste.add(p);
                };
                Nächsterp.setText(""+erster.toString());
                Vorname.setText("");
                Nachname.setText("");
                updatePatientList();

            }
        });
        Baufnehmen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pp = new Blutspender(Vorname.getText(), Nachname.getText());
                if (blutliste.isEmpty()){
                    eerster=pp;
                    blutliste.add(pp);
                }
                else
                {
                    blutliste.add(pp);
                }
                Nächsterb.setText(""+eerster.toString());
                Vorname.setText("");
                Nachname.setText("");
                updatePatientList();

            }

        });
        Paufrufen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!aufrufliste.isEmpty()) {
                    Patient nextPatient = aufrufliste.poll();
                    Nächsterp.setText(""+nextPatient.toString());
                } else {
                    Nächsterp.setText("leer");
                }
                updatePatientList();
                if(stack.isEmpty()){erster=p;
                    stack.push(p);}
                Stackarea.setText(""+erster.toString());
            }
        });
        Baufrufen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!blutliste.isEmpty()) {
                    Blutspender nextPatient = blutliste.poll();
                    Nächsterb.setText(""+nextPatient.toString());

                } else {
                    Nächsterb.setText("leer");
                }
                updatePatientList();
                if(blutstack.isEmpty()){eerster=pp;
                    blutstack.push(pp);}
                Stackarea.setText(Stackarea.getText()+"\t\t"+eerster.toString());
            }
        });


        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLast();
                updatePatientList();
            }
        });
        deleteb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLastb();
                updatePatientList();
            }
        });
        Stackbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void deleteLast() {
        if (!aufrufliste.isEmpty()) {
            LinkedList<Patient> patientList = new LinkedList<>(aufrufliste);
            patientList.removeLast();
            aufrufliste = new LinkedList<>(patientList);
        }


    }
    public void deleteLastb(){if (!blutliste.isEmpty()) {
        LinkedList<Blutspender> blutspenderList = new LinkedList<>(blutliste);
        blutspenderList.removeLast();
        blutliste = new LinkedList<>(blutspenderList);
    }}
    private void updatePatientList() {
        StringBuilder patientListText = new StringBuilder("Patientenliste:\n");


        for (Patient patient : aufrufliste) {
            patientListText.append(patient.getFullName()).append("\n");
        }


        patientListText.append("\nBlutspenderliste:\n");
        for (Blutspender blutspender : blutliste) {
            patientListText.append(blutspender.getFullName()).append("\n");
        }

        Liste.setText(patientListText.toString());
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Praxis77GUI");
        frame.setContentPane(new Praxis77GUI().Mainpanell);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
