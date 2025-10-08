package collectionFrameworks.Sets.HashSet;

import java.util.HashSet;
import java.util.Set;

public class Explian {
    public static void main(String[] args) {
      Set<Integer> st = new HashSet<>();
      Set<Integer> st2 = new HashSet<>();

      for(int i = 0; i<=13; i++)
      {
        st.add(i);
        st2.add(i);
      };

      st2.add(20);

      System.out.println(st+"\n"+st2);

      //Union but for unique
      st.addAll(st2);

      System.out.println(st);

      st.remove(2);
      System.out.println(st);

      System.out.println(st);
    }
}
