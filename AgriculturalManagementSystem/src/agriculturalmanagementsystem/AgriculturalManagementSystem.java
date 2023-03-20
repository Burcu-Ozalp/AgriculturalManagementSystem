/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agriculturalmanagementsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AgriculturalManagementSystem {

    private static Supplier s1 = new Supplier("ArazMeyve", 1000);
    private static Supplier s2 = new Supplier("AylarTarim", 1500);
    private static Supplier s3 = new Supplier("HasanBey", 200);
    private static Supplier s4 = new Supplier("ZehraCiftci", 1250);

    private static Store store1 = new Store("Migros", 1000, 12);
    private static Store store2 = new Store("File", 1200, 10);

    private static Crop c1 = new Fruit("RedApple", "fruit", 45, "winter", "sweet", 3, 1133);
    private static Crop c2 = new Fruit("Orange", "fruit", 50, "autumn", "sour", 4, 5967);
    private static Crop c3 = new Fruit("Kiwi", "fruit", 10, "autumn", "sour", 10, 1133);
    private static Crop c4 = new Vegetable("Parsley", "vegetable", 25, "Samsun", 1429);
    private static Crop c5 = new Vegetable("Mint", "vegetable", 15, "Adana", 1429);
    private static Crop c6 = new Fruit("GreenApple", "fruit", 25, "winter", "sweet", 6, 1133);
    private static Crop c7 = new Fruit("Orange", "fruit", 20, "autumn", "sour", 4, 1322);
    private static Crop c8 = new Fruit("GreenApple", "fruit", 5, "winter", "sweet", 6, 5343);
    private static Crop c9 = new Vegetable("GreenBeans", "vegetable", 22, "Bursa", 1322);
    private static Crop c10 = new Fruit("Banana", "fruit", 63, "summer", "sweet", 12, 5343);

    private static Scanner input = new Scanner(System.in);

    public static ArrayList<Supplier> suppliers;
    public static ArrayList<Store> stores;

    public static void main(String[] args) throws FileNotFoundException {

        File supplierfile = new File("Suppliers.txt");
        File storefile = new File("Stores.txt");
        File cropfile = new File("Crops.txt");

        Scanner input = new Scanner(System.in);
        suppliers = new ArrayList<>();
        stores = new ArrayList<>();

        suppliers.add(s1);
        suppliers.add(s2);
        suppliers.add(s3);
        suppliers.add(s4);

        stores.add(store1);
        stores.add(store2);

        boolean open = true;
        while (open) {

            PrintWriter supplierFile = new PrintWriter(supplierfile);
            supplierFile.println(s1);
            supplierFile.println(s2);
            supplierFile.println(s3);
            supplierFile.println(s4);
            supplierFile.close();

            PrintWriter storeFile = new PrintWriter(storefile);
            storeFile.println(store1);
            storeFile.println(store2);
            storeFile.close();

            PrintWriter cropFile = new PrintWriter(cropfile);
            cropFile.println(c1);
            cropFile.println(c2);
            cropFile.println(c3);
            cropFile.println(c4);
            cropFile.println(c5);
            cropFile.println(c6);
            cropFile.println(c7);
            cropFile.println(c8);
            cropFile.println(c9);
            cropFile.println(c10);
            cropFile.close();

            String menu = "1) Display all suppliers \n2) Display all store\n3) Buy a fruit crop\n4) Sell a fruit crop \n5) Remove a fruit from a store\n6) Remove a crop from a supplier\n7) Add crop\n8) Show remaining budget\n9) Show remaining capacity\n0) Quit";
            System.out.println(menu);
            System.out.println("Select a number between 0 to 9");
            int number = input.nextInt();

            switch (number) {
                case 1:
                    displayAllSuppliers();
                    break;
                case 2:
                    displayAllStores();
                    break;
                case 3:
                    System.out.println("Write a number between 1-10 to choose your crop object");
                    int choose = input.nextInt();
                    if (choose == 1) {
                        buyFruit(c1);
                    } else if (choose == 2) {
                        buyFruit(c2);
                    } else if (choose == 3) {
                        buyFruit(c3);
                    } else if (choose == 4) {
                        buyFruit(c4);
                    } else if (choose == 5) {
                        buyFruit(c5);
                    } else if (choose == 6) {
                        buyFruit(c6);
                    } else if (choose == 7) {
                        buyFruit(c7);
                    } else if (choose == 8) {
                        buyFruit(c8);
                    } else if (choose == 9) {
                        buyFruit(c9);
                    } else if (choose == 10) {
                        buyFruit(c10);
                    } else {
                        System.out.println("Number is out of range");
                    }
                    break;
                case 4:
                    System.out.println("Write a number between 1-10 to choose your crop object");
                    int chosen = input.nextInt();
                    if (chosen == 1) {
                        sellFruit(c1);
                    } else if (chosen == 2) {
                        sellFruit(c2);
                    } else if (chosen == 3) {
                        sellFruit(c3);
                    } else if (chosen == 4) {
                        sellFruit(c4);
                    } else if (chosen == 5) {
                        sellFruit(c5);
                    } else if (chosen == 6) {
                        sellFruit(c6);
                    } else if (chosen == 7) {
                        sellFruit(c7);
                    } else if (chosen == 8) {
                        sellFruit(c8);
                    } else if (chosen == 9) {
                        sellFruit(c9);
                    } else if (chosen == 10) {
                        sellFruit(c10);
                    } else {
                        System.out.println("Number is out of range");
                    }
                    break;
                case 5:
                    removeFruit(store1, c1);
                    break;
                case 6:
                    removeCrop(s3, c6);
                    break;
                case 7:
                    addCrop(c3, store2, s3);
                    break;
                case 8:
                    System.out.println("Remaining budget is ");
                    budget();
                    break;
                case 9:
                    System.out.println("Remaining capacity is ");
                    remainingCapacity();
                    break;
                case 0:
                    System.out.println("You quitted.");
                    open = false;
                    break;
                default:
                    System.out.println("Number is out of range");

            }
        }

        if (!supplierfile.exists()) {
            System.out.println("File does not exist");
            System.exit(1);
        }
        if (!storefile.exists()) {
            System.out.println("File does not exist");
            System.exit(1);
        }
        if (!cropfile.exists()) {
            System.out.println("File does not exist");
            System.exit(1);
        }
    }

    public static void displayAllSuppliers() {
        for (int i = 0; i < suppliers.size(); i++) {
            System.out.println(suppliers.get(i).toString());
            suppliers.get(i).howToStore();

        }
    }

    public static void displayAllStores() {
        for (int i = 0; i < stores.size(); i++) {
            System.out.println(stores.get(i).toString());
            stores.get(i).howToStore();

        }
    }

    public static void buyFruit(Crop c) {
        if (c instanceof Fruit) {
            Fruit f = (Fruit) c;
            try {
                s1.buyCrop(f);
                System.out.println("Crop is bought.");
            } catch (SupplierHasNotEnoughMoneyException ex) {
                System.out.println("Supplier has not enough money.");
            } catch (FruitNotAvailableException ex) {
                System.out.println("Fruit not available.");
            }
            try {
                store1.importCrop(f);
                System.out.println("Crop is added.");
            } catch (CapacityNotEnoughException ex) {
                System.out.println("Capacity not enough.");
            }
            try {
                store2.exportCrop(f);
                System.out.println("Crop is exported.");

            } catch (FruitNotFoundException ex) {
                System.out.println("Fruit not found.");
            }
        }
    }

    public static void sellFruit(Crop c) {
        if (c instanceof Fruit) {
            Fruit f = (Fruit) c;

            try {
                s1.sellCrop(c);
                System.out.println("Crop is sold.");
            } catch (FruitNotFoundException ex) {
                System.out.println("Fruit not found.");
            }

            try {
                store1.importCrop(f);
                System.out.println("Crop is added");
            } catch (CapacityNotEnoughException ex) {
                System.out.println("Capacity not enough.");
            }

        }
    }

    public static void removeFruit(Store s, Crop c) {
        try {
            if (c instanceof Fruit) {
                Fruit f = (Fruit) c;
                s.exportCrop(f);
                System.out.println("Fruit is removed.");
            }
        } catch (FruitNotFoundException ex) {
            System.out.println("Fruit not found.");
        }
    }

    public static void removeCrop(Supplier s, Crop c) {
        try {
            s.sellCrop(c);
            System.out.println("Crop is removed from a supplier");
        } catch (FruitNotFoundException ex) {
            System.out.println("Fruit not found.");
        }
    }

    public static void addCrop(Crop c, Store store, Supplier supplier) {
        System.out.println("Write a number to add crop which place. \n 1: Store \n 2: Supplier");
        int num = input.nextInt();
        if (c instanceof Fruit) {
            Fruit f = (Fruit) c;
            if (num == 1) {
                try {
                    store.importCrop(f);
                    System.out.println("New crop added");
                } catch (CapacityNotEnoughException ex) {
                    System.out.println("Capacity not enough");
                }
            }
        } else if (num == 2) {
            try {
                supplier.buyCrop(c);
                System.out.println("New crop added.");
            } catch (SupplierHasNotEnoughMoneyException ex) {
                System.out.println("Supplier has not enough money.");
            } catch (FruitNotAvailableException ex) {
                System.out.println("Fruit not available.");;
            }
        } else {
            System.out.println("Number is not valid");
        }
    }

    public static void budget() {
        for (int i = 0; i < suppliers.size(); i++) {
            System.out.println(suppliers.get(i).getBudget());
        }
    }

    public static void remainingCapacity() {
        for (int i = 0; i < stores.size(); i++) {
            System.out.println(stores.get(i).availableCapacity());
        }
    }
}

