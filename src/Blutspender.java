public class Blutspender {
    String name;
    String nachname;

    Blutspender nachfolger;

    public Blutspender(String pname, String pnachname)
    {
        name=pname;
        nachname=pnachname;

    }
    public void setName(String pname){
        name=pname;
    }
    public String getName(){
        return name;
    }
    public void setNachname(String pnachname){
        nachname=pnachname;
    }
    public String getNachname(){
        return nachname;
    }
    public void setNachfolger(Blutspender pnachfolger){
        if(nachfolger==null){
            nachfolger=pnachfolger;
        }
        else{


        }
    }
    public Blutspender getNachfolger(){
        return nachfolger;
    }
    public String toString() {
        return "" + name + "," + nachname;
    }
    public String getFullName() {
        return name + " " + nachname;
    }
}

