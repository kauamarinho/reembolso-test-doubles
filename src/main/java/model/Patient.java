package model;

public class Patient {

    private String name;
    private String cpf;

    public Patient() {
    }

    public Patient(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }
}
