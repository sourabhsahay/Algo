import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class DecomposeIntoDictionaryWords {

    List<String > decompose (String domain, Set<String> dictionary) {
        int[] lastLength = new int[domain.length()];
        for (int i = 0; i < domain.length(); i++) {
            if (dictionary.contains(domain.substring(0, i + 1))) {
                lastLength[i] = i + 1;
            }

            if (lastLength[i] == -1) {
                for (int j = 0; j < i; j++) {
                    if (lastLength[j] != -1 && dictionary.contains(domain.substring(j + 1, i))) {
                        lastLength[i] = i - j;
                    }
                }
            }
        }
        List<String> decompositions = new ArrayList<>();
        int index = domain.length() -1;
        while (index >=0)
        {
            decompositions.add(domain.substring(index +1 - lastLength[index], lastLength[index]));
            index-= lastLength[index];
        }
        Collections.reverse(decompositions);
        return decompositions;
    }




}
