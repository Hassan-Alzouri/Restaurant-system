
package Dashboard;

import java.util.ArrayList;

public class Arraylist {
    
   ArrayList<Integer> number1 = new ArrayList<>();
    ArrayList<Integer> number2 = new ArrayList<>();
    ArrayList<Integer> number3 = new ArrayList<>();
    ArrayList<Integer> number4 = new ArrayList<>();
    ArrayList<Integer> number5 = new ArrayList<>();
    ArrayList<Integer> number6 = new ArrayList<>();
    ArrayList<Integer> number7 = new ArrayList<>();
    ArrayList<Integer> number8 = new ArrayList<>();
    ArrayList<Integer> number9 = new ArrayList<>();
    ArrayList<Integer> number10 = new ArrayList<>();
    ArrayList<Integer> number11 = new ArrayList<>();
    ArrayList<Integer> number12 = new ArrayList<>();
    ArrayList<Integer> number13 = new ArrayList<>();
    ArrayList<Integer> number14 = new ArrayList<>();
    ArrayList<Integer> number15 = new ArrayList<>();

    // Boolean flags to track whether an item has been added or not
    static boolean Item1 = false;
    static boolean Item2 = false;
    static boolean Item3 = false;
    static boolean Item4 = false;
    static boolean Item5 = false;
    static boolean Item6 = false;
    static boolean Item7 = false;
    static boolean Item8 = false;
    static boolean Item9 = false;
    static boolean Item10 = false;
    static boolean Item11 = false;
    static boolean Item12 = false;
    static boolean Item13 = false;
    static boolean Item14 = false;
    static boolean Item15 = false;
    
    static int value1 =0;
    static int value2 =0;
    static int value3 =0;
    static int value4 =0;
    static int value5 =0;
    static int value6 =0;
    static int value7 =0;
    static int value8 =0;
    static int value9 =0;
    static int value10 =0;
    static int value11=0;
    static int value12 =0;
    static int value13 =0;
    static int value14 =0;
    static int value15 =0;
 
    

    public void TakeValueToTable(int quantity, int itemId) {
        // Add quantity to the appropriate ArrayList based on itemId
        switch (itemId) {
            case 1:
                number1.add(quantity);
                Item1 = true;
                break;
            case 2:
                number2.add(quantity);
                Item2 = true;
                break;
            case 3:
                number3.add(quantity);
                Item3 = true;
                break;
            case 4:
                number4.add(quantity);
                Item4 = true;
                break;
            case 5:
                number5.add(quantity);
                Item5 = true;
                break;
            case 6:
                number6.add(quantity);
                Item6 = true;
                break;
            case 7:
                number7.add(quantity);
                Item7 = true;
                break;
            case 8:
                number8.add(quantity);
                Item8 = true;
                break;
            case 9:
                number9.add(quantity);
                Item9 = true;
                break;
            case 10:
                number10.add(quantity);
                Item10 = true;
                break;
            case 11:
                number11.add(quantity);
                Item11 = true;
                break;
            case 12:
                number12.add(quantity);
                Item12 = true;
                break;
            case 13:
                number13.add(quantity);
                Item13 = true;
                break;
            case 14:
                number14.add(quantity);
                Item14 = true;
                break;
            case 15:
                number15.add(quantity);
                Item15 = true;
                break;
            default:
                System.out.println("Invalid item ID: " + itemId);
                break;
        }
    }
    
