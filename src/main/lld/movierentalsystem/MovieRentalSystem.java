package main.lld.movierentalsystem;


import java.util.*;

public class MovieRentalSystem {

    HashMap<String,Movie> map;
    SortedSet<Movie> rented;
    Map<Integer,SortedSet<Movie>> unrented;

    public MovieRentalSystem(int n, int[][] entries) {
        this.map = new HashMap<>();
        this.rented = new TreeSet<>();
        this.unrented = new HashMap<>();
        for(int entry[] : entries){
            Movie movie = new Movie(entry[0], entry[1], entry[2]);
            if(unrented.containsKey(movie.mov)){
                SortedSet<Movie> unrent = unrented.get(movie.mov);
                unrent.add(movie);
            }else{
                SortedSet<Movie> unrent =new TreeSet<>();
                unrent.add(movie);
                unrented.put(movie.mov,unrent);
            }
            map.put(entry[0]+":"+entry[1], movie);
        }
    }

    class Movie implements Comparable<Movie> {

        int mov;

        int shop;
        int price;

        public Movie(int mov, int shop, int price) {
            this.mov = mov;
            this.shop = shop;
            this.price = price;
        }

        @Override
        public int compareTo( Movie m) {
            if(this.price == m.price && this.shop == m.shop)
                return this.mov - m.mov;
            if(this.price == m.price)
                return this.shop - m.shop;
            return this.price - m.price;
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>();
        int count = 5;
        if(!unrented.containsKey(movie)) return ans;
        SortedSet<Movie> unrent = unrented.get(movie);
        for(Movie mov : unrent){
            count--;
            ans.add(mov.shop);
            if(count == 0)
                return ans;
        }
        return ans;
    }
    public void rent(int shop, int movie) {
        unrented.get(movie).remove(map.get(shop+":"+movie));
        rented.add(map.get(shop+":"+movie));
    }

    public void drop(int shop, int movie) {
        rented.remove(map.get(shop+":"+movie));
        SortedSet<Movie> unrent = unrented.get(movie);
        unrent.add(map.get(shop+":"+movie));
    }

    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>();
        int count = 5;
        for(Movie movie : rented){
            count--;
            ans.add(new ArrayList<>(Arrays.asList(
                    movie.shop, movie.mov)));
            if(count == 0)
                return ans;
        }
        return ans;
    }


}
