package com.ejavac;public class Pair<A,B> {

    public static <P, Q> Pair<P, Q> makePair(P p, Q q) {
        return new Pair<P, Q>(p, q);
    }

    public  A a;
    public  B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }
    
    public static <A, B> boolean compare(A a, B b)
    {
        if (a != null)
        {
            return a.equals(b);
        }
        else
        {
            return false;
        }
    }
    
    public String toString()
    {
        return "" + this.a + " " + this.b;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((a == null) ? 0 : a.hashCode());
        result = prime * result + ((b == null) ? 0 : b.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Pair other = (Pair) obj;
        if (a == null) {
            if (other.a != null) {
                return false;
            }
        } else if (!a.equals(other.a)) {
            return false;
        }
        if (b == null) {
            if (other.b != null) {
                return false;
            }
        } else if (!b.equals(other.b)) {
            return false;
        }
        return true;
    }
}
