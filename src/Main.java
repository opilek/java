public class Main
{
    public static void main(String[] args)
    {


        Point p1=new Point();
        p1.x=5.0;
        p1.y=6.0;


        System.out.println(p1);
       System.out.println(p1.toSvg());

        p1.translate(-6,5);
        System.out.println(p1);

        Point p2=p1.translated(-6,5);
        System.out.println(p2);

       Segment s=new Segment();
       s.a=new Point();
       s.a.x=1.0;
       s.a.y=5.0;

       s.b=new Point();
       s.b.x=5.0;
       s.b.y=9.0;

        System.out.println(s.length());

        // Inicjalizowanie tablicy segmentów
        Segment[] arr = new Segment[2];

        // Inicjalizowanie pierwszego segmentu
        arr[0] = new Segment();
        arr[0].a.x = 1.0;
        arr[0].a.y = 2.0;
        arr[0].b.x = 4.0;
        arr[0].b.y = 6.0;

        // Inicjalizowanie drugiego segmentu
        arr[1] = new Segment();
        arr[1].a.x = 0.0;
        arr[1].a.y = 0.0;
        arr[1].b.x = 7.5;
        arr[1].b.y = 5.0;

        // Wywołanie metody maxSegment() z klasy Segment
        Segment result = Segment.maxSegment(arr);

        // Wyświetlanie wyniku
        if (result != null) {
            System.out.println("Najdłuższy segment ma długość: " + result.length());
        } else {
            System.out.println("Tablica segmentów jest pusta.");
        }







    }
}