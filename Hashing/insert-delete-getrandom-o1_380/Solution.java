// Question Link : https://leetcode.com/problems/insert-delete-getrandom-o1/description/

class RandomizedSet {
    ArrayList<Integer> list = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>(); //key = element, value = index in list
    public RandomizedSet() {    
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val); 
        return true;  
    }
    
    public boolean remove(int val) {
        if(list.isEmpty() || !map.containsKey(val)){
            return false;
        }
        if(map.get(val) == list.size()-1){
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }
        else{
            int removeIndex = map.get(val);
            int lastElement = list.get(list.size()-1);
            //swapping the last element with the required element so that the required element goes to the end of the list so that we can remove from the map in O(1) T.C
            list.set(removeIndex, lastElement);
            map.put(lastElement, removeIndex);
            list.set(list.size()-1, val);
            map.put(val, list.size()-1);
            map.remove(val); //deleting required element from map
            list.remove(list.size()-1); //deleting required element from list
            map.put(lastElement, removeIndex); //updating the index value of the swapped previously last element
            return true;
        }   
    }
    
    public int getRandom() {
        return list.get((int)(Math.random()*list.size())); //returns a element at a random index between 0 to list.size()-1 in the list     
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */