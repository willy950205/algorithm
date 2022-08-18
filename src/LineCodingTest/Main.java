package LineCodingTest;

public class Main {

    public static void main(String[] args) {
        LevelThree a = new LevelThree();
        String program = "bank";
        String flag_rules[] = {"-send STRING", "-a ALIAS -amount", "-amount NUMBERS"};
        String commands[] = {"bank -send abc -amount 500 200 -a 400", "bank -send abc -a hey"};
        a.solution(program, flag_rules, commands);


    }

}
