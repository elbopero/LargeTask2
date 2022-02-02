import java.awt.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadShape {


    public ArrayList<Shape> shapeObj = new ArrayList<>();

    public void readFile() throws FileNotFoundException{
        File file = new File("shapes.txt");
        Scanner scan = new Scanner(file);

        //readCircle(scan);
         while (scan.hasNextLine()) {

             switch (scan.nextLine()) {
                 case "Circle" -> shapeObj.add(readCircle(scan));
                 case "Rectangle" -> shapeObj.add(readRectangle(scan));
                 case "Square" -> shapeObj.add(readSquare(scan));
             }
         }
    }

    public Circle readCircle(Scanner scan) {
      // String name = scan.nextLine();
        //scan.nextLine();
        int radius = Integer.parseInt(scan.nextLine());
        int r = Integer.parseInt(scan.nextLine());
        int g = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        Color color = new Color(r,g,b);
        boolean filled = Boolean.parseBoolean(scan.nextLine());
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        MovablePoint movablePoint = new MovablePoint(x,y);

        //scan.close();
        return new Circle(radius, color, filled, movablePoint);

    }

    public Rectangle readRectangle(Scanner scan) {
       // String name = scan.nextLine();
       // scan.nextLine();
        double width = Double.parseDouble(scan.nextLine());
        double length = Double.parseDouble(scan.nextLine());
        int r = Integer.parseInt(scan.nextLine());
        int g = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        Color color = new Color(r,g,b);
        boolean filled = Boolean.parseBoolean(scan.nextLine());
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        MovablePoint topLeft = new MovablePoint(x,y);
        x = scan.nextDouble();
        y = scan.nextDouble();
        MovablePoint bottomRight = new MovablePoint(x,y);

        return new Rectangle(width, length, color, filled, topLeft, bottomRight);
    }

    public Square readSquare(Scanner scan) {
      //  String name = scan.nextLine();
      //  scan.nextLine();
        double side = Double.parseDouble(scan.nextLine());
        int r = Integer.parseInt(scan.nextLine());
        int g = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        Color color = new Color(r, g, b);
        boolean filled = Boolean.parseBoolean(scan.nextLine());
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        MovablePoint topLeft = new MovablePoint(x,y);
        x = scan.nextDouble();
        y = scan.nextDouble();
        MovablePoint bottomRight = new MovablePoint(x,y);

        return new Square(side, color, filled, topLeft, bottomRight);
    }

    public void drawAllShapes() {
        for (int i = 0; i < shapeObj.size(); i++) {
            System.out.println(shapeObj.get(i)+"\n");
        }
        System.out.println();
    }

    public void sumAreaSquare() {
        double sum = 0;

        for (Shape sh: shapeObj) {
            if (sh instanceof Square) {
                sum += sh.getArea();
            }
        }
        System.out.println("Total areas for squares added is: " + sum + "\n");
    }

    public void createNewShapes() {
        try {
            Scanner read = new Scanner(System.in);
            System.out.println("Skriv figuren du vil legge til; Circle, Rectangle eller Square");
            switch (read.nextLine()) {
                case "Circle" -> createCircle();
                case "Rectangle" -> createRectangle();
                case "Square" -> createSquare();
                default -> System.out.println("Ugyldig figur. Circle, Rectangle eller Square må skrives.");
            }
        } catch (Exception ex) {
            System.out.println("Ugyldig valg. Skriv Circle, Rectangle eller Square.");
        }
    }

    public void createCircle() {
        // String name = scan.nextLine();
        //scan.nextLine();
        try {
            Scanner read = new Scanner(System.in);
            System.out.println("Skriv inn radius");
            int radius = Integer.parseInt(read.nextLine());


            System.out.println("Fyll rødtone fra 0 til 255");
           // int r = Integer.parseInt(read.nextLine());
            int r = Shape.colorValidate();

            System.out.println("Fyll grønntone fra 0 til 255");
            int g = Shape.colorValidate();

            System.out.println("Fyll blåtone fra 0 til 255");
            int b = Shape.colorValidate();
            Color color = new Color(r, g, b);
            System.out.println("Skriv om figuren er fylt. True eller false");
            boolean filled = Boolean.parseBoolean(read.nextLine());
            System.out.println("Fyll x koordinat for senter");
            double x = read.nextDouble();
            System.out.println("Fyll y koordinat for senter");
            double y = read.nextDouble();
            MovablePoint movablePoint = new MovablePoint(x, y);

            //scan.close();
            Circle c = new Circle(radius, color, filled, movablePoint);
            shapeObj.add(c);
        }
        catch (Exception e) {
            System.out.println("En av verdiene ble ikke fylt inn riktig. Se tips\n" +
                    "Radius fylles med et heltall f.eks 1,2,3 osv.\n"+
                    "Rød, grønn og blåtone fylles med et heltall.\n"+
                    "Om figuren er fylt eller ikke, skrives med true eller false.\n" +
                    "Bredde og lengde skrives med desimaltall. F.eks; 2.5");
        }
    }

    public void createRectangle() {
        try {
            Scanner read = new Scanner(System.in);
            System.out.println("Skriv bredde:");
            double width = Double.parseDouble(read.nextLine());
            System.out.println("Skriv lengde: ");
            double length = Double.parseDouble(read.nextLine());
            System.out.println("Skriv rødtone. Må være et tall mellom 0 - 255");
            int r = Integer.parseInt(read.nextLine());
            System.out.println("Skriv grønntone. Må være et tall mellom 0 - 255");
            int g = Integer.parseInt(read.nextLine());
            System.out.println("Skriv blåtone. Må være et tall mellom 0 - 255");
            int b = Integer.parseInt(read.nextLine());
            Color color = new Color(r, g, b);
            System.out.println("Er figuren fylt eller ikke? True/false. true=fylt, false = ikke fylt.");
            boolean filled = Boolean.parseBoolean(read.nextLine());
            System.out.println("Fyll koordinat x for topp venstre med desimaltall.");
            double x = read.nextDouble();
            System.out.println("Fyll koordinat y for topp venstre med desimaltall.");
            double y = read.nextDouble();
            MovablePoint topLeft = new MovablePoint(x, y);
            System.out.println("Fyll koordinat x for bunn høyre med desimaltall.");
            x = read.nextDouble();
            System.out.println("Fyll koordinat y for bunn høyre med desimaltall.");
            y = read.nextDouble();
            MovablePoint bottomRight = new MovablePoint(x, y);

            Rectangle re = new Rectangle(width, length, color, filled, topLeft, bottomRight);
            shapeObj.add(re);
        } catch (Exception e) {
            System.out.println("Et av verdiene som ble lagt til hadde feil datatype. Prøv igjen.");
        }
    }

    public void createSquare() {
        try {
            Scanner read = new Scanner(System.in);
            System.out.println("Skriv lengden på en side med desimaltall.");
            double side = Double.parseDouble(read.nextLine());
            System.out.println("Skriv rødtone. Må være et tall mellom 0 - 255");
            int r = Integer.parseInt(read.nextLine());
            System.out.println("Skriv grønntone. Må være et tall mellom 0 - 255");
            int g = Integer.parseInt(read.nextLine());
            System.out.println("Skriv blåtone. Må være et tall mellom 0 - 255");
            int b = Integer.parseInt(read.nextLine());
            Color color = new Color(r, g, b);
            System.out.println("Skriv om figuren er fylt eller ikke. true=fylt, false = ikke fylt");
            boolean filled = Boolean.parseBoolean(read.nextLine());
            System.out.println("Fyll koordinat x for topp venstre med desimaltall.");
            double x = read.nextDouble();
            System.out.println("Fyll koordinat y for topp venstre med desimaltall.");
            double y = read.nextDouble();
            MovablePoint topLeft = new MovablePoint(x, y);
            System.out.println("Fyll koordinat x for bunn høyre med desimaltall.");
            x = read.nextDouble();
            System.out.println("Fyll koordinat y for bunn høyre med desimaltall.");
            y = read.nextDouble();
            MovablePoint bottomRight = new MovablePoint(x, y);

            Square s = new Square(side, color, filled, topLeft, bottomRight);
            shapeObj.add(s);
        } catch (Exception e) {
            System.out.println("En av verdiene ble lagt til med feil datatype. Prøv på nytt");
        }
    }

    public void moveFigure(){
        try {
            Scanner scan = new Scanner(System.in);

            System.out.println("Hvilken figur vil du flytte?");
            int index = scan.nextInt();
            if (shapeObj.get(index) instanceof Circle) {
                System.out.println("Hvor mye vil du flytte senter til høyre?");
                double move = scan.nextDouble();
                shapeObj.get(index).moveRight(move);}
            else if(shapeObj.get(index) instanceof Rectangle) {
                System.out.println("Hvor mye vil du flytte rektangel til høyre?");
                double moveRectangle = scan.nextDouble();
                shapeObj.get(index).moveRight(moveRectangle);
            } else if (shapeObj.get(index) instanceof Square) {
                System.out.println("Hvor mye vil du flytte kvadrat til høyre?");
                double moveSquare = scan.nextDouble();
                shapeObj.get(index).moveRight(moveSquare);
            }

            System.out.println("Figuren er flyttet med god suksess.");
            System.out.println(shapeObj.get(index));

        } catch (Exception e) {

            System.out.println("Beklager. Fikk ikke lagt til figuren.");
        }

    }
}
