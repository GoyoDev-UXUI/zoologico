import java.util.ArrayList;
import java.util.List;

public interface Animal {
    void hacerRuido();
    void moverse();
    int getEdad();
    String getNombre();
}

abstract class AnimalBase implements Animal {
    private String nombre;
    private int edad;

    public AnimalBase(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}

class Leon extends AnimalBase {
    public Leon(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerRuido() {
        System.out.println("El león ruge");
    }

    @Override
    public void moverse() {
        System.out.println("El león se mueve");
    }
}

class Elefante extends AnimalBase {
    public Elefante(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerRuido() {
        System.out.println("El elefante barrita");
    }

    @Override
    public void moverse() {
        System.out.println("El elefante se mueve");
    }
}

class Pajaro extends AnimalBase {
    public Pajaro(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerRuido() {
        System.out.println("El pájaro canta");
    }

    @Override
    public void moverse() {
        System.out.println("El pájaro vuela");
    }
}

class Zoologico {
    private List<Animal> animales;

    public Zoologico() {
        this.animales = new ArrayList<>();
    }

    public void añadirAnimal(Animal animal) {
        animales.add(animal);
    }

    public void mostrarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales en el zoológico.");
            return;
        }

        for (Animal animal : animales) {
            System.out.println("Tipo de animal: " + animal.getClass().getSimpleName());
            System.out.println("Nombre: " + animal.getNombre());
            System.out.println("Edad: " + animal.getEdad());
            animal.hacerRuido();
            animal.moverse();
            System.out.println();
        }
    }
}
