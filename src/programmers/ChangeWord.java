package programmers;

public class ChangeWord {

    int MIN = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        int a = Integer.MAX_VALUE;


        search(begin, target, words, 0);

        if (a == MIN) {
            return 0;
        }
        return MIN;
    }

    public void search(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            MIN = Integer.min(MIN, cnt);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            int wordCnt = 0;
            String str = words[i];
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == str.charAt(j)) {
                    wordCnt++;
                }
            }
            if (wordCnt == begin.length() - 1) {
                words[i] = "";
                for (int j = 0; j < begin.length(); j++) {
                    words[i] += " ";
                }

                search(str, target, words, cnt + 1);
                words[i] = str;
            }
        }


    }
}
