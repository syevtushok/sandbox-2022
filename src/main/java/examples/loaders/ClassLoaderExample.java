package examples.loaders;

import lombok.SneakyThrows;

public class ClassLoaderExample {
    @SneakyThrows
    public static void main(String[] args) {
        Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("examples.loaders.ClassLoaderExample");
        System.out.println(aClass);
    }
}
