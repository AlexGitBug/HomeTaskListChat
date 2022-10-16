package CollectionLesson.HomeTask.List.Chat_Task;
/**
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 * Задача:
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * а если это количество совпадает, то по названию в алфавитном порядке.
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */

import java.util.*;

public class ListChatRunner {
    public static void main(String[] args) {
        List<Chat> list = new ArrayList<>(Arrays.asList(
                new Chat("F_Chat_0", 450),
                new Chat("D_Chat_1", 500),
                new Chat("M_Chat_2", 1080),
                new Chat("A_Сhat_3", 1080),
                new Chat("B_Сhat_4", 1050),
                new Chat("C_Chat_5", 1121)));

        list.sort(Comparator.comparing(Chat::getName));
        System.out.println("Сортировка всего списка чатов по умолчанию (по названию): " + list);

        findAbove1000(list);
        System.out.println("Удаление из списка через итератор: " + list);


        list.sort(new ChatComparatorByUsers().thenComparing(new chatComparatorByName()));
        System.out.println("Сортировка по количеству пользователей и по алфафиту: " + list);


        Collections.sort(list);
        System.out.println("Сортировка по умолчанию по названию через Comparable больше 1000 пользователей: " + list);







    }
    public static void findAbove1000(List<Chat> list) {
        ListIterator<Chat> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Chat nextValue = listIterator.next();
            if (nextValue.getQuantity() < 1000) {
                listIterator.remove();
            }
        }
    }

    public static class chatComparatorByName implements Comparator<Chat> {
        public int compare(Chat o1, Chat o2) {
            return o1.getName().compareTo(o2.getName());

        }
    }
    public static class ChatComparatorByUsers implements Comparator<Chat> {
        @Override
        public int compare(Chat o1, Chat o2) {
            return o2.getQuantity() - o1.getQuantity();
        }
    }
}





