package pl.sda.javagdy2.database.model;

public enum Usluga {

    WYMIANA_OPON ("Wymiana opon"),
    WYMIANA_OLEJU ("Wymiana Oleju"),
    NAPRAWA_SILNIKA ("Naprawa Silnika"),
    WYMIANA_KLOCKOW ("Wymiana Klocków"),
    WYMIANA_FILTROW ("Wymiana filtrów"),
    SERWIS ("Serwis roczny auta");

    private String opis;

    Usluga(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }
}
