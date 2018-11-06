package model;

import model.media.AbstractMedia;
import model.media.Movie;
import model.media.Photo;
import model.media.Song;

import java.util.*;

public class iPod implements Iterable<AbstractMedia> {

    private String name;
    private Set<AbstractMedia> movies = new HashSet<>();
    private Set<AbstractMedia> photos = new HashSet<>();
    private Collection<AbstractMedia> songs = new HashSet<>();

    public iPod(String name) {
        this.name = name;
    }

    // getters
    public String getName() { return name; }

    /**
     *
     * @param movie the movie we add into the set
     */
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addphoto(Photo photo) {
        photos.add(photo);
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public Iterator<AbstractMedia> iterator() {
        return new AbstractMediaIterator();
    }

    private class AbstractMediaIterator implements Iterator<AbstractMedia> {

        Iterator movieIterator = movies.iterator();
        Iterator photoIterator = photos.iterator();
        Iterator songIterator  =  songs.iterator();

        @Override
        public boolean hasNext() {
            return movieIterator.hasNext() || photoIterator.hasNext() || songIterator.hasNext();
        }

        @Override
        public AbstractMedia next() {
            AbstractMedia media = null;
            if (movieIterator.hasNext()) {
                media = (Movie) movieIterator.next();
            } else if (photoIterator.hasNext()) {
                media = (Photo) photoIterator.next();
            } else if (songIterator.hasNext()) {
                media = (Song) songIterator.next();
            }

            return media;
        }
    }
}