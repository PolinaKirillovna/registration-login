package entitities;

public enum Color {
    WHITE("white"),
    GINGER("ginger"),
    BROWN("brown"),
    GREY("grey"),
    BLACK("black");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
