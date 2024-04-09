package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
    @Table(name = "planet")
    @Entity
    public class Planet {
        @Id
        private String id;
        @Column
        private String name;
        @OneToMany(mappedBy = "planet", cascade = CascadeType.ALL)
        private List<Ticket> tickets = new ArrayList<>();

        public String getId() {
            return id;
        }

        public void setId(String id) {
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
            return "Planet{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