    public void addValueToTable(){
        DatabaseAccess databaseaccesson = new DatabaseAccess();
        if (Item1==true){
            /*for (int i = 0; i < number1.size(); i++) {
             value1 =  value1 + number1.get(i);
             
        }*/
            value1 =  value1 + number1.get(0);
            databaseaccesson.insertInvoiceItems(value1, 1);
            deleteAllValues(number1);
            Item1=false;
            value1=0;
            
        }
         if (Item2==true){
            /*for (int i = 0; i < number2.size(); i++) {
            value2 =  value2 +number2.get(i);
            

        }*/
            value2 =  value2 +number2.get(0);
            databaseaccesson.insertInvoiceItems(value2, 2);
            deleteAllValues(number2);
            Item2=false;
            value2=0;
        }
         if (Item3==true){
            
            for (int i = 0; i < number3.size(); i++) {
            value3 =  value3 + number3.get(i);
            

        }
            databaseaccesson.insertInvoiceItems(value3, 3);
            deleteAllValues(number3);
            Item3=false;
            value3=0;
        }
         if (Item4==true){
            
            for (int i = 0; i < number4.size(); i++) {
            value4 =  value4 +  number4.get(i);
            

        }
            databaseaccesson.insertInvoiceItems(value4, 4);
            deleteAllValues(number4);
            Item4=false;
            value4=0;
        }
         if (Item5==true){
            
            for (int i = 0; i < number5.size(); i++) {
            value5 =  value5 + number5.get(i);
            

        }
            databaseaccesson.insertInvoiceItems(value5, 5);
            deleteAllValues(number5);
            Item5=false;
            value5=0;
        }
         if (Item6==true){
            
            for (int i = 0; i < number6.size(); i++) {
            value6 =  value6 + number6.get(i);
            

        }
            databaseaccesson.insertInvoiceItems(value6, 6);
            deleteAllValues(number6);
            Item6=false;
             value6=0;
        }
         if (Item7==true){
            
            for (int i = 0; i < number7.size(); i++) {
            value7 =  value7 + number7.get(i);
            

        }
            databaseaccesson.insertInvoiceItems(value7, 7);
            deleteAllValues(number7);
            Item7=false;
            value7=0;
        }
         if (Item8==true){
            
           for (int i = 0; i < number8.size(); i++) {
            value8 =  value8 + number8.get(i);
            

        }
           databaseaccesson.insertInvoiceItems(value8, 8);
            deleteAllValues(number8);
            Item8=false;
            value8=0;
        }
         if (Item9==true){
            
            for (int i = 0; i < number9.size(); i++) {
            value9 =  value9 + number9.get(i);
            

        }
            databaseaccesson.insertInvoiceItems(value9, 9);
            deleteAllValues(number9);
            Item9=false;
            value9=0;
        }
         if (Item10==true){
            
            for (int i = 0; i < number10.size(); i++) {
            value10 =  value10 + number10.get(i);
            

        }
            databaseaccesson.insertInvoiceItems(value10, 10);
            deleteAllValues(number10);
            Item10=false;
            value10=0;
        }
         if (Item11==true){
            
            for (int i = 0; i < number11.size(); i++) {
            value11 =  value11 + number11.get(i);
            

        }
            databaseaccesson.insertInvoiceItems(value11, 11);
            deleteAllValues(number11);
            Item11=false;
            value11=0;
        }
         if (Item12==true){
            
            for (int i = 0; i < number12.size(); i++) {
            value12 =  value12 + number12.get(i);
            

        }
            databaseaccesson.insertInvoiceItems(value12, 12);
            deleteAllValues(number12);
            Item12=false;
            value12=0;
        }
         if (Item13==true){
            
           for (int i = 0; i < number13.size(); i++) {
            value13 =  value13 + number13.get(i);
            

        }
           databaseaccesson.insertInvoiceItems(value13, 13);
            deleteAllValues(number13);
            Item13=false;
            value13=0;
        }
         if (Item14==true){
            
            for (int i = 0; i < number14.size(); i++) {
            value14 =  value14 + number14.get(i);
            

        }
            databaseaccesson.insertInvoiceItems(value14, 14);
            deleteAllValues(number14);
            Item14=false;
            value14=0;
        }
         if  (Item15==true){
            
            for (int i = 0; i < number15.size(); i++) {
            value15 =  value15 + number15.get(i);
            

        }
            databaseaccesson.insertInvoiceItems(value15, 15);
            deleteAllValues(number15);
            Item15=false;
            value15=0;
        }
       
    
}
public static void deleteAllValues(ArrayList<?> list) {
        list.clear();
    }
    
}
