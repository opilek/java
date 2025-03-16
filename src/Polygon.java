import javax.sound.sampled.Line;

public class Polygon extends Shape
{
    private Point[] points;
    //dodajemy pole typu Style
    private Style style;

    //Getter dla style
    public Style getStyle()
    {
        return style;
    }
    //Seter dla style
    public void setStyle(Style style)
    {
        this.style = style;
    }



    public Point[] getPoints()
    {
        return points;
    }

    public void setPoints(Point[] points)
    {
        this.points = points;
    }

    // Konstruktor bez argumentu style - ustawia domyślny styl
    public Polygon(Point[] points)
    {
        this(points, new Style("transparent", "black", 1));
    }


    //Modyfikacja konstruktora (dodanie Style)
    public Polygon(Point[] points, Style style )
    {
        //Super służy doywoływania konstruktora
        // klasy nadrzędnej w konstruktorze klasy pochodnej (dziedziczącej).
        super(style);
        this.points = new Point[points.length];
        this.style=style;
        for (int i = 0; i < points.length; i++)
        {
            this.points[i] = new Point(points[i].getX(), points[i].getY());
        }
    }
    //Konstruktor wykonujący głęboką kopię obiektu
    public Polygon(Polygon other)
    {
        //Przy głębokiej kopii tworzymy nowy obiekt dlatego mamy new Style
        super(new Style(other.getStyle().fillColor, other.getStyle().strokeColor, other.getStyle().widthColor));


        Point[] otherPoints = other.getPoints();
        this.points = new Point[otherPoints.length];
        for (int i = 0; i < points.length; i++)
        {
            this.points[i] = new Point(otherPoints[i].getX(), otherPoints[i].getY());
        }
    }



    @Override
    public String toString()
    {
        String result = "";
        for (int i = 0; i < this.points.length; i++)
        {
            result += "Punkt nr. " + (i + 1) + "\n" + this.points[i] + "\n";
        }

        return result;
    }

    public String toSvg(double offsetX, double offsetY)
    {
        String result = "<polygon points=\"";

        for (int i = 0; i < points.length; i++)
        {
            result += (points[i].getX() + offsetX) + "," + (points[i].getY() + offsetY);

            if (i < points.length - 1)
            {
                result += " ";
            }
        }
        result += "\" style=\"fill: " + getStyle().fillColor + "; stroke: " + getStyle().strokeColor
                + "; stroke-width: " + getStyle().widthColor + "\" />";

        return result;
    }







}
