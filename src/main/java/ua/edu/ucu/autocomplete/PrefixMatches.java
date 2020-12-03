package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;



    public PrefixMatches(Trie trie) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    // Формує in-memory словник слів. Метод може приймати слово, рядок,
    // масив слів/рядків. Якщо приходить рядок, то він має бути розділений на окремі слова
    // (слова відокремлюються пробілами).
    // До словника мають додаватися лише слова довші за 2 символи.
    public int load(String... strings) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

    // Чи є слово у словнику
    public boolean contains(String word) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Видаляє слово зі словника.
    public boolean delete(String word) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Якщо pref довший або дорівнює 2ом символам, то повертається набір слів k
    // різних довжин (починаючи з довжини префіксу або 3 якщо префікс містить дві літери)
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
    public Iterable<String> wordsWithPrefix(String pref) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

    // Якщо pref довший або дорівнює 2ом символам, то повертається усі слова які починаються з даного префіксу.
    public Iterable<String> wordsWithPrefix(String pref, int k) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

    // Кількість слів у словнику

    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
