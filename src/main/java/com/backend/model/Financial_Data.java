package com.backend.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Financial_Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;
    private Double cifraAfaceri;
    private Double profitNet;
    private Double activeTotale;
    private Double datorii;
    private Double capitaluriProprii;
    private Double angajati;
    private Double rentabilitate;

    @ManyToOne
    @JoinColumn(name = "company_cui")
    private Company company;

}
