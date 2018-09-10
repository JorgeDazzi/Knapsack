import java.util.ArrayList;
import java.util.List;


public class Main {


    List<Nods> prods;

    /**
     * https://en.wikipedia.org/wiki/Knapsack_problem
     */
    public Nods getUserRecom(int[] p, int[] v, int budget) {

        prods = new ArrayList<>();

//        int[] p = {1, 2, 3};//price
//        int[] v = {3, 2, 1};//value
//        int budget = 3;

        Nods aux;
        Nods last = new Nods();

        // Empty
            aux = new Nods();
            prods.add(aux);


        for(int i = 0; i < v.length; i++){

            aux = new Nods();
                aux.price = p[i];
                aux.value = v[i];
                aux.index = ""+1;
            prods.add(aux);

        }

        for(int i = 0; i < v.length; i++){

            last.price += p[i];
            last.value += v[i];
            last.index += i+" ";

            for(int j = 1; j < v.length; j++){


                if((j+i) < v.length) {
                    aux = new Nods();
                        aux.price = p[i] + p[j + i];
                        aux.value = v[i] + v[j + i];
                        aux.index = i+" "+(j+i);
                    prods.add(aux);
                }
            }

        }

        prods.add(last);

        for(int i = prods.size() -1 ; i >= 0; i--){

            if(prods.get(i).price == budget)
                return prods.get(i);

        }

    /*
           0 - []
           1 - [a] 1,3
           2 - [b] 2,2
           3 - [c] 3,1
           4 - [a,b] 3,5 <
           5 - [a,c] 4,4
           6 - [b,c] 5,3
           7 - [a,b,c] 6,6
     */

        return prods.get(0);
    }








    public static void main(String[] args) {

        Main m = new Main();

        int[] p = {1, 2, 3};//price
        int[] v = {3, 2, 1};//value

        Nods res = m.getUserRecom(p, v,3);

        System.out.println(res.index);
        System.out.println(res.price);
        System.out.println(res.value);

        System.exit(0);

    }
}
