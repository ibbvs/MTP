// 1. Реализовать класс обертку StringBuilder с поддержкой undo. Делегировать стандартные методы стандартному StringBUilder. Паттерн «Команда»


import java.util.Stack;
class DEMKAStringBuilder {
    private interface Action {
        void undo();
    }

    private class DeleteAction implements Action {
        private int size;

        public DeleteAction(int size) {
            this.size = size;
        }

        public void undo() {
            stringBuilder.delete(
                    stringBuilder.length() - size, stringBuilder.length());
        }
    }

    private StringBuilder stringBuilder; // делегат

    private Stack<Action> actions = new Stack<Action>();

    // конструктор
    public DEMKAStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    public DEMKAStringBuilder append(String str) {
        stringBuilder.append(str);

        Action action = new Action() {
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length() - str.length() - 1,
                        stringBuilder.length());
            }
        };
        actions.add(action);
        return this;
    }

    public void undo() {
        if (!actions.isEmpty()) {
            actions.pop().undo();
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}




public class Main {
    public static void main(String[] strings) {
        DEMKAStringBuilder thisString = new DEMKAStringBuilder();
        thisString.append("РАЗ РАЗ РАЗ ");
        thisString.append("ДВА ДВА ДВА ");
        thisString.append("ТРИ ТРИ ТРИ ");

        System.out.println("Строка:"+ thisString.toString());
        thisString.undo();
        thisString.undo();
        System.out.println("После отмены: "+ thisString.toString());
    }
}