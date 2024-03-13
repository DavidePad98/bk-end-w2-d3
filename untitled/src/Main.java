import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product p1 = new Product(1, "libro1", "Books", 8.00);
        Product p2 = new Product(2, "mele", "Boys", 9.00);
        Product p3 = new Product(3, "libro2", "Books", 180.00);
        Product p4 = new Product(4, "pannolini", "Baby", 34.00);
        Product p5 = new Product(5, "libro2", "Books", 120.00);
        Product p6 = new Product(6, "pannolini2", "Baby", 14.00);
        Product p7 = new Product(2, "mutande", "Boys", 19.55);

        List<Product> productList = new ArrayList<>();
        productList.add(p1); productList.add(p2); productList.add(p3); productList.add(p4); productList.add(p5); productList.add(p6);productList.add(p7);

        List<Product> babyList = new ArrayList<>();
        babyList.add(p4); babyList.add(p6);

        Customer c1 = new Customer(1, "luca", 1);
        Customer c2 = new Customer(2, "marco", 2);
        Customer c3 = new Customer(3, "luigi", 1);
        Customer c4 = new Customer(4, "marta", 2);
        Customer c5 = new Customer(5, "gina", 3);

        Order o1 = new Order(1, "in consegna", LocalDate.of(2021, 2, 1), LocalDate.now(), productList, c1);
        Order o2 = new Order(2, "spedito", LocalDate.of(2024, 1, 3), LocalDate.now(), babyList, c2);
        Order o3 = new Order(3, "in lavorazione", LocalDate.of(2020, 2, 10), LocalDate.now(), productList, c3);
        Order o4 = new Order(4, "spedito", LocalDate.of(2021, 2, 10), LocalDate.now(), productList, c4);
        Order o5 = new Order(5, "consegnato", LocalDate.of(2021, 4, 1), LocalDate.now(), babyList, c5);

        List<Order> orderList = new ArrayList<>();
        orderList.add(o1); orderList.add(o2); orderList.add(o3); orderList.add(o4); orderList.add(o5);

        //es1
        List<Product> listaLibriCostosi = productList.stream().filter(product -> product.getPrice() > 100 && product.getCategory().equals("Books")).toList();
        // System.out.println(listaLibriCostosi);

        //es2
        List<Order> listaOrdiniBaby = orderList.stream().filter(order -> order.getProducts().equals(babyList)).toList();
        //System.out.println(listaOrdiniBaby);

        //es3
        // List<Product> listaBoys = productList.stream().filter(product -> product.getCategory().equals("Boys")).toList();
        List<Double> listaBoys = productList.stream().filter(product -> product.getCategory().equals("Boys")).map(product -> product.getPrice()-product.getPrice()*0.10).toList();
        //System.out.println(listaBoys);

        //es4
        LocalDate startDate = LocalDate.of(2021, 2, 1);
        LocalDate endDate = LocalDate.of(2021, 4, 1);
        List<Order> listaOrd = orderList.stream().filter(order -> order.getOrderDate().datesUntil(LocalDate.of(2021,2,1), LocalDate.of(2021,4,1))).toList();
        System.out.println(listaOrd);
    }
}