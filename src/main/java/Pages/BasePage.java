package Pages;

//шаблон. вказуючи конкретний клас, ми даємо знати що працюємо саме з цим класом.
    public class BasePage <T extends BasePage> {
        public T chooseMenu(){
            return (T) this;
        }
    }
