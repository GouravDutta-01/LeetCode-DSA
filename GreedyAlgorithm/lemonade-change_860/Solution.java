// Question Link : https://leetcode.com/problems/lemonade-change/

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countFive = 0;//count of $5 bills
        int countTen = 0;//count of $10 bills
        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5){
                countFive++;
            }
            else if(bills[i] == 10){
                countFive--;
                countTen++;
            }
            else if(countTen > 0){
                countTen--;
                countFive--;
            }
            else{
                countFive -= 3;
            }
            if(countFive < 0){
                return false;
            }
        }
        return true;    
    }
}