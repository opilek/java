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
}
