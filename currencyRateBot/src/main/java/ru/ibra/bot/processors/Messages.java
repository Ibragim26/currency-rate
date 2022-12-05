package ru.ibra.bot.processors;

public enum Messages {
    DATA_FORMAT_MESSAGE("Ожидаемый формат даты:\n" + "dd-MM-yyyy, Пример: 22-01-2021"),
    EXPECTED_FORMAT_MESSAGE("Возможные команды ( не нужен): \n"+
                    " Курс на дату: CBR USD dd-MM-yyyy\n"+
                    "Курс ЦБ на дату: EUR dd-MM-yyyy\n"+
                    "Курс ЦБ на сегодня: USD");

    private final String text;

    Messages(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}