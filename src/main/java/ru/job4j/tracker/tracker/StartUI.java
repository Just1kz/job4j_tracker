package ru.job4j.tracker.tracker;

public class StartUI {

     private final Output out;

     public StartUI(Output out) {
         this.out = out;
     }

     public void init(Input input, Store tracker, UserAction[] actions) {
         boolean run = true;
         while (run) {
             this.showMenu(actions);
             int select = input.askInt("Select: ");
             if (select < 0 || select >= actions.length) {
                 out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                 continue;
             }
             UserAction action = actions[select];
             run = action.execute(input, tracker);
         }
     }

     private void showMenu(UserAction[] actions) {
         out.println("Menu.");
         for (int index = 0; index < actions.length; index++) {
             out.println(index + ". " + actions[index].name());
         }
     }

     public static void main(String[] args) {
         Output output = new ConsoleOutput();
         Input input = new ValidateInput(output, new ConsoleInput());
         Store tracker = new SqlTracker();
         UserAction[] actions = {
                 new CreateAction(output),
                 new ShowAllAction(),
                 new FindNameAction(output),
                 new FindIDAction(output),
                 new EditAction(output),
                 new DeleteAction(output),
                 new ExitAction()
         };
         new StartUI(output).init(input, tracker, actions);
     }
}
