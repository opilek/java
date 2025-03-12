public class Point
{

//    Pola x i y sa teraz prywatne, więc musimy utworzyć dla nich
//    odpowiednie metody, czyli akcesory i mutatory


    private int x;
    private int y;

//    Akcesory czyli setery

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

//    Mutatory czyli getery

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

//    Następnie tworzymy 2-argumentowy konstruktor, tworzący
//    nasz punk w miejscu określonym za pomocą argumentów

    public Point(int x, int y)

    {
        this.x = x;
        this.y = y;
    }

//    Następnie bezargumentowy tworzoący punkt w punkcie (0, 0)

    public Point()
    {
        this.x = 0;
        this.y = 0;
    }

//    Następnie tworzymy konstruktor kopiujący tworzący kopię GŁĘBOKĄ obiektu

    public Point(Point old)
    {
        this.x = old.getX();
        this.y = old.getY();
    }

    @Override
    public String toString()
    {
        return "Współżedna x punktu = " + x + "\nWspółżedna y punktu = " + y;
    }

    public String toSvg()
    {
        return "<circle cx=\"" + this.x + "\" cy=\"" + this.y + "\" r=\"5\" fill=\"black\" />";
    }

    public void translate(int dx, int dy)
    {
        this.x += dx;
        this.y += dy;
    }

    public Point translated(int dx, int dy)
    {
        Point result = new Point();
        result.x = this.x + dx;
        result.y = this.y + dy;
        return result;
    }
}