package echo.dependencies;

public class SimpleMovieListener {
    private MovieFinder movieFinder;
    public SimpleMovieListener(){
        System.out.println("调用了SimpleMovieListener的构造方法");
    }
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    @Override
    public String toString() {
        return "SimpleMovieListener{" +
                "movieFinder=" + movieFinder +
                '}';
    }
}
