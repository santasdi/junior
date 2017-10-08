package ru.job4j.application.tracker;

import ru.job4j.application.models.Item;
import java.util.Arrays;

/**
 * Created by Артем on 07.10.2017.
 */
public class MenuTracker {
    /**
     * array of actions.
     */
    private UserAction[] action = new UserAction[7];
    /**
     * input object.
     */
    private Input input;
    /**
     * tracker object.
     */
    private Tracker tracker;

    /**
     * Constructor.
     * @param input is input object.
     * @param tracker  is tracker object.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * initialize menu.
     */
    public void fillActions() {
        this.action[0] = new AddItem();
        this.action[1] = new ShowItems();
        this.action[2] = new EditItem();
        this.action[3] = new DeleteItem();
        this.action[4] = new FindById();
        this.action[5] = new FindByName();
        this.action[6] = new Exit();
    }

    /**
     * Show all actions.
     */
    public void show() {
        for (UserAction action : this.action) {
            System.out.println(action.info());
        }
    }

    /**
     * Select action by choosing key.
     * @param key is key of action.
     */
    public void select(int key) {
        this.action[key].execute(this.input, this.tracker);
    }

    /**
     * Class about adding action.
     */
    private class AddItem implements UserAction {
        /**
         * Key of action.
         * @return
         */
        @Override
        public int key() {
            return 0;
        }

        /**
         * Execution of action by tracker actions.
         * @param input is object input
         * @param tracker is object tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name :");
            String desc = input.ask("Enter description :");
            tracker.add(new Item(name, desc, 11));
        }

        /**
         * Info about action.
         * @return
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new item");
        }
    }

    /**
     * Class about showing items action.
     */
    private class ShowItems implements UserAction {
        /**
         * Key of action.
         * @return
         */
        @Override
        public int key() {
            return 1;
        }
        /**
         * Execution of action by tracker actions.
         * @param input is object input
         * @param tracker is object tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(Arrays.toString(tracker.findAll()));
        }
        /**
         * Info about action.
         * @return
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    /**
     * Class about editing items action.
     */
    private static class EditItem implements UserAction {

        /**
         * Key for action.
         *
         * @return key
         */
        @Override
        public int key() {
            return 2;
        }

        /**
         * Execution of action.
         *
         * @param input   is object input
         * @param tracker is object tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter id :");
            tracker.update(id, tracker.findById(id));
        }

        /**
         * Information about action.
         *
         * @return string with information
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }

    /**
     * Class about delete action.
     */
    private class DeleteItem implements UserAction {

        /**
         * Key for action.
         *
         * @return key
         */
        @Override
        public int key() {
            return 3;
        }

        /**
         * Execution of program.
         *
         * @param input   is object input
         * @param tracker is object tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter id :");
            tracker.delete(tracker.findById(id));
        }

        /**
         * Information about action.
         *
         * @return string with information
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    /**
     * Class about finding by id action.
     */
    private class FindById implements UserAction {
        /**
         * Key for action.
         *
         * @return key
         */
        @Override
        public int key() {
            return 4;
        }

        /**
         * Execution of program.
         *
         * @param input   is object input
         * @param tracker is object tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter id :");
            Item item = tracker.findById(id);
            System.out.println(item);
        }

        /**
         * Information about action.
         *
         * @return string with information
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id");
        }
    }

    /**
     * Class about finding by name action.
     */
    private class FindByName implements UserAction {

        /**
         * Key for action.
         *
         * @return key
         */
        @Override
        public int key() {
            return 5;
        }

        /**
         * Execution of program.
         *
         * @param input   is object input
         * @param tracker is object tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name :");
            Item[] item = tracker.findByName(name);
            System.out.println(Arrays.toString(item));
        }

        /**
         * Information about action.
         *
         * @return string with information
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }

    /**
     * Class about exit action.
     */
    private class Exit implements UserAction {

        /**
         * Key for action.
         *
         * @return key
         */
        @Override
        public int key() {
            return 6;
        }

        /**
         * Execution of program.
         *
         * @param input   is object input
         * @param tracker is object tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Good bye! Have a nice day.");
        }

        /**
         * Information about action.
         * @return string with information
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit");
        }
    }
}