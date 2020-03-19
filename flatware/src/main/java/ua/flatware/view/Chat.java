package ua.flatware.view;

public class Chat implements BaseChat {

    @Override
    public void printGreeting() {
        System.out.println("Hello, it's xml parser for flatware files");
    }

    public void printIfXmlValid() {
            System.out.println("XML is valid");
    }

    public void printIfXmlNotValid() {
        System.out.println("XML not valid, check your files or correctness of path and start again");
    }

    public void printParsingSuccessful(){
        System.out.println("Parsing successful");
    }

    @Override
    public void printTransformationComplete() {
        System.out.println("Transformation complete, pick up the file from the specified directory");
    }

}
