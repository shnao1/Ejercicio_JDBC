package entity;

public class Autor {

    private int id;
    private String name;
    private String nationality;

    public Autor(){

    }

    public Autor(int id, String name, String nacionalidad) {
        this.id = id;
        this.name = name;
        this.nationality = nacionalidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Autor" + id + "{" + "\n" +
                "id = " + id + "\n" +
                "name = " + name + '\n' +
                "nationality = " + nationality + '}' + "\n";
    }
}
