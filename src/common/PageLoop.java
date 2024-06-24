package common;

import java.util.Scanner;

public class PageLoop {
    AppView view;

    public PageLoop(AppView view) {
        this.view = view;
    }


    int getChildrenSize() {
        return view.children.size();
    }

    int getOptionalsSize() {
        int optionalSize = 0;
        if (view.hasNextPage)  optionalSize++;
        optionalSize += view.availableComparators.size();
        return optionalSize;
    }
    public void run() {
        while (true) {
            view.action();
            displayChildren();
            final int fullSize = getChildrenSize() + getOptionalsSize() + 1;
            Scanner in = new Scanner(System.in);
            int value = in.nextInt();
            if (value < 0 || value > fullSize) {
                System.out.println("Неверное значение страницы");
            } else if (value == fullSize) {
                break;
            } else if (value < getChildrenSize()) {
                AppView selectedView = view.children.get(value - 1);
                new PageLoop(selectedView).run();
            } else {
                if (value == getChildrenSize() + 1 && view.hasNextPage) {
                    view.nowPage++;
                } else if (value == getChildrenSize() + 1) {
                    view.displayCart();
                } else {
                    int index = value - getChildrenSize() - 2;
                    if (index >= 0 && index < view.availableComparators.size()) {
                        view.selectedComparator = view.availableComparators.get(index);
                    }
                }
            }
        }
    }



    void displayChildren() {
        int index = 1;
        System.out.println(view.title);
        System.out.println("Выберите вариант ( от 1 до " + (getChildrenSize() +getOptionalsSize() +  1) + ")");
        for (int i = 0; i < getChildrenSize(); i++) {
            AppView _view = view.children.get(i);
            System.out.println(index + " " + _view.title);
            index++;
        }
        if (view.hasNextPage) {
            System.out.println(index + " " + "Следующая страница");
            index++;
        }

        for (int i = 0; i < view.availableComparators.size(); i++) {
            System.out.println(index + " " + view.availableComparators.get(i).name);
            index++;
        }


        System.out.println((getChildrenSize()+getOptionalsSize()+1)  + " Назад");
    }
}
