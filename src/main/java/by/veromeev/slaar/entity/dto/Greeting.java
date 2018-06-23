package by.veromeev.slaar.entity.dto;

public class Greeting {

    private String content;

    public Greeting() {
        System.out.println("Greeting created");
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
