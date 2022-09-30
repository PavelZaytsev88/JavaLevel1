package Lesson6;

public abstract class Animal  {
    String name;
    String color;
    float age;

    public abstract boolean run(float distance);
    public abstract boolean swim(float distance);
    public abstract boolean jump(float height);
}
