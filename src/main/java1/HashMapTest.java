package main.java1;

import java.util.HashMap;
import java.util.Map;


public class HashMapTest {
    int a= 100;
    public static void main(String[] args) throws Exception {


        /*Map<Test,String> map = new HashMap<>();
        Test obj = new Test();
        obj.var ="1";
        obj.var2 ="1";
        Test obj1 = new Test();
        obj1.var ="1";
        obj1.var2 ="1";

        map.put(obj,"b");
        map.put(obj1,"c");
        System.out.println(map);

        int a1 =1000;
        int a2 = fix(a1);


        System.out.println(a1+" "+a2);

        int a = 200;
        System.out.println(a);


        long a3[] = {3,4,7};
        long a4[]= fix(a3);

        System.out.println(a3[0]+a3[1]+a3[2]);
        System.out.println(a4[0]+a4[1]+a4[2]);


        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = true;

        if(b1 & b2 | b2 & b3 | b2){

            System.out.println("ok");
        }
        if(b1 & b2 | b2 & b3 | b2 |b1){

            System.out.println("yes");
        }
*/
    }

    static int fix(int a){
        a=2000;
        //throw  new Error();
        return a;
        
    }

    static long[] fix(long[] a){
        a[1]=7;
        //throw  new Error();
        return a;

    }

    static class Test {
        public  String var;
        public  String var2;

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Test test = (Test) o;

            if (var != null ? !var.equals(test.var) : test.var != null)
                return false;
            return var2 != null ? var2.equals(test.var2) : test.var2 == null;
        }

        @Override
        public int hashCode() {
            int result = var != null ? var.hashCode() : 0;
            result = 31 * result + (var2 != null ? var2.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Test{" + "var='" + var + '\'' + ", var2='" + var2 + '\'' + '}';
        }
    }


}

class Foo
{
    class Bar{ }
}
class Pack
{
    public static void main (String [] args)
    {
        Foo f = new Foo();
        Foo.Bar b = f.new Bar();

    }
}

