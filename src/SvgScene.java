import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;




public class SvgScene
{

    private Polygon[] polygons;  // Tablica przechowująca referencje do 3 obiektów Polygon
    private int index;  // Indeks, który wskazuje, gdzie dodać nowy Polygon


    public SvgScene()
    {
        this.polygons=new Polygon[3];
        index=0;
    }

    // Funkcja dodająca Polygon do tablicy
    public void addPolygon(Polygon poly)
    {
        // Dodaj nowy Polygon w miejscu wskazanym przez index
        polygons[index] = poly;

        // Zwiększ indeks, a jeśli przekroczy rozmiar tablicy, zresetuj go do 0
        index = (index + 1) % polygons.length;
    }

    public String toSvg()
    {
        StringBuilder sb = new StringBuilder();
        for(Polygon p: polygons)
        {
            if (p != null) {
                sb.append(p.toSvg()).append("\n");
            }


        }
        return sb.toString();
    }

    public BoundingBox boundingBox()
    {
        double minX = Double.POSITIVE_INFINITY;
        double maxX = Double.NEGATIVE_INFINITY;
        double minY = Double.POSITIVE_INFINITY;
        double maxY = Double.NEGATIVE_INFINITY;
        for (Polygon p : polygons){
            if(p!=null)
            {
                BoundingBox polyBB = p.boundingBox();
                minX = Math.min(minX, polyBB.x());
                minY = Math.min(minY, polyBB.y());
                maxX = Math.max(maxX, polyBB.x()+polyBB.width());
                maxY = Math.max(maxY, polyBB.y()+polyBB.height());
            }
        }
        return new BoundingBox(minX, minY, maxX-minX, maxY-minY);
    }


    public void save(String filePath) throws IOException
    {
        FileWriter writer = new FileWriter(filePath);
        BoundingBox bb = boundingBox();
        writer.write("<svg width=\""+bb.width()+"\" height=\""+bb.height());
        writer.write("\" viewBox=\""+bb.x()+" "+bb.y()+" "+bb.width()+" "+bb.height()+"\" xmlns=\"http://www.w3.org/2000/svg\">\n");
        for(Polygon p : polygons)
        {
            if(p!=null)
            {
                writer.write(p.toSvg()+"\n");
            }
        }
        writer.write("</svg>");
        writer.close();
    }

}
