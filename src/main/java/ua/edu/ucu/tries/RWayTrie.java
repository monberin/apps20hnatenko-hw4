package ua.edu.ucu.tries;
import ua.edu.ucu.immutable.Queue;

public class RWayTrie implements Trie {
    private static final int R = 256;
    private Node root = new Node();
    private int size = 0;
    // radix
    // root of trie
    //page 737
    private static class Node
    {
        private Object val;
        private Node[] next = new Node[R];
    }

    private Node get(Node x, String key, int d)
    { // Return node associated with key in the subtrie rooted at x.
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        return get(x.next[c], key, d+1);
    }

    private Node put(Node x, String key, Object val, int d)
    { // Change value associated with key if in subtrie rooted at x.
        if (x == null) x = new Node();
        if (d == key.length()) { x.val = val; return x; }
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }

    // page 741
    private Node delete(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }
        if (x.val != null) {
            return x;
        }
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) {
                return x;
            }
        }
        return null;
    }

    // page 738
    private void collect(Node x, String pre,Queue q){
        if (x == null) return;
        if (x.val != null) {
            q.enqueue(pre);
        }
        for (char c = 0; c < R; c++){
            collect(x.next[c], pre + c, q);
        }
    }


    // Додає в Trie кортеж - Tuple: слово - term, і його вагу - weight.
    // У якості ваги, використовуйте довжину слова
    @Override
    public void add(Tuple t) {
        root = put(root, t.term, t.weight, 0);
        size+=1;
    }

    // Чи є слово в Trie
    @Override
    public boolean contains(String word) {
        Node finalNode = get(root,word,0);
        return finalNode != null && finalNode.val != null;
    }

    // Видаляє слово з Trie
    @Override
    public boolean delete(String word) {
        if (this.contains(word)) {
            root = delete(root, word, 0);
            size -= 1;
            return true;
        }
        return false;
    }

    // Ітератор по всім словам (обхід дерева в ширину)
    @Override
    public Iterable<String> words() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Ітератор по всім словам, які починаються з pref
    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Кількість слів в Trie
    @Override
    public int size() {
        return size;
    }

}
