package kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class KakaoRecommendId {

    public String solution(String new_id) {

        String weird = "~!@#$%^&*()=+[{]}:?,<>/";
        boolean check = false;

        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        String temp = new_id.toLowerCase(Locale.ROOT);
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        // char [] list = temp.toCharArray();

        List<String> list = new ArrayList<>();
        for (char ch:temp.toCharArray()) {
            list.add(""+ch);
        }

        // 이 부분을 좀 고쳐봐
        for (int i = 0; i < list.size(); i++) {

            if(i != 0 && list.get(i-1) =="." && list.get(i-1) ==list.get(i)){
                list.remove(i);

            }

            if (weird.contains(String.valueOf( list.get(i))) ){
                list.remove(i);
            }
        }
        String lower ="";
        for (String alph : list) {
            lower+=alph;
        }

        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(lower.startsWith(".")){
            lower = lower.substring(1);
        }

        if(lower.endsWith(".")){
            lower = lower.substring(0, lower.length()-1);
        }

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(lower.isEmpty()){
            lower="a";
        }
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if(lower.length()>=16){
            lower = lower.substring(0, 15);
        }
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(lower.endsWith(".")){
            lower = lower.substring(1, lower.length()-1);
        }
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while(true){
            if(lower.length() <= 2){
                lower = lower + lower.charAt(lower.length()-1);
            }else{
                break;
            }
        }
        System.out.println(lower);
        return lower;
    }
}
