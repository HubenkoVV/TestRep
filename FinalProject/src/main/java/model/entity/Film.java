package model.entity;

import java.util.List;

public class Film {
    private int id;
    private String name;
    private int duration;
    private int year;
    private String genre;

    private List<Seance> seances;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

    public static final class FilmBuilder {
        private int id;
        private String name;
        private int duration;
        private int year;
        private String genre;
        private List<Seance> seances;

        public FilmBuilder buildId(int id) {
            this.id = id;
            return this;
        }

        public FilmBuilder buildName(String name) {
            this.name = name;
            return this;
        }

        public FilmBuilder buildDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public FilmBuilder buildYear(int year) {
            this.year = year;
            return this;
        }

        public FilmBuilder buildGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public FilmBuilder buildSeances(List<Seance> seances) {
            this.seances = seances;
            return this;
        }

        public Film build(){
            Film film = new Film();
            film.setName(name);
            film.setDuration(duration);
            film.setGenre(genre);
            film.setId(id);
            film.setYear(year);
            film.setSeances(seances);
            return film;
        }
    }
}
