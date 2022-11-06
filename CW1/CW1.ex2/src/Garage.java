
import java.util.*;

public class Garage {

    public Garage(int maxAmount){
        this.maxAmount = maxAmount;
        this.curAmount = 0;
        this.cars = new HashMap<Class, ArrayList<Car>>();
    }

    private int maxAmount;
    private int curAmount;
    private HashMap<Class, ArrayList<Car>> cars;

    public int getMaxAmount() {
        return maxAmount;
    }

    public int getCurAmount(){
        return curAmount;
    }


    public void addCar(Car car){
        if(curAmount < maxAmount){
            curAmount += 1;
            Class carClass = car.getClass();

            if(cars.containsKey(carClass)){
                cars.get(carClass).add(car);
            } else {
                cars.put(carClass, new ArrayList<Car>());
                cars.get(carClass).add(car);
            }
            System.out.printf("%s добавлена.\n", carClass.getName());
        } else {
            System.out.println("Гараж полон.");
        }
    }
    // сортировка
    public void getCars(String sortBy){
        if(sortBy.equalsIgnoreCase("Количество")){
            System.out.println("Сортировка по количеству:");

            ArrayList list = new ArrayList(cars.entrySet());
            list.sort((Comparator<Map.Entry<Class, ArrayList<Car>>>) (a, b) -> b.getValue().size() - a.getValue().size());
            list.forEach(item -> {
                Map.Entry<Class, ArrayList<Car>> i = (Map.Entry<Class, ArrayList<Car>>) item;
                System.out.println(i.getKey().getName() + " : Количество = " + i.getValue().size());
            });
        }
        else if(sortBy.equalsIgnoreCase("Цена")){
            System.out.println("Сортировка по цене:");

            ArrayList list = new ArrayList(cars.entrySet());
            list.sort((Comparator<Map.Entry<Class, ArrayList<Car>>>) (a, b) -> b.getValue().get(0).getPrice() - a.getValue().get(0).getPrice());
            list.forEach(item -> {
                Map.Entry<Class, ArrayList<Car>> i = (Map.Entry<Class, ArrayList<Car>>) item;
                System.out.println(i.getKey().getName() + " : Цена = " + i.getValue().get(0).getPrice());
            });
        }
        else{
            System.out.println("Некорректный атрибут: " + sortBy);
        }
    }
}
