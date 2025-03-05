public class Polygon {
    //Tablica obiektów Point
    private final Point[] vertices; //wierzchołki


    //Konstruktor
    public Polygon(Point[] vertices) {
        this.vertices = new Point[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    @Override
    // Metoda toString
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Point p : vertices) {
            s.append(p.getX()).append(",").append(p.getY()).append(" ");
        }

        return s.toString().trim();
    }


    public String toSvg()
    {
        return "<polygon points=\"" + this +"\" style=\"fill:none;stroke:red;stroke-width:3\" />";
    }




}


