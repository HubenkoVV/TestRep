package ua.training.Memento;

public class MementoApp {
    public static void main(String[] args) {
        Game game = new Game();
        game.set("FIRST", 1234);
        System.out.println(game.toString());

        File file = new File();
        file.setSave(game.createSave());

        game.set("SECOND", 14222);
        System.out.println(game.toString());

        game.setSave(file.getSave());
        System.out.println(game.toString());



    }
}

class Game{
    private String level;
    private int ms;
    void set(String level, int ms){
        this.level = level;
        this.ms = ms;
    }

    Save createSave(){
        return new Save(level, ms);
    }
    public void setSave(Save save){
        level = save.getLevel();
        ms = save.getMs();
    }

    @Override
    public String toString() {
        return "Game{" +
                "level='" + level + '\'' +
                ", ms=" + ms +
                '}';
    }
}

class Save{
    private final String level;
    private final int ms;
    Save(String level, int ms){
        this.level = level;
        this.ms = ms;
    }

    String getLevel() {
        return level;
    }

    int getMs() {
        return ms;
    }
}

class File{
    private Save save;

    public Save getSave() {
        return save;
    }

    void setSave(Save save) {
        this.save = save;
    }
}