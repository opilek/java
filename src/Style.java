public class Style
{
    public final String fillColor;
    public final String strokeColor;
    public final double widthColor;


    Style(String fillColor, String strokeColor, double widthColor )
    {

        //this używamy wtedy gdy 2 zmienne nazywają się tak samo
        this.fillColor=fillColor;
        this.strokeColor=strokeColor;
        this.widthColor=widthColor;
    }



    public String toSvg()
    {
        return "style=\"fill: "+fillColor+" stroke: "+strokeColor+" width: "+widthColor+"\"";
    }
}
