import java.io.IOException;//rzuca wyjątki tak jak tu przy konstruktorze new Point()
public class Main
{
    public static void main(String[] args) throws IOException
    {


          Point p1=new Point();
          p1.setX(30.0);
          p1.setY(24.0);


        System.out.println(p1);

        Point p2=new Point(13.0,65);

        System.out.println(p2);

        Segment s1=new Segment(p1,p2);
        System.out.println(s1);


        Point[] arr={p1,p2,p1};
        arr[2]=new Point(30,65);

      //Wywołanie kostruktora z klasy Polygon
        Polygon poly=new Polygon(arr);
        System.out.println(poly);

        //Użycie metody toSvg
        System.out.println(poly.toSvg());








    }
}