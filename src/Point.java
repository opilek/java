public class Point
{

    private double x;
    private double y;

    // Konstruktor ustawiający punkt w zadanym położeniu
    public Point()
    {
        this.x=x;
        this.y=y;
    }

    // Domyślny konstruktor ustawiający punkt na (0,0)
   /* public Point()
    {
        this.x=0;
        this.y=0;
    }*/
    //Getter x
    public double getX()
    {
        return this.x;
    }
    //Getter y
    public double getY() {
        return this.y;
    }
    //Setter x
    public void setX(double x)
    {
        this.x=x;
    }
    //Setter y
    public void setY(double y)
    {
        this.y = y;
    }

    @Override
    public String toString()
    {
          return "("+x+";"+y+")";
    }

    public String toSvg()
    {
        return "<circle r=\"5\" cx=\""+x+"\" cy=\""+y+"\" fill=\"black\" />";
    }

    public void translate(double dx,double dy)
    {
        x+=dx;
        y+=dy;
    }

    public Point translated(double dx, double dy)
    {

       Point newPoint=new Point();
        newPoint.x+=x+dx;
        newPoint.y=y+dy;

        return newPoint;


    }





}
