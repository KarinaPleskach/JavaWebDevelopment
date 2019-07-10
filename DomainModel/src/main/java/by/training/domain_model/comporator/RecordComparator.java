package by.training.domain_model.comporator;

import by.training.domain_model.entity.Composition;
import by.training.domain_model.entity.Record;
import by.training.domain_model.entity.Song;

import java.util.Comparator;

public enum RecordComparator implements Comparator<Record> {

    PERFORMER_TITLE_SORT {
        public int compare(Record o1, Record o2) {
            if ((o1 instanceof Composition) && (o2 instanceof Composition)) {
                Composition c1 = (Composition) o1;
                Composition c2 = (Composition) o2;
                return c1.getPerformer().getPerformer().compareTo(c2.getPerformer().getPerformer());
            } else if (o1 instanceof Composition) {
                return -1;
            } else if (o2 instanceof Composition) {
                return 1;
            } else {
                return 0;
            }
        }},
    DURATION_SORT {
        public int compare(Record o1, Record o2) {
            int seconds1 = o1.getDuration().getMinutes()*60 + o1.getDuration().getSeconds();
            int seconds2 = o2.getDuration().getMinutes()*60 + o2.getDuration().getSeconds();
            if (seconds1 > seconds2) {
                return 1 ;
            } else if (seconds1 < seconds2) {
                return - 1 ;
            } else {
                return 0 ;
            }
        }},
    TIMBRE_SORT {
        public int compare(Record o1, Record o2) {
            if ((o1 instanceof Song) && (o2 instanceof Song)) {
                Song s1 = (Song) o1;
                Song s2 = (Song) o2;
                return s1.getTimbre().name().compareTo(s2.getTimbre().name());
            } else if (o1 instanceof Song) {
                return -1;
            } else if (o2 instanceof Song) {
                return 1;
            } else {
                return 0;
            }
        }},
    STYLE_SORT {
        public int compare(Record o1, Record o2) {
            if ((o1 instanceof Composition) && (o2 instanceof Composition)) {
                Composition c1 = (Composition) o1;
                Composition c2 = (Composition) o2;
                return c1.getStyle().name().compareTo(c2.getStyle().name());
            } else if (o1 instanceof Composition) {
                return -1;
            } else if (o2 instanceof Composition) {
                return 1;
            } else {
                return 0;
            }
        }},
    SONG_NAME_SORT {
        public int compare(Record o1, Record o2) {
            return o1.getSongName().compareTo(o2.getSongName());
        }};

    public static Comparator<Record> descending(final Comparator<Record> other) {
        return new Comparator<Record>() {
            public int compare(Record o1, Record o2) {
                return -1 * other.compare(o1, o2);
            }
        };
    }

    public static Comparator<Record> ascending(final Comparator<Record> other) {
        return new Comparator<Record>() {
            public int compare(Record o1, Record o2) {
                return other.compare(o1, o2);
            }
        };
    }

    public static Comparator<Record> getComparator(final RecordComparator... multipleOptions) {
        return new Comparator<Record>() {
            public int compare(Record o1, Record o2) {
                for (RecordComparator option : multipleOptions) {
                    int result = option.compare(o1, o2);
                    if (result != 0) {
                        return result;
                    }
                }
                return 0;
            }
        };
    }

}