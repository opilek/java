public class Ellipse extends Shape
{
    //Srodek elipsy
    private Point mid;
    //Promienie
    private double rx;
    private double ry;

    //Ellipse dziedziczy po Shape a tam jest już Style więc nie musimy go definiować

    public Ellipse(Point mid, double rx, double ry,Style style)
    {
        super(style);

        this.mid=mid;
        this.rx=rx;
        this.ry=ry;
    }
    @Override
    public String toSvg(double offsetX, double offsetY)
    {
        return "<ellipse> rx: "+rx+" ry: "+ry+"cx: "+mid.getX()+" cy: "+mid.getY()+"\""
                + " "+ style.toSvg()+"/>";
    }



}
