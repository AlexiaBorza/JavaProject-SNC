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
        private String id;

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

        public Financial_Data(Long id, Integer year, Double cifraAfaceri, Double profitNet, Double activeTotale, Double datorii, Double capitaluriProprii, Double angajati, Double rentabilitate, Company company) {
            this.id = id;
            this.year = year;
            this.cifraAfaceri = cifraAfaceri;
            this.profitNet = profitNet;
            this.activeTotale = activeTotale;
            this.datorii = datorii;
            this.capitaluriProprii = capitaluriProprii;
            this.angajati = angajati;
            this.rentabilitate = rentabilitate;
            this.company = company;
        }
    }
