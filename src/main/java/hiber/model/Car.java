package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Component
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne(mappedBy = "car")
    private User user;
    @Autowired
    public Car() {
    }
    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
    public String getModel() { return model; }

    public Integer getSeries() { return series;  }
}