package programmers;

import java.util.Arrays;

public class PhoneBook {
    public boolean solution(String[] phone_book) {

        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                return false;
            }
        }


//        int temp=phone_book[0].length();
//        String theAnswer=phone_book[0];
//        
//        for(String key:phone_book){
//            if(temp>key.length()){
//                temp=key.length();
//                theAnswer=key;
//            }
//        }
//
//
//        for(String key:phone_book){
//            if(!key.equals(theAnswer)){
//                if(theAnswer.equals(key.substring(0,temp))){
//                    answer=false;
//                    break;
//                }
//            }
//
//        }
//        
        return answer;
    }
}
