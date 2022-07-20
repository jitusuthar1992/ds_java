package main.systemdesign.countminsketch;

public class HashFunction {

    private long prime;
    private long odd;
    private int LIMIT;

    public HashFunction(final long prime, final long odd, final int LIMIT) {
        this.prime = prime;
        this.odd = odd;
        this.LIMIT = LIMIT;
    }

    public int getHashValue(final Character character) {
        int hash = character.hashCode();
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return calculateHash(hash, prime, odd);
    }

    private int calculateHash(final int hash, final long prime, final long odd) {
        return (int) ((((hash % LIMIT) * prime) % LIMIT) * odd) % LIMIT;
    }

}
