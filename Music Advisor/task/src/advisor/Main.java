package advisor;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        NewReleases newReleases = new NewReleases();
        newReleases.addNewReleases("Mountains [Sia, Diplo, Labrinth]");
        newReleases.addNewReleases("Runaway [Lil Peep]");
        newReleases.addNewReleases("The Greatest Show [Panic! At The Disco]");
        newReleases.addNewReleases("All Out Life [Slipknot]");

        Featured featured = new Featured();
        featured.addFeatured("Mellow Morning");
        featured.addFeatured("Wake Up and Smell the Coffee");
        featured.addFeatured("Monday Motivation");
        featured.addFeatured("Songs to Sing in the Shower");

        Categories categories = new Categories();
        categories.addCategory("Top List");
        categories.addCategory("Pop");
        categories.addCategory("Mood");
        categories.addCategory("Latin");

        Playlists playlists = new Playlists();
        playlists.addPlaylist("Walk Like A Badass");
        playlists.addPlaylist("Rage Beats");
        playlists.addPlaylist("Arab Mood Booster");
        playlists.addPlaylist("Sunday Stroll");


        MusicLibrary musicLibrary = new MusicLibrary(newReleases, featured, categories, playlists);
        UserInteraction userInteraction = new UserInteraction(musicLibrary);
        userInteraction.menu();


    }
}

class UserInteraction {

    MusicLibrary musicLibrary;

    UserInteraction(MusicLibrary musicLibrary) {
        this.musicLibrary = musicLibrary;

    }

    void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean isActionZero = false;


        while (!isActionZero) {
            String[] action = scanner.nextLine().split(" ");

            switch (action[0]) {
                case "new": {
                    showNewReleases(action[0]);
                    break;
                }
                case "featured": {
                    showFeatured(action[0]);
                    break;
                }
                case "categories": {
                    showCategories(action[0]);
                    break;
                }
                case "playlists": {
                    String input = (action[0] + " " + action[1]);
                    showPlaylists(input);
                    break;
                }
                case "exit": {
                    System.out.println("---GOODBYE!---");
                    isActionZero = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect command!");
                }
            }
        }

    }

    void showNewReleases(String input) {
        System.out.println("---NEW RELEASES---");
        for (String release : musicLibrary.getEntity(input)) {
            System.out.println(release);
        }


    }

    void showFeatured(String input) {
        System.out.println("---FEATURED---");
        for (String feature : musicLibrary.getEntity(input)) {
            System.out.println(feature);
        }
    }

    void showCategories(String input) {
        System.out.println("---CATEGORIES---");
        for (String category : musicLibrary.getEntity(input)) {
            System.out.println(category);
        }

    }

    void showPlaylists(String input) {
        String[] config = input.split(" ");
        String formattedString = String.format("---%s PLAYLISTS---", config[1].toUpperCase());
        System.out.println(formattedString);

        for (String playlist : musicLibrary.getEntity(config[0])) {
            System.out.println(playlist);
        }

    }


}

class MusicLibrary {

    NewReleases newReleases;
    Featured featured;
    Categories categories;
    Playlists playlists;

    MusicLibrary(NewReleases newReleases, Featured featured, Categories categories, Playlists playlists) {
        this.newReleases = newReleases;
        this.featured = featured;
        this.categories = categories;
        this.playlists = playlists;

    }


    List<String> getEntity(String input) {
        if (input.equalsIgnoreCase("new")) {
            return newReleases.getNewReleases();
        } else if (input.equalsIgnoreCase("featured")) {
            return featured.getFeatured();
        } else if (input.equalsIgnoreCase("categories")) {
            return categories.getCategories();
        } else if (input.equalsIgnoreCase("playlists")) {
            return playlists.getPlaylists();
        } else {
            return null;
        }
    }

}

class NewReleases {

    List<String> newReleases;

    NewReleases() {
        this.newReleases = new ArrayList<>();
    }

    List<String> addNewReleases(String release) {
        newReleases.add(release);

        return newReleases;
    }

    public List<String> getNewReleases() {
        return newReleases;
    }
}

class Featured {

    List<String> featured;

    Featured() {
        this.featured = new ArrayList<>();
    }

    List<String> addFeatured(String feature) {
        featured.add(feature);

        return featured;
    }

    public List<String> getFeatured() {
        return featured;
    }
}

class Categories {

    List<String> categories;

    Categories() {
        this.categories = new ArrayList<>();
    }

    List<String> addCategory(String category) {
        categories.add(category);

        return categories;
    }

    public List<String> getCategories() {
        return categories;
    }
}

class Playlists {

    List<String> playlists;

    Playlists() {
        this.playlists = new ArrayList<>();
    }

    List<String> addPlaylist(String playlist) {
        playlists.add(playlist);

        return playlists;
    }

    public List<String> getPlaylists() {
        return playlists;
    }
}


