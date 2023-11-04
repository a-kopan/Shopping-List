import java.util.ArrayList;
import java.util.Scanner;
class product {
    private String name, type;
    private Integer quantity;
    private double wage;
    //constructors
    product() {
        this.name = "Undefined";
        this.quantity = 0;
        this.type = "Undefined";
        this.wage = 0.0;
    }
    product(String name, Integer quantity, double wage, String type) {
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.wage = wage;
    }
    //getters and setters
    public String getName() {
        return name;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setName(String word) {
        this.name = word;
    }
    public void setQuantity(Integer number) {
        this.quantity = number;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getWage() {
        return wage;
    }
    public void setWage(double wage) {
        this.wage = wage;
    }
}
class list {
    private ArrayList<product> contents;
    //constructors
    list() {
        contents = new ArrayList<>(0);
    }
    list(product product) {
        contents = new ArrayList<>(0);
        contents.add(product);
    }
    public String getContents() {
        String chain = "";
        for(product x:this.contents) {
            chain+= x.getName()+" : "+x.getQuantity()+" : "+x.getWage()+" : "+x.getType()+"\n";
        }
        return chain;
    }
    public void addProduct(product product) {
        contents.add(product);
    }
    public void removeProduct(int space) {
        try { 
            contents.remove(space+1);
        } 
        catch(IndexOutOfBoundsException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    public void editProduct(Object object,int index) {
        index--;
        //if the data provided is a string, edit the name of the product
        if(object instanceof String) {
            contents.get(index).setName(object.toString());
        }
        //if the data provided is a Integer, edit the quantity of the product
        else if(object instanceof Integer) {
            contents.get(index).setQuantity((Integer) object);
        }
        //if the data provided is a double, edit the wage of the product
        else if(object instanceof Double) {
            contents.get(index).setWage((double) object);
        }
    }
}
class outputOptions {
    static String name, type;
    static Integer quantity, index;
    static double wage;
    static product product;
    static Scanner input = new Scanner(System.in);

    public static void addProduct(list list) {
        System.out.println("Provide the neccessary information for adding the product: ");
        System.out.println();
        System.out.print("Name: "); name = input.next();
        System.out.print("Quantity: "); quantity = input.nextInt();
        System.out.print("Wage: "); wage = input.nextDouble();
        System.out.print("Type: "); type = input.next();
        product = new product(name,quantity,wage,type);
        list.addProduct(product);
    }
    public static void removeProduct(list list) {
        System.out.println("Which product do you want to remove: ");
        index = input.nextInt()-1;
        list.removeProduct(index);
    }
    public static void editProduct() {

    }
}
public class shoppingList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer choice;

        product produkt = new product("Mleko",1,1.0,"Spożywcze");
        list lista = new list();
        lista.addProduct(produkt);
        while (true) {
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            System.out.println(lista.getContents());
            System.out.println("Please chose the operation: ");
            System.out.println("1. Add a product");
            System.out.println("2. Remove a product");
            System.out.println("3. Edit a product");
            choice = input.nextInt();

            switch(choice) {
                case 1:
                    outputOptions.addProduct(lista);
                    break;
                case 2:
                    outputOptions.removeProduct(lista);
                    break;
                case 3:
                    outputOptions.editProduct();
                    break;
                default:
                    System.out.println("Wrong input, try again.");
            }  
        }
    }
}