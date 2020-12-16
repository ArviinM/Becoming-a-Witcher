import java.util.LinkedList;
class Bag {
    LinkedList<String> bag = new LinkedList<>();

    String item;
    String hasItem;
    String [] needItems = {"forktail spinal fluid", "mantacore poison gland" , "albino bruxa tongue", "bryonia", "ribleaf", "mandrake root"};
    String [] brewItems = {"forktail spinal fluid", "mantacore poison gland"};

    public void addItem(String i){
        this.item = i;
        bag.add(i);
    }

    public void displayItems(){
        if(bag.isEmpty()){
            System.out.println("\nYour bag is empty.");
        } else if(!bag.isEmpty()){
            System.out.println("\nBag Items: " + bag);
        } else {
            System.out.println("Please try again!");
        }
    }

    public boolean hasItem(String i){
        this.hasItem = i;
        if(bag.contains(i)){
            return true;
        } else {
            return false;
        }
    }

    public boolean hasAllItems(){
        for(int i = 0; i < needItems.length; i++){
            if(!bag.contains(needItems[i]))
                return true;
        }
        return false;
    }

    public boolean hasAllBrewItems(){
        for(int i = 0; i < brewItems.length; i++){
            if(!bag.contains(brewItems[i]))
                return true;
        }
        return false;
    }

    public void removeAllItems(){
        bag.clear();
    }
}