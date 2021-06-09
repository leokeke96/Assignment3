/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3;
  
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



/**
 *
 * @author Kevin Mombo
 */
public class Solution {
 ObjectInputStream input;
 
  public void openFile(){
        try{
            input = new ObjectInputStream( new FileInputStream( "stakeholder.ser" ) ); 
            System.out.println("*** ser file opened for reading ***");               
        }
        catch (IOException ioe){
            System.out.println("error opening ser file: " + ioe.getMessage());
            System.exit(1);
            
        }
    }
     public void closeFile(){
        try{
        input.close( ); 
        }
        catch (IOException ioe){            
            System.out.println("error closing ser file: " + ioe.getMessage());
            System.exit(1);
        }        
    }   
     
     class SortCustomer implements Comparator<Customer>{

        @Override
        public int compare(Customer a, Customer b) {
            return a.getStHolderId().compareTo(b.getStHolderId());
        }
    }

      
     public void readfromFile(){
         List <Object> customers = new ArrayList<Object>();
        List<Supplier> suppliers = new ArrayList<Supplier>();
        ObjectInputStream ois = null;

        try {
            FileInputStream fis = new FileInputStream("stakeholder.ser");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
            Object cg = null;


            do{

                cg = ois.readObject();
                if(cg != null){
                    customers.add(cg);
                }

                System.out.println(customers.get(0).toString());


            }while(cg  != null);




        }catch( FileNotFoundException er){

        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally{
            closeFile();
            System.out.println("*** file has been closed ***");               
        } 
     }       
     
     
       
  public static void main(String [] args) throws ClassNotFoundException {
   Solution s = new Solution();
   s.openFile();
   s.readfromFile();
   }
}
   
    
