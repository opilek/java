import static java.lang.Math.pow;
public class Segment
{

    public Point a;
    public Point b;


    public String toString()
    {
        return "("+a.x+";"+a.y+") ("+b.x+";"+b.y+")";
    }

    public String toSvgs()
    {

        return "<circle r=\"5\" cx=\"" + a.x + "\" cy=\"" + a.y + "\" r=\"2\" fill=\"red\" />" +
                "<circle r=\"5\"cx=\"" + b.x + "\" cy=\"" + b.y + "\" r=\"2\" fill=\"blue\" />";
    }


    public double length()
    {

        return Math.sqrt(pow(b.x-a.x,2)+pow(b.y-a.y,2));
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








