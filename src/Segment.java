import static java.lang.Math.pow;
public class Segment
{

    private final Point a;
    private final Point b;


    public Segment(Point a, Point b)
    {
        this.a=new Point(a);
        this.b=new Point(b);
    }


@Override

    public String toString()
    {
        return "Segment: a="+a+" b="+b;
    }



    //W tej metodzie poprzednio był x i y a teraz musimy użyć getterów bo x i y są private
    public double length()
    {

        return Math.sqrt(pow(b.getX()-a.getX(),2)+pow(b.getY()-a.getY(),2));
    }


    public static Segment maxSegment(Segment[] arr)
    {
        if (arr.length == 0)
        {
            return null;  // Zwrócenie null, jeśli tablica jest pusta
        }

        Segment max = arr[0];  // Zakłada, że pierwszy segment jest najdłuższy

        for (int i = 1; i < arr.length; i++)
        {  // Rozpoczynamy od drugiego segmentu
            if (arr[i].length() > max.length())
            {  // Porównujemy długość segmentu
                max = arr[i];  // Jeśli segment jest dłuższy, przypisujemy go jako nowy "max"
            }
        }
        return max;  // Zwracamy najdłuższy segment po zakończeniu pętli
    }

}








