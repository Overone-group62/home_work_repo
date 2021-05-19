public class MovieTestDrive {
    public static void main(String[] args) {
        Movie one = new Movie();
        one.title = "Как прогореть на акциях";
        one.genre = "Трагедия";
        one.rating= -2;

        Movie two = new Movie();
        two.title = "Потерянный в Офисе";
        two.genre = "Комедия";
        two.rating= 5;

        Movie three = new Movie();
        three.title = "Байт-Клуб";
        three.genre = "Трагедия, но в целом веселая";
        three.rating= 127;

        one.playIt(one.title, one.genre, one.rating);
        two.playIt(two.title, two.genre, two.rating);
        three.playIt(three.title, three.genre, three.rating);

    }
}
