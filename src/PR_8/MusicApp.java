package PR_8;

import java.util.Objects;

public abstract class MusicApp {
    protected String name;
    protected int id;

    public MusicApp(String name, int id) {
        if (name == null || id < 0) throw new IllegalArgumentException("Неверное имя или идентификатор!");
        this.name = name;
        this.id = id;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return getInfo();
    }
}
