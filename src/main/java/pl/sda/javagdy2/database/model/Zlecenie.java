package pl.sda.javagdy2.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Zlecenie implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Enumerated(EnumType.STRING)
    private Usluga usluga;

    private double cena;

    @ManyToOne()
    private Klient klient;

    @CreationTimestamp
    private LocalDateTime dataDodania;

    public Zlecenie(Usluga usluga, double cena) {
        this.usluga = usluga;
        this.cena = cena;
    }
}
