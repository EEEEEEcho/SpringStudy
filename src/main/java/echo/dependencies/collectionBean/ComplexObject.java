package echo.dependencies.collectionBean;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComplexObject {
    private List<String> someList;
    private Map<String,String> someMap;
    private Set<String> someSet;

    public List<String> getSomeList() {
        return someList;
    }

    public void setSomeList(List<String> someList) {
        this.someList = someList;
    }

    public Map<String, String> getSomeMap() {
        return someMap;
    }

    public void setSomeMap(Map<String, String> someMap) {
        this.someMap = someMap;
    }

    public Set<String> getSomeSet() {
        return someSet;
    }

    public void setSomeSet(Set<String> someSet) {
        this.someSet = someSet;
    }

    @Override
    public String toString() {
        return "ComplexObject{" +
                "someList=" + someList +
                ", someMap=" + someMap +
                ", someSet=" + someSet +
                '}';
    }
}
