package ru.zychkov.web.compositeentity.example1;

public class CompositeEntityMain {

    public static void main(String[] args) {
        CompositeEntity compositeEntity = new CompositeEntity();

        for (String s : compositeEntity.getData()) {
            System.out.println(s);
        }
    }
}

class DependentObject1 {
    String getData() {
        return "one";
    }
}

class DependentObject2 {
    String getData() {
        return "two";
    }
}

class CoarseGainedObject {

    private DependentObject1 dependentObject1 = new DependentObject1();
    private DependentObject2 dependentObject2 = new DependentObject2();

    public String[] getData() {
        return new String[] {dependentObject1.getData(), dependentObject2.getData()};
    }
}

class CompositeEntity {
    private CoarseGainedObject coarseGainedObject = new CoarseGainedObject();

    public String[] getData() {
        return coarseGainedObject.getData();
    }
}