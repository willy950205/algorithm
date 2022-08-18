package programmers;

public class KakaoBlindStringCompression {
    public int solution(String s) {
        int answer = s.length();


        int len = s.length()/2;
        // 압축할 문자열의 길이
       for (int i = 1; i <= len; i++) {
           String lastword = s.substring(0, i);
           StringBuilder sb = new StringBuilder();
           int dupleCnt = 1;
           for (int j = i; j < s.length(); j=j+i) {

               int nextLastIndex = Math.min(j + i, s.length());

               String nowWord = findNowStr(s,j,nextLastIndex);

               if(nowWord.equals(lastword)){
                   dupleCnt++;
               }else{
                   appendToStringBuilder(sb, dupleCnt, lastword);
                   dupleCnt = 1;
                   lastword = nowWord;

               }

           }
           appendToStringBuilder(sb, dupleCnt, lastword);
           answer = Integer.min(answer, sb.length());

       }
       System.out.println(answer);
        return answer;
    }

    String findNowStr(String s, int index, int nextIndex){

        String result = s.substring(index, nextIndex);

        return result;
    }

    void appendToStringBuilder(StringBuilder stringBuilder, int count, String str) {
        if(count > 1) {
            stringBuilder.append(count);
        }
        stringBuilder.append(str);
    }



}
