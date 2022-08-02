public interface Question {
    public void Ask();
}

/*

class Main {
    public static void main(String[] args) {

        String[] answer = {"1","2","3","4"};
        Questions a = new CloseQuestion("Cual es tu color favorito",answer);
        Questions b = new OpenQuestion("Cual es tu color favorito", "Rojo");
        List<Questions> questions = new ArrayList<Questions>();
        questions.add(a);
        questions.add(b);
        for(Questions quest:questions){
            quest.Ask();
        }
    }
}
 */