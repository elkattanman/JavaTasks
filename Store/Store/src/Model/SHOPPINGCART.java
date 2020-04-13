package Model;

import java.util.ArrayList;


public class SHOPPINGCART {
    
    private ArrayList<ORDEREDITEM> ordered_list;

    public SHOPPINGCART() {
        ordered_list = new ArrayList<>();
    }

    public SHOPPINGCART(ArrayList<ORDEREDITEM> ordered_list) {
        this.ordered_list = ordered_list;
    }

    public ArrayList<ORDEREDITEM> getOrdered_list() {
        return ordered_list;
    }

    public void setOrdered_list(ArrayList<ORDEREDITEM> ordered_list) {
        this.ordered_list = ordered_list;
    }

    public boolean addOrder(ORDEREDITEM e) {
        return ordered_list.add(e);
    }
    
    
    
}
