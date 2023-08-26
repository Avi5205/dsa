package Pointer;

public class Main {
    public static void main(String[] args) {
        Cookie cookieOne = new Cookie("Green");
        Cookie cookieTwo = new Cookie("Blue");

        cookieOne.setColor("yellow");

        System.out.println(cookieOne.getColor());
        System.out.println(cookieTwo.getColor());
    }
}
