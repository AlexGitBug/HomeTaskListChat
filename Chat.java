package CollectionLesson.HomeTask.List.Chat_Task;

import java.util.List;

/**
 * адание 1
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 *
 * Задача:
 *
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 *
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей, а если это количество совпадает, то по названию в алфавитном порядке.
 *
 * - Также предоставить сортировку чатов по названию по умолчанию
 */
class Chat implements Comparable<Chat>{

    private String name;
    private int quantity;

    private List<User> list;

    public Chat() {
    }

    public Chat(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Chat(String name, List<User> list) {
        this.name = name;
        this.list = list;
    }

    public String toString() {
        return getName() + "  " + getQuantity();
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }


    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    @Override
    public int compareTo(Chat o) {
        return this.name.compareTo(o.name);
    }
}