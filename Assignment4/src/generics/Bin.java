package generics;

import java.util.*;

public class Bin<T extends Part> {
    private ArrayList<T> contents = new ArrayList<>();
    // the ArrayList should be parameterized

    public void add(T part){
        contents.add(part);
    } // should take an argument
    public T get(int index){
        return contents.get(index);
    } // should have a return type
    public int size(){
        return contents.size();
    }

    public double totalMass(){
        double total = 0.0;
        for(int i = 0; i < contents.size(); i++){
            total += contents.get(i).massGrams();
        }
        return total;
    }          // sum of massGrams() over contents
    public T heaviest(){
        if(contents.isEmpty()) return null;

        double max = 0.0;
        int index = 0;
        for(int i = 0; i < contents.size(); i++){
            if(max < contents.get(i).massGrams()){
                max = contents.get(i).massGrams();
                index = i;
            }
        }
        return contents.get(index);
    } // needs a return type, null if empty
    public boolean hasSku(String sku){
        for(int i = 0; i < contents.size(); i++){
            if(contents.get(i).sku().equals(sku)){
                return true;
            }
        }
        return false;
    }  // case-sensitive exact match

    @Override public String toString(){
        String str = "Bin[";
        for(int i = 0; i < contents.size(); i++){
            str += contents.get(i).toString();
            if(i != contents.size()-1){
                str += ", ";
            }
        }
        return str + "]";
    } // e.g. Bin[B-10(12.5g), B-10(12.5g)]
}

