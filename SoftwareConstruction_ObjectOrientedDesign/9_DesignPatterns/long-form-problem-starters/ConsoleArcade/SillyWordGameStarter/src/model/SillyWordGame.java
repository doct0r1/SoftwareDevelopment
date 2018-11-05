package model;

import java.util.Iterator;
import java.util.List;

public class SillyWordGame implements Iterable<Phrase> {

    private List<Phrase> phrases;


    public SillyWordGame(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    //EFFECTS: returns all phrases in this game
    public List<Phrase> getAllPhrases() {
        return phrases;
    }

    @Override
    public Iterator<Phrase> iterator() {
        return new PhrasesNeedingWordsIterator();
    }

    private class PhrasesNeedingWordsIterator implements Iterator<Phrase> {

        private int numWordsNeeded;
        private Iterator<Phrase> phraseIterator;

        private PhrasesNeedingWordsIterator() {
            phraseIterator = phrases.iterator();
            calculateNumWordsNeeded();
        }

        @Override
        public boolean hasNext() {
            return numWordsNeeded > 0;
        }

        //EFFECTS: returns the next phrase needing a word
        @Override
        public Phrase next() {
            Phrase phrase =  phraseIterator.next();
            while (!phrase.needsWord()) {
                phrase = phraseIterator.next();
            }
            numWordsNeeded--;
            return phrase;
        }

        public void remove(){
            //This method does nothing!
        }

        //MODIFIES: this
        //EFFECTS: sets numWordsNeeded to the number of phrases that still need words
        private void calculateNumWordsNeeded() {
            while (phraseIterator.hasNext()) {
                if (phraseIterator.next().needsWord()) {
                    numWordsNeeded++;
                }
            }
        }
    }
}
