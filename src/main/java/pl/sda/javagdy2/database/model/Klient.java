package pl.sda.javagdy2.database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Klient implements IBaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imie;
    private String nazwisko;
    private int iloscSamochodow;
    private boolean czyDajeNapiwki;
    private int ocenaKlienta;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "klient")
    private List<Zlecenie> zlecenieList;
}
