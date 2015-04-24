package de.bertschneider.junitquickchecktest;

public class Data {

    private String stuff;

    public Data(String stuff) {
        this.stuff = stuff;
    }

    public String getStuff() {
        return stuff;
    }

    @Override
    public String toString() {
        return "Data [stuff=" + stuff + "]";
    }

}