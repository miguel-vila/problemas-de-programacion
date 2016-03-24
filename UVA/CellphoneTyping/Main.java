package CellphoneTyping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;

class TrieNode {
    char c;
    HashMap<Character,TrieNode> children;
    public TrieNode(char c) {
        this.c = c;
        this.children = new HashMap();
    }

    void insertWord(String word) {
        if(word.length()>0) {
            char head = word.charAt(0);
            String tail = word.substring(1);
            if(!children.containsKey(head)) {
                TrieNode node = new TrieNode(head);
                node.insertWord(tail);
                children.put(head, node);
            } else {
                children.get(head).insertWord(tail);
            }
        }
    }

    public String toString() {
        String chil = "";
        for(Character c: children.keySet()) {
            TrieNode node = children.get(c);
            chil += c + " -> " + node.toString() + "\n";
        }
        return "Trie(char = "+c+", children ("+ children.size() +") : \n { " + chil + " } )";
    }

    static int presses(TrieNode root, String word) {
        String _word = word + '*';
        TrieNode node = root;
        int presses = 0;
        for (int i = 0; i < _word.length();) {
            //System.out.println("i = "+i);
            int children = node.children.size();
            if(children == 1 && node.c != '*') {
                while(node.children.size() == 1 && i < _word.length()) {
                    char c = _word.charAt(i);
                    node = node.children.get(c);
                    i++;
                }
                //System.out.println("not pressed");
            } else {
                char c = _word.charAt(i);
                if(c!='*'){
                    presses++;
                }
                node = node.children.get(c);
                //System.out.println("pressed");
                i++;
            }
         }
        return presses;
    }

    public static TrieNode CreateFromDictionary(String[] dictionary) {
        TrieNode root = new TrieNode('*');
        for(String word: dictionary) {
            root.insertWord(word+'*');
        }
        //System.out.println(root);
        return root;
    }

    public static void averagePresses(String[] dictionary) {
        DecimalFormat df = new DecimalFormat(".##");
        df.setMinimumFractionDigits(2);
        TrieNode root = CreateFromDictionary(dictionary);
        double avg = 0;
        for(String word: dictionary) {
            int presses = presses(root, word);
            //System.out.println("presses  for " + word + "= "+presses);
            avg += presses;
        }
        avg /= dictionary.length;
        System.out.println(df.format(avg));
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        /*
        String[] dict1 = new String[]{"hello","hell","heaven","goodbye"};
        String[] dict2 = new String[]{"he","hi","h"};
        String[] dict3 = new String[]{"structure" ,
                "structures" ,
                "ride" ,
                "riders" ,
                "stress" ,
                "solstice" ,
                "ridiculous"};
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while(line!=null) {
            int n = Integer.parseInt(line);
            String[] dict = new String[n];
            for (int i = 0; i < n; i++) {
                line = br.readLine();
                dict[i] = line.trim();
            }
            TrieNode.averagePresses(dict);
            line = br.readLine();
        }
        br.close();
    }

}
