package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.RWayTrie;
import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    static final int MIN_LENGTH = 3;
    private Trie trie;



    public PrefixMatches(Trie trie) {
        this.trie = trie;
    }

    public PrefixMatches() {
        this.trie = new RWayTrie();
    }


    // Формує in-memory словник слів. Метод може приймати слово, рядок,
    // масив слів/рядків. Якщо приходить рядок, то він має бути
    // розділений на окремі слова
    // (слова відокремлюються пробілами).
    // До словника мають додаватися лише слова довші за 2 символи.
    public int load(String... strings) {
        for (String string: strings) {
            String[] words = string.split("\\s");
            for (String word: words) {
                if (word.length() >= MIN_LENGTH) {
                    trie.add(new Tuple(word, word.length()));
                }
            }
        }
        return trie.size();
    }

    // Чи є слово у словнику
    public boolean contains(String word) {
        return trie.contains(word);
    }

    // Видаляє слово зі словника.
    public boolean delete(String word) {
        if (this.contains(word)) {
            trie.delete(word);
            return true;
        }
        return false;
    }

    // Якщо pref довший або дорівнює 2ом символам,то повертається набір слів k
    // різних довжин (починаючи з довжини префіксу або 3
    // якщо префікс містить дві літери)
    // і які починаються з даного префіксу pref.
    // Приклад: задані наступні слова та їх довжини:
    // abc 3
    // abcd 4
    // abce 4
    // abcde 5
    // abcdef 6
    // Вказано префікс pref='abc',
    // - при k=1 повертається 'abc'
    // - при k=2 повертається 'abc', 'abcd', 'abce'
    // - при k=3 повертається 'abc', 'abcd', 'abce', 'abcde'
    // - при k=4 повертається 'abc', 'abcd', 'abce', 'abcde', 'abcdef'
    public Iterable<String> wordsWithPrefix(String pref, int k) {
        if (pref.length() < 2) {
            throw new IllegalArgumentException("Prefix should be" +
                    " longer than 1");
        }
        int len = MIN_LENGTH;
        ArrayList<String> wordsWithPrefix = new ArrayList<>();

        if (pref.length() > 2) {
            len = pref.length();
        }
        Iterable<String> words = trie.wordsWithPrefix(pref);
        for (String word: words) {
            if (word.length() < len + k) {
                wordsWithPrefix.add(word);
            }
        }
        return wordsWithPrefix;
    }

    // Якщо pref довший або дорівнює 2ом символам, то повертається
    // усі слова які починаються з даного префіксу.
    public Iterable<String> wordsWithPrefix(String pref) {
        if (pref.length() >= 2) {
            return trie.wordsWithPrefix(pref);
        }
        throw new IllegalArgumentException("Prefix should be longer than 1");
    }

    // Кількість слів у словнику
    public int size() {
        return trie.size();
    }
}
