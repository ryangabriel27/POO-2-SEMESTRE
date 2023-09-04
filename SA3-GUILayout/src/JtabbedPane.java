import javax.swing.JTabbedPane;

public class JtabbedPane extends JTabbedPane {
    public JtabbedPane() {
        super();
        this.add(new Calculadora1());
        this.add(new Calculadora2());
        this.add(new Calculadora3());
    }
}
