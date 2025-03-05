import java.io.IOException;//rzuca wyjątki tak jak tu przy konstruktorze new Point()
public class Main
{
    public static void main(String[] args) throws IOException
    {


          Point p1=new Point();
          p1.setX(30.0);
          p1.setY(24.0);


        System.out.println(p1);



    }
}