package PR_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class PR_5 {
    record Phone(String model, int storage, double price){
        public double getPricePerGB(){
            return price / storage;
        }
    };

    public static void main(String[] args) {
        Phone[] phones = {
                new Phone("Iphone", 512, 180000),
                new Phone("Samsung", 128, 80000),
                new Phone("Vivo", 256, 75000),
                new Phone("Honor", 256, 80000),
                new Phone("Tecno", 128, 15000)
        };

        Comparator<Phone> pricePerGB = (phone1, phone2) -> Double.compare(phone1.getPricePerGB(),
                phone2.getPricePerGB());
        Consumer<Phone> printer = x -> System.out.printf("Model: %s%nStorage: %d GB%nPrice: %.2f%nPrice/GB: %.2f%n",
                x.model, x.storage, x.price, x.getPricePerGB()
        );

        System.out.println("Три лучших телефона по цене за ГБ: ");
        Arrays.stream(phones).sorted(pricePerGB).limit(3).forEach(printer);
    }
}