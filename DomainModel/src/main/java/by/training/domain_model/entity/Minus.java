package by.training.domain_model.entity;

import by.training.domain_model.entity.music.Duration;
import by.training.domain_model.entity.music.Styles;
import by.training.domain_model.entity.performer.Performer;

public class Minus extends Composition {

    public Minus(String songName, Duration duration, Performer performer, Styles style) {
        super(songName, duration, performer, style);
    }

    @Override
    public String toString() {
        return "Minus " +
                getSongName() +
                getDuration() +
                getPerformer() +
                " " + getStyle() + "\n";
    }


}
