package echo.dependencies;

import java.beans.ConstructorProperties;

public class ExampleBean {
    private int years;
    private String ultimateAnswer;
    private MovieFinder movieFinder;
    //使用构造函数参数名进行值消歧:使用@constructorproperties注解显式地命名构造函数参数
    @ConstructorProperties({"years","ultimateAnswer"})
    public ExampleBean(int years,String ultimateAnswer){
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }

    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    @Override
    public String toString() {
        return "ExampleBean{" +
                "years=" + years +
                ", ultimateAnswer='" + ultimateAnswer + '\'' +
                ", movieFinder=" + movieFinder +
                '}';
    }
}
