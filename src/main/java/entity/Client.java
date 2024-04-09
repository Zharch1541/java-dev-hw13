package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
    @Table(name = "client")
    @Entity
    public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column
        private String name;

        @OneToMany(mappedBy ="client", cascade = CascadeType.ALL)
        private List<Ticket> tickets = new ArrayList<>();

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public String toString() {
            return "Client{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
