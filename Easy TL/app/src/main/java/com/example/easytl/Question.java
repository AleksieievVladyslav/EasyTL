package com.example.easytl;

public class Question {

    private Query currentQuery;

    public Question(int topicNumber, int questionNumber) {
        switch (topicNumber) {
            case 0:
                currentQuery = questionsTopic1[questionNumber];
                break;
        }
    }

    public String getQuestionStatement() {
        return currentQuery.query;
    }

    public String getAnswer(int index) {
        return currentQuery.answer[index];
    }

    public int getAnswersNumber() {
        return currentQuery.answersNum;
    }

    public int indexOfCorrectAnswer() {
        return currentQuery.indexOfCorrectAnswer;
    }

    private static class Query {
        String query;
        int answersNum;
        String answer[];
        int indexOfCorrectAnswer;

        protected Query(String query, int answersNum, String answer[], int indexOfCorrectAnswer) {
            this.query = query;
            this.answersNum = answersNum;
            this.answer = answer;
            this.indexOfCorrectAnswer = indexOfCorrectAnswer;
        }
    }

    private static Query[] questionsTopic1 = new Query[]{

            new Query("Въезжая на дорогу по полосе разгона, водитель должен:", 2,
                    new String[]{"Вливаться в транспортный поток, уступая дорогу транспортным " +
                            "средствам, движущимся по этой дороге.", "Вливаться в транспортный поток, " +
                            "другие водители, увидев его, должны обязательно уступить ему дорогу."},
                    0),

            new Query("Разрешено ли в данном месте опасного поворота движение задним ходом?",
                    2, new String[]{"Разрешено при условии обеспечения безопасности " +
                    "дорожного движения.", " Запрещено"}, 0)

    };
}