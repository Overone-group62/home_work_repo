public class Movie {
    String title;
    String genre;
    int rating;
    void playIt(String title, String genre, int rating ){
        System.out.println("Проигрывание фильма "+ title+ " "+ genre+ " с рейтингом "+rating);
    }
}
